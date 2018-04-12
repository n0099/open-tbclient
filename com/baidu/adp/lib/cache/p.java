package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b rk;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.rk = bVar;
    }

    public h ad(String str) {
        Cursor cursor;
        try {
            cursor = this.rk.bQ().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.rk.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.ry = cursor.getString(0);
            hVar.rl = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.rC = cursor.getString(3);
            hVar.rD = cursor.getInt(4);
            hVar.rE = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.ry);
            contentValues.put("tableName", hVar.rl);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.rD));
            contentValues.put("cacheType", hVar.rC);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.rE));
            SQLiteDatabase bQ = this.rk.bQ();
            if (bQ != null && bQ.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.ry}) == 0) {
                bQ.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.rk.a(th, "addOrUpdate");
        }
    }

    public int ae(String str) {
        try {
            if (ad(str) == null) {
                return 0;
            }
            return this.rk.bQ().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.rk.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
