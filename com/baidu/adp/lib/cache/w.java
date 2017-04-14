package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b tc;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.tc = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i R(String str) {
        Cursor cursor;
        try {
            cursor = this.tc.ch().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.tc.a(th, "get");
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
        iVar.tr = cursor.getString(0);
        iVar.td = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.f0tv = cursor.getString(3);
        iVar.tw = cursor.getInt(4);
        iVar.tx = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.tr);
            contentValues.put("tableName", iVar.td);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.tw));
            contentValues.put("cacheType", iVar.f0tv);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.tx));
            SQLiteDatabase ch = this.tc.ch();
            if (ch != null && ch.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.tr}) == 0) {
                ch.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.tc.a(th, "addOrUpdate");
        }
    }

    public int S(String str) {
        try {
            if (R(str) == null) {
                return 0;
            }
            return this.tc.ch().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.tc.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
