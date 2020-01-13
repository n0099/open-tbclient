package com.baidu.swan.apps.database.a;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes10.dex */
public class c {
    public static void w(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(ON());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static String ON() {
        return "CREATE TABLE IF NOT EXISTS ai_apps_history (_id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL UNIQUE,app_from TEXT,visit_time INTEGER DEFAULT 0);";
    }

    public static void x(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
            sQLiteDatabase.execSQL("CREATE TRIGGER delete_old_swan_history AFTER INSERT ON ai_apps_history WHEN (select count(*) from ai_apps_history)>400 BEGIN  DELETE FROM ai_apps_history WHERE _id IN (SELECT _id FROM  ai_apps_history ORDER BY visit_time LIMIT (SELECT count(*) -400 FROM ai_apps_history)); END;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
