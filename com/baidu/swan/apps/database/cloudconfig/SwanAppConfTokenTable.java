package com.baidu.swan.apps.database.cloudconfig;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes3.dex */
public final class SwanAppConfTokenTable {

    /* loaded from: classes3.dex */
    public enum Table {
        app_id,
        action,
        token,
        ext
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(b());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static String b() {
        return "CREATE TABLE ai_apps_cloud_config_tokens (" + Table.app_id + " TEXT NOT NULL," + Table.action + " TEXT," + Table.token + " TEXT," + Table.ext + " TEXT, PRIMARY KEY (" + Table.app_id + StringUtil.ARRAY_ELEMENT_SEPARATOR + Table.action + "));";
    }
}
