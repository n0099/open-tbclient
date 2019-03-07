package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b Au;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.Au = bVar;
    }

    public h aH(String str) {
        Cursor cursor;
        try {
            cursor = this.Au.ga().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.Au.c(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.AH = cursor.getString(0);
            hVar.Av = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.AM = cursor.getString(3);
            hVar.AN = cursor.getInt(4);
            hVar.AO = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.AH);
            contentValues.put("tableName", hVar.Av);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.AN));
            contentValues.put("cacheType", hVar.AM);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.AO));
            SQLiteDatabase ga = this.Au.ga();
            if (ga != null && ga.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.AH}) == 0) {
                ga.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.Au.c(th, "addOrUpdate");
        }
    }

    public int aI(String str) {
        try {
            if (aH(str) == null) {
                return 0;
            }
            return this.Au.ga().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.Au.c(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
