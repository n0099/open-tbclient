package com.baidu.searchbox.bddownload.core.download;

import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.exception.NetworkPolicyException;
import com.baidu.searchbox.bddownload.core.exception.ResumeFailedException;
import com.baidu.searchbox.bddownload.core.exception.ServerCanceledException;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class DownloadStrategy {
    public static final long FOUR_CONNECTION_UPPER_LIMIT = 104857600;
    public static final long ONE_CONNECTION_UPPER_LIMIT = 1048576;
    public static final String TAG = "DownloadStrategy";
    public static final long THREE_CONNECTION_UPPER_LIMIT = 52428800;
    public static final Pattern TMP_FILE_NAME_PATTERN = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    public static final long TWO_CONNECTION_UPPER_LIMIT = 5242880;
    public Boolean isHasAccessNetworkStatePermission = null;
    public ConnectivityManager manager = null;

    public boolean isServerCanceled(int i, boolean z) {
        if (i == 206 || i == 200) {
            return i == 200 && z;
        }
        return true;
    }

    public long reuseIdledSameInfoThresholdBytes() {
        return 10240L;
    }

    /* loaded from: classes3.dex */
    public static class FilenameHolder {
        public volatile String filename;
        public final boolean filenameProvidedByConstruct = false;

        public FilenameHolder() {
        }

        @Nullable
        public String get() {
            return this.filename;
        }

        public int hashCode() {
            if (this.filename == null) {
                return 0;
            }
            return this.filename.hashCode();
        }

        public boolean isFilenameProvidedByConstruct() {
            return this.filenameProvidedByConstruct;
        }

        public FilenameHolder(@NonNull String str) {
            this.filename = str;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof FilenameHolder)) {
                return false;
            }
            if (this.filename == null) {
                if (((FilenameHolder) obj).filename == null) {
                    return true;
                }
                return false;
            }
            return this.filename.equals(((FilenameHolder) obj).filename);
        }

        public void set(@NonNull String str) {
            this.filename = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class ResumeAvailableResponseCheck {
        public int blockIndex;
        @NonNull
        public DownloadConnection.Connected connected;
        @NonNull
        public BreakpointInfo info;

        public ResumeAvailableResponseCheck(@NonNull DownloadConnection.Connected connected, int i, @NonNull BreakpointInfo breakpointInfo) {
            this.connected = connected;
            this.info = breakpointInfo;
            this.blockIndex = i;
        }

        public void inspect() throws IOException {
            boolean z;
            BlockInfo block = this.info.getBlock(this.blockIndex);
            int responseCode = this.connected.getResponseCode();
            String responseHeaderField = this.connected.getResponseHeaderField(Util.ETAG);
            DownloadStrategy downloadStrategy = BdDownload.with().downloadStrategy();
            boolean z2 = true;
            if (block.getCurrentOffset() != 0) {
                z = true;
            } else {
                z = false;
            }
            ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, z, this.info, responseHeaderField);
            if (preconditionFailedCause == null) {
                DownloadStrategy downloadStrategy2 = BdDownload.with().downloadStrategy();
                if (block.getCurrentOffset() == 0) {
                    z2 = false;
                }
                if (!downloadStrategy2.isServerCanceled(responseCode, z2)) {
                    return;
                }
                throw new ServerCanceledException(responseCode, block.getCurrentOffset());
            }
            throw new ResumeFailedException(preconditionFailedCause);
        }
    }

    public int determineBlockCount(@NonNull DownloadTask downloadTask, long j) {
        if (downloadTask.getSetConnectionCount() != null) {
            return downloadTask.getSetConnectionCount().intValue();
        }
        if (j < 5242880) {
            return 1;
        }
        if (j < 52428800) {
            return 2;
        }
        if (j < 104857600) {
            return 3;
        }
        return 4;
    }

    public void inspectFilenameFromResume(@NonNull String str, @NonNull DownloadTask downloadTask) {
        if (Util.isEmpty(downloadTask.getFilename())) {
            downloadTask.getFilenameHolder().set(str);
        }
    }

    public String determineFilename(@Nullable String str, @NonNull DownloadTask downloadTask) throws IOException {
        if (Util.isEmpty(str)) {
            String url = downloadTask.getUrl();
            Matcher matcher = TMP_FILE_NAME_PATTERN.matcher(url);
            String str2 = null;
            while (matcher.find()) {
                str2 = matcher.group(1);
            }
            if (Util.isEmpty(str2)) {
                str2 = Util.md5(url);
            }
            if (str2 != null) {
                return str2;
            }
            throw new IOException("Can't find valid filename.");
        }
        return str;
    }

    @Nullable
    public ResumeFailedCause getPreconditionFailedCause(int i, boolean z, @NonNull BreakpointInfo breakpointInfo, @Nullable String str) {
        String etag = breakpointInfo.getEtag();
        if (i == 412) {
            return ResumeFailedCause.RESPONSE_PRECONDITION_FAILED;
        }
        if (!Util.isEmpty(etag) && !Util.isEmpty(str) && !str.equals(etag)) {
            return ResumeFailedCause.RESPONSE_ETAG_CHANGED;
        }
        if (i == 201 && z) {
            return ResumeFailedCause.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i == 205 && z) {
            return ResumeFailedCause.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public boolean inspectAnotherSameInfo(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, long j) {
        BreakpointStore breakpointStore;
        BreakpointInfo findAnotherInfoFromCompare;
        if (!downloadTask.isFilenameFromResponse() || (findAnotherInfoFromCompare = (breakpointStore = BdDownload.with().breakpointStore()).findAnotherInfoFromCompare(downloadTask, breakpointInfo)) == null) {
            return false;
        }
        breakpointStore.remove(findAnotherInfoFromCompare.getId());
        if (findAnotherInfoFromCompare.getTotalOffset() <= BdDownload.with().downloadStrategy().reuseIdledSameInfoThresholdBytes()) {
            return false;
        }
        if ((findAnotherInfoFromCompare.getEtag() != null && !findAnotherInfoFromCompare.getEtag().equals(breakpointInfo.getEtag())) || findAnotherInfoFromCompare.getTotalLength() != j || findAnotherInfoFromCompare.getFile() == null || !findAnotherInfoFromCompare.getFile().exists()) {
            return false;
        }
        breakpointInfo.reuseBlocks(findAnotherInfoFromCompare);
        Util.d(TAG, "Reuse another same info: " + breakpointInfo);
        return true;
    }

    public void inspectNetworkAvailable() throws UnknownHostException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.isHasAccessNetworkStatePermission.booleanValue()) {
            return;
        }
        if (this.manager == null) {
            this.manager = (ConnectivityManager) BdDownload.with().context().getSystemService("connectivity");
        }
        if (Util.isNetworkAvailable(this.manager)) {
            return;
        }
        throw new UnknownHostException("network is not available!");
    }

    public void inspectNetworkOnWifi(@NonNull DownloadTask downloadTask) throws IOException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!downloadTask.isWifiRequired()) {
            return;
        }
        if (this.isHasAccessNetworkStatePermission.booleanValue()) {
            if (this.manager == null && BdDownload.with().context() != null) {
                this.manager = (ConnectivityManager) BdDownload.with().context().getSystemService("connectivity");
            }
            if (!Util.isNetworkNotOnWifiType(this.manager)) {
                return;
            }
            throw new NetworkPolicyException();
        }
        throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
    }

    public boolean isUseMultiBlock(boolean z) {
        if (!BdDownload.with().outputStreamFactory().supportSeek()) {
            return false;
        }
        return z;
    }

    public boolean validFilenameFromStore(@NonNull DownloadTask downloadTask) {
        String responseFilename = BdDownload.with().breakpointStore().getResponseFilename(downloadTask.getUrl());
        if (responseFilename == null) {
            return false;
        }
        downloadTask.getFilenameHolder().set(responseFilename);
        return true;
    }

    public ResumeAvailableResponseCheck resumeAvailableResponseCheck(DownloadConnection.Connected connected, int i, BreakpointInfo breakpointInfo) {
        return new ResumeAvailableResponseCheck(connected, i, breakpointInfo);
    }

    public synchronized void validFilenameFromResponse(@Nullable String str, @NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) throws IOException {
        if (Util.isEmpty(downloadTask.getFilename())) {
            String determineFilename = determineFilename(str, downloadTask);
            if (Util.isEmpty(downloadTask.getFilename()) && Util.isEmpty(downloadTask.getFilename())) {
                downloadTask.getFilenameHolder().set(determineFilename);
                breakpointInfo.getFilenameHolder().set(determineFilename);
            }
        }
    }

    public void validInfoOnCompleted(@NonNull DownloadTask downloadTask, @NonNull DownloadStore downloadStore) {
        long length;
        BreakpointInfo afterCompleted = downloadStore.getAfterCompleted(downloadTask.getId());
        if (afterCompleted == null) {
            afterCompleted = new BreakpointInfo(downloadTask.getId(), downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
            if (Util.isUriContentScheme(downloadTask.getUri())) {
                length = Util.getSizeFromContentUri(downloadTask.getUri());
            } else {
                File file = downloadTask.getFile();
                if (file == null) {
                    length = 0;
                    Util.w(TAG, "file is not ready on valid info for task on complete state " + downloadTask);
                } else {
                    length = file.length();
                }
            }
            long j = length;
            afterCompleted.addBlock(new BlockInfo(0L, j, j));
        }
        DownloadTask.TaskHideWrapper.setBreakpointInfo(downloadTask, afterCompleted);
    }
}
