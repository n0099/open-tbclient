package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b tc;
    protected String td;
    protected f.b te;
    protected f.a tf;
    protected int tg;
    protected LinkedList<String> th = new LinkedList<>();
    private Object ti = new Object();

    public abstract String C(String str);

    protected abstract boolean D(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int ev();

    public c(com.baidu.adp.base.a.b bVar) {
        this.tc = bVar;
    }

    public void a(f fVar, String str) {
        this.td = str;
        if (fVar instanceof f.b) {
            this.te = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.tf = (f.a) fVar;
        }
    }

    public h<T> E(String str) {
        try {
            return c(this.tc.ch(), str);
        } catch (Throwable th) {
            this.tc.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.ti) {
                this.th.remove(hVar.tq);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase ch = this.tc.ch();
            if (ch.update(this.td, a, "m_key = ?", new String[]{hVar.tq}) == 0) {
                ch.insert(this.td, null, a);
                if (this.tf != null) {
                    ew();
                }
            }
            if (this.te != null && (e = this.te.e(hVar)) != null) {
                F(e);
            }
        } catch (Throwable th) {
            this.tc.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void ew() {
        if (this.tf != null) {
            this.tg++;
            if (this.tg >= ((int) Math.min(this.tf.getMaxSize() * 0.2d, 5.0d))) {
                this.tg = 0;
                com.baidu.adp.lib.g.k.fS().f(new d(this));
            }
        }
    }

    public int F(String str) {
        try {
            return this.tc.ch().delete(this.td, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.tc.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void G(String str) {
        this.tg = 0;
        synchronized (this.ti) {
            this.th.clear();
        }
        if (D(str)) {
            BdCacheService.eH().eI().S(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.ti) {
            if (!this.th.contains(str)) {
                this.th.addLast(str);
                if (z) {
                    ew();
                }
            }
        }
    }

    public void H(String str) {
        if (this.tf != null) {
            Cursor cursor = null;
            try {
                this.tf.eB();
                cursor = d(this.tc.ch(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tq = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.ts = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tt = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tu = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.tf.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ex();
            } catch (Throwable th) {
                try {
                    this.tc.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.tf.eC();
                }
            }
        }
    }

    public void I(String str) {
        if (this.te != null) {
            Cursor cursor = null;
            try {
                this.te.eD();
                cursor = d(this.tc.ch(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tq = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.ts = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tt = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tu = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.te.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ex();
            } catch (Throwable th) {
                try {
                    this.tc.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.te.eE();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ex() {
        String removeFirst;
        if (!this.th.isEmpty()) {
            SQLiteDatabase ch = this.tc.ch();
            ch.beginTransaction();
            while (true) {
                try {
                    synchronized (this.ti) {
                        if (!this.th.isEmpty()) {
                            removeFirst = this.th.removeFirst();
                        } else {
                            ch.setTransactionSuccessful();
                            this.tg = 0;
                            return;
                        }
                    }
                    ch.delete(this.td, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.tc.a(th, "performCleanup");
                        return;
                    } finally {
                        ch.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ey() {
        return this.tc;
    }
}
