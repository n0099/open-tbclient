package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b ti;
    protected String tj;
    protected e.b tk;
    protected e.a tl;
    protected int tm;
    protected LinkedList<String> tp = new LinkedList<>();
    private Object tq = new Object();

    public abstract String J(String str);

    protected abstract boolean K(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int et();

    public c(com.baidu.adp.base.a.b bVar) {
        this.ti = bVar;
    }

    public void a(e eVar, String str) {
        this.tj = str;
        if (eVar instanceof e.b) {
            this.tk = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.tl = (e.a) eVar;
        }
    }

    public g<T> L(String str) {
        try {
            return c(this.ti.ch(), str);
        } catch (Throwable th) {
            this.ti.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.tq) {
                this.tp.remove(gVar.tw);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ch = this.ti.ch();
            if (ch.update(this.tj, a, "m_key = ?", new String[]{gVar.tw}) == 0) {
                ch.insert(this.tj, null, a);
                if (this.tl != null) {
                    eu();
                }
            }
            if (this.tk != null && (e = this.tk.e(gVar)) != null) {
                M(e);
            }
        } catch (Throwable th) {
            this.ti.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void eu() {
        if (this.tl != null) {
            this.tm++;
            if (this.tm >= ((int) Math.min(this.tl.getMaxSize() * 0.2d, 5.0d))) {
                this.tm = 0;
                com.baidu.adp.lib.g.h.fQ().f(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ev();
                    }
                });
            }
        }
    }

    public int M(String str) {
        try {
            return this.ti.ch().delete(this.tj, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.ti.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void N(String str) {
        this.tm = 0;
        synchronized (this.tq) {
            this.tp.clear();
        }
        if (K(str)) {
            BdCacheService.eF().eG().Z(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.tq) {
            if (!this.tp.contains(str)) {
                this.tp.addLast(str);
                if (z) {
                    eu();
                }
            }
        }
    }

    public void O(String str) {
        if (this.tl != null) {
            Cursor cursor = null;
            try {
                this.tl.ez();
                cursor = d(this.ti.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.tw = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ty = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.tz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.tA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.tl.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ev();
            } catch (Throwable th) {
                try {
                    this.ti.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.tl.eA();
                }
            }
        }
    }

    public void P(String str) {
        if (this.tk != null) {
            Cursor cursor = null;
            try {
                this.tk.eB();
                cursor = d(this.ti.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.tw = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ty = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.tz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.tA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.tk.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ev();
            } catch (Throwable th) {
                try {
                    this.ti.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.tk.eC();
                }
            }
        }
    }

    protected void ev() {
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

    public com.baidu.adp.base.a.b ew() {
        return this.ti;
    }
}
