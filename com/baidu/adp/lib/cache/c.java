package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sC;
    protected String sD;
    protected e.b sE;
    protected e.a sF;
    protected int sG;
    protected LinkedList<String> sH = new LinkedList<>();
    private Object sI = new Object();

    public abstract String J(String str);

    protected abstract boolean K(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int et();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sC = bVar;
    }

    public void a(e eVar, String str) {
        this.sD = str;
        if (eVar instanceof e.b) {
            this.sE = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.sF = (e.a) eVar;
        }
    }

    public g<T> L(String str) {
        try {
            return c(this.sC.ch(), str);
        } catch (Throwable th) {
            this.sC.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.sI) {
                this.sH.remove(gVar.sO);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ch = this.sC.ch();
            if (ch.update(this.sD, a, "m_key = ?", new String[]{gVar.sO}) == 0) {
                ch.insert(this.sD, null, a);
                if (this.sF != null) {
                    eu();
                }
            }
            if (this.sE != null && (e = this.sE.e(gVar)) != null) {
                M(e);
            }
        } catch (Throwable th) {
            this.sC.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void eu() {
        if (this.sF != null) {
            this.sG++;
            if (this.sG >= ((int) Math.min(this.sF.getMaxSize() * 0.2d, 5.0d))) {
                this.sG = 0;
                com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ev();
                    }
                });
            }
        }
    }

    public int M(String str) {
        try {
            return this.sC.ch().delete(this.sD, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sC.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void N(String str) {
        this.sG = 0;
        synchronized (this.sI) {
            this.sH.clear();
        }
        if (K(str)) {
            BdCacheService.eF().eG().Z(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sI) {
            if (!this.sH.contains(str)) {
                this.sH.addLast(str);
                if (z) {
                    eu();
                }
            }
        }
    }

    public void O(String str) {
        if (this.sF != null) {
            Cursor cursor = null;
            try {
                this.sF.ez();
                cursor = d(this.sC.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sO = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sQ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sR = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sS = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sF.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ev();
            } catch (Throwable th) {
                try {
                    this.sC.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sF.eA();
                }
            }
        }
    }

    public void P(String str) {
        if (this.sE != null) {
            Cursor cursor = null;
            try {
                this.sE.eB();
                cursor = d(this.sC.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sO = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sQ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sR = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sS = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sE.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ev();
            } catch (Throwable th) {
                try {
                    this.sC.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sE.eC();
                }
            }
        }
    }

    protected void ev() {
        String removeFirst;
        if (!this.sH.isEmpty()) {
            SQLiteDatabase ch = this.sC.ch();
            ch.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sI) {
                        if (!this.sH.isEmpty()) {
                            removeFirst = this.sH.removeFirst();
                        } else {
                            ch.setTransactionSuccessful();
                            this.sG = 0;
                            return;
                        }
                    }
                    ch.delete(this.sD, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sC.a(th, "performCleanup");
                        return;
                    } finally {
                        ch.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ew() {
        return this.sC;
    }
}
