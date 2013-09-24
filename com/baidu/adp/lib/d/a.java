package com.baidu.adp.lib.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.f.d;
/* loaded from: classes.dex */
public class a {
    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                d.b("adp_util_close", "error on close android.database.Cursor.", e.getMessage());
            }
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                d.b("adp_util_close", "error on close android.database.SQLiteDatabase.", e.getMessage());
            }
        }
    }
}
