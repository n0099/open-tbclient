package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b ti;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.ti = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i R(String str) {
        Cursor cursor;
        try {
            cursor = this.ti.ch().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.ti.a(th, "get");
                return null;
            } finally {
                com.baidu.adp.lib.g.a.a(cursor);
            }
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.g.a.a(cursor);
            return null;
        }
        i iVar = new i();
        iVar.tx = cursor.getString(0);
        iVar.tj = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.tB = cursor.getString(3);
        iVar.tC = cursor.getInt(4);
        iVar.tD = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.tx);
            contentValues.put("tableName", iVar.tj);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.tC));
            contentValues.put("cacheType", iVar.tB);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.tD));
            SQLiteDatabase ch = this.ti.ch();
            if (ch != null && ch.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.tx}) == 0) {
                ch.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.ti.a(th, "addOrUpdate");
        }
    }

    public int S(String str) {
        try {
            if (R(str) == null) {
                return 0;
            }
            return this.ti.ch().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.ti.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
