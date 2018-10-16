package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class p {
    private final com.baidu.adp.base.a.b As;

    public p(Context context, com.baidu.adp.base.a.b bVar) {
        this.As = bVar;
    }

    public h aH(String str) {
        Cursor cursor;
        try {
            cursor = this.As.ge().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.As.a(th, "get");
                com.baidu.adp.lib.g.a.e(cursor);
                return null;
            } finally {
                com.baidu.adp.lib.g.a.e(cursor);
            }
        }
        if (cursor.moveToNext()) {
            h hVar = new h();
            hVar.AF = cursor.getString(0);
            hVar.At = cursor.getString(1);
            hVar.maxSize = cursor.getInt(2);
            hVar.AJ = cursor.getString(3);
            hVar.AK = cursor.getInt(4);
            hVar.AM = cursor.getLong(5);
            return hVar;
        }
        return null;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.AF);
            contentValues.put("tableName", hVar.At);
            contentValues.put("maxSize", Integer.valueOf(hVar.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.AK));
            contentValues.put("cacheType", hVar.AJ);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.AM));
            SQLiteDatabase ge = this.As.ge();
            if (ge != null && ge.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.AF}) == 0) {
                ge.insert("cache_meta_info", null, contentValues);
            }
        } catch (Throwable th) {
            this.As.a(th, "addOrUpdate");
        }
    }

    public int aI(String str) {
        try {
            if (aH(str) == null) {
                return 0;
            }
            return this.As.ge().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.As.a(th, WriteImageActivityConfig.DELET_FLAG);
            return 0;
        }
    }
}
