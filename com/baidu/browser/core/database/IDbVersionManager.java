package com.baidu.browser.core.database;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.browser.core.INoProGuard;
/* loaded from: classes14.dex */
public interface IDbVersionManager extends INoProGuard {
    int getVersionCode();

    void onCreate(int i, SQLiteDatabase sQLiteDatabase, String str);

    void onDowngrade(int i, int i2, SQLiteDatabase sQLiteDatabase, String str);

    void onOpen(int i, SQLiteDatabase sQLiteDatabase, String str);

    void onUpgrade(int i, int i2, SQLiteDatabase sQLiteDatabase, String str);
}
