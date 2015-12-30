package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class v {
    private final com.baidu.adp.base.a.b sQ;

    public v(Context context, com.baidu.adp.base.a.b bVar) {
        this.sQ = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i ac(String str) {
        Cursor cursor;
        try {
            cursor = this.sQ.dL().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.sQ.d(th, "get");
                return null;
            } finally {
                com.baidu.adp.lib.h.a.b(cursor);
            }
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.h.a.b(cursor);
            return null;
        }
        i iVar = new i();
        iVar.te = cursor.getString(0);
        iVar.sR = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.ti = cursor.getString(3);
        iVar.tj = cursor.getInt(4);
        iVar.tk = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.te);
            contentValues.put("tableName", iVar.sR);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.tj));
            contentValues.put("cacheType", iVar.ti);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.tk));
            SQLiteDatabase dL = this.sQ.dL();
            if (dL != null && dL.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.te}) == 0) {
                dL.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.sQ.d(th, "addOrUpdate");
        }
    }

    public int ad(String str) {
        try {
            if (ac(str) == null) {
                return 0;
            }
            return this.sQ.dL().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.sQ.d(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
