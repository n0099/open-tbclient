package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sB;
    protected String sC;
    protected e.b sD;
    protected e.a sE;
    protected int sF;
    protected LinkedList<String> sG = new LinkedList<>();
    private Object sH = new Object();

    public abstract String J(String str);

    protected abstract boolean K(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int es();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sB = bVar;
    }

    public void a(e eVar, String str) {
        this.sC = str;
        if (eVar instanceof e.b) {
            this.sD = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.sE = (e.a) eVar;
        }
    }

    public g<T> L(String str) {
        try {
            return c(this.sB.ch(), str);
        } catch (Throwable th) {
            this.sB.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.sH) {
                this.sG.remove(gVar.sN);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ch = this.sB.ch();
            if (ch.update(this.sC, a, "m_key = ?", new String[]{gVar.sN}) == 0) {
                ch.insert(this.sC, null, a);
                if (this.sE != null) {
                    et();
                }
            }
            if (this.sD != null && (e = this.sD.e(gVar)) != null) {
                M(e);
            }
        } catch (Throwable th) {
            this.sB.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void et() {
        if (this.sE != null) {
            this.sF++;
            if (this.sF >= ((int) Math.min(this.sE.getMaxSize() * 0.2d, 5.0d))) {
                this.sF = 0;
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
            return this.sB.ch().delete(this.sC, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sB.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void N(String str) {
        this.sF = 0;
        synchronized (this.sH) {
            this.sG.clear();
        }
        if (K(str)) {
            BdCacheService.eE().eF().Z(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sH) {
            if (!this.sG.contains(str)) {
                this.sG.addLast(str);
                if (z) {
                    et();
                }
            }
        }
    }

    public void O(String str) {
        if (this.sE != null) {
            Cursor cursor = null;
            try {
                this.sE.ey();
                cursor = d(this.sB.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sN = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sP = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sQ = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sR = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sE.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                eu();
            } catch (Throwable th) {
                try {
                    this.sB.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sE.ez();
                }
            }
        }
    }

    public void P(String str) {
        if (this.sD != null) {
            Cursor cursor = null;
            try {
                this.sD.eA();
                cursor = d(this.sB.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sN = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sP = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sQ = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sR = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sD.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                eu();
            } catch (Throwable th) {
                try {
                    this.sB.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sD.eB();
                }
            }
        }
    }

    protected void eu() {
        String removeFirst;
        if (!this.sG.isEmpty()) {
            SQLiteDatabase ch = this.sB.ch();
            ch.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sH) {
                        if (!this.sG.isEmpty()) {
                            removeFirst = this.sG.removeFirst();
                        } else {
                            ch.setTransactionSuccessful();
                            this.sF = 0;
                            return;
                        }
                    }
                    ch.delete(this.sC, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sB.a(th, "performCleanup");
                        return;
                    } finally {
                        ch.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ev() {
        return this.sB;
    }
}
