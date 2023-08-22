package com.baidu.searchbox.download.component;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.ioc.DownloadRuntime;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.downloads.DSUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes3.dex */
public final class DownloadProvider {
    public static final int ALL_DOWNLOADS = 3;
    public static final int ALL_DOWNLOADS_ID = 4;
    public static final String AUTHORITY;
    public static final Uri[] BASE_URIS;
    public static final boolean CHECK_PERMISSION = false;
    public static final String DB_NAME = "downloads.db";
    public static final String DB_TABLE = "downloads";
    public static final int DB_VERSION_1214 = 111;
    public static final String DOWNLOAD_LIST_TYPE = "vnd.android.cursor.dir/download";
    public static final String DOWNLOAD_TYPE = "vnd.android.cursor.item/download";
    public static final int MY_DOWNLOADS = 1;
    public static final int MY_DOWNLOADS_ID = 2;
    public static final int REQUEST_HEADERS_URI = 5;
    public static final String TAG = "DownloadProvider";
    public static String[] sAppReadableColumnsArray;
    public static HashSet<String> sAppReadableColumnsSet;
    public Context mContext;
    public int mDefContainerUid = -1;
    public ISystemFacade mISystemFacade;
    public SQLiteOpenHelper mOpenHelper;
    public int mSystemUid;
    public static final boolean DEBUG = DownloadRuntime.GLOBAL_DEBUG;
    public static UriMatcher sURIMatcher = new UriMatcher(-1);

    private void checkInsertPermissions(ContentValues contentValues) {
    }

    /* loaded from: classes3.dex */
    public static final class DatabaseHelper extends SQLiteOpenHelper {
        public static volatile DatabaseHelper mDbOpenHelper;

        public DatabaseHelper(Context context) {
            super(context, DownloadProvider.DB_NAME, (SQLiteDatabase.CursorFactory) null, 111);
        }

