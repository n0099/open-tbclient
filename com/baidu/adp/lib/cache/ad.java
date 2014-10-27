package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class ad {
    private final com.baidu.adp.base.a.c fi;

    public ad(Context context, com.baidu.adp.base.a.c cVar) {
        this.fi = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public n I(String str) {
        Cursor cursor;
        try {
            cursor = this.fi.P().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.fi.a(th, "get");
                return null;
            } finally {
                com.baidu.adp.lib.g.a.a(cursor);
            }
        }
        if (!cursor.moveToNext()) {
            com.baidu.adp.lib.g.a.a(cursor);
            return null;
        }
        n nVar = new n();
        nVar.fv = cursor.getString(0);
        nVar.fj = cursor.getString(1);
        nVar.maxSize = cursor.getInt(2);
        nVar.fz = cursor.getString(3);
        nVar.fA = cursor.getInt(4);
        nVar.fB = cursor.getLong(5);
        return nVar;
    }

    public void a(n nVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", nVar.fv);
            contentValues.put("tableName", nVar.fj);
            contentValues.put("maxSize", Integer.valueOf(nVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(nVar.fA));
            contentValues.put("cacheType", nVar.fz);
            contentValues.put("lastActiveTime", Long.valueOf(nVar.fB));
            SQLiteDatabase P = this.fi.P();
            if (P != null && P.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{nVar.fv}) == 0) {
                P.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.fi.a(th, "addOrUpdate");
        }
    }

    public int J(String str) {
        try {
            if (I(str) == null) {
                return 0;
            }
            return this.fi.P().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.fi.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
