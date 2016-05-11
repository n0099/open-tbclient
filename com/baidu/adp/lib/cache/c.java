package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b iZ;
    protected String ja;
    protected f.b jb;
    protected f.a jc;
    protected int jd;
    protected LinkedList<String> je = new LinkedList<>();
    private Object jf = new Object();

    public abstract String D(String str);

    protected abstract boolean E(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int cu();

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public c(com.baidu.adp.base.a.b bVar) {
        this.iZ = bVar;
    }

    public void a(f fVar, String str) {
        this.ja = str;
        if (fVar instanceof f.b) {
            this.jb = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.jc = (f.a) fVar;
        }
    }

    public h<T> F(String str) {
        try {
            return c(this.iZ.ae(), str);
        } catch (Throwable th) {
            this.iZ.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.jf) {
                this.je.remove(hVar.jl);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase ae = this.iZ.ae();
            if (ae.update(this.ja, a, "m_key = ?", new String[]{hVar.jl}) == 0) {
                ae.insert(this.ja, null, a);
                if (this.jc != null) {
                    cv();
                }
            }
            if (this.jb != null && (e = this.jb.e(hVar)) != null) {
                G(e);
            }
        } catch (Throwable th) {
            this.iZ.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void cv() {
        if (this.jc != null) {
            this.jd++;
            if (this.jd >= ((int) Math.min(this.jc.getMaxSize() * 0.2d, 5.0d))) {
                this.jd = 0;
                com.baidu.adp.lib.h.k.dM().c(new d(this));
            }
        }
    }

    public int G(String str) {
        try {
            return this.iZ.ae().delete(this.ja, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.iZ.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void H(String str) {
        this.jd = 0;
        synchronized (this.jf) {
            this.je.clear();
        }
        if (E(str)) {
            BdCacheService.cG().cH().T(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.jf) {
            if (!this.je.contains(str)) {
                this.je.addLast(str);
                if (z) {
                    cv();
                }
            }
        }
    }

    public void I(String str) {
        if (this.jc != null) {
            Cursor cursor = null;
            try {
                this.jc.cA();
                cursor = d(this.iZ.ae(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.jl = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.jn = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.jo = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.jp = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.jc.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                cw();
            } catch (Throwable th) {
                try {
                    this.iZ.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.jc.cB();
                }
            }
        }
    }

    public void J(String str) {
        if (this.jb != null) {
            Cursor cursor = null;
            try {
                this.jb.cC();
                cursor = d(this.iZ.ae(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.jl = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.jn = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.jo = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.jp = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.jb.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                cw();
            } catch (Throwable th) {
                try {
                    this.iZ.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.jb.cD();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cw() {
        String removeFirst;
        if (!this.je.isEmpty()) {
            SQLiteDatabase ae = this.iZ.ae();
            ae.beginTransaction();
            while (true) {
                try {
                    synchronized (this.jf) {
                        if (!this.je.isEmpty()) {
                            removeFirst = this.je.removeFirst();
                        } else {
                            ae.setTransactionSuccessful();
                            this.jd = 0;
                            return;
                        }
                    }
                    ae.delete(this.ja, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.iZ.d(th, "performCleanup");
                        return;
                    } finally {
                        ae.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b cx() {
        return this.iZ;
    }
}
