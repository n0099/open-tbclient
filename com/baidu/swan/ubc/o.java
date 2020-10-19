package com.baidu.swan.ubc;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
/* loaded from: classes9.dex */
public class o extends SQLiteOpenHelper {
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        super(context.getApplicationContext(), "OpenStat.db", (SQLiteDatabase.CursorFactory) null, 5);
        this.mContext = context.getApplicationContext();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        u.aZH().putString("ubc_version_md5", "0");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                    J(sQLiteDatabase);
                    break;
                case 2:
                    M(sQLiteDatabase);
                    break;
                case 3:
                    K(sQLiteDatabase);
                    break;
                case 4:
                    L(sQLiteDatabase);
                    break;
            }
            i++;
        }
    }

    private void J(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void K(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void L(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void M(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        try {
            sQLiteDatabase = super.getReadableDatabase();
        } catch (Exception e) {
            new File(this.mContext.getDatabasePath("OpenStat.db").getPath()).delete();
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        try {
            sQLiteDatabase = super.getWritableDatabase();
            sQLiteDatabase.enableWriteAheadLogging();
        } catch (Exception e) {
            new File(this.mContext.getDatabasePath("OpenStat.db").getPath()).delete();
        }
        return sQLiteDatabase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aYH() {
        return new File(this.mContext.getDatabasePath("OpenStat.db").getPath()).length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aYI() {
        return new File(this.mContext.getDatabasePath("OpenStat.db").getPath() + "-journal").length();
    }
}
