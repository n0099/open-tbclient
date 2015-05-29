package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class ad {
    private final com.baidu.adp.base.a.c sS;

    public ad(Context context, com.baidu.adp.base.a.c cVar) {
        this.sS = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public n af(String str) {
        Cursor cursor;
        try {
            cursor = this.sS.dK().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.sS.a(th, "get");
                return null;
            } finally {
                com.baidu.adp.lib.g.a.b(cursor);
            }
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.g.a.b(cursor);
            return null;
        }
        n nVar = new n();
        nVar.tg = cursor.getString(0);
        nVar.sT = cursor.getString(1);
        nVar.maxSize = cursor.getInt(2);
        nVar.tk = cursor.getString(3);
        nVar.tl = cursor.getInt(4);
        nVar.tm = cursor.getLong(5);
        return nVar;
    }

    public void a(n nVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", nVar.tg);
            contentValues.put("tableName", nVar.sT);
            contentValues.put("maxSize", Integer.valueOf(nVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(nVar.tl));
            contentValues.put("cacheType", nVar.tk);
            contentValues.put("lastActiveTime", Long.valueOf(nVar.tm));
            SQLiteDatabase dK = this.sS.dK();
            if (dK != null && dK.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{nVar.tg}) == 0) {
                dK.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.sS.a(th, "addOrUpdate");
        }
    }

    public int ag(String str) {
        try {
            if (af(str) == null) {
                return 0;
            }
            return this.sS.dK().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.sS.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
