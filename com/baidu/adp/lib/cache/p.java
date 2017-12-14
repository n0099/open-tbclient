package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b sA;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.sA = bVar;
    }

    public h Y(String str) {
        Cursor cursor;
        try {
            cursor = this.sA.ch().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.sA.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.sN = cursor.getString(0);
            hVar.sB = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.sR = cursor.getString(3);
            hVar.sS = cursor.getInt(4);
            hVar.sT = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.sN);
            contentValues.put("tableName", hVar.sB);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.sS));
            contentValues.put("cacheType", hVar.sR);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.sT));
            SQLiteDatabase ch = this.sA.ch();
            if (ch != null && ch.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.sN}) == 0) {
                ch.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.sA.a(th, "addOrUpdate");
        }
    }

    public int Z(String str) {
        try {
            if (Y(str) == null) {
                return 0;
            }
            return this.sA.ch().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.sA.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
