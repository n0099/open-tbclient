package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase vs = null;
    private a.InterfaceC0014a vv;
    private int vx;
    private final String vy;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void e(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0014a interfaceC0014a) {
        this.vv = interfaceC0014a;
    }

    public d(String str, int i) {
        this.vx = 1;
        this.vx = i;
        this.vy = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.vy);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.vs = SQLiteDatabase.openOrCreateDatabase(this.vy, (SQLiteDatabase.CursorFactory) null);
            if (this.vs != null) {
                if (!exists) {
                    g(this.vs);
                    this.vs.setVersion(this.vx);
                } else {
                    int version = this.vs.getVersion();
                    if (version != this.vx) {
                        a(this.vs, version, this.vx);
                        this.vs.setVersion(this.vx);
                    }
                }
            }
        }
        return this.vs;
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
        if (this.vv != null) {
            this.vv.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean aL(Context context) {
        File file = new File(this.vy);
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
