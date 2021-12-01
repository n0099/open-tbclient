package com.baidu.browser.core.database;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.browser.core.INoProGuard;
/* loaded from: classes8.dex */
public interface IDbVersionManager extends INoProGuard {
    int getVersionCode();

    void onCreate(int i2, SQLiteDatabase sQLiteDatabase, String str);

    void onDowngrade(int i2, int i3, SQLiteDatabase sQLiteDatabase, String str);

    void onOpen(int i2, SQLiteDatabase sQLiteDatabase, String str);

    void onUpgrade(int i2, int i3, SQLiteDatabase sQLiteDatabase, String str);
}
