package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b ye;
    protected String yf;
    protected e.b yg;
    protected e.a yh;
    protected int yi;
    protected LinkedList<String> yj = new LinkedList<>();
    private Object yk = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String ab(String str);

    protected abstract boolean ac(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int he();

    public c(com.baidu.adp.base.a.b bVar) {
        this.ye = bVar;
    }

    public void a(e eVar, String str) {
        this.yf = str;
        if (eVar instanceof e.b) {
            this.yg = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.yh = (e.a) eVar;
        }
    }

    public g<T> ad(String str) {
        try {
            return c(this.ye.eT(), str);
        } catch (Throwable th) {
            this.ye.c(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.yk) {
                this.yj.remove(gVar.yq);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase eT = this.ye.eT();
            if (eT.update(this.yf, a, "m_key = ?", new String[]{gVar.yq}) == 0) {
                eT.insert(this.yf, null, a);
                if (this.yh != null) {
                    hf();
                }
            }
            if (this.yg != null && (e = this.yg.e(gVar)) != null) {
                ae(e);
            }
        } catch (Throwable th) {
            this.ye.c(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void hf() {
        if (this.yh != null) {
            this.yi++;
            if (this.yi >= ((int) Math.min(this.yh.getMaxSize() * 0.2d, 5.0d))) {
                this.yi = 0;
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
            return this.ye.eT().delete(this.yf, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.ye.c(th, "deleteCacheItem");
            return 0;
        }
    }

    public void af(String str) {
        this.yi = 0;
        synchronized (this.yk) {
            this.yj.clear();
        }
        if (ac(str)) {
            BdCacheService.hq().hr().as(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.yk) {
            if (!this.yj.contains(str)) {
                this.yj.addLast(str);
                if (z) {
                    hf();
                }
            }
        }
    }

    public void ag(String str) {
        if (this.yh != null) {
            Cursor cursor = null;
            try {
                this.yh.hk();
                cursor = d(this.ye.eT(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.yq = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ys = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.yt = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.yu = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.yh.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                hg();
            } catch (Throwable th) {
                try {
                    this.ye.c(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.yh.hl();
                }
            }
        }
    }

    public void ah(String str) {
        if (this.yg != null) {
            Cursor cursor = null;
            try {
                this.yg.hm();
                cursor = d(this.ye.eT(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.yq = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ys = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.yt = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.yu = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.yg.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                hg();
            } catch (Throwable th) {
                try {
                    this.ye.c(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.yg.hn();
                }
            }
        }
    }

    protected void hg() {
        String removeFirst;
        if (!this.yj.isEmpty()) {
            SQLiteDatabase eT = this.ye.eT();
            eT.beginTransaction();
            while (true) {
                try {
                    synchronized (this.yk) {
                        if (!this.yj.isEmpty()) {
                            removeFirst = this.yj.removeFirst();
                        } else {
                            eT.setTransactionSuccessful();
                            this.yi = 0;
                            return;
                        }
                    }
                    eT.delete(this.yf, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.ye.c(th, "performCleanup");
                        return;
                    } finally {
                        eT.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b hh() {
        return this.ye;
    }
}
