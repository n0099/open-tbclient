package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b uO;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.uO = bVar;
    }

    public h ae(String str) {
        Cursor cursor;
        try {
            cursor = this.uO.cs().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.uO.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.vb = cursor.getString(0);
            hVar.uP = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.vf = cursor.getString(3);
            hVar.vg = cursor.getInt(4);
            hVar.vh = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.vb);
            contentValues.put("tableName", hVar.uP);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.vg));
            contentValues.put("cacheType", hVar.vf);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.vh));
            SQLiteDatabase cs = this.uO.cs();
            if (cs != null && cs.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.vb}) == 0) {
                cs.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.uO.a(th, "addOrUpdate");
        }
    }

    public int af(String str) {
        try {
            if (ae(str) == null) {
                return 0;
            }
            return this.uO.cs().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.uO.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
