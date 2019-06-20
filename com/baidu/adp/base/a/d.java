package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase sS = null;
    private a.InterfaceC0012a sV;
    private int sX;
    private final String sY;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void e(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0012a interfaceC0012a) {
        this.sV = interfaceC0012a;
    }

    public d(String str, int i) {
        this.sX = 1;
        this.sX = i;
        this.sY = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.sY);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.sS = SQLiteDatabase.openOrCreateDatabase(this.sY, (SQLiteDatabase.CursorFactory) null);
            if (this.sS != null) {
                if (!exists) {
                    g(this.sS);
                    this.sS.setVersion(this.sX);
                } else {
                    int version = this.sS.getVersion();
                    if (version != this.sX) {
                        a(this.sS, version, this.sX);
                        this.sS.setVersion(this.sX);
                    }
                }
            }
        }
        return this.sS;
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
        if (this.sV != null) {
            this.sV.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean ac(Context context) {
        File file = new File(this.sY);
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
