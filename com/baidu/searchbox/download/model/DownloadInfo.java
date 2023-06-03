package com.baidu.searchbox.download.model;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.component.SizeLimitActivity;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.downloads.DSUtils;
import com.baidu.searchbox.downloads.DownloadThread;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
@SuppressLint({"LogConditional"})
/* loaded from: classes3.dex */
public final class DownloadInfo {
    public static final String EXTRA_IS_WIFI_REQUIRED = "isWifiRequired";
    public static final int NETWORK_CANNOT_USE_ROAMING = 5;
    public static final int NETWORK_NO_CONNECTION = 2;
    public static final int NETWORK_OK = 1;
    public static final int NETWORK_RECOMMENDED_UNUSABLE_DUE_TO_SIZE = 4;
    public static final int NETWORK_TYPE_DISALLOWED_BY_REQUESTOR = 6;
    public static final int NETWORK_UNUSABLE_DUE_TO_SIZE = 3;
    public boolean mAllowRoaming;
    public int mAllowedNetworkTypes;
    public String mBusinessId;
    public int mBusinessType;
    public int mBypassRecommendedSizeLimit;
    public String mClass;
    public Context mContext;
    public int mControl;
    public String mCookies;
    public long mCurrentBytes;
    public boolean mDeleted;
    public String mDescription;
    public int mDestination;
    public String mETag;
    public String mExtraInfo;
    public String mExtras;
    public String mFileName;
    public int mFuzz;
    public volatile boolean mHasActiveThread;
    public String mHint;
    public ISystemFacade mISystemFacade;
    public long mId;
    public boolean mIsPublicApi;
    public long mLastMod;
    public String mMediaProviderUri;
    public boolean mMediaScanned;
    public String mMimeType;
    public String mNetdiskUploadInfo;
    public boolean mNoIntegrity;
    public int mNumFailed;
    public String mPackage;
    public int mProgress;
    public long mRangeEndByte;
    public long mRangeStartByte;
    public String mRangeValue;
    public int mRedirectCount;
    public String mReferer;
    public List<Pair<String, String>> mRequestHeaders;
    public int mRetryAfter;
    public int mStatus;
    public String mTitle;
    public long mTotalBytes;
    public String mUri;
    public String mUserAgent;
    public int mVisibility;

    private int translateNetworkTypeToApiFlag(int i) {
        if (i != 0) {
            return i != 1 ? 0 : 2;
        }
        return 1;
    }

    public String getLogMessageForNetworkError(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "unknown error with network connectivity" : "download was requested to not use the current network type" : "download cannot use the current network connection because it is roaming" : "download size exceeds recommended limit for mobile network" : "download size exceeds limit for mobile network" : "no network connection available";
    }

    /* loaded from: classes3.dex */
    public static class Reader {
        public Cursor mCursor;
        public CharArrayBuffer mNewChars;
        public CharArrayBuffer mOldChars;
        public ContentResolver mResolver;

        public Reader(ContentResolver contentResolver, Cursor cursor) {
            this.mResolver = contentResolver;
            this.mCursor = cursor;
        }

        public DownloadInfo newDownloadInfo(Context context, ISystemFacade iSystemFacade) {
            DownloadInfo downloadInfo = new DownloadInfo(context, iSystemFacade);
            updateFromDatabase(downloadInfo);
            readRequestHeaders(downloadInfo);
            return downloadInfo;
        }

        private void addHeader(DownloadInfo downloadInfo, String str, String str2) {
            downloadInfo.mRequestHeaders.add(Pair.create(str, str2));
        }

