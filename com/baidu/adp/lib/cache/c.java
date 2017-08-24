package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b uQ;
    protected String uR;
    protected e.b uS;
    protected e.a uT;
    protected int uU;
    protected LinkedList<String> uV = new LinkedList<>();
    private Object uW = new Object();

    public abstract String Q(String str);

    protected abstract boolean R(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int eE();

    public c(com.baidu.adp.base.a.b bVar) {
        this.uQ = bVar;
    }

    public void a(e eVar, String str) {
        this.uR = str;
        if (eVar instanceof e.b) {
            this.uS = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.uT = (e.a) eVar;
        }
    }

    public g<T> S(String str) {
        try {
            return c(this.uQ.cs(), str);
        } catch (Throwable th) {
            this.uQ.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.uW) {
                this.uV.remove(gVar.vc);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase cs = this.uQ.cs();
            if (cs.update(this.uR, a, "m_key = ?", new String[]{gVar.vc}) == 0) {
                cs.insert(this.uR, null, a);
                if (this.uT != null) {
                    eF();
                }
            }
            if (this.uS != null && (e = this.uS.e(gVar)) != null) {
                T(e);
            }
        } catch (Throwable th) {
            this.uQ.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void eF() {
        if (this.uT != null) {
            this.uU++;
            if (this.uU >= ((int) Math.min(this.uT.getMaxSize() * 0.2d, 5.0d))) {
                this.uU = 0;
                com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.eG();
                    }
                });
            }
        }
    }

    public int T(String str) {
        try {
            return this.uQ.cs().delete(this.uR, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.uQ.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void U(String str) {
        this.uU = 0;
        synchronized (this.uW) {
            this.uV.clear();
        }
        if (R(str)) {
            BdCacheService.eQ().eR().ag(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.uW) {
            if (!this.uV.contains(str)) {
                this.uV.addLast(str);
                if (z) {
                    eF();
                }
            }
        }
    }

    public void V(String str) {
        if (this.uT != null) {
            Cursor cursor = null;
            try {
                this.uT.eK();
                cursor = d(this.uQ.cs(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.vc = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ve = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.vf = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.vg = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.uT.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                eG();
            } catch (Throwable th) {
                try {
                    this.uQ.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.uT.eL();
                }
            }
        }
    }

    public void W(String str) {
        if (this.uS != null) {
            Cursor cursor = null;
            try {
                this.uS.eM();
                cursor = d(this.uQ.cs(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.vc = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.ve = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.vf = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.vg = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.uS.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                eG();
            } catch (Throwable th) {
                try {
                    this.uQ.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.uS.eN();
                }
            }
        }
    }

    protected void eG() {
        String removeFirst;
        if (!this.uV.isEmpty()) {
            SQLiteDatabase cs = this.uQ.cs();
            cs.beginTransaction();
            while (true) {
                try {
                    synchronized (this.uW) {
                        if (!this.uV.isEmpty()) {
                            removeFirst = this.uV.removeFirst();
                        } else {
                            cs.setTransactionSuccessful();
                            this.uU = 0;
                            return;
                        }
                    }
                    cs.delete(this.uR, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.uQ.a(th, "performCleanup");
                        return;
                    } finally {
                        cs.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b eH() {
        return this.uQ;
    }
}
