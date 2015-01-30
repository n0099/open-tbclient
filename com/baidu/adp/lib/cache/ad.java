package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class ad {
    private final com.baidu.adp.base.a.c hm;

    public ad(Context context, com.baidu.adp.base.a.c cVar) {
        this.hm = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public n W(String str) {
        Cursor cursor;
        try {
            cursor = this.hm.ak().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.hm.a(th, "get");
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
        nVar.hz = cursor.getString(0);
        nVar.hn = cursor.getString(1);
        nVar.maxSize = cursor.getInt(2);
        nVar.hD = cursor.getString(3);
        nVar.hE = cursor.getInt(4);
        nVar.hF = cursor.getLong(5);
        return nVar;
    }

    public void a(n nVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", nVar.hz);
            contentValues.put("tableName", nVar.hn);
            contentValues.put("maxSize", Integer.valueOf(nVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(nVar.hE));
            contentValues.put("cacheType", nVar.hD);
            contentValues.put("lastActiveTime", Long.valueOf(nVar.hF));
            SQLiteDatabase ak = this.hm.ak();
            if (ak != null && ak.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{nVar.hz}) == 0) {
                ak.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.hm.a(th, "addOrUpdate");
        }
    }

    public int X(String str) {
        try {
            if (W(str) == null) {
                return 0;
            }
            return this.hm.ak().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.hm.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
