package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b At;
    protected String Au;
    protected e.b Av;
    protected e.a Aw;
    protected int Ax;
    protected LinkedList<String> Ay = new LinkedList<>();
    private Object Az = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String as(String str);

    protected abstract boolean at(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int il();

    public c(com.baidu.adp.base.a.b bVar) {
        this.At = bVar;
    }

    public void a(e eVar, String str) {
        this.Au = str;
        if (eVar instanceof e.b) {
            this.Av = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.Aw = (e.a) eVar;
        }
    }

    public g<T> au(String str) {
        try {
            return c(this.At.ga(), str);
        } catch (Throwable th) {
            this.At.c(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.Az) {
                this.Ay.remove(gVar.AF);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ga = this.At.ga();
            if (ga.update(this.Au, a, "m_key = ?", new String[]{gVar.AF}) == 0) {
                ga.insert(this.Au, null, a);
                if (this.Aw != null) {
                    im();
                }
            }
            if (this.Av != null && (e = this.Av.e(gVar)) != null) {
                av(e);
            }
        } catch (Throwable th) {
            this.At.c(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void im() {
        if (this.Aw != null) {
            this.Ax++;
            if (this.Ax >= ((int) Math.min(this.Aw.getMaxSize() * 0.2d, 5.0d))) {
                this.Ax = 0;
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
            return this.At.ga().delete(this.Au, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.At.c(th, "deleteCacheItem");
            return 0;
        }
    }

    public void aw(String str) {
        this.Ax = 0;
        synchronized (this.Az) {
            this.Ay.clear();
        }
        if (at(str)) {
            BdCacheService.iy().iz().aI(str);
        }
    }

    public synchronized void d(String str, boolean z) {
        synchronized (this.Az) {
            if (!this.Ay.contains(str)) {
                this.Ay.addLast(str);
                if (z) {
                    im();
                }
            }
        }
    }

    public void ax(String str) {
        if (this.Aw != null) {
            Cursor cursor = null;
            try {
                this.Aw.is();
                cursor = d(this.At.ga(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AF = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AH = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AI = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AJ = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.Aw.d(gVar);
                    if (d != null) {
                        d(d, false);
                    }
                }
                in();
            } catch (Throwable th) {
                try {
                    this.At.c(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Aw.it();
                }
            }
        }
    }

    public void ay(String str) {
        if (this.Av != null) {
            Cursor cursor = null;
            try {
                this.Av.iu();
                cursor = d(this.At.ga(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AF = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AH = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AI = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AJ = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.Av.f(gVar);
                    if (f != null) {
                        d(f, false);
                    }
                }
                in();
            } catch (Throwable th) {
                try {
                    this.At.c(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Av.iv();
                }
            }
        }
    }

    protected void in() {
        String removeFirst;
        if (!this.Ay.isEmpty()) {
            SQLiteDatabase ga = this.At.ga();
            ga.beginTransaction();
            while (true) {
                try {
                    synchronized (this.Az) {
                        if (!this.Ay.isEmpty()) {
                            removeFirst = this.Ay.removeFirst();
                        } else {
                            ga.setTransactionSuccessful();
                            this.Ax = 0;
                            return;
                        }
                    }
                    ga.delete(this.Au, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.At.c(th, "performCleanup");
                        return;
                    } finally {
                        ga.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ip() {
        return this.At;
    }
}
