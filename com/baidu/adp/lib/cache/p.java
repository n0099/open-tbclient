package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.lib.cache.BdCacheSQLiteHelper;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b pN;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.pN = bVar;
    }

    public h ae(String str) {
        Cursor cursor;
        try {
            cursor = this.pN.getOpenedDatabase().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.pN.notifySQLException(th, "get");
                com.baidu.adp.lib.f.a.close(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.f.a.close(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.nameSpace = cursor.getString(0);
            hVar.tableName = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.cacheType = cursor.getString(3);
            hVar.cacheVersion = cursor.getInt(4);
            hVar.lastActiveTime = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.nameSpace);
            contentValues.put("tableName", hVar.tableName);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.cacheVersion));
            contentValues.put("cacheType", hVar.cacheType);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.lastActiveTime));
            SQLiteDatabase openedDatabase = this.pN.getOpenedDatabase();
            if (openedDatabase != null && openedDatabase.update(BdCacheSQLiteHelper.TABLE_CACHE_META_INFO, contentValues, "nameSpace = ?", new String[]{hVar.nameSpace}) == 0) {
                openedDatabase.insert(BdCacheSQLiteHelper.TABLE_CACHE_META_INFO, null, contentValues);
            }
        } catch (Throwable th) {
            this.pN.notifySQLException(th, "addOrUpdate");
        }
    }

    public int delete(String str) {
        try {
            if (ae(str) == null) {
                return 0;
            }
            return this.pN.getOpenedDatabase().delete(BdCacheSQLiteHelper.TABLE_CACHE_META_INFO, "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.pN.notifySQLException(th, "delete");
            return 0;
        }
    }
}
