package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b As;
    protected String At;
    protected e.b Au;
    protected e.a Av;
    protected int Aw;
    protected LinkedList<String> Ax = new LinkedList<>();
    private Object Ay = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String as(String str);

    protected abstract boolean at(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int im();

    public c(com.baidu.adp.base.a.b bVar) {
        this.As = bVar;
    }

    public void a(e eVar, String str) {
        this.At = str;
        if (eVar instanceof e.b) {
            this.Au = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.Av = (e.a) eVar;
        }
    }

    public g<T> au(String str) {
        try {
            return c(this.As.ge(), str);
        } catch (Throwable th) {
            this.As.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.Ay) {
                this.Ax.remove(gVar.AE);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ge = this.As.ge();
            if (ge.update(this.At, a, "m_key = ?", new String[]{gVar.AE}) == 0) {
                ge.insert(this.At, null, a);
                if (this.Av != null) {
                    in();
                }
            }
            if (this.Au != null && (e = this.Au.e(gVar)) != null) {
                av(e);
            }
        } catch (Throwable th) {
            this.As.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void in() {
        if (this.Av != null) {
            this.Aw++;
            if (this.Aw >= ((int) Math.min(this.Av.getMaxSize() * 0.2d, 5.0d))) {
                this.Aw = 0;
                com.baidu.adp.lib.g.h.jJ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ip();
                    }
                });
            }
        }
    }

    public int av(String str) {
        try {
            return this.As.ge().delete(this.At, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.As.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void aw(String str) {
        this.Aw = 0;
        synchronized (this.Ay) {
            this.Ax.clear();
        }
        if (at(str)) {
            BdCacheService.iz().iA().aI(str);
        }
    }

    public synchronized void f(String str, boolean z) {
        synchronized (this.Ay) {
            if (!this.Ax.contains(str)) {
                this.Ax.addLast(str);
                if (z) {
                    in();
                }
            }
        }
    }

    public void ax(String str) {
        if (this.Av != null) {
            Cursor cursor = null;
            try {
                this.Av.it();
                cursor = d(this.As.ge(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AE = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AG = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AH = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AI = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.Av.d(gVar);
                    if (d != null) {
                        f(d, false);
                    }
                }
                ip();
            } catch (Throwable th) {
                try {
                    this.As.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Av.iu();
                }
            }
        }
    }

    public void ay(String str) {
        if (this.Au != null) {
            Cursor cursor = null;
            try {
                this.Au.iv();
                cursor = d(this.As.ge(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AE = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AG = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AH = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AI = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.Au.f(gVar);
                    if (f != null) {
                        f(f, false);
                    }
                }
                ip();
            } catch (Throwable th) {
                try {
                    this.As.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Au.iw();
                }
            }
        }
    }

    protected void ip() {
        String removeFirst;
        if (!this.Ax.isEmpty()) {
            SQLiteDatabase ge = this.As.ge();
            ge.beginTransaction();
            while (true) {
                try {
                    synchronized (this.Ay) {
                        if (!this.Ax.isEmpty()) {
                            removeFirst = this.Ax.removeFirst();
                        } else {
                            ge.setTransactionSuccessful();
                            this.Aw = 0;
                            return;
                        }
                    }
                    ge.delete(this.At, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.As.a(th, "performCleanup");
                        return;
                    } finally {
                        ge.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b iq() {
        return this.As;
    }
}
