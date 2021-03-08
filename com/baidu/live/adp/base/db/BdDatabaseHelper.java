package com.baidu.live.adp.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes10.dex */
public interface BdDatabaseHelper {

    /* loaded from: classes10.dex */
    public interface OnDatabaseCreatedCallback {
        void onDatabaseCreated(SQLiteDatabase sQLiteDatabase);
    }

    boolean dropDatabase(Context context);

    SQLiteDatabase getWritableDatabase();

    void onCreate(SQLiteDatabase sQLiteDatabase);

    void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    void setOnCreateCallback(OnDatabaseCreatedCallback onDatabaseCreatedCallback);
}
