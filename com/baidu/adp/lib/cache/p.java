package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b yd;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.yd = bVar;
    }

    public h ar(String str) {
        Cursor cursor;
        try {
            cursor = this.yd.eT().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.yd.c(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.yq = cursor.getString(0);
            hVar.ye = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.yu = cursor.getString(3);
            hVar.yv = cursor.getInt(4);
            hVar.yw = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.yq);
            contentValues.put("tableName", hVar.ye);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.yv));
            contentValues.put("cacheType", hVar.yu);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.yw));
            SQLiteDatabase eT = this.yd.eT();
            if (eT != null && eT.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.yq}) == 0) {
                eT.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.yd.c(th, "addOrUpdate");
        }
    }

    public int as(String str) {
        try {
            if (ar(str) == null) {
                return 0;
            }
            return this.yd.eT().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.yd.c(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
