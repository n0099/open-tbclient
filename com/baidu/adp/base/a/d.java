package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    private int mVersion;
    private SQLiteDatabase oc = null;
    private a.InterfaceC0002a of;
    private final String oh;

    public abstract void c(SQLiteDatabase sQLiteDatabase);

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0002a interfaceC0002a) {
        this.of = interfaceC0002a;
    }

    public d(String str, int i) {
        this.mVersion = 1;
        this.mVersion = i;
        this.oh = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.oh);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.oc = SQLiteDatabase.openOrCreateDatabase(this.oh, (SQLiteDatabase.CursorFactory) null);
            if (this.oc != null) {
                if (!exists) {
                    f(this.oc);
                    this.oc.setVersion(this.mVersion);
                } else {
                    int version = this.oc.getVersion();
                    if (version != this.mVersion) {
                        a(this.oc, version, this.mVersion);
                        this.oc.setVersion(this.mVersion);
                    }
                }
            }
        }
        return this.oc;
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
        if (this.of != null) {
            this.of.b(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean ab(Context context) {
        File file = new File(this.oh);
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
