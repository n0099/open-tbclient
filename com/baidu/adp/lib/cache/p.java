package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b rj;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.rj = bVar;
    }

    public h ad(String str) {
        Cursor cursor;
        try {
            cursor = this.rj.bQ().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.rj.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.rx = cursor.getString(0);
            hVar.rk = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.rB = cursor.getString(3);
            hVar.rC = cursor.getInt(4);
            hVar.rD = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.rx);
            contentValues.put("tableName", hVar.rk);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.rC));
            contentValues.put("cacheType", hVar.rB);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.rD));
            SQLiteDatabase bQ = this.rj.bQ();
            if (bQ != null && bQ.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.rx}) == 0) {
                bQ.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.rj.a(th, "addOrUpdate");
        }
    }

    public int ae(String str) {
        try {
            if (ad(str) == null) {
                return 0;
            }
            return this.rj.bQ().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.rj.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
