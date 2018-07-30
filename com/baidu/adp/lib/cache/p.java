package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b xp;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.xp = bVar;
    }

    public h aq(String str) {
        Cursor cursor;
        try {
            cursor = this.xp.eD().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.xp.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.xC = cursor.getString(0);
            hVar.xq = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.xG = cursor.getString(3);
            hVar.xH = cursor.getInt(4);
            hVar.xI = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.xC);
            contentValues.put("tableName", hVar.xq);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.xH));
            contentValues.put("cacheType", hVar.xG);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.xI));
            SQLiteDatabase eD = this.xp.eD();
            if (eD != null && eD.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.xC}) == 0) {
                eD.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.xp.a(th, "addOrUpdate");
        }
    }

    public int ar(String str) {
        try {
            if (aq(str) == null) {
                return 0;
            }
            return this.xp.eD().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.xp.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
