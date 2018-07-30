package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b xp;
    protected String xq;
    protected e.b xr;
    protected e.a xs;
    protected int xt;
    protected LinkedList<String> xu = new LinkedList<>();
    private Object xv = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String ab(String str);

    protected abstract boolean ac(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gR();

    public c(com.baidu.adp.base.a.b bVar) {
        this.xp = bVar;
    }

    public void a(e eVar, String str) {
        this.xq = str;
        if (eVar instanceof e.b) {
            this.xr = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.xs = (e.a) eVar;
        }
    }

    public g<T> ad(String str) {
        try {
            return c(this.xp.eD(), str);
        } catch (Throwable th) {
            this.xp.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.xv) {
                this.xu.remove(gVar.xB);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase eD = this.xp.eD();
            if (eD.update(this.xq, a, "m_key = ?", new String[]{gVar.xB}) == 0) {
                eD.insert(this.xq, null, a);
                if (this.xs != null) {
                    gS();
                }
            }
            if (this.xr != null && (e = this.xr.e(gVar)) != null) {
                ae(e);
            }
        } catch (Throwable th) {
            this.xp.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gS() {
        if (this.xs != null) {
            this.xt++;
            if (this.xt >= ((int) Math.min(this.xs.getMaxSize() * 0.2d, 5.0d))) {
                this.xt = 0;
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
            return this.xp.eD().delete(this.xq, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.xp.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void af(String str) {
        this.xt = 0;
        synchronized (this.xv) {
            this.xu.clear();
        }
        if (ac(str)) {
            BdCacheService.hd().he().ar(str);
        }
    }

    public synchronized void b(String str, boolean z) {
        synchronized (this.xv) {
            if (!this.xu.contains(str)) {
                this.xu.addLast(str);
                if (z) {
                    gS();
                }
            }
        }
    }

    public void ag(String str) {
        if (this.xs != null) {
            Cursor cursor = null;
            try {
                this.xs.gX();
                cursor = d(this.xp.eD(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xB = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xD = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xE = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xF = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.xs.d(gVar);
                    if (d != null) {
                        b(d, false);
                    }
                }
                gT();
            } catch (Throwable th) {
                try {
                    this.xp.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xs.gY();
                }
            }
        }
    }

    public void ah(String str) {
        if (this.xr != null) {
            Cursor cursor = null;
            try {
                this.xr.gZ();
                cursor = d(this.xp.eD(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xB = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xD = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xE = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xF = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.xr.f(gVar);
                    if (f != null) {
                        b(f, false);
                    }
                }
                gT();
            } catch (Throwable th) {
                try {
                    this.xp.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xr.ha();
                }
            }
        }
    }

    protected void gT() {
        String removeFirst;
        if (!this.xu.isEmpty()) {
            SQLiteDatabase eD = this.xp.eD();
            eD.beginTransaction();
            while (true) {
                try {
                    synchronized (this.xv) {
                        if (!this.xu.isEmpty()) {
                            removeFirst = this.xu.removeFirst();
                        } else {
                            eD.setTransactionSuccessful();
                            this.xt = 0;
                            return;
                        }
                    }
                    eD.delete(this.xq, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.xp.a(th, "performCleanup");
                        return;
                    } finally {
                        eD.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b gU() {
        return this.xp;
    }
}
