package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b th;
    protected String ti;
    protected f.b tj;
    protected f.a tk;
    protected int tl;
    protected LinkedList<String> tm = new LinkedList<>();
    private Object tp = new Object();

    public abstract String C(String str);

    protected abstract boolean D(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int ew();

    public c(com.baidu.adp.base.a.b bVar) {
        this.th = bVar;
    }

    public void a(f fVar, String str) {
        this.ti = str;
        if (fVar instanceof f.b) {
            this.tj = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.tk = (f.a) fVar;
        }
    }

    public h<T> E(String str) {
        try {
            return c(this.th.ch(), str);
        } catch (Throwable th) {
            this.th.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.tp) {
                this.tm.remove(hVar.f0tv);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase ch = this.th.ch();
            if (ch.update(this.ti, a, "m_key = ?", new String[]{hVar.f0tv}) == 0) {
                ch.insert(this.ti, null, a);
                if (this.tk != null) {
                    ex();
                }
            }
            if (this.tj != null && (e = this.tj.e(hVar)) != null) {
                F(e);
            }
        } catch (Throwable th) {
            this.th.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void ex() {
        if (this.tk != null) {
            this.tl++;
            if (this.tl >= ((int) Math.min(this.tk.getMaxSize() * 0.2d, 5.0d))) {
                this.tl = 0;
                com.baidu.adp.lib.g.k.fT().f(new d(this));
            }
        }
    }

    public int F(String str) {
        try {
            return this.th.ch().delete(this.ti, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.th.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void G(String str) {
        this.tl = 0;
        synchronized (this.tp) {
            this.tm.clear();
        }
        if (D(str)) {
            BdCacheService.eI().eJ().S(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.tp) {
            if (!this.tm.contains(str)) {
                this.tm.addLast(str);
                if (z) {
                    ex();
                }
            }
        }
    }

    public void H(String str) {
        if (this.tk != null) {
            Cursor cursor = null;
            try {
                this.tk.eC();
                cursor = d(this.th.ch(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.f0tv = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tx = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.ty = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tz = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.tk.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ey();
            } catch (Throwable th) {
                try {
                    this.th.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.tk.eD();
                }
            }
        }
    }

    public void I(String str) {
        if (this.tj != null) {
            Cursor cursor = null;
            try {
                this.tj.eE();
                cursor = d(this.th.ch(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.f0tv = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tx = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.ty = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tz = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.tj.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ey();
            } catch (Throwable th) {
                try {
                    this.th.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.tj.eF();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ey() {
        String removeFirst;
        if (!this.tm.isEmpty()) {
            SQLiteDatabase ch = this.th.ch();
            ch.beginTransaction();
            while (true) {
                try {
                    synchronized (this.tp) {
                        if (!this.tm.isEmpty()) {
                            removeFirst = this.tm.removeFirst();
                        } else {
                            ch.setTransactionSuccessful();
                            this.tl = 0;
                            return;
                        }
                    }
                    ch.delete(this.ti, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.th.a(th, "performCleanup");
                        return;
                    } finally {
                        ch.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ez() {
        return this.th;
    }
}