        private void createDownloadsTable(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
                sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, method INTEGER, entity TEXT, no_integrity BOOLEAN, hint TEXT, otaupdate BOOLEAN, _data TEXT, mimetype TEXT, destination INTEGER, no_system BOOLEAN, visibility INTEGER, control INTEGER, status INTEGER, numfailed INTEGER, lastmod BIGINT, notificationpackage TEXT, notificationclass TEXT, notificationextras TEXT, cookiedata TEXT, useragent TEXT, referer TEXT, total_bytes INTEGER, current_bytes INTEGER, etag TEXT, uid INTEGER, otheruid INTEGER, title TEXT, description TEXT, scanned BOOLEAN);");
            } catch (SQLException e) {
                Log.e("DownloadManager", "couldn't create table in downloads database");
                throw e;
            }
        }

        private void createHeadersTable(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request_headers");
            sQLiteDatabase.execSQL("CREATE TABLE request_headers(id INTEGER PRIMARY KEY AUTOINCREMENT,download_id INTEGER NOT NULL,header TEXT NOT NULL,value TEXT NOT NULL);");
        }

        public static DatabaseHelper getInstance(Context context) {
            if (mDbOpenHelper == null) {
                synchronized (DatabaseHelper.class) {
                    if (mDbOpenHelper == null) {
                        mDbOpenHelper = new DatabaseHelper(context);
                    }
                }
            }
            return mDbOpenHelper;
        }

        private void makeCacheDownloadsInvisible(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.FALSE);
            sQLiteDatabase.update("downloads", contentValues, "destination != 0", null);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "populating new database");
            }
            onUpgrade(sQLiteDatabase, 0, 111);
        }

        private void addColumn(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
            sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD COLUMN " + str2 + " " + str3);
        }

        private boolean checkDownloadTable(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("downloads", null, null, null, null, null, null, "1");
                    if (cursor != null) {
                        if (cursor.getColumnIndex("_id") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("uri") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("method") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("entity") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("no_integrity") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("hint") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Constants.OTA_UPDATE) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("_data") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("mimetype") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("destination") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Constants.NO_SYSTEM_FILES) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("visibility") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("control") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("status") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Constants.FAILED_CONNECTIONS) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("lastmod") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("notificationpackage") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("notificationclass") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("notificationextras") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("cookiedata") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("useragent") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("referer") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("total_bytes") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("current_bytes") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("etag") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("uid") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("otheruid") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("title") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("description") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Constants.MEDIA_SCANNED) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_PUBLIC_API) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_ALLOW_ROAMING) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("mediaprovider_uri") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("deleted") < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_RANGE_START_BYTE) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_RANGE_END_BYTE) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_RANGE) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_BOUNDARY) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex(Downloads.Impl.COLUMN_DOWNLOAD_MOD) < 0) {
                            return false;
                        }
                        if (cursor.getColumnIndex("extra_info") < 0) {
                            return false;
                        }
                    }
                } catch (Exception e) {
                    if (DownloadProvider.DEBUG) {
                        e.printStackTrace();
                    }
                }
                Closeables.closeSafely(cursor);
                return true;
            } finally {
                Closeables.closeSafely(cursor);
            }
        }

        private void fillNullValues(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_bytes", (Integer) 0);
            fillNullValuesForColumn(sQLiteDatabase, contentValues);
            contentValues.put("total_bytes", (Integer) (-1));
            fillNullValuesForColumn(sQLiteDatabase, contentValues);
            contentValues.put("title", "");
            fillNullValuesForColumn(sQLiteDatabase, contentValues);
            contentValues.put("description", "");
            fillNullValuesForColumn(sQLiteDatabase, contentValues);
        }

        private void fillNullValuesForColumn(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
            try {
                sQLiteDatabase.update("downloads", contentValues, contentValues.valueSet().iterator().next().getKey() + " is null", null);
                contentValues.clear();
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }

        private void upgradeTo(SQLiteDatabase sQLiteDatabase, int i) {
            switch (i) {
                case 100:
                    createDownloadsTable(sQLiteDatabase);
                    return;
                case 101:
                    createHeadersTable(sQLiteDatabase);
                    return;
                case 102:
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_IS_PUBLIC_API, "INTEGER NOT NULL DEFAULT 0");
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_ALLOW_ROAMING, "INTEGER NOT NULL DEFAULT 0");
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, "INTEGER NOT NULL DEFAULT 0");
                    return;
                case 103:
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "INTEGER NOT NULL DEFAULT 1");
                    makeCacheDownloadsInvisible(sQLiteDatabase);
                    return;
                case 104:
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT, "INTEGER NOT NULL DEFAULT 0");
                    return;
                case 105:
                    fillNullValues(sQLiteDatabase);
                    return;
                case 106:
                    addColumn(sQLiteDatabase, "downloads", "mediaprovider_uri", "TEXT");
                    addColumn(sQLiteDatabase, "downloads", "deleted", "BOOLEAN NOT NULL DEFAULT 0");
                    return;
                case 107:
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_RANGE_START_BYTE, "INTEGER DEFAULT 0");
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_RANGE_END_BYTE, "INTEGER DEFAULT -1");
                    return;
                case 108:
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_RANGE, "TEXT");
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_BOUNDARY, "TEXT");
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_DOWNLOAD_MOD, "INTEGER DEFAULT 0");
                    addColumn(sQLiteDatabase, "downloads", "extra_info", "TEXT");
                    return;
                case 109:
                    addColumn(sQLiteDatabase, "downloads", "business_type", "INTEGER DEFAULT 0");
                    addColumn(sQLiteDatabase, "downloads", "business_id", "TEXT");
                    addColumn(sQLiteDatabase, "downloads", "progress", "INTEGER DEFAULT 0");
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, "TEXT");
                    return;
                case 110:
                    addColumn(sQLiteDatabase, "downloads", "source", "TEXT");
                    addColumn(sQLiteDatabase, "downloads", "create_time", "BIGINT");
                    return;
                case 111:
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_OPEN_TIME, "BIGINT");
                    addColumn(sQLiteDatabase, "downloads", Downloads.Impl.COLUMN_OPEN_READ, "INTEGER NOT NULL DEFAULT 0");
                    DownloadCenterUtils.moveDocRecentData(sQLiteDatabase);
                    return;
                default:
                    throw new IllegalStateException("Don't know how to upgrade to " + i);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (DownloadRuntime.GLOBAL_DEBUG) {
                Log.i("DownloadManager", "DownloadProvider downgrade database from version " + i + " to " + i2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (DownloadProvider.DEBUG) {
                Log.d(DownloadProvider.TAG, "DatabaseHelper onOpen start: " + System.currentTimeMillis());
            }
            if (!checkDownloadTable(sQLiteDatabase)) {
                onUpgrade(sQLiteDatabase, 0, 111);
            }
            if (DownloadProvider.DEBUG) {
                Log.d(DownloadProvider.TAG, "DatabaseHelper onOpen end: " + System.currentTimeMillis());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 31) {
                i = 100;
            } else {
                if (i < 100) {
                    if (DownloadRuntime.GLOBAL_DEBUG) {
                        Log.i("DownloadManager", "Upgrading downloads database from version " + i + " to version " + i2 + ", which will destroy all old data");
                    }
                } else if (i > i2) {
                    if (DownloadRuntime.GLOBAL_DEBUG) {
                        Log.i("DownloadManager", "Downgrading downloads database from version " + i + " (current version is " + i2 + "), destroying all old data");
                    }
                }
                i = 99;
            }
            while (true) {
                i++;
                if (i <= i2) {
                    try {
                        upgradeTo(sQLiteDatabase, i);
                    } catch (SQLException e) {
                        Log.w(DownloadProvider.TAG, e);
                        for (int i3 = 100; i3 <= i2; i3++) {
                            upgradeTo(sQLiteDatabase, i3);
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ReadOnlyCursorWrapper extends CursorWrapper implements CrossProcessCursor {
        public CrossProcessCursor mCursor;

        public ReadOnlyCursorWrapper(Cursor cursor) {
            super(cursor);
            this.mCursor = (CrossProcessCursor) cursor;
        }

        public boolean commitUpdates() {
            throw new SecurityException("Download manager cursors are read-only");
        }

        public boolean deleteRow() {
            throw new SecurityException("Download manager cursors are read-only");
        }

        @Override // android.database.CrossProcessCursor
        public CursorWindow getWindow() {
            return this.mCursor.getWindow();
        }

        @Override // android.database.CrossProcessCursor
        public void fillWindow(int i, CursorWindow cursorWindow) {
            this.mCursor.fillWindow(i, cursorWindow);
        }

        @Override // android.database.CrossProcessCursor
        public boolean onMove(int i, int i2) {
            return this.mCursor.onMove(i, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class SqlSelection {
        public List<String> mParameters;
        public StringBuilder mWhereClause;

        public SqlSelection() {
            this.mWhereClause = new StringBuilder();
            this.mParameters = new ArrayList();
        }

        public String[] getParameters() {
            return (String[]) this.mParameters.toArray(new String[this.mParameters.size()]);
        }

        public String getSelection() {
            return this.mWhereClause.toString();
        }

        public <T> void appendClause(String str, T... tArr) {
            if (str != null && !TextUtils.isEmpty(str)) {
                if (this.mWhereClause.length() != 0) {
                    this.mWhereClause.append(" AND ");
                }
                this.mWhereClause.append("(");
                this.mWhereClause.append(str);
                this.mWhereClause.append(SmallTailInfo.EMOTION_SUFFIX);
                if (tArr != null) {
                    for (T t : tArr) {
                        this.mParameters.add(t.toString());
                    }
                }
            }
        }
    }

    static {
        String str = AppRuntime.getAppContext().getPackageName() + ".downloads";
        AUTHORITY = str;
        sURIMatcher.addURI(str, "my_downloads", 1);
        sURIMatcher.addURI(AUTHORITY, "my_downloads/#", 2);
        sURIMatcher.addURI(AUTHORITY, "all_downloads", 3);
        sURIMatcher.addURI(AUTHORITY, "all_downloads/#", 4);
        sURIMatcher.addURI(AUTHORITY, "my_downloads/#/headers", 5);
        sURIMatcher.addURI(AUTHORITY, "all_downloads/#/headers", 5);
        sURIMatcher.addURI(AUTHORITY, "download", 1);
        sURIMatcher.addURI(AUTHORITY, "download/#", 2);
        sURIMatcher.addURI(AUTHORITY, "download/#/headers", 5);
        int i = 0;
        BASE_URIS = new Uri[]{Downloads.Impl.CONTENT_URI, Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI};
        sAppReadableColumnsArray = new String[]{"_id", "entity", "_data", "mimetype", "visibility", "destination", "control", "status", "lastmod", "notificationpackage", "notificationclass", "total_bytes", "current_bytes", "title", "description", "uri", Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "hint", "mediaprovider_uri", "deleted", Downloads.Impl.COLUMN_IS_PUBLIC_API, "business_type", "business_id", "progress", Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, "source", "create_time", "extra_info", Downloads.Impl.COLUMN_IS_PUBLIC_API, "business_type", "business_id", "progress", Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, Downloads.Impl.COLUMN_OPEN_TIME, Downloads.Impl.COLUMN_OPEN_READ};
        sAppReadableColumnsSet = new HashSet<>();
        while (true) {
            String[] strArr = sAppReadableColumnsArray;
            if (i < strArr.length) {
                sAppReadableColumnsSet.add(strArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public DownloadProvider(Context context) {
        this.mOpenHelper = null;
        this.mSystemUid = -1;
        this.mContext = context;
        if (this.mISystemFacade == null) {
            this.mISystemFacade = new RealSystemFacade(context);
        }
        this.mOpenHelper = DatabaseHelper.getInstance(context);
        this.mSystemUid = 1000;
    }

    private boolean checkBusinessDownload(ContentValues contentValues) {
        if (contentValues.containsKey("business_type") && contentValues.getAsInteger("business_type").intValue() != 0) {
            return true;
        }
        return false;
    }

    private boolean checkDownloaded(ContentValues contentValues) {
        if (contentValues.containsKey("status") && contentValues.getAsInteger("status").intValue() == 200) {
            return true;
        }
        return false;
    }

    private String getDownloadIdFromUri(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    private boolean shouldRestrictVisibility() {
        int callingUid = Binder.getCallingUid();
        if (Binder.getCallingPid() != Process.myPid() && callingUid != this.mSystemUid && callingUid != this.mDefContainerUid && Process.supportsProcesses()) {
            return true;
        }
        return false;
    }

    public Context getContext() {
        return this.mContext;
    }

    private String checkFileUriDestination(ContentValues contentValues) {
        String asString = contentValues.getAsString("hint");
        if (asString != null) {
            Uri parse = Uri.parse(asString);
            String scheme = parse.getScheme();
            if (scheme != null && scheme.equals("file")) {
                String path = parse.getPath();
                if (path != null) {
                    return path;
                }
                throw new IllegalArgumentException("Invalid file URI: " + parse);
            }
            throw new IllegalArgumentException("Not a file URI: " + parse);
        }
        throw new IllegalArgumentException("DESTINATION_FILE_URI must include a file URI under COLUMN_FILE_NAME_HINT");
    }

    public static void copyBoolean(String str, ContentValues contentValues, ContentValues contentValues2) {
        Boolean asBoolean = contentValues.getAsBoolean(str);
        if (asBoolean != null) {
            contentValues2.put(str, asBoolean);
        }
    }

    public static void copyInteger(String str, ContentValues contentValues, ContentValues contentValues2) {
        Integer asInteger = contentValues.getAsInteger(str);
        if (asInteger != null) {
            contentValues2.put(str, asInteger);
        }
    }

    public static void copyLong(String str, ContentValues contentValues, ContentValues contentValues2) {
        Long asLong = contentValues.getAsLong(str);
        if (asLong != null) {
            contentValues2.put(str, asLong);
        }
    }

    public static void copyString(String str, ContentValues contentValues, ContentValues contentValues2) {
        String asString = contentValues.getAsString(str);
        if (asString != null) {
            contentValues2.put(str, asString);
        }
    }

    public static void copyLongWithDefault(String str, ContentValues contentValues, ContentValues contentValues2, Long l) {
        copyLong(str, contentValues, contentValues2);
        if (!contentValues2.containsKey(str)) {
            contentValues2.put(str, l);
        }
    }

    public static void copyStringWithDefault(String str, ContentValues contentValues, ContentValues contentValues2, String str2) {
        copyString(str, contentValues, contentValues2);
        if (!contentValues2.containsKey(str)) {
            contentValues2.put(str, str2);
        }
    }

    private void deleteRequestHeaders(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        Cursor query;
        Cursor cursor = null;
        try {
            try {
                query = sQLiteDatabase.query("downloads", new String[]{"_id"}, str, strArr, null, null, null, null);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                long j = query.getLong(0);
                sQLiteDatabase.delete(Downloads.Impl.RequestHeaders.HEADERS_DB_TABLE, "download_id=" + j, null);
                query.moveToNext();
            }
            Closeables.closeSafely(query);
        } catch (Exception e2) {
            e = e2;
            cursor = query;
            if (DEBUG) {
                e.printStackTrace();
            }
            Closeables.closeSafely(cursor);
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            Closeables.closeSafely(cursor);
            throw th;
        }
    }

    private void doCloudInsertStatisticJob(long j, String str) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.downloadId = j;
        downloadActionModel.mimeType = str;
        ApkCloudStatisticsUtils.doApkStartDownloadStatisticJob(downloadActionModel);
    }

    private Cursor queryRequestHeaders(SQLiteDatabase sQLiteDatabase, Uri uri) {
        return new ReadOnlyCursorWrapper(sQLiteDatabase.query(Downloads.Impl.RequestHeaders.HEADERS_DB_TABLE, new String[]{"header", "value"}, "download_id=" + getDownloadIdFromUri(uri), null, null, null, null));
    }

    private void enforceAllowedValues(ContentValues contentValues, String str, Object... objArr) {
        Object obj = contentValues.get(str);
        contentValues.remove(str);
        for (Object obj2 : objArr) {
            if (obj == null && obj2 == null) {
                return;
            }
            if (obj != null && obj.equals(obj2)) {
                return;
            }
        }
        throw new SecurityException("Invalid value for " + str + ": " + obj);
    }

    private SqlSelection getWhereClause(Uri uri, String str, String[] strArr, int i) {
        SqlSelection sqlSelection = new SqlSelection();
        sqlSelection.appendClause(str, strArr);
        if (i == 2 || i == 4) {
            sqlSelection.appendClause("_id = ?", getDownloadIdFromUri(uri));
        }
        if ((i == 1 || i == 2) && getContext().checkCallingPermission(Downloads.Impl.PERMISSION_ACCESS_ALL) != 0) {
            sqlSelection.appendClause("uid= ? OR otheruid= ?", Integer.valueOf(Binder.getCallingUid()), Integer.valueOf(Binder.getCallingPid()));
        }
        return sqlSelection;
    }

    private void insertRequestHeaders(SQLiteDatabase sQLiteDatabase, long j, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("download_id", Long.valueOf(j));
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            if (entry.getKey().startsWith(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX)) {
                String obj = entry.getValue().toString();
                if (obj.contains(":")) {
                    String[] split = obj.split(":", 2);
                    contentValues2.put("header", split[0].trim());
                    contentValues2.put("value", split[1].trim());
                    sQLiteDatabase.insert(Downloads.Impl.RequestHeaders.HEADERS_DB_TABLE, null, contentValues2);
                } else {
                    throw new IllegalArgumentException("Invalid HTTP header line: " + obj);
                }
            }
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i;
        DownloadHelper.validateSelection(str, sAppReadableColumnsSet);
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int match = sURIMatcher.match(uri);
        if (match != 1 && match != 2 && match != 3 && match != 4) {
            if (DownloadRuntime.GLOBAL_DEBUG) {
                Log.d("DownloadManager", "deleting unknown/invalid URI: " + uri);
            }
            throw new UnsupportedOperationException("Cannot delete URI: " + uri);
        }
        try {
            SqlSelection whereClause = getWhereClause(uri, str, strArr, match);
            deleteRequestHeaders(writableDatabase, whereClause.getSelection(), whereClause.getParameters());
            i = writableDatabase.delete("downloads", whereClause.getSelection(), whereClause.getParameters());
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        notifyContentChanged(uri, match);
        return i;
    }

    private void logVerboseOpenFileInfo(Uri uri, String str) {
        if (AppConfig.isDebug()) {
            Log.v("DownloadManager", "openFile uri: " + uri + ", mode: " + str + ", uid: " + Binder.getCallingUid());
        }
        Cursor cursor = null;
        try {
            try {
                Cursor query = query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, null, null, "_id");
                if (query == null) {
                    Log.v("DownloadManager", "null cursor in openFile");
                } else {
                    if (!query.moveToFirst()) {
                        Log.v("DownloadManager", "empty cursor in openFile");
                    } else {
                        do {
                            Log.v("DownloadManager", "row " + query.getInt(0) + " available");
                        } while (query.moveToNext());
                    }
                    Closeables.closeSafely(query);
                }
                cursor = query(uri, new String[]{"_data"}, null, null, null);
                if (cursor == null) {
                    Log.v("DownloadManager", "null cursor in openFile");
                } else {
                    if (!cursor.moveToFirst()) {
                        Log.v("DownloadManager", "empty cursor in openFile");
                    } else {
                        String string = cursor.getString(0);
                        Log.v("DownloadManager", "filename in openFile: " + string);
                        if (new File(string).isFile()) {
                            Log.v("DownloadManager", "file exists in openFile");
                        }
                    }
                    Closeables.closeSafely(cursor);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00cd: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:51:0x00cd */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Cursor cursor;
        Cursor cursor2;
        int count;
        if (Constants.LOGVV) {
            logVerboseOpenFileInfo(uri, str);
        }
        Cursor cursor3 = null;
        r0 = null;
        r0 = null;
        String str2 = null;
        try {
            try {
                cursor = query(uri, new String[]{"_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        count = cursor.getCount();
                    } catch (SQLiteFullException e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        if (str2 == null) {
                        }
                    }
                } else {
                    count = 0;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                Closeables.closeSafely(cursor3);
                throw th;
            }
        } catch (SQLiteFullException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(cursor3);
            throw th;
        }
        if (count != 1) {
            if (count == 0) {
                throw new FileNotFoundException("No entry for " + uri);
            }
            throw new FileNotFoundException("Multiple items at " + uri);
        }
        if (cursor != null) {
            cursor.moveToFirst();
            str2 = cursor.getString(0);
        }
        Closeables.closeSafely(cursor);
        if (str2 == null) {
            if (DownloadHelper.isFilenameValid(str2)) {
                if ("r".equals(str)) {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(str2), LaunchTaskConstants.OTHER_PROCESS);
                    if (open == null) {
                        if (Constants.LOGV) {
                            Log.v("DownloadManager", "couldn't open file");
                        }
                        throw new FileNotFoundException("couldn't open file");
                    }
                    return open;
                }
                throw new FileNotFoundException("Bad mode for " + uri + ": " + str);
            }
            throw new FileNotFoundException("Invalid filename.");
        }
        throw new FileNotFoundException("No filename found.");
    }

    private void logVerboseQueryInfo(String[] strArr, String str, String[] strArr2, String str2, SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("starting query, database is ");
            if (sQLiteDatabase != null) {
                sb.append("not ");
            }
            sb.append("null; ");
            if (strArr == null) {
                sb.append("projection is null; ");
            } else if (strArr.length == 0) {
                sb.append("projection is empty; ");
            } else {
                for (int i = 0; i < strArr.length; i++) {
                    sb.append("projection[");
                    sb.append(i);
                    sb.append("] is ");
                    sb.append(strArr[i]);
                    sb.append("; ");
                }
            }
            sb.append("selection is ");
            sb.append(str);
            sb.append("; ");
            if (strArr2 == null) {
                sb.append("selectionArgs is null; ");
            } else if (strArr2.length == 0) {
                sb.append("selectionArgs is empty; ");
            } else {
                for (int i2 = 0; i2 < strArr2.length; i2++) {
                    sb.append("selectionArgs[");
                    sb.append(i2);
                    sb.append("] is ");
                    sb.append(strArr2[i2]);
                    sb.append("; ");
                }
            }
            sb.append("sort is ");
            sb.append(str2);
            sb.append(".");
            if (AppConfig.isDebug()) {
                Log.v("DownloadManager", sb.toString());
            }
        } catch (Exception e) {
            if (!DEBUG) {
                return;
            }
            throw new DebugException("DownloadProvider.logVerboseQueryInfo: " + e);
        }
    }

    private void notifyContentChanged(Uri uri, int i) {
        Long valueOf;
        Uri[] uriArr;
        if (i != 2 && i != 4) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(Long.parseLong(getDownloadIdFromUri(uri)));
        }
        for (Uri uri2 : BASE_URIS) {
            if (valueOf != null) {
                uri2 = ContentUris.withAppendedId(uri2, valueOf.longValue());
            }
            getContext().getContentResolver().notifyChange(uri2, null);
        }
    }

    public String getType(Uri uri) {
        int match = sURIMatcher.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (Constants.LOGV) {
                    Log.v("DownloadManager", "calling getType on an unknown URI: " + uri);
                }
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            return DOWNLOAD_TYPE;
        }
        return DOWNLOAD_LIST_TYPE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020a A[Catch: NameNotFoundException -> 0x0203, TRY_LEAVE, TryCatch #2 {NameNotFoundException -> 0x0203, blocks: (B:87:0x01fa, B:92:0x0205, B:94:0x020a), top: B:154:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Uri insert(Uri uri, ContentValues contentValues) {
        boolean z;
        String str;
        boolean equals;
        Integer asInteger;
        String str2;
        Integer asInteger2;
        int i;
        String asString;
        String asString2;
        boolean z2;
        long insert;
        long j;
        long j2;
        int callingUid;
        boolean z3;
        Integer num;
        JSONObject jSONObject;
        checkInsertPermissions(contentValues);
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int match = sURIMatcher.match(uri);
        if (match != 1) {
            if (DownloadRuntime.GLOBAL_DEBUG) {
                Log.d("DownloadManager", "calling insert on an unknown/invalid URI: " + uri);
            }
            throw new IllegalArgumentException("Unknown/Invalid URI " + uri);
        }
        if (!checkDownloaded(contentValues) && !checkBusinessDownload(contentValues)) {
            z = false;
        } else {
            z = true;
        }
        ContentValues contentValues2 = new ContentValues();
        copyInteger("business_type", contentValues, contentValues2);
        copyLong(Downloads.Impl.COLUMN_OPEN_TIME, contentValues, contentValues2);
        copyBoolean(Downloads.Impl.COLUMN_OPEN_READ, contentValues, contentValues2);
        copyString("business_id", contentValues, contentValues2);
        copyInteger("progress", contentValues, contentValues2);
        copyString("uri", contentValues, contentValues2);
        copyString("entity", contentValues, contentValues2);
        copyBoolean("no_integrity", contentValues, contentValues2);
        copyString("source", contentValues, contentValues2);
        contentValues2.put("create_time", Long.valueOf(System.currentTimeMillis()));
        String asString3 = contentValues.getAsString("hint");
        if (asString3 != null) {
            contentValues.put("hint", DownloadHelper.getFileNameCutOff(asString3));
        }
        copyString("hint", contentValues, contentValues2);
        String asString4 = contentValues.getAsString("mimetype");
        if (TextUtils.isEmpty(asString4)) {
            String asString5 = contentValues.getAsString("_data");
            if (TextUtils.isEmpty(asString5)) {
                asString5 = contentValues.getAsString("uri");
            }
            asString4 = ApkCloudStatisticsUtils.getDownloadStaticMimeType(asString5);
            if (!TextUtils.isEmpty(asString4)) {
                contentValues.put("mimetype", asString4);
            }
        }
        copyString("mimetype", contentValues, contentValues2);
        try {
            String asString6 = contentValues.getAsString("extra_info");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(asString6)) {
                str = "mimetype";
                try {
                    jSONObject = new JSONObject(asString6);
                } catch (Exception e) {
                    e = e;
                    if (AppConfig.isDebug()) {
                        throw new DebugException("insert ORIGINAL_URI fail" + e);
                    }
                    copyString("extra_info", contentValues, contentValues2);
                    copyBoolean(Downloads.Impl.COLUMN_IS_PUBLIC_API, contentValues, contentValues2);
                    equals = Boolean.TRUE.equals(contentValues.getAsBoolean(Downloads.Impl.COLUMN_IS_PUBLIC_API));
                    asInteger = contentValues.getAsInteger("destination");
                    if (asInteger == null) {
                    }
                    asInteger2 = contentValues.getAsInteger("visibility");
                    if (asInteger2 != null) {
                    }
                    if (contentValues2.getAsInteger("visibility").intValue() != i) {
                    }
                    copyInteger("control", contentValues, contentValues2);
                    if (!z) {
                    }
                    contentValues2.put("lastmod", Long.valueOf(this.mISystemFacade.currentTimeMillis()));
                    asString = contentValues.getAsString("notificationpackage");
                    asString2 = contentValues.getAsString("notificationclass");
                    if (asString != null) {
                        callingUid = Binder.getCallingUid();
                        if (callingUid != 0) {
                        }
                        contentValues2.put("notificationpackage", asString);
                        if (asString2 != null) {
                        }
                    }
                    copyString("notificationextras", contentValues, contentValues2);
                    copyString("cookiedata", contentValues, contentValues2);
                    copyString("useragent", contentValues, contentValues2);
                    copyString("referer", contentValues, contentValues2);
                    contentValues2.put("uid", Integer.valueOf(Binder.getCallingUid()));
                    if (Binder.getCallingUid() == 0) {
                    }
                    copyStringWithDefault("title", contentValues, contentValues2, (!TextUtils.isEmpty(asString3) || asString3.startsWith("file://")) ? "" : "");
                    copyStringWithDefault("description", contentValues, contentValues2, "");
                    if (!z) {
                    }
                    copyLongWithDefault(Downloads.Impl.COLUMN_RANGE_END_BYTE, contentValues, contentValues2, -1L);
                    copyLongWithDefault(Downloads.Impl.COLUMN_RANGE_START_BYTE, contentValues, contentValues2, 0L);
                    copyString(Downloads.Impl.COLUMN_RANGE, contentValues, contentValues2);
                    if (!contentValues.containsKey(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI)) {
                    }
                    if (equals) {
                    }
                    if (Constants.LOGVV) {
                    }
                    Context context = getContext();
                    if (!z) {
                    }
                    insert = writableDatabase.insert("downloads", null, contentValues2);
                    if (insert != -1) {
                    }
                }
            } else {
                str = "mimetype";
                jSONObject = jSONObject2;
            }
            jSONObject.put("originalUri", contentValues.getAsString("uri"));
            contentValues.put("extra_info", jSONObject.toString());
        } catch (Exception e2) {
            e = e2;
            str = "mimetype";
        }
        copyString("extra_info", contentValues, contentValues2);
        copyBoolean(Downloads.Impl.COLUMN_IS_PUBLIC_API, contentValues, contentValues2);
        equals = Boolean.TRUE.equals(contentValues.getAsBoolean(Downloads.Impl.COLUMN_IS_PUBLIC_API));
        asInteger = contentValues.getAsInteger("destination");
        if (asInteger == null) {
            str2 = asString4;
            if (getContext().checkCallingPermission(Downloads.Impl.PERMISSION_CACHE_NON_PURGEABLE) == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (equals) {
                num = asInteger;
                if (asInteger.intValue() == 2 && z3) {
                    asInteger = 1;
                    if (asInteger.intValue() != 4 && !DownloadHelper.isStoragePrivatePath(checkFileUriDestination(contentValues)) && !DownloadHelper.isStoragePermissionGranted()) {
                        Log.e(TAG, "need WRITE_EXTERNAL_STORAGE permission to use DESTINATION_FILE_URI");
                        return null;
                    }
                    contentValues2.put("destination", asInteger);
                }
            } else {
                num = asInteger;
            }
            asInteger = num;
            if (asInteger.intValue() != 4) {
            }
            contentValues2.put("destination", asInteger);
        } else {
            str2 = asString4;
        }
        asInteger2 = contentValues.getAsInteger("visibility");
        if (asInteger2 != null) {
            if (asInteger.intValue() == 0) {
                contentValues2.put("visibility", (Integer) 1);
                i = 2;
            } else {
                i = 2;
                contentValues2.put("visibility", (Integer) 2);
            }
        } else {
            i = 2;
            contentValues2.put("visibility", asInteger2);
        }
        if (contentValues2.getAsInteger("visibility").intValue() != i) {
            if (contentValues.getAsBoolean(Constants.MEDIA_SCANNED) == null) {
                contentValues.put(Constants.MEDIA_SCANNED, Boolean.TRUE);
            }
            copyBoolean(Constants.MEDIA_SCANNED, contentValues, contentValues2);
        }
        copyInteger("control", contentValues, contentValues2);
        if (!z) {
            copyInteger("status", contentValues, contentValues2);
            copyString("_data", contentValues, contentValues2);
        } else {
            contentValues2.put("status", (Integer) 190);
        }
        contentValues2.put("lastmod", Long.valueOf(this.mISystemFacade.currentTimeMillis()));
        asString = contentValues.getAsString("notificationpackage");
        asString2 = contentValues.getAsString("notificationclass");
        if (asString != null && (asString2 != null || equals)) {
            callingUid = Binder.getCallingUid();
            if (callingUid != 0) {
                try {
                    if (this.mISystemFacade.userOwnsPackage(callingUid, asString)) {
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.w(TAG, e3);
                }
            }
            contentValues2.put("notificationpackage", asString);
            if (asString2 != null) {
                contentValues2.put("notificationclass", asString2);
            }
        }
        copyString("notificationextras", contentValues, contentValues2);
        copyString("cookiedata", contentValues, contentValues2);
        copyString("useragent", contentValues, contentValues2);
        copyString("referer", contentValues, contentValues2);
        contentValues2.put("uid", Integer.valueOf(Binder.getCallingUid()));
        if (Binder.getCallingUid() == 0) {
            copyInteger("uid", contentValues, contentValues2);
        }
        copyStringWithDefault("title", contentValues, contentValues2, (!TextUtils.isEmpty(asString3) || asString3.startsWith("file://")) ? "" : "");
        copyStringWithDefault("description", contentValues, contentValues2, "");
        if (!z) {
            Long asLong = contentValues.getAsLong("total_bytes");
            if (asLong != null) {
                j = asLong.longValue();
            } else {
                j = -1;
            }
            contentValues2.put("total_bytes", Long.valueOf(j));
            Long asLong2 = contentValues.getAsLong("current_bytes");
            if (asLong2 != null) {
                j2 = asLong2.longValue();
            } else {
                j2 = 0;
            }
            contentValues2.put("current_bytes", Long.valueOf(j2));
            z2 = false;
        } else {
            contentValues2.put("total_bytes", (Integer) (-1));
            z2 = false;
            contentValues2.put("current_bytes", (Integer) 0);
        }
        copyLongWithDefault(Downloads.Impl.COLUMN_RANGE_END_BYTE, contentValues, contentValues2, -1L);
        copyLongWithDefault(Downloads.Impl.COLUMN_RANGE_START_BYTE, contentValues, contentValues2, 0L);
        copyString(Downloads.Impl.COLUMN_RANGE, contentValues, contentValues2);
        if (!contentValues.containsKey(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI)) {
            copyBoolean(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, contentValues, contentValues2);
        } else {
            contentValues2.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf((asInteger == null || asInteger.intValue() == 0) ? true : true));
        }
        if (equals) {
            copyInteger(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, contentValues, contentValues2);
            copyBoolean(Downloads.Impl.COLUMN_ALLOW_ROAMING, contentValues, contentValues2);
        }
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "initiating download with UID " + contentValues2.getAsInteger("uid"));
            if (contentValues2.containsKey("otheruid")) {
                Log.v("DownloadManager", "other UID " + contentValues2.getAsInteger("otheruid"));
            }
        }
        Context context2 = getContext();
        if (!z) {
            DSUtils.startDownloadServices(context2);
        }
        insert = writableDatabase.insert("downloads", null, contentValues2);
        if (insert != -1) {
            if (DownloadRuntime.GLOBAL_DEBUG) {
                Log.d("DownloadManager", "couldn't insert into downloads database");
            }
            return null;
        }
        if (!z) {
            insertRequestHeaders(writableDatabase, insert, contentValues);
            DSUtils.startDownloadServices(context2);
        }
        notifyContentChanged(uri, match);
        if (!TextUtils.isEmpty(str2)) {
            doCloudInsertStatisticJob(insert, contentValues.getAsString(str));
        }
        return ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, insert);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = this.mOpenHelper.getReadableDatabase();
        int match = sURIMatcher.match(uri);
        if (match == -1) {
            if (Constants.LOGV) {
                Log.v("DownloadManager", "querying unknown URI: " + uri);
            }
            throw new IllegalArgumentException("Unknown URI: " + uri);
        } else if (match == 5) {
            if (strArr == null && str == null && str2 == null) {
                return queryRequestHeaders(readableDatabase, uri);
            }
            throw new UnsupportedOperationException("Request header queries do not support projections, selections or sorting");
        } else {
            SqlSelection whereClause = getWhereClause(uri, str, strArr2, match);
            if (shouldRestrictVisibility()) {
                if (strArr == null) {
                    strArr = sAppReadableColumnsArray;
                } else {
                    for (int i = 0; i < strArr.length; i++) {
                        if (!sAppReadableColumnsSet.contains(strArr[i])) {
                            throw new IllegalArgumentException("column " + strArr[i] + " is not allowed in queries");
                        }
                    }
                }
            }
            if (Constants.LOGVV) {
                logVerboseQueryInfo(strArr, str, strArr2, str2, readableDatabase);
            }
            Cursor query = readableDatabase.query("downloads", strArr, whereClause.getSelection(), whereClause.getParameters(), null, null, str2);
            if (query != null) {
                query = new ReadOnlyCursorWrapper(query);
            }
            if (query != null) {
                query.setNotificationUri(getContext().getContentResolver(), uri);
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "created cursor " + query + " on behalf of " + Binder.getCallingPid());
                }
            } else if (Constants.LOGV) {
                Log.v("DownloadManager", "query failed in downloads database");
            }
            return query;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        boolean z;
        Integer asInteger;
        boolean z2;
        Cursor query;
        int match;
        ContentValues contentValues2 = contentValues;
        DownloadHelper.validateSelection(str, sAppReadableColumnsSet);
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int i = 0;
        if (contentValues2.containsKey("deleted") && !checkBusinessDownload(contentValues2) && contentValues2.getAsInteger("deleted").intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (Binder.getCallingPid() != Process.myPid()) {
            ContentValues contentValues3 = new ContentValues();
            copyString("entity", contentValues2, contentValues3);
            copyInteger("visibility", contentValues2, contentValues3);
            Integer asInteger2 = contentValues2.getAsInteger("control");
            if (asInteger2 != null) {
                contentValues3.put("control", asInteger2);
                z = true;
            }
            copyInteger("control", contentValues2, contentValues3);
            copyString("title", contentValues2, contentValues3);
            copyString("mediaprovider_uri", contentValues2, contentValues3);
            copyString("description", contentValues2, contentValues3);
            copyInteger("deleted", contentValues2, contentValues3);
            copyInteger(Constants.MEDIA_SCANNED, contentValues2, contentValues3);
            contentValues2 = contentValues3;
        } else {
            String asString = contentValues2.getAsString("_data");
            if (asString != null) {
                Cursor cursor = null;
                try {
                    try {
                        query = query(uri, new String[]{"title"}, null, null, null);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                }
                try {
                    if (!query.moveToFirst() || TextUtils.isEmpty(query.getString(0))) {
                        contentValues2.put("title", new File(asString).getName());
                    }
                    Closeables.closeSafely(query);
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                    asInteger = contentValues2.getAsInteger("status");
                    if (asInteger == null) {
                    }
                    z2 = false;
                    boolean containsKey = contentValues2.containsKey(Downloads.Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT);
                    if (!z2) {
                    }
                    z = true;
                    match = sURIMatcher.match(uri);
                    if (match == 1) {
                    }
                    SqlSelection whereClause = getWhereClause(uri, str, strArr, match);
                    if (contentValues2.size() > 0) {
                    }
                    notifyContentChanged(uri, match);
                    if (z) {
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
            asInteger = contentValues2.getAsInteger("status");
            if (asInteger == null && asInteger.intValue() == 190) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean containsKey2 = contentValues2.containsKey(Downloads.Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT);
            if (!z2 || containsKey2) {
                z = true;
            }
        }
        match = sURIMatcher.match(uri);
        if (match == 1 && match != 2 && match != 3 && match != 4) {
            if (DownloadRuntime.GLOBAL_DEBUG) {
                Log.d("DownloadManager", "updating unknown/invalid URI: " + uri);
            }
            return 0;
        }
        SqlSelection whereClause2 = getWhereClause(uri, str, strArr, match);
        if (contentValues2.size() > 0) {
            try {
                i = writableDatabase.update("downloads", contentValues2, whereClause2.getSelection(), whereClause2.getParameters());
            } catch (Exception e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
        notifyContentChanged(uri, match);
        if (z) {
            DSUtils.startDownloadServices(getContext());
        }
        return i;
    }
}
