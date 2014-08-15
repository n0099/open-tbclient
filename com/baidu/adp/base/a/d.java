package com.baidu.adp.base.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d extends SQLiteOpenHelper implements a {
    private b a;
    private final String b;

    public abstract void a(SQLiteDatabase sQLiteDatabase);

    public abstract void b(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.a = bVar;
    }

    public d(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.b = str;
    }

    @Override // com.baidu.adp.base.a.a
    public boolean a(Context context) {
        return context.deleteDatabase(this.b);
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
        a(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @SuppressLint({"Override"})
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        if (this.a != null) {
            this.a.a(sQLiteDatabase);
        }
    }
}
