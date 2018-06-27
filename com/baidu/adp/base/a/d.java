package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private SQLiteDatabase sj = null;
    private a.InterfaceC0011a sm;
    private int sq;
    private final String sr;

    public abstract void g(SQLiteDatabase sQLiteDatabase);

    public abstract void h(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.sm = interfaceC0011a;
    }

    public d(String str, int i) {
        this.sq = 1;
        this.sq = i;
        this.sr = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.sr);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.sj = SQLiteDatabase.openOrCreateDatabase(this.sr, (SQLiteDatabase.CursorFactory) null);
            if (this.sj != null) {
                if (!exists) {
                    j(this.sj);
                    this.sj.setVersion(this.sq);
                } else {
                    int version = this.sj.getVersion();
                    if (version != this.sq) {
                        a(this.sj, version, this.sq);
                        this.sj.setVersion(this.sq);
                    }
                }
            }
        }
        return this.sj;
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
        if (this.sm != null) {
            this.sm.f(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean ae(Context context) {
        File file = new File(this.sr);
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
