package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b xv;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.xv = bVar;
    }

    public h ap(String str) {
        Cursor cursor;
        try {
            cursor = this.xv.eE().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.xv.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.xI = cursor.getString(0);
            hVar.xw = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.xM = cursor.getString(3);
            hVar.xN = cursor.getInt(4);
            hVar.xO = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.xI);
            contentValues.put("tableName", hVar.xw);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.xN));
            contentValues.put("cacheType", hVar.xM);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.xO));
            SQLiteDatabase eE = this.xv.eE();
            if (eE != null && eE.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.xI}) == 0) {
                eE.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.xv.a(th, "addOrUpdate");
        }
    }

    public int aq(String str) {
        try {
            if (ap(str) == null) {
                return 0;
            }
            return this.xv.eE().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.xv.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
