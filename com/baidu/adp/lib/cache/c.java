package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b xq;
    protected String xr;
    protected e.b xs;
    protected e.a xt;
    protected int xu;
    protected LinkedList<String> xv = new LinkedList<>();
    private Object xw = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String ab(String str);

    protected abstract boolean ac(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gR();

    public c(com.baidu.adp.base.a.b bVar) {
        this.xq = bVar;
    }

    public void a(e eVar, String str) {
        this.xr = str;
        if (eVar instanceof e.b) {
            this.xs = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.xt = (e.a) eVar;
        }
    }

    public g<T> ad(String str) {
        try {
            return c(this.xq.eD(), str);
        } catch (Throwable th) {
            this.xq.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.xw) {
                this.xv.remove(gVar.xC);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase eD = this.xq.eD();
            if (eD.update(this.xr, a, "m_key = ?", new String[]{gVar.xC}) == 0) {
                eD.insert(this.xr, null, a);
                if (this.xt != null) {
                    gS();
                }
            }
            if (this.xs != null && (e = this.xs.e(gVar)) != null) {
                ae(e);
            }
        } catch (Throwable th) {
            this.xq.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gS() {
        if (this.xt != null) {
            this.xu++;
            if (this.xu >= ((int) Math.min(this.xt.getMaxSize() * 0.2d, 5.0d))) {
                this.xu = 0;
                com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gT();
                    }
                });
            }
        }
    }

    public int ae(String str) {
        try {
            return this.xq.eD().delete(this.xr, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.xq.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void af(String str) {
        this.xu = 0;
        synchronized (this.xw) {
            this.xv.clear();
        }
        if (ac(str)) {
            BdCacheService.hd().he().ar(str);
        }
    }

    public synchronized void b(String str, boolean z) {
        synchronized (this.xw) {
            if (!this.xv.contains(str)) {
                this.xv.addLast(str);
                if (z) {
                    gS();
                }
            }
        }
    }

    public void ag(String str) {
        if (this.xt != null) {
            Cursor cursor = null;
            try {
                this.xt.gX();
                cursor = d(this.xq.eD(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xC = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xE = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xF = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xG = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.xt.d(gVar);
                    if (d != null) {
                        b(d, false);
                    }
                }
                gT();
            } catch (Throwable th) {
                try {
                    this.xq.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xt.gY();
                }
            }
        }
    }

    public void ah(String str) {
        if (this.xs != null) {
            Cursor cursor = null;
            try {
                this.xs.gZ();
                cursor = d(this.xq.eD(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xC = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xE = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xF = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xG = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.xs.f(gVar);
                    if (f != null) {
                        b(f, false);
                    }
                }
                gT();
            } catch (Throwable th) {
                try {
                    this.xq.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xs.ha();
                }
            }
        }
    }

    protected void gT() {
        String removeFirst;
        if (!this.xv.isEmpty()) {
            SQLiteDatabase eD = this.xq.eD();
            eD.beginTransaction();
            while (true) {
                try {
                    synchronized (this.xw) {
                        if (!this.xv.isEmpty()) {
                            removeFirst = this.xv.removeFirst();
                        } else {
                            eD.setTransactionSuccessful();
                            this.xu = 0;
                            return;
                        }
                    }
                    eD.delete(this.xr, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.xq.a(th, "performCleanup");
                        return;
                    } finally {
                        eD.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b gU() {
        return this.xq;
    }
}
