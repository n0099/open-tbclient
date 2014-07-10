package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class ac {
    private final com.baidu.adp.base.i a;

    public ac(Context context, com.baidu.adp.base.i iVar) {
        this.a = iVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [52=4] */
    public n a(String str) {
        Cursor cursor;
        try {
            cursor = this.a.a().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.a.a(th);
                BdLog.e(th.getMessage());
                return null;
            } finally {
                com.baidu.adp.lib.f.a.a(cursor);
            }
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.f.a.a(cursor);
            return null;
        }
        n nVar = new n();
        nVar.a = cursor.getString(0);
        nVar.b = cursor.getString(1);
        nVar.c = cursor.getInt(2);
        nVar.d = cursor.getString(3);
        nVar.e = cursor.getInt(4);
        nVar.f = cursor.getLong(5);
        return nVar;
    }

    public void a(n nVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", nVar.a);
            contentValues.put("tableName", nVar.b);
            contentValues.put("maxSize", Integer.valueOf(nVar.c));
            contentValues.put("cacheVersion", Integer.valueOf(nVar.e));
            contentValues.put("cacheType", nVar.d);
            contentValues.put("lastActiveTime", Long.valueOf(nVar.f));
            if (this.a.a().update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{nVar.a}) == 0) {
                this.a.a().insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.a.a(th);
            BdLog.e(th);
        }
    }

    public int b(String str) {
        try {
            if (a(str) == null) {
                return 0;
            }
            return this.a.a().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            BdLog.e(th);
            this.a.a(th);
            return 0;
        }
    }
}
