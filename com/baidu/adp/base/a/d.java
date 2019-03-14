package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase vq = null;
    private a.InterfaceC0012a vt;
    private int vv;
    private final String vw;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void e(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0012a interfaceC0012a) {
        this.vt = interfaceC0012a;
    }

    public d(String str, int i) {
        this.vv = 1;
        this.vv = i;
        this.vw = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.vw);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.vq = SQLiteDatabase.openOrCreateDatabase(this.vw, (SQLiteDatabase.CursorFactory) null);
            if (this.vq != null) {
                if (!exists) {
                    g(this.vq);
                    this.vq.setVersion(this.vv);
                } else {
                    int version = this.vq.getVersion();
                    if (version != this.vv) {
                        a(this.vq, version, this.vv);
                        this.vq.setVersion(this.vv);
                    }
                }
            }
        }
        return this.vq;
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
        if (this.vt != null) {
            this.vt.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean aL(Context context) {
        File file = new File(this.vw);
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
            BdLog.e(str + Config.TRACE_TODAY_VISIT_SPLIT + th);
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
