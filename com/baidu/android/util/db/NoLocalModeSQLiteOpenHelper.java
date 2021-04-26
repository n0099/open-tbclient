package com.baidu.android.util.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
@Deprecated
/* loaded from: classes.dex */
public abstract class NoLocalModeSQLiteOpenHelper extends SQLiteOpenHelper {
    public NoLocalModeSQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(new NoLocalModeContextWrapper(context), str, cursorFactory, i2);
    }

    public NoLocalModeSQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        super(new NoLocalModeContextWrapper(context), str, cursorFactory, i2, databaseErrorHandler);
    }
}
