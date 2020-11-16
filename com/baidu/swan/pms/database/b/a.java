package com.baidu.swan.pms.database.b;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes6.dex */
public interface a<T> {
    void onCreate(SQLiteDatabase sQLiteDatabase);

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
}
