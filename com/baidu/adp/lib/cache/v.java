package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class v {
    private final com.baidu.adp.base.a.b iX;

    public v(Context context, com.baidu.adp.base.a.b bVar) {
        this.iX = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i S(String str) {
        Cursor cursor;
        try {
            cursor = this.iX.ae().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.iX.d(th, "get");
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
        iVar.jk = cursor.getString(0);
        iVar.iY = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.jo = cursor.getString(3);
        iVar.jp = cursor.getInt(4);
        iVar.jq = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.jk);
            contentValues.put("tableName", iVar.iY);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.jp));
            contentValues.put("cacheType", iVar.jo);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.jq));
            SQLiteDatabase ae = this.iX.ae();
            if (ae != null && ae.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.jk}) == 0) {
                ae.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.iX.d(th, "addOrUpdate");
        }
    }

    public int T(String str) {
        try {
            if (S(str) == null) {
                return 0;
            }
            return this.iX.ae().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.iX.d(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
