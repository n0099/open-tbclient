package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b th;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.th = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i R(String str) {
        Cursor cursor;
        try {
            cursor = this.th.ch().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.th.a(th, "get");
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
        iVar.tw = cursor.getString(0);
        iVar.ti = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.tA = cursor.getString(3);
        iVar.tB = cursor.getInt(4);
        iVar.tC = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.tw);
            contentValues.put("tableName", iVar.ti);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.tB));
            contentValues.put("cacheType", iVar.tA);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.tC));
            SQLiteDatabase ch = this.th.ch();
            if (ch != null && ch.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.tw}) == 0) {
                ch.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.th.a(th, "addOrUpdate");
        }
    }

    public int S(String str) {
        try {
            if (R(str) == null) {
                return 0;
            }
            return this.th.ch().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.th.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
