package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b uQ;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.uQ = bVar;
    }

    public h ae(String str) {
        Cursor cursor;
        try {
            cursor = this.uQ.cs().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.uQ.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.vd = cursor.getString(0);
            hVar.uR = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.vh = cursor.getString(3);
            hVar.vi = cursor.getInt(4);
            hVar.vj = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.vd);
            contentValues.put("tableName", hVar.uR);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.vi));
            contentValues.put("cacheType", hVar.vh);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.vj));
            SQLiteDatabase cs = this.uQ.cs();
            if (cs != null && cs.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.vd}) == 0) {
                cs.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.uQ.a(th, "addOrUpdate");
        }
    }

    public int af(String str) {
        try {
            if (ae(str) == null) {
                return 0;
            }
            return this.uQ.cs().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.uQ.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
