package com.baidu.swan.apps.database.subscribe;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.database.SwanAppDbControl;
import d.a.i0.a.c1.a;
/* loaded from: classes2.dex */
public class SwanAppSubscribeMsgProvider extends ContentProvider {
    public static final String CONTENT_AUTHORITY = a.b().getPackageName() + ".swan.subscribe_msg";
    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    @Nullable
    public SQLiteDatabase mDatabase;

    private synchronized boolean isInitDBFail() {
        if (this.mDatabase != null) {
            return false;
        }
        SQLiteOpenHelper h2 = SwanAppDbControl.f(a.b()).h();
        if (h2 != null) {
            SQLiteDatabase writableDatabase = h2.getWritableDatabase();
            this.mDatabase = writableDatabase;
            return writableDatabase == null;
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public int delete(@Nullable Uri uri, @Nullable String str, @Nullable String[] strArr) {
        if (isInitDBFail()) {
            return 0;
        }
        return this.mDatabase.delete("swanapp_subscribe_msg", str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@Nullable Uri uri) {
        return CONTENT_AUTHORITY;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@Nullable Uri uri, @Nullable ContentValues contentValues) {
        if (!isInitDBFail() && this.mDatabase.insert("swanapp_subscribe_msg", null, contentValues) > 0) {
            return uri;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@Nullable Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (isInitDBFail()) {
            return null;
        }
        return this.mDatabase.query("swanapp_subscribe_msg", strArr, str, strArr2, null, null, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@Nullable Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (isInitDBFail()) {
            return 0;
        }
        return this.mDatabase.update("swanapp_subscribe_msg", contentValues, str, strArr);
    }
}
