package com.baidu.searchbox.downloads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.android.internal.http.multipart.Part;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.PkgUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.DownloadInfo;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.download.util.DownloadErrorLogger;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.net.DownloadProxyHttpClient;
import com.baidu.searchbox.net.IProxyHttpClient;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.R;
import com.baidu.tieba.z20;
import com.baidu.ubc.UBC;
import com.baidubce.http.Headers;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SyncFailedException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadThread extends Thread {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "DownloadThread";
    public Context mContext;
    public ISystemFacade mISystemFacade;
    public DownloadInfo mInfo;
    public HttpResponse mResponse;

    private void transferToDrm(State state) throws StopRequest {
    }

    /* loaded from: classes3.dex */
    public static class InnerState {
        public long mBytesNotified;
        public long mBytesSoFar;
        public boolean mContinuingDownload;
        public String mHeaderContentDisposition;
        public String mHeaderContentLength;
        public String mHeaderContentLocation;
        public String mHeaderETag;
        public boolean mInitContinuingDownload;
        public long mRangeEndByte;
        public long mRangeStartByte;
        public String mRangeValue;
        public long mTimeLastNotification;

        public InnerState() {
            this.mBytesSoFar = 0L;
            this.mContinuingDownload = false;
            this.mInitContinuingDownload = false;
            this.mBytesNotified = 0L;
            this.mTimeLastNotification = 0L;
            this.mRangeStartByte = 0L;
            this.mRangeEndByte = -1L;
        }

        @NonNull
        public String toString() {
            return "InnerState detail - [ mBytesSoFar=" + this.mBytesSoFar + ", mHeaderETag=" + this.mHeaderETag + ", mContinuingDownload=" + this.mContinuingDownload + ", mInitContinuingDownload=" + this.mInitContinuingDownload + ", mHeaderContentLength=" + this.mHeaderContentLength + ", mHeaderContentDisposition=" + this.mHeaderContentDisposition + ", mHeaderContentLocation=" + this.mHeaderContentLocation + ", mBytesNotified=" + this.mBytesNotified + ", mRangeStartByte=" + this.mRangeStartByte + ", mRangeEndByte=" + this.mRangeEndByte + ", mRangeValue=" + this.mRangeValue + " ]";
        }
    }

    /* loaded from: classes3.dex */
    public static class RetryDownload extends Throwable {
        public RetryDownload() {
        }
    }

    /* loaded from: classes3.dex */
    public static class State {
        public String mBoundary;
        public String mFilename;
        public String mMimeType;
        public String mNewUri;
        public long mRangeEndByte;
        public long mRangeStartByte;
        public String mRangeValue;
        public int mRedirectCount;
        public String mRedirectUris;
        public String mReferer;
        public String mRequestUri;
        public FileOutputStream mStream;
        public boolean mCountRetry = false;
        public int mRetryAfter = 0;
        public boolean mGotData = false;
        public int mDownloadMod = 0;

        public State(DownloadInfo downloadInfo) {
            this.mRedirectCount = 0;
            this.mRangeStartByte = 0L;
            this.mRangeEndByte = -1L;
            this.mMimeType = DownloadHelper.sanitizeMimeType(downloadInfo.mMimeType);
            this.mRedirectCount = downloadInfo.mRedirectCount;
            this.mRequestUri = downloadInfo.mUri;
            this.mFilename = downloadInfo.mFileName;
            this.mRangeStartByte = downloadInfo.mRangeStartByte;
            this.mRangeEndByte = downloadInfo.mRangeEndByte;
            this.mRangeValue = downloadInfo.mRangeValue;
            this.mReferer = downloadInfo.mReferer;
        }

        @NonNull
        public String toString() {
            return "State -- [ mFilename=" + this.mFilename + ", mMimeType=" + this.mMimeType + ", mCountRetry=" + this.mCountRetry + ", mRetryAfter=" + this.mRetryAfter + ", mRedirectCount=" + this.mRedirectCount + ", mNewUri=" + this.mNewUri + ", mGotData=" + this.mGotData + ", mRequestUri=" + this.mRequestUri + ", mRangeStartByte=" + this.mRangeStartByte + ", mRangeEndByte=" + this.mRangeEndByte + ", mRangeValue=" + this.mRangeValue + ", mBoundary=" + this.mBoundary + ", mDownloadMod=" + this.mDownloadMod + ", mReferer=" + this.mReferer + ", mRedirectUris=" + this.mRedirectUris + " ]";
        }
    }

    /* loaded from: classes3.dex */
    public static class StopRequest extends Throwable {
        public int mFinalStatus;

        public StopRequest(int i, String str) {
            super(str);
            this.mFinalStatus = i;
        }

        public StopRequest(int i, String str, Throwable th) {
            super(str, th);
            this.mFinalStatus = i;
        }
    }

    private void logNetworkState() {
        String str;
        if (Constants.LOGX) {
            StringBuilder sb = new StringBuilder();
            sb.append("Net ");
            if (DownloadHelper.isNetworkAvailable(this.mISystemFacade)) {
                str = "Up";
            } else {
                str = "Down";
            }
            sb.append(str);
            Log.i("DownloadManager", sb.toString());
        }
    }

    private String userAgent() {
        String str = this.mInfo.mUserAgent;
        if (str == null) {
            return Constants.DEFAULT_USER_AGENT;
        }
        return str;
    }

    public DownloadThread(Context context, ISystemFacade iSystemFacade, DownloadInfo downloadInfo) {
        this.mContext = context;
        this.mISystemFacade = iSystemFacade;
        this.mInfo = downloadInfo;
        setName("DownloadThread:" + downloadInfo.mUri);
    }

    private void createStreamByUri(State state, Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        state.mStream = new FileOutputStream(contentResolver.openFileDescriptor(uri, "w", null).getFileDescriptor());
    }

    private void displayMsg(final DownloadInfo downloadInfo, final int i, final Throwable th) {
        new Handler(this.mContext.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.downloads.DownloadThread.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadThread.this.showMsg(downloadInfo, i, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMsg(DownloadInfo downloadInfo, int i, Throwable th) {
        String errorMessage = getErrorMessage(downloadInfo, i, th);
        if (!TextUtils.isEmpty(errorMessage)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), errorMessage).showToast();
        }
    }

    private void doCloudPauseStatisticJob(long j, String str, int i, String str2, String str3) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.downloadId = j;
        downloadActionModel.fileName = str;
        downloadActionModel.mimeType = "application/vnd.android.package-archive";
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        downloadActionModel.extraInfo = str2;
        downloadActionModel.mRedirectUris = str3;
        ApkCloudStatisticsUtils.doApkPauseDownloadStatisticJob(i, downloadActionModel);
    }

    private void addRequestHeaders(InnerState innerState, HttpGet httpGet) {
        String str;
        for (Pair<String, String> pair : this.mInfo.getHeaders()) {
            httpGet.addHeader((String) pair.first, (String) pair.second);
        }
        if (innerState.mContinuingDownload && (str = innerState.mHeaderETag) != null) {
            httpGet.addHeader(Util.IF_MATCH, str);
        }
        String createRangeHeader = createRangeHeader(innerState);
        if (!TextUtils.isEmpty(createRangeHeader)) {
            httpGet.addHeader("Range", createRangeHeader);
        }
    }

    private InputStream openResponseEntity(State state, HttpResponse httpResponse) throws StopRequest {
        try {
            return httpResponse.getEntity().getContent();
        } catch (IOException e) {
            logNetworkState();
            int finalStatusForHttpError = getFinalStatusForHttpError(state);
            saveErrorRecord(finalStatusForHttpError, "while getting entity: " + e.toString(), state, null);
            throw new StopRequest(finalStatusForHttpError, "while getting entity: " + e.toString(), e);
        }
    }

    private void reportProgress(State state, InnerState innerState) {
        long currentTimeMillis = this.mISystemFacade.currentTimeMillis();
        if (innerState.mBytesSoFar - innerState.mBytesNotified > 4096 && currentTimeMillis - innerState.mTimeLastNotification > 1500) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_bytes", Long.valueOf(innerState.mBytesSoFar));
            this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues, null, null);
            innerState.mBytesNotified = innerState.mBytesSoFar;
            innerState.mTimeLastNotification = currentTimeMillis;
        }
    }

    private void updateDatabaseFromHeaders(State state, InnerState innerState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", state.mFilename);
        String str = innerState.mHeaderETag;
        if (str != null) {
            contentValues.put("etag", str);
        }
        String str2 = state.mMimeType;
        if (str2 != null) {
            String mimeTypeFromFilename = DownloadHelper.getMimeTypeFromFilename(str2, state.mFilename);
            state.mMimeType = mimeTypeFromFilename;
            contentValues.put("mimetype", mimeTypeFromFilename);
        }
        contentValues.put("total_bytes", Long.valueOf(this.mInfo.mTotalBytes));
        this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues, null, null);
    }

    private boolean cannotResume(InnerState innerState) {
        if (innerState.mBytesSoFar > 0 && !this.mInfo.mNoIntegrity && innerState.mHeaderETag == null) {
            return true;
        }
        return false;
    }

    private void checkPausedOrCanceled(State state) throws StopRequest {
        synchronized (this.mInfo) {
            if (this.mInfo.mControl == 1) {
                throw new StopRequest(193, "download paused by owner");
            }
        }
        if (this.mInfo.mStatus != 490) {
            return;
        }
        throw new StopRequest(490, "download canceled");
    }

    private void closeDestination(State state) {
        try {
            if (state.mStream != null) {
                state.mStream.close();
                state.mStream = null;
            }
        } catch (Exception e) {
            if (Constants.LOGV) {
                Log.v("DownloadManager", "exception when closing the file after download : " + e);
            }
        }
    }

    private void finalizeDestinationFile(State state) throws StopRequest {
        if (isDrmFile(state)) {
            if (DEBUG) {
                Log.e(TAG, "finalizeDestinationFile drm file failed.");
                return;
            }
            return;
        }
        syncDestination(state);
    }

    private String getRealUri(String str) {
        try {
            return new URI(this.mInfo.mUri).resolve(new URI(URLEncoder.encode(str, "utf-8"))).toString();
        } catch (Exception e) {
            if (!DEBUG) {
                return null;
            }
            throw new DebugException("Download failed 下载链接包含特殊字符", e);
        }
    }

    private boolean isDrmFile(State state) {
        return Constants.MIMETYPE_DRM_MESSAGE.equalsIgnoreCase(state.mMimeType);
    }

    private void checkConnectivity(State state) throws StopRequest {
        int checkCanUseNetwork = this.mInfo.checkCanUseNetwork();
        if (checkCanUseNetwork != 1) {
            int i = 195;
            if (checkCanUseNetwork != 3) {
                if (checkCanUseNetwork == 4) {
                    this.mInfo.notifyPauseDueToSize(false);
                }
                saveErrorRecord(i, this.mInfo.getLogMessageForNetworkError(checkCanUseNetwork), state, null);
                throw new StopRequest(i, this.mInfo.getLogMessageForNetworkError(checkCanUseNetwork));
            }
            this.mInfo.notifyPauseDueToSize(true);
            i = 196;
            saveErrorRecord(i, this.mInfo.getLogMessageForNetworkError(checkCanUseNetwork), state, null);
            throw new StopRequest(i, this.mInfo.getLogMessageForNetworkError(checkCanUseNetwork));
        }
    }

    private int getFinalStatusForHttpError(State state) {
        if (!DownloadHelper.isNetworkAvailable(this.mISystemFacade)) {
            return 195;
        }
        if (this.mInfo.mNumFailed < 2) {
            state.mCountRetry = true;
            return 194;
        } else if (DEBUG) {
            Log.w("DownloadManager", "reached max retries for " + this.mInfo.mId);
            return Downloads.Impl.STATUS_HTTP_DATA_ERROR_3;
        } else {
            return Downloads.Impl.STATUS_HTTP_DATA_ERROR_3;
        }
    }

    private void cleanupDestination(State state, int i) {
        closeDestination(state);
        String str = state.mFilename;
        if (str != null && i == 490) {
            DownloadMediaHelper.deleteMediaFile(this.mContext, str, state.mMimeType);
            state.mFilename = null;
        }
    }

    private void doCloudStartStatisticJob(long j, String str) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.downloadId = j;
        downloadActionModel.mimeType = str;
        ApkCloudStatisticsUtils.doApkStartDownloadStatisticJob(downloadActionModel);
    }

    private void setMediaFileValues(ContentValues contentValues, State state) {
        String pathDir = DownloadMediaHelper.getPathDir(state.mFilename);
        contentValues.put("_display_name", DownloadMediaHelper.getName(state.mFilename));
        contentValues.put("mime_type", state.mMimeType);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", pathDir);
        }
    }

    private String createRangeHeader(InnerState innerState) {
        String str = innerState.mRangeValue;
        if (str != null && !str.isEmpty()) {
            return innerState.mRangeValue;
        }
        long j = innerState.mBytesSoFar;
        long j2 = innerState.mRangeStartByte;
        long j3 = innerState.mRangeEndByte;
        StringBuffer stringBuffer = new StringBuffer();
        if (innerState.mContinuingDownload) {
            j2 += j;
        }
        stringBuffer.append("bytes=");
        if (j2 > 0) {
            stringBuffer.append(j2);
            innerState.mInitContinuingDownload = true;
        } else {
            stringBuffer.append("0");
        }
        stringBuffer.append("-");
        if (j3 > 0 && j3 > j2) {
            stringBuffer.append(j3);
            innerState.mInitContinuingDownload = true;
        }
        String stringBuffer2 = stringBuffer.toString();
        if (TextUtils.equals(stringBuffer2, "bytes=0-") && !innerState.mContinuingDownload) {
            return "";
        }
        return stringBuffer2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDownloadStatistic(int i, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", i);
            jSONObject.put("url", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("referer", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(PackageTable.MD5, str3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UBC.onEvent(DownloadStatisticConstants.UBC_ID_DOWNLOAD_STATISTIC, jSONObject.toString());
    }

    private void executeDownload(State state, DownloadProxyHttpClient downloadProxyHttpClient, HttpGet httpGet, String str) throws StopRequest, RetryDownload {
        InnerState innerState = new InnerState();
        byte[] bArr = new byte[4096];
        setupDestinationFile(state, innerState);
        addRequestHeaders(innerState, httpGet);
        checkConnectivity(state);
        if (Constants.LOGV) {
            Log.i("DownloadManager", "sendRequest for begin: " + this.mInfo.mId);
        }
        this.mResponse = sendRequest(state, downloadProxyHttpClient, httpGet);
        if (Constants.LOGV) {
            Log.i("DownloadManager", "sendRequest for end: " + this.mInfo.mId);
        }
        int statusCode = this.mResponse.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            Header[] allHeaders = this.mResponse.getAllHeaders();
            StringBuilder sb = new StringBuilder();
            if (allHeaders != null && allHeaders.length > 0) {
                for (Header header : allHeaders) {
                    sb.append(header.toString());
                    sb.append(";;");
                }
            }
            if (!TextUtils.isEmpty(str)) {
                sendResponseErrorUBCEvent(this.mContext, "download", statusCode, DownloadStatisticConstants.UBC_VALUE_UNKNOW, -1, str, sb.toString());
            }
        }
        checkPausedOrCanceled(state);
        handleExceptionalStatus(state, innerState, this.mResponse);
        if (Constants.LOGV) {
            Log.v("DownloadManager", "received response for " + this.mInfo.mUri);
        }
        processResponseHeaders(state, innerState, this.mResponse);
        InputStream openResponseEntity = openResponseEntity(state, this.mResponse);
        this.mInfo.updateStatus(192);
        if (Constants.LOGV) {
            Log.i("DownloadManager", "executeDownload.transferData() set status: STATUS_RUNNING");
        }
        if (DownloadMediaHelper.needMediaFileProcessor(state.mFilename)) {
            transferData(state, innerState, openResponseEntity);
        } else {
            transferData(state, innerState, bArr, openResponseEntity);
        }
    }

    private String getErrorMessage(DownloadInfo downloadInfo, int i, Throwable th) {
        if (i != 498) {
            if (i != 499) {
                if (FileClassifyHelper.getCategory("", downloadInfo.mMimeType) == 0 && i != 490 && Downloads.isStatusError(i)) {
                    IDownloadApp.Impl.get().getVideoErrorMessage(this.mContext, downloadInfo, th, i);
                    return null;
                }
                return null;
            }
            return this.mContext.getString(R.string.dialog_media_not_found);
        }
        z20.u();
        return this.mContext.getString(R.string.download_no_enough_space_toast);
    }

    private void handleExceptionalStatus(State state, InnerState innerState, HttpResponse httpResponse) throws StopRequest, RetryDownload {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 503 && this.mInfo.mNumFailed < 2) {
            handleServiceUnavailable(state, httpResponse);
        }
        if (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) {
            handleRedirect(state, httpResponse, statusCode);
        }
        int i = 206;
        if (innerState.mRangeValue == null && !innerState.mContinuingDownload && !innerState.mInitContinuingDownload) {
            i = 200;
        }
        if (statusCode != i) {
            handleOtherStatus(state, innerState, statusCode);
        }
    }

    private void handleDownloadStatistic(final int i, final State state, String str) {
        String str2 = "";
        if (Downloads.Impl.isStatusCompleted(i) && Downloads.Impl.isStatusSuccess(i)) {
            final File file = new File(state.mFilename);
            if (file.exists()) {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.downloads.DownloadThread.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String md5 = MD5Utils.toMd5(file, false);
                        DownloadThread downloadThread = DownloadThread.this;
                        int i2 = i;
                        State state2 = state;
                        downloadThread.doDownloadStatistic(i2, state2.mRequestUri, state2.mReferer, md5);
                    }
                }, "downloadFileMd5", 3);
                return;
            } else {
                doDownloadStatistic(i, state.mRequestUri, state.mReferer, "");
                return;
            }
        }
        doDownloadStatistic(i, state.mRequestUri, state.mReferer, "");
        if (this.mInfo != null) {
            if (ApkCloudStatisticsUtils.enableAppsearchCloudStatic()) {
                DownloadInfo downloadInfo = this.mInfo;
                doCloudPauseStatisticJob(downloadInfo.mId, downloadInfo.mFileName, i, downloadInfo.mExtraInfo, state.mRedirectUris);
            }
            z20.e(this.mInfo.mId, i, str);
            str2 = this.mInfo.mExtraInfo;
        }
        DownloadMessageSender.logDownloadFail(state.mFilename, state.mMimeType, i, state.mRequestUri, state.mReferer, state.mRedirectCount, state.mCountRetry, str2);
    }

    private void handleOtherStatus(State state, InnerState innerState, int i) throws StopRequest, RetryDownload {
        int i2;
        if (!Downloads.Impl.isStatusError(i)) {
            if (i >= 300 && i < 400) {
                i2 = 493;
            } else if (innerState.mContinuingDownload && i == 200) {
                innerState.mBytesSoFar = 0L;
                innerState.mHeaderContentLength = "0";
                innerState.mBytesNotified = 0L;
                innerState.mTimeLastNotification = 0L;
                innerState.mHeaderETag = null;
                closeDestination(state);
                DownloadMediaHelper.deleteMediaFile(this.mContext, state.mFilename, state.mMimeType);
                DownloadInfo downloadInfo = this.mInfo;
                downloadInfo.mTotalBytes = 0L;
                downloadInfo.mCurrentBytes = 0L;
                throw new RetryDownload();
            } else {
                i2 = 494;
            }
        } else {
            i2 = i;
        }
        saveErrorRecord(i2, "http error " + i, state, innerState);
        throw new StopRequest(i2, "http error " + i);
    }

    private void readETagResponseHeaders(State state, InnerState innerState, HttpResponse httpResponse) throws RetryDownload {
        if (TextUtils.isEmpty(innerState.mHeaderETag)) {
            if (DEBUG) {
                Log.i("DownloadManager", "innerState.mHeaderETag == null");
                return;
            }
            return;
        }
        Header firstHeader = httpResponse.getFirstHeader(Headers.ETAG);
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (DEBUG) {
                Log.i("DownloadManager", "downlaodthread: etag = etag");
            }
            if (!TextUtils.equals(innerState.mHeaderETag, value)) {
                if (DEBUG) {
                    Log.i("DownloadManager", "innerState.mHeaderETag != etag");
                }
                innerState.mBytesSoFar = 0L;
                innerState.mHeaderContentLength = "0";
                innerState.mBytesNotified = 0L;
                innerState.mTimeLastNotification = 0L;
                innerState.mHeaderETag = null;
                closeDestination(state);
                DownloadMediaHelper.deleteMediaFile(this.mContext, state.mFilename, state.mMimeType);
                DownloadInfo downloadInfo = this.mInfo;
                downloadInfo.mTotalBytes = 0L;
                downloadInfo.mCurrentBytes = 0L;
                throw new RetryDownload();
            } else if (DEBUG) {
                Log.i("DownloadManager", "innerState.mHeaderETag == etag");
            }
        }
    }

    private HttpResponse sendRequest(State state, HttpClient httpClient, HttpGet httpGet) throws StopRequest {
        try {
            if (httpClient instanceof DownloadProxyHttpClient) {
                return ((DownloadProxyHttpClient) httpClient).executeSafely(httpGet);
            }
            return httpClient.execute(httpGet);
        } catch (IOException e) {
            logNetworkState();
            int finalStatusForHttpError = getFinalStatusForHttpError(state);
            saveErrorRecord(finalStatusForHttpError, "while trying to execute request: " + e.toString(), state, null);
            throw new StopRequest(finalStatusForHttpError, "while trying to execute request: " + e.toString(), e);
        } catch (IllegalArgumentException e2) {
            saveErrorRecord(Downloads.Impl.STATUS_HTTP_DATA_ERROR_2, "while trying to execute request: " + e2.toString(), state, null);
            throw new StopRequest(Downloads.Impl.STATUS_HTTP_DATA_ERROR_2, "while trying to execute request: " + e2.toString(), e2);
        }
    }

    private void handleEndOfStream(State state, InnerState innerState) throws StopRequest {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("current_bytes", Long.valueOf(innerState.mBytesSoFar));
        if (innerState.mHeaderContentLength == null) {
            contentValues.put("total_bytes", Long.valueOf(innerState.mBytesSoFar));
        }
        this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues, null, null);
        String str = innerState.mHeaderContentLength;
        if (str != null && innerState.mBytesSoFar != Long.parseLong(str)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (cannotResume(innerState)) {
                saveErrorRecord(Downloads.Impl.STATUS_CANNOT_RESUME, "mismatched content length", state, innerState);
                throw new StopRequest(Downloads.Impl.STATUS_CANNOT_RESUME, "mismatched content length");
            }
            int finalStatusForHttpError = getFinalStatusForHttpError(state);
            saveErrorRecord(finalStatusForHttpError, "closed socket before end of file", state, innerState);
            throw new StopRequest(finalStatusForHttpError, "closed socket before end of file");
        }
    }

    private void handleServiceUnavailable(State state, HttpResponse httpResponse) throws StopRequest {
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "got HTTP response code 503");
        }
        state.mCountRetry = true;
        Header firstHeader = httpResponse.getFirstHeader("Retry-After");
        if (firstHeader != null) {
            try {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "Retry-After :" + firstHeader.getValue());
                }
                int parseInt = Integer.parseInt(firstHeader.getValue());
                state.mRetryAfter = parseInt;
                if (parseInt >= 0) {
                    if (parseInt >= 30) {
                        if (parseInt > 86400) {
                            state.mRetryAfter = 86400;
                        }
                    } else {
                        state.mRetryAfter = 30;
                    }
                    int nextInt = state.mRetryAfter + DownloadHelper.RANDOM.nextInt(31);
                    state.mRetryAfter = nextInt;
                    state.mRetryAfter = nextInt * 1000;
                } else {
                    state.mRetryAfter = 0;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        saveErrorRecord(194, "got 503 Service Unavailable, will retry later", state, null);
        throw new StopRequest(194, "got 503 Service Unavailable, will retry later");
    }

    private void handleRedirect(State state, HttpResponse httpResponse, int i) throws StopRequest, RetryDownload {
        String realUri;
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "got HTTP redirect " + i);
        }
        if (state.mRedirectCount < 5) {
            Header firstHeader = httpResponse.getFirstHeader("Location");
            if (firstHeader == null) {
                return;
            }
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "Location :" + firstHeader.getValue());
            }
            try {
                realUri = new URI(this.mInfo.mUri).resolve(new URI(firstHeader.getValue())).toString();
            } catch (URISyntaxException unused) {
                realUri = getRealUri(firstHeader.getValue());
                if (TextUtils.isEmpty(realUri)) {
                    saveErrorRecord(Downloads.Impl.STATUS_HTTP_DATA_ERROR_1, "Couldn't resolve redirect URI", state, null);
                    throw new StopRequest(Downloads.Impl.STATUS_HTTP_DATA_ERROR_1, "Couldn't resolve redirect URI");
                }
            }
            state.mRedirectCount++;
            state.mRequestUri = realUri;
            if (i == 301 || i == 303) {
                state.mNewUri = realUri;
            }
            state.mRedirectUris = ">>##>>" + realUri;
            throw new RetryDownload();
        }
        saveErrorRecord(497, "too many redirects", state, null);
        throw new StopRequest(497, "too many redirects");
    }

    @TargetApi(29)
    private void transferData(State state, InnerState innerState, InputStream inputStream) throws StopRequest {
        ContentValues contentValues = new ContentValues();
        String fileSuffix = FileClassifyHelper.getFileSuffix(state.mFilename);
        if (FileClassifyHelper.isNeedReplaceMimetype(state.mMimeType, fileSuffix)) {
            state.mMimeType = FileClassifyHelper.guessMimeTypeFromExtension(fileSuffix);
        }
        setMediaFileValues(contentValues, state);
        Uri a = MediaFileProcessor.a(DownloadMediaHelper.getMediaFileUriSource(state.mFilename, state.mMimeType));
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Uri insert = contentResolver.insert(a, contentValues);
        try {
            if (insert == null) {
                return;
            }
            try {
                if (DownloadMediaHelper.isAndroid11Device()) {
                    try {
                        if (Constants.LOGV) {
                            Log.d("DownloadManager", "downloaded by FileOutputStream");
                        }
                        state.mStream = new FileOutputStream(state.mFilename, true);
                    } catch (SecurityException unused) {
                        if (Constants.LOGV) {
                            Log.d("DownloadManager", "downloaded throw exception , backup by uri");
                        }
                        createStreamByUri(state, insert, contentResolver);
                    }
                } else {
                    if (Constants.LOGV) {
                        Log.d("DownloadManager", "downloaded by uri");
                    }
                    createStreamByUri(state, insert, contentResolver);
                }
                transferData(state, innerState, new byte[4096], inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            closeDestination(state);
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(insert, contentValues, null, null);
        } catch (Throwable th) {
            closeDestination(state);
            throw th;
        }
    }

    private void writeDataToDestination(State state, byte[] bArr, int i) throws StopRequest {
        while (true) {
            try {
                if (state.mStream == null) {
                    state.mStream = new FileOutputStream(state.mFilename, true);
                }
                state.mStream.write(bArr, 0, i);
                return;
            } catch (Exception e) {
                if (this.mInfo.isOnCache()) {
                    if (!DownloadHelper.discardPurgeableFiles(this.mContext, 4096L)) {
                        break;
                    }
                } else if (DownloadHelper.isExternalMediaMounted()) {
                    break;
                } else {
                    saveErrorRecord(499, "external media not mounted while writing destination file", state, null);
                    throw new StopRequest(499, "external media not mounted while writing destination file");
                }
                try {
                    if (DownloadHelper.getAvailableBytes(DownloadHelper.getFilesystemRoot(state.mFilename)) < i) {
                        saveErrorRecord(498, this.mContext.getString(R.string.download_noenough_space), state, null);
                        throw new StopRequest(498, this.mContext.getString(R.string.download_noenough_space), e);
                    }
                    saveErrorRecord(Downloads.Impl.STATUS_FILE_ERROR_9, "while writing destination file: " + e.toString(), state, null);
                    throw new StopRequest(Downloads.Impl.STATUS_FILE_ERROR_9, "while writing destination file: " + e.toString(), e);
                } catch (Exception unused) {
                    saveErrorRecord(498, this.mContext.getString(R.string.download_noenough_space) + "[1]", state, null);
                    throw new StopRequest(498, this.mContext.getString(R.string.download_noenough_space), e);
                }
            }
        }
    }

    private void notifyDownloadCompleted(int i, boolean z, int i2, int i3, boolean z2, String str, String str2, String str3) {
        notifyThroughDatabase(i, z, i2, i3, z2, str, str2, str3);
        if (Downloads.Impl.isStatusCompleted(i)) {
            this.mInfo.sendIntentIfRequested();
        }
    }

    private void notifyThroughDatabase(int i, boolean z, int i2, int i3, boolean z2, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        if (str2 != null) {
            contentValues.put("uri", str2);
        }
        contentValues.put("mimetype", str3);
        contentValues.put("lastmod", Long.valueOf(this.mISystemFacade.currentTimeMillis()));
        contentValues.put("method", Integer.valueOf(i2 + (i3 << 28)));
        if (!z) {
            contentValues.put(Constants.FAILED_CONNECTIONS, (Integer) 0);
        } else if (z2) {
            contentValues.put(Constants.FAILED_CONNECTIONS, (Integer) 1);
        } else {
            contentValues.put(Constants.FAILED_CONNECTIONS, Integer.valueOf(this.mInfo.mNumFailed + 1));
        }
        try {
            this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues, null, null);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void processResponseHeaders(State state, InnerState innerState, HttpResponse httpResponse) throws StopRequest, RetryDownload {
        long j;
        readETagResponseHeaders(state, innerState, httpResponse);
        if (innerState.mContinuingDownload) {
            return;
        }
        synchronized (this.mInfo) {
            readResponseHeaders(state, innerState, httpResponse);
            try {
                Context context = this.mContext;
                String str = this.mInfo.mUri;
                String str2 = state.mRequestUri;
                String str3 = this.mInfo.mHint;
                String str4 = innerState.mHeaderContentDisposition;
                String str5 = innerState.mHeaderContentLocation;
                String str6 = state.mMimeType;
                int i = this.mInfo.mDestination;
                if (innerState.mHeaderContentLength != null) {
                    j = Long.parseLong(innerState.mHeaderContentLength);
                } else {
                    j = 0;
                }
                String generateSaveFile = DownloadHelper.generateSaveFile(context, str, str2, str3, str4, str5, str6, i, j, this.mInfo.mIsPublicApi);
                state.mFilename = generateSaveFile;
                try {
                    if (DownloadMediaHelper.noNeedMediaFileProcessor(generateSaveFile)) {
                        File file = new File(state.mFilename);
                        if (!file.exists()) {
                            try {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && !parentFile.exists()) {
                                    if (parentFile.mkdirs()) {
                                        file.createNewFile();
                                    }
                                }
                                file.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        state.mStream = new FileOutputStream(state.mFilename);
                    }
                    if (Constants.LOGV) {
                        Log.v("DownloadManager", "writing " + this.mInfo.mUri + " to " + state.mFilename);
                    }
                    updateDatabaseFromHeaders(state, innerState);
                    z20.f(this.mInfo.mId);
                } catch (FileNotFoundException e2) {
                    saveErrorRecord(Downloads.Impl.STATUS_FILE_ERROR_10, "while opening destination file: " + e2.toString(), state, innerState);
                    throw new StopRequest(Downloads.Impl.STATUS_FILE_ERROR_10, "while opening destination file: " + e2.toString(), e2);
                }
            } catch (DownloadHelper.GenerateSaveFileError e3) {
                saveErrorRecord(e3.mStatus, e3.mMessage, state, innerState);
                throw new StopRequest(e3.mStatus, e3.mMessage);
            }
        }
        checkConnectivity(state);
    }

    private int readFromResponse(State state, InnerState innerState, byte[] bArr, InputStream inputStream) throws StopRequest {
        try {
            return inputStream.read(bArr);
        } catch (IOException e) {
            logNetworkState();
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_bytes", Long.valueOf(innerState.mBytesSoFar));
            this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues, null, null);
            if (cannotResume(innerState)) {
                String str = "while reading response: " + e.toString() + ", can't resume interrupted download with no ETag";
                saveErrorRecord(Downloads.Impl.STATUS_CANNOT_RESUME, str, state, innerState);
                throw new StopRequest(Downloads.Impl.STATUS_CANNOT_RESUME, str, e);
            }
            int finalStatusForHttpError = getFinalStatusForHttpError(state);
            saveErrorRecord(finalStatusForHttpError, "while reading response: " + e.toString(), state, innerState);
            throw new StopRequest(finalStatusForHttpError, "while reading response: " + e.toString(), e);
        }
    }

    private void readResponseHeaders(State state, InnerState innerState, HttpResponse httpResponse) throws StopRequest {
        String str;
        boolean z;
        Header firstHeader = httpResponse.getFirstHeader("Content-type");
        boolean z2 = true;
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (value.contains(Downloads.Impl.COLUMN_BOUNDARY)) {
                state.mBoundary = value.substring(value.indexOf(61) + 1);
                state.mDownloadMod = IDownloadApp.Impl.get().getNovelDownloadModeMultiRange();
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Content-Range");
        if (firstHeader2 != null && firstHeader2.getValue().contains("bytes")) {
            state.mDownloadMod = IDownloadApp.Impl.get().getNovelDownloadModeSingleRange();
        }
        Header firstHeader3 = httpResponse.getFirstHeader("Content-Disposition");
        if (firstHeader3 != null) {
            innerState.mHeaderContentDisposition = firstHeader3.getValue();
        }
        Header firstHeader4 = httpResponse.getFirstHeader("Content-Location");
        if (firstHeader4 != null) {
            innerState.mHeaderContentLocation = firstHeader4.getValue();
        }
        Header firstHeader5 = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader5 != null) {
            str = DownloadHelper.sanitizeMimeType(firstHeader5.getValue());
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(state.mMimeType)) {
            doCloudStartStatisticJob(this.mInfo.mId, str);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(state.mMimeType, str)) {
            boolean isDownloadingApk = FileClassifyHelper.isDownloadingApk(state.mRequestUri, innerState.mHeaderContentDisposition, str);
            if ("application/vnd.android.package-archive".equalsIgnoreCase(state.mMimeType) && isDownloadingApk) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                state.mMimeType = str;
            }
            if (DEBUG) {
                Log.i("DownloadManager", "isChangeApk:" + z + ",MIME:" + state.mMimeType);
            }
        }
        Header firstHeader6 = httpResponse.getFirstHeader(Headers.ETAG);
        if (firstHeader6 != null) {
            innerState.mHeaderETag = firstHeader6.getValue();
        }
        String str2 = null;
        Header firstHeader7 = httpResponse.getFirstHeader("Transfer-Encoding");
        if (firstHeader7 != null) {
            str2 = firstHeader7.getValue();
        }
        if (str2 == null) {
            Header firstHeader8 = httpResponse.getFirstHeader("Content-Length");
            if (firstHeader8 != null) {
                String value2 = firstHeader8.getValue();
                innerState.mHeaderContentLength = value2;
                this.mInfo.mTotalBytes = Long.parseLong(value2);
            }
        } else if (Constants.LOGVV) {
            Log.v("DownloadManager", "ignoring content-length because of xfer-encoding");
        }
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "Content-Disposition: " + innerState.mHeaderContentDisposition);
            Log.v("DownloadManager", "Content-Length: " + innerState.mHeaderContentLength);
            Log.v("DownloadManager", "Content-Location: " + innerState.mHeaderContentLocation);
            Log.v("DownloadManager", Part.CONTENT_TYPE + state.mMimeType);
            Log.v("DownloadManager", "ETag: " + innerState.mHeaderETag);
            Log.v("DownloadManager", "Transfer-Encoding: " + str2);
        }
        z2 = (innerState.mHeaderContentLength != null || (str2 != null && str2.equalsIgnoreCase("chunked")) || httpResponse.getProtocolVersion().getMajor() >= 2) ? false : false;
        if (!this.mInfo.mNoIntegrity && z2) {
            saveErrorRecord(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "can't know size of download, giving up", state, innerState);
            throw new StopRequest(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "can't know size of download, giving up");
        }
    }

    private void saveErrorRecord(int i, String str, State state, InnerState innerState) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        DownloadErrorLogger.Companion.errorLog(TAG, String.format("======<<< record start- time: %s <<<========", format));
        DownloadErrorLogger.Companion.errorLog(TAG, String.format("errorCode=%d", Integer.valueOf(i)));
        DownloadErrorLogger.Companion.errorLog(TAG, String.format("errorMsg=%s", str));
        if (this.mInfo != null) {
            DownloadErrorLogger.Companion companion = DownloadErrorLogger.Companion;
            companion.errorLog(TAG, "downloadInfo -- " + this.mInfo.toString());
        }
        if (state != null) {
            DownloadErrorLogger.Companion companion2 = DownloadErrorLogger.Companion;
            companion2.errorLog(TAG, "state -- " + state.toString());
        }
        if (innerState != null) {
            DownloadErrorLogger.Companion companion3 = DownloadErrorLogger.Companion;
            companion3.errorLog(TAG, "innerState -- " + innerState.toString());
        }
        DownloadErrorLogger.Companion.errorLog(TAG, String.format("======<<< record end- time: %s <<<========", format));
    }

    public static void sendResponseErrorUBCEvent(@NonNull Context context, String str, int i, String str2, int i2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put("value", i);
            jSONObject.put("page", str2);
            jSONObject.put("from", ApkCloudStatisticsUtils.removeBDussInUrl(str3));
            jSONObject.put("downloadState", i2);
            jSONObject.put("header", str4);
            jSONObject.put("netWork", NetWorkUtils.getNetworkClass(context));
            PackageInfo packageInfo = PkgUtils.getPackageInfo(context, context.getPackageName());
            if (packageInfo != null) {
                jSONObject.put("appVersion", packageInfo.versionName);
            }
            UBC.onEvent(DownloadStatisticConstants.RESPONSE_ERROR_ID, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setupDestinationFile(State state, InnerState innerState) throws StopRequest {
        String str = state.mFilename;
        if (str != null) {
            if (DownloadHelper.isFilenameValid(str)) {
                File file = new File(state.mFilename);
                if (file.exists()) {
                    long length = file.length();
                    if (length == 0) {
                        DownloadMediaHelper.deleteMediaFile(this.mContext, state.mFilename, state.mMimeType);
                        state.mFilename = null;
                    } else {
                        DownloadInfo downloadInfo = this.mInfo;
                        if (downloadInfo.mETag == null && !downloadInfo.mNoIntegrity) {
                            DownloadMediaHelper.deleteMediaFile(this.mContext, state.mFilename, state.mMimeType);
                            saveErrorRecord(Downloads.Impl.STATUS_CANNOT_RESUME, "Trying to resume a download that can't be resumed", state, innerState);
                            throw new StopRequest(Downloads.Impl.STATUS_CANNOT_RESUME, "Trying to resume a download that can't be resumed");
                        }
                        if (DownloadMediaHelper.noNeedMediaFileProcessor(state.mFilename)) {
                            try {
                                state.mStream = new FileOutputStream(state.mFilename, true);
                            } catch (FileNotFoundException e) {
                                saveErrorRecord(Downloads.Impl.STATUS_FILE_ERROR_12, "while opening destination for resuming: " + e.toString(), state, innerState);
                                throw new StopRequest(Downloads.Impl.STATUS_FILE_ERROR_12, "while opening destination for resuming: " + e.toString(), e);
                            }
                        }
                        innerState.mBytesSoFar = length;
                        long j = this.mInfo.mTotalBytes;
                        if (j != -1) {
                            innerState.mHeaderContentLength = Long.toString(j);
                        }
                        innerState.mHeaderETag = this.mInfo.mETag;
                        innerState.mContinuingDownload = true;
                    }
                }
            } else {
                saveErrorRecord(Downloads.Impl.STATUS_FILE_ERROR_11, "found invalid internal destination filename", state, innerState);
                throw new StopRequest(Downloads.Impl.STATUS_FILE_ERROR_11, "found invalid internal destination filename");
            }
        }
        if (state.mStream != null && !isDrmFile(state)) {
            closeDestination(state);
        }
        innerState.mRangeStartByte = state.mRangeStartByte;
        innerState.mRangeEndByte = state.mRangeEndByte;
        innerState.mRangeValue = state.mRangeValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x002c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x002e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0031 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0034 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x004d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x00bd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00bd -> B:63:0x00bd). Please submit an issue!!! */
    private void syncDestination(State state) {
        FileOutputStream fileOutputStream;
        if (DownloadMediaHelper.needMediaFileProcessor(state.mFilename)) {
            return;
        }
        FileNotFoundException e = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        e = null;
        e = 0;
        try {
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(state.mFilename, true);
                    } catch (Throwable th) {
                        th = th;
                        if (e != null) {
                            try {
                                e.close();
                            } catch (IOException e2) {
                                Log.w("DownloadManager", "IOException while closing synced file: ", e2);
                            } catch (RuntimeException e3) {
                                Log.w("DownloadManager", "exception while closing file: ", e3);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    Log.w("DownloadManager", "IOException while closing synced file: ", e4);
                    e = e;
                    fileOutputStream = fileOutputStream;
                } catch (RuntimeException e5) {
                    Log.w("DownloadManager", "exception while closing file: ", e5);
                    e = e;
                    fileOutputStream = fileOutputStream;
                }
            } catch (FileNotFoundException e6) {
                fileOutputStream = null;
                e = e6;
            } catch (SyncFailedException e7) {
                fileOutputStream = null;
                e = e7;
            } catch (IOException e8) {
                e = e8;
            } catch (RuntimeException e9) {
                e = e9;
            }
            try {
                FileDescriptor fd = fileOutputStream.getFD();
                fd.sync();
                fileOutputStream.close();
                e = fd;
                fileOutputStream = fileOutputStream;
            } catch (FileNotFoundException e10) {
                e = e10;
                Log.w("DownloadManager", "file " + state.mFilename + " not found: " + e);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (SyncFailedException e11) {
                e = e11;
                Log.w("DownloadManager", "file " + state.mFilename + " sync failed: " + e);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e12) {
                e = e12;
                fileOutputStream2 = fileOutputStream;
                ?? sb = new StringBuilder();
                sb.append("IOException trying to sync ");
                sb.append(state.mFilename);
                sb.append(": ");
                sb.append(e);
                Log.w("DownloadManager", sb.toString());
                e = fileOutputStream2;
                fileOutputStream = sb;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    e = fileOutputStream2;
                    fileOutputStream = sb;
                }
            } catch (RuntimeException e13) {
                e = e13;
                fileOutputStream3 = fileOutputStream;
                Log.w("DownloadManager", "exception while syncing file: ", e);
                e = fileOutputStream3;
                fileOutputStream = fileOutputStream;
                if (fileOutputStream3 != null) {
                    fileOutputStream3.close();
                    e = fileOutputStream3;
                    fileOutputStream = fileOutputStream;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            e = fileOutputStream;
        }
    }

    private void transferData(State state, InnerState innerState, byte[] bArr, InputStream inputStream) throws StopRequest {
        while (true) {
            int readFromResponse = readFromResponse(state, innerState, bArr, inputStream);
            if (readFromResponse == -1) {
                break;
            }
            state.mGotData = true;
            state.mRedirectCount = 0;
            writeDataToDestination(state, bArr, readFromResponse);
            innerState.mBytesSoFar += readFromResponse;
            reportProgress(state, innerState);
            if (Constants.LOGV) {
                Log.d("DownloadManager", "downloaded " + innerState.mBytesSoFar + " for " + this.mInfo.mUri);
            }
            checkPausedOrCanceled(state);
        }
        handleEndOfStream(state, innerState);
        if (!isDrmFile(state)) {
            closeDestination(state);
        }
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x03a1: IF  (r13 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:161:0x03a6, block:B:159:0x03a1 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x03a6: IF  (r14 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:163:0x03ab, block:B:161:0x03a6 */
    @Override // java.lang.Thread, java.lang.Runnable
    @SuppressLint({"InvalidWakeLockTag", "WakelockTimeout"})
    public void run() {
        Throwable th;
        PowerManager.WakeLock wakeLock;
        IProxyHttpClient iProxyHttpClient;
        PowerManager.WakeLock wakeLock2;
        DownloadProxyHttpClient downloadProxyHttpClient;
        Process.setThreadPriority(10);
        State state = new State(this.mInfo);
        int i = 0;
        try {
            try {
                try {
                    wakeLock2 = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, "DownloadManager");
                    try {
                        wakeLock2.acquire();
                        if (Constants.LOGV) {
                            Log.v("DownloadManager", "initiating download for " + this.mInfo.mUri);
                        }
                        downloadProxyHttpClient = new DownloadProxyHttpClient(userAgent());
                        try {
                            downloadProxyHttpClient.getParams().setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, false);
                            boolean z = false;
                            while (!z) {
                                if (Constants.LOGV) {
                                    Log.i("DownloadManager", "Initiating request for download " + this.mInfo.mId);
                                }
                                String str = state.mRequestUri;
                                downloadProxyHttpClient.setUrl(str);
                                HttpGet httpGet = new HttpGet();
                                try {
                                    executeDownload(state, downloadProxyHttpClient, httpGet, str);
                                    httpGet.abort();
                                    if (this.mResponse != null && this.mResponse.getEntity() != null && this.mResponse.getEntity().getContent() != null) {
                                        try {
                                            this.mResponse.getEntity().getContent().close();
                                        } catch (Exception e) {
                                            if (DEBUG) {
                                                Log.v("DownloadManager", e.getMessage());
                                            }
                                        }
                                    }
                                    z = true;
                                } catch (RetryDownload e2) {
                                    e2.printStackTrace();
                                    httpGet.abort();
                                    if (this.mResponse != null && this.mResponse.getEntity() != null && this.mResponse.getEntity().getContent() != null) {
                                        try {
                                            this.mResponse.getEntity().getContent().close();
                                        } catch (Exception e3) {
                                            if (DEBUG) {
                                                Log.v("DownloadManager", e3.getMessage());
                                            }
                                        }
                                    }
                                }
                            }
                            if (Constants.LOGV) {
                                Log.v("DownloadManager", "download completed for " + this.mInfo.mUri);
                            }
                            finalizeDestinationFile(state);
                            if (wakeLock2 != null) {
                                wakeLock2.release();
                            }
                            downloadProxyHttpClient.close();
                            cleanupDestination(state, 200);
                            ContentValues contentValues = new ContentValues();
                            if (state.mDownloadMod > 0) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(IDownloadApp.Impl.get().getNovelSegmentStatus(), IDownloadApp.Impl.get().getNovelStatusDownloadEnd());
                                    jSONObject.put(IDownloadApp.Impl.get().getNovelStatusTimestamp(), System.currentTimeMillis());
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                                contentValues.put("extra_info", jSONObject.toString());
                                String str2 = state.mBoundary;
                                if (str2 != null && !str2.isEmpty()) {
                                    contentValues.put(Downloads.Impl.COLUMN_BOUNDARY, state.mBoundary);
                                }
                                contentValues.put(Downloads.Impl.COLUMN_DOWNLOAD_MOD, Integer.valueOf(state.mDownloadMod));
                            }
                            try {
                                this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues, null, null);
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            handleDownloadStatistic(200, state, "");
                            notifyDownloadCompleted(200, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename, state.mNewUri, state.mMimeType);
                            DSUtils.mCurrentThreadNum--;
                            if (Downloads.Impl.isStatusCompleted(200)) {
                                return;
                            }
                        } catch (StopRequest e6) {
                            e = e6;
                            if (Constants.LOGV) {
                                Log.w("DownloadManager", "Aborting request for download " + this.mInfo.mId + ": " + e.getMessage());
                            }
                            int i2 = e.mFinalStatus;
                            displayMsg(this.mInfo, i2, e);
                            String message = e.getMessage();
                            if (wakeLock2 != null) {
                                wakeLock2.release();
                            }
                            if (downloadProxyHttpClient != null) {
                                downloadProxyHttpClient.close();
                            }
                            cleanupDestination(state, i2);
                            ContentValues contentValues2 = new ContentValues();
                            if (state.mDownloadMod > 0) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put(IDownloadApp.Impl.get().getNovelSegmentStatus(), IDownloadApp.Impl.get().getNovelStatusDownloadEnd());
                                    jSONObject2.put(IDownloadApp.Impl.get().getNovelStatusTimestamp(), System.currentTimeMillis());
                                } catch (JSONException e7) {
                                    e7.printStackTrace();
                                }
                                contentValues2.put("extra_info", jSONObject2.toString());
                                String str3 = state.mBoundary;
                                if (str3 != null && !str3.isEmpty()) {
                                    contentValues2.put(Downloads.Impl.COLUMN_BOUNDARY, state.mBoundary);
                                }
                                contentValues2.put(Downloads.Impl.COLUMN_DOWNLOAD_MOD, Integer.valueOf(state.mDownloadMod));
                            }
                            try {
                                this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues2, null, null);
                            } catch (Exception e8) {
                                e8.printStackTrace();
                            }
                            handleDownloadStatistic(i2, state, message);
                            notifyDownloadCompleted(i2, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename, state.mNewUri, state.mMimeType);
                            DSUtils.mCurrentThreadNum--;
                            if (Downloads.Impl.isStatusCompleted(i2)) {
                                return;
                            }
                            this.mInfo.mHasActiveThread = false;
                        } catch (Throwable th2) {
                            th = th2;
                            Log.w("DownloadManager", "Exception for id " + this.mInfo.mId + ": " + th);
                            displayMsg(this.mInfo, Downloads.Impl.STATUS_UNKNOWN_ERROR, th);
                            String message2 = th.getMessage();
                            if (wakeLock2 != null) {
                                wakeLock2.release();
                            }
                            if (downloadProxyHttpClient != null) {
                                downloadProxyHttpClient.close();
                            }
                            cleanupDestination(state, Downloads.Impl.STATUS_UNKNOWN_ERROR);
                            ContentValues contentValues3 = new ContentValues();
                            if (state.mDownloadMod > 0) {
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.put(IDownloadApp.Impl.get().getNovelSegmentStatus(), IDownloadApp.Impl.get().getNovelStatusDownloadEnd());
                                    jSONObject3.put(IDownloadApp.Impl.get().getNovelStatusTimestamp(), System.currentTimeMillis());
                                } catch (JSONException e9) {
                                    e9.printStackTrace();
                                }
                                contentValues3.put("extra_info", jSONObject3.toString());
                                String str4 = state.mBoundary;
                                if (str4 != null && !str4.isEmpty()) {
                                    contentValues3.put(Downloads.Impl.COLUMN_BOUNDARY, state.mBoundary);
                                }
                                contentValues3.put(Downloads.Impl.COLUMN_DOWNLOAD_MOD, Integer.valueOf(state.mDownloadMod));
                            }
                            try {
                                this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues3, null, null);
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                            handleDownloadStatistic(Downloads.Impl.STATUS_UNKNOWN_ERROR, state, message2);
                            notifyDownloadCompleted(Downloads.Impl.STATUS_UNKNOWN_ERROR, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename, state.mNewUri, state.mMimeType);
                            DSUtils.mCurrentThreadNum--;
                            if (Downloads.Impl.isStatusCompleted(Downloads.Impl.STATUS_UNKNOWN_ERROR)) {
                                return;
                            }
                            this.mInfo.mHasActiveThread = false;
                        }
                    } catch (StopRequest e11) {
                        e = e11;
                        downloadProxyHttpClient = null;
                    } catch (Throwable th3) {
                        th = th3;
                        downloadProxyHttpClient = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (wakeLock != null) {
                        wakeLock.release();
                    }
                    if (iProxyHttpClient != null) {
                        iProxyHttpClient.close();
                    }
                    cleanupDestination(state, i);
                    ContentValues contentValues4 = new ContentValues();
                    if (state.mDownloadMod > 0) {
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            jSONObject4.put(IDownloadApp.Impl.get().getNovelSegmentStatus(), IDownloadApp.Impl.get().getNovelStatusDownloadEnd());
                            jSONObject4.put(IDownloadApp.Impl.get().getNovelStatusTimestamp(), System.currentTimeMillis());
                        } catch (JSONException e12) {
                            e12.printStackTrace();
                        }
                        contentValues4.put("extra_info", jSONObject4.toString());
                        String str5 = state.mBoundary;
                        if (str5 != null && !str5.isEmpty()) {
                            contentValues4.put(Downloads.Impl.COLUMN_BOUNDARY, state.mBoundary);
                        }
                        contentValues4.put(Downloads.Impl.COLUMN_DOWNLOAD_MOD, Integer.valueOf(state.mDownloadMod));
                    }
                    try {
                        this.mContext.getContentResolver().update(this.mInfo.getAllDownloadsUri(), contentValues4, null, null);
                    } catch (Exception e13) {
                        e13.printStackTrace();
                    }
                    handleDownloadStatistic(i, state, "");
                    notifyDownloadCompleted(i, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename, state.mNewUri, state.mMimeType);
                    DSUtils.mCurrentThreadNum--;
                    if (!Downloads.Impl.isStatusCompleted(i)) {
                        this.mInfo.mHasActiveThread = false;
                    }
                    throw th;
                }
            } catch (StopRequest e14) {
                e = e14;
                wakeLock2 = null;
                downloadProxyHttpClient = null;
            } catch (Throwable th5) {
                th = th5;
                wakeLock2 = null;
                downloadProxyHttpClient = null;
            }
            this.mInfo.mHasActiveThread = false;
        } catch (Throwable th6) {
            th = th6;
            i = 100;
        }
    }
}
