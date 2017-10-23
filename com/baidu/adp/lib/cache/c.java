package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sD;
    protected String sE;
    protected e.b sF;
    protected e.a sG;
    protected int sH;
    protected LinkedList<String> sI = new LinkedList<>();
    private Object sJ = new Object();

    public abstract String J(String str);

    protected abstract boolean K(String str);

    protected abstract ContentValues a(g<T> gVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int es();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sD = bVar;
    }

    public void a(e eVar, String str) {
        this.sE = str;
        if (eVar instanceof e.b) {
            this.sF = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.sG = (e.a) eVar;
        }
    }

    public g<T> L(String str) {
        try {
            return c(this.sD.ch(), str);
        } catch (Throwable th) {
            this.sD.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.sJ) {
                this.sI.remove(gVar.sP);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase ch = this.sD.ch();
            if (ch.update(this.sE, a, "m_key = ?", new String[]{gVar.sP}) == 0) {
                ch.insert(this.sE, null, a);
                if (this.sG != null) {
                    et();
                }
            }
            if (this.sF != null && (e = this.sF.e(gVar)) != null) {
                M(e);
            }
        } catch (Throwable th) {
            this.sD.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void et() {
        if (this.sG != null) {
            this.sH++;
            if (this.sH >= ((int) Math.min(this.sG.getMaxSize() * 0.2d, 5.0d))) {
                this.sH = 0;
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
            return this.sD.ch().delete(this.sE, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sD.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void N(String str) {
        this.sH = 0;
        synchronized (this.sJ) {
            this.sI.clear();
        }
        if (K(str)) {
            BdCacheService.eE().eF().Z(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sJ) {
            if (!this.sI.contains(str)) {
                this.sI.addLast(str);
                if (z) {
                    et();
                }
            }
        }
    }

    public void O(String str) {
        if (this.sG != null) {
            Cursor cursor = null;
            try {
                this.sG.ey();
                cursor = d(this.sD.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sP = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sR = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sS = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sT = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sG.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                eu();
            } catch (Throwable th) {
                try {
                    this.sD.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sG.ez();
                }
            }
        }
    }

    public void P(String str) {
        if (this.sF != null) {
            Cursor cursor = null;
            try {
                this.sF.eA();
                cursor = d(this.sD.ch(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.sP = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.sR = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.sS = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.sT = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sF.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                eu();
            } catch (Throwable th) {
                try {
                    this.sD.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.sF.eB();
                }
            }
        }
    }

    protected void eu() {
        String removeFirst;
        if (!this.sI.isEmpty()) {
            SQLiteDatabase ch = this.sD.ch();
            ch.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sJ) {
                        if (!this.sI.isEmpty()) {
                            removeFirst = this.sI.removeFirst();
                        } else {
                            ch.setTransactionSuccessful();
                            this.sH = 0;
                            return;
                        }
                    }
                    ch.delete(this.sE, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sD.a(th, "performCleanup");
                        return;
                    } finally {
                        ch.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ev() {
        return this.sD;
    }
}
