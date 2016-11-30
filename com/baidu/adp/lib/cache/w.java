package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b lR;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.lR = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i V(String str) {
        Cursor cursor;
        try {
            cursor = this.lR.aZ().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.lR.a(th, "get");
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
        iVar.mf = cursor.getString(0);
        iVar.lS = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.mj = cursor.getString(3);
        iVar.mk = cursor.getInt(4);
        iVar.ml = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.mf);
            contentValues.put("tableName", iVar.lS);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.mk));
            contentValues.put("cacheType", iVar.mj);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.ml));
            SQLiteDatabase aZ = this.lR.aZ();
            if (aZ != null && aZ.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.mf}) == 0) {
                aZ.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.lR.a(th, "addOrUpdate");
        }
    }

    public int W(String str) {
        try {
            if (V(str) == null) {
                return 0;
            }
            return this.lR.aZ().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.lR.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
