package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b Au;
    protected String Av;
    protected e.b Aw;
    protected e.a Ax;
    protected int Ay;
    protected LinkedList<String> Az = new LinkedList<>();
    private Object AA = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String as(String str);

    protected abstract boolean at(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int il();

    public c(com.baidu.adp.base.a.b bVar) {
        this.Au = bVar;
    }

    public void a(e eVar, String str) {
        this.Av = str;
        if (eVar instanceof e.b) {
            this.Aw = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.Ax = (e.a) eVar;
        }
    }

    public g<T> au(String str) {
        try {
            return c(this.Au.ga(), str);
        } catch (Throwable th) {
            this.Au.c(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.AA) {
                this.Az.remove(gVar.AG);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ga = this.Au.ga();
            if (ga.update(this.Av, a, "m_key = ?", new String[]{gVar.AG}) == 0) {
                ga.insert(this.Av, null, a);
                if (this.Ax != null) {
                    im();
                }
            }
            if (this.Aw != null && (e = this.Aw.e(gVar)) != null) {
                av(e);
            }
        } catch (Throwable th) {
            this.Au.c(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void im() {
        if (this.Ax != null) {
            this.Ay++;
            if (this.Ay >= ((int) Math.min(this.Ax.getMaxSize() * 0.2d, 5.0d))) {
                this.Ay = 0;
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.in();
                    }
                });
            }
        }
    }

    public int av(String str) {
        try {
            return this.Au.ga().delete(this.Av, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.Au.c(th, "deleteCacheItem");
            return 0;
        }
    }

    public void aw(String str) {
        this.Ay = 0;
        synchronized (this.AA) {
            this.Az.clear();
        }
        if (at(str)) {
            BdCacheService.iy().iz().aI(str);
        }
    }

    public synchronized void d(String str, boolean z) {
        synchronized (this.AA) {
            if (!this.Az.contains(str)) {
                this.Az.addLast(str);
                if (z) {
                    im();
                }
            }
        }
    }

    public void ax(String str) {
        if (this.Ax != null) {
            Cursor cursor = null;
            try {
                this.Ax.is();
                cursor = d(this.Au.ga(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AG = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AI = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AJ = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AK = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.Ax.d(gVar);
                    if (d != null) {
                        d(d, false);
                    }
                }
                in();
            } catch (Throwable th) {
                try {
                    this.Au.c(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Ax.it();
                }
            }
        }
    }

    public void ay(String str) {
        if (this.Aw != null) {
            Cursor cursor = null;
            try {
                this.Aw.iu();
                cursor = d(this.Au.ga(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AG = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AI = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AJ = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AK = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.Aw.f(gVar);
                    if (f != null) {
                        d(f, false);
                    }
                }
                in();
            } catch (Throwable th) {
                try {
                    this.Au.c(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Aw.iv();
                }
            }
        }
    }

    protected void in() {
        String removeFirst;
        if (!this.Az.isEmpty()) {
            SQLiteDatabase ga = this.Au.ga();
            ga.beginTransaction();
            while (true) {
                try {
                    synchronized (this.AA) {
                        if (!this.Az.isEmpty()) {
                            removeFirst = this.Az.removeFirst();
                        } else {
                            ga.setTransactionSuccessful();
                            this.Ay = 0;
                            return;
                        }
                    }
                    ga.delete(this.Av, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.Au.c(th, "performCleanup");
                        return;
                    } finally {
                        ga.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ip() {
        return this.Au;
    }
}
