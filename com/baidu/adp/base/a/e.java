package com.baidu.adp.base.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class e implements a {
    private int a;
    private final String b;
    private b c;
    private SQLiteDatabase d = null;

    public abstract void a(SQLiteDatabase sQLiteDatabase);

    public abstract void b(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.c = bVar;
    }

    public e(String str, int i) {
        this.a = 1;
        this.a = i;
        this.b = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.b);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.d = SQLiteDatabase.openOrCreateDatabase(this.b, (SQLiteDatabase.CursorFactory) null);
            if (this.d != null) {
                if (!exists) {
                    d(this.d);
                    this.d.setVersion(this.a);
                } else {
                    int version = this.d.getVersion();
                    if (version != this.a) {
                        b(this.d, version, this.a);
                        this.d.setVersion(this.a);
                    }
                }
            }
        }
        return this.d;
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    private void b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            a(sQLiteDatabase, i, i2);
        }
        e(sQLiteDatabase);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (this.c != null) {
            this.c.a(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean a(Context context) {
        File file = new File(this.b);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(String.valueOf(str) + ":" + th);
            return false;
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @SuppressLint({"Override"})
    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }
}
