package com.baidu.searchbox.bddownload.core.download;

import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.down.utils.Constants;
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
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class DownloadStrategy {
    public static final long FOUR_CONNECTION_UPPER_LIMIT = 104857600;
    public static final long ONE_CONNECTION_UPPER_LIMIT = 1048576;
    public static final String TAG = "DownloadStrategy";
    public static final long THREE_CONNECTION_UPPER_LIMIT = 52428800;
    public static final Pattern TMP_FILE_NAME_PATTERN = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    public static final long TWO_CONNECTION_UPPER_LIMIT = 5242880;
    public Boolean isHasAccessNetworkStatePermission = null;
    public ConnectivityManager manager = null;

    /* loaded from: classes2.dex */
    public static class ResumeAvailableResponseCheck {
        public int blockIndex;
        @NonNull
        public DownloadConnection.Connected connected;
        @NonNull
        public BreakpointInfo info;

        public ResumeAvailableResponseCheck(@NonNull DownloadConnection.Connected connected, int i2, @NonNull BreakpointInfo breakpointInfo) {
            this.connected = connected;
            this.info = breakpointInfo;
            this.blockIndex = i2;
        }

        public void inspect() throws IOException {
            BlockInfo block = this.info.getBlock(this.blockIndex);
            int responseCode = this.connected.getResponseCode();
            ResumeFailedCause preconditionFailedCause = BdDownload.with().downloadStrategy().getPreconditionFailedCause(responseCode, block.getCurrentOffset() != 0, this.info, this.connected.getResponseHeaderField(Util.ETAG));
            if (preconditionFailedCause != null) {
                throw new ResumeFailedException(preconditionFailedCause);
            }
            if (BdDownload.with().downloadStrategy().isServerCanceled(responseCode, block.getCurrentOffset() != 0)) {
                throw new ServerCanceledException(responseCode, block.getCurrentOffset());
            }
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
        return j < 104857600 ? 3 : 4;
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
    public ResumeFailedCause getPreconditionFailedCause(int i2, boolean z, @NonNull BreakpointInfo breakpointInfo, @Nullable String str) {
        String etag = breakpointInfo.getEtag();
        if (i2 == 412) {
            return ResumeFailedCause.RESPONSE_PRECONDITION_FAILED;
        }
        if (Util.isEmpty(etag) || Util.isEmpty(str) || str.equals(etag)) {
            if (i2 == 201 && z) {
                return ResumeFailedCause.RESPONSE_CREATED_RANGE_NOT_FROM_0;
            }
            if (i2 == 205 && z) {
                return ResumeFailedCause.RESPONSE_RESET_RANGE_NOT_FROM_0;
            }
            return null;
        }
        return ResumeFailedCause.RESPONSE_ETAG_CHANGED;
    }

    public boolean inspectAnotherSameInfo(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, long j) {
        BreakpointStore breakpointStore;
        BreakpointInfo findAnotherInfoFromCompare;
        if (downloadTask.isFilenameFromResponse() && (findAnotherInfoFromCompare = (breakpointStore = BdDownload.with().breakpointStore()).findAnotherInfoFromCompare(downloadTask, breakpointInfo)) != null) {
            breakpointStore.remove(findAnotherInfoFromCompare.getId());
            if (findAnotherInfoFromCompare.getTotalOffset() <= BdDownload.with().downloadStrategy().reuseIdledSameInfoThresholdBytes()) {
                return false;
            }
            if ((findAnotherInfoFromCompare.getEtag() == null || findAnotherInfoFromCompare.getEtag().equals(breakpointInfo.getEtag())) && findAnotherInfoFromCompare.getTotalLength() == j && findAnotherInfoFromCompare.getFile() != null && findAnotherInfoFromCompare.getFile().exists()) {
                breakpointInfo.reuseBlocks(findAnotherInfoFromCompare);
                Util.d(TAG, "Reuse another same info: " + breakpointInfo);
                return true;
            }
            return false;
        }
        return false;
    }

    public void inspectFilenameFromResume(@NonNull String str, @NonNull DownloadTask downloadTask) {
        if (Util.isEmpty(downloadTask.getFilename())) {
            downloadTask.getFilenameHolder().set(str);
        }
    }

    public void inspectNetworkAvailable() throws UnknownHostException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
        }
        if (this.isHasAccessNetworkStatePermission.booleanValue()) {
            if (this.manager == null) {
                this.manager = (ConnectivityManager) BdDownload.with().context().getSystemService("connectivity");
            }
            if (!Util.isNetworkAvailable(this.manager)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void inspectNetworkOnWifi(@NonNull DownloadTask downloadTask) throws IOException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
        }
        if (downloadTask.isWifiRequired()) {
            if (this.isHasAccessNetworkStatePermission.booleanValue()) {
                if (this.manager == null && BdDownload.with().context() != null) {
                    this.manager = (ConnectivityManager) BdDownload.with().context().getSystemService("connectivity");
                }
                if (Util.isNetworkNotOnWifiType(this.manager)) {
                    throw new NetworkPolicyException();
                }
                return;
            }
            throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
        }
    }

    public boolean isServerCanceled(int i2, boolean z) {
        if (i2 == 206 || i2 == 200) {
            return i2 == 200 && z;
        }
        return true;
    }

    public boolean isUseMultiBlock(boolean z) {
        if (BdDownload.with().outputStreamFactory().supportSeek()) {
            return z;
        }
        return false;
    }

    public ResumeAvailableResponseCheck resumeAvailableResponseCheck(DownloadConnection.Connected connected, int i2, BreakpointInfo breakpointInfo) {
        return new ResumeAvailableResponseCheck(connected, i2, breakpointInfo);
    }

    public long reuseIdledSameInfoThresholdBytes() {
        return Constants.TEST_SPEED_THRESHOLD_DEFAULT;
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

    public boolean validFilenameFromStore(@NonNull DownloadTask downloadTask) {
        String responseFilename = BdDownload.with().breakpointStore().getResponseFilename(downloadTask.getUrl());
        if (responseFilename == null) {
            return false;
        }
        downloadTask.getFilenameHolder().set(responseFilename);
        return true;
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

    /* loaded from: classes2.dex */
    public static class FilenameHolder {
        public volatile String filename;
        public final boolean filenameProvidedByConstruct = false;

        public FilenameHolder() {
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof FilenameHolder) {
                if (this.filename == null) {
                    return ((FilenameHolder) obj).filename == null;
                }
                return this.filename.equals(((FilenameHolder) obj).filename);
            }
            return false;
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

        public void set(@NonNull String str) {
            this.filename = str;
        }

        public FilenameHolder(@NonNull String str) {
            this.filename = str;
        }
    }
}
