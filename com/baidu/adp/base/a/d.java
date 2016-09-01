package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase gm = null;
    private a.InterfaceC0003a gp;
    private final String gr;
    private int mVersion;

    public abstract void c(SQLiteDatabase sQLiteDatabase);

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.gp = interfaceC0003a;
    }

    public d(String str, int i) {
        this.mVersion = 1;
        this.mVersion = i;
        this.gr = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.gr);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.gm = SQLiteDatabase.openOrCreateDatabase(this.gr, (SQLiteDatabase.CursorFactory) null);
            if (this.gm != null) {
                if (!exists) {
                    f(this.gm);
                    this.gm.setVersion(this.mVersion);
                } else {
                    int version = this.gm.getVersion();
                    if (version != this.mVersion) {
                        a(this.gm, version, this.mVersion);
                        this.gm.setVersion(this.mVersion);
                    }
                }
            }
        }
        return this.gm;
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
        if (this.gp != null) {
            this.gp.b(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean D(Context context) {
        File file = new File(this.gr);
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
