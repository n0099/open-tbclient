package com.baidu.android.util.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
@Deprecated
/* loaded from: classes5.dex */
final class NoLocalModeContextWrapper extends ContextWrapper {
    public NoLocalModeContextWrapper(Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @SuppressLint({"InlinedApi"})
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return super.openOrCreateDatabase(str, i | 16, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @SuppressLint({"InlinedApi"})
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return super.openOrCreateDatabase(str, i | 16, cursorFactory, databaseErrorHandler);
    }
}
