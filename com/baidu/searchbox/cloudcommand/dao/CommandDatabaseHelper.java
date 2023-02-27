package com.baidu.searchbox.cloudcommand.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class CommandDatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "com.baidu.searchbox.cloudcommand";
    public static final int DB_VERSION = 1;
    public static SQLiteDatabase mDB;
    public static CommandDatabaseHelper mInstance;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public CommandDatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static synchronized SQLiteDatabase getDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (CommandDatabaseHelper.class) {
            if (mDB == null) {
                mDB = getInstance().getWritableDatabase();
            }
            sQLiteDatabase = mDB;
        }
        return sQLiteDatabase;
    }

    public static synchronized CommandDatabaseHelper getInstance() {
        CommandDatabaseHelper commandDatabaseHelper;
        synchronized (CommandDatabaseHelper.class) {
            if (mInstance == null) {
                mInstance = new CommandDatabaseHelper(AppRuntime.getAppContext(), DB_NAME, null, 1);
            }
            commandDatabaseHelper = mInstance;
        }
        return commandDatabaseHelper;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CloudCommandTable.CREATE_TABLE);
    }
}
