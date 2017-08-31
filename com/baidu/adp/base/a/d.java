package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase mU = null;
    private a.InterfaceC0001a mZ;
    private int nb;
    private final String nc;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void e(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0001a interfaceC0001a) {
        this.mZ = interfaceC0001a;
    }

    public d(String str, int i) {
        this.nb = 1;
        this.nb = i;
        this.nc = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.nc);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.mU = SQLiteDatabase.openOrCreateDatabase(this.nc, (SQLiteDatabase.CursorFactory) null);
            if (this.mU != null) {
                if (!exists) {
                    g(this.mU);
                    this.mU.setVersion(this.nb);
                } else {
                    int version = this.mU.getVersion();
                    if (version != this.nb) {
                        a(this.mU, version, this.nb);
                        this.mU.setVersion(this.nb);
                    }
                }
            }
        }
        return this.mU;
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        f(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            onDowngrade(sQLiteDatabase, i, i2);
        }
        f(sQLiteDatabase);
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        if (this.mZ != null) {
            this.mZ.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean Y(Context context) {
        File file = new File(this.nc);
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
            BdLog.e(str + ":" + th);
            return false;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e(sQLiteDatabase);
        d(sQLiteDatabase);
    }
}
