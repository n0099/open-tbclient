package com.baidu.searchbox.ng.ai.apps.database.subpackage;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes2.dex */
public class SubPackageTable {
    private static final boolean DEBUG = false;
    public static final int PACKAGE_EXIST = 1;
    public static final int PACKAGE_NOT_EXIST = 0;
    private static final String TAG = "SubPackageTable";

    /* loaded from: classes2.dex */
    public enum Table {
        _id,
        app_id,
        version,
        package_name,
        is_exist,
        aps_package_name;
        
        public static final String TABLE_NAME = "ai_app_sub_package_data";
    }

    public static void createSubPackageTable(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(getCreateSql());
        } catch (Exception e) {
        }
    }

    public static String getCreateSql() {
        return "CREATE TABLE ai_app_sub_package_data (" + Table._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Table.app_id + " TEXT," + Table.version + " TEXT," + Table.package_name + " TEXT," + Table.is_exist + " INTEGER," + Table.aps_package_name + " TEXT,UNIQUE (" + Table.app_id + "," + Table.package_name + "));";
    }
}
