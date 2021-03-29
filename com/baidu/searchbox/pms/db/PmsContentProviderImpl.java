package com.baidu.searchbox.pms.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.utils.DebugUtils;
/* loaded from: classes2.dex */
public class PmsContentProviderImpl {
    public static final String AUTHORITY = AppRuntime.getApplication().getPackageName() + ".pms.db.provider";
    public static final Uri BASE_URI;
    public static final int CODE_EXECUTE_SQL = 102;
    public static final int CODE_QUERY_SQL = 101;
    public static final int CODE_TABLE_PACKAGE_INFO = 100;
    public static final String COLUMN_ID = "id";
    public static final Uri CONTENT_URI_EXECUTE_SQL;
    public static final Uri CONTENT_URI_PACKAGE_INFO;
    public static final Uri CONTENT_URI_QUERY_SQL;
    public static final String PATH_EXECUTE_SQL = "execute_sql";
    public static final String PATH_QUERY_SQL = "query_sql";
    public static final String PATH_TABLE_PACKAGE_INFO = "package_info";
    public static final UriMatcher sUriMatcher;
    public Context mContext;
    public DbHelper mDbHelper;

    static {
        Uri parse = Uri.parse("content://" + AUTHORITY);
        BASE_URI = parse;
        CONTENT_URI_PACKAGE_INFO = parse.buildUpon().appendPath("package_info").build();
        CONTENT_URI_QUERY_SQL = BASE_URI.buildUpon().appendPath(PATH_QUERY_SQL).build();
        CONTENT_URI_EXECUTE_SQL = BASE_URI.buildUpon().appendPath(PATH_EXECUTE_SQL).build();
        UriMatcher uriMatcher = new UriMatcher(-1);
        sUriMatcher = uriMatcher;
        uriMatcher.addURI(AUTHORITY, "package_info", 100);
        sUriMatcher.addURI(AUTHORITY, PATH_QUERY_SQL, 101);
        sUriMatcher.addURI(AUTHORITY, PATH_EXECUTE_SQL, 102);
    }

    public PmsContentProviderImpl(Context context) {
        this.mContext = context;
    }

    public static int deleteExt(Context context, Uri uri, String str, String[] strArr) {
        try {
            return context.getContentResolver().delete(uri, str, strArr);
        } catch (IllegalArgumentException e2) {
            DebugUtils.throwExceptionForDebug(e2);
            return 0;
        }
    }

    public static void execSqlExt(Context context, String str) {
        try {
            context.getContentResolver().query(CONTENT_URI_EXECUTE_SQL, null, str, null, null);
        } catch (IllegalArgumentException e2) {
            DebugUtils.throwExceptionForDebug(e2);
        }
    }

    private DbHelper getDbHelper() {
        if (this.mDbHelper == null) {
            this.mDbHelper = new DbHelper(this.mContext);
        }
        return this.mDbHelper;
    }

    @Nullable
    public static String getType(@NonNull Uri uri) {
        if (sUriMatcher.match(uri) != 100) {
            return null;
        }
        return "package_info";
    }

    public static long insertExt(Context context, Uri uri, ContentValues contentValues) {
        Uri uri2;
        try {
            uri2 = context.getContentResolver().insert(uri, contentValues);
        } catch (IllegalArgumentException e2) {
            DebugUtils.throwExceptionForDebug(e2);
            uri2 = null;
        }
        if (uri2 == null) {
            return 0L;
        }
        try {
            return Long.parseLong(uri2.getQueryParameter("id"));
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0L;
        }
    }

    public static Cursor queryExt(Context context, Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        try {
            return context.getContentResolver().query(uri, strArr, str, strArr2, str2);
        } catch (IllegalArgumentException e2) {
            DebugUtils.throwExceptionForDebug(e2);
            return null;
        }
    }

    public static int updateExt(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return context.getContentResolver().update(uri, contentValues, str, strArr);
        } catch (IllegalArgumentException e2) {
            DebugUtils.throwExceptionForDebug(e2);
            return 0;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String type = getType(uri);
        if (TextUtils.isEmpty(type)) {
            return 0;
        }
        try {
            return getDbHelper().getWritableDatabase().delete(type, str, strArr);
        } catch (SQLiteFullException e2) {
            DebugUtils.printStackTrace(e2);
            return 0;
        } catch (SQLiteReadOnlyDatabaseException e3) {
            DebugUtils.printStackTrace(e3);
            return 0;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        String type = getType(uri);
        if (TextUtils.isEmpty(type)) {
            return null;
        }
        long j = 0;
        try {
            j = getDbHelper().getWritableDatabase().insert(type, null, contentValues);
        } catch (SQLiteFullException e2) {
            DebugUtils.printStackTrace(e2);
        } catch (SQLiteReadOnlyDatabaseException e3) {
            DebugUtils.printStackTrace(e3);
        }
        Uri.Builder appendPath = BASE_URI.buildUpon().appendPath(type);
        return appendPath.appendQueryParameter("id", j + "").build();
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        try {
            String type = getType(uri);
            if (!TextUtils.isEmpty(type)) {
                return getDbHelper().getReadableDatabase().query(type, strArr, str, strArr2, null, null, str2);
            }
            int match = sUriMatcher.match(uri);
            if (match != 101) {
                if (match != 102) {
                    return null;
                }
                getDbHelper().getWritableDatabase().execSQL(str);
                return null;
            }
            return getDbHelper().getReadableDatabase().rawQuery(str, strArr2);
        } catch (Exception e2) {
            DebugUtils.printStackTrace(e2);
            return null;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String type = getType(uri);
        if (TextUtils.isEmpty(type)) {
            return 0;
        }
        try {
            return getDbHelper().getWritableDatabase().update(type, contentValues, str, strArr);
        } catch (SQLiteFullException e2) {
            DebugUtils.printStackTrace(e2);
            return 0;
        } catch (SQLiteReadOnlyDatabaseException e3) {
            DebugUtils.printStackTrace(e3);
            return 0;
        }
    }

    public static Cursor queryExt(Context context, String str, @Nullable String[] strArr) {
        try {
            return context.getContentResolver().query(CONTENT_URI_QUERY_SQL, null, str, strArr, null);
        } catch (IllegalArgumentException e2) {
            DebugUtils.throwExceptionForDebug(e2);
            return null;
        }
    }
}
