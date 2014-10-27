package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d extends SQLiteOpenHelper implements a {
    private b aD;
    private final String aE;

    public abstract void b(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.aD = bVar;
    }

    public d(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.aE = str;
    }

    @Override // com.baidu.adp.base.a.a
    public boolean f(Context context) {
        return context.deleteDatabase(this.aE);
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, String str) {
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
        b(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        if (this.aD != null) {
            this.aD.a(sQLiteDatabase);
        }
    }
}
