package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.exception.DownloadSecurityException;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class ConnectTrial {
    public static final String TAG = "ConnectTrial";
    public boolean acceptRange;
    @NonNull
    public final BreakpointInfo info;
    @IntRange(from = -1)
    public long instanceLength;
    public int responseCode;
    @Nullable
    public String responseEtag;
    @Nullable
    public String responseFileType;
    @Nullable
    public String responseFilename;
    @NonNull
    public final DownloadTask task;
    public static final Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    public static final Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    @Nullable
    public String getResponseContentType() {
        return this.responseFileType;
    }

    @Nullable
    public String getResponseEtag() {
        return this.responseEtag;
    }

    @Nullable
    public String getResponseFilename() {
        return this.responseFilename;
    }

    public boolean isAcceptRange() {
        return this.acceptRange;
    }

    public boolean isChunked() {
        if (this.instanceLength == -1) {
            return true;
        }
        return false;
    }

    public boolean isEtagOverdue() {
        if (this.info.getEtag() != null && !this.info.getEtag().equals(this.responseEtag)) {
            return true;
        }
        return false;
    }

    public ConnectTrial(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    @Nullable
    public static String findContentType(DownloadConnection.Connected connected) {
        return connected.getResponseHeaderField(Util.CONTENT_TYPE);
    }

    @Nullable
    public static String findEtag(DownloadConnection.Connected connected) {
        return connected.getResponseHeaderField(Util.ETAG);
    }

    @Nullable
    public static String findFilename(DownloadConnection.Connected connected) throws IOException {
        return parseContentDisposition(connected.getResponseHeaderField("Content-Disposition"));
    }

    public static long findInstanceLength(DownloadConnection.Connected connected) {
        long parseContentRangeFoInstanceLength = parseContentRangeFoInstanceLength(connected.getResponseHeaderField("Content-Range"));
        if (parseContentRangeFoInstanceLength != -1) {
            return parseContentRangeFoInstanceLength;
        }
        if (!parseTransferEncoding(connected.getResponseHeaderField("Transfer-Encoding"))) {
            Util.w(TAG, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    public static boolean isAcceptRange(@NonNull DownloadConnection.Connected connected) throws IOException {
        if (connected.getResponseCode() == 206) {
            return true;
        }
        return "bytes".equals(connected.getResponseHeaderField(Util.ACCEPT_RANGES));
    }

    public static long parseContentRangeFoInstanceLength(@Nullable String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                Util.w(TAG, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean parseTransferEncoding(@Nullable String str) {
        if (str != null && str.equals("chunked")) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String parseContentDisposition(String str) throws IOException {
        String str2;
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
            if (matcher.find()) {
                str2 = matcher.group(1);
            } else {
                Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
                if (matcher2.find()) {
                    str2 = matcher2.group(1);
                } else {
                    str2 = null;
                }
            }
            if (str2 != null && str2.contains("../")) {
                throw new DownloadSecurityException("The filename [" + str2 + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return str2;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public void executeTrial() throws IOException {
        BdDownload.with().downloadStrategy().inspectNetworkOnWifi(this.task);
        BdDownload.with().downloadStrategy().inspectNetworkAvailable();
        DownloadConnection create = BdDownload.with().connectionFactory().create(this.task.getUrl());
        try {
            if (!Util.isEmpty(this.info.getEtag())) {
                create.addHeader(Util.IF_MATCH, this.info.getEtag());
            }
            create.addHeader("Range", "bytes=0-0");
            Map<String, List<String>> headerMapFields = this.task.getHeaderMapFields();
            if (headerMapFields != null) {
                Util.addUserRequestHeaderField(headerMapFields, create);
            }
            DownloadListener dispatch = BdDownload.with().callbackDispatcher().dispatch();
            dispatch.connectTrialStart(this.task, create.getRequestProperties());
            DownloadConnection.Connected execute = create.execute();
            this.task.setRedirectLocation(execute.getRedirectLocation());
            Util.d(TAG, "task[" + this.task.getId() + "] redirect location: " + this.task.getRedirectLocation());
            this.responseCode = execute.getResponseCode();
            this.acceptRange = isAcceptRange(execute);
            this.instanceLength = findInstanceLength(execute);
            this.responseEtag = findEtag(execute);
            this.responseFilename = findFilename(execute);
            this.responseFileType = findContentType(execute);
            Map<String, List<String>> responseHeaderFields = execute.getResponseHeaderFields();
            if (responseHeaderFields == null) {
                responseHeaderFields = new HashMap<>();
            }
            dispatch.connectTrialEnd(this.task, this.responseCode, responseHeaderFields);
            if (isNeedTrialHeadMethodForInstanceLength(this.instanceLength, execute)) {
                trialHeadMethodForInstanceLength();
            }
        } finally {
            create.release();
        }
    }

    public boolean isNeedTrialHeadMethodForInstanceLength(long j, @NonNull DownloadConnection.Connected connected) {
        String responseHeaderField;
        if (j != -1) {
            return false;
        }
        String responseHeaderField2 = connected.getResponseHeaderField("Content-Range");
        if ((responseHeaderField2 != null && responseHeaderField2.length() > 0) || parseTransferEncoding(connected.getResponseHeaderField("Transfer-Encoding")) || (responseHeaderField = connected.getResponseHeaderField("Content-Length")) == null || responseHeaderField.length() <= 0) {
            return false;
        }
        return true;
    }

    public void trialHeadMethodForInstanceLength() throws IOException {
        DownloadConnection create = BdDownload.with().connectionFactory().create(this.task.getUrl());
        DownloadListener dispatch = BdDownload.with().callbackDispatcher().dispatch();
        try {
            create.setRequestMethod("HEAD");
            Map<String, List<String>> headerMapFields = this.task.getHeaderMapFields();
            if (headerMapFields != null) {
                Util.addUserRequestHeaderField(headerMapFields, create);
            }
            dispatch.connectTrialStart(this.task, create.getRequestProperties());
            DownloadConnection.Connected execute = create.execute();
            dispatch.connectTrialEnd(this.task, execute.getResponseCode(), execute.getResponseHeaderFields());
            this.instanceLength = Util.parseContentLength(execute.getResponseHeaderField("Content-Length"));
        } finally {
            create.release();
        }
    }
}
