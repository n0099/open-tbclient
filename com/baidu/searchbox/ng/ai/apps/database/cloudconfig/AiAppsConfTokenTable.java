package com.baidu.searchbox.ng.ai.apps.database.cloudconfig;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes2.dex */
public final class AiAppsConfTokenTable {
    public static final String TABLE_NAME = "ai_apps_cloud_config_tokens";

    /* loaded from: classes2.dex */
    public enum Table {
        app_id,
        action,
        token,
        ext
    }

    public static void createConfTokenTable(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(getCreateSql());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static String getCreateSql() {
        return "CREATE TABLE ai_apps_cloud_config_tokens (" + Table.app_id + " TEXT NOT NULL," + Table.action + " TEXT," + Table.token + " TEXT," + Table.ext + " TEXT, PRIMARY KEY (" + Table.app_id + ", " + Table.action + "));";
    }
}
