package com.baidu.android.systemmonitor.a;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public abstract class d {
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
