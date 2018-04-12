package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b rk;
    protected String rl;
    protected e.b rm;
    protected e.a ro;
    protected int rp;
    protected LinkedList<String> rq = new LinkedList<>();
    private Object rr = new Object();

    public abstract String O(String str);

    protected abstract boolean P(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int eb();

    public c(com.baidu.adp.base.a.b bVar) {
        this.rk = bVar;
    }

    public void a(e eVar, String str) {
        this.rl = str;
        if (eVar instanceof e.b) {
            this.rm = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.ro = (e.a) eVar;
        }
    }

    public g<T> Q(String str) {
        try {
            return c(this.rk.bQ(), str);
        } catch (Throwable th) {
            this.rk.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.rr) {
                this.rq.remove(gVar.rx);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase bQ = this.rk.bQ();
            if (bQ.update(this.rl, a, "m_key = ?", new String[]{gVar.rx}) == 0) {
                bQ.insert(this.rl, null, a);
                if (this.ro != null) {
                    ec();
                }
            }
            if (this.rm != null && (e = this.rm.e(gVar)) != null) {
                R(e);
            }
        } catch (Throwable th) {
            this.rk.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void ec() {
        if (this.ro != null) {
            this.rp++;
            if (this.rp >= ((int) Math.min(this.ro.getMaxSize() * 0.2d, 5.0d))) {
                this.rp = 0;
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
            return this.rk.bQ().delete(this.rl, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.rk.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void S(String str) {
        this.rp = 0;
        synchronized (this.rr) {
            this.rq.clear();
        }
        if (P(str)) {
            BdCacheService.en().eo().ae(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.rr) {
            if (!this.rq.contains(str)) {
                this.rq.addLast(str);
                if (z) {
                    ec();
                }
            }
        }
    }

    public void T(String str) {
        if (this.ro != null) {
            Cursor cursor = null;
            try {
                this.ro.eh();
                cursor = d(this.rk.bQ(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.rx = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.rz = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.rA = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.rB = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.ro.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ed();
            } catch (Throwable th) {
                try {
                    this.rk.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.ro.ei();
                }
            }
        }
    }

    public void U(String str) {
        if (this.rm != null) {
            Cursor cursor = null;
            try {
                this.rm.ej();
                cursor = d(this.rk.bQ(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.rx = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.rz = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.rA = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.rB = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.rm.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ed();
            } catch (Throwable th) {
                try {
                    this.rk.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.rm.ek();
                }
            }
        }
    }

    protected void ed() {
        String removeFirst;
        if (!this.rq.isEmpty()) {
            SQLiteDatabase bQ = this.rk.bQ();
            bQ.beginTransaction();
            while (true) {
                try {
                    synchronized (this.rr) {
                        if (!this.rq.isEmpty()) {
                            removeFirst = this.rq.removeFirst();
                        } else {
                            bQ.setTransactionSuccessful();
                            this.rp = 0;
                            return;
                        }
                    }
                    bQ.delete(this.rl, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.rk.a(th, "performCleanup");
                        return;
                    } finally {
                        bQ.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ee() {
        return this.rk;
    }
}
