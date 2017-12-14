package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sA;
    protected String sB;
    protected e.b sC;
    protected e.a sD;
    protected int sE;
    protected LinkedList<String> sF = new LinkedList<>();
    private Object sG = new Object();

    public abstract String J(String str);

    protected abstract boolean K(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int es();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sA = bVar;
    }

    public void a(e eVar, String str) {
        this.sB = str;
        if (eVar instanceof e.b) {
            this.sC = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.sD = (e.a) eVar;
        }
    }

    public g<T> L(String str) {
        try {
            return c(this.sA.ch(), str);
        } catch (Throwable th) {
            this.sA.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.sG) {
                this.sF.remove(gVar.sM);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ch = this.sA.ch();
            if (ch.update(this.sB, a, "m_key = ?", new String[]{gVar.sM}) == 0) {
                ch.insert(this.sB, null, a);
                if (this.sD != null) {
                    et();
                }
            }
            if (this.sC != null && (e = this.sC.e(gVar)) != null) {
                M(e);
            }
        } catch (Throwable th) {
            this.sA.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void et() {
        if (this.sD != null) {
            this.sE++;
            if (this.sE >= ((int) Math.min(this.sD.getMaxSize() * 0.2d, 5.0d))) {
                this.sE = 0;
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.eu();
                    }
                });
            }
        }
    }

    public int M(String str) {
        try {
            return this.sA.ch().delete(this.sB, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sA.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void N(String str) {
        this.sE = 0;
        synchronized (this.sG) {
            this.sF.clear();
        }
        if (K(str)) {
            BdCacheService.eE().eF().Z(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sG) {
            if (!this.sF.contains(str)) {
                this.sF.addLast(str);
                if (z) {
                    et();
                }
            }
        }
    }

    public void O(String str) {
        if (this.sD != null) {
            Cursor cursor = null;
            try {
                this.sD.ey();
                cursor = d(this.sA.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sM = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sO = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sP = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sQ = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sD.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                eu();
            } catch (Throwable th) {
                try {
                    this.sA.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sD.ez();
                }
            }
        }
    }

    public void P(String str) {
        if (this.sC != null) {
            Cursor cursor = null;
            try {
                this.sC.eA();
                cursor = d(this.sA.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sM = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sO = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sP = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sQ = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sC.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                eu();
            } catch (Throwable th) {
                try {
                    this.sA.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sC.eB();
                }
            }
        }
    }

    protected void eu() {
        String removeFirst;
        if (!this.sF.isEmpty()) {
            SQLiteDatabase ch = this.sA.ch();
            ch.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sG) {
                        if (!this.sF.isEmpty()) {
                            removeFirst = this.sF.removeFirst();
                        } else {
                            ch.setTransactionSuccessful();
                            this.sE = 0;
                            return;
                        }
                    }
                    ch.delete(this.sB, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sA.a(th, "performCleanup");
                        return;
                    } finally {
                        ch.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ev() {
        return this.sA;
    }
}
