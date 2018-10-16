package com.baidu.searchbox.ng.ai.apps.database.subpackage;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageTable;
/* loaded from: classes2.dex */
public class SubPackageProvider extends ContentProvider {
    public static final String AUTHORITY = "com.baidu.tieba.aiapps.subpackage";
    private static final boolean DEBUG = false;
    private static final int SUB_PACKAGE_TABLE_CODE = 0;
    private static final String TAG = "SubPackageProvider";
    private static UriMatcher sURIMatcher = new UriMatcher(-1);
    private Context mContext;
    private SQLiteOpenHelper mSQLiteOpenHelper;

    static {
        sURIMatcher.addURI(AUTHORITY, SubPackageTable.Table.TABLE_NAME, 0);
    }

    public static Uri getUri() {
        return Uri.parse("content://com.baidu.tieba.aiapps.subpackage/ai_app_sub_package_data");
    }

    private String getTableName(Uri uri) {
        switch (sURIMatcher.match(uri)) {
            case 0:
                return SubPackageTable.Table.TABLE_NAME;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mContext = getContext();
        if (AppRuntime.getAppContext() == null) {
            AppRuntimeInit.onApplicationattachBaseContext((Application) this.mContext);
            return true;
        }
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            return null;
        }
        return getSQLiteOpenHelper().getReadableDatabase().query(tableName, strArr, str, strArr2, null, null, str2, null);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName) || contentValues == null) {
            return null;
        }
        getSQLiteOpenHelper().getWritableDatabase().insert(tableName, null, contentValues);
        this.mContext.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            return 0;
        }
        int delete = getSQLiteOpenHelper().getWritableDatabase().delete(tableName, str, strArr);
        if (delete > 0) {
            this.mContext.getContentResolver().notifyChange(uri, null);
            return delete;
        }
        return delete;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            return 0;
        }
        int update = getSQLiteOpenHelper().getWritableDatabase().update(tableName, contentValues, str, strArr);
        if (update > 0) {
            this.mContext.getContentResolver().notifyChange(uri, null);
            return update;
        }
        return update;
    }

    private SQLiteOpenHelper getSQLiteOpenHelper() {
        if (this.mSQLiteOpenHelper == null) {
            this.mSQLiteOpenHelper = AiAppsDbControl.getInstance(this.mContext).getSQLiteOpenHelper();
        }
        return this.mSQLiteOpenHelper;
    }
}
