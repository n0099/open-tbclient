package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b ye;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.ye = bVar;
    }

    public h ar(String str) {
        Cursor cursor;
        try {
            cursor = this.ye.eT().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.ye.c(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.yr = cursor.getString(0);
            hVar.yf = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.yv = cursor.getString(3);
            hVar.yw = cursor.getInt(4);
            hVar.yx = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.yr);
            contentValues.put("tableName", hVar.yf);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.yw));
            contentValues.put("cacheType", hVar.yv);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.yx));
            SQLiteDatabase eT = this.ye.eT();
            if (eT != null && eT.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.yr}) == 0) {
                eT.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.ye.c(th, "addOrUpdate");
        }
    }

    public int as(String str) {
        try {
            if (ar(str) == null) {
                return 0;
            }
            return this.ye.eT().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.ye.c(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
