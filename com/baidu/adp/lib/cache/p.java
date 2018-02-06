package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b agW;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.agW = bVar;
    }

    public h ag(String str) {
        Cursor cursor;
        try {
            cursor = this.agW.jM().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.agW.a(th, "get");
                com.baidu.adp.lib.g.a.i(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.i(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.ahj = cursor.getString(0);
            hVar.agX = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.ahn = cursor.getString(3);
            hVar.aho = cursor.getInt(4);
            hVar.ahp = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.ahj);
            contentValues.put("tableName", hVar.agX);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.aho));
            contentValues.put("cacheType", hVar.ahn);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.ahp));
            SQLiteDatabase jM = this.agW.jM();
            if (jM != null && jM.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.ahj}) == 0) {
                jM.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.agW.a(th, "addOrUpdate");
        }
    }

    public int ah(String str) {
        try {
            if (ag(str) == null) {
                return 0;
            }
            return this.agW.jM().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.agW.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
