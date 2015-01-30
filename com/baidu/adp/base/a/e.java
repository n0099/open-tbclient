package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class e implements a {
    private SQLiteDatabase cm = null;
    private b cp;
    private int cr;
    private final String cs;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void f(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.cp = bVar;
    }

    public e(String str, int i) {
        this.cr = 1;
        this.cr = i;
        this.cs = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.cs);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.cm = SQLiteDatabase.openOrCreateDatabase(this.cs, (SQLiteDatabase.CursorFactory) null);
            if (this.cm != null) {
                if (!exists) {
                    g(this.cm);
                    this.cm.setVersion(this.cr);
                } else {
                    int version = this.cm.getVersion();
                    if (version != this.cr) {
                        b(this.cm, version, this.cr);
                        this.cm.setVersion(this.cr);
                    }
                }
            }
        }
        return this.cm;
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    private void b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            onDowngrade(sQLiteDatabase, i, i2);
        }
        e(sQLiteDatabase);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (this.cp != null) {
            this.cp.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean E(Context context) {
        File file = new File(this.cs);
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
        d(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f(sQLiteDatabase);
        d(sQLiteDatabase);
    }
}
