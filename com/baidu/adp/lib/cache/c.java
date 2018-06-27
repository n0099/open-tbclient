package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected LinkedList<String> xA = new LinkedList<>();
    private Object xB = new Object();
    protected final com.baidu.adp.base.a.b xv;
    protected String xw;
    protected e.b xx;
    protected e.a xy;
    protected int xz;

    protected abstract ContentValues a(g<T> gVar);

    public abstract String aa(String str);

    protected abstract boolean ab(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gS();

    public c(com.baidu.adp.base.a.b bVar) {
        this.xv = bVar;
    }

    public void a(e eVar, String str) {
        this.xw = str;
        if (eVar instanceof e.b) {
            this.xx = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.xy = (e.a) eVar;
        }
    }

    public g<T> ac(String str) {
        try {
            return c(this.xv.eE(), str);
        } catch (Throwable th) {
            this.xv.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.xB) {
                this.xA.remove(gVar.xH);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase eE = this.xv.eE();
            if (eE.update(this.xw, a, "m_key = ?", new String[]{gVar.xH}) == 0) {
                eE.insert(this.xw, null, a);
                if (this.xy != null) {
                    gT();
                }
            }
            if (this.xx != null && (e = this.xx.e(gVar)) != null) {
                ad(e);
            }
        } catch (Throwable th) {
            this.xv.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gT() {
        if (this.xy != null) {
            this.xz++;
            if (this.xz >= ((int) Math.min(this.xy.getMaxSize() * 0.2d, 5.0d))) {
                this.xz = 0;
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gU();
                    }
                });
            }
        }
    }

    public int ad(String str) {
        try {
            return this.xv.eE().delete(this.xw, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.xv.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void ae(String str) {
        this.xz = 0;
        synchronized (this.xB) {
            this.xA.clear();
        }
        if (ab(str)) {
            BdCacheService.he().hf().aq(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.xB) {
            if (!this.xA.contains(str)) {
                this.xA.addLast(str);
                if (z) {
                    gT();
                }
            }
        }
    }

    public void af(String str) {
        if (this.xy != null) {
            Cursor cursor = null;
            try {
                this.xy.gY();
                cursor = d(this.xv.eE(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xH = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xJ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xK = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xL = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.xy.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                gU();
            } catch (Throwable th) {
                try {
                    this.xv.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xy.gZ();
                }
            }
        }
    }

    public void ag(String str) {
        if (this.xx != null) {
            Cursor cursor = null;
            try {
                this.xx.ha();
                cursor = d(this.xv.eE(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xH = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xJ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xK = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xL = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.xx.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                gU();
            } catch (Throwable th) {
                try {
                    this.xv.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xx.hb();
                }
            }
        }
    }

    protected void gU() {
        String removeFirst;
        if (!this.xA.isEmpty()) {
            SQLiteDatabase eE = this.xv.eE();
            eE.beginTransaction();
            while (true) {
                try {
                    synchronized (this.xB) {
                        if (!this.xA.isEmpty()) {
                            removeFirst = this.xA.removeFirst();
                        } else {
                            eE.setTransactionSuccessful();
                            this.xz = 0;
                            return;
                        }
                    }
                    eE.delete(this.xw, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.xv.a(th, "performCleanup");
                        return;
                    } finally {
                        eE.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b gV() {
        return this.xv;
    }
}
