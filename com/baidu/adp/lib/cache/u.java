package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private final com.baidu.adp.a.f f379a;

    public u(Context context, com.baidu.adp.a.f fVar) {
        this.f379a = fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [54=4] */
    public l a(String str) {
        Cursor cursor;
        try {
            cursor = this.f379a.a().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
            } catch (Throwable th) {
                th = th;
                try {
                    this.f379a.a(th);
                    com.baidu.adp.lib.e.d.b("BdNameSpaceDBManager", str, th.getMessage());
                    return null;
                } finally {
                    com.baidu.adp.lib.e.b.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.e.b.a(cursor);
            return null;
        }
        l lVar = new l();
        lVar.f375a = cursor.getString(0);
        lVar.b = cursor.getString(1);
        lVar.c = cursor.getInt(2);
        lVar.d = cursor.getString(3);
        lVar.e = cursor.getInt(4);
        lVar.f = cursor.getLong(5);
        return lVar;
    }

    public void a(l lVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", lVar.f375a);
            contentValues.put("tableName", lVar.b);
            contentValues.put("maxSize", Integer.valueOf(lVar.c));
            contentValues.put("cacheVersion", Integer.valueOf(lVar.e));
            contentValues.put("cacheType", lVar.d);
            contentValues.put("lastActiveTime", Long.valueOf(lVar.f));
            if (this.f379a.a().update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{lVar.f375a}) == 0) {
                this.f379a.a().insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.f379a.a(th);
            com.baidu.adp.lib.e.d.a("BdNameSpaceDBManager", "failed to insert " + lVar.f375a + " to db.", th);
        }
    }
}
