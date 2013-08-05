package com.baidu.android.systemmonitor.c;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public abstract class a {
    protected abstract boolean a(SQLiteDatabase sQLiteDatabase);

    public void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            if (a(sQLiteDatabase)) {
                sQLiteDatabase.setTransactionSuccessful();
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
