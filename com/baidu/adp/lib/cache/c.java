package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected LinkedList<String> AA = new LinkedList<>();
    private Object AB = new Object();
    protected final com.baidu.adp.base.a.b Av;
    protected String Aw;
    protected e.b Ax;
    protected e.a Ay;
    protected int Az;

    protected abstract ContentValues a(g<T> gVar);

    public abstract String as(String str);

    protected abstract boolean at(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int il();

    public c(com.baidu.adp.base.a.b bVar) {
        this.Av = bVar;
    }

    public void a(e eVar, String str) {
        this.Aw = str;
        if (eVar instanceof e.b) {
            this.Ax = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.Ay = (e.a) eVar;
        }
    }

    public g<T> au(String str) {
        try {
            return c(this.Av.ge(), str);
        } catch (Throwable th) {
            this.Av.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.AB) {
                this.AA.remove(gVar.AH);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ge = this.Av.ge();
            if (ge.update(this.Aw, a, "m_key = ?", new String[]{gVar.AH}) == 0) {
                ge.insert(this.Aw, null, a);
                if (this.Ay != null) {
                    im();
                }
            }
            if (this.Ax != null && (e = this.Ax.e(gVar)) != null) {
                av(e);
            }
        } catch (Throwable th) {
            this.Av.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void im() {
        if (this.Ay != null) {
            this.Az++;
            if (this.Az >= ((int) Math.min(this.Ay.getMaxSize() * 0.2d, 5.0d))) {
                this.Az = 0;
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
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
            return this.Av.ge().delete(this.Aw, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.Av.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void aw(String str) {
        this.Az = 0;
        synchronized (this.AB) {
            this.AA.clear();
        }
        if (at(str)) {
            BdCacheService.iy().iz().aI(str);
        }
    }

    public synchronized void f(String str, boolean z) {
        synchronized (this.AB) {
            if (!this.AA.contains(str)) {
                this.AA.addLast(str);
                if (z) {
                    im();
                }
            }
        }
    }

    public void ax(String str) {
        if (this.Ay != null) {
            Cursor cursor = null;
            try {
                this.Ay.is();
                cursor = d(this.Av.ge(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AH = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AJ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AK = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AM = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.Ay.d(gVar);
                    if (d != null) {
                        f(d, false);
                    }
                }
                in();
            } catch (Throwable th) {
                try {
                    this.Av.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Ay.it();
                }
            }
        }
    }

    public void ay(String str) {
        if (this.Ax != null) {
            Cursor cursor = null;
            try {
                this.Ax.iu();
                cursor = d(this.Av.ge(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.AH = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.AJ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.AK = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.AM = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.Ax.f(gVar);
                    if (f != null) {
                        f(f, false);
                    }
                }
                in();
            } catch (Throwable th) {
                try {
                    this.Av.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.Ax.iv();
                }
            }
        }
    }

    protected void in() {
        String removeFirst;
        if (!this.AA.isEmpty()) {
            SQLiteDatabase ge = this.Av.ge();
            ge.beginTransaction();
            while (true) {
                try {
                    synchronized (this.AB) {
                        if (!this.AA.isEmpty()) {
                            removeFirst = this.AA.removeFirst();
                        } else {
                            ge.setTransactionSuccessful();
                            this.Az = 0;
                            return;
                        }
                    }
                    ge.delete(this.Aw, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.Av.a(th, "performCleanup");
                        return;
                    } finally {
                        ge.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ip() {
        return this.Av;
    }
}
