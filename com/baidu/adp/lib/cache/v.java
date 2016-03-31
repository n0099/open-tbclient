package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class v {
    private final com.baidu.adp.base.a.b tj;

    public v(Context context, com.baidu.adp.base.a.b bVar) {
        this.tj = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i ab(String str) {
        Cursor cursor;
        try {
            cursor = this.tj.dO().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.tj.d(th, "get");
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
        iVar.ty = cursor.getString(0);
        iVar.tk = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.tC = cursor.getString(3);
        iVar.tD = cursor.getInt(4);
        iVar.tE = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.ty);
            contentValues.put("tableName", iVar.tk);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.tD));
            contentValues.put("cacheType", iVar.tC);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.tE));
            SQLiteDatabase dO = this.tj.dO();
            if (dO != null && dO.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.ty}) == 0) {
                dO.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.tj.d(th, "addOrUpdate");
        }
    }

    public int ac(String str) {
        try {
            if (ab(str) == null) {
                return 0;
            }
            return this.tj.dO().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.tj.d(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
