package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class ad {
    private final com.baidu.adp.base.a.c a;

    public ad(Context context, com.baidu.adp.base.a.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public n a(String str) {
        Cursor cursor;
        try {
            cursor = this.a.a().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.a.a(th, "get");
                return null;
            } finally {
                com.baidu.adp.lib.e.a.a(cursor);
            }
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.e.a.a(cursor);
            return null;
        }
        n nVar = new n();
        nVar.a = cursor.getString(0);
        nVar.b = cursor.getString(1);
        nVar.c = cursor.getInt(2);
        nVar.d = cursor.getString(3);
        nVar.e = cursor.getInt(4);
        nVar.f = cursor.getLong(5);
        return nVar;
    }

    public void a(n nVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", nVar.a);
            contentValues.put("tableName", nVar.b);
            contentValues.put("maxSize", Integer.valueOf(nVar.c));
            contentValues.put("cacheVersion", Integer.valueOf(nVar.e));
            contentValues.put("cacheType", nVar.d);
            contentValues.put("lastActiveTime", Long.valueOf(nVar.f));
            SQLiteDatabase a = this.a.a();
            if (a != null && a.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{nVar.a}) == 0) {
                a.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.a.a(th, "addOrUpdate");
        }
    }

    public int b(String str) {
        try {
            if (a(str) == null) {
                return 0;
            }
            return this.a.a().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.a.a(th, "delete");
            return 0;
        }
    }
}
