package com.baidu.swan.apps.database.subscribe;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.tieba.br2;
/* loaded from: classes3.dex */
public class SwanAppSubscribeMsgProvider extends ContentProvider {
    public static final String b = br2.c().getPackageName() + ".swan.subscribe_msg";
    public static final Uri c = Uri.parse("content://" + b);
    @Nullable
    public SQLiteDatabase a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    public final synchronized boolean a() {
        boolean z = false;
        if (this.a != null) {
            return false;
        }
        SQLiteOpenHelper h = SwanAppDbControl.f(br2.c()).h();
        if (h == null) {
            return true;
        }
        SQLiteDatabase writableDatabase = h.getWritableDatabase();
        this.a = writableDatabase;
        if (writableDatabase == null) {
            z = true;
        }
        return z;
    }

    @Override // android.content.ContentProvider
    public int delete(@Nullable Uri uri, @Nullable String str, @Nullable String[] strArr) {
        if (a()) {
            return 0;
        }
        return this.a.delete("swanapp_subscribe_msg", str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@Nullable Uri uri) {
        return b;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@Nullable Uri uri, @Nullable ContentValues contentValues) {
        if (a() || this.a.insert("swanapp_subscribe_msg", null, contentValues) <= 0) {
            return null;
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@Nullable Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (a()) {
            return null;
        }
        return this.a.query("swanapp_subscribe_msg", strArr, str, strArr2, null, null, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@Nullable Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (a()) {
            return 0;
        }
        return this.a.update("swanapp_subscribe_msg", contentValues, str, strArr);
    }
}
