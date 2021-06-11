package com.baidu.searchbox.pms.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes2.dex */
public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "pms.db";
    public static final int DB_VERSION = 3;

    public DbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    private void alterAddDependencies(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE ");
        sb.append("package_info");
        sb.append(" ADD COLUMN ");
        sb.append(PackageTable.UPDATE_SIGN);
        sb.append(" TEXT;");
        try {
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb.append("ALTER TABLE ");
        sb.append("package_info");
        sb.append(" ADD COLUMN ");
        sb.append(PackageTable.IS_MAIN_ENTRANCE);
        sb.append(" INTEGER DEFAULT 1;");
        try {
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb.append("ALTER TABLE ");
        sb.append("package_info");
        sb.append(" ADD COLUMN ");
        sb.append(PackageTable.DEPENDENCY_PACKAGE);
        sb.append(" TEXT");
        sb.append(";");
        try {
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private String getCreateDBSql() {
        return "CREATE TABLE package_info(_id INTEGER PRIMARY KEY,channel_id TEXT NOT NULL,package_name TEXT NOT NULL,name TEXT NOT NULL,version LONG,update_version LONG," + PackageTable.MIN_HOST_VERSION + " TEXT," + PackageTable.MAX_HOST_VERSION + " TEXT,download_url TEXT,type INTEGER DEFAULT 0," + PackageTable.MD5 + " TEXT,size TEXT," + PackageTable.DOWNLOAD_OPTION + " INTEGER DEFAULT 0,wifi INTEGER DEFAULT 0," + PackageTable.IS_SILENCE + " INTEGER DEFAULT 0," + PackageTable.DISABLE + " INTEGER DEFAULT 0,sign TEXT," + PackageTable.EXTRA_FROM_SERVER + " TEXT," + PackageTable.EXTRA_FROM_LOCAL + " TEXT," + PackageTable.FILE_PATH + " TEXT," + PackageTable.TOTAL_SIZE + " LONG," + PackageTable.CURRENT_SIZE + " LONG,create_time LONG,update_time LONG," + PackageTable.UPDATE_SIGN + " TEXT," + PackageTable.IS_MAIN_ENTRANCE + " INTEGER DEFAULT 1," + PackageTable.DEPENDENCY_PACKAGE + " TEXT );";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(getCreateDBSql());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 1) {
            alterAddDependencies(sQLiteDatabase);
        } else if (i2 != 2) {
        } else {
            alterAddDependencies(sQLiteDatabase);
        }
    }
}
