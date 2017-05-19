package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b ti;
    protected String tj;
    protected f.b tk;
    protected f.a tl;
    protected int tm;
    protected LinkedList<String> tp = new LinkedList<>();
    private Object tq = new Object();

    public abstract String C(String str);

    protected abstract boolean D(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int ew();

    public c(com.baidu.adp.base.a.b bVar) {
        this.ti = bVar;
    }

    public void a(f fVar, String str) {
        this.tj = str;
        if (fVar instanceof f.b) {
            this.tk = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.tl = (f.a) fVar;
        }
    }

    public h<T> E(String str) {
        try {
            return c(this.ti.ch(), str);
        } catch (Throwable th) {
            this.ti.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.tq) {
                this.tp.remove(hVar.tw);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase ch = this.ti.ch();
            if (ch.update(this.tj, a, "m_key = ?", new String[]{hVar.tw}) == 0) {
                ch.insert(this.tj, null, a);
                if (this.tl != null) {
                    ex();
                }
            }
            if (this.tk != null && (e = this.tk.e(hVar)) != null) {
                F(e);
            }
        } catch (Throwable th) {
            this.ti.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void ex() {
        if (this.tl != null) {
            this.tm++;
            if (this.tm >= ((int) Math.min(this.tl.getMaxSize() * 0.2d, 5.0d))) {
                this.tm = 0;
                com.baidu.adp.lib.g.k.fT().f(new d(this));
            }
        }
    }

    public int F(String str) {
        try {
            return this.ti.ch().delete(this.tj, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.ti.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void G(String str) {
        this.tm = 0;
        synchronized (this.tq) {
            this.tp.clear();
        }
        if (D(str)) {
            BdCacheService.eI().eJ().S(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.tq) {
            if (!this.tp.contains(str)) {
                this.tp.addLast(str);
                if (z) {
                    ex();
                }
            }
        }
    }

    public void H(String str) {
        if (this.tl != null) {
            Cursor cursor = null;
            try {
                this.tl.eC();
                cursor = d(this.ti.ch(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tw = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.ty = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.tl.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ey();
            } catch (Throwable th) {
                try {
                    this.ti.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.tl.eD();
                }
            }
        }
    }

    public void I(String str) {
        if (this.tk != null) {
            Cursor cursor = null;
            try {
                this.tk.eE();
                cursor = d(this.ti.ch(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tw = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.ty = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.tk.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ey();
            } catch (Throwable th) {
                try {
                    this.ti.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.tk.eF();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ey() {
        String removeFirst;
        if (!this.tp.isEmpty()) {
            SQLiteDatabase ch = this.ti.ch();
            ch.beginTransaction();
            while (true) {
                try {
                    synchronized (this.tq) {
                        if (!this.tp.isEmpty()) {
                            removeFirst = this.tp.removeFirst();
                        } else {
                            ch.setTransactionSuccessful();
                            this.tm = 0;
                            return;
                        }
                    }
                    ch.delete(this.tj, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.ti.a(th, "performCleanup");
                        return;
                    } finally {
                        ch.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ez() {
        return this.ti;
    }
}
