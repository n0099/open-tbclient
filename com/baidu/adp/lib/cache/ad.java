package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class ad {
    private final com.baidu.adp.base.a.c sH;

    public ad(Context context, com.baidu.adp.base.a.c cVar) {
        this.sH = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public n ad(String str) {
        Cursor cursor;
        try {
            cursor = this.sH.dI().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.sH.a(th, "get");
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
        nVar.sU = cursor.getString(0);
        nVar.sI = cursor.getString(1);
        nVar.maxSize = cursor.getInt(2);
        nVar.sY = cursor.getString(3);
        nVar.sZ = cursor.getInt(4);
        nVar.tb = cursor.getLong(5);
        return nVar;
    }

    public void a(n nVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", nVar.sU);
            contentValues.put("tableName", nVar.sI);
            contentValues.put("maxSize", Integer.valueOf(nVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(nVar.sZ));
            contentValues.put("cacheType", nVar.sY);
            contentValues.put("lastActiveTime", Long.valueOf(nVar.tb));
            SQLiteDatabase dI = this.sH.dI();
            if (dI != null && dI.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{nVar.sU}) == 0) {
                dI.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.sH.a(th, "addOrUpdate");
        }
    }

    public int ae(String str) {
        try {
            if (ad(str) == null) {
                return 0;
            }
            return this.sH.dI().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.sH.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
