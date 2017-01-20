package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b lL;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.lL = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i V(String str) {
        Cursor cursor;
        try {
            cursor = this.lL.aZ().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.lL.a(th, "get");
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
        iVar.lY = cursor.getString(0);
        iVar.lM = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.mc = cursor.getString(3);
        iVar.md = cursor.getInt(4);
        iVar.mf = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.lY);
            contentValues.put("tableName", iVar.lM);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.md));
            contentValues.put("cacheType", iVar.mc);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.mf));
            SQLiteDatabase aZ = this.lL.aZ();
            if (aZ != null && aZ.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.lY}) == 0) {
                aZ.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.lL.a(th, "addOrUpdate");
        }
    }

    public int W(String str) {
        try {
            if (V(str) == null) {
                return 0;
            }
            return this.lL.aZ().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.lL.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
