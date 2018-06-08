package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase sl = null;
    private a.InterfaceC0011a sq;
    private int ss;
    private final String su;

    public abstract void g(SQLiteDatabase sQLiteDatabase);

    public abstract void h(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.sq = interfaceC0011a;
    }

    public d(String str, int i) {
        this.ss = 1;
        this.ss = i;
        this.su = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.su);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.sl = SQLiteDatabase.openOrCreateDatabase(this.su, (SQLiteDatabase.CursorFactory) null);
            if (this.sl != null) {
                if (!exists) {
                    j(this.sl);
                    this.sl.setVersion(this.ss);
                } else {
                    int version = this.sl.getVersion();
                    if (version != this.ss) {
                        a(this.sl, version, this.ss);
                        this.sl.setVersion(this.ss);
                    }
                }
            }
        }
        return this.sl;
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
        if (this.sq != null) {
            this.sq.f(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean ae(Context context) {
        File file = new File(this.su);
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
            BdLog.e(str + SystemInfoUtil.COLON + th);
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
