package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b zI;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.zI = bVar;
    }

    public h aH(String str) {
        Cursor cursor;
        try {
            cursor = this.zI.fL().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.zI.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.zV = cursor.getString(0);
            hVar.zJ = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.zZ = cursor.getString(3);
            hVar.Aa = cursor.getInt(4);
            hVar.Ab = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.zV);
            contentValues.put("tableName", hVar.zJ);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.Aa));
            contentValues.put("cacheType", hVar.zZ);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.Ab));
            SQLiteDatabase fL = this.zI.fL();
            if (fL != null && fL.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.zV}) == 0) {
                fL.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.zI.a(th, "addOrUpdate");
        }
    }

    public int aI(String str) {
        try {
            if (aH(str) == null) {
                return 0;
            }
            return this.zI.fL().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.zI.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
