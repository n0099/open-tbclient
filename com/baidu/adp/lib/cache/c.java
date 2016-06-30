package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b iX;
    protected String iY;
    protected f.b iZ;
    protected f.a ja;
    protected int jb;
    protected LinkedList<String> jc = new LinkedList<>();
    private Object jd = new Object();

    public abstract String D(String str);

    protected abstract boolean E(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int cv();

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public c(com.baidu.adp.base.a.b bVar) {
        this.iX = bVar;
    }

    public void a(f fVar, String str) {
        this.iY = str;
        if (fVar instanceof f.b) {
            this.iZ = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.ja = (f.a) fVar;
        }
    }

    public h<T> F(String str) {
        try {
            return c(this.iX.ae(), str);
        } catch (Throwable th) {
            this.iX.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.jd) {
                this.jc.remove(hVar.jj);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase ae = this.iX.ae();
            if (ae.update(this.iY, a, "m_key = ?", new String[]{hVar.jj}) == 0) {
                ae.insert(this.iY, null, a);
                if (this.ja != null) {
                    cw();
                }
            }
            if (this.iZ != null && (e = this.iZ.e(hVar)) != null) {
                G(e);
            }
        } catch (Throwable th) {
            this.iX.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void cw() {
        if (this.ja != null) {
            this.jb++;
            if (this.jb >= ((int) Math.min(this.ja.getMaxSize() * 0.2d, 5.0d))) {
                this.jb = 0;
                com.baidu.adp.lib.h.k.dN().c(new d(this));
            }
        }
    }

    public int G(String str) {
        try {
            return this.iX.ae().delete(this.iY, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.iX.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void H(String str) {
        this.jb = 0;
        synchronized (this.jd) {
            this.jc.clear();
        }
        if (E(str)) {
            BdCacheService.cH().cI().T(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.jd) {
            if (!this.jc.contains(str)) {
                this.jc.addLast(str);
                if (z) {
                    cw();
                }
            }
        }
    }

    public void I(String str) {
        if (this.ja != null) {
            Cursor cursor = null;
            try {
                this.ja.cB();
                cursor = d(this.iX.ae(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.jj = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.jl = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.jm = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.jn = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.ja.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                cx();
            } catch (Throwable th) {
                try {
                    this.iX.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.ja.cC();
                }
            }
        }
    }

    public void J(String str) {
        if (this.iZ != null) {
            Cursor cursor = null;
            try {
                this.iZ.cD();
                cursor = d(this.iX.ae(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.jj = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.jl = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.jm = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.jn = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.iZ.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                cx();
            } catch (Throwable th) {
                try {
                    this.iX.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.iZ.cE();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cx() {
        String removeFirst;
        if (!this.jc.isEmpty()) {
            SQLiteDatabase ae = this.iX.ae();
            ae.beginTransaction();
            while (true) {
                try {
                    synchronized (this.jd) {
                        if (!this.jc.isEmpty()) {
                            removeFirst = this.jc.removeFirst();
                        } else {
                            ae.setTransactionSuccessful();
                            this.jb = 0;
                            return;
                        }
                    }
                    ae.delete(this.iY, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.iX.d(th, "performCleanup");
                        return;
                    } finally {
                        ae.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b cy() {
        return this.iX;
    }
}
