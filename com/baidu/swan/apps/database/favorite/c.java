package com.baidu.swan.apps.database.favorite;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes10.dex */
public final class c {
    public static void x(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(aqg());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static String aqg() {
        return "CREATE TABLE IF NOT EXISTS ai_apps_favorites (_id INTEGER PRIMARY KEY AUTOINCREMENT,sort_index INTEGER,app_id TEXT NOT NULL UNIQUE,app_icon TEXT,app_name TEXT,app_type INTEGER,frame_type INTEGER,favorite_time INTEGER DEFAULT 0);";
    }
}
