package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b sC;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.sC = bVar;
    }

    public h Y(String str) {
        Cursor cursor;
        try {
            cursor = this.sC.ch().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.sC.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.sP = cursor.getString(0);
            hVar.sD = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.sT = cursor.getString(3);
            hVar.sU = cursor.getInt(4);
            hVar.sV = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.sP);
            contentValues.put("tableName", hVar.sD);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.sU));
            contentValues.put("cacheType", hVar.sT);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.sV));
            SQLiteDatabase ch = this.sC.ch();
            if (ch != null && ch.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.sP}) == 0) {
                ch.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.sC.a(th, "addOrUpdate");
        }
    }

    public int Z(String str) {
        try {
            if (Y(str) == null) {
                return 0;
            }
            return this.sC.ch().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.sC.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
