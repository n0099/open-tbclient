package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private a.InterfaceC0002a nC;
    private int nE;
    private final String nF;
    private SQLiteDatabase nz = null;

    public abstract void c(SQLiteDatabase sQLiteDatabase);

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0002a interfaceC0002a) {
        this.nC = interfaceC0002a;
    }

    public d(String str, int i) {
        this.nE = 1;
        this.nE = i;
        this.nF = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.nF);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.nz = SQLiteDatabase.openOrCreateDatabase(this.nF, (SQLiteDatabase.CursorFactory) null);
            if (this.nz != null) {
                if (!exists) {
                    f(this.nz);
                    this.nz.setVersion(this.nE);
                } else {
                    int version = this.nz.getVersion();
                    if (version != this.nE) {
                        a(this.nz, version, this.nE);
                        this.nz.setVersion(this.nE);
                    }
                }
            }
        }
        return this.nz;
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
        if (this.nC != null) {
            this.nC.b(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean D(Context context) {
        File file = new File(this.nF);
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
