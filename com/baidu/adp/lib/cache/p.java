package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b agQ;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.agQ = bVar;
    }

    public h ag(String str) {
        Cursor cursor;
        try {
            cursor = this.agQ.jM().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.agQ.a(th, "get");
                com.baidu.adp.lib.g.a.i(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.i(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.ahd = cursor.getString(0);
            hVar.agR = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.ahh = cursor.getString(3);
            hVar.ahi = cursor.getInt(4);
            hVar.ahj = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.ahd);
            contentValues.put("tableName", hVar.agR);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.ahi));
            contentValues.put("cacheType", hVar.ahh);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.ahj));
            SQLiteDatabase jM = this.agQ.jM();
            if (jM != null && jM.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.ahd}) == 0) {
                jM.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.agQ.a(th, "addOrUpdate");
        }
    }

    public int ah(String str) {
        try {
            if (ag(str) == null) {
                return 0;
            }
            return this.agQ.jM().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.agQ.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
