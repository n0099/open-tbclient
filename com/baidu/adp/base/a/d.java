package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase nB = null;
    private a.InterfaceC0003a nE;
    private int nG;
    private final String nH;

    public abstract void c(SQLiteDatabase sQLiteDatabase);

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.nE = interfaceC0003a;
    }

    public d(String str, int i) {
        this.nG = 1;
        this.nG = i;
        this.nH = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.nH);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.nB = SQLiteDatabase.openOrCreateDatabase(this.nH, (SQLiteDatabase.CursorFactory) null);
            if (this.nB != null) {
                if (!exists) {
                    f(this.nB);
                    this.nB.setVersion(this.nG);
                } else {
                    int version = this.nB.getVersion();
                    if (version != this.nG) {
                        a(this.nB, version, this.nG);
                        this.nB.setVersion(this.nG);
                    }
                }
            }
        }
        return this.nB;
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
        if (this.nE != null) {
            this.nE.b(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean t(Context context) {
        File file = new File(this.nH);
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
