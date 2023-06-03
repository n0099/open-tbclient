package com.baidu.searchbox.downloads;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.OpenDownloadReceiver;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.business.util.DownloadUtils;
import com.baidu.searchbox.download.callback.IDownloadServiceCallback;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.component.DownloadReceiver;
import com.baidu.searchbox.download.component.RealSystemFacade;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.DownloadInfo;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.downloads.DownloadManagerContentObserver;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class DownloadService {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int MSG_UPDATE_FROM_PROVIDER = 1;
    public static final String TAG = "DownloadService";
    public static final long WAIT_TIMEOUT = 10000;
    @SuppressLint({"StaticFieldLeak"})
    public static DownloadService sInstance;
    public ISystemFacade mISystemFacade;
    public boolean mMediaScannerConnecting;
    public MyMediaScannerConnection mMediaScannerConnection;
    public MyMediaScannerConnectionClient mMediaScannerConnectionClient;
    public Object mMediaScannerService;
    public boolean mNotificationStopped;
    public DownloadNotification mNotifier;
    public DownloadManagerContentObserver mObserver;
    public volatile boolean mPendingUpdate;
    public HandlerThread mUpdateHandlerThread;
    public UpdateHandler mUpdateThreadHandler;
    public Map<Long, DownloadInfo> mDownloads = new HashMap();
    public AtomicBoolean mIsUpdating = new AtomicBoolean(false);
    public BroadcastReceiver mNotificationReceiver = new BroadcastReceiver() { // from class: com.baidu.searchbox.downloads.DownloadService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadInfo[] downloadInfoArr;
            String action = intent.getAction();
            if (!action.equals(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION)) {
                if (!action.equals(DownloadConstants.ACTION_DOWNLOAD_START_NOTIFICATION)) {
                    return;
                }
                DownloadService.this.mNotificationStopped = false;
                return;
            }
            DownloadService.this.mNotificationStopped = true;
            DownloadService downloadService = DownloadService.this;
            if (downloadService.mISystemFacade == null) {
                downloadService.mISystemFacade = new RealSystemFacade(context);
            }
            synchronized (DownloadService.this.mDownloads) {
                Collection values = DownloadService.this.mDownloads.values();
                downloadInfoArr = (DownloadInfo[]) values.toArray(new DownloadInfo[values.size()]);
            }
            for (DownloadInfo downloadInfo : downloadInfoArr) {
                if (downloadInfo != null && downloadInfo.mStatus != 200) {
                    DownloadService.this.mISystemFacade.cancelNotification(downloadInfo.mId);
                }
            }
        }
    };
    public Context mContext = AppRuntime.getAppContext();

    /* loaded from: classes3.dex */
    public interface OnScanCompletedListener {
        void onScanCompleted(String str, Uri uri);
    }

    /* loaded from: classes3.dex */
    public class MyMediaScannerConnection extends MediaScannerConnection {
        public MyMediaScannerConnection(Context context, MediaScannerConnection.MediaScannerConnectionClient mediaScannerConnectionClient) {
            super(context, mediaScannerConnectionClient);
        }

        public void disconnectMediaScanner() {
            DownloadService downloadService;
            synchronized (DownloadService.this) {
                DownloadService.this.mMediaScannerConnecting = false;
                if (DownloadService.this.mMediaScannerService != null) {
                    DownloadService.this.mMediaScannerService = null;
                    if (Constants.LOGVV) {
                        Log.v("DownloadManager", "Disconnecting from Media Scanner");
                    }
                    try {
                        disconnect();
                        downloadService = DownloadService.this;
                    } catch (IllegalArgumentException e) {
                        Log.w("DownloadManager", "unbindService failed: " + e);
                        downloadService = DownloadService.this;
                    }
                    downloadService.notifyAll();
                }
            }
        }

        @Override // android.media.MediaScannerConnection, android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            super.onServiceConnected(componentName, iBinder);
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "Connected to Media Scanner");
            }
            synchronized (DownloadService.this) {
                DownloadService.this.mMediaScannerConnecting = false;
                DownloadService.this.mMediaScannerService = this;
                if (DownloadService.this.mMediaScannerService != null) {
                    DownloadService.this.updateFromProvider();
                }
                DownloadService.this.notifyAll();
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.media.MediaScannerConnection, android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            super.onServiceDisconnected(componentName);
            try {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "Disconnected from Media Scanner");
                }
                synchronized (DownloadService.this) {
                    DownloadService.this.mMediaScannerService = null;
                    DownloadService.this.mMediaScannerConnecting = false;
                    DownloadService.this.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (DownloadService.this) {
                    DownloadService.this.mMediaScannerService = null;
                    DownloadService.this.mMediaScannerConnecting = false;
                    DownloadService.this.notifyAll();
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class UpdateHandler extends Handler {
        public UpdateHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00de A[LOOP:2: B:42:0x00d8->B:44:0x00de, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0157  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void doUpdate() {
            Cursor cursor;
            boolean z;
            DownloadService.this.mIsUpdating.set(true);
            DownloadService.this.trimDatabase();
            DownloadService.this.removeSpuriousFiles();
            do {
                synchronized (DownloadService.this) {
                    DownloadService.this.mPendingUpdate = false;
                }
                long currentTimeMillis = DownloadService.this.mISystemFacade.currentTimeMillis();
                long j = Long.MAX_VALUE;
                HashSet<Long> hashSet = new HashSet(DownloadService.this.mDownloads.keySet());
                Cursor cursor2 = null;
                try {
                    cursor = DownloadService.this.mContext.getContentResolver().query(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, null, null, null, null);
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                }
                if (cursor == null) {
                    Closeables.closeSafely(cursor);
                    return;
                }
                try {
                    try {
                        DownloadInfo.Reader reader = new DownloadInfo.Reader(DownloadService.this.mContext.getContentResolver(), cursor);
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                        cursor.moveToFirst();
                        z = false;
                        while (!cursor.isAfterLast()) {
                            try {
                                long j2 = cursor.getLong(columnIndexOrThrow);
                                hashSet.remove(Long.valueOf(j2));
                                DownloadInfo downloadInfo = (DownloadInfo) DownloadService.this.mDownloads.get(Long.valueOf(j2));
                                if (downloadInfo != null) {
                                    DownloadService.this.updateDownload(reader, downloadInfo, currentTimeMillis);
                                } else {
                                    downloadInfo = DownloadService.this.insertDownload(reader, currentTimeMillis);
                                }
                                if (downloadInfo.shouldScanFile() && !DownloadService.this.scanFile(downloadInfo, true, false)) {
                                    z = true;
                                }
                                downloadInfo.hasCompletionNotification();
                                long nextAction = downloadInfo.nextAction(currentTimeMillis);
                                int i = (nextAction > 0L ? 1 : (nextAction == 0L ? 0 : -1));
                                if (i != 0 && i > 0 && nextAction < j) {
                                    j = nextAction;
                                }
                                cursor.moveToNext();
                            } catch (Exception unused2) {
                            }
                        }
                    } catch (Exception unused3) {
                        z = false;
                        Closeables.closeSafely(cursor);
                        while (r0.hasNext()) {
                        }
                        if (!z) {
                        }
                        if (!DownloadService.this.mNotificationStopped) {
                        }
                        if (!z) {
                        }
                        while (r0.hasNext()) {
                        }
                        if (!DownloadService.this.mPendingUpdate) {
                            DownloadService.this.mIsUpdating.set(false);
                        }
                    }
                    Closeables.closeSafely(cursor);
                    for (Long l : hashSet) {
                        DownloadService.this.deleteDownload(l.longValue());
                    }
                    if (!z) {
                        Iterator it = DownloadService.this.mDownloads.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            DownloadInfo downloadInfo2 = (DownloadInfo) it.next();
                            if (downloadInfo2.mDeleted && TextUtils.isEmpty(downloadInfo2.mMediaProviderUri)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (!DownloadService.this.mNotificationStopped) {
                        DownloadService.this.mNotifier.updateNotification(DownloadService.this.mDownloads.values());
                    }
                    if (!z) {
                        DownloadService.this.bindMediaScanner();
                    } else {
                        DownloadService.this.mMediaScannerConnection.disconnectMediaScanner();
                    }
                    for (DownloadInfo downloadInfo3 : DownloadService.this.mDownloads.values()) {
                        if (downloadInfo3.mDeleted) {
                            if (TextUtils.isEmpty(downloadInfo3.mMediaProviderUri)) {
                                if (!downloadInfo3.shouldScanFile()) {
                                    DownloadHelper.deleteFile(DownloadService.this.mContext.getContentResolver(), downloadInfo3.mId, downloadInfo3.mFileName, downloadInfo3.mMimeType, downloadInfo3.mVisibility);
                                } else {
                                    DownloadService.this.scanFile(downloadInfo3, false, true);
                                }
                            } else {
                                DownloadMediaHelper.deleteFromMediaProvider(DownloadService.this.mContext, Uri.parse(downloadInfo3.mMediaProviderUri), null, null);
                                DownloadHelper.deleteFile(DownloadService.this.mContext.getContentResolver(), downloadInfo3.mId, downloadInfo3.mFileName, downloadInfo3.mMimeType, downloadInfo3.mVisibility);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    Closeables.closeSafely(cursor2);
                    throw th;
                }
            } while (!DownloadService.this.mPendingUpdate);
            DownloadService.this.mIsUpdating.set(false);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                doUpdate();
            }
        }
    }

    public DownloadService() {
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindMediaScanner() {
        synchronized (this) {
            try {
                if (!this.mMediaScannerConnecting) {
                    this.mMediaScannerConnecting = true;
                    this.mMediaScannerConnection.connect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static DownloadService getInstance() {
        if (sInstance == null) {
            synchronized (DownloadManagerExt.class) {
                if (sInstance == null) {
                    sInstance = new DownloadService();
                }
            }
        }
        return sInstance;
    }

    private void registerDownloadedReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION);
        intentFilter.addAction(DownloadConstants.ACTION_DOWNLOAD_START_NOTIFICATION);
        DownloadUtils.safeRegisterReceiver(this.mContext, this.mNotificationReceiver, intentFilter);
    }

    private void registerNotificationReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION);
        intentFilter.addAction(DownloadConstants.ACTION_DOWNLOAD_START_NOTIFICATION);
        intentFilter.addAction(DownloadConstants.ACTION_DOWNLOAD_COMPLETE);
        DownloadUtils.safeRegisterReceiver(this.mContext, this.mNotificationReceiver, intentFilter);
    }

    private void unregisterNotificationReceiver() {
        DownloadUtils.safeUnRegisterReceiver(this.mContext, this.mNotificationReceiver);
    }

    public void finalize() throws Throwable {
        this.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "Service onDestroy");
        }
        unregisterNotificationReceiver();
        this.mMediaScannerConnection.disconnectMediaScanner();
        if (DEBUG) {
            Log.e(TAG, "DownloadService finalize()");
        }
        super.finalize();
    }

    public void start() {
        updateFromProvider();
    }

    /* loaded from: classes3.dex */
    public static class MyMediaScannerConnectionClient implements MediaScannerConnection.MediaScannerConnectionClient {
        public OnScanCompletedListener listener;

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            OnScanCompletedListener onScanCompletedListener = this.listener;
            if (onScanCompletedListener != null) {
                onScanCompletedListener.onScanCompleted(str, uri);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownload(DownloadInfo.Reader reader, DownloadInfo downloadInfo, long j) {
        int i = downloadInfo.mVisibility;
        int i2 = downloadInfo.mStatus;
        reader.updateFromDatabase(downloadInfo);
        boolean z = true;
        if (i == 1 && downloadInfo.mVisibility != 1) {
            Downloads.Impl.isStatusCompleted(downloadInfo.mStatus);
        }
        if ((Downloads.Impl.isStatusCompleted(i2) || !Downloads.Impl.isStatusCompleted(downloadInfo.mStatus)) ? false : false) {
            this.mISystemFacade.cancelNotification(downloadInfo.mId);
        }
        downloadInfo.startIfReady(j);
    }

    private void dealComponetsDisabled() {
        PackageManager packageManager = this.mContext.getPackageManager();
        if (!IDownloadApp.Impl.get().isComponentEnable(this.mContext, DownloadReceiver.class.getName())) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "enable the disabled downloadreceiver");
            }
            packageManager.setComponentEnabledSetting(new ComponentName(this.mContext.getPackageName(), DownloadReceiver.class.getName()), 1, 1);
        }
        if (!IDownloadApp.Impl.get().isComponentEnable(this.mContext, OpenDownloadReceiver.class.getName())) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "enable the disabled OpenDownloadReceiver");
            }
            packageManager.setComponentEnabledSetting(new ComponentName(this.mContext.getPackageName(), OpenDownloadReceiver.class.getName()), 1, 1);
        }
    }

    public void init() {
        if (DEBUG) {
            Log.e(TAG, "DownloadService init()");
        }
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "Service onCreate");
        }
        dealComponetsDisabled();
        Context context = this.mContext;
        if (context instanceof IDownloadServiceCallback) {
            ((IDownloadServiceCallback) context).onDownloadServiceCreate();
        }
        if (this.mISystemFacade == null) {
            this.mISystemFacade = new RealSystemFacade(this.mContext);
        }
        DownloadManagerContentObserver downloadManagerContentObserver = new DownloadManagerContentObserver();
        this.mObserver = downloadManagerContentObserver;
        downloadManagerContentObserver.setChange(new DownloadManagerContentObserver.ChangeProxy() { // from class: com.baidu.searchbox.downloads.DownloadService.2
            @Override // com.baidu.searchbox.downloads.DownloadManagerContentObserver.ChangeProxy
            public void onChange(boolean z) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "Service ContentObserver received notification");
                }
                DownloadService.this.updateFromProvider();
            }
        });
        this.mContext.getContentResolver().registerContentObserver(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, true, this.mObserver);
        synchronized (this) {
            this.mMediaScannerService = null;
            this.mMediaScannerConnecting = false;
        }
        this.mMediaScannerConnectionClient = new MyMediaScannerConnectionClient();
        this.mMediaScannerConnection = new MyMediaScannerConnection(this.mContext, this.mMediaScannerConnectionClient);
        this.mNotifier = DownloadNotification.getInstance();
        registerNotificationReceiver();
        updateFromProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDownload(long j) {
        String str;
        DownloadInfo downloadInfo = this.mDownloads.get(Long.valueOf(j));
        if (downloadInfo.shouldScanFile()) {
            scanFile(downloadInfo, false, false);
        }
        if (downloadInfo.mStatus == 192) {
            downloadInfo.mStatus = 490;
        }
        int i = downloadInfo.mDestination;
        if (i != 0 && i != 5 && (str = downloadInfo.mFileName) != null) {
            try {
                if (!DownloadMediaHelper.deleteMediaFile(this.mContext, str, downloadInfo.mMimeType) && DEBUG) {
                    Log.w("DownloadManager", "deleteDownload delete file failed");
                }
            } catch (Exception e) {
                if (DEBUG) {
                    throw new DebugException(TAG, e);
                }
            }
        }
        this.mISystemFacade.cancelNotification(downloadInfo.mId);
        synchronized (this.mDownloads) {
            this.mDownloads.remove(Long.valueOf(downloadInfo.mId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadInfo insertDownload(DownloadInfo.Reader reader, long j) {
        String str;
        DownloadInfo newDownloadInfo = reader.newDownloadInfo(this.mContext, this.mISystemFacade);
        synchronized (this.mDownloads) {
            this.mDownloads.put(Long.valueOf(newDownloadInfo.mId), newDownloadInfo);
        }
        if (Constants.LOGVV) {
            newDownloadInfo.logVerboseInfo();
        }
        if (newDownloadInfo.mStatus == 192 && (str = newDownloadInfo.mRangeValue) != null && !str.isEmpty()) {
            if (newDownloadInfo.mId < 0 && DEBUG) {
                Log.w("DownloadManager", "deleteDownload delete file failed");
            }
            IDownloadApp.Impl.get().cancelDownload(newDownloadInfo.mId);
            newDownloadInfo.mDeleted = true;
        } else {
            newDownloadInfo.startIfReady(j);
        }
        return newDownloadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSpuriousFiles() {
        File[] listFiles = Environment.getDownloadCacheDirectory().listFiles();
        if (listFiles == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < listFiles.length; i++) {
            if (!listFiles[i].getName().equals(Constants.KNOWN_SPURIOUS_FILENAME) && !listFiles[i].getName().equalsIgnoreCase(Constants.RECOVERY_DIRECTORY)) {
                hashSet.add(listFiles[i].getPath());
            }
        }
        Cursor query = this.mContext.getContentResolver().query(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, new String[]{"_data"}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                do {
                    hashSet.remove(query.getString(0));
                } while (query.moveToNext());
                Closeables.closeSafely(query);
            } else {
                Closeables.closeSafely(query);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (Constants.LOGV) {
                Log.v("DownloadManager", "deleting spurious file " + str);
            }
            if (!new File(str).delete() && DEBUG) {
                Log.w("DownloadManager", "removeSpuriousFiles delete file failed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean scanFile(DownloadInfo downloadInfo, final boolean z, final boolean z2) {
        synchronized (this) {
            if (this.mMediaScannerService == null) {
                return false;
            }
            if (Constants.LOGV) {
                Log.v("DownloadManager", "Scanning file " + downloadInfo.mFileName);
            }
            try {
                final Uri allDownloadsUri = downloadInfo.getAllDownloadsUri();
                final String str = downloadInfo.mMimeType;
                final ContentResolver contentResolver = this.mContext.getContentResolver();
                final long j = downloadInfo.mId;
                final boolean z3 = downloadInfo.mMediaScanned;
                final int i = downloadInfo.mVisibility;
                this.mMediaScannerConnectionClient.listener = new OnScanCompletedListener() { // from class: com.baidu.searchbox.downloads.DownloadService.3
                    @Override // com.baidu.searchbox.downloads.DownloadService.OnScanCompletedListener
                    public void onScanCompleted(String str2, Uri uri) {
                        long clearCallingIdentity = Binder.clearCallingIdentity();
                        try {
                            if (z) {
                                boolean z4 = false;
                                ContentValues contentValues = new ContentValues();
                                boolean z5 = true;
                                if (!z3) {
                                    contentValues.put(Constants.MEDIA_SCANNED, (Integer) 1);
                                    z4 = true;
                                }
                                if (uri != null) {
                                    contentValues.put("mediaprovider_uri", uri.toString());
                                } else {
                                    z5 = z4;
                                }
                                if (z5 && DownloadService.this.mContext.getContentResolver().update(allDownloadsUri, contentValues, null, null) == 0 && Constants.LOGV) {
                                    Log.v("DownloadManager", "Scanning file update failed " + allDownloadsUri);
                                }
                            } else if (z2) {
                                if (uri != null) {
                                    DownloadMediaHelper.deleteFromMediaProvider(DownloadService.this.mContext, uri, null, null);
                                }
                                DownloadHelper.deleteFile(contentResolver, j, str2, str, i);
                            }
                            Binder.restoreCallingIdentity(clearCallingIdentity);
                            DownloadService.this.mMediaScannerConnectionClient.listener = null;
                        } catch (Throwable th) {
                            Binder.restoreCallingIdentity(clearCallingIdentity);
                            throw th;
                        }
                    }
                };
                this.mMediaScannerConnection.scanFile(downloadInfo.mFileName, downloadInfo.mMimeType);
                return true;
            } catch (Exception unused) {
                Log.w("DownloadManager", "Failed to scan file " + downloadInfo.mFileName);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimDatabase() {
        Cursor cursor;
        try {
            cursor = this.mContext.getContentResolver().query(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, new String[]{"_id"}, "status >= '200'", null, "lastmod");
        } catch (Exception e) {
            e.printStackTrace();
            cursor = null;
        }
        if (cursor == null) {
            if (DEBUG) {
                Log.e("DownloadManager", "null cursor in trimDatabase");
                return;
            }
            return;
        }
        if (cursor.moveToFirst()) {
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
            for (int count = cursor.getCount() - 21000; count > 0; count--) {
                DownloadMediaHelper.deleteFromMediaProvider(this.mContext, ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, cursor.getLong(columnIndexOrThrow)), null, null);
                if (!cursor.moveToNext()) {
                    break;
                }
            }
        }
        Closeables.closeSafely(cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFromProvider() {
        synchronized (this) {
            this.mPendingUpdate = true;
            if (this.mUpdateHandlerThread == null || !this.mUpdateHandlerThread.isAlive()) {
                HandlerThread handlerThread = new HandlerThread("Download Service", 10);
                this.mUpdateHandlerThread = handlerThread;
                this.mISystemFacade.startThread(handlerThread);
                this.mUpdateThreadHandler = new UpdateHandler(this.mUpdateHandlerThread.getLooper());
            }
        }
        if (!this.mIsUpdating.get()) {
            this.mUpdateThreadHandler.removeMessages(1);
            this.mUpdateThreadHandler.sendMessage(this.mUpdateThreadHandler.obtainMessage(1));
        }
    }
}
