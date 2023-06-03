package com.baidu.searchbox.download.util;

import android.app.Activity;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.component.DownloadProvider;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DocClassifyHelper;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class LocalDataScanHelper {
    public static final String DOWNLOAD_LAST_SCAN_LOCAL_TIME = "download_last_scan_local_time";
    public static final String EXT_KEY_DURATION = "duration";
    public static final String EXT_KEY_PLAY_PROGRESS = "play_progress";
    public static final String LOCAL_DATA_IS_EMPTY = "local_data_is_empty";
    public static final int LOCAL_DATA_MAX_COUNT = 2000;
    public static final String TAG = "LocalDataScanHelper";
    public boolean isInit;
    public boolean isScanning;
    public boolean mIsDeleting;
    public ConcurrentHashMap<String, Integer> mLocalDataCount;
    public ConcurrentHashMap<String, String> mLocalDataType;
    public HashMap<Uri, MediaStoreContentObserver> mUriToObserver;

    /* loaded from: classes3.dex */
    public interface IContentObserver {
        void onChange(boolean z);

        void onChange(boolean z, Uri uri);
    }

    /* renamed from: com.baidu.searchbox.download.util.LocalDataScanHelper$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy;

        static {
            int[] iArr = new int[DocClassifyHelper.DocCategroy.values().length];
            $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy = iArr;
            try {
                iArr[DocClassifyHelper.DocCategroy.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy[DocClassifyHelper.DocCategroy.PPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy[DocClassifyHelper.DocCategroy.WORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy[DocClassifyHelper.DocCategroy.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy[DocClassifyHelper.DocCategroy.EXCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy[DocClassifyHelper.DocCategroy.ALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy[DocClassifyHelper.DocCategroy.OFFICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LocalDataScanHelperInstance {
        public static final LocalDataScanHelper instance = new LocalDataScanHelper();
    }

    /* loaded from: classes3.dex */
    public class MediaStoreContentObserver extends ContentObserver {
        public HashSet<IContentObserver> mListeners;

        public MediaStoreContentObserver(Handler handler) {
            super(handler);
            this.mListeners = new HashSet<>();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            synchronized (this) {
                int size = this.mListeners.size();
                IContentObserver[] iContentObserverArr = new IContentObserver[size];
                this.mListeners.toArray(iContentObserverArr);
                for (int i = 0; i < size; i++) {
                    iContentObserverArr[i].onChange(z, uri);
                }
            }
        }

        public synchronized boolean addListener(IContentObserver iContentObserver) {
            return this.mListeners.add(iContentObserver);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            synchronized (this) {
                int size = this.mListeners.size();
                IContentObserver[] iContentObserverArr = new IContentObserver[size];
                this.mListeners.toArray(iContentObserverArr);
                for (int i = 0; i < size; i++) {
                    iContentObserverArr[i].onChange(z);
                }
            }
        }

        public synchronized boolean removeListener(IContentObserver iContentObserver) {
            return this.mListeners.remove(iContentObserver);
        }

        public synchronized void clearListeners() {
            this.mListeners.clear();
        }

        public boolean isListenersEmpty() {
            return this.mListeners.isEmpty();
        }
    }

    public LocalDataScanHelper() {
        this.isInit = false;
        this.isScanning = false;
        this.mLocalDataCount = new ConcurrentHashMap<>();
        this.mUriToObserver = new HashMap<>();
        this.mLocalDataType = new ConcurrentHashMap<>();
        ApkUtil.registerApkReceiver(AppRuntime.getAppContext());
    }

    public static LocalDataScanHelper getInstance() {
        return LocalDataScanHelperInstance.instance;
    }

    public boolean localDataIsEmpty() {
        return PreferenceUtils.getBoolean(LOCAL_DATA_IS_EMPTY, false);
    }

    public static String getFileNameWithSuffix(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public void deleteLocalData(String str) {
        AppRuntime.getAppContext().getContentResolver().delete(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH), "_data = ?", new String[]{str});
    }

    public boolean hasContentObserverWithUri(Uri uri) {
        MediaStoreContentObserver mediaStoreContentObserver;
        if (uri == null || (mediaStoreContentObserver = this.mUriToObserver.get(uri)) == null || mediaStoreContentObserver.mListeners.size() == 0) {
            return false;
        }
        return true;
    }

    public void setInit(boolean z) {
        this.isInit = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        r7.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean deleteLocalRecords(List<String> list) {
        SQLiteDatabase writableDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("delete from downloads where (_data)in (?)");
        boolean z = false;
        try {
            try {
                writableDatabase.beginTransaction();
                Iterator<String> it = list.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    compileStatement.bindString(1, it.next());
                    compileStatement.executeUpdateDelete();
                    i++;
                    if (i > 999) {
                        z = true;
                        break;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            return z;
        } catch (Throwable th3) {
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Throwable th4) {
                    if (AppConfig.isDebug()) {
                        th4.printStackTrace();
                    }
                }
            }
            throw th3;
        }
    }

    public static Cursor getDownloadVideoCursor() {
        DownloadManager.Query query = new DownloadManager.Query();
        DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
        String sQliteSelectionByCategory = FileClassifyHelper.getSQliteSelectionByCategory(0, null);
        query.setFilterByStatus(8);
        query.setOnlyIncludeVisibleInDownloadsUi(true);
        try {
            return downloadManager.queryDownload(query.setFilterBySelection(sQliteSelectionByCategory));
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (!AppConfig.isDebug()) {
                return null;
            }
            throw e;
        }
    }

    public int getOtherDataCount() {
        ArrayList<CategoryInfoData> queryDownloaded = DownloadCenterUtils.queryDownloaded(true, -1L, Long.MAX_VALUE, Integer.MAX_VALUE, false, true);
        if (queryDownloaded == null || queryDownloaded.size() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < queryDownloaded.size(); i2++) {
            CategoryInfoData categoryInfoData = queryDownloaded.get(i2);
            if (categoryInfoData != null && categoryInfoData.mType == 5) {
                i++;
            }
        }
        DownloadCenterUtils.setOtherDataCount(i);
        return i;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void insertLocalData(HashSet<String> hashSet, ArrayList<ContentValues> arrayList) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("insert into downloads(uri,mimetype,_data,status,total_bytes,hint,title,lastmod,destination,no_integrity,visibility,deleted,is_visible_in_downloads_ui,uid,scanned,extra_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sQLiteDatabase.beginTransaction();
            int i = 0;
            Iterator<ContentValues> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentValues next = it.next();
                if (hashSet.contains(next.getAsString("_data"))) {
                    compileStatement.bindString(1, next.getAsString("uri"));
                    compileStatement.bindString(2, next.getAsString("mimetype"));
                    compileStatement.bindString(3, next.getAsString("_data"));
                    compileStatement.bindLong(4, next.getAsInteger("status").intValue());
                    compileStatement.bindLong(5, next.getAsLong("total_bytes").longValue());
                    compileStatement.bindString(6, next.getAsString("hint"));
                    compileStatement.bindString(7, next.getAsString("title"));
                    compileStatement.bindLong(8, next.getAsLong("lastmod").longValue());
                    compileStatement.bindLong(9, 0L);
                    compileStatement.bindLong(10, 1L);
                    compileStatement.bindLong(11, 2L);
                    compileStatement.bindLong(12, 0L);
                    compileStatement.bindLong(13, 1L);
                    compileStatement.bindLong(14, Binder.getCallingUid());
                    compileStatement.bindLong(15, 1L);
                    compileStatement.bindString(16, next.getAsString("extra_info"));
                    compileStatement.executeInsert();
                    i++;
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (AppConfig.isDebug()) {
                Log.d(TAG, "本次扫描新增视频数量: " + i);
            }
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                if (!AppConfig.isDebug()) {
                    if (sQLiteDatabase == null) {
                        return;
                    }
                } else {
                    throw new DebugException("getLocalFilesByType", th);
                }
            } catch (Throwable th2) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused2) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void isFilePathRepeat(HashSet<String> hashSet, boolean z) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (hashSet.size() < 1) {
            return;
        }
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, "status= ? AND is_visible_in_downloads_ui= ?", new String[]{String.valueOf(200), String.valueOf(1)}, null);
            if (cursor != null) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                while (cursor.moveToNext()) {
                    String string = cursor.getString(columnIndexOrThrow);
                    if (hashSet.contains(string)) {
                        arrayList.add(string);
                    }
                }
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "数据库中已存在数据 repeatList.size:" + arrayList.size());
            }
        } catch (Throwable th) {
            try {
                if (!AppConfig.isDebug()) {
                    hashSet.clear();
                } else {
                    throw new DebugException("DownloadHelper.isFilePathRepeat", th);
                }
            } catch (Throwable th2) {
                Closeables.closeSafely(cursor);
                throw th2;
            }
        }
        Closeables.closeSafely(cursor);
        if (arrayList.size() == hashSet.size()) {
            hashSet.clear();
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.remove((String) it.next());
        }
        if (!z) {
            return;
        }
        Iterator<String> it2 = hashSet.iterator();
        HashSet hashSet2 = new HashSet();
        int size = arrayList.size() + hashSet.size() + DlnaManager.DLNA_SUB_ERROR_NETWORK_UNREACHABLE;
        while (it2.hasNext()) {
            String next = it2.next();
            if (!LocalFilesFilterKt.filterSystemLogName(FileClassifyHelper.getFileNameFromPath(next)) && ((concurrentHashMap = this.mLocalDataType) == null || !concurrentHashMap.containsKey(next))) {
                if (size < 0) {
                    size++;
                    hashSet2.add(next);
                }
            }
        }
        hashSet.clear();
        hashSet.addAll(hashSet2);
    }

    private void patchAllLocalVideoDuration(HashMap<String, Long> hashMap) {
        JSONObject jSONObject;
        if (DownloadSharedPrefsUtils.getInstance().getBoolean(DownloadCenterUtils.HAS_PATCH_ALL_LOCAL_VIDEO_DURATION, false) || !DownloadHelper.isStoragePermissionGranted()) {
            return;
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "patchAllLocalVideoDuration start ... at thread: " + Thread.currentThread());
        }
        HashMap hashMap2 = new HashMap();
        Cursor downloadVideoCursor = getDownloadVideoCursor();
        try {
            if (downloadVideoCursor != null) {
                try {
                    int columnIndexOrThrow = downloadVideoCursor.getColumnIndexOrThrow("_data");
                    int columnIndexOrThrow2 = downloadVideoCursor.getColumnIndexOrThrow("extra_info");
                    while (downloadVideoCursor.moveToNext()) {
                        String string = downloadVideoCursor.getString(columnIndexOrThrow);
                        Long l = hashMap.get(string);
                        if (l != null) {
                            String string2 = downloadVideoCursor.getString(columnIndexOrThrow2);
                            try {
                                if (TextUtils.isEmpty(string2)) {
                                    jSONObject = new JSONObject();
                                } else {
                                    jSONObject = new JSONObject(string2);
                                }
                                if (TextUtils.isEmpty(jSONObject.optString("duration"))) {
                                    jSONObject.putOpt("duration", String.valueOf(l));
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("extra_info", jSONObject.toString());
                                    hashMap2.put(string, contentValues);
                                }
                            } catch (Exception e) {
                                if (AppConfig.isDebug()) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
                Closeables.closeSafely(downloadVideoCursor);
                if (!hashMap2.isEmpty()) {
                    SQLiteDatabase writableDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
                    for (Map.Entry entry : hashMap2.entrySet()) {
                        writableDatabase.update("downloads", (ContentValues) entry.getValue(), "_data=?", new String[]{String.valueOf(entry.getKey())});
                    }
                }
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "patchAllLocalVideoDuration end, patched " + hashMap2.size() + " videos in total");
                }
                DownloadSharedPrefsUtils.getInstance().putBoolean(DownloadCenterUtils.HAS_PATCH_ALL_LOCAL_VIDEO_DURATION, true);
            }
        } catch (Throwable th) {
            Closeables.closeSafely(downloadVideoCursor);
            throw th;
        }
    }

    public int getDataCountByType(int i) {
        if (this.mLocalDataCount == null || !localDataIsEmpty()) {
            return 0;
        }
        Integer num = 0;
        if (i != 1) {
            if (i != 8) {
                if (i != 11) {
                    if (i != 3) {
                        if (i == 4) {
                            for (Map.Entry<String, Integer> entry : this.mLocalDataCount.entrySet()) {
                                if (TextUtils.equals(entry.getKey(), "pdf") || TextUtils.equals(entry.getKey(), DownloadStatisticConstants.UBC_VALUE_WORD) || TextUtils.equals(entry.getKey(), DownloadStatisticConstants.UBC_VALUE_EXCEL) || TextUtils.equals(entry.getKey(), "text") || TextUtils.equals(entry.getKey(), "ppt")) {
                                    Integer num2 = this.mLocalDataCount.get(entry.getKey());
                                    if (num2 != null) {
                                        num = Integer.valueOf(num.intValue() + num2.intValue());
                                    }
                                }
                            }
                        }
                    } else {
                        num = this.mLocalDataCount.get("app");
                    }
                } else {
                    num = this.mLocalDataCount.get(DownloadStatisticConstants.UBC_VALUE_OFFLINE_WEB);
                }
            } else {
                num = this.mLocalDataCount.get("zip");
            }
        } else {
            num = this.mLocalDataCount.get("music");
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01cb A[Catch: all -> 0x01d3, TRY_ENTER, TryCatch #1 {all -> 0x01d3, blocks: (B:80:0x0188, B:98:0x01cb, B:99:0x01d2), top: B:117:0x0188 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteUnExistLocalData() {
        String str;
        String str2;
        long j;
        boolean z;
        int i;
        boolean z2;
        Activity topActivity;
        Activity topActivity2;
        boolean z3;
        Activity topActivity3;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            j = 5000;
            try {
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data", "extra_info", "mimetype", Downloads.Impl.COLUMN_OPEN_TIME}, "uri like '%content://%'", null, "time_open DESC ");
                if (query != null) {
                    try {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        int columnIndexOrThrow2 = query.getColumnIndexOrThrow("mimetype");
                        int columnIndexOrThrow3 = query.getColumnIndexOrThrow("extra_info");
                        int columnIndexOrThrow4 = query.getColumnIndexOrThrow(Downloads.Impl.COLUMN_OPEN_TIME);
                        while (query.moveToNext()) {
                            CategoryInfoData categoryInfoData = new CategoryInfoData();
                            categoryInfoData.mDownloadPath = query.getString(columnIndexOrThrow);
                            categoryInfoData.mOpenTime = query.getLong(columnIndexOrThrow4);
                            categoryInfoData.mMimeType = query.getString(columnIndexOrThrow2);
                            categoryInfoData.mExtraInfo = query.getString(columnIndexOrThrow3);
                            arrayList.add(categoryInfoData);
                        }
                        if (arrayList.size() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            int i2 = 0;
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                CategoryInfoData categoryInfoData2 = (CategoryInfoData) arrayList.get(i3);
                                String str3 = categoryInfoData2.mDownloadPath;
                                long j2 = categoryInfoData2.mOpenTime;
                                String str4 = categoryInfoData2.mMimeType;
                                String str5 = categoryInfoData2.mExtraInfo;
                                if (!TextUtils.isEmpty(str3) && !new File(str3).exists()) {
                                    arrayList2.add(str3);
                                } else {
                                    if (j2 > 0) {
                                        i2++;
                                    } else {
                                        int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str3), str4);
                                        if (category != 0 && category != 4) {
                                            arrayList2.add(str3);
                                        } else if (category == 4 && TextUtils.isEmpty(str5)) {
                                            arrayList2.add(str3);
                                        }
                                    }
                                    if (i2 > 100) {
                                        int category2 = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str3), str4);
                                        if (category2 != 0 && category2 != 4) {
                                            arrayList2.add(str3);
                                        } else if (category2 == 4 && TextUtils.isEmpty(str5)) {
                                            arrayList2.add(str3);
                                        }
                                    }
                                }
                            }
                            boolean deleteLocalRecords = deleteLocalRecords(arrayList2);
                            try {
                                arrayList2.clear();
                                z3 = deleteLocalRecords;
                                Closeables.closeSafely(query);
                                if (!z3) {
                                    ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.util.LocalDataScanHelper.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            LocalDataScanHelper.this.deleteUnExistLocalData();
                                        }
                                    }, "deleteUnExistLocalData()", 3, 5000L);
                                } else if (!localDataIsEmpty()) {
                                    PreferenceUtils.setBoolean(LOCAL_DATA_IS_EMPTY, true);
                                    if (BdBoxActivityManager.isForeground() && (topActivity3 = BdBoxActivityManager.getTopActivity()) != null) {
                                        String simpleName = topActivity3.getClass().getSimpleName();
                                        if (simpleName.equalsIgnoreCase("FileManagerActivity") || simpleName.equalsIgnoreCase("DownloadedCategorySecActivity")) {
                                            scanLocalFilesByType();
                                        }
                                    }
                                }
                                this.mIsDeleting = z3;
                            } catch (Exception e) {
                                e = e;
                                cursor = query;
                                z2 = deleteLocalRecords;
                                str = "DownloadedCategorySecActivity";
                                str2 = "FileManagerActivity";
                                z = true;
                                i = 3;
                                try {
                                    if (AppConfig.isDebug()) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    Closeables.closeSafely(cursor);
                                    if (!z2) {
                                        if (!localDataIsEmpty()) {
                                            PreferenceUtils.setBoolean(LOCAL_DATA_IS_EMPTY, z);
                                            if (BdBoxActivityManager.isForeground() && (topActivity = BdBoxActivityManager.getTopActivity()) != null) {
                                                String simpleName2 = topActivity.getClass().getSimpleName();
                                                if (simpleName2.equalsIgnoreCase(str2) || simpleName2.equalsIgnoreCase(str)) {
                                                    scanLocalFilesByType();
                                                }
                                            }
                                        }
                                    } else {
                                        ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.util.LocalDataScanHelper.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                LocalDataScanHelper.this.deleteUnExistLocalData();
                                            }
                                        }, "deleteUnExistLocalData()", i, j);
                                    }
                                    this.mIsDeleting = z2;
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = query;
                                z2 = deleteLocalRecords;
                                str = "DownloadedCategorySecActivity";
                                str2 = "FileManagerActivity";
                                z = true;
                                i = 3;
                                Closeables.closeSafely(cursor);
                                if (!z2) {
                                }
                                this.mIsDeleting = z2;
                                throw th;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                        str = "DownloadedCategorySecActivity";
                        str2 = "FileManagerActivity";
                        z = true;
                        i = 3;
                        z2 = false;
                        if (AppConfig.isDebug()) {
                            Closeables.closeSafely(cursor);
                            if (z2) {
                                ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.util.LocalDataScanHelper.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LocalDataScanHelper.this.deleteUnExistLocalData();
                                    }
                                }, "deleteUnExistLocalData()", i, j);
                            } else if (!localDataIsEmpty()) {
                                PreferenceUtils.setBoolean(LOCAL_DATA_IS_EMPTY, z);
                                if (BdBoxActivityManager.isForeground() && (topActivity2 = BdBoxActivityManager.getTopActivity()) != null) {
                                    String simpleName3 = topActivity2.getClass().getSimpleName();
                                    if (simpleName3.equalsIgnoreCase(str2) || simpleName3.equalsIgnoreCase(str)) {
                                        scanLocalFilesByType();
                                    }
                                }
                            }
                            this.mIsDeleting = z2;
                            return;
                        }
                        throw new DebugException("DownloadHelper.deleteUnExistLocalData", e);
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = query;
                        str = "DownloadedCategorySecActivity";
                        str2 = "FileManagerActivity";
                        z = true;
                        i = 3;
                        z2 = false;
                        Closeables.closeSafely(cursor);
                        if (!z2) {
                        }
                        this.mIsDeleting = z2;
                        throw th;
                    }
                }
                z3 = false;
                Closeables.closeSafely(query);
                if (!z3) {
                }
                this.mIsDeleting = z3;
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e4) {
            e = e4;
            str = "DownloadedCategorySecActivity";
            str2 = "FileManagerActivity";
            j = 5000;
        } catch (Throwable th5) {
            th = th5;
            str = "DownloadedCategorySecActivity";
            str2 = "FileManagerActivity";
            j = 5000;
        }
    }

    public int getDocDataCountByType(DocClassifyHelper.DocCategroy docCategroy) {
        if (this.mLocalDataCount == null || !localDataIsEmpty()) {
            return 0;
        }
        Integer num = 0;
        switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$download$util$DocClassifyHelper$DocCategroy[docCategroy.ordinal()]) {
            case 1:
                num = this.mLocalDataCount.get("pdf");
                break;
            case 2:
                num = this.mLocalDataCount.get("ppt");
                break;
            case 3:
                num = this.mLocalDataCount.get(DownloadStatisticConstants.UBC_VALUE_WORD);
                break;
            case 4:
                num = this.mLocalDataCount.get("text");
                break;
            case 5:
                num = this.mLocalDataCount.get(DownloadStatisticConstants.UBC_VALUE_EXCEL);
                break;
            case 6:
                for (Map.Entry<String, Integer> entry : this.mLocalDataCount.entrySet()) {
                    if (TextUtils.equals(entry.getKey(), "pdf") || TextUtils.equals(entry.getKey(), DownloadStatisticConstants.UBC_VALUE_WORD) || TextUtils.equals(entry.getKey(), DownloadStatisticConstants.UBC_VALUE_EXCEL) || TextUtils.equals(entry.getKey(), "text") || TextUtils.equals(entry.getKey(), "ppt")) {
                        num = Integer.valueOf(num.intValue() + this.mLocalDataCount.get(entry.getKey()).intValue());
                    }
                }
                break;
            case 7:
                for (Map.Entry<String, Integer> entry2 : this.mLocalDataCount.entrySet()) {
                    if (TextUtils.equals(entry2.getKey(), DownloadStatisticConstants.UBC_VALUE_WORD) || TextUtils.equals(entry2.getKey(), DownloadStatisticConstants.UBC_VALUE_EXCEL) || TextUtils.equals(entry2.getKey(), "ppt")) {
                        num = Integer.valueOf(num.intValue() + this.mLocalDataCount.get(entry2.getKey()).intValue());
                    }
                }
                break;
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public ArrayList<String> getLocalDataListByType(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.mLocalDataType.keySet()) {
            String str2 = this.mLocalDataType.get(str);
            if (DownloadHelper.getFileTypeIntByString(str2) == i) {
                arrayList.add(str);
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "getLocalDataListByType key:" + str + ", value:" + str2);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<CategoryInfoData> queryDataByCategory(int i, long j, int i2) {
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        ArrayList<String> mimeTypesByType = FileClassifyHelper.getMimeTypesByType(i);
        if (mimeTypesByType.size() == 0) {
            return arrayList;
        }
        long j2 = 1000;
        long j3 = j / 1000;
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str = "date_modified < " + j3;
        String str2 = "date_modified" + WordCommandManager.DESC;
        Cursor cursor = null;
        try {
            try {
                cursor = DownloadMediaHelper.query(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH).buildUpon().appendQueryParameter(Constants.EXTRA_CONFIG_LIMIT, i2 + "").build(), null, str + " AND mime_type IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX, null, str2, i2);
                if (cursor != null) {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("mime_type");
                    int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("_data");
                    int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("_size");
                    int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("date_modified");
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(columnIndexOrThrow3);
                        String string2 = cursor.getString(columnIndexOrThrow);
                        String fileNameWithSuffix = getFileNameWithSuffix(string);
                        if (!TextUtils.isEmpty(fileNameWithSuffix)) {
                            int i3 = columnIndexOrThrow3;
                            long j4 = cursor.getLong(columnIndexOrThrow4);
                            long j5 = cursor.getLong(columnIndexOrThrow5) * j2;
                            long j6 = cursor.getLong(columnIndexOrThrow2);
                            String fileTypeString = DownloadHelper.getFileTypeString(string, string2);
                            if (DownloadHelper.getFileTypeIntByString(fileTypeString) != i) {
                                if (AppConfig.isDebug()) {
                                    Log.d(TAG, "【文件数目 queryDataByCategory path:" + string + ", minType:" + string2 + ", typeStr:" + fileTypeString + ", getFileTypeIntByString:" + DownloadHelper.getFileTypeIntByString(fileTypeString) + "---category:" + i);
                                }
                            } else {
                                CategoryInfoData categoryInfoData = new CategoryInfoData();
                                categoryInfoData.mId = j6;
                                categoryInfoData.mFileName = fileNameWithSuffix;
                                categoryInfoData.mType = i;
                                categoryInfoData.mDownloadPath = string;
                                categoryInfoData.mSize = j4;
                                categoryInfoData.mMimeType = string2;
                                categoryInfoData.mCompletionTime = j5;
                                categoryInfoData.mIsLocal = true;
                                arrayList.add(categoryInfoData);
                            }
                            columnIndexOrThrow3 = i3;
                            j2 = 1000;
                        }
                    }
                }
                Closeables.closeSafely(cursor);
            } catch (Throwable th) {
                th = th;
                Closeables.closeSafely(cursor);
                throw th;
            }
        } catch (Exception e) {
            try {
                if (!AppConfig.isDebug()) {
                    this.isInit = false;
                    Closeables.closeSafely(cursor);
                } else {
                    throw new DebugException("getLocalFilesByType", e);
                }
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(cursor);
                throw th;
            }
        }
        return arrayList;
    }

    public ArrayList<CategoryInfoData> queryDocDataByCategory(DocClassifyHelper.DocCategroy docCategroy, long j, int i) {
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        ArrayList<String> mimeTypesByType = DocClassifyHelper.getMimeTypesByType(docCategroy);
        if (mimeTypesByType.size() == 0) {
            return arrayList;
        }
        long j2 = 1000;
        long j3 = j / 1000;
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str = "date_modified <= " + j3;
        String str2 = "date_modified" + WordCommandManager.DESC;
        Cursor cursor = null;
        try {
            cursor = DownloadMediaHelper.query(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH).buildUpon().appendQueryParameter(Constants.EXTRA_CONFIG_LIMIT, i + "").build(), null, str + " AND mime_type IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX, null, str2, i);
        } catch (Exception unused) {
        } catch (Throwable th) {
            Closeables.closeSafely((Cursor) null);
            throw th;
        }
        if (cursor == null) {
            Closeables.closeSafely(cursor);
            return arrayList;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("mime_type");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("_data");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("_size");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("date_modified");
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndexOrThrow3);
            String string2 = cursor.getString(columnIndexOrThrow);
            String fileNameWithSuffix = getFileNameWithSuffix(string);
            if (!TextUtils.isEmpty(fileNameWithSuffix)) {
                long j4 = cursor.getLong(columnIndexOrThrow4);
                int i2 = columnIndexOrThrow4;
                long j5 = cursor.getLong(columnIndexOrThrow5) * j2;
                long j6 = cursor.getLong(columnIndexOrThrow2);
                CategoryInfoData categoryInfoData = new CategoryInfoData();
                categoryInfoData.mId = j6;
                categoryInfoData.mFileName = fileNameWithSuffix;
                categoryInfoData.mType = 4L;
                categoryInfoData.mDownloadPath = string;
                categoryInfoData.mSize = j4;
                categoryInfoData.mMimeType = string2;
                categoryInfoData.mCompletionTime = j5;
                categoryInfoData.mIsLocal = true;
                arrayList.add(categoryInfoData);
                columnIndexOrThrow4 = i2;
                j2 = 1000;
            }
        }
        Closeables.closeSafely(cursor);
        return arrayList;
    }

    public long queryLastOrFirstDataByCategory(int i, DocClassifyHelper.DocCategroy docCategroy, boolean z) {
        ArrayList<String> mimeTypesByType;
        String str;
        if (docCategroy != null) {
            mimeTypesByType = DocClassifyHelper.getMimeTypesByType(docCategroy);
        } else {
            mimeTypesByType = FileClassifyHelper.getMimeTypesByType(i);
        }
        long j = -1;
        if (mimeTypesByType.size() == 0) {
            return -1L;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str2 = "mime_type IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX;
        if (z) {
            str = "date_modified DESC ";
        } else {
            str = "date_modified ASC ";
        }
        String str3 = str;
        Cursor cursor = null;
        try {
            try {
                cursor = DownloadMediaHelper.query(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH).buildUpon().appendQueryParameter(Constants.EXTRA_CONFIG_LIMIT, "1").build(), new String[]{"date_modified"}, str2, null, str3, 1);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToNext();
                    j = cursor.getLong(cursor.getColumnIndexOrThrow("date_modified")) * 1000;
                }
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    throw new DebugException("getLocalFilesByType", e);
                }
            }
            return j;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public void refreshLocalDataCount(String str, boolean z) {
        Integer num;
        Integer valueOf;
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.mLocalDataCount;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str) || (num = this.mLocalDataCount.get(str)) == null) {
            return;
        }
        if (z) {
            valueOf = Integer.valueOf(num.intValue() + 1);
        } else {
            valueOf = Integer.valueOf(num.intValue() - 1);
        }
        if (valueOf.intValue() < 0) {
            valueOf = 0;
        }
        this.mLocalDataCount.put(str, valueOf);
    }

    public void refreshLocalDataType(String str, String str2, boolean z) {
        ConcurrentHashMap<String, String> concurrentHashMap = this.mLocalDataType;
        if (concurrentHashMap == null) {
            return;
        }
        if (z) {
            concurrentHashMap.put(str, str2);
        } else {
            concurrentHashMap.remove(str);
        }
    }

    public void registerMediaStoreContentObserver(Uri uri, IContentObserver iContentObserver) {
        MediaStoreContentObserver mediaStoreContentObserver = this.mUriToObserver.get(uri);
        if (mediaStoreContentObserver == null) {
            mediaStoreContentObserver = new MediaStoreContentObserver(null);
            this.mUriToObserver.put(uri, mediaStoreContentObserver);
            try {
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(uri, true, mediaStoreContentObserver);
            } catch (Exception unused) {
            }
        }
        mediaStoreContentObserver.addListener(iContentObserver);
    }

    public void unregisterMediaStoreContentObserver(Uri uri, IContentObserver iContentObserver) {
        MediaStoreContentObserver mediaStoreContentObserver;
        if (uri == null || (mediaStoreContentObserver = this.mUriToObserver.get(uri)) == null) {
            return;
        }
        mediaStoreContentObserver.removeListener(iContentObserver);
        if (mediaStoreContentObserver.isListenersEmpty()) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(mediaStoreContentObserver);
            this.mUriToObserver.remove(uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scanLocalFilesByType() {
        HashSet<String> hashSet;
        boolean z;
        HashSet<String> hashSet2;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        int i5;
        String str3;
        if (!this.isInit && !this.isScanning && !this.mIsDeleting) {
            this.mLocalDataCount = new ConcurrentHashMap<>();
            PreferenceUtils.setLong(DOWNLOAD_LAST_SCAN_LOCAL_TIME, System.currentTimeMillis());
            this.isScanning = true;
            Cursor cursor = null;
            HashSet<String> hashSet3 = new HashSet<>();
            ArrayList<ContentValues> arrayList = new ArrayList<>();
            HashMap<String, Long> hashMap = new HashMap<>();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("mime_type");
                sb.append(" is NOT NULL");
                sb.append(" AND ");
                sb.append("mime_type");
                sb.append(" in (");
                for (Map.Entry<String, Integer> entry : FileClassifyHelper.sMimeTypeExtensionToTypeMap.entrySet()) {
                    if (entry.getValue().intValue() != 5 && entry.getValue().intValue() != 2) {
                        String substring = entry.getKey().substring(0, entry.getKey().indexOf("@"));
                        sb.append("'");
                        sb.append(substring);
                        sb.append("',");
                    }
                }
                cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH), null, sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX, null, null);
                if (cursor != null) {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("mime_type");
                    int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_data");
                    int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("_size");
                    int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("date_modified");
                    int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("duration");
                    File downloadPrivateFile = DownloadHelper.getDownloadPrivateFile();
                    if (downloadPrivateFile == null) {
                        str = "";
                    } else {
                        str = downloadPrivateFile.getAbsolutePath();
                    }
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(columnIndexOrThrow2);
                        if (!TextUtils.isEmpty(string) && new File(string).exists() && ((TextUtils.isEmpty(str) || !string.startsWith(str)) && DownloadCenterUtils.checkFileDirNormal(string))) {
                            String string2 = cursor.getString(columnIndexOrThrow);
                            i = columnIndexOrThrow;
                            String fileNameWithSuffix = getFileNameWithSuffix(string);
                            if (!TextUtils.isEmpty(fileNameWithSuffix)) {
                                i5 = columnIndexOrThrow2;
                                String fileTypeString = DownloadHelper.getFileTypeString(string, string2);
                                str2 = str;
                                if (TextUtils.equals("other", fileTypeString)) {
                                    hashSet2 = hashSet3;
                                    i4 = columnIndexOrThrow3;
                                } else {
                                    hashSet3.add(string);
                                    Integer num = this.mLocalDataCount.get(fileTypeString);
                                    if (num == null) {
                                        num = 0;
                                    }
                                    if (!TextUtils.isEmpty(fileNameWithSuffix)) {
                                        hashSet2 = hashSet3;
                                        try {
                                            str3 = fileNameWithSuffix.toLowerCase(Locale.getDefault());
                                        } catch (Exception e) {
                                            e = e;
                                            hashSet = hashSet2;
                                            try {
                                                if (AppConfig.isDebug()) {
                                                    e.printStackTrace();
                                                }
                                                z = false;
                                                this.isInit = false;
                                                Closeables.closeSafely(cursor);
                                                patchAllLocalVideoDuration(hashMap);
                                                isFilePathRepeat(hashSet, true);
                                                if (hashSet.size() != 0) {
                                                    insertLocalData(hashSet, arrayList);
                                                    arrayList.clear();
                                                }
                                                this.isScanning = z;
                                                return this.isInit;
                                            } catch (Throwable th) {
                                                th = th;
                                                Closeables.closeSafely(cursor);
                                                patchAllLocalVideoDuration(hashMap);
                                                isFilePathRepeat(hashSet, true);
                                                if (hashSet.size() != 0) {
                                                    insertLocalData(hashSet, arrayList);
                                                    arrayList.clear();
                                                }
                                                this.isScanning = false;
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            hashSet = hashSet2;
                                            Closeables.closeSafely(cursor);
                                            patchAllLocalVideoDuration(hashMap);
                                            isFilePathRepeat(hashSet, true);
                                            if (hashSet.size() != 0) {
                                            }
                                            this.isScanning = false;
                                            throw th;
                                        }
                                    } else {
                                        hashSet2 = hashSet3;
                                        str3 = "";
                                    }
                                    FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str3), string2);
                                    boolean filterSystemLogName = LocalFilesFilterKt.filterSystemLogName(fileNameWithSuffix);
                                    if (!filterSystemLogName) {
                                        num = Integer.valueOf(num.intValue() + 1);
                                    }
                                    this.mLocalDataCount.put(fileTypeString, num);
                                    if (TextUtils.equals("video", fileTypeString)) {
                                        long j = cursor.getLong(columnIndexOrThrow3);
                                        int i6 = columnIndexOrThrow3;
                                        long j2 = cursor.getLong(columnIndexOrThrow5) / 1000;
                                        if (j != 0 && j2 != 0) {
                                            ContentValues contentValues = new ContentValues();
                                            i4 = i6;
                                            i3 = columnIndexOrThrow4;
                                            StringBuilder sb2 = new StringBuilder();
                                            i2 = columnIndexOrThrow5;
                                            sb2.append("content:/");
                                            sb2.append(string);
                                            contentValues.put("uri", sb2.toString());
                                            contentValues.put("mimetype", string2);
                                            contentValues.put("_data", string);
                                            contentValues.put("status", (Integer) 200);
                                            contentValues.put("total_bytes", Long.valueOf(j));
                                            contentValues.put("hint", fileNameWithSuffix);
                                            contentValues.put("title", fileNameWithSuffix);
                                            contentValues.put("lastmod", Long.valueOf(cursor.getLong(columnIndexOrThrow4) * 1000));
                                            contentValues.put("destination", (Integer) 0);
                                            contentValues.put("no_integrity", Boolean.TRUE);
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("duration", j2);
                                            contentValues.put("extra_info", jSONObject.toString());
                                            hashMap.put(string, Long.valueOf(j2));
                                            arrayList.add(contentValues);
                                        }
                                        i4 = i6;
                                    } else {
                                        i4 = columnIndexOrThrow3;
                                        i3 = columnIndexOrThrow4;
                                        i2 = columnIndexOrThrow5;
                                        if (this.mLocalDataType == null) {
                                            this.mLocalDataType = new ConcurrentHashMap<>();
                                        }
                                        if (!filterSystemLogName) {
                                            this.mLocalDataType.put(string, fileTypeString);
                                        }
                                    }
                                    columnIndexOrThrow = i;
                                    columnIndexOrThrow2 = i5;
                                    str = str2;
                                    hashSet3 = hashSet2;
                                    columnIndexOrThrow3 = i4;
                                    columnIndexOrThrow4 = i3;
                                    columnIndexOrThrow5 = i2;
                                }
                                i3 = columnIndexOrThrow4;
                                i2 = columnIndexOrThrow5;
                                columnIndexOrThrow = i;
                                columnIndexOrThrow2 = i5;
                                str = str2;
                                hashSet3 = hashSet2;
                                columnIndexOrThrow3 = i4;
                                columnIndexOrThrow4 = i3;
                                columnIndexOrThrow5 = i2;
                            } else {
                                hashSet2 = hashSet3;
                                i5 = columnIndexOrThrow2;
                                i4 = columnIndexOrThrow3;
                                i3 = columnIndexOrThrow4;
                                i2 = columnIndexOrThrow5;
                                str2 = str;
                                columnIndexOrThrow = i;
                                columnIndexOrThrow2 = i5;
                                str = str2;
                                hashSet3 = hashSet2;
                                columnIndexOrThrow3 = i4;
                                columnIndexOrThrow4 = i3;
                                columnIndexOrThrow5 = i2;
                            }
                        }
                        i = columnIndexOrThrow;
                        hashSet2 = hashSet3;
                        i5 = columnIndexOrThrow2;
                        i4 = columnIndexOrThrow3;
                        i3 = columnIndexOrThrow4;
                        i2 = columnIndexOrThrow5;
                        str2 = str;
                        columnIndexOrThrow = i;
                        columnIndexOrThrow2 = i5;
                        str = str2;
                        hashSet3 = hashSet2;
                        columnIndexOrThrow3 = i4;
                        columnIndexOrThrow4 = i3;
                        columnIndexOrThrow5 = i2;
                    }
                }
                hashSet2 = hashSet3;
                this.isInit = true;
                Closeables.closeSafely(cursor);
                patchAllLocalVideoDuration(hashMap);
                isFilePathRepeat(hashSet2, true);
                if (hashSet2.size() != 0) {
                    insertLocalData(hashSet2, arrayList);
                    arrayList.clear();
                }
                z = false;
            } catch (Exception e2) {
                e = e2;
                hashSet = hashSet3;
            } catch (Throwable th3) {
                th = th3;
                hashSet = hashSet3;
            }
            this.isScanning = z;
            return this.isInit;
        }
        return false;
    }
}
