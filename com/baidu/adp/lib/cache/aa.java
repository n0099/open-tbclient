package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
/* loaded from: classes.dex */
public final class aa {
    private final com.baidu.adp.a.h a;

    public aa(com.baidu.adp.a.h hVar) {
        this.a = hVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [55=4] */
    public final n a(String str) {
        Cursor cursor;
        try {
            cursor = this.a.a().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
            } catch (Throwable th) {
                th = th;
                try {
                    this.a.b();
                    com.baidu.adp.lib.util.e.b("BdNameSpaceDBManager", str, th.getMessage());
                    return null;
                } finally {
                    com.baidu.adp.lib.f.a.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.f.a.a(cursor);
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

    public final void a(n nVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", nVar.a);
            contentValues.put("tableName", nVar.b);
            contentValues.put("maxSize", Integer.valueOf(nVar.c));
            contentValues.put("cacheVersion", Integer.valueOf(nVar.e));
            contentValues.put("cacheType", nVar.d);
            contentValues.put("lastActiveTime", Long.valueOf(nVar.f));
            if (this.a.a().update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{nVar.a}) == 0) {
                this.a.a().insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.a.b();
            com.baidu.adp.lib.util.e.a("BdNameSpaceDBManager", "failed to insert " + nVar.a + " to db.", th);
        }
    }

    public final int b(String str) {
        try {
            if (a(str) == null) {
                return 0;
            }
            return this.a.a().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.a.b();
            Log.e("BdNameSpaceDBManager", "failed to delete " + str + " from db.", th);
            return 0;
        }
    }
}
