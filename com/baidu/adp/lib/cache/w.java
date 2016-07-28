package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b jz;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.jz = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i U(String str) {
        Cursor cursor;
        try {
            cursor = this.jz.ae().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.jz.d(th, "get");
                return null;
            } finally {
                com.baidu.adp.lib.h.a.a(cursor);
            }
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.h.a.a(cursor);
            return null;
        }
        i iVar = new i();
        iVar.jM = cursor.getString(0);
        iVar.jA = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.jQ = cursor.getString(3);
        iVar.jR = cursor.getInt(4);
        iVar.jS = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.jM);
            contentValues.put("tableName", iVar.jA);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.jR));
            contentValues.put("cacheType", iVar.jQ);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.jS));
            SQLiteDatabase ae = this.jz.ae();
            if (ae != null && ae.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.jM}) == 0) {
                ae.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.jz.d(th, "addOrUpdate");
        }
    }

    public int V(String str) {
        try {
            if (U(str) == null) {
                return 0;
            }
            return this.jz.ae().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.jz.d(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
