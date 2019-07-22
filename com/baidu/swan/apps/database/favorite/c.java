package com.baidu.swan.apps.database.favorite;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes2.dex */
public final class c {
    public static void D(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(Cx());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static String Cx() {
        return "CREATE TABLE IF NOT EXISTS ai_apps_favorites (_id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL UNIQUE,favorite_time INTEGER DEFAULT 0);";
    }
}
