package com.baidu.searchbox.download.manager;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.DownloadCallBack;
import com.baidu.searchbox.download.callback.DownloadListener;
import com.baidu.searchbox.download.component.DownloadProvider;
import com.baidu.searchbox.download.component.RealSystemFacade;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadModel;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ng.browser.explore.model.WebAddress;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.y;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class DownloadManagerExt implements NoProGuard {
    public static final String TAG = "DownloadManagerExt";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static volatile DownloadManagerExt sInstance = null;
    public HashMap<Uri, DownloadObserver> mUriToObserver = new HashMap<>();
    public ContentResolver mResolver = AppRuntime.getAppContext().getContentResolver();
    public String mPackageName = AppRuntime.getAppContext().getPackageName();
    public DownloadManager mDownloadManager = new DownloadManager(this.mResolver, this.mPackageName);

    /* loaded from: classes3.dex */
    public class DownloadObserver extends ContentObserver {
        public long mLastBytes;
        public DownloadState mLastState;
        public long mLastTime;
        public HashSet<DownloadListener> mListeners;
        public DownloadBean mPdb;

        public DownloadObserver(Context context, Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mLastBytes = 0L;
            this.mLastTime = 0L;
            this.mLastState = DownloadState.NOT_START;
            this.mListeners = new HashSet<>();
            this.mPdb = new DownloadBean(uri);
            if (DownloadManagerExt.DEBUG) {
                Log.w(DownloadManagerExt.TAG, "new DownloadObserver(" + uri + SmallTailInfo.EMOTION_SUFFIX);
            }
        }

        public synchronized boolean addListener(DownloadListener downloadListener) {
            return this.mListeners.add(downloadListener);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.DownloadObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadObserver downloadObserver = DownloadObserver.this;
                    DownloadManagerExt.this.queryDownloadData(downloadObserver.mPdb);
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.DownloadObserver.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long currentTimeMillis = System.currentTimeMillis();
                            if ((DownloadObserver.this.mLastState == DownloadObserver.this.mPdb.getDownloadState() && DownloadObserver.this.mLastBytes == DownloadObserver.this.mPdb.getCurrentBytes()) || DownloadObserver.this.mLastTime == currentTimeMillis) {
                                return;
                            }
                            if (DownloadState.DOWNLOADING == DownloadObserver.this.mPdb.getDownloadState()) {
                                DownloadObserver.this.mPdb.setSpeed(((DownloadObserver.this.mPdb.getCurrentBytes() - DownloadObserver.this.mLastBytes) * 1000) / (currentTimeMillis - DownloadObserver.this.mLastTime));
                            } else {
                                DownloadObserver.this.mPdb.setSpeed(0L);
                            }
                            if (DownloadManagerExt.DEBUG) {
                                Log.i(DownloadManagerExt.TAG, "DownloadObserver.onChange(" + DownloadObserver.this.mPdb + SmallTailInfo.EMOTION_SUFFIX);
                            }
                            DownloadObserver downloadObserver2 = DownloadObserver.this;
                            downloadObserver2.mLastBytes = downloadObserver2.mPdb.getCurrentBytes();
                            DownloadObserver downloadObserver3 = DownloadObserver.this;
                            downloadObserver3.mLastState = downloadObserver3.mPdb.getDownloadState();
                            DownloadObserver.this.mLastTime = currentTimeMillis;
                            synchronized (this) {
                                int size = DownloadObserver.this.mListeners.size();
                                DownloadListener[] downloadListenerArr = new DownloadListener[size];
                                DownloadObserver.this.mListeners.toArray(downloadListenerArr);
                                for (int i = 0; i < size; i++) {
                                    DownloadListener downloadListener = downloadListenerArr[i];
                                    if (downloadListener != null) {
                                        downloadListener.onChanged(DownloadObserver.this.mPdb);
                                    }
                                }
                            }
                        }
                    });
                }
            }, "queryDownloadData");
        }

        public synchronized boolean removeListener(DownloadListener downloadListener) {
            return this.mListeners.remove(downloadListener);
        }

        public synchronized void clearListeners() {
            this.mListeners.clear();
        }

        public boolean isListenersEmpty() {
            return this.mListeners.isEmpty();
        }
    }

    public static DownloadManagerExt getInstance() {
        if (sInstance == null) {
            synchronized (DownloadManagerExt.class) {
                if (sInstance == null) {
                    sInstance = new DownloadManagerExt();
                }
            }
        }
        return sInstance;
    }

    @Deprecated
    public Uri doDownload(String str, String str2, String str3) {
        return doDownload(str, str2, str3, false, false, false, false, null);
    }

    public void unregisterObserver(Context context, Uri uri, DownloadListener downloadListener) {
        DownloadObserver downloadObserver;
        if (uri == null || (downloadObserver = this.mUriToObserver.get(uri)) == null) {
            return;
        }
        downloadObserver.removeListener(downloadListener);
        if (downloadObserver.isListenersEmpty()) {
            context.getContentResolver().unregisterContentObserver(downloadObserver);
            this.mUriToObserver.remove(uri);
        }
    }

    public static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public void cancelDownload(long j) {
        if (j <= -1) {
            if (DEBUG) {
                Log.e(TAG, "cancelDownload error params, (id <=-1)");
                return;
            }
            return;
        }
        this.mDownloadManager.remove(j);
    }

    public void deleteDatabaseId(List<Long> list) {
        for (Long l : list) {
            if (l != null) {
                this.mDownloadManager.markRowDeleted(l.longValue());
                this.mDownloadManager.remove(l.longValue());
            }
        }
    }

    public void deleteDownloadFile(long... jArr) {
        deleteDownloadFile(false, null, null, jArr);
    }

    public void doDeleteFileIfExist(String str) {
        if (str != null && !DownloadHelper.isExternalStorageAndNoPermission(str)) {
            File file = new File(str);
            if (file.exists() && !file.delete() && DEBUG) {
                Log.w(TAG, "deleteMediaFile delete file failed");
            }
        }
    }

    public Uri doDownload(String str) {
        return doDownload(str, null, null, false, false, false, false, null);
    }

    public Uri getDownloadUri(long j) {
        return this.mDownloadManager.getDownloadUri(j);
    }

    public long getIdFromUri(Uri uri) {
        if (uri != null) {
            try {
                return ContentUris.parseId(uri);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        } else if (DEBUG) {
            Log.e(TAG, "getIdFromUri(uri == null)");
        }
        return -1L;
    }

    public int markRowDeleted(long... jArr) {
        return this.mDownloadManager.markRowDeleted(jArr);
    }

    public boolean needRequestExternalStorage(long j) {
        return this.mDownloadManager.needRequestExternalStorage(String.valueOf(j));
    }

    public void pauseDownload(long... jArr) {
        this.mDownloadManager.pauseDownload(jArr);
    }

    public DownloadBean queryDownloadData(Uri uri) {
        if (uri == null) {
            return null;
        }
        DownloadBean downloadBean = new DownloadBean(uri);
        queryDownloadData(downloadBean);
        return downloadBean;
    }

    public DownloadBean queryDownloadDataNoTranslator(Uri uri) {
        if (uri == null) {
            return null;
        }
        DownloadBean downloadBean = new DownloadBean(uri);
        queryDownloadDataNoTranslator(downloadBean);
        return downloadBean;
    }

    public void resumeDownload(Uri uri) {
        long idFromUri = getIdFromUri(uri);
        if (-1 == idFromUri) {
            if (DEBUG) {
                Log.e(TAG, "resumeDownload(id == -1)");
                return;
            }
            return;
        }
        this.mDownloadManager.resumeDownload(idFromUri);
    }

    private void deleteDatabaseRecord(HashMap<Long, String> hashMap, long... jArr) {
        this.mDownloadManager.markRowDeleted(jArr);
        if (hashMap != null && hashMap.size() > 0) {
            long[] jArr2 = new long[hashMap.size()];
            int i = 0;
            for (Long l : hashMap.keySet()) {
                jArr2[i] = l.longValue();
                i++;
            }
            this.mDownloadManager.remove(jArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteOneDatabaseRecord(HashMap<Long, String> hashMap, String str) {
        if (!TextUtils.isEmpty(str) && hashMap != null && !hashMap.isEmpty()) {
            for (Long l : hashMap.keySet()) {
                long longValue = l.longValue();
                String str2 = hashMap.get(Long.valueOf(longValue));
                if (str2 != null && str2.contains(str)) {
                    this.mDownloadManager.markRowDeleted(longValue);
                    if (str2.startsWith(DownloadConstants.LOCAL_DATA_URI_PREFIX)) {
                        this.mDownloadManager.remove(longValue);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static String encodePath(String str) {
        boolean z;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c == '[' || c == ']') {
                z = true;
                break;
            }
        }
        z = false;
        if (!z) {
            return str;
        }
        StringBuilder sb = new StringBuilder("");
        for (char c2 : charArray) {
            if (c2 != '[' && c2 != ']') {
                sb.append(c2);
            } else {
                sb.append('%');
                sb.append(Integer.toHexString(c2));
            }
        }
        return sb.toString();
    }

    public void cancelDownload(Uri uri) {
        long idFromUri = getIdFromUri(uri);
        if (-1 == idFromUri) {
            if (DEBUG) {
                Log.e(TAG, "cancelDownload(id == -1)");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.w(TAG, "cancelDownload(uri=" + uri + SmallTailInfo.EMOTION_SUFFIX);
        }
        this.mDownloadManager.remove(idFromUri);
    }

    public void pauseDownload(Uri uri) {
        long idFromUri = getIdFromUri(uri);
        if (-1 == idFromUri) {
            if (DEBUG) {
                Log.e(TAG, "pauseDownload(id=-1)");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.w(TAG, "pauseDownload(uri=" + uri + SmallTailInfo.EMOTION_SUFFIX);
        }
        this.mDownloadManager.pauseDownload(idFromUri);
    }

    private void processUnRead(boolean z, Uri uri) {
        IDownloadApp.Impl.get().processUnRead(z, uri);
    }

    public void deleteDownloadFile(DownloadMediaHelper.CallBack<ArrayList<Long>> callBack, long... jArr) {
        deleteDownloadFile(false, null, callBack, jArr);
    }

    public void deleteFile(String str, boolean z) {
        if (z) {
            if (str != null && !DownloadHelper.isExternalStorageAndNoPermission(str)) {
                deleteDir(new File(str).getParentFile());
                return;
            }
            return;
        }
        doDeleteFileIfExist(str);
    }

    public void resumeDownload(Uri uri, DownloadCallBack downloadCallBack) {
        long idFromUri = getIdFromUri(uri);
        if (-1 == idFromUri) {
            if (DEBUG) {
                Log.e(TAG, "resumeDownload(id == -1)");
            }
            if (downloadCallBack != null) {
                downloadCallBack.onResult(null);
                return;
            }
            return;
        }
        this.mDownloadManager.resumeDownload(downloadCallBack, idFromUri);
    }

    public void unregisterObserver(Context context, Uri uri) {
        DownloadObserver downloadObserver;
        if (uri == null || (downloadObserver = this.mUriToObserver.get(uri)) == null) {
            return;
        }
        downloadObserver.clearListeners();
        context.getContentResolver().unregisterContentObserver(downloadObserver);
        this.mUriToObserver.remove(uri);
    }

    public void cancelDownload(long... jArr) {
        this.mDownloadManager.remove(jArr);
    }

    public void resumeDownload(long... jArr) {
        this.mDownloadManager.resumeDownload(jArr);
    }

    public void cancelDownloadedNotifications() {
        RealSystemFacade realSystemFacade = new RealSystemFacade(AppRuntime.getAppContext());
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDownloadManager.query(new DownloadManager.Query().setFilterByStatus(24).setOnlyIncludeVisibleInDownloadsUi(true));
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
            if (cursor != null && cursor.getCount() != 0) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    realSystemFacade.cancelNotification(cursor.getLong(columnIndexOrThrow));
                    cursor.moveToNext();
                }
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public void deleteDownload(boolean z, long... jArr) {
        Cursor cursor = null;
        if (jArr != null) {
            try {
                try {
                } catch (Exception e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
                if (jArr.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    if (z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        for (int i = 0; i < jArr.length; i++) {
                            if (i > 0) {
                                sb.append("OR ");
                            }
                            sb.append("_id");
                            sb.append(" = ? ");
                        }
                        sb.append(SmallTailInfo.EMOTION_SUFFIX);
                        String[] strArr = new String[jArr.length];
                        for (int i2 = 0; i2 < jArr.length; i2++) {
                            strArr[i2] = Long.toString(jArr[i2]);
                        }
                        cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, sb.toString(), strArr, null);
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            arrayList.add(cursor.getString(cursor.getInt(cursor.getColumnIndex("_data"))));
                            cursor.moveToNext();
                        }
                    }
                    this.mDownloadManager.remove(jArr);
                    if (z) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            String str = (String) arrayList.get(i3);
                            if (str != null) {
                                DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), str, "");
                            }
                        }
                    }
                    IDownloadApp.Impl.get().doSearchBoxDownloadControlDelete(AppRuntime.getApplication(), jArr);
                    Intent intent = new Intent(DownloadConstants.DOWNLOAD_DELETE_ACTION);
                    intent.setPackage(AppRuntime.getAppContext().getPackageName());
                    intent.putExtra(DownloadConstants.DOWNLOAD_DELETE_IDS, jArr);
                    AppRuntime.getAppContext().sendBroadcast(intent);
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteDownloadFile(boolean z, DownloadMediaHelper.CallBack<ArrayList<String>> callBack, final DownloadMediaHelper.CallBack<ArrayList<Long>> callBack2, long... jArr) {
        Cursor cursor;
        if (jArr != null && jArr.length != 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            final HashMap<Long, String> hashMap = new HashMap<>();
            HashMap hashMap2 = new HashMap();
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("_id");
                    sb.append(" in (");
                    for (long j : jArr) {
                        sb.append("'");
                        sb.append(j);
                        sb.append("',");
                    }
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data", "uri", "_id"}, sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX, null, null);
                    try {
                        int columnIndex = cursor.getColumnIndex("_data");
                        int columnIndex2 = cursor.getColumnIndex("uri");
                        int columnIndex3 = cursor.getColumnIndex("_id");
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            String string = cursor.getString(columnIndex);
                            arrayList.add(string);
                            String string2 = cursor.getString(columnIndex2);
                            long j2 = cursor.getLong(columnIndex3);
                            hashMap2.put(string, Long.valueOf(j2));
                            if (!TextUtils.isEmpty(string2) && string2.startsWith(DownloadConstants.LOCAL_DATA_URI_PREFIX)) {
                                hashMap.put(Long.valueOf(j2), string2);
                            } else if (DownloadMediaHelper.isOpenScopedStorage()) {
                                hashMap.put(Long.valueOf(j2), string);
                            }
                            cursor.moveToNext();
                        }
                    } catch (Exception e) {
                        e = e;
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        if (DownloadMediaHelper.isOpenScopedStorage()) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely((Cursor) null);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Cursor) null);
                throw th;
            }
            Closeables.closeSafely(cursor);
            if (DownloadMediaHelper.isOpenScopedStorage()) {
                deleteDatabaseRecord(hashMap, jArr);
                for (int i = 0; i < arrayList.size(); i++) {
                    deleteFile(arrayList.get(i), z);
                }
            } else if (DownloadMediaHelper.isAndroid11Device()) {
                ArrayList arrayList2 = new ArrayList();
                final HashMap hashMap3 = new HashMap();
                final HashMap hashMap4 = new HashMap();
                if (callBack != null) {
                    callBack.callback(arrayList);
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    String str = arrayList.get(i2);
                    if (DownloadHelper.isStoragePrivatePath(str)) {
                        deleteFile(str, z);
                        deleteOneDatabaseRecord(hashMap, str);
                    } else {
                        Uri queryMediaFileUri = DownloadMediaHelper.queryMediaFileUri(AppRuntime.getAppContext(), str, "");
                        arrayList2.add(queryMediaFileUri);
                        hashMap3.put(queryMediaFileUri, str);
                        hashMap4.put(queryMediaFileUri, (Long) hashMap2.get(str));
                    }
                }
                DownloadMediaHelper.deleteByUriList(BdBoxActivityManager.getRealTopActivity(), arrayList2, new DownloadMediaHelper.CallBack<Uri>() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.download.util.DownloadMediaHelper.CallBack
                    public void callback(Uri uri) {
                        DownloadManagerExt.this.deleteOneDatabaseRecord(hashMap, (String) hashMap3.get(uri));
                    }
                }, new DownloadMediaHelper.CallBack<ArrayList<Uri>>() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.download.util.DownloadMediaHelper.CallBack
                    public void callback(ArrayList<Uri> arrayList3) {
                        if (callBack2 != null && hashMap4 != null && arrayList3 != null) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator<Uri> it = arrayList3.iterator();
                            while (it.hasNext()) {
                                arrayList4.add(hashMap4.get(it.next()));
                            }
                            callBack2.callback(arrayList4);
                        }
                    }
                });
            } else {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    final String str2 = arrayList.get(i3);
                    if (str2 != null) {
                        DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), str2, "", new y() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.5
                            @Override // com.baidu.tieba.y
                            public void onFailed(int i4) {
                            }

                            @Override // com.baidu.tieba.y
                            public void onRefused() {
                            }

                            @Override // com.baidu.tieba.y
                            public void onPermitted(Object obj) {
                                DownloadManagerExt.this.deleteOneDatabaseRecord(hashMap, str2);
                            }
                        });
                    }
                }
            }
        }
    }

    public void deleteDownloadFile(boolean z, long... jArr) {
        deleteDownloadFile(z, null, null, jArr);
    }

    @Deprecated
    public Uri doDownload(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, ContentValues contentValues) {
        int i;
        if (DownloadMediaHelper.isDownloadPathUncompliant(str2)) {
            str2 = DownloadHelper.getDownloadPrivateFile().getAbsolutePath();
            if (DEBUG) {
                Log.e(TAG, "Download directory does not meet Android 10 partition storage specifications.");
            }
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            WebAddress webAddress = new WebAddress(str);
            webAddress.mPath = encodePath(webAddress.mPath);
            ContentValues contentValues2 = new ContentValues();
            if (contentValues != null && contentValues.size() > 0) {
                contentValues2.putAll(contentValues);
            }
            contentValues2.put("uri", webAddress.toString());
            contentValues2.put("notificationpackage", this.mPackageName);
            contentValues2.put("notificationclass", str4);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                contentValues2.put("destination", (Integer) 4);
                contentValues2.put("hint", "file://" + str2 + File.separator + str3);
            } else {
                String asString = contentValues2.getAsString("hint");
                if (!TextUtils.isEmpty(asString) && asString.startsWith("file://") && DownloadMediaHelper.checkDownloadSpecifiedDirectoryValid(asString)) {
                    contentValues2.put("destination", (Integer) 4);
                } else {
                    if (!TextUtils.isEmpty(str3)) {
                        contentValues2.put("hint", str3);
                    }
                    contentValues2.put("destination", (Integer) 0);
                }
            }
            contentValues2.put("no_integrity", Boolean.TRUE);
            contentValues2.put("description", webAddress.mHost);
            if (z2) {
                i = 1;
            } else {
                i = 2;
            }
            contentValues2.put("visibility", Integer.valueOf(i));
            contentValues2.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(z));
            contentValues2.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, Boolean.valueOf(z4));
            if (z3) {
                contentValues2.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, (Integer) 2);
            }
            Uri insert = this.mResolver.insert(Downloads.Impl.CONTENT_URI, contentValues2);
            IDownloadApp.Impl.get().doDownloadStartStatics(str3, contentValues2.getAsString("mimetype"), contentValues2.getAsString("extra_info"));
            if (DEBUG) {
                Log.w(TAG, "doDownload(uri=" + insert + SmallTailInfo.EMOTION_SUFFIX);
            }
            processUnRead(z, insert);
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Uri doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4) {
        return doDownload(str, str2, str3, IDownloadApp.Impl.get().getOpenDownloadReceiverCanonicalName(), z, z2, z3, z4, null);
    }

    public Uri doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, ContentValues contentValues) {
        return doDownload(str, str2, str3, IDownloadApp.Impl.get().getOpenDownloadReceiverCanonicalName(), z, z2, z3, z4, contentValues);
    }

    public void doDownload(final String str, final String str2, final String str3, final DownloadCallBack downloadCallBack) {
        DownloadHelper.checkExternalStorage(str2, true, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.1
            @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
            public void onResult(boolean z) {
                if (z) {
                    Uri doDownload = DownloadManagerExt.this.doDownload(str, str2, str3);
                    DownloadCallBack downloadCallBack2 = downloadCallBack;
                    if (downloadCallBack2 != null) {
                        downloadCallBack2.onResult(doDownload);
                        return;
                    }
                    return;
                }
                DownloadCallBack downloadCallBack3 = downloadCallBack;
                if (downloadCallBack3 != null) {
                    downloadCallBack3.onResult(null);
                }
            }
        }, true);
    }

    public void doDownload(final String str, final String str2, final String str3, final String str4, final boolean z, final boolean z2, final boolean z3, final boolean z4, final ContentValues contentValues, final DownloadCallBack downloadCallBack) {
        boolean z5;
        if (!z && !z2) {
            z5 = false;
        } else {
            z5 = true;
        }
        DownloadHelper.checkExternalStorage(str2, z5, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.2
            @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
            public void onResult(boolean z6) {
                if (z6) {
                    Uri doDownload = DownloadManagerExt.this.doDownload(str, str2, str3, str4, z, z2, z3, z4, contentValues);
                    DownloadCallBack downloadCallBack2 = downloadCallBack;
                    if (downloadCallBack2 != null) {
                        downloadCallBack2.onResult(doDownload);
                        return;
                    }
                    return;
                }
                DownloadCallBack downloadCallBack3 = downloadCallBack;
                if (downloadCallBack3 != null) {
                    downloadCallBack3.onResult(null);
                }
            }
        }, true);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x008a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.searchbox.download.manager.DownloadManager$Query] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    public long[] getPauseDownloadIds() {
        Throwable th;
        Cursor cursor;
        ?? query = new DownloadManager.Query();
        try {
            try {
                cursor = this.mDownloadManager.queryNoTranslator(query.setOnlyDownloading(true));
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Cursor) query);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            query = 0;
            Closeables.closeSafely((Cursor) query);
            throw th;
        }
        if (cursor != null) {
            try {
            } catch (Exception e2) {
                e = e2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                Closeables.closeSafely(cursor);
                return null;
            }
            if (cursor.getCount() != 0) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("status");
                ArrayList arrayList = new ArrayList();
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    if (cursor.getInt(columnIndexOrThrow2) != 193) {
                        arrayList.add(Long.valueOf(cursor.getLong(columnIndexOrThrow)));
                    }
                    cursor.moveToNext();
                }
                if (arrayList.size() > 0) {
                    long[] jArr = new long[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        jArr[i] = ((Long) arrayList.get(i)).longValue();
                    }
                    Closeables.closeSafely(cursor);
                    return jArr;
                }
                Closeables.closeSafely(cursor);
                return null;
            }
        }
        Closeables.closeSafely(cursor);
        return null;
    }

    public long queryDownloadSizeByStatus() {
        boolean z;
        Cursor cursor = null;
        long j = 0;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"total_bytes", "_data"}, "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND uri not like '%content://%'", new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("_data");
                    do {
                        try {
                            z = new File(cursor.getString(columnIndex)).exists();
                        } catch (Exception e) {
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            z = false;
                        }
                        if (z) {
                            j += cursor.getLong(cursor.getColumnIndex("total_bytes"));
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            return j;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public ArrayList<Uri> queryContentUriByIds(List<String> list) {
        ArrayList<Uri> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            ArrayList<String> arrayList2 = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("_id");
                    sb.append(" in (");
                    for (String str : list) {
                        sb.append("'");
                        sb.append(str);
                        sb.append("',");
                    }
                    String substring = sb.substring(0, sb.length() - 1);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data", "uri", "_id"}, substring + SmallTailInfo.EMOTION_SUFFIX, null, null);
                    int columnIndex = cursor.getColumnIndex("_data");
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        arrayList2.add(cursor.getString(columnIndex));
                        cursor.moveToNext();
                    }
                } catch (Exception e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
                Closeables.closeSafely(cursor);
                for (String str2 : arrayList2) {
                    Uri convertPathToMediaUri = DownloadMediaHelper.convertPathToMediaUri(AppRuntime.getAppContext(), str2);
                    if (convertPathToMediaUri != null) {
                        arrayList.add(convertPathToMediaUri);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                Closeables.closeSafely(cursor);
                throw th;
            }
        }
        return arrayList;
    }

    public void queryDownloadDataNoTranslator(DownloadBean downloadBean) {
        if (-1 == downloadBean.getDownloadId()) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDownloadManager.queryNoTranslator(new DownloadManager.Query().setFilterById(downloadBean.getDownloadId()));
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cursor != null && cursor.getCount() != 0 && cursor.moveToFirst()) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("total_bytes");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("current_bytes");
                int columnIndex = cursor.getColumnIndex("status");
                int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("_data");
                long j = cursor.getLong(columnIndexOrThrow);
                long j2 = cursor.getLong(columnIndexOrThrow2);
                int i = cursor.getInt(columnIndex);
                String string = cursor.getString(columnIndexOrThrow3);
                if (DEBUG) {
                    Log.d(TAG, "queryDownloadDataNoTranslator(total=" + j + ", current=" + j2 + ", status=" + i + SmallTailInfo.EMOTION_SUFFIX);
                }
                downloadBean.setTotalBytes(j);
                downloadBean.setCurrentBytes(j2);
                downloadBean.setStatus(i);
                downloadBean.setFilePath(string);
                return;
            }
            downloadBean.setCurrentBytes(0L);
            downloadBean.setTotalBytes(-1L);
            downloadBean.setDownloadState(DownloadState.NOT_START);
            if (DEBUG) {
                Log.w(TAG, "null == cursor || cursor.getCount() == 0 || !cursor.moveToFirst()");
            }
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        r2 = r1.getLong(r1.getColumnIndexOrThrow("_id"));
        r4 = r1.getLong(r1.getColumnIndexOrThrow("total_bytes"));
        r6 = r1.getLong(r1.getColumnIndexOrThrow("current_bytes"));
        r15 = r1.getInt(r1.getColumnIndexOrThrow("status"));
        r8 = r1.getString(r1.getColumnIndexOrThrow("_data"));
        r0.mCurrentBytes = r6;
        r0.mTotalBytes = r4;
        r0.mStatus = r15;
        r0.mDownloadId = r2;
        r0.mDownloadPath = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DownloadModel queryDownloadBeanByExtraInfo(String str) {
        DownloadModel buildErrorBean = DownloadModel.buildErrorBean();
        if (TextUtils.isEmpty(str)) {
            return buildErrorBean;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.mResolver.query(Downloads.Impl.CONTENT_URI, new String[]{"_id", "total_bytes", "current_bytes", "status", "_data", "extra_info"}, null, null, "lastmod DESC");
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cursor == null) {
                return buildErrorBean;
            }
            cursor.moveToFirst();
            while (true) {
                if (cursor.isAfterLast()) {
                    break;
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("extra_info"));
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        JSONObject jSONObject2 = new JSONObject(str);
                        Iterator<String> keys = jSONObject2.keys();
                        boolean z = true;
                        while (true) {
                            if (!keys.hasNext()) {
                                break;
                            }
                            String obj = keys.next().toString();
                            if (!TextUtils.equals(jSONObject.optString(obj), jSONObject2.optString(obj))) {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            break;
                        }
                    } catch (Exception unused) {
                        return buildErrorBean;
                    }
                }
                cursor.moveToNext();
            }
            return buildErrorBean;
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.searchbox.ng.browser.explore.model.WebAddress */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadBean queryDownloadBeanByUrl(String str) {
        Exception e;
        Cursor cursor;
        Cursor cursor2 = null;
        Uri parse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            WebAddress webAddress = new WebAddress(str);
            webAddress.mPath = encodePath(webAddress.mPath);
            DownloadBean downloadBean = new DownloadBean();
            try {
                try {
                    cursor = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getReadableDatabase().rawQuery("select * from downloads where uri = '" + webAddress.toString() + "'", null);
                } catch (Throwable th) {
                    th = th;
                    cursor2 = webAddress;
                    Closeables.closeSafely(cursor2);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(cursor2);
                throw th;
            }
            if (cursor != null) {
                try {
                } catch (Exception e3) {
                    e = e3;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                    return downloadBean;
                }
                if (cursor.getCount() != 0 && cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("uri"));
                    int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                    long j = cursor.getLong(cursor.getColumnIndexOrThrow("total_bytes"));
                    long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("current_bytes"));
                    int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        parse = Uri.parse(string);
                    }
                    downloadBean.setUri(parse);
                    downloadBean.setDownloadId(i);
                    downloadBean.setTotalBytes(j);
                    downloadBean.setCurrentBytes(j2);
                    downloadBean.setFilePath(string2);
                    downloadBean.setDownloadState(DownloadState.rawConvert(i2));
                    if (DEBUG) {
                        Log.d(TAG, "Selected:" + downloadBean.toString());
                    }
                    Closeables.closeSafely(cursor);
                    return downloadBean;
                }
            }
            downloadBean.setUri(null);
            downloadBean.setDownloadId(-1);
            downloadBean.setTotalBytes(-1L);
            downloadBean.setCurrentBytes(0L);
            downloadBean.setDownloadState(DownloadState.NOT_START);
            if (DEBUG) {
                Log.d(TAG, "Default:" + downloadBean.toString());
            }
            Closeables.closeSafely(cursor);
            return downloadBean;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void queryDownloadData(DownloadBean downloadBean) {
        if (-1 == downloadBean.getDownloadId()) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDownloadManager.query(new DownloadManager.Query().setFilterById(downloadBean.getDownloadId()));
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cursor != null && cursor.getCount() != 0 && cursor.moveToFirst()) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("total_bytes");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);
                int columnIndex = cursor.getColumnIndex("progress");
                int columnIndex2 = cursor.getColumnIndex("status");
                int columnIndex3 = cursor.getColumnIndex("_data");
                long j = cursor.getLong(columnIndexOrThrow);
                long j2 = cursor.getLong(columnIndexOrThrow2);
                int i = cursor.getInt(columnIndex);
                int i2 = cursor.getInt(columnIndex2);
                String string = cursor.getString(columnIndex3);
                if (DEBUG) {
                    Log.d(TAG, "query(total=" + j + ", current=" + j2 + ", status=" + i2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                downloadBean.setTotalBytes(j);
                downloadBean.setCurrentBytes(j2);
                downloadBean.setProgress(i);
                downloadBean.setDownloadState(DownloadState.convert(i2));
                downloadBean.setFilePath(string);
                return;
            }
            downloadBean.setCurrentBytes(0L);
            downloadBean.setTotalBytes(-1L);
            downloadBean.setProgress(0);
            downloadBean.setDownloadState(DownloadState.NOT_START);
            if (DEBUG) {
                Log.w(TAG, "null == cursor || cursor.getCount() == 0 || !cursor.moveToFirst()");
            }
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    public int queryDownloadIdByUrl(String str) {
        Cursor cursor;
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            WebAddress webAddress = new WebAddress(str);
            webAddress.mPath = encodePath(webAddress.mPath);
            ?? r6 = 0;
            r6 = 0;
            try {
                try {
                    SQLiteDatabase readableDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getReadableDatabase();
                    r6 = readableDatabase.rawQuery("select _id from downloads where uri = '" + webAddress.toString() + "'", null);
                    cursor = r6;
                    if (r6 != 0) {
                        boolean moveToFirst = r6.moveToFirst();
                        cursor = r6;
                        if (moveToFirst) {
                            i = r6.getInt(0);
                            cursor = r6;
                        }
                    }
                } catch (Throwable th) {
                    Closeables.closeSafely((Cursor) r6);
                    throw th;
                }
            } catch (Exception e) {
                cursor = r6;
                if (DEBUG) {
                    e.printStackTrace();
                    cursor = r6;
                }
            }
            Closeables.closeSafely(cursor);
            r6 = DEBUG;
            if (r6 != 0) {
                Log.d(TAG, "QueryDownloadIdByUrl: downlaod id = " + i);
            }
            return i;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public void restartDownload(final long j) {
        boolean z;
        boolean z2;
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j), new String[]{"_id", "_data", "status", "visibility", Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI}, null, null, null);
                final String str = "";
                boolean z3 = true;
                if (cursor.moveToFirst()) {
                    if (cursor.getLong(cursor.getColumnIndex("status")) == 200) {
                        IDownloadApp.Impl.get().doRestartDownloadJob(j);
                    }
                    str = cursor.getString(cursor.getColumnIndex("_data"));
                    if (cursor.getInt(cursor.getColumnIndex("visibility")) != 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (cursor.getInt(cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI)) != 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                if (!z2 && !z) {
                    z3 = false;
                }
                DownloadHelper.checkExternalStorage(str, z3, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.manager.DownloadManagerExt.6
                    @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                    public void onResult(boolean z4) {
                        if (z4) {
                            try {
                                if (str != null) {
                                    DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), str, "");
                                }
                                DownloadManagerExt.this.mDownloadManager.restartDownload(AppRuntime.getAppContext(), j);
                            } catch (Exception e) {
                                if (AppConfig.isDebug()) {
                                    throw new DebugException("restartDownload", e);
                                }
                            }
                        }
                    }
                });
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    throw new DebugException("restartDownload", e);
                }
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public void registerObserver(Context context, Uri uri, DownloadListener downloadListener) {
        if (downloadListener == null) {
            if (DEBUG) {
                Log.e(TAG, "registerObserver(listener == null)");
            }
        } else if (-1 == getIdFromUri(uri)) {
            if (DEBUG) {
                Log.e(TAG, "registerObserver(id == -1)");
            }
        } else {
            DownloadObserver downloadObserver = this.mUriToObserver.get(uri);
            if (downloadObserver == null) {
                downloadObserver = new DownloadObserver(context, uri);
                this.mUriToObserver.put(uri, downloadObserver);
                context.getContentResolver().registerContentObserver(uri, true, downloadObserver);
            }
            downloadObserver.addListener(downloadListener);
        }
    }
}
