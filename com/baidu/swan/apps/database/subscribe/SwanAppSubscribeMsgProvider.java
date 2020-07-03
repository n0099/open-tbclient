package com.baidu.swan.apps.database.subscribe;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.database.SwanAppDbControl;
/* loaded from: classes11.dex */
public class SwanAppSubscribeMsgProvider extends ContentProvider {
    @Nullable
    private SQLiteDatabase mDatabase;
    private static final String cgz = com.baidu.swan.apps.u.a.afX().getPackageName() + ".swan.subscribe_msg";
    public static final Uri CONTENT_URI = Uri.parse("content://" + cgz);

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    private synchronized boolean adt() {
        boolean z = true;
        synchronized (this) {
            if (this.mDatabase != null) {
                z = false;
            } else {
                SQLiteOpenHelper acW = SwanAppDbControl.bO(com.baidu.swan.apps.u.a.afX()).acW();
                if (acW != null) {
                    this.mDatabase = acW.getWritableDatabase();
                    if (this.mDatabase != null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@Nullable Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (adt()) {
            return null;
        }
        return this.mDatabase.query("swanapp_subscribe_msg", strArr, str, strArr2, null, null, str2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@Nullable Uri uri) {
        return cgz;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@Nullable Uri uri, @Nullable ContentValues contentValues) {
        if (adt()) {
            return null;
        }
        if (this.mDatabase.insert("swanapp_subscribe_msg", null, contentValues) <= 0) {
            uri = null;
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public int delete(@Nullable Uri uri, @Nullable String str, @Nullable String[] strArr) {
        if (adt()) {
            return 0;
        }
        return this.mDatabase.delete("swanapp_subscribe_msg", str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@Nullable Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (adt()) {
            return 0;
        }
        return this.mDatabase.update("swanapp_subscribe_msg", contentValues, str, strArr);
    }
}
