package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b agY;
    protected String agZ;
    protected e.b aha;
    protected e.a ahb;
    protected int ahc;
    protected LinkedList<String> ahd = new LinkedList<>();
    private Object ahe = new Object();

    public abstract String R(String str);

    protected abstract boolean S(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int lX();

    public c(com.baidu.adp.base.a.b bVar) {
        this.agY = bVar;
    }

    public void a(e eVar, String str) {
        this.agZ = str;
        if (eVar instanceof e.b) {
            this.aha = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.ahb = (e.a) eVar;
        }
    }

    public g<T> T(String str) {
        try {
            return c(this.agY.jM(), str);
        } catch (Throwable th) {
            this.agY.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.ahe) {
                this.ahd.remove(gVar.ahk);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase jM = this.agY.jM();
            if (jM.update(this.agZ, a, "m_key = ?", new String[]{gVar.ahk}) == 0) {
                jM.insert(this.agZ, null, a);
                if (this.ahb != null) {
                    lY();
                }
            }
            if (this.aha != null && (e = this.aha.e(gVar)) != null) {
                U(e);
            }
        } catch (Throwable th) {
            this.agY.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void lY() {
        if (this.ahb != null) {
            this.ahc++;
            if (this.ahc >= ((int) Math.min(this.ahb.getMaxSize() * 0.2d, 5.0d))) {
                this.ahc = 0;
                com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.lZ();
                    }
                });
            }
        }
    }

    public int U(String str) {
        try {
            return this.agY.jM().delete(this.agZ, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.agY.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void V(String str) {
        this.ahc = 0;
        synchronized (this.ahe) {
            this.ahd.clear();
        }
        if (S(str)) {
            BdCacheService.mj().mk().ah(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.ahe) {
            if (!this.ahd.contains(str)) {
                this.ahd.addLast(str);
                if (z) {
                    lY();
                }
            }
        }
    }

    public void W(String str) {
        if (this.ahb != null) {
            Cursor cursor = null;
            try {
                this.ahb.md();
                cursor = d(this.agY.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahk = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahm = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahn = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.aho = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.ahb.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                lZ();
            } catch (Throwable th) {
                try {
                    this.agY.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.ahb.me();
                }
            }
        }
    }

    public void X(String str) {
        if (this.aha != null) {
            Cursor cursor = null;
            try {
                this.aha.mf();
                cursor = d(this.agY.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahk = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahm = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahn = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.aho = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.aha.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                lZ();
            } catch (Throwable th) {
                try {
                    this.agY.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.aha.mg();
                }
            }
        }
    }

    protected void lZ() {
        String removeFirst;
        if (!this.ahd.isEmpty()) {
            SQLiteDatabase jM = this.agY.jM();
            jM.beginTransaction();
            while (true) {
                try {
                    synchronized (this.ahe) {
                        if (!this.ahd.isEmpty()) {
                            removeFirst = this.ahd.removeFirst();
                        } else {
                            jM.setTransactionSuccessful();
                            this.ahc = 0;
                            return;
                        }
                    }
                    jM.delete(this.agZ, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.agY.a(th, "performCleanup");
                        return;
                    } finally {
                        jM.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ma() {
        return this.agY;
    }
}
