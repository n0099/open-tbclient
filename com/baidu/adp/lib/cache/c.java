package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b rj;
    protected String rk;
    protected e.b rl;
    protected e.a rm;
    protected int ro;
    protected LinkedList<String> rp = new LinkedList<>();
    private Object rq = new Object();

    public abstract String O(String str);

    protected abstract boolean P(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int eb();

    public c(com.baidu.adp.base.a.b bVar) {
        this.rj = bVar;
    }

    public void a(e eVar, String str) {
        this.rk = str;
        if (eVar instanceof e.b) {
            this.rl = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.rm = (e.a) eVar;
        }
    }

    public g<T> Q(String str) {
        try {
            return c(this.rj.bQ(), str);
        } catch (Throwable th) {
            this.rj.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.rq) {
                this.rp.remove(gVar.rw);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase bQ = this.rj.bQ();
            if (bQ.update(this.rk, a, "m_key = ?", new String[]{gVar.rw}) == 0) {
                bQ.insert(this.rk, null, a);
                if (this.rm != null) {
                    ec();
                }
            }
            if (this.rl != null && (e = this.rl.e(gVar)) != null) {
                R(e);
            }
        } catch (Throwable th) {
            this.rj.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void ec() {
        if (this.rm != null) {
            this.ro++;
            if (this.ro >= ((int) Math.min(this.rm.getMaxSize() * 0.2d, 5.0d))) {
                this.ro = 0;
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ed();
                    }
                });
            }
        }
    }

    public int R(String str) {
        try {
            return this.rj.bQ().delete(this.rk, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.rj.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void S(String str) {
        this.ro = 0;
        synchronized (this.rq) {
            this.rp.clear();
        }
        if (P(str)) {
            BdCacheService.en().eo().ae(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.rq) {
            if (!this.rp.contains(str)) {
                this.rp.addLast(str);
                if (z) {
                    ec();
                }
            }
        }
    }

    public void T(String str) {
        if (this.rm != null) {
            Cursor cursor = null;
            try {
                this.rm.eh();
                cursor = d(this.rj.bQ(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.rw = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ry = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.rz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.rA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.rm.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ed();
            } catch (Throwable th) {
                try {
                    this.rj.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.rm.ei();
                }
            }
        }
    }

    public void U(String str) {
        if (this.rl != null) {
            Cursor cursor = null;
            try {
                this.rl.ej();
                cursor = d(this.rj.bQ(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.rw = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ry = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.rz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.rA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.rl.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ed();
            } catch (Throwable th) {
                try {
                    this.rj.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.rl.ek();
                }
            }
        }
    }

    protected void ed() {
        String removeFirst;
        if (!this.rp.isEmpty()) {
            SQLiteDatabase bQ = this.rj.bQ();
            bQ.beginTransaction();
            while (true) {
                try {
                    synchronized (this.rq) {
                        if (!this.rp.isEmpty()) {
                            removeFirst = this.rp.removeFirst();
                        } else {
                            bQ.setTransactionSuccessful();
                            this.ro = 0;
                            return;
                        }
                    }
                    bQ.delete(this.rk, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.rj.a(th, "performCleanup");
                        return;
                    } finally {
                        bQ.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ee() {
        return this.rj;
    }
}
