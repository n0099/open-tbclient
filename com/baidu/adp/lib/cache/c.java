package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b agQ;
    protected String agR;
    protected e.b agS;
    protected e.a agT;
    protected int agU;
    protected LinkedList<String> agV = new LinkedList<>();
    private Object agW = new Object();

    public abstract String R(String str);

    protected abstract boolean S(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int lX();

    public c(com.baidu.adp.base.a.b bVar) {
        this.agQ = bVar;
    }

    public void a(e eVar, String str) {
        this.agR = str;
        if (eVar instanceof e.b) {
            this.agS = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.agT = (e.a) eVar;
        }
    }

    public g<T> T(String str) {
        try {
            return c(this.agQ.jM(), str);
        } catch (Throwable th) {
            this.agQ.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.agW) {
                this.agV.remove(gVar.ahc);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase jM = this.agQ.jM();
            if (jM.update(this.agR, a, "m_key = ?", new String[]{gVar.ahc}) == 0) {
                jM.insert(this.agR, null, a);
                if (this.agT != null) {
                    lY();
                }
            }
            if (this.agS != null && (e = this.agS.e(gVar)) != null) {
                U(e);
            }
        } catch (Throwable th) {
            this.agQ.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void lY() {
        if (this.agT != null) {
            this.agU++;
            if (this.agU >= ((int) Math.min(this.agT.getMaxSize() * 0.2d, 5.0d))) {
                this.agU = 0;
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
            return this.agQ.jM().delete(this.agR, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.agQ.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void V(String str) {
        this.agU = 0;
        synchronized (this.agW) {
            this.agV.clear();
        }
        if (S(str)) {
            BdCacheService.mj().mk().ah(str);
        }
    }

    public synchronized void b(String str, boolean z) {
        synchronized (this.agW) {
            if (!this.agV.contains(str)) {
                this.agV.addLast(str);
                if (z) {
                    lY();
                }
            }
        }
    }

    public void W(String str) {
        if (this.agT != null) {
            Cursor cursor = null;
            try {
                this.agT.md();
                cursor = d(this.agQ.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahc = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahe = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahf = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ahg = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.agT.d(gVar);
                    if (d != null) {
                        b(d, false);
                    }
                }
                lZ();
            } catch (Throwable th) {
                try {
                    this.agQ.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.agT.me();
                }
            }
        }
    }

    public void X(String str) {
        if (this.agS != null) {
            Cursor cursor = null;
            try {
                this.agS.mf();
                cursor = d(this.agQ.jM(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.ahc = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ahe = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.ahf = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ahg = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.agS.f(gVar);
                    if (f != null) {
                        b(f, false);
                    }
                }
                lZ();
            } catch (Throwable th) {
                try {
                    this.agQ.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.i(cursor);
                    this.agS.mg();
                }
            }
        }
    }

    protected void lZ() {
        String removeFirst;
        if (!this.agV.isEmpty()) {
            SQLiteDatabase jM = this.agQ.jM();
            jM.beginTransaction();
            while (true) {
                try {
                    synchronized (this.agW) {
                        if (!this.agV.isEmpty()) {
                            removeFirst = this.agV.removeFirst();
                        } else {
                            jM.setTransactionSuccessful();
                            this.agU = 0;
                            return;
                        }
                    }
                    jM.delete(this.agR, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.agQ.a(th, "performCleanup");
                        return;
                    } finally {
                        jM.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ma() {
        return this.agQ;
    }
}
