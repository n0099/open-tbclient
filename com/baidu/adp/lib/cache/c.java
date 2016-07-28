package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected String jA;
    protected f.b jB;
    protected f.a jC;
    protected int jD;
    protected LinkedList<String> jE = new LinkedList<>();
    private Object jF = new Object();
    protected final com.baidu.adp.base.a.b jz;

    public abstract String F(String str);

    protected abstract boolean G(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract int cu();

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public c(com.baidu.adp.base.a.b bVar) {
        this.jz = bVar;
    }

    public void a(f fVar, String str) {
        this.jA = str;
        if (fVar instanceof f.b) {
            this.jB = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.jC = (f.a) fVar;
        }
    }

    public h<T> H(String str) {
        try {
            return c(this.jz.ae(), str);
        } catch (Throwable th) {
            this.jz.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.jF) {
                this.jE.remove(hVar.jL);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase ae = this.jz.ae();
            if (ae.update(this.jA, a, "m_key = ?", new String[]{hVar.jL}) == 0) {
                ae.insert(this.jA, null, a);
                if (this.jC != null) {
                    cv();
                }
            }
            if (this.jB != null && (e = this.jB.e(hVar)) != null) {
                I(e);
            }
        } catch (Throwable th) {
            this.jz.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void cv() {
        if (this.jC != null) {
            this.jD++;
            if (this.jD >= ((int) Math.min(this.jC.getMaxSize() * 0.2d, 5.0d))) {
                this.jD = 0;
                com.baidu.adp.lib.h.k.dM().f(new d(this));
            }
        }
    }

    public int I(String str) {
        try {
            return this.jz.ae().delete(this.jA, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.jz.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void J(String str) {
        this.jD = 0;
        synchronized (this.jF) {
            this.jE.clear();
        }
        if (G(str)) {
            BdCacheService.cG().cH().V(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.jF) {
            if (!this.jE.contains(str)) {
                this.jE.addLast(str);
                if (z) {
                    cv();
                }
            }
        }
    }

    public void K(String str) {
        if (this.jC != null) {
            Cursor cursor = null;
            try {
                this.jC.cA();
                cursor = d(this.jz.ae(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.jL = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.jN = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.jO = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.jP = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.jC.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                cw();
            } catch (Throwable th) {
                try {
                    this.jz.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.jC.cB();
                }
            }
        }
    }

    public void L(String str) {
        if (this.jB != null) {
            Cursor cursor = null;
            try {
                this.jB.cC();
                cursor = d(this.jz.ae(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.jL = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.jN = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.jO = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.jP = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.jB.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                cw();
            } catch (Throwable th) {
                try {
                    this.jz.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.jB.cD();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cw() {
        String removeFirst;
        if (!this.jE.isEmpty()) {
            SQLiteDatabase ae = this.jz.ae();
            ae.beginTransaction();
            while (true) {
                try {
                    synchronized (this.jF) {
                        if (!this.jE.isEmpty()) {
                            removeFirst = this.jE.removeFirst();
                        } else {
                            ae.setTransactionSuccessful();
                            this.jD = 0;
                            return;
                        }
                    }
                    ae.delete(this.jA, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.jz.d(th, "performCleanup");
                        return;
                    } finally {
                        ae.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b cx() {
        return this.jz;
    }
}
