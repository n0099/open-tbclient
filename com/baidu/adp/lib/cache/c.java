package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b agW;
    protected String agX;
    protected e.b agY;
    protected e.a agZ;
    protected int aha;
    protected LinkedList<String> ahb = new LinkedList<>();
    private Object ahc = new Object();

    public abstract String R(String str);

    protected abstract boolean S(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int lX();

    public c(com.baidu.adp.base.a.b bVar) {
        this.agW = bVar;
    }

    public void a(e eVar, String str) {
        this.agX = str;
        if (eVar instanceof e.b) {
            this.agY = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.agZ = (e.a) eVar;
        }
    }

    public g<T> T(String str) {
        try {
            return c(this.agW.jM(), str);
        } catch (Throwable th) {
            this.agW.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.ahc) {
                this.ahb.remove(gVar.ahi);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase jM = this.agW.jM();
            if (jM.update(this.agX, a, "m_key = ?", new String[]{gVar.ahi}) == 0) {
                jM.insert(this.agX, null, a);
                if (this.agZ != null) {
                    lY();
                }
            }
            if (this.agY != null && (e = this.agY.e(gVar)) != null) {
                U(e);
            }
        } catch (Throwable th) {
            this.agW.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void lY() {
        if (this.agZ != null) {
            this.aha++;
            if (this.aha >= ((int) Math.min(this.agZ.getMaxSize() * 0.2d, 5.0d))) {
                this.aha = 0;
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
            return this.agW.jM().delete(this.agX, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.agW.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void V(String str) {
        this.aha = 0;
        synchronized (this.ahc) {
            this.ahb.clear();
        }
        if (S(str)) {
            BdCacheService.mj().mk().ah(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.ahc) {
            if (!this.ahb.contains(str)) {
                this.ahb.addLast(str);
                if (z) {
                    lY();
                }
            }
        }
    }

    public void W(String str) {
        if (this.agZ != null) {
            Cursor cursor = null;
            try {
                this.agZ.md();
                cursor = d(this.agW.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahi = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahk = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahl = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ahm = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.agZ.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                lZ();
            } catch (Throwable th) {
                try {
                    this.agW.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.agZ.me();
                }
            }
        }
    }

    public void X(String str) {
        if (this.agY != null) {
            Cursor cursor = null;
            try {
                this.agY.mf();
                cursor = d(this.agW.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahi = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahk = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahl = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ahm = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.agY.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                lZ();
            } catch (Throwable th) {
                try {
                    this.agW.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.agY.mg();
                }
            }
        }
    }

    protected void lZ() {
        String removeFirst;
        if (!this.ahb.isEmpty()) {
            SQLiteDatabase jM = this.agW.jM();
            jM.beginTransaction();
            while (true) {
                try {
                    synchronized (this.ahc) {
                        if (!this.ahb.isEmpty()) {
                            removeFirst = this.ahb.removeFirst();
                        } else {
                            jM.setTransactionSuccessful();
                            this.aha = 0;
                            return;
                        }
                    }
                    jM.delete(this.agX, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.agW.a(th, "performCleanup");
                        return;
                    } finally {
                        jM.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ma() {
        return this.agW;
    }
}
