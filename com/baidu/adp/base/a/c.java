package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class c extends SQLiteOpenHelper implements a {
    private a.InterfaceC0014a vx;
    private final String vy;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void e(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0014a interfaceC0014a) {
        this.vx = interfaceC0014a;
    }

    public c(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.vy = str;
    }

    @Override // com.baidu.adp.base.a.a
    public boolean aL(Context context) {
        return context.deleteDatabase(this.vy);
    }

    public boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(str + ":" + th.getMessage());
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        f(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e(sQLiteDatabase);
        d(sQLiteDatabase);
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        if (this.vx != null) {
            this.vx.c(sQLiteDatabase);
        }
    }
}
