package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b sB;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.sB = bVar;
    }

    public h Y(String str) {
        Cursor cursor;
        try {
            cursor = this.sB.ch().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.sB.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.sO = cursor.getString(0);
            hVar.sC = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.sS = cursor.getString(3);
            hVar.sT = cursor.getInt(4);
            hVar.sU = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.sO);
            contentValues.put("tableName", hVar.sC);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.sT));
            contentValues.put("cacheType", hVar.sS);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.sU));
            SQLiteDatabase ch = this.sB.ch();
            if (ch != null && ch.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.sO}) == 0) {
                ch.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.sB.a(th, "addOrUpdate");
        }
    }

    public int Z(String str) {
        try {
            if (Y(str) == null) {
                return 0;
            }
            return this.sB.ch().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.sB.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
