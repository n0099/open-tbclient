package com.baidu.searchbox.download.business.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.media.ImageScanner;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.boxdownload.IBoxDownloadDbOperator;
import com.baidu.searchbox.boxdownload.ICyberInvoker;
import com.baidu.searchbox.boxdownload.model.DownloadDbItem;
import com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo;
import com.baidu.searchbox.boxdownload.model.VideoDownloadInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.callback.AppDownloadListener;
import com.baidu.searchbox.download.callback.DownloadListener;
import com.baidu.searchbox.download.callback.IAppDownloadListener;
import com.baidu.searchbox.download.component.DownloadProvider;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.DownloadingInfo;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.table.SearchBoxDownloadTable;
import com.baidu.searchbox.download.util.DocClassifyHelper;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.download.util.LocalDataScanHelper;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.x20;
import com.baidu.tieba.z;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadCenterUtils {
    public static final int DEFAULT_DELETE_COUNT = 20;
    public static final int DEFAULT_DELETE_DURATION = 150;
    public static final int DEFAULT_DELETE_TOAST_DURATION = 2;
    public static final String HAS_PATCH_ALL_LOCAL_VIDEO_DURATION = "has_patch_all_local_video_duration";
    public static final String INSTALL_APP_ICON = "install_app_icon";
    public static final String INSTALL_APP_NAME = "install_app_name";
    public static final String INSTALL_APP_PATH = "install_app_path";
    public static final String SHOW_APK_CHECK_REQUEST_INTERVAL = "show_app_check_request_interval";
    public static final String SHOW_APK_INSTALL_GUIDE = "show_app_install_guide";
    public static final String SHOW_APK_INSTALL_GUIDE_INTERVAL = "show_app_install_guide_interval";
    public static final String SHOW_APK_INSTALL_GUIDE_MAX_NUM = "show_app_install_guide_max_num";
    public static final String SHOW_APK_INSTALL_GUIDE_NUM = "show_app_install_guide_num";
    public static final String SHOW_APK_INSTALL_GUIDE_TIME = "show_app_install_guide_time";
    public static int mOtherDataCount;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String[] PROJECTIONS_FILTER_BY_TYPE = {"_id", "title", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "_data", "extra_info", "uri", "deleted", "business_type", "business_id", Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, "source", Downloads.Impl.COLUMN_OPEN_TIME, Downloads.Impl.COLUMN_OPEN_READ, "progress"};

    public static void clearNetdiskUploadInfo() {
        ContentValues contentValues = new ContentValues();
        contentValues.putNull(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO);
        AppRuntime.getAppContext().getContentResolver().update(Downloads.CONTENT_URI, contentValues, null, null);
    }

    public static int getOtherDataCount() {
        return mOtherDataCount;
    }

    public static ArrayList<CategoryInfoData> queryDownloaded(boolean z, long j, long j2, int i) {
        return queryDownloaded(z, j, j2, i, false, false);
    }

    public static boolean checkFileAvailable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception e) {
            if (!DEBUG) {
                return false;
            }
            throw new DebugException("DownloadCenterUtils.checkFileAvailable(String path) : path = " + DownloadHelper.getDisplayString(str), e);
        }
    }

    public static boolean checkFileDirNormal(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (Environment.getExternalStorageDirectory() != null && str.startsWith(Environment.getExternalStorageDirectory().toString())) {
            return true;
        }
        if (AppRuntime.getApplication().getFilesDir() == null || !str.startsWith(AppRuntime.getApplication().getFilesDir().getParent())) {
            return false;
        }
        return true;
    }

    public static boolean isHasFileInDownloadDbByPath(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.CONTENT_URI, new String[]{"_id"}, "_data = ?", new String[]{str}, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
            return z;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static String joinString(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("'" + it.next() + "'");
        }
        return TextUtils.join(",", arrayList);
    }

    public static long queryDownloadDataByPath(String str) {
        String[] strArr = {str};
        Cursor cursor = null;
        long j = -1;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "_data= ?", strArr, null);
                if (cursor != null && cursor.moveToFirst()) {
                    j = cursor.getLong(cursor.getColumnIndex("_id"));
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return j;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static void delDeleUriIdCallback(Set<CategoryInfoData> set, DownloadMediaHelper.CallBack<ArrayList<Long>> callBack, HashMap<Uri, String> hashMap, ArrayList<Uri> arrayList) {
        if (callBack != null && set != null && !set.isEmpty() && arrayList != null && hashMap != null) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            for (CategoryInfoData categoryInfoData : set) {
                Iterator<Uri> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(categoryInfoData.mDownloadPath, hashMap.get(it.next()))) {
                        arrayList2.add(Long.valueOf(categoryInfoData.mId));
                    }
                }
            }
            callBack.callback(arrayList2);
        }
    }

    public static void deleteDownloadInfo(CategoryInfoData categoryInfoData, z zVar) {
        if (categoryInfoData.mIsLocal) {
            DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), categoryInfoData.mDownloadPath, categoryInfoData.mMimeType, zVar);
            return;
        }
        DownloadManagerExt.getInstance().deleteDownloadFile(categoryInfoData.mId);
        if (zVar != null) {
            zVar.onPermitted(1);
        }
    }

    public static long getFileOpenTime(CategoryInfoData categoryInfoData, long j) {
        if (categoryInfoData == null) {
            return j;
        }
        String str = categoryInfoData.mExtraInfo;
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return new JSONObject(str).optLong(Downloads.Impl.COLUMN_EXTRA_INFO_OPEN_TIME, j);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return j;
        }
    }

    public static List<CategoryInfoData> queryHasOpenDatas(boolean z, int i) {
        return queryHasOpenDatas(z, i, null);
    }

    public static AppDownloadListener registerAppDownloadListener(Uri uri, IAppDownloadListener iAppDownloadListener) {
        AppDownloadListener appDownloadListener = new AppDownloadListener(AppRuntime.getAppContext(), uri, iAppDownloadListener);
        DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), uri, appDownloadListener);
        return appDownloadListener;
    }

    public static void setTouchDelegate(final View view2, final int i) {
        final View view3 = (View) view2.getParent();
        view3.post(new Runnable() { // from class: com.baidu.searchbox.download.business.util.DownloadCenterUtils.4
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view2.getHitRect(rect);
                int i2 = rect.top;
                int i3 = i;
                rect.top = i2 - i3;
                rect.bottom += i3;
                rect.left -= i3;
                rect.right += i3;
                view3.setTouchDelegate(new TouchDelegate(rect, view2));
            }
        });
    }

    public static void unregisterAppDownloadListener(Uri uri, DownloadListener downloadListener) {
        if (downloadListener != null) {
            DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri, downloadListener);
        }
    }

    public static void updateExtralInfo(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("extra_info", str);
        AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, "_id= ? ", new String[]{String.valueOf(j)});
    }

    public static void deleteDownloadInfo(Set<CategoryInfoData> set) {
        deleteDownloadInfo(set, (DownloadMediaHelper.CallBack<ArrayList<Long>>) null);
    }

    public static boolean getIllegal(CategoryInfoData categoryInfoData) {
        if (categoryInfoData == null) {
            return true;
        }
        NetdiskUploadInfo netdiskUploadInfo = categoryInfoData.mNetdiskUploadInfo;
        if (netdiskUploadInfo == null) {
            return false;
        }
        return netdiskUploadInfo.getIllegal();
    }

    public static VideoDownloadInfo getVideoDownloadInfo(CategoryInfoData categoryInfoData) {
        if (categoryInfoData == null) {
            return null;
        }
        try {
            return (VideoDownloadInfo) new Gson().fromJson(categoryInfoData.mExtraInfo, (Class<Object>) VideoDownloadInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int markRowDeleted(long... jArr) {
        return DownloadManagerExt.getInstance().markRowDeleted(jArr);
    }

    public static int queryDownloadDocDataCountByCategory(DocClassifyHelper.DocCategroy docCategroy) {
        return queryDownloadDocDataCountByCategory(docCategroy, null);
    }

    public static CategoryInfoData queryDownloadItem(long j) {
        return queryDownloadItem(j, true);
    }

    public static void setOtherDataCount(int i) {
        mOtherDataCount = i;
    }

    public static void deleteDownloadInfo(final Set<CategoryInfoData> set, final DownloadMediaHelper.CallBack<ArrayList<Long>> callBack) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] strArr = new String[set.size()];
        int i = 0;
        for (CategoryInfoData categoryInfoData : set) {
            if (categoryInfoData.mIsLocal) {
                arrayList2.add(categoryInfoData);
            } else {
                arrayList.add(categoryInfoData);
            }
            strArr[i] = categoryInfoData.mDownloadPath;
            i++;
        }
        final ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        final HashMap hashMap = new HashMap();
        if (arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                CategoryInfoData categoryInfoData2 = (CategoryInfoData) it.next();
                if (DownloadMediaHelper.isOpenScopedStorage()) {
                    arrayList3.add(categoryInfoData2.mDownloadPath);
                    Uri queryMediaFileUri = DownloadMediaHelper.queryMediaFileUri(AppRuntime.getAppContext(), categoryInfoData2.mDownloadPath, categoryInfoData2.mMimeType);
                    arrayList4.add(queryMediaFileUri);
                    hashMap.put(queryMediaFileUri, categoryInfoData2.mDownloadPath);
                } else {
                    DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), categoryInfoData2.mDownloadPath, categoryInfoData2.mMimeType);
                }
                String fileTypeString = DownloadHelper.getFileTypeString(categoryInfoData2.mDownloadPath, categoryInfoData2.mMimeType);
                LocalDataScanHelper.getInstance().refreshLocalDataCount(fileTypeString, false);
                LocalDataScanHelper.getInstance().refreshLocalDataType(categoryInfoData2.mDownloadPath, fileTypeString, false);
            }
            if (DownloadMediaHelper.isOpenScopedStorage() && arrayList.size() == 0) {
                DownloadMediaHelper.deleteByUriList(AppRuntime.getAppContext(), arrayList4, new DownloadMediaHelper.CallBack<ArrayList<Uri>>() { // from class: com.baidu.searchbox.download.business.util.DownloadCenterUtils.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.download.util.DownloadMediaHelper.CallBack
                    public void callback(ArrayList<Uri> arrayList5) {
                        DownloadCenterUtils.delDeleUriIdCallback(set, callBack, hashMap, arrayList5);
                    }
                });
            }
        }
        if (arrayList.size() > 0) {
            long[] jArr = new long[arrayList.size()];
            Iterator it2 = arrayList.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                CategoryInfoData categoryInfoData3 = (CategoryInfoData) it2.next();
                jArr[i2] = categoryInfoData3.mId;
                i2++;
                if (categoryInfoData3.mType == 5) {
                    mOtherDataCount--;
                }
            }
            DownloadManagerExt.getInstance().deleteDownloadFile(false, new DownloadMediaHelper.CallBack<ArrayList<String>>() { // from class: com.baidu.searchbox.download.business.util.DownloadCenterUtils.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.download.util.DownloadMediaHelper.CallBack
                public void callback(ArrayList<String> arrayList5) {
                    List list = arrayList3;
                    if (list != null && !list.isEmpty() && arrayList5 != null) {
                        arrayList5.addAll(arrayList3);
                    }
                }
            }, new DownloadMediaHelper.CallBack<ArrayList<Long>>() { // from class: com.baidu.searchbox.download.business.util.DownloadCenterUtils.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.download.util.DownloadMediaHelper.CallBack
                public void callback(ArrayList<Long> arrayList5) {
                    DownloadMediaHelper.CallBack callBack2 = DownloadMediaHelper.CallBack.this;
                    if (callBack2 != null) {
                        callBack2.callback(arrayList5);
                    }
                }
            }, jArr);
        }
        ImageScanner.scanFile(AppRuntime.getAppContext(), strArr, null, null);
    }

    public static long[] filterCyberDownloadOperate(ICyberInvoker iCyberInvoker, long... jArr) {
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            DownloadDbItem queryItem = ((IBoxDownloadDbOperator) ServiceManager.getService(IBoxDownloadDbOperator.Companion.getSERVICE_REFERENCE())).queryItem(j);
            if (queryItem != null && queryItem.getBusinessType() == 1 && !TextUtils.isEmpty(queryItem.getBusinessId())) {
                if (iCyberInvoker != null) {
                    iCyberInvoker.invoke(queryItem);
                }
            } else {
                arrayList.add(Long.valueOf(j));
            }
        }
        if (arrayList.size() > 0) {
            long[] jArr2 = new long[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                jArr2[i] = ((Long) arrayList.get(i)).longValue();
            }
            return jArr2;
        }
        return null;
    }

    public static int getErrorMessage(long j) {
        int i = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName()).query(new DownloadManager.Query().setFilterById(j));
                if (cursor != null && cursor.moveToFirst()) {
                    i = cursor.getInt(cursor.getColumnIndex("reason"));
                }
            } catch (Exception e) {
                if (DEBUG) {
                    throw new DebugException("DownloadCenterUtils.getErrorMessage()", e);
                }
            }
            return i;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static int queryDownloadingDataCount(boolean z) {
        Cursor cursor = null;
        try {
            try {
                DownloadManager.Query query = new DownloadManager.Query();
                DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
                query.setOnlyDownloading(true).orderBy(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP, 2).setOnlyIncludeVisibleInDownloadsUi(true);
                if (!z) {
                    query.setFilterBySelection(getFilterPrivateFileSql());
                }
                cursor = downloadManager.query(query);
                if (cursor != null) {
                    return cursor.getCount();
                }
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    throw new DebugException("DownloadCenterUtils.queryDownloading()", e);
                }
            }
            Closeables.closeSafely(cursor);
            return 0;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static void updateDocRecent(CategoryInfoData categoryInfoData) {
        JSONObject jSONObject;
        long j = categoryInfoData.mId;
        boolean z = true;
        if (categoryInfoData.mIsLocal) {
            j = queryDownloadDataByPath(categoryInfoData.mDownloadPath);
            if (j <= -1) {
                insertLocalData(categoryInfoData);
                z = false;
            }
        }
        if (z) {
            try {
                if (TextUtils.isEmpty(categoryInfoData.mExtraInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(categoryInfoData.mExtraInfo);
                }
                jSONObject.put(Downloads.Impl.COLUMN_EXTRA_INFO_OPEN_TIME, String.valueOf(System.currentTimeMillis()));
                updateExtralInfo(j, jSONObject.toString());
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getFilterPrivateFileSql() {
        String parent = DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent();
        return " AND (_data like '%" + parent + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)";
    }

    public static int queryVideoCount() {
        DownloadManager.Query query = new DownloadManager.Query();
        DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
        String sQliteSelectionByCategory = FileClassifyHelper.getSQliteSelectionByCategory(0, null);
        query.setFilterByStatus(8);
        query.setOnlyIncludeVisibleInDownloadsUi(true);
        try {
            Cursor queryDownload = downloadManager.queryDownload(query.setFilterBySelection(sQliteSelectionByCategory).orderBy(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP, 2));
            if (queryDownload != null && !queryDownload.isClosed()) {
                return queryDownload.getCount();
            }
            return 0;
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (!DEBUG) {
                return 0;
            }
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0127, code lost:
        if (r0 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x012a, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0117, code lost:
        if (r0 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0119, code lost:
        r0.endTransaction();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long insertLocalData(CategoryInfoData categoryInfoData) {
        ContentValues contentValues = new ContentValues();
        JSONObject jSONObject = new JSONObject();
        long j = -1;
        try {
            jSONObject.put(Downloads.Impl.COLUMN_EXTRA_INFO_OPEN_TIME, String.valueOf(System.currentTimeMillis()));
            contentValues.put("uri", "content:/" + categoryInfoData.mDownloadPath);
            contentValues.put("mimetype", categoryInfoData.mMimeType);
            contentValues.put("_data", categoryInfoData.mDownloadPath);
            contentValues.put("status", (Integer) 200);
            contentValues.put("total_bytes", Long.valueOf(categoryInfoData.mSize));
            contentValues.put("hint", categoryInfoData.mFileName);
            contentValues.put("title", categoryInfoData.mFileName);
            contentValues.put("lastmod", Long.valueOf(categoryInfoData.mCompletionTime));
            contentValues.put("destination", (Integer) 0);
            contentValues.put("no_integrity", Boolean.TRUE);
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
                SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("insert into downloads(uri,mimetype,_data,status,total_bytes,hint,title,lastmod,destination,no_integrity,visibility,deleted,is_visible_in_downloads_ui,uid,scanned,extra_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                sQLiteDatabase.beginTransaction();
                compileStatement.bindString(1, "content:/" + categoryInfoData.mDownloadPath);
                compileStatement.bindString(2, categoryInfoData.mMimeType);
                compileStatement.bindString(3, categoryInfoData.mDownloadPath);
                compileStatement.bindLong(4, 200L);
                compileStatement.bindLong(5, categoryInfoData.mSize);
                compileStatement.bindString(6, categoryInfoData.mFileName);
                compileStatement.bindString(7, categoryInfoData.mFileName);
                compileStatement.bindLong(8, categoryInfoData.mCompletionTime);
                compileStatement.bindLong(9, 0L);
                compileStatement.bindLong(10, 1L);
                compileStatement.bindLong(11, 2L);
                compileStatement.bindLong(12, 0L);
                compileStatement.bindLong(13, 1L);
                compileStatement.bindLong(14, Binder.getCallingUid());
                compileStatement.bindLong(15, 1L);
                compileStatement.bindString(16, jSONObject.toString());
                j = compileStatement.executeInsert();
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    if (AppConfig.isDebug()) {
                        th.printStackTrace();
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
        } catch (JSONException unused2) {
            return -1L;
        }
    }

    public static void moveDocRecentData(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> mimeTypesByType = DocClassifyHelper.getMimeTypesByType(DocClassifyHelper.DocCategroy.RECENT);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str = ((("mimetype IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX) + " AND extra_info IS NOT NULL") + " AND is_visible_in_downloads_ui != '0'") + " AND status = '200'";
        if (!x20.d(x20.a)) {
            str = str + getFilterPrivateFileSql();
        }
        Cursor query = sQLiteDatabase.query("downloads", new String[]{"_id", "extra_info"}, str, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    try {
                        long j = query.getLong(query.getColumnIndex("_id"));
                        long optLong = new JSONObject(query.getString(query.getColumnIndex("extra_info"))).optLong(Downloads.Impl.COLUMN_EXTRA_INFO_OPEN_TIME, -1L);
                        if (optLong != -1) {
                            CategoryInfoData categoryInfoData = new CategoryInfoData();
                            categoryInfoData.mId = j;
                            categoryInfoData.mOpenTime = optLong;
                            arrayList.add(categoryInfoData);
                        }
                    } catch (Exception e) {
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    Closeables.closeSafely(query);
                    throw th;
                }
            }
        }
        Closeables.closeSafely(query);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CategoryInfoData categoryInfoData2 = (CategoryInfoData) it2.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Impl.COLUMN_OPEN_TIME, Long.valueOf(categoryInfoData2.mOpenTime));
            contentValues.put(Downloads.Impl.COLUMN_OPEN_READ, Boolean.TRUE);
            sQLiteDatabase.update("downloads", contentValues, "_id =  ? ", new String[]{String.valueOf(categoryInfoData2.mId)});
        }
    }

    public static ArrayList<CategoryInfoData> queryDownloadedCountInfo(int i) {
        boolean z;
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        ArrayList<String> mimeTypesByType = FileClassifyHelper.getMimeTypesByType(i);
        if (mimeTypesByType.size() == 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND mimetype IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX;
        if (!x20.d(x20.a)) {
            str = str + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NOT NULL)");
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id", "title", "_data", "mimetype"}, str2, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, null);
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("_id");
                    int columnIndex2 = cursor.getColumnIndex("mimetype");
                    int columnIndex3 = cursor.getColumnIndex("title");
                    int columnIndex4 = cursor.getColumnIndex("_data");
                    cursor.moveToFirst();
                    do {
                        String string = cursor.getString(columnIndex2);
                        String string2 = cursor.getString(columnIndex4);
                        if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string2), string) == i) {
                            CategoryInfoData categoryInfoData = new CategoryInfoData();
                            String string3 = cursor.getString(columnIndex3);
                            categoryInfoData.mId = cursor.getLong(columnIndex);
                            categoryInfoData.mMimeType = string;
                            categoryInfoData.mType = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string3), categoryInfoData.mMimeType);
                            categoryInfoData.mDownloadPath = string2;
                            if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            categoryInfoData.newFlag = z;
                            arrayList.add(categoryInfoData);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b5, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b7, code lost:
        r13.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d0, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long insertLocalDataToDownloadTable(CategoryInfoData categoryInfoData) {
        String str;
        long j = -1;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("insert into downloads(uri,mimetype,_data,status,total_bytes,hint,title,lastmod,destination,no_integrity,visibility,deleted,is_visible_in_downloads_ui,uid,scanned,extra_info,current_bytes) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sQLiteDatabase.beginTransaction();
            compileStatement.bindString(1, "content:/" + categoryInfoData.mDownloadPath);
            String str2 = "";
            if (categoryInfoData.mMimeType == null) {
                str = "";
            } else {
                str = categoryInfoData.mMimeType;
            }
            compileStatement.bindString(2, str);
            compileStatement.bindString(3, categoryInfoData.mDownloadPath);
            compileStatement.bindLong(4, 200L);
            compileStatement.bindLong(5, categoryInfoData.mSize);
            compileStatement.bindString(6, categoryInfoData.mFileName);
            compileStatement.bindString(7, categoryInfoData.mFileName);
            compileStatement.bindLong(8, categoryInfoData.mCompletionTime);
            compileStatement.bindLong(9, 0L);
            compileStatement.bindLong(10, 1L);
            compileStatement.bindLong(11, 2L);
            compileStatement.bindLong(12, 0L);
            compileStatement.bindLong(13, 1L);
            compileStatement.bindLong(14, Binder.getCallingUid());
            compileStatement.bindLong(15, 1L);
            if (categoryInfoData.mExtraInfo != null) {
                str2 = categoryInfoData.mExtraInfo;
            }
            compileStatement.bindString(16, str2);
            compileStatement.bindLong(17, categoryInfoData.mSize);
            j = compileStatement.executeInsert();
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (Throwable th2) {
            try {
                if (AppConfig.isDebug()) {
                    th2.printStackTrace();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Throwable th4) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th5) {
                        if (AppConfig.isDebug()) {
                            th5.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
        return j;
    }

    public static int queryDownloadDataCountByCategory(int i) {
        if (i == 5) {
            return mOtherDataCount;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? ");
        Cursor cursor = null;
        sb.append(FileClassifyHelper.getSQliteSelectionByCategory(i, null));
        String sb2 = sb.toString();
        if (!x20.d(x20.a)) {
            sb2 = sb2 + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
        }
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data", "mimetype"}, sb2, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "");
                if (cursor != null) {
                    int columnIndex = cursor.getColumnIndex("mimetype");
                    int columnIndex2 = cursor.getColumnIndex("_data");
                    int count = cursor.getCount();
                    cursor.moveToFirst();
                    do {
                        if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(cursor.getString(columnIndex2)), cursor.getString(columnIndex)) != i) {
                            count--;
                        }
                    } while (cursor.moveToNext());
                    return count;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static List<String> queryDownloadedM3u8Path(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                String str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND lower(mimetype)= ?";
                if (!x20.d(x20.a)) {
                    str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND lower(mimetype)= ?" + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
                }
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, str, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1), "application/vnd.apple.mpegurl"}, "status asc LIMIT 0," + i);
                if (cursor != null) {
                    int columnIndex = cursor.getColumnIndex("_data");
                    cursor.moveToFirst();
                    do {
                        String string = cursor.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static int queryAllDownloadedCount(boolean z) {
        String str = " AND uri not like '%content://%'";
        if (!z) {
            str = " AND uri not like '%content://%'" + getFilterPrivateFileSql();
        }
        Cursor cursor = null;
        try {
            try {
                DownloadManager.Query query = new DownloadManager.Query();
                DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
                query.setOnlyIncludeVisibleInDownloadsUi(true).setOnlyDownloading(false).setFilterByStatus(8).setFilterBySelection(str);
                cursor = downloadManager.query(query, new String[]{"_id"});
                if (cursor != null && cursor.getCount() > 0) {
                    return cursor.getCount();
                }
            } catch (Exception e) {
                if (DEBUG) {
                    throw new DebugException("queryAllCategory", e);
                }
            }
            return 0;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static int queryDownloadDocDataCountByCategory(DocClassifyHelper.DocCategroy docCategroy, List<String> list) {
        String str;
        ArrayList<String> mimeTypesByType = DocClassifyHelper.getMimeTypesByType(docCategroy);
        int i = 0;
        if (mimeTypesByType.size() == 0) {
            return 0;
        }
        if (list != null && !list.isEmpty()) {
            str = ("status= ? AND (" + Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI + " = ? OR ") + "source IN (" + joinString(list) + ")) AND ";
        } else {
            str = "status= ? AND " + Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI + " = ? AND ";
        }
        String str2 = (str + "deleted!= ? AND ") + "mimetype IN (";
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str3 = str2 + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX;
        if (!x20.d(x20.a)) {
            str3 = str3 + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
        }
        String str4 = str3;
        String[] strArr = {String.valueOf(200), String.valueOf(1), String.valueOf(1)};
        Cursor cursor = null;
        try {
            try {
                if (docCategroy == DocClassifyHelper.DocCategroy.RECENT) {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info", "_data"}, str4, strArr, "");
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("extra_info");
                        int columnIndex2 = cursor.getColumnIndex("_data");
                        cursor.moveToFirst();
                        do {
                            if (checkFileAvailable(cursor.getString(columnIndex2))) {
                                String string = cursor.getString(columnIndex);
                                if (!TextUtils.isEmpty(string) && new JSONObject(string).optLong(Downloads.Impl.COLUMN_EXTRA_INFO_OPEN_TIME, -1L) > 0) {
                                    i++;
                                }
                            }
                        } while (cursor.moveToNext());
                    }
                } else {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, str4, strArr, "");
                    if (cursor != null) {
                        int columnIndex3 = cursor.getColumnIndex("_data");
                        cursor.moveToFirst();
                        do {
                            if (checkFileAvailable(cursor.getString(columnIndex3))) {
                                i++;
                            }
                        } while (cursor.moveToNext());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0154 A[Catch: all -> 0x015b, TRY_LEAVE, TryCatch #10 {all -> 0x015b, blocks: (B:31:0x0150, B:33:0x0154), top: B:94:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017f A[Catch: Exception -> 0x0204, all -> 0x0207, TryCatch #4 {all -> 0x0207, blocks: (B:4:0x0035, B:6:0x003b, B:7:0x0040, B:18:0x013e, B:43:0x017b, B:45:0x017f, B:46:0x018b, B:50:0x01ce, B:54:0x01df, B:56:0x01ed, B:59:0x01fb, B:61:0x01ff, B:36:0x015c, B:37:0x015f, B:34:0x0157, B:40:0x0164, B:42:0x016e), top: B:88:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021c A[Catch: all -> 0x0224, TRY_LEAVE, TryCatch #2 {all -> 0x0224, blocks: (B:76:0x0218, B:78:0x021c), top: B:86:0x0218 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CategoryInfoData queryDownloadItem(long j, boolean z) {
        Cursor cursor;
        CategoryInfoData categoryInfoData;
        Cursor cursor2;
        int i;
        boolean z2;
        boolean z3;
        String string;
        CategoryInfoData categoryInfoData2;
        try {
            DownloadManager.Query query = new DownloadManager.Query();
            DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
            query.setOnlyIncludeVisibleInDownloadsUi(z).setOnlyDownloading(false).setFilterById(j);
            Cursor query2 = downloadManager.query(query, PROJECTIONS_FILTER_BY_TYPE);
            if (query2 != null) {
                try {
                    try {
                        if (query2.getCount() > 0) {
                            categoryInfoData = new CategoryInfoData();
                            try {
                                int columnIndex = query2.getColumnIndex("_id");
                                int columnIndexOrThrow = query2.getColumnIndexOrThrow("status");
                                int columnIndex2 = query2.getColumnIndex("mimetype");
                                int columnIndex3 = query2.getColumnIndex("total_bytes");
                                int columnIndex4 = query2.getColumnIndex("_data");
                                int columnIndex5 = query2.getColumnIndex("title");
                                int columnIndex6 = query2.getColumnIndex("lastmod");
                                int columnIndex7 = query2.getColumnIndex("extra_info");
                                int columnIndexOrThrow2 = query2.getColumnIndexOrThrow("uri");
                                int columnIndexOrThrow3 = query2.getColumnIndexOrThrow("deleted");
                                int columnIndexOrThrow4 = query2.getColumnIndexOrThrow("business_type");
                                int columnIndexOrThrow5 = query2.getColumnIndexOrThrow(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO);
                                int columnIndexOrThrow6 = query2.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);
                                query2.moveToFirst();
                                Gson gson = new Gson();
                                String string2 = query2.getString(columnIndex2);
                                String string3 = query2.getString(columnIndex5);
                                int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string3), string2);
                                categoryInfoData.mId = query2.getLong(columnIndex);
                                categoryInfoData.mMimeType = string2;
                                categoryInfoData.mType = category;
                                categoryInfoData.mBusinessType = query2.getInt(columnIndexOrThrow4);
                                if (6 == category) {
                                    try {
                                        try {
                                            i = columnIndexOrThrow3;
                                        } catch (Exception e) {
                                            e = e;
                                            i = columnIndexOrThrow3;
                                        }
                                        try {
                                            Cursor searchboxDownloadCursor = IDownloadApp.Impl.get().getSearchboxDownloadCursor(categoryInfoData.mId);
                                            if (searchboxDownloadCursor != null) {
                                                try {
                                                    if (searchboxDownloadCursor.moveToFirst()) {
                                                        categoryInfoData.mStoryViewProgress = searchboxDownloadCursor.getFloat(searchboxDownloadCursor.getColumnIndex(SearchBoxDownloadTable.viewprogress.name()));
                                                        categoryInfoData.mStoryPosition = searchboxDownloadCursor.getString(searchboxDownloadCursor.getColumnIndex(SearchBoxDownloadTable.viewposition.name()));
                                                        categoryInfoData.mGid = searchboxDownloadCursor.getLong(searchboxDownloadCursor.getColumnIndex(SearchBoxDownloadTable.gid.name()));
                                                        categoryInfoData.mBookDirectoryUrl = searchboxDownloadCursor.getString(searchboxDownloadCursor.getColumnIndex(SearchBoxDownloadTable.booksrc.name()));
                                                        categoryInfoData.mBookType = searchboxDownloadCursor.getInt(searchboxDownloadCursor.getColumnIndex(SearchBoxDownloadTable.booktype.name()));
                                                        categoryInfoData.mFree = searchboxDownloadCursor.getString(searchboxDownloadCursor.getColumnIndex(SearchBoxDownloadTable.bookfree.name()));
                                                        Closeables.closeSafely(searchboxDownloadCursor);
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    cursor2 = searchboxDownloadCursor;
                                                    try {
                                                        if (DEBUG) {
                                                        }
                                                        Closeables.closeSafely(cursor2);
                                                        if (categoryInfoData.mBusinessType != 0) {
                                                        }
                                                        categoryInfoData.mSize = query2.getLong(columnIndex3);
                                                        categoryInfoData.mDownloadPath = query2.getString(columnIndex4);
                                                        categoryInfoData.mFileName = string3;
                                                        categoryInfoData.mCompletionTime = query2.getLong(columnIndex6);
                                                        categoryInfoData.mExtraInfo = query2.getString(columnIndex7);
                                                        categoryInfoData.mDownloadingInfo = new DownloadingInfo();
                                                        categoryInfoData.mDownloadingInfo.mUrl = query2.getString(columnIndexOrThrow2);
                                                        categoryInfoData.mDownloadingInfo.mStatus = query2.getInt(columnIndexOrThrow);
                                                        categoryInfoData.mDownloadingInfo.mCurrentSize = query2.getLong(columnIndexOrThrow6);
                                                        if (query2.getInt(i) == 1) {
                                                        }
                                                        categoryInfoData.mIsDeleted = z2;
                                                        if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                                                        }
                                                        categoryInfoData.newFlag = z3;
                                                        string = query2.getString(columnIndexOrThrow5);
                                                        if (!TextUtils.isEmpty(string)) {
                                                        }
                                                        categoryInfoData2 = categoryInfoData;
                                                        Closeables.closeSafely(query2);
                                                        return categoryInfoData2;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        Closeables.closeSafely(cursor2);
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    cursor2 = searchboxDownloadCursor;
                                                    Closeables.closeSafely(cursor2);
                                                    throw th;
                                                }
                                            }
                                            categoryInfoData.mStoryViewProgress = -1.0f;
                                            categoryInfoData.mStoryPosition = "";
                                            Closeables.closeSafely(searchboxDownloadCursor);
                                        } catch (Exception e3) {
                                            e = e3;
                                            cursor2 = null;
                                            if (DEBUG) {
                                                e.printStackTrace();
                                            }
                                            Closeables.closeSafely(cursor2);
                                            if (categoryInfoData.mBusinessType != 0) {
                                            }
                                            categoryInfoData.mSize = query2.getLong(columnIndex3);
                                            categoryInfoData.mDownloadPath = query2.getString(columnIndex4);
                                            categoryInfoData.mFileName = string3;
                                            categoryInfoData.mCompletionTime = query2.getLong(columnIndex6);
                                            categoryInfoData.mExtraInfo = query2.getString(columnIndex7);
                                            categoryInfoData.mDownloadingInfo = new DownloadingInfo();
                                            categoryInfoData.mDownloadingInfo.mUrl = query2.getString(columnIndexOrThrow2);
                                            categoryInfoData.mDownloadingInfo.mStatus = query2.getInt(columnIndexOrThrow);
                                            categoryInfoData.mDownloadingInfo.mCurrentSize = query2.getLong(columnIndexOrThrow6);
                                            if (query2.getInt(i) == 1) {
                                            }
                                            categoryInfoData.mIsDeleted = z2;
                                            if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                                            }
                                            categoryInfoData.newFlag = z3;
                                            string = query2.getString(columnIndexOrThrow5);
                                            if (!TextUtils.isEmpty(string)) {
                                            }
                                            categoryInfoData2 = categoryInfoData;
                                            Closeables.closeSafely(query2);
                                            return categoryInfoData2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor2 = null;
                                    }
                                } else {
                                    i = columnIndexOrThrow3;
                                    if (category == 3) {
                                        String string4 = query2.getString(columnIndex7);
                                        if (!TextUtils.isEmpty(string4)) {
                                            categoryInfoData.mAppIcon = new JSONObject(string4).optString("icon", "");
                                        }
                                    }
                                }
                                if (categoryInfoData.mBusinessType != 0) {
                                    categoryInfoData.businessId = query2.getString(query2.getColumnIndexOrThrow("business_id"));
                                }
                                categoryInfoData.mSize = query2.getLong(columnIndex3);
                                categoryInfoData.mDownloadPath = query2.getString(columnIndex4);
                                categoryInfoData.mFileName = string3;
                                categoryInfoData.mCompletionTime = query2.getLong(columnIndex6);
                                categoryInfoData.mExtraInfo = query2.getString(columnIndex7);
                                categoryInfoData.mDownloadingInfo = new DownloadingInfo();
                                categoryInfoData.mDownloadingInfo.mUrl = query2.getString(columnIndexOrThrow2);
                                categoryInfoData.mDownloadingInfo.mStatus = query2.getInt(columnIndexOrThrow);
                                categoryInfoData.mDownloadingInfo.mCurrentSize = query2.getLong(columnIndexOrThrow6);
                                if (query2.getInt(i) == 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                categoryInfoData.mIsDeleted = z2;
                                if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                categoryInfoData.newFlag = z3;
                                string = query2.getString(columnIndexOrThrow5);
                                if (!TextUtils.isEmpty(string)) {
                                    try {
                                        categoryInfoData.mNetdiskUploadInfo = (NetdiskUploadInfo) gson.fromJson(string, (Class<Object>) NetdiskUploadInfo.class);
                                    } catch (JsonSyntaxException e4) {
                                        if (DEBUG) {
                                            e4.printStackTrace();
                                        }
                                    }
                                }
                                categoryInfoData2 = categoryInfoData;
                                Closeables.closeSafely(query2);
                                return categoryInfoData2;
                            } catch (Exception e5) {
                                e = e5;
                                cursor = query2;
                                try {
                                    if (DEBUG) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    return categoryInfoData;
                                } catch (Throwable th4) {
                                    th = th4;
                                    Closeables.closeSafely(cursor);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        cursor = query2;
                        categoryInfoData = null;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return categoryInfoData;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
            categoryInfoData2 = null;
            Closeables.closeSafely(query2);
            return categoryInfoData2;
        } catch (Exception e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    public static String[] queryDownloadInfoByDownloadID(Context context, String str) {
        String[] strArr = new String[3];
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"mimetype", "title", "business_type", "extra_info"}, "_id= ?", new String[]{str}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("mimetype"));
                    String string2 = cursor.getString(cursor.getColumnIndex("title"));
                    int i = cursor.getInt(cursor.getColumnIndex("business_type"));
                    strArr[0] = string;
                    strArr[1] = string2;
                    if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string2), string) == 3) {
                        try {
                            strArr[2] = new JSONObject(cursor.getString(cursor.getColumnIndex("extra_info"))).optString("icon", "");
                        } catch (Exception e) {
                            if (DEBUG) {
                                throw new DebugException("DownloadCenterUtils.queryDownloadInfoByDownloadID()", e);
                            }
                        }
                    } else if (i == 1) {
                        String string3 = cursor.getString(cursor.getColumnIndex("extra_info"));
                        if (!TextUtils.isEmpty(string3)) {
                            try {
                                strArr[2] = ((VideoDownloadInfo) new Gson().fromJson(string3, (Class<Object>) VideoDownloadInfo.class)).getPoster();
                            } catch (JsonSyntaxException e2) {
                                if (DEBUG) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                if (DEBUG) {
                    throw new DebugException("DownloadCenterUtils.queryDownloadInfoByDownloadID()", e3);
                }
            }
            return strArr;
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:67:0x020e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.util.List<com.baidu.searchbox.download.model.CategoryInfoData> queryDownloadItemListByIds(long[] r22, boolean r23) {
        /*
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            r0.<init>()     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            com.baidu.searchbox.download.manager.DownloadManager r3 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            r4 = r23
            com.baidu.searchbox.download.manager.DownloadManager$Query r4 = r0.setOnlyIncludeVisibleInDownloadsUi(r4)     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            r5 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r4 = r4.setOnlyDownloading(r5)     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            r6 = r22
            r4.setFilterById(r6)     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            java.lang.String[] r4 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.PROJECTIONS_FILTER_BY_TYPE     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            android.database.Cursor r3 = r3.query(r0, r4)     // Catch: java.lang.Throwable -> L248 java.lang.Exception -> L24b
            if (r3 == 0) goto L243
            int r0 = r3.getCount()     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            if (r0 <= 0) goto L243
            java.lang.String r0 = "_id"
            int r4 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "status"
            int r6 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "mimetype"
            int r7 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "total_bytes"
            int r8 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "_data"
            int r9 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "title"
            int r10 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "lastmod"
            int r11 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "extra_info"
            int r12 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "uri"
            int r13 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "deleted"
            int r14 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "business_type"
            int r15 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "netdisk_upload_info"
            int r2 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            java.lang.String r0 = "bytes_so_far"
            int r5 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            r3.moveToFirst()     // Catch: java.lang.Throwable -> L23c java.lang.Exception -> L23f
            r16 = r1
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.<init>()     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r22 = r1
        L9b:
            com.baidu.searchbox.download.model.CategoryInfoData r1 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.<init>()     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            java.lang.String r0 = r3.getString(r7)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r17 = r7
            java.lang.String r7 = r3.getString(r10)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r18 = r10
            java.lang.String r10 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r7)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            int r10 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r10, r0)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r20 = r5
            r19 = r6
            long r5 = r3.getLong(r4)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mId = r5     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mMimeType = r0     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            long r5 = (long) r10     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mType = r5     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            int r0 = r3.getInt(r15)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mBusinessType = r0     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r0 = 6
            java.lang.String r5 = ""
            if (r0 != r10) goto L168
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch: java.lang.Throwable -> L152 java.lang.Exception -> L155
            r6 = r14
            r21 = r15
            long r14 = r1.mId     // Catch: java.lang.Exception -> L150 java.lang.Throwable -> L152
            android.database.Cursor r10 = r0.getSearchboxDownloadCursor(r14)     // Catch: java.lang.Exception -> L150 java.lang.Throwable -> L152
            if (r10 == 0) goto L144
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            if (r0 == 0) goto L144
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewprogress     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            float r0 = r10.getFloat(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            r1.mStoryViewProgress = r0     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewposition     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            r1.mStoryPosition = r0     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.gid     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            long r14 = r10.getLong(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            r1.mGid = r14     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booksrc     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            r1.mBookDirectoryUrl = r0     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booktype     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            int r0 = r10.getInt(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            r1.mBookType = r0     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.bookfree     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            r1.mFree = r0     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            goto L14a
        L144:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.mStoryViewProgress = r0     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
            r1.mStoryPosition = r5     // Catch: java.lang.Exception -> L14e java.lang.Throwable -> L162
        L14a:
            com.baidu.android.util.io.Closeables.closeSafely(r10)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            goto L18c
        L14e:
            r0 = move-exception
            goto L15a
        L150:
            r0 = move-exception
            goto L159
        L152:
            r0 = move-exception
            r2 = 0
            goto L164
        L155:
            r0 = move-exception
            r6 = r14
            r21 = r15
        L159:
            r10 = 0
        L15a:
            boolean r5 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Throwable -> L162
            if (r5 == 0) goto L14a
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L162
            goto L14a
        L162:
            r0 = move-exception
            r2 = r10
        L164:
            com.baidu.android.util.io.Closeables.closeSafely(r2)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            throw r0     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
        L168:
            r6 = r14
            r21 = r15
            r0 = 3
            if (r10 != r0) goto L18c
            java.lang.String r0 = r3.getString(r12)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            if (r10 != 0) goto L18c
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            r10.<init>(r0)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            java.lang.String r0 = "icon"
            java.lang.String r0 = r10.optString(r0, r5)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            r1.mAppIcon = r0     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            goto L18c
        L186:
            r0 = move-exception
            r2 = r3
            r10 = r16
            goto L24e
        L18c:
            int r0 = r1.mBusinessType     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            if (r0 == 0) goto L19c
            java.lang.String r0 = "business_id"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            r1.businessId = r0     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
        L19c:
            long r14 = r3.getLong(r8)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mSize = r14     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            java.lang.String r0 = r3.getString(r9)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mDownloadPath = r0     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mFileName = r7     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            long r14 = r3.getLong(r11)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mCompletionTime = r14     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            java.lang.String r0 = r3.getString(r12)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mExtraInfo = r0     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r0.<init>()     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r1.mDownloadingInfo = r0     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            java.lang.String r0 = r3.getString(r13)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            com.baidu.searchbox.download.model.DownloadingInfo r5 = r1.mDownloadingInfo     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r5.mUrl = r0     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r1.mDownloadingInfo     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r5 = r19
            int r7 = r3.getInt(r5)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r0.mStatus = r7     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r1.mDownloadingInfo     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r7 = r20
            long r14 = r3.getLong(r7)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r0.mCurrentSize = r14     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            int r0 = r3.getInt(r6)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            r10 = 1
            if (r0 != r10) goto L1e2
            r0 = 1
            goto L1e3
        L1e2:
            r0 = 0
        L1e3:
            r1.mIsDeleted = r0     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            long r14 = r1.mId     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            boolean r0 = r0.isRead(r14)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            if (r0 != 0) goto L1f2
            goto L1f3
        L1f2:
            r10 = 0
        L1f3:
            r1.newFlag = r10     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            java.lang.String r0 = r3.getString(r2)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L238 java.lang.Throwable -> L23c
            if (r10 != 0) goto L219
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r10 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r14 = r22
            java.lang.Object r0 = r14.fromJson(r0, r10)     // Catch: java.lang.Exception -> L186 com.google.gson.JsonSyntaxException -> L20c java.lang.Throwable -> L23c
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch: java.lang.Exception -> L186 com.google.gson.JsonSyntaxException -> L20c java.lang.Throwable -> L23c
            r1.mNetdiskUploadInfo = r0     // Catch: java.lang.Exception -> L186 com.google.gson.JsonSyntaxException -> L20c java.lang.Throwable -> L23c
            goto L21b
        L20c:
            r0 = move-exception
            goto L211
        L20e:
            r0 = move-exception
            r14 = r22
        L211:
            boolean r10 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            if (r10 == 0) goto L21b
            r0.printStackTrace()     // Catch: java.lang.Exception -> L186 java.lang.Throwable -> L23c
            goto L21b
        L219:
            r14 = r22
        L21b:
            r10 = r16
            r10.add(r1)     // Catch: java.lang.Exception -> L236 java.lang.Throwable -> L23c
            boolean r0 = r3.moveToNext()     // Catch: java.lang.Exception -> L236 java.lang.Throwable -> L23c
            if (r0 != 0) goto L227
            goto L244
        L227:
            r16 = r10
            r22 = r14
            r10 = r18
            r15 = r21
            r14 = r6
            r6 = r5
            r5 = r7
            r7 = r17
            goto L9b
        L236:
            r0 = move-exception
            goto L241
        L238:
            r0 = move-exception
            r10 = r16
            goto L241
        L23c:
            r0 = move-exception
            r2 = r3
            goto L25a
        L23f:
            r0 = move-exception
            r10 = r1
        L241:
            r2 = r3
            goto L24e
        L243:
            r10 = r1
        L244:
            com.baidu.android.util.io.Closeables.closeSafely(r3)
            goto L258
        L248:
            r0 = move-exception
            r2 = 0
            goto L25a
        L24b:
            r0 = move-exception
            r10 = r1
            r2 = 0
        L24e:
            boolean r1 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Throwable -> L259
            if (r1 == 0) goto L255
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L259
        L255:
            com.baidu.android.util.io.Closeables.closeSafely(r2)
        L258:
            return r10
        L259:
            r0 = move-exception
        L25a:
            com.baidu.android.util.io.Closeables.closeSafely(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloadItemListByIds(long[], boolean):java.util.List");
    }

    public static ArrayList<CategoryInfoData> queryDownloaded(boolean z, long j, long j2, int i, boolean z2, boolean z3) {
        return queryDownloaded(z, j, j2, i, true, z2, z3);
    }

    public static ArrayList<CategoryInfoData> queryDownloaded(boolean z, long j, long j2, int i, boolean z2, boolean z3, boolean z4) {
        return queryDownloaded(z, j, j2, i, z2, z3, z4, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:89:0x02fd
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.util.ArrayList<com.baidu.searchbox.download.model.CategoryInfoData> queryDownloaded(boolean r17, long r18, long r20, int r22, boolean r23, boolean r24, boolean r25, java.util.List<java.lang.String> r26) {
        /*
            r0 = r20
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r4.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r5 = " AND _id != "
            r4.append(r5)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r5 = r18
            r4.append(r5)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r5 = "lastmod"
            java.lang.String r6 = ")"
            if (r23 == 0) goto L48
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r4)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r4 = " AND (lastmod < "
            r7.append(r4)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r4 = " OR "
            r7.append(r4)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r5)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r4 = " = "
            r7.append(r4)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r6)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            goto L5f
        L48:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r4)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r4 = " AND (lastmod > "
            r7.append(r4)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7.append(r6)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
        L5f:
            if (r25 != 0) goto L72
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = " AND uri not like '%content://%'"
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
        L72:
            if (r26 == 0) goto Laa
            boolean r1 = r26.isEmpty()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            if (r1 == 0) goto L7b
            goto Laa
        L7b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = " AND (is_visible_in_downloads_ui != '0'"
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r1 = joinString(r26)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r4.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r4.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = " OR source IN ("
            r4.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r4.append(r1)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = "))"
            r4.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            goto Lbb
        Laa:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = " AND is_visible_in_downloads_ui != '0'"
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
        Lbb:
            if (r17 != 0) goto Ld0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = getFilterPrivateFileSql()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.append(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
        Ld0:
            com.baidu.searchbox.download.manager.DownloadManager$Query r1 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.<init>()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            com.baidu.searchbox.download.manager.DownloadManager r4 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            android.content.Context r7 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r7 = r7.getPackageName()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r4.<init>(r6, r7)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r6 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r7 = r1.setOnlyIncludeVisibleInDownloadsUi(r6)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            com.baidu.searchbox.download.manager.DownloadManager$Query r7 = r7.setOnlyDownloading(r6)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r8 = 8
            com.baidu.searchbox.download.manager.DownloadManager$Query r7 = r7.setFilterByStatus(r8)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r7.setFilterBySelection(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7 = r24
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.showDeleted(r7)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r7 = r22
            r0.setLimit(r7)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            java.lang.String r0 = "last_modified_timestamp"
            r7 = 1
            if (r23 == 0) goto L112
            r8 = 2
            r1.orderBy(r0, r8)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            goto L115
        L112:
            r1.orderBy(r0, r7)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
        L115:
            if (r17 != 0) goto L11e
            java.lang.String r0 = getFilterPrivateFileSql()     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            r1.setFilterBySelection(r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
        L11e:
            java.lang.String[] r0 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.PROJECTIONS_FILTER_BY_TYPE     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            android.database.Cursor r1 = r4.query(r1, r0)     // Catch: java.lang.Throwable -> L336 java.lang.Exception -> L339
            if (r1 == 0) goto L331
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            if (r0 <= 0) goto L331
            java.lang.String r0 = "_id"
            int r4 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "status"
            int r8 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "mimetype"
            int r9 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "total_bytes"
            int r10 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "_data"
            int r11 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "title"
            int r12 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "extra_info"
            int r13 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "uri"
            int r14 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "deleted"
            int r15 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "business_type"
            int r3 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "netdisk_upload_info"
            int r6 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            java.lang.String r0 = "source"
            int r7 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L32a java.lang.Exception -> L32d
            r16 = r2
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.<init>()     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
        L187:
            java.lang.String r0 = r1.getString(r9)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r17 = r9
            java.lang.String r9 = r1.getString(r12)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r20 = r12
            java.lang.String r12 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r9)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            int r12 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r12, r0)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r21 = r2
            com.baidu.searchbox.download.model.CategoryInfoData r2 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.<init>()     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r22 = r6
            r23 = r7
            long r6 = r1.getLong(r4)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mId = r6     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mMimeType = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            long r6 = (long) r12     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mType = r6     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            int r0 = r1.getInt(r3)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mBusinessType = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r0 = 6
            java.lang.String r6 = ""
            if (r0 != r12) goto L257
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch: java.lang.Throwable -> L241 java.lang.Exception -> L244
            r25 = r3
            r24 = r4
            long r3 = r2.mId     // Catch: java.lang.Exception -> L23f java.lang.Throwable -> L241
            android.database.Cursor r3 = r0.getSearchboxDownloadCursor(r3)     // Catch: java.lang.Exception -> L23f java.lang.Throwable -> L241
            if (r3 == 0) goto L233
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            if (r0 == 0) goto L233
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewprogress     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            float r0 = r3.getFloat(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            r2.mStoryViewProgress = r0     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewposition     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            r2.mStoryPosition = r0     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.gid     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            long r6 = r3.getLong(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            r2.mGid = r6     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booksrc     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            r2.mBookDirectoryUrl = r0     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booktype     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            int r0 = r3.getInt(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            r2.mBookType = r0     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.bookfree     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            r2.mFree = r0     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            goto L239
        L233:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2.mStoryViewProgress = r0     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
            r2.mStoryPosition = r6     // Catch: java.lang.Exception -> L23d java.lang.Throwable -> L252
        L239:
            com.baidu.android.util.io.Closeables.closeSafely(r3)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            goto L27c
        L23d:
            r0 = move-exception
            goto L24a
        L23f:
            r0 = move-exception
            goto L249
        L241:
            r0 = move-exception
            r3 = 0
            goto L253
        L244:
            r0 = move-exception
            r25 = r3
            r24 = r4
        L249:
            r3 = 0
        L24a:
            boolean r4 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Throwable -> L252
            if (r4 == 0) goto L239
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L252
            goto L239
        L252:
            r0 = move-exception
        L253:
            com.baidu.android.util.io.Closeables.closeSafely(r3)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            throw r0     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
        L257:
            r25 = r3
            r24 = r4
            r0 = 3
            if (r12 != r0) goto L27c
            java.lang.String r0 = r1.getString(r13)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            if (r3 != 0) goto L27c
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            r3.<init>(r0)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            java.lang.String r0 = "icon"
            java.lang.String r0 = r3.optString(r0, r6)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            r2.mAppIcon = r0     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            goto L27c
        L276:
            r0 = move-exception
            r3 = r1
            r7 = r16
            goto L33c
        L27c:
            int r0 = r2.mBusinessType     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            if (r0 == 0) goto L28c
            java.lang.String r0 = "business_id"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            r2.businessId = r0     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
        L28c:
            long r3 = r1.getLong(r10)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mSize = r3     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            java.lang.String r0 = r1.getString(r11)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mDownloadPath = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mFileName = r9     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            long r3 = r1.getLong(r5)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mCompletionTime = r3     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            java.lang.String r0 = r1.getString(r13)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mExtraInfo = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r0.<init>()     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mDownloadingInfo = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            java.lang.String r0 = r1.getString(r14)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            com.baidu.searchbox.download.model.DownloadingInfo r3 = r2.mDownloadingInfo     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r3.mUrl = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            int r3 = r1.getInt(r8)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r0.mStatus = r3     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            int r0 = r1.getInt(r15)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r3 = 1
            if (r0 != r3) goto L2c6
            r0 = 1
            goto L2c7
        L2c6:
            r0 = 0
        L2c7:
            r2.mIsDeleted = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            long r6 = r2.mId     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            boolean r0 = r0.isRead(r6)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            if (r0 != 0) goto L2d7
            r0 = 1
            goto L2d8
        L2d7:
            r0 = 0
        L2d8:
            r2.newFlag = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r4 = r23
            java.lang.String r0 = r1.getString(r4)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r2.mSource = r0     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            r6 = r22
            java.lang.String r0 = r1.getString(r6)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L326 java.lang.Throwable -> L32a
            if (r7 != 0) goto L308
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r7 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r9 = r21
            java.lang.Object r0 = r9.fromJson(r0, r7)     // Catch: java.lang.Exception -> L276 com.google.gson.JsonSyntaxException -> L2fb java.lang.Throwable -> L32a
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch: java.lang.Exception -> L276 com.google.gson.JsonSyntaxException -> L2fb java.lang.Throwable -> L32a
            r2.mNetdiskUploadInfo = r0     // Catch: java.lang.Exception -> L276 com.google.gson.JsonSyntaxException -> L2fb java.lang.Throwable -> L32a
            goto L30a
        L2fb:
            r0 = move-exception
            goto L300
        L2fd:
            r0 = move-exception
            r9 = r21
        L300:
            boolean r7 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            if (r7 == 0) goto L30a
            r0.printStackTrace()     // Catch: java.lang.Exception -> L276 java.lang.Throwable -> L32a
            goto L30a
        L308:
            r9 = r21
        L30a:
            r7 = r16
            r7.add(r2)     // Catch: java.lang.Exception -> L324 java.lang.Throwable -> L32a
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Exception -> L324 java.lang.Throwable -> L32a
            if (r0 != 0) goto L316
            goto L332
        L316:
            r12 = r20
            r3 = r25
            r16 = r7
            r2 = r9
            r9 = r17
            r7 = r4
            r4 = r24
            goto L187
        L324:
            r0 = move-exception
            goto L32f
        L326:
            r0 = move-exception
            r7 = r16
            goto L32f
        L32a:
            r0 = move-exception
            r3 = r1
            goto L348
        L32d:
            r0 = move-exception
            r7 = r2
        L32f:
            r3 = r1
            goto L33c
        L331:
            r7 = r2
        L332:
            com.baidu.android.util.io.Closeables.closeSafely(r1)
            goto L346
        L336:
            r0 = move-exception
            r3 = 0
            goto L348
        L339:
            r0 = move-exception
            r7 = r2
            r3 = 0
        L33c:
            boolean r1 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Throwable -> L347
            if (r1 == 0) goto L343
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L347
        L343:
            com.baidu.android.util.io.Closeables.closeSafely(r3)
        L346:
            return r7
        L347:
            r0 = move-exception
        L348:
            com.baidu.android.util.io.Closeables.closeSafely(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloaded(boolean, long, long, int, boolean, boolean, boolean, java.util.List):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0136 A[Catch: Exception -> 0x01a5, all -> 0x01a9, TryCatch #2 {all -> 0x01a9, blocks: (B:3:0x000d, B:5:0x0037, B:6:0x003e, B:8:0x0044, B:10:0x004a, B:12:0x009b, B:13:0x00ab, B:15:0x00eb, B:17:0x00fd, B:19:0x0106, B:27:0x0118, B:35:0x0132, B:37:0x0136, B:38:0x0142, B:40:0x0189, B:25:0x0114, B:28:0x011b, B:29:0x0120, B:34:0x012c, B:49:0x01ac, B:53:0x01b6, B:54:0x01bb), top: B:59:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193 A[LOOP:0: B:13:0x00ab->B:43:0x0193, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b2 A[EDGE_INSN: B:65:0x01b2->B:51:0x01b2 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<CategoryInfoData> queryDownloading(Context context, boolean z, int i, int i2) {
        int i3;
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        DownloadManager.Query query = new DownloadManager.Query();
        Cursor cursor = null;
        try {
            try {
                DownloadManager downloadManager = new DownloadManager(context.getContentResolver(), context.getPackageName());
                query.setOnlyDownloading(true).setOnlyIncludeVisibleInDownloadsUi(true).setOffset(i).setLimit(i2).orderBy(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP, 2);
                if (!z) {
                    query.setFilterBySelection(getFilterPrivateFileSql());
                }
                cursor = downloadManager.query(query);
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("title");
                    int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("status");
                    int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);
                    int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("total_bytes");
                    int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_MEDIA_TYPE);
                    int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("reason");
                    int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("uri");
                    int columnIndex = cursor.getColumnIndex("lastmod");
                    int columnIndex2 = cursor.getColumnIndex("_data");
                    int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("business_type");
                    int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow("progress");
                    ArrayList<CategoryInfoData> arrayList2 = arrayList;
                    try {
                        int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow("extra_info");
                        int i4 = columnIndex2;
                        int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow("source");
                        cursor.moveToFirst();
                        while (true) {
                            String string = cursor.getString(columnIndexOrThrow6);
                            int i5 = columnIndexOrThrow6;
                            String string2 = cursor.getString(columnIndexOrThrow2);
                            int i6 = columnIndexOrThrow2;
                            int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string2), string);
                            int i7 = columnIndexOrThrow12;
                            CategoryInfoData categoryInfoData = new CategoryInfoData();
                            int i8 = columnIndexOrThrow8;
                            int i9 = columnIndex;
                            categoryInfoData.mId = cursor.getLong(columnIndexOrThrow);
                            categoryInfoData.mMimeType = string;
                            categoryInfoData.mType = category;
                            categoryInfoData.progress = cursor.getInt(columnIndexOrThrow10);
                            categoryInfoData.mDownloadingInfo = new DownloadingInfo();
                            int i10 = cursor.getInt(columnIndexOrThrow9);
                            categoryInfoData.mBusinessType = i10;
                            if (3 == category) {
                                String queryExtraInfoByDownloadID = FileDownloader.queryExtraInfoByDownloadID(context, String.valueOf(categoryInfoData.mId));
                                if (!TextUtils.isEmpty(queryExtraInfoByDownloadID)) {
                                    try {
                                        i3 = columnIndexOrThrow;
                                        try {
                                            categoryInfoData.mAppIcon = new JSONObject(queryExtraInfoByDownloadID).optString("icon", "");
                                        } catch (Exception e) {
                                            e = e;
                                            if (DEBUG) {
                                                throw new DebugException("DownloadCenterUtils.queryDownloading()", e);
                                            }
                                            categoryInfoData.mExtraInfo = queryExtraInfoByDownloadID;
                                            if (categoryInfoData.mBusinessType != 0) {
                                            }
                                            categoryInfoData.mDownloadingInfo.mCurrentSize = cursor.getLong(columnIndexOrThrow4);
                                            categoryInfoData.mSize = cursor.getLong(columnIndexOrThrow5);
                                            categoryInfoData.mDownloadingInfo.mStatus = cursor.getInt(columnIndexOrThrow3);
                                            categoryInfoData.mFileName = string2;
                                            categoryInfoData.mDownloadingInfo.mReason = cursor.getInt(columnIndexOrThrow7);
                                            categoryInfoData.mDownloadingInfo.mUrl = cursor.getString(i8);
                                            int i11 = columnIndexOrThrow10;
                                            categoryInfoData.mCompletionTime = cursor.getLong(i9);
                                            int i12 = i4;
                                            categoryInfoData.mDownloadPath = cursor.getString(i12);
                                            categoryInfoData.mSource = cursor.getString(i7);
                                            int i13 = columnIndexOrThrow11;
                                            arrayList = arrayList2;
                                            arrayList.add(categoryInfoData);
                                            if (cursor.moveToNext()) {
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        i3 = columnIndexOrThrow;
                                    }
                                    categoryInfoData.mExtraInfo = queryExtraInfoByDownloadID;
                                } else {
                                    i3 = columnIndexOrThrow;
                                }
                            } else {
                                i3 = columnIndexOrThrow;
                                if (i10 == 1) {
                                    categoryInfoData.mExtraInfo = cursor.getString(columnIndexOrThrow11);
                                }
                            }
                            if (categoryInfoData.mBusinessType != 0) {
                                categoryInfoData.businessId = cursor.getString(cursor.getColumnIndexOrThrow("business_id"));
                            }
                            categoryInfoData.mDownloadingInfo.mCurrentSize = cursor.getLong(columnIndexOrThrow4);
                            categoryInfoData.mSize = cursor.getLong(columnIndexOrThrow5);
                            categoryInfoData.mDownloadingInfo.mStatus = cursor.getInt(columnIndexOrThrow3);
                            categoryInfoData.mFileName = string2;
                            categoryInfoData.mDownloadingInfo.mReason = cursor.getInt(columnIndexOrThrow7);
                            categoryInfoData.mDownloadingInfo.mUrl = cursor.getString(i8);
                            int i112 = columnIndexOrThrow10;
                            categoryInfoData.mCompletionTime = cursor.getLong(i9);
                            int i122 = i4;
                            categoryInfoData.mDownloadPath = cursor.getString(i122);
                            categoryInfoData.mSource = cursor.getString(i7);
                            int i132 = columnIndexOrThrow11;
                            arrayList = arrayList2;
                            arrayList.add(categoryInfoData);
                            if (cursor.moveToNext()) {
                                break;
                            }
                            columnIndexOrThrow2 = i6;
                            arrayList2 = arrayList;
                            columnIndexOrThrow12 = i7;
                            columnIndexOrThrow10 = i112;
                            columnIndexOrThrow11 = i132;
                            i4 = i122;
                            columnIndex = i9;
                            columnIndexOrThrow = i3;
                            columnIndexOrThrow8 = i8;
                            columnIndexOrThrow6 = i5;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        arrayList = arrayList2;
                        if (AppConfig.isDebug()) {
                            throw new DebugException("DownloadCenterUtils.queryDownloading()", e);
                        }
                        return arrayList;
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
            return arrayList;
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:82:0x026f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.util.List<com.baidu.searchbox.download.model.CategoryInfoData> queryDownloadingAndDownloaded(boolean r24, int r25, boolean r26) {
        /*
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r0 = " AND uri not like '%content://%'"
            com.baidu.searchbox.download.manager.DownloadManager$Query r3 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            r3.<init>()     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            com.baidu.searchbox.download.manager.DownloadManager r4 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            r5 = 1
            com.baidu.searchbox.download.manager.DownloadManager$Query r6 = r3.setOnlyIncludeVisibleInDownloadsUi(r5)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            r7 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r6 = r6.setOnlyDownloading(r7)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r6.setFilterBySelection(r0)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            r6 = r26
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.showDeleted(r6)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            r6 = r25
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setLimit(r6)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            java.lang.String r6 = "create_time"
            r8 = 2
            r0.orderBy(r6, r8)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            if (r24 != 0) goto L4a
            java.lang.String r0 = getFilterPrivateFileSql()     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            r3.setFilterBySelection(r0)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
        L4a:
            java.lang.String[] r0 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.PROJECTIONS_FILTER_BY_TYPE     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            android.database.Cursor r3 = r4.query(r3, r0)     // Catch: java.lang.Throwable -> L2b2 java.lang.Exception -> L2b5
            if (r3 == 0) goto L2ad
            int r0 = r3.getCount()     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            if (r0 <= 0) goto L2ad
            java.lang.String r0 = "_id"
            int r4 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "status"
            int r6 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "mimetype"
            int r9 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "total_bytes"
            int r10 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "_data"
            int r11 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "title"
            int r12 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "lastmod"
            int r13 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "extra_info"
            int r14 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "uri"
            int r15 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "deleted"
            int r2 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "business_type"
            int r7 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "netdisk_upload_info"
            int r5 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "bytes_so_far"
            int r8 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L2a6 java.lang.Exception -> L2a9
            java.lang.String r0 = "source"
            r17 = r1
            int r1 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            java.lang.String r0 = "progress"
            r24 = r5
            int r5 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r3.moveToFirst()     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r26 = r1
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.<init>()     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
        Lc5:
            java.lang.String r0 = r3.getString(r9)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r18 = r9
            java.lang.String r9 = r3.getString(r12)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r19 = r12
            java.lang.String r12 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r9)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            int r12 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r12, r0)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r20 = r1
            com.baidu.searchbox.download.model.CategoryInfoData r1 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.<init>()     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r22 = r9
            r21 = r10
            long r9 = r3.getLong(r4)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mId = r9     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            java.lang.String r10 = ""
            if (r9 == 0) goto Lf3
            r0 = r10
        Lf3:
            r1.mMimeType = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r9 = r13
            r23 = r14
            long r13 = (long) r12     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mType = r13     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            int r0 = r3.getInt(r7)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mBusinessType = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            java.lang.String r0 = r3.getString(r11)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mDownloadPath = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            int r0 = r3.getInt(r5)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.progress = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r0.<init>()     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mDownloadingInfo = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            java.lang.String r0 = r3.getString(r15)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            com.baidu.searchbox.download.model.DownloadingInfo r13 = r1.mDownloadingInfo     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r13.mUrl = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r1.mDownloadingInfo     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            int r13 = r3.getInt(r6)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r0.mStatus = r13     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r1.mDownloadingInfo     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            long r13 = r3.getLong(r8)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r0.mCurrentSize = r13     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r0 = 6
            if (r0 != r12) goto L1c4
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch: java.lang.Throwable -> L1ae java.lang.Exception -> L1b1
            long r12 = r1.mId     // Catch: java.lang.Throwable -> L1ae java.lang.Exception -> L1b1
            android.database.Cursor r12 = r0.getSearchboxDownloadCursor(r12)     // Catch: java.lang.Throwable -> L1ae java.lang.Exception -> L1b1
            if (r12 == 0) goto L1a2
            boolean r0 = r12.moveToFirst()     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            if (r0 == 0) goto L1a2
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewprogress     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            float r0 = r12.getFloat(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            r1.mStoryViewProgress = r0     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewposition     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r12.getString(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            r1.mStoryPosition = r0     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.gid     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            long r13 = r12.getLong(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            r1.mGid = r13     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booksrc     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r12.getString(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            r1.mBookDirectoryUrl = r0     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booktype     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            int r0 = r12.getInt(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            r1.mBookType = r0     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.bookfree     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r0.name()     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            java.lang.String r0 = r12.getString(r0)     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            r1.mFree = r0     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            goto L1a8
        L1a2:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.mStoryViewProgress = r0     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
            r1.mStoryPosition = r10     // Catch: java.lang.Exception -> L1ac java.lang.Throwable -> L1be
        L1a8:
            com.baidu.android.util.io.Closeables.closeSafely(r12)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            goto L1bb
        L1ac:
            r0 = move-exception
            goto L1b3
        L1ae:
            r0 = move-exception
            r2 = 0
            goto L1c0
        L1b1:
            r0 = move-exception
            r12 = 0
        L1b3:
            boolean r13 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Throwable -> L1be
            if (r13 == 0) goto L1a8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1be
            goto L1a8
        L1bb:
            r13 = r23
            goto L1e0
        L1be:
            r0 = move-exception
            r2 = r12
        L1c0:
            com.baidu.android.util.io.Closeables.closeSafely(r2)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            throw r0     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
        L1c4:
            r0 = 3
            if (r12 != r0) goto L1e8
            r13 = r23
            java.lang.String r0 = r3.getString(r13)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            if (r12 != 0) goto L1e0
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            r12.<init>(r0)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            java.lang.String r0 = "icon"
            java.lang.String r0 = r12.optString(r0, r10)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            r1.mAppIcon = r0     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
        L1e0:
            r14 = 2
            goto L1fb
        L1e2:
            r0 = move-exception
            r2 = r3
            r10 = r17
            goto L2b8
        L1e8:
            r13 = r23
            r14 = 2
            if (r12 == r14) goto L1ef
            if (r12 != 0) goto L1fb
        L1ef:
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r1.mDownloadingInfo     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            int r0 = r0.mStatus     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r12 = 8
            if (r0 != r12) goto L1fb
            java.lang.String r0 = r1.mDownloadPath     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            r1.mAppIcon = r0     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
        L1fb:
            int r0 = r1.mBusinessType     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            if (r0 == 0) goto L20b
            java.lang.String r0 = "business_id"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            r1.businessId = r0     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
        L20b:
            r25 = r15
            r12 = r21
            long r14 = r3.getLong(r12)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mSize = r14     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r14 = r22
            r1.mFileName = r14     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            long r14 = r3.getLong(r9)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mCompletionTime = r14     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            java.lang.String r0 = r3.getString(r13)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            boolean r14 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            if (r14 == 0) goto L22a
            goto L22b
        L22a:
            r10 = r0
        L22b:
            r1.mExtraInfo = r10     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            int r0 = r3.getInt(r2)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r10 = 1
            if (r0 != r10) goto L236
            r0 = 1
            goto L237
        L236:
            r0 = 0
        L237:
            r1.mIsDeleted = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            long r14 = r1.mId     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            boolean r0 = r0.isRead(r14)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            if (r0 != 0) goto L247
            r0 = 1
            goto L248
        L247:
            r0 = 0
        L248:
            r1.newFlag = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r14 = r26
            java.lang.String r0 = r3.getString(r14)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r1.mSource = r0     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            r15 = r24
            java.lang.String r0 = r3.getString(r15)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            boolean r16 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L2a2 java.lang.Throwable -> L2a6
            if (r16 != 0) goto L27c
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r10 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r24 = r2
            r2 = r20
            java.lang.Object r0 = r2.fromJson(r0, r10)     // Catch: java.lang.Exception -> L1e2 com.google.gson.JsonSyntaxException -> L26d java.lang.Throwable -> L2a6
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch: java.lang.Exception -> L1e2 com.google.gson.JsonSyntaxException -> L26d java.lang.Throwable -> L2a6
            r1.mNetdiskUploadInfo = r0     // Catch: java.lang.Exception -> L1e2 com.google.gson.JsonSyntaxException -> L26d java.lang.Throwable -> L2a6
            goto L280
        L26d:
            r0 = move-exception
            goto L274
        L26f:
            r0 = move-exception
            r24 = r2
            r2 = r20
        L274:
            boolean r10 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            if (r10 == 0) goto L280
            r0.printStackTrace()     // Catch: java.lang.Exception -> L1e2 java.lang.Throwable -> L2a6
            goto L280
        L27c:
            r24 = r2
            r2 = r20
        L280:
            r10 = r17
            r10.add(r1)     // Catch: java.lang.Exception -> L2a0 java.lang.Throwable -> L2a6
            boolean r0 = r3.moveToNext()     // Catch: java.lang.Exception -> L2a0 java.lang.Throwable -> L2a6
            if (r0 != 0) goto L28c
            goto L2ae
        L28c:
            r1 = r2
            r17 = r10
            r10 = r12
            r26 = r14
            r12 = r19
            r2 = r24
            r14 = r13
            r24 = r15
            r15 = r25
            r13 = r9
            r9 = r18
            goto Lc5
        L2a0:
            r0 = move-exception
            goto L2ab
        L2a2:
            r0 = move-exception
            r10 = r17
            goto L2ab
        L2a6:
            r0 = move-exception
            r2 = r3
            goto L2c4
        L2a9:
            r0 = move-exception
            r10 = r1
        L2ab:
            r2 = r3
            goto L2b8
        L2ad:
            r10 = r1
        L2ae:
            com.baidu.android.util.io.Closeables.closeSafely(r3)
            goto L2c2
        L2b2:
            r0 = move-exception
            r2 = 0
            goto L2c4
        L2b5:
            r0 = move-exception
            r10 = r1
            r2 = 0
        L2b8:
            boolean r1 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Throwable -> L2c3
            if (r1 == 0) goto L2bf
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2c3
        L2bf:
            com.baidu.android.util.io.Closeables.closeSafely(r2)
        L2c2:
            return r10
        L2c3:
            r0 = move-exception
        L2c4:
            com.baidu.android.util.io.Closeables.closeSafely(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloadingAndDownloaded(boolean, int, boolean):java.util.List");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:50:0x0206
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.util.List<com.baidu.searchbox.download.model.CategoryInfoData> queryHasOpenDatas(boolean r23, int r24, java.util.ArrayList<java.lang.String> r25) {
        /*
            java.lang.String r0 = "time_open"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 1
            java.lang.String r4 = " AND time_open > 0"
            if (r25 == 0) goto L6c
            boolean r5 = r25.isEmpty()
            if (r5 != 0) goto L6c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.Iterator r6 = r25.iterator()
        L1d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L37
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "'"
            r5.append(r8)
            r5.append(r7)
            java.lang.String r7 = "',"
            r5.append(r7)
            goto L1d
        L37:
            int r6 = r5.length()
            int r6 = r6 - r3
            java.lang.String r5 = r5.substring(r2, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = " AND ( is_visible_in_downloads_ui != '0' "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = " OR source IN ("
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = "))"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5 = 0
            goto L6d
        L6c:
            r5 = 1
        L6d:
            if (r23 != 0) goto L82
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = getFilterPrivateFileSql()
            r6.append(r4)
            java.lang.String r4 = r6.toString()
        L82:
            r6 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r7 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            r7.<init>()     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            com.baidu.searchbox.download.manager.DownloadManager r8 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            android.content.Context r9 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            android.content.Context r10 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r10 = r10.getPackageName()     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            r8.<init>(r9, r10)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            com.baidu.searchbox.download.manager.DownloadManager$Query r5 = r7.setOnlyIncludeVisibleInDownloadsUi(r5)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            com.baidu.searchbox.download.manager.DownloadManager$Query r5 = r5.setOnlyDownloading(r2)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            r9 = 8
            com.baidu.searchbox.download.manager.DownloadManager$Query r5 = r5.setFilterByStatus(r9)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            com.baidu.searchbox.download.manager.DownloadManager$Query r4 = r5.setFilterBySelection(r4)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            com.baidu.searchbox.download.manager.DownloadManager$Query r4 = r4.showDeleted(r3)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            r5 = 2
            com.baidu.searchbox.download.manager.DownloadManager$Query r4 = r4.orderBy(r0, r5)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            r9 = r24
            r4.setLimit(r9)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String[] r4 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.PROJECTIONS_FILTER_BY_TYPE     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            android.database.Cursor r6 = r8.query(r7, r4)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            if (r6 == 0) goto L26b
            int r4 = r6.getCount()     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            if (r4 <= 0) goto L26b
            java.lang.String r4 = "_id"
            int r4 = r6.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r7 = "mimetype"
            int r7 = r6.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r8 = "total_bytes"
            int r8 = r6.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r9 = "_data"
            int r9 = r6.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r10 = "title"
            int r10 = r6.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r11 = "lastmod"
            int r11 = r6.getColumnIndex(r11)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r12 = "extra_info"
            int r12 = r6.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r13 = "uri"
            int r13 = r6.getColumnIndexOrThrow(r13)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r14 = "deleted"
            int r14 = r6.getColumnIndexOrThrow(r14)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            int r15 = r6.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r0 = "netdisk_upload_info"
            int r2 = r6.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r0 = "open_read"
            int r5 = r6.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r0 = "bytes_so_far"
            int r3 = r6.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L26d java.lang.Exception -> L26f
            java.lang.String r0 = "source"
            r16 = r1
            int r1 = r6.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r0 = "business_type"
            r24 = r2
            int r2 = r6.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r6.moveToFirst()     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r25 = r2
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.<init>()     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
        L135:
            java.lang.String r0 = r6.getString(r7)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r17 = r7
            java.lang.String r7 = r6.getString(r10)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r18 = r10
            java.lang.String r10 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r7)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            int r10 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r10, r0)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r19 = r2
            com.baidu.searchbox.download.model.CategoryInfoData r2 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.<init>()     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r20 = r14
            r21 = r15
            long r14 = r6.getLong(r4)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mId = r14     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            boolean r14 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r15 = ""
            if (r14 == 0) goto L163
            r0 = r15
        L163:
            r2.mMimeType = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r22 = r15
            long r14 = (long) r10     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mType = r14     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            long r14 = r6.getLong(r8)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mSize = r14     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r0 = r6.getString(r9)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mDownloadPath = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mFileName = r7     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            long r14 = r6.getLong(r11)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mCompletionTime = r14     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r0 = r6.getString(r12)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            if (r7 == 0) goto L18a
            r0 = r22
        L18a:
            r2.mExtraInfo = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r0.<init>()     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mDownloadingInfo = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r0 = r6.getString(r13)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            com.baidu.searchbox.download.model.DownloadingInfo r7 = r2.mDownloadingInfo     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r7.mUrl = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            long r14 = r6.getLong(r3)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r0.mCurrentSize = r14     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r7 = r20
            int r0 = r6.getInt(r7)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r14 = 1
            if (r0 != r14) goto L1ae
            r14 = 1
            goto L1af
        L1ae:
            r14 = 0
        L1af:
            r2.mIsDeleted = r14     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            long r14 = r2.mId     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            boolean r0 = r0.isRead(r14)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            if (r0 != 0) goto L1bf
            r14 = 1
            goto L1c0
        L1bf:
            r14 = 0
        L1c0:
            r2.newFlag = r14     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r20 = r3
            r15 = r4
            r14 = r21
            long r3 = r6.getLong(r14)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mOpenTime = r3     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            int r0 = r6.getInt(r5)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r3 = 1
            if (r0 != r3) goto L1d6
            r0 = 1
            goto L1d7
        L1d6:
            r0 = 0
        L1d7:
            r2.mOpenRead = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r0 = r6.getString(r1)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mSource = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r4 = r25
            int r0 = r6.getInt(r4)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mBusinessType = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r3 = r24
            java.lang.String r0 = r6.getString(r3)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            boolean r21 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            if (r21 != 0) goto L213
            r24 = r1
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r1 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r21 = r3
            r3 = r19
            java.lang.Object r0 = r3.fromJson(r0, r1)     // Catch: com.google.gson.JsonSyntaxException -> L204 java.lang.Exception -> L267 java.lang.Throwable -> L26d
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch: com.google.gson.JsonSyntaxException -> L204 java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mNetdiskUploadInfo = r0     // Catch: com.google.gson.JsonSyntaxException -> L204 java.lang.Exception -> L267 java.lang.Throwable -> L26d
            goto L219
        L204:
            r0 = move-exception
            goto L20b
        L206:
            r0 = move-exception
            r21 = r3
            r3 = r19
        L20b:
            boolean r1 = com.baidu.searchbox.download.business.util.DownloadCenterUtils.DEBUG     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            if (r1 == 0) goto L219
            r0.printStackTrace()     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            goto L219
        L213:
            r24 = r1
            r21 = r3
            r3 = r19
        L219:
            r0 = 3
            if (r10 != r0) goto L239
            java.lang.String r0 = r2.mExtraInfo     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            if (r0 != 0) goto L235
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r1 = r2.mExtraInfo     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r0.<init>(r1)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            java.lang.String r1 = "icon"
            r10 = r22
            java.lang.String r0 = r0.optString(r1, r10)     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mAppIcon = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
        L235:
            r10 = r16
            r1 = 2
            goto L247
        L239:
            r1 = 2
            if (r10 == r1) goto L242
            if (r10 != 0) goto L23f
            goto L242
        L23f:
            r10 = r16
            goto L247
        L242:
            java.lang.String r0 = r2.mDownloadPath     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            r2.mAppIcon = r0     // Catch: java.lang.Exception -> L267 java.lang.Throwable -> L26d
            goto L23f
        L247:
            r10.add(r2)     // Catch: java.lang.Exception -> L265 java.lang.Throwable -> L26d
            boolean r0 = r6.moveToNext()     // Catch: java.lang.Exception -> L265 java.lang.Throwable -> L26d
            if (r0 != 0) goto L251
            goto L27a
        L251:
            r1 = r24
            r2 = r3
            r25 = r4
            r16 = r10
            r4 = r15
            r10 = r18
            r3 = r20
            r24 = r21
            r15 = r14
            r14 = r7
            r7 = r17
            goto L135
        L265:
            r0 = move-exception
            goto L271
        L267:
            r0 = move-exception
            r10 = r16
            goto L271
        L26b:
            r10 = r1
            goto L27a
        L26d:
            r0 = move-exception
            goto L27e
        L26f:
            r0 = move-exception
            r10 = r1
        L271:
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch: java.lang.Throwable -> L26d
            if (r1 == 0) goto L27a
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L26d
        L27a:
            com.baidu.android.util.io.Closeables.closeSafely(r6)
            return r10
        L27e:
            com.baidu.android.util.io.Closeables.closeSafely(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryHasOpenDatas(boolean, int, java.util.ArrayList):java.util.List");
    }

    public static List<Long> queryDownloadingIds() {
        int columnIndex;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                DownloadManager.Query query = new DownloadManager.Query();
                DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
                query.setFilterBySelection(" AND status IN ('190', '192', '193', '194', '195', '196')");
                cursor = downloadManager.query(query, new String[]{"_id"});
                if (cursor != null && cursor.getCount() > 0 && (columnIndex = cursor.getColumnIndex("_id")) > -1) {
                    cursor.moveToFirst();
                    do {
                        arrayList.add(Long.valueOf(cursor.getLong(columnIndex)));
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static void updateDownloadTitle(String str, CategoryInfoData categoryInfoData, z zVar) {
        if (categoryInfoData.mIsLocal) {
            updateLocalDataTitle(str, categoryInfoData, zVar);
            long queryDownloadDataByPath = queryDownloadDataByPath(str);
            if (queryDownloadDataByPath > -1) {
                IDownloadApp.Impl.get().updateDownloadTitle(categoryInfoData.mFileName, categoryInfoData.mDownloadPath, queryDownloadDataByPath);
                return;
            }
            return;
        }
        IDownloadApp.Impl.get().updateDownloadTitle(categoryInfoData.mFileName, categoryInfoData.mDownloadPath, categoryInfoData.mId);
        if (!DownloadHelper.getFileTypeString(categoryInfoData.mDownloadPath, categoryInfoData.mMimeType).equals("image") && FileClassifyHelper.getCategory(categoryInfoData.mDownloadPath, categoryInfoData.mMimeType) != 4) {
            if (zVar != null) {
                zVar.onPermitted(1);
                return;
            }
            return;
        }
        updateLocalDataTitle(str, categoryInfoData, zVar);
    }

    public static void updateLocalDataTitle(String str, CategoryInfoData categoryInfoData, z zVar) {
        Uri contentUri;
        ContentValues contentValues = new ContentValues();
        String str2 = categoryInfoData.mFileName;
        contentValues.put("title", str2.substring(0, str2.lastIndexOf(".")));
        contentValues.put("_data", categoryInfoData.mDownloadPath);
        if (DownloadMediaHelper.isOpenScopedStorage()) {
            contentUri = DownloadMediaHelper.queryMediaFileUri(AppRuntime.getAppContext(), categoryInfoData.mDownloadPath, categoryInfoData.mMimeType);
        } else {
            contentUri = MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH);
        }
        MediaFileProcessor.update(AppRuntime.getAppContext(), contentUri, contentValues, "_data = ?", new String[]{str}, zVar);
        if (zVar != null) {
            zVar.onPermitted(1);
        }
    }

    public static void updateOpenTime(CategoryInfoData categoryInfoData, long j, boolean z) {
        long j2 = categoryInfoData.mId;
        if (categoryInfoData.mIsLocal) {
            j2 = queryDownloadDataByPath(categoryInfoData.mDownloadPath);
            if (j2 == -1) {
                j2 = insertLocalDataToDownloadTable(categoryInfoData);
            }
        }
        if (j2 != -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Impl.COLUMN_OPEN_TIME, Long.valueOf(j));
            contentValues.put(Downloads.Impl.COLUMN_OPEN_READ, Boolean.valueOf(z));
            AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, "_id= ? ", new String[]{String.valueOf(j2)});
        }
    }

    public static boolean updateM3u8Info(String str, String str2, String str3, String str4) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = AppRuntime.getAppContext().getContentResolver();
                Cursor query = contentResolver.query(Downloads.CONTENT_URI, new String[]{"_id"}, "_data = ?", new String[]{str}, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_data", str2);
                            contentValues.put("title", str3);
                            contentValues.put("mimetype", str4);
                            if (contentResolver.update(DownloadManagerExt.getInstance().getDownloadUri(query.getLong(query.getColumnIndexOrThrow("_id"))), contentValues, null, null) >= 1) {
                                z = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = query;
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                }
                Closeables.closeSafely(query);
            } catch (Exception e2) {
                e = e2;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void updateNetdiskUploadInfo(long j, NetdiskUploadInfo netdiskUploadInfo) {
        ContentValues contentValues = new ContentValues();
        if (netdiskUploadInfo == null) {
            contentValues.putNull(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO);
        } else {
            contentValues.put(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, new Gson().toJson(netdiskUploadInfo));
        }
        AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, "_id= ? ", new String[]{String.valueOf(j)});
    }

    public static void updatePlayProgress(String str, double d) {
        JSONObject jSONObject;
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info"}, "_data= ?", new String[]{str}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("extra_info"));
                    if (TextUtils.isEmpty(string)) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(string);
                    }
                    jSONObject.putOpt(LocalDataScanHelper.EXT_KEY_PLAY_PROGRESS, Double.valueOf(d));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("extra_info", jSONObject.toString());
                    AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, "_data= ? ", new String[]{String.valueOf(str)});
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }
}
