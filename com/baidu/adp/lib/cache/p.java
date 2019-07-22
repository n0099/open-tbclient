package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b yj;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.yj = bVar;
    }

    public h as(String str) {
        Cursor cursor;
        try {
            cursor = this.yj.fa().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.yj.c(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.yw = cursor.getString(0);
            hVar.yk = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.yA = cursor.getString(3);
            hVar.yB = cursor.getInt(4);
            hVar.yC = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.yw);
            contentValues.put("tableName", hVar.yk);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.yB));
            contentValues.put("cacheType", hVar.yA);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.yC));
            SQLiteDatabase fa = this.yj.fa();
            if (fa != null && fa.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.yw}) == 0) {
                fa.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.yj.c(th, "addOrUpdate");
        }
    }

    public int at(String str) {
        try {
            if (as(str) == null) {
                return 0;
            }
            return this.yj.fa().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.yj.c(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
