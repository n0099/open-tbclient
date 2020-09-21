package com.baidu.swan.apps.database.cloudconfig;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes3.dex */
public final class SwanAppConfTokenTable {

    /* loaded from: classes3.dex */
    public enum Table {
        app_id,
        action,
        token,
        ext
    }

    public static void v(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(alA());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static String alA() {
        return "CREATE TABLE ai_apps_cloud_config_tokens (" + Table.app_id + " TEXT NOT NULL," + Table.action + " TEXT," + Table.token + " TEXT," + Table.ext + " TEXT, PRIMARY KEY (" + Table.app_id + ", " + Table.action + "));";
    }
}
