package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b uO;
    protected String uP;
    protected e.b uQ;
    protected e.a uR;
    protected int uS;
    protected LinkedList<String> uT = new LinkedList<>();
    private Object uU = new Object();

    public abstract String P(String str);

    protected abstract boolean Q(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int eE();

    public c(com.baidu.adp.base.a.b bVar) {
        this.uO = bVar;
    }

    public void a(e eVar, String str) {
        this.uP = str;
        if (eVar instanceof e.b) {
            this.uQ = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.uR = (e.a) eVar;
        }
    }

    public g<T> R(String str) {
        try {
            return c(this.uO.cs(), str);
        } catch (Throwable th) {
            this.uO.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.uU) {
                this.uT.remove(gVar.va);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase cs = this.uO.cs();
            if (cs.update(this.uP, a, "m_key = ?", new String[]{gVar.va}) == 0) {
                cs.insert(this.uP, null, a);
                if (this.uR != null) {
                    eF();
                }
            }
            if (this.uQ != null && (e = this.uQ.e(gVar)) != null) {
                S(e);
            }
        } catch (Throwable th) {
            this.uO.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void eF() {
        if (this.uR != null) {
            this.uS++;
            if (this.uS >= ((int) Math.min(this.uR.getMaxSize() * 0.2d, 5.0d))) {
                this.uS = 0;
                com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.eG();
                    }
                });
            }
        }
    }

    public int S(String str) {
        try {
            return this.uO.cs().delete(this.uP, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.uO.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void T(String str) {
        this.uS = 0;
        synchronized (this.uU) {
            this.uT.clear();
        }
        if (Q(str)) {
            BdCacheService.eQ().eR().af(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.uU) {
            if (!this.uT.contains(str)) {
                this.uT.addLast(str);
                if (z) {
                    eF();
                }
            }
        }
    }

    public void U(String str) {
        if (this.uR != null) {
            Cursor cursor = null;
            try {
                this.uR.eK();
                cursor = d(this.uO.cs(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.va = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.vc = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.vd = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ve = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.uR.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                eG();
            } catch (Throwable th) {
                try {
                    this.uO.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.uR.eL();
                }
            }
        }
    }

    public void V(String str) {
        if (this.uQ != null) {
            Cursor cursor = null;
            try {
                this.uQ.eM();
                cursor = d(this.uO.cs(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.va = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.vc = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.vd = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.ve = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.uQ.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                eG();
            } catch (Throwable th) {
                try {
                    this.uO.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.uQ.eN();
                }
            }
        }
    }

    protected void eG() {
        String removeFirst;
        if (!this.uT.isEmpty()) {
            SQLiteDatabase cs = this.uO.cs();
            cs.beginTransaction();
            while (true) {
                try {
                    synchronized (this.uU) {
                        if (!this.uT.isEmpty()) {
                            removeFirst = this.uT.removeFirst();
                        } else {
                            cs.setTransactionSuccessful();
                            this.uS = 0;
                            return;
                        }
                    }
                    cs.delete(this.uP, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.uO.a(th, "performCleanup");
                        return;
                    } finally {
                        cs.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b eH() {
        return this.uO;
    }
}