        private Integer getInt(String str) {
            Cursor cursor = this.mCursor;
            return Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(str)));
        }

        private Long getLong(String str) {
            Cursor cursor = this.mCursor;
            return Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(str)));
        }

        private String getString(String str, String str2) {
            int columnIndexOrThrow = this.mCursor.getColumnIndexOrThrow(str2);
            if (str == null) {
                return this.mCursor.getString(columnIndexOrThrow);
            }
            if (this.mNewChars == null) {
                this.mNewChars = new CharArrayBuffer(128);
            }
            this.mCursor.copyStringToBuffer(columnIndexOrThrow, this.mNewChars);
            int i = this.mNewChars.sizeCopied;
            if (i != str.length()) {
                return new String(this.mNewChars.data, 0, i);
            }
            CharArrayBuffer charArrayBuffer = this.mOldChars;
            if (charArrayBuffer == null || charArrayBuffer.sizeCopied < i) {
                this.mOldChars = new CharArrayBuffer(i);
            }
            char[] cArr = this.mOldChars.data;
            char[] cArr2 = this.mNewChars.data;
            str.getChars(0, i, cArr, 0);
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (cArr[i2] != cArr2[i2]) {
                    return new String(cArr2, 0, i);
                }
            }
            return str;
        }

        private void readRequestHeaders(DownloadInfo downloadInfo) {
            downloadInfo.mRequestHeaders.clear();
            Cursor cursor = null;
            try {
                try {
                    cursor = this.mResolver.query(Uri.withAppendedPath(downloadInfo.getAllDownloadsUri(), Downloads.Impl.RequestHeaders.URI_SEGMENT), null, null, null, null);
                    if (cursor != null) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("header");
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("value");
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            addHeader(downloadInfo, cursor.getString(columnIndexOrThrow), cursor.getString(columnIndexOrThrow2));
                            cursor.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Closeables.closeSafely(cursor);
                String str = downloadInfo.mCookies;
                if (str != null) {
                    addHeader(downloadInfo, "Cookie", str);
                }
                String str2 = downloadInfo.mReferer;
                if (str2 != null) {
                    addHeader(downloadInfo, "Referer", str2);
                }
            } catch (Throwable th) {
                Closeables.closeSafely(cursor);
                throw th;
            }
        }

        public void updateFromDatabase(DownloadInfo downloadInfo) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            synchronized (downloadInfo) {
                downloadInfo.mId = getLong("_id").longValue();
                downloadInfo.mUri = getString(downloadInfo.mUri, "uri");
                boolean z5 = false;
                if (getInt("no_integrity").intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                downloadInfo.mNoIntegrity = z;
                downloadInfo.mHint = getString(downloadInfo.mHint, "hint");
                downloadInfo.mFileName = getString(downloadInfo.mFileName, "_data");
                downloadInfo.mMimeType = getString(downloadInfo.mMimeType, "mimetype");
                downloadInfo.mDestination = getInt("destination").intValue();
                downloadInfo.mVisibility = getInt("visibility").intValue();
                downloadInfo.mStatus = getInt("status").intValue();
                downloadInfo.mNumFailed = getInt(Constants.FAILED_CONNECTIONS).intValue();
                int intValue = getInt("method").intValue();
                downloadInfo.mRetryAfter = 268435455 & intValue;
                downloadInfo.mRedirectCount = intValue >> 28;
                downloadInfo.mLastMod = getLong("lastmod").longValue();
                downloadInfo.mPackage = getString(downloadInfo.mPackage, "notificationpackage");
                downloadInfo.mClass = getString(downloadInfo.mClass, "notificationclass");
                downloadInfo.mExtras = getString(downloadInfo.mExtras, "notificationextras");
                downloadInfo.mExtraInfo = getString(downloadInfo.mExtraInfo, "extra_info");
                downloadInfo.mCookies = getString(downloadInfo.mCookies, "cookiedata");
                downloadInfo.mUserAgent = getString(downloadInfo.mUserAgent, "useragent");
                downloadInfo.mReferer = getString(downloadInfo.mReferer, "referer");
                downloadInfo.mTotalBytes = getLong("total_bytes").longValue();
                downloadInfo.mCurrentBytes = getLong("current_bytes").longValue();
                downloadInfo.mETag = getString(downloadInfo.mETag, "etag");
                if (getInt(Constants.MEDIA_SCANNED).intValue() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                downloadInfo.mMediaScanned = z2;
                if (getInt("deleted").intValue() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                downloadInfo.mDeleted = z3;
                downloadInfo.mMediaProviderUri = getString(downloadInfo.mMediaProviderUri, "mediaprovider_uri");
                if (getInt(Downloads.Impl.COLUMN_IS_PUBLIC_API).intValue() != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                downloadInfo.mIsPublicApi = z4;
                downloadInfo.mAllowedNetworkTypes = getInt(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES).intValue();
                if (getInt(Downloads.Impl.COLUMN_ALLOW_ROAMING).intValue() != 0) {
                    z5 = true;
                }
                downloadInfo.mAllowRoaming = z5;
                downloadInfo.mTitle = getString(downloadInfo.mTitle, "title");
                downloadInfo.mDescription = getString(downloadInfo.mDescription, "description");
                downloadInfo.mBypassRecommendedSizeLimit = getInt(Downloads.Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT).intValue();
                downloadInfo.mControl = getInt("control").intValue();
                downloadInfo.mRangeStartByte = getLong(Downloads.Impl.COLUMN_RANGE_START_BYTE).longValue();
                downloadInfo.mRangeEndByte = getLong(Downloads.Impl.COLUMN_RANGE_END_BYTE).longValue();
                downloadInfo.mRangeValue = getString(downloadInfo.mRangeValue, Downloads.Impl.COLUMN_RANGE);
                downloadInfo.mBusinessType = getInt("business_type").intValue();
                downloadInfo.mBusinessId = getString(downloadInfo.mBusinessId, "business_id");
                downloadInfo.mProgress = getInt("progress").intValue();
                downloadInfo.mNetdiskUploadInfo = getString(downloadInfo.mNetdiskUploadInfo, Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO);
            }
        }
    }

    public DownloadInfo(Context context, ISystemFacade iSystemFacade) {
        this.mRangeStartByte = 0L;
        this.mRangeEndByte = -1L;
        this.mRequestHeaders = new ArrayList();
        this.mContext = context;
        this.mISystemFacade = iSystemFacade;
        this.mFuzz = new Random(SystemClock.uptimeMillis()).nextInt(1001);
    }

    private int checkIsNetworkTypeAllowed(int i) {
        if (this.mIsPublicApi && (translateNetworkTypeToApiFlag(i) & this.mAllowedNetworkTypes) == 0) {
            return 6;
        }
        return checkSizeAllowedForNetwork(i);
    }

    public long nextAction(long j) {
        if (Downloads.Impl.isStatusCompleted(this.mStatus)) {
            return -1L;
        }
        if (this.mStatus != 194) {
            return 0L;
        }
        long restartTime = restartTime(j);
        if (restartTime <= j) {
            return 0L;
        }
        return restartTime - j;
    }

    public void notifyPauseDueToSize(boolean z) {
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
        intent.setData(getAllDownloadsUri());
        intent.setClassName(this.mContext.getPackageName(), SizeLimitActivity.class.getName());
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra(EXTRA_IS_WIFI_REQUIRED, z);
        this.mContext.startActivity(intent);
    }

    public long restartTime(long j) {
        if (this.mNumFailed == 0) {
            return j;
        }
        int i = this.mRetryAfter;
        if (i > 0) {
            return this.mLastMod + i;
        }
        return this.mLastMod + 10000;
    }

    public void updateStatus(int i) {
        if (this.mStatus != i) {
            this.mStatus = i;
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(this.mStatus));
            this.mContext.getContentResolver().update(getAllDownloadsUri(), contentValues, null, null);
        }
    }

    private int checkSizeAllowedForNetwork(int i) {
        Long recommendedMaxBytesOverMobile;
        if (this.mTotalBytes <= 0 || i == 1) {
            return 1;
        }
        Long maxBytesOverMobile = this.mISystemFacade.getMaxBytesOverMobile();
        if (maxBytesOverMobile != null && this.mTotalBytes > maxBytesOverMobile.longValue()) {
            return 3;
        }
        if (this.mBypassRecommendedSizeLimit != 0 || (recommendedMaxBytesOverMobile = this.mISystemFacade.getRecommendedMaxBytesOverMobile()) == null || this.mTotalBytes <= recommendedMaxBytesOverMobile.longValue()) {
            return 1;
        }
        return 4;
    }

    private boolean isReadyToStart(long j) {
        if (this.mControl == 1) {
            return false;
        }
        int i = this.mStatus;
        if (i == 0 || i == 190 || i == 192) {
            return true;
        }
        switch (i) {
            case 194:
                if (restartTime(j) > j) {
                    return false;
                }
                return true;
            case 195:
            case 196:
                if (checkCanUseNetwork() != 1) {
                    return false;
                }
                return true;
            default:
                if (Downloads.Impl.isStatusCompleted(i) && this.mHasActiveThread) {
                    this.mHasActiveThread = false;
                }
                return false;
        }
    }

    private boolean isRoamingAllowed() {
        if (this.mIsPublicApi) {
            return this.mAllowRoaming;
        }
        if (this.mDestination != 3) {
            return true;
        }
        return false;
    }

    public int checkCanUseNetwork() {
        Integer activeNetworkType = this.mISystemFacade.getActiveNetworkType();
        if (activeNetworkType == null) {
            return 2;
        }
        if (!isRoamingAllowed() && this.mISystemFacade.isNetworkRoaming()) {
            return 5;
        }
        return checkIsNetworkTypeAllowed(activeNetworkType.intValue());
    }

    public Uri getAllDownloadsUri() {
        return ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, this.mId);
    }

    public Collection<Pair<String, String>> getHeaders() {
        return Collections.unmodifiableList(this.mRequestHeaders);
    }

    public Uri getMyDownloadsUri() {
        return ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, this.mId);
    }

    public boolean hasCompletionNotification() {
        if (!Downloads.Impl.isStatusCompleted(this.mStatus) || this.mVisibility != 1) {
            return false;
        }
        return true;
    }

    public boolean isOnCache() {
        int i = this.mDestination;
        if (i == 1 || i == 3 || i == 2) {
            return true;
        }
        return false;
    }

    public boolean shouldScanFile() {
        if (!this.mMediaScanned && !DownloadHelper.isStoragePrivatePath(this.mFileName) && Downloads.Impl.isStatusSuccess(this.mStatus) && !Constants.MIMETYPE_DRM_MESSAGE.equalsIgnoreCase(this.mMimeType)) {
            return true;
        }
        return false;
    }

    public void logVerboseInfo() {
        Log.v("DownloadManager", "Service adding new entry");
        Log.v("DownloadManager", "ID      : " + this.mId);
        Log.v("DownloadManager", "URI     : " + this.mUri);
        Log.v("DownloadManager", "NO_INTEG: " + this.mNoIntegrity);
        Log.v("DownloadManager", "HINT    : " + this.mHint);
        Log.v("DownloadManager", "FILENAME: " + this.mFileName);
        Log.v("DownloadManager", "MIMETYPE: " + this.mMimeType);
        Log.v("DownloadManager", "DESTINAT: " + this.mDestination);
        Log.v("DownloadManager", "VISIBILI: " + this.mVisibility);
        Log.v("DownloadManager", "CONTROL : " + this.mControl);
        Log.v("DownloadManager", "STATUS  : " + this.mStatus);
        Log.v("DownloadManager", "FAILED_C: " + this.mNumFailed);
        Log.v("DownloadManager", "RETRY_AF: " + this.mRetryAfter);
        Log.v("DownloadManager", "REDIRECT: " + this.mRedirectCount);
        Log.v("DownloadManager", "LAST_MOD: " + this.mLastMod);
        Log.v("DownloadManager", "PACKAGE : " + this.mPackage);
        Log.v("DownloadManager", "CLASS   : " + this.mClass);
        Log.v("DownloadManager", "COOKIES : " + this.mCookies);
        Log.v("DownloadManager", "AGENT   : " + this.mUserAgent);
        Log.v("DownloadManager", "REFERER : " + this.mReferer);
        Log.v("DownloadManager", "TOTAL   : " + this.mTotalBytes);
        Log.v("DownloadManager", "CURRENT : " + this.mCurrentBytes);
        Log.v("DownloadManager", "ETAG    : " + this.mETag);
        Log.v("DownloadManager", "SCANNED : " + this.mMediaScanned);
        Log.v("DownloadManager", "DELETED : " + this.mDeleted);
        Log.v("DownloadManager", "MEDIAPROVIDER_URI : " + this.mMediaProviderUri);
        Log.v("DownloadManager", "mAllowedNetworkTypes : " + this.mAllowedNetworkTypes);
        Log.v("DownloadManager", "mExtraInfo : " + this.mExtraInfo);
    }

    public void sendIntentIfRequested() {
        Intent intent;
        if (this.mPackage == null) {
            return;
        }
        if (this.mIsPublicApi) {
            intent = new Intent(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
            intent.setPackage(this.mPackage);
            intent.putExtra(DownloadManager.EXTRA_DOWNLOAD_ID, this.mId);
        } else if (this.mClass == null) {
            return;
        } else {
            intent = new Intent(Downloads.Impl.ACTION_DOWNLOAD_COMPLETED);
            intent.setClassName(this.mPackage, this.mClass);
            String str = this.mExtras;
            if (str != null) {
                intent.putExtra("notificationextras", str);
            }
            intent.setData(getMyDownloadsUri());
        }
        this.mISystemFacade.sendBroadcast(intent);
    }

    public void startIfReady(long j) {
        if (this.mBusinessType != 0) {
            return;
        }
        int i = DSUtils.mCurrentThreadNum;
        if (isReadyToStart(j) && i <= 2) {
            updateStatus(192);
            if (this.mHasActiveThread) {
                return;
            }
            if (Constants.LOGV) {
                Log.v("DownloadManager", "Service spawning thread to handle download " + this.mId);
            }
            if (Constants.LOGV) {
                Log.i("DownloadManager", "startIfReady() set status: STATUS_RUNNING");
            }
            DownloadThread downloadThread = new DownloadThread(this.mContext, this.mISystemFacade, this);
            this.mHasActiveThread = true;
            DSUtils.mCurrentThreadNum = i + 1;
            this.mISystemFacade.startThread(downloadThread);
        }
    }

    @NonNull
    public String toString() {
        return "DownloadInfo detail - [ mId=" + this.mId + ", mUri=" + this.mUri + ", mNoIntegrity=" + this.mNoIntegrity + ", mHint=" + this.mHint + ", mFileName=" + this.mFileName + ", mMimeType=" + this.mMimeType + ", mMimeType=" + this.mMimeType + ", mDestination = " + this.mDestination + ", mVisibility=" + this.mVisibility + ", mControl=" + this.mControl + ", mStatus=" + this.mStatus + ", mNumFailed=" + this.mNumFailed + ", mRetryAfter=" + this.mRetryAfter + ", mRedirectCount=" + this.mRedirectCount + ", mLastMod=" + this.mLastMod + ", mPackage=" + this.mPackage + ", mClass=" + this.mClass + ", mExtras=" + this.mExtras + ", mExtraInfo=" + this.mExtraInfo + ", mCookies=" + this.mCookies + ", mUserAgent=" + this.mUserAgent + ", mReferer=" + this.mReferer + ", mTotalBytes=" + this.mTotalBytes + ", mCurrentBytes=" + this.mCurrentBytes + ", mETag=" + this.mETag + ", mMediaScanned=" + this.mMediaScanned + ", mDeleted=" + this.mDeleted + ", mMediaProviderUri=" + this.mMediaProviderUri + ", mIsPublicApi=" + this.mIsPublicApi + ", mAllowedNetworkTypes=" + this.mAllowedNetworkTypes + ", mAllowRoaming=" + this.mAllowRoaming + ", mTitle=" + this.mTitle + ", mDescription=" + this.mDescription + ", mBypassRecommendedSizeLimit=" + this.mBypassRecommendedSizeLimit + ", mRangeStartByte=" + this.mRangeStartByte + ", mRangeEndByte=" + this.mRangeEndByte + ", mRangeValue=" + this.mRangeValue + ", mBusinessType=" + this.mBusinessType + ", mProgress=" + this.mProgress + ", mNetdiskUploadInfo=" + this.mNetdiskUploadInfo + ", mFuzz=" + this.mFuzz + ", mHasActiveThread=" + this.mHasActiveThread + " ]";
    }
}
