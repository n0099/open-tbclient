package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class v {
    private final com.baidu.adp.base.a.b sO;

    public v(Context context, com.baidu.adp.base.a.b bVar) {
        this.sO = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i ac(String str) {
        Cursor cursor;
        try {
            cursor = this.sO.dL().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.sO.d(th, "get");
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
        iVar.tc = cursor.getString(0);
        iVar.sP = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.tg = cursor.getString(3);
        iVar.th = cursor.getInt(4);
        iVar.ti = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.tc);
            contentValues.put("tableName", iVar.sP);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.th));
            contentValues.put("cacheType", iVar.tg);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.ti));
            SQLiteDatabase dL = this.sO.dL();
            if (dL != null && dL.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.tc}) == 0) {
                dL.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.sO.d(th, "addOrUpdate");
        }
    }

    public int ad(String str) {
        try {
            if (ac(str) == null) {
                return 0;
            }
            return this.sO.dL().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.sO.d(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
