package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase lP = null;
    private a.InterfaceC0003a lS;
    private int lU;
    private final String lV;

    public abstract void g(SQLiteDatabase sQLiteDatabase);

    public abstract void h(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.lS = interfaceC0003a;
    }

    public d(String str, int i) {
        this.lU = 1;
        this.lU = i;
        this.lV = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.lV);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.lP = SQLiteDatabase.openOrCreateDatabase(this.lV, (SQLiteDatabase.CursorFactory) null);
            if (this.lP != null) {
                if (!exists) {
                    j(this.lP);
                    this.lP.setVersion(this.lU);
                } else {
                    int version = this.lP.getVersion();
                    if (version != this.lU) {
                        a(this.lP, version, this.lU);
                        this.lP.setVersion(this.lU);
                    }
                }
            }
        }
        return this.lP;
    }

    private void j(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        i(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            onDowngrade(sQLiteDatabase, i, i2);
        }
        i(sQLiteDatabase);
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        if (this.lS != null) {
            this.lS.f(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean ac(Context context) {
        File file = new File(this.lV);
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
        g(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        h(sQLiteDatabase);
        g(sQLiteDatabase);
    }
}
