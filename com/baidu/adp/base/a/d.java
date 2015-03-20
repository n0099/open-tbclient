package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d extends SQLiteOpenHelper implements a {
    private final String nA;
    private b nz;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.nz = bVar;
    }

    public d(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.nA = str;
    }

    @Override // com.baidu.adp.base.a.a
    public boolean E(Context context) {
        return context.deleteDatabase(this.nA);
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
        d(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (this.nz != null) {
            this.nz.c(sQLiteDatabase);
        }
    }
}
