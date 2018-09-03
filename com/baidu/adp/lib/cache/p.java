package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b xq;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.xq = bVar;
    }

    public h aq(String str) {
        Cursor cursor;
        try {
            cursor = this.xq.eD().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.xq.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.xD = cursor.getString(0);
            hVar.xr = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.xH = cursor.getString(3);
            hVar.xI = cursor.getInt(4);
            hVar.xJ = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.xD);
            contentValues.put("tableName", hVar.xr);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.xI));
            contentValues.put("cacheType", hVar.xH);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.xJ));
            SQLiteDatabase eD = this.xq.eD();
            if (eD != null && eD.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.xD}) == 0) {
                eD.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.xq.a(th, "addOrUpdate");
        }
    }

    public int ar(String str) {
        try {
            if (aq(str) == null) {
                return 0;
            }
            return this.xq.eD().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.xq.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
