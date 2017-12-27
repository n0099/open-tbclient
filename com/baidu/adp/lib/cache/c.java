package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b agV;
    protected String agW;
    protected e.b agX;
    protected e.a agY;
    protected int agZ;
    protected LinkedList<String> aha = new LinkedList<>();
    private Object ahb = new Object();

    public abstract String R(String str);

    protected abstract boolean S(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int lW();

    public c(com.baidu.adp.base.a.b bVar) {
        this.agV = bVar;
    }

    public void a(e eVar, String str) {
        this.agW = str;
        if (eVar instanceof e.b) {
            this.agX = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.agY = (e.a) eVar;
        }
    }

    public g<T> T(String str) {
        try {
            return c(this.agV.jM(), str);
        } catch (Throwable th) {
            this.agV.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.ahb) {
                this.aha.remove(gVar.ahh);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase jM = this.agV.jM();
            if (jM.update(this.agW, a, "m_key = ?", new String[]{gVar.ahh}) == 0) {
                jM.insert(this.agW, null, a);
                if (this.agY != null) {
                    lX();
                }
            }
            if (this.agX != null && (e = this.agX.e(gVar)) != null) {
                U(e);
            }
        } catch (Throwable th) {
            this.agV.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void lX() {
        if (this.agY != null) {
            this.agZ++;
            if (this.agZ >= ((int) Math.min(this.agY.getMaxSize() * 0.2d, 5.0d))) {
                this.agZ = 0;
                com.baidu.adp.lib.g.h.ns().e(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.lY();
                    }
                });
            }
        }
    }

    public int U(String str) {
        try {
            return this.agV.jM().delete(this.agW, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.agV.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void V(String str) {
        this.agZ = 0;
        synchronized (this.ahb) {
            this.aha.clear();
        }
        if (S(str)) {
            BdCacheService.mi().mj().ah(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.ahb) {
            if (!this.aha.contains(str)) {
                this.aha.addLast(str);
                if (z) {
                    lX();
                }
            }
        }
    }

    public void W(String str) {
        if (this.agY != null) {
            Cursor cursor = null;
            try {
                this.agY.mc();
                cursor = d(this.agV.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahh = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahj = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahk = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ahl = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.agY.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                lY();
            } catch (Throwable th) {
                try {
                    this.agV.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.agY.md();
                }
            }
        }
    }

    public void X(String str) {
        if (this.agX != null) {
            Cursor cursor = null;
            try {
                this.agX.me();
                cursor = d(this.agV.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahh = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahj = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahk = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ahl = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.agX.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                lY();
            } catch (Throwable th) {
                try {
                    this.agV.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.agX.mf();
                }
            }
        }
    }

    protected void lY() {
        String removeFirst;
        if (!this.aha.isEmpty()) {
            SQLiteDatabase jM = this.agV.jM();
            jM.beginTransaction();
            while (true) {
                try {
                    synchronized (this.ahb) {
                        if (!this.aha.isEmpty()) {
                            removeFirst = this.aha.removeFirst();
                        } else {
                            jM.setTransactionSuccessful();
                            this.agZ = 0;
                            return;
                        }
                    }
                    jM.delete(this.agW, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.agV.a(th, "performCleanup");
                        return;
                    } finally {
                        jM.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b lZ() {
        return this.agV;
    }
}
