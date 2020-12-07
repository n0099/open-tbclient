package com.baidu.android.util.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
@Deprecated
/* loaded from: classes15.dex */
public abstract class NoLocalModeSQLiteOpenHelper extends SQLiteOpenHelper {
    public NoLocalModeSQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(new NoLocalModeContextWrapper(context), str, cursorFactory, i);
    }

    public NoLocalModeSQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        super(new NoLocalModeContextWrapper(context), str, cursorFactory, i, databaseErrorHandler);
    }
}
