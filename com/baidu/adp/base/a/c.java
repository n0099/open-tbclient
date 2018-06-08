package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
/* loaded from: classes.dex */
public abstract class c extends SQLiteOpenHelper implements a {
    private a.InterfaceC0011a sq;
    private final String sr;

    public abstract void g(SQLiteDatabase sQLiteDatabase);

    public abstract void h(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.sq = interfaceC0011a;
    }

    public c(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.sr = str;
    }

    @Override // com.baidu.adp.base.a.a
    public boolean ae(Context context) {
        return context.deleteDatabase(this.sr);
    }

    public boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(str + SystemInfoUtil.COLON + th.getMessage());
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        g(sQLiteDatabase);
        i(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        h(sQLiteDatabase);
        g(sQLiteDatabase);
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        if (this.sq != null) {
            this.sq.f(sQLiteDatabase);
        }
    }
}
