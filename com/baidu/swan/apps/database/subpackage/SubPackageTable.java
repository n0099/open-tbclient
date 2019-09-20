package com.baidu.swan.apps.database.subpackage;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class SubPackageTable {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

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

    public static void G(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(CB());
            if (DEBUG) {
                Log.e("SubPackageTable", "创建分包信息表");
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.getStackTrace();
                Log.e("SubPackageTable", "创建分包信息表失败:" + e.getMessage());
            }
        }
    }

    public static String CB() {
        return "CREATE TABLE ai_app_sub_package_data (" + Table._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Table.app_id + " TEXT," + Table.version + " TEXT," + Table.package_name + " TEXT," + Table.is_exist + " INTEGER," + Table.aps_package_name + " TEXT,UNIQUE (" + Table.app_id + Constants.ACCEPT_TIME_SEPARATOR_SP + Table.package_name + "));";
    }
}
