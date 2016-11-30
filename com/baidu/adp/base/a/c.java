package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class c extends SQLiteOpenHelper implements a {
    private a.InterfaceC0003a gq;
    private final String gr;

    public abstract void c(SQLiteDatabase sQLiteDatabase);

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.gq = interfaceC0003a;
    }

    public c(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.gr = str;
    }

    @Override // com.baidu.adp.base.a.a
    public boolean D(Context context) {
        return context.deleteDatabase(this.gr);
    }

    public boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(String.valueOf(str) + ":" + th.getMessage());
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (this.gq != null) {
            this.gq.b(sQLiteDatabase);
        }
    }
}
