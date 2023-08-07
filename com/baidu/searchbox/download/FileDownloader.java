package com.baidu.searchbox.download;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.callback.FileDownloadListener;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.download.table.SearchBoxDownloadTable;
import com.baidu.searchbox.download.util.DocClassifyHelper;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.v10;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FileDownloader {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String[] PROJECTIONS_FILTER_BY_TYPE = {"_id", "title", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "_data", "extra_info"};

    public static int getTotalDownloadedCount() {
        return getTotalDownloadedCount(true);
    }

    public static boolean canDownloadResume(Uri uri) {
        DownloadBean queryDownloadData;
        if (uri == null || (queryDownloadData = DownloadManagerExt.getInstance().queryDownloadData(uri)) == null || queryDownloadData.getDownloadState() == null || queryDownloadData.getDownloadState() != DownloadState.DOWNLOAD_PAUSED) {
            return false;
        }
        return true;
    }

    public static void cancelDownload(Uri uri) {
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null && uri != null) {
            DownloadManagerExt.getInstance().cancelDownload(uri);
            DownloadManagerExt.getInstance().unregisterObserver(appContext, uri);
        }
    }

    public static DownloadState getDownloadState(Uri uri) {
        DownloadBean queryDownloadData;
        if (uri == null || (queryDownloadData = DownloadManagerExt.getInstance().queryDownloadData(uri)) == null) {
            return null;
        }
        return queryDownloadData.getDownloadState();
    }

    public static void pauseDownload(Uri uri) {
        if (uri == null) {
            return;
        }
        DownloadManagerExt.getInstance().pauseDownload(uri);
    }

    public static void pauseDownloadSafety(Uri uri) {
        if (uri == null) {
            return;
        }
        DownloadManagerExt.getInstance().pauseDownload(uri);
        DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri);
    }

    public static void resumeDownload(Uri uri) {
        if (uri == null) {
            return;
        }
        DownloadManagerExt.getInstance().resumeDownload(uri);
    }

    public static int getTotalDownloadedCount(boolean z) {
        String str;
        int i = 0;
        String[] strArr = {String.valueOf(200), String.valueOf(1), String.valueOf(1)};
        Cursor cursor = null;
        if (z) {
            str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ?";
        } else {
            try {
                try {
                    str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ?" + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
        }
        cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, str, strArr, "lastmod DESC");
        if (cursor != null) {
            i = cursor.getCount();
        }
        return i;
    }

    public static boolean isFilePathRepeat(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "_data= ? AND is_visible_in_downloads_ui= ?", new String[]{str, String.valueOf(1)}, null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        return true;
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    throw new DebugException("DownloadHelper.isFilePathRepeat", e);
                }
            }
            return false;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static String queryFilePathByDownloadID(String str) {
        Cursor cursor;
        Throwable th;
        String[] strArr = {str};
        String str2 = null;
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, "_id= ?", strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("_data"));
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            throw new DebugException("FileDownloader.queryFilePathByDownloadID", e);
                        }
                        Closeables.closeSafely(cursor);
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            Closeables.closeSafely(cursor);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return str2;
    }

    public static ArrayList<CategoryInfoData> queryByCategory(int i, int i2, int i3) {
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
        String substring = sb.substring(0, sb.length() - 1);
        queryDownloadData(i, i2, i3, "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND mimetype IN (" + substring + SmallTailInfo.EMOTION_SUFFIX, arrayList, v10.d(v10.a));
        return arrayList;
    }

    @Deprecated
    public static Uri startDownload(String str, ContentValues contentValues, IDownloadListener iDownloadListener) {
        boolean z;
        if (TextUtils.isEmpty(str) && iDownloadListener != null) {
            iDownloadListener.onStopped(StopStatus.PARAMETER_ERROR);
            return null;
        }
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || TextUtils.isEmpty(str) || iDownloadListener == null) {
            return null;
        }
        if (contentValues != null && contentValues.containsKey("visibility") && 2 == contentValues.getAsInteger("visibility").intValue()) {
            z = false;
        } else {
            z = true;
        }
        Uri doDownload = DownloadManagerExt.getInstance().doDownload(str, null, null, true, z, false, false, contentValues);
        DownloadManagerExt.getInstance().registerObserver(appContext, doDownload, new FileDownloadListener(appContext, iDownloadListener));
        return doDownload;
    }

    public static ArrayList<CategoryInfoData> queryByCategory(Context context, int i) {
        return queryByCategory(i, Integer.MAX_VALUE, 0);
    }

    public static void registerDownloadListener(long j, IDownloadListener iDownloadListener) {
        DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), DownloadManagerExt.getInstance().getDownloadUri(j), new FileDownloadListener(AppRuntime.getAppContext(), iDownloadListener));
    }

    @Deprecated
    public static Uri resumeDownload(Uri uri, IDownloadListener iDownloadListener) {
        if (uri == null && iDownloadListener != null) {
            iDownloadListener.onStopped(StopStatus.PARAMETER_ERROR);
            return null;
        }
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || uri == null || iDownloadListener == null) {
            return null;
        }
        DownloadManagerExt.getInstance().registerObserver(appContext, uri, new FileDownloadListener(appContext, iDownloadListener));
        DownloadManagerExt.getInstance().resumeDownload(uri);
        return uri;
    }

    @Deprecated
    public static Uri startDownload(String str, ContentValues contentValues) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (contentValues != null && contentValues.containsKey("visibility") && 1 == contentValues.getAsInteger("visibility").intValue()) {
            z = true;
        } else {
            z = false;
        }
        return DownloadManagerExt.getInstance().doDownload(str, null, null, true, z, false, false, contentValues);
    }

    public static ArrayList<CategoryInfoData> queryDocByCategory(DocClassifyHelper.DocCategroy docCategroy, int i, int i2) {
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        ArrayList<String> mimeTypesByType = DocClassifyHelper.getMimeTypesByType(docCategroy);
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
        if (docCategroy == DocClassifyHelper.DocCategroy.RECENT) {
            str = str + " AND extra_info IS NOT NULL";
        }
        queryDownloadData(4, i, i2, str, arrayList, v10.d(v10.a));
        if (docCategroy == DocClassifyHelper.DocCategroy.RECENT && arrayList.size() > 0) {
            ArrayList<CategoryInfoData> arrayList2 = new ArrayList<>();
            Iterator<CategoryInfoData> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CategoryInfoData next = it2.next();
                try {
                    if (!TextUtils.isEmpty(next.mExtraInfo) && new JSONObject(next.mExtraInfo).optLong(Downloads.Impl.COLUMN_EXTRA_INFO_OPEN_TIME, -1L) > 0) {
                        arrayList2.add(next);
                    }
                } catch (Exception unused) {
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    public static ArrayList<CategoryInfoData> queryDownloadById(long... jArr) {
        boolean z;
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        if (jArr != null && jArr.length >= 1) {
            StringBuilder sb = new StringBuilder();
            for (long j : jArr) {
                sb.append("'");
                sb.append(j);
                sb.append("',");
            }
            String str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND _id IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX;
            if (!v10.d(v10.a)) {
                str = str + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
            }
            String str2 = str;
            Cursor cursor = null;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, PROJECTIONS_FILTER_BY_TYPE, str2, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("_id");
                        int columnIndex2 = cursor.getColumnIndex("mimetype");
                        int columnIndex3 = cursor.getColumnIndex("total_bytes");
                        int columnIndex4 = cursor.getColumnIndex("_data");
                        int columnIndex5 = cursor.getColumnIndex("title");
                        int columnIndex6 = cursor.getColumnIndex("lastmod");
                        int columnIndex7 = cursor.getColumnIndex("extra_info");
                        cursor.moveToFirst();
                        do {
                            String string = cursor.getString(columnIndex2);
                            String string2 = cursor.getString(columnIndex5);
                            CategoryInfoData categoryInfoData = new CategoryInfoData();
                            categoryInfoData.mId = cursor.getLong(columnIndex);
                            categoryInfoData.mMimeType = string;
                            categoryInfoData.mType = FileClassifyHelper.getCategory("", string);
                            if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            categoryInfoData.newFlag = z;
                            categoryInfoData.mSize = cursor.getLong(columnIndex3);
                            categoryInfoData.mDownloadPath = cursor.getString(columnIndex4);
                            categoryInfoData.mFileName = string2;
                            categoryInfoData.mCompletionTime = cursor.getLong(columnIndex6);
                            categoryInfoData.mExtraInfo = cursor.getString(columnIndex7);
                            arrayList.add(categoryInfoData);
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
        return arrayList;
    }

    public static int queryDownloadDocDataCountByCategory(DocClassifyHelper.DocCategroy docCategroy) {
        ArrayList<String> mimeTypesByType = DocClassifyHelper.getMimeTypesByType(docCategroy);
        int i = 0;
        if (mimeTypesByType.size() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND mimetype IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX;
        if (!v10.d(v10.a)) {
            str = str + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
        }
        String str2 = str;
        String[] strArr = {String.valueOf(200), String.valueOf(1), String.valueOf(1)};
        Cursor cursor = null;
        try {
            try {
                if (docCategroy == DocClassifyHelper.DocCategroy.RECENT) {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info"}, str2, strArr, "");
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("extra_info");
                        cursor.moveToFirst();
                        do {
                            String string = cursor.getString(columnIndex);
                            if (!TextUtils.isEmpty(string) && new JSONObject(string).optLong(Downloads.Impl.COLUMN_EXTRA_INFO_OPEN_TIME, -1L) > 0) {
                                i++;
                            }
                        } while (cursor.moveToNext());
                    }
                } else {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, null, str2, strArr, "");
                    if (cursor != null) {
                        i = cursor.getCount();
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

    /* JADX WARN: Removed duplicated region for block: B:58:0x01f0 A[LOOP:0: B:12:0x00e0->B:58:0x01f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0202 A[EDGE_INSN: B:97:0x0202->B:70:0x0202 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void queryDownloadData(int i, int i2, int i3, String str, ArrayList<CategoryInfoData> arrayList, boolean z) {
        String str2;
        Cursor cursor;
        Cursor cursor2;
        boolean z2;
        Cursor cursor3;
        Cursor cursor4;
        Cursor cursor5;
        if (!z) {
            str2 = str + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
        } else {
            str2 = str;
        }
        try {
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, PROJECTIONS_FILTER_BY_TYPE, str2, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "lastmod DESC LIMIT " + i2 + " OFFSET " + i3);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex("_id");
                        int columnIndex2 = query.getColumnIndex("mimetype");
                        int columnIndex3 = query.getColumnIndex("total_bytes");
                        int columnIndex4 = query.getColumnIndex("_data");
                        int columnIndex5 = query.getColumnIndex("title");
                        int columnIndex6 = query.getColumnIndex("lastmod");
                        int columnIndex7 = query.getColumnIndex("extra_info");
                        query.moveToFirst();
                        while (true) {
                            String string = query.getString(columnIndex2);
                            String string2 = query.getString(columnIndex5);
                            String string3 = query.getString(columnIndex4);
                            if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string3), string) != i) {
                                cursor2 = query;
                            } else {
                                CategoryInfoData categoryInfoData = new CategoryInfoData();
                                categoryInfoData.mId = query.getLong(columnIndex);
                                categoryInfoData.mMimeType = string;
                                categoryInfoData.mType = i;
                                if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                categoryInfoData.newFlag = z2;
                                if (6 == i) {
                                    try {
                                        cursor5 = IDownloadApp.Impl.get().getSearchboxDownloadCursor(categoryInfoData.mId);
                                    } catch (Exception e) {
                                        e = e;
                                        cursor3 = query;
                                        cursor5 = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor3 = query;
                                        cursor4 = null;
                                    }
                                    try {
                                        if (cursor5 != null) {
                                            try {
                                            } catch (Exception e2) {
                                                e = e2;
                                                cursor3 = query;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                cursor3 = query;
                                            }
                                            if (cursor5.moveToFirst()) {
                                                categoryInfoData.mStoryViewProgress = cursor5.getFloat(cursor5.getColumnIndex(SearchBoxDownloadTable.viewprogress.name()));
                                                categoryInfoData.mStoryPosition = cursor5.getString(cursor5.getColumnIndex(SearchBoxDownloadTable.viewposition.name()));
                                                cursor3 = query;
                                                try {
                                                    try {
                                                        categoryInfoData.mGid = cursor5.getLong(cursor5.getColumnIndex(SearchBoxDownloadTable.gid.name()));
                                                        categoryInfoData.mBookDirectoryUrl = cursor5.getString(cursor5.getColumnIndex(SearchBoxDownloadTable.booksrc.name()));
                                                        categoryInfoData.mBookType = cursor5.getInt(cursor5.getColumnIndex(SearchBoxDownloadTable.booktype.name()));
                                                        categoryInfoData.mFree = cursor5.getString(cursor5.getColumnIndex(SearchBoxDownloadTable.bookfree.name()));
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        if (DEBUG) {
                                                            e.printStackTrace();
                                                        }
                                                        Closeables.closeSafely(cursor5);
                                                        cursor2 = cursor3;
                                                        categoryInfoData.mSize = cursor2.getLong(columnIndex3);
                                                        categoryInfoData.mDownloadPath = string3;
                                                        categoryInfoData.mFileName = string2;
                                                        categoryInfoData.mCompletionTime = cursor2.getLong(columnIndex6);
                                                        categoryInfoData.mExtraInfo = cursor2.getString(columnIndex7);
                                                        arrayList.add(categoryInfoData);
                                                        if (cursor2.moveToNext()) {
                                                        }
                                                    }
                                                    Closeables.closeSafely(cursor5);
                                                    cursor2 = cursor3;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    cursor4 = cursor5;
                                                    Closeables.closeSafely(cursor4);
                                                    throw th;
                                                }
                                            }
                                        }
                                        Closeables.closeSafely(cursor5);
                                        cursor2 = cursor3;
                                    } catch (Exception e4) {
                                        e = e4;
                                        cursor = cursor3;
                                        try {
                                            e.printStackTrace();
                                            Closeables.closeSafely(cursor);
                                            return;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            Closeables.closeSafely(cursor);
                                            throw th;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        cursor = cursor3;
                                        Closeables.closeSafely(cursor);
                                        throw th;
                                    }
                                    cursor3 = query;
                                    categoryInfoData.mStoryViewProgress = -1.0f;
                                    categoryInfoData.mStoryPosition = "";
                                } else {
                                    cursor2 = query;
                                }
                                try {
                                    categoryInfoData.mSize = cursor2.getLong(columnIndex3);
                                    categoryInfoData.mDownloadPath = string3;
                                    categoryInfoData.mFileName = string2;
                                    categoryInfoData.mCompletionTime = cursor2.getLong(columnIndex6);
                                    categoryInfoData.mExtraInfo = cursor2.getString(columnIndex7);
                                    arrayList.add(categoryInfoData);
                                } catch (Exception e5) {
                                    e = e5;
                                    cursor = cursor2;
                                    e.printStackTrace();
                                    Closeables.closeSafely(cursor);
                                    return;
                                } catch (Throwable th6) {
                                    th = th6;
                                    cursor = cursor2;
                                    Closeables.closeSafely(cursor);
                                    throw th;
                                }
                            }
                            if (cursor2.moveToNext()) {
                                break;
                            }
                            query = cursor2;
                        }
                        Closeables.closeSafely(cursor2);
                    }
                } catch (Exception e6) {
                    e = e6;
                    cursor2 = query;
                } catch (Throwable th7) {
                    th = th7;
                    cursor2 = query;
                }
            }
            cursor2 = query;
            Closeables.closeSafely(cursor2);
        } catch (Exception e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th8) {
            th = th8;
            cursor = null;
        }
    }

    public static int queryDownloadDataCountByCategory(int i) {
        ArrayList<String> mimeTypesByType = FileClassifyHelper.getMimeTypesByType(i);
        if (mimeTypesByType.size() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = mimeTypesByType.iterator();
        while (it.hasNext()) {
            sb.append("'");
            sb.append(it.next());
            sb.append("',");
        }
        String str = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND mimetype IN (" + sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX;
        if (!v10.d(v10.a)) {
            str = str + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR _data like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR _data IS NULL)");
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data", "mimetype"}, str2, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "");
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

    public static String queryExtraInfoByDownloadID(Context context, String str) {
        Throwable th;
        Cursor cursor;
        String[] strArr = {str};
        String str2 = null;
        try {
            cursor = context.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info"}, "_id= ?", strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("extra_info"));
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            Closeables.closeSafely(cursor);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return str2;
    }

    public static void resumeDownload(Uri uri, final IDownloadListener iDownloadListener, final DownloadCallBack downloadCallBack) {
        if (uri == null && iDownloadListener != null) {
            iDownloadListener.onStopped(StopStatus.PARAMETER_ERROR);
            if (downloadCallBack != null) {
                downloadCallBack.onResult(null);
                return;
            }
            return;
        }
        final Context appContext = AppRuntime.getAppContext();
        if ((appContext == null || uri == null || iDownloadListener == null) && downloadCallBack != null) {
            downloadCallBack.onResult(null);
        }
        DownloadManagerExt.getInstance().resumeDownload(uri, new DownloadCallBack() { // from class: com.baidu.searchbox.download.FileDownloader.2
            @Override // com.baidu.searchbox.download.DownloadCallBack
            public void onResult(Uri uri2) {
                DownloadCallBack downloadCallBack2 = DownloadCallBack.this;
                if (downloadCallBack2 != null) {
                    downloadCallBack2.onResult(uri2);
                }
                if (uri2 != null) {
                    DownloadManagerExt.getInstance().registerObserver(appContext, uri2, new FileDownloadListener(appContext, iDownloadListener));
                }
            }
        });
    }

    public static void startDownload(String str, ContentValues contentValues, DownloadCallBack downloadCallBack) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            if (downloadCallBack != null) {
                downloadCallBack.onResult(null);
                return;
            }
            return;
        }
        if (contentValues != null && contentValues.containsKey("visibility") && 1 == contentValues.getAsInteger("visibility").intValue()) {
            z = true;
        } else {
            z = false;
        }
        DownloadManagerExt.getInstance().doDownload(str, null, null, IDownloadApp.Impl.get().getOpenDownloadReceiverCanonicalName(), true, z, false, false, contentValues, downloadCallBack);
    }

    public static void startDownload(String str, ContentValues contentValues, final IDownloadListener iDownloadListener, final DownloadCallBack downloadCallBack) {
        if (TextUtils.isEmpty(str) && iDownloadListener != null) {
            iDownloadListener.onStopped(StopStatus.PARAMETER_ERROR);
            if (downloadCallBack != null) {
                downloadCallBack.onResult(null);
                return;
            }
            return;
        }
        final Context appContext = AppRuntime.getAppContext();
        if (appContext != null && !TextUtils.isEmpty(str) && iDownloadListener != null) {
            startDownload(str, contentValues, new DownloadCallBack() { // from class: com.baidu.searchbox.download.FileDownloader.1
                @Override // com.baidu.searchbox.download.DownloadCallBack
                public void onResult(Uri uri) {
                    DownloadCallBack downloadCallBack2 = DownloadCallBack.this;
                    if (downloadCallBack2 != null) {
                        downloadCallBack2.onResult(uri);
                    }
                    if (uri != null) {
                        DownloadManagerExt.getInstance().registerObserver(appContext, uri, new FileDownloadListener(appContext, iDownloadListener));
                    }
                }
            });
        } else if (downloadCallBack != null) {
            downloadCallBack.onResult(null);
        }
    }

    public static void updateDownloadExtraInfo(Context context, long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String queryExtraInfoByDownloadID = queryExtraInfoByDownloadID(context, String.valueOf(j));
        if (!TextUtils.isEmpty(queryExtraInfoByDownloadID)) {
            try {
                JSONObject jSONObject = new JSONObject(queryExtraInfoByDownloadID);
                JSONObject jSONObject2 = new JSONObject(str);
                String optString = jSONObject.optString("versioncode");
                String optString2 = jSONObject2.optString("versioncode");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    jSONObject.put(obj, jSONObject2.optString(obj));
                }
                str = jSONObject.toString();
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.equals(optString, optString2)) {
                    DownloadActionModel downloadActionModel = new DownloadActionModel();
                    downloadActionModel.downloadId = j;
                    ApkCloudStatisticsUtils.doApkDownHijackCloudStatisticJob(downloadActionModel);
                }
            } catch (Exception unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("extra_info", str);
        context.getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, "_id= ? ", new String[]{String.valueOf(j)});
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void uriToFile(Context context, final Uri uri, final DownloadFileCallBack downloadFileCallBack) {
        String str;
        SQLiteFullException e;
        Cursor cursor;
        String str2;
        if (downloadFileCallBack == null) {
            return;
        }
        Cursor cursor2 = null;
        if (context != null && uri != null) {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                downloadFileCallBack.onResult(uri, null);
                return;
            }
            try {
                cursor = contentResolver.query(uri, new String[]{"_id", "_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(cursor.getColumnIndex("_data"));
                                try {
                                    if (TextUtils.isEmpty(str)) {
                                        downloadFileCallBack.onResult(uri, null);
                                        Closeables.closeSafely(cursor);
                                        return;
                                    }
                                    cursor2 = str;
                                } catch (SQLiteFullException e2) {
                                    e = e2;
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                    Closeables.closeSafely(cursor);
                                    str2 = str;
                                    if (TextUtils.isEmpty(str2)) {
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            Closeables.closeSafely(cursor2);
                            throw th;
                        }
                    } catch (SQLiteFullException e3) {
                        e = e3;
                        str = null;
                    }
                }
                Closeables.closeSafely(cursor);
                str2 = cursor2;
            } catch (SQLiteFullException e4) {
                str = null;
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(cursor2);
                throw th;
            }
            if (TextUtils.isEmpty(str2)) {
                final Uri parse = Uri.parse(str2);
                DownloadHelper.checkExternalStorage(str2, true, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.FileDownloader.3
                    @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                    public void onResult(boolean z) {
                        if (z) {
                            String uri2 = parse.toString();
                            if (!TextUtils.isEmpty(uri2)) {
                                downloadFileCallBack.onResult(uri, new File(uri2));
                                return;
                            }
                            return;
                        }
                        downloadFileCallBack.onResult(uri, null);
                    }
                }, true);
                return;
            }
            return;
        }
        downloadFileCallBack.onResult(uri, null);
    }

    @Deprecated
    public static File uriToFile(Context context, Uri uri) {
        ContentResolver contentResolver;
        Cursor cursor;
        Cursor cursor2 = null;
        if (context == null || uri == null || (contentResolver = context.getContentResolver()) == null) {
            return null;
        }
        try {
            cursor = contentResolver.query(uri, new String[]{"_id", "_data"}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            if (TextUtils.isEmpty(string)) {
                                Closeables.closeSafely(cursor);
                                return null;
                            }
                            Uri parse = Uri.parse(string);
                            if (parse != null) {
                                String uri2 = parse.toString();
                                if (!TextUtils.isEmpty(uri2)) {
                                    File file = new File(uri2);
                                    Closeables.closeSafely(cursor);
                                    return file;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    Closeables.closeSafely(cursor2);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(cursor2);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return null;
    }
}
