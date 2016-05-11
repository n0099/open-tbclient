package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private a.InterfaceC0003a dA;
    private int dC;
    private final String dD;
    private SQLiteDatabase dx = null;

    public abstract void c(SQLiteDatabase sQLiteDatabase);

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.dA = interfaceC0003a;
    }

    public d(String str, int i) {
        this.dC = 1;
        this.dC = i;
        this.dD = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.dD);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.dx = SQLiteDatabase.openOrCreateDatabase(this.dD, (SQLiteDatabase.CursorFactory) null);
            if (this.dx != null) {
                if (!exists) {
                    f(this.dx);
                    this.dx.setVersion(this.dC);
                } else {
                    int version = this.dx.getVersion();
                    if (version != this.dC) {
                        a(this.dx, version, this.dC);
                        this.dx.setVersion(this.dC);
                    }
                }
            }
        }
        return this.dx;
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            onDowngrade(sQLiteDatabase, i, i2);
        }
        e(sQLiteDatabase);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (this.dA != null) {
            this.dA.b(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean t(Context context) {
        File file = new File(this.dD);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(String.valueOf(str) + ":" + th);
            return false;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }
}
