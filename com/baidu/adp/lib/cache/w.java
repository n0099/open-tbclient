package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.base.a.b tG;

    public w(Context context, com.baidu.adp.base.a.b bVar) {
        this.tG = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public i U(String str) {
        Cursor cursor;
        try {
            cursor = this.tG.ci().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.tG.a(th, "get");
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
        iVar.tT = cursor.getString(0);
        iVar.tH = cursor.getString(1);
        iVar.maxSize = cursor.getInt(2);
        iVar.tX = cursor.getString(3);
        iVar.tY = cursor.getInt(4);
        iVar.tZ = cursor.getLong(5);
        return iVar;
    }

    public void a(i iVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", iVar.tT);
            contentValues.put("tableName", iVar.tH);
            contentValues.put("maxSize", Integer.valueOf(iVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(iVar.tY));
            contentValues.put("cacheType", iVar.tX);
            contentValues.put("lastActiveTime", Long.valueOf(iVar.tZ));
            SQLiteDatabase ci = this.tG.ci();
            if (ci != null && ci.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{iVar.tT}) == 0) {
                ci.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.tG.a(th, "addOrUpdate");
        }
    }

    public int V(String str) {
        try {
            if (U(str) == null) {
                return 0;
            }
            return this.tG.ci().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.tG.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
