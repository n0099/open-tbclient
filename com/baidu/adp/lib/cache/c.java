package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b yd;
    protected String ye;
    protected e.b yf;
    protected e.a yg;
    protected int yh;
    protected LinkedList<String> yi = new LinkedList<>();
    private Object yj = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String ab(String str);

    protected abstract boolean ac(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int he();

    public c(com.baidu.adp.base.a.b bVar) {
        this.yd = bVar;
    }

    public void a(e eVar, String str) {
        this.ye = str;
        if (eVar instanceof e.b) {
            this.yf = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.yg = (e.a) eVar;
        }
    }

    public g<T> ad(String str) {
        try {
            return c(this.yd.eT(), str);
        } catch (Throwable th) {
            this.yd.c(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.yj) {
                this.yi.remove(gVar.yp);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase eT = this.yd.eT();
            if (eT.update(this.ye, a, "m_key = ?", new String[]{gVar.yp}) == 0) {
                eT.insert(this.ye, null, a);
                if (this.yg != null) {
                    hf();
                }
            }
            if (this.yf != null && (e = this.yf.e(gVar)) != null) {
                ae(e);
            }
        } catch (Throwable th) {
            this.yd.c(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void hf() {
        if (this.yg != null) {
            this.yh++;
            if (this.yh >= ((int) Math.min(this.yg.getMaxSize() * 0.2d, 5.0d))) {
                this.yh = 0;
                com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hg();
                    }
                });
            }
        }
    }

    public int ae(String str) {
        try {
            return this.yd.eT().delete(this.ye, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.yd.c(th, "deleteCacheItem");
            return 0;
        }
    }

    public void af(String str) {
        this.yh = 0;
        synchronized (this.yj) {
            this.yi.clear();
        }
        if (ac(str)) {
            BdCacheService.hq().hr().as(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.yj) {
            if (!this.yi.contains(str)) {
                this.yi.addLast(str);
                if (z) {
                    hf();
                }
            }
        }
    }

    public void ag(String str) {
        if (this.yg != null) {
            Cursor cursor = null;
            try {
                this.yg.hk();
                cursor = d(this.yd.eT(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.yp = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.yr = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ys = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.yt = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.yg.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                hg();
            } catch (Throwable th) {
                try {
                    this.yd.c(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.yg.hl();
                }
            }
        }
    }

    public void ah(String str) {
        if (this.yf != null) {
            Cursor cursor = null;
            try {
                this.yf.hm();
                cursor = d(this.yd.eT(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.yp = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.yr = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ys = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.yt = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.yf.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                hg();
            } catch (Throwable th) {
                try {
                    this.yd.c(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.yf.hn();
                }
            }
        }
    }

    protected void hg() {
        String removeFirst;
        if (!this.yi.isEmpty()) {
            SQLiteDatabase eT = this.yd.eT();
            eT.beginTransaction();
            while (true) {
                try {
                    synchronized (this.yj) {
                        if (!this.yi.isEmpty()) {
                            removeFirst = this.yi.removeFirst();
                        } else {
                            eT.setTransactionSuccessful();
                            this.yh = 0;
                            return;
                        }
                    }
                    eT.delete(this.ye, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.yd.c(th, "performCleanup");
                        return;
                    } finally {
                        eT.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b hh() {
        return this.yd;
    }
}
