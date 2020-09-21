package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: com.baidu.adp.base.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0016a {
        void onDatabaseCreated(SQLiteDatabase sQLiteDatabase);
    }

    void a(InterfaceC0016a interfaceC0016a);

    boolean dropDatabase(Context context);

    SQLiteDatabase getWritableDatabase();

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
}
