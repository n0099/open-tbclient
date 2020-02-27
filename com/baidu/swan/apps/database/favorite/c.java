package com.baidu.swan.apps.database.favorite;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes11.dex */
public final class c {
    public static void v(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(Rb());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static String Rb() {
        return "CREATE TABLE IF NOT EXISTS ai_apps_favorites (_id INTEGER PRIMARY KEY AUTOINCREMENT,sort_index INTEGER,app_id TEXT NOT NULL UNIQUE,app_icon TEXT,app_name TEXT,app_type INTEGER,frame_type INTEGER,favorite_time INTEGER DEFAULT 0);";
    }
}
