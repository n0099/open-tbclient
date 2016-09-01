package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b lQ;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.lQ = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i V(String str) {
        Cursor cursor;
        try {
            cursor = this.lQ.aZ().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.lQ.d(th, "get");
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
        iVar.md = cursor.getString(0);
        iVar.lR = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.mi = cursor.getString(3);
        iVar.mj = cursor.getInt(4);
        iVar.mk = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.md);
            contentValues.put("tableName", iVar.lR);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.mj));
            contentValues.put("cacheType", iVar.mi);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.mk));
            SQLiteDatabase aZ = this.lQ.aZ();
            if (aZ != null && aZ.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.md}) == 0) {
                aZ.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.lQ.d(th, "addOrUpdate");
        }
    }

    public int W(String str) {
        try {
            if (V(str) == null) {
                return 0;
            }
            return this.lQ.aZ().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.lQ.d(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
