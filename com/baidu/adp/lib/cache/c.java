package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.c hm;
    protected String hn;
    protected h ho;
    protected g hp;
    protected int hq;
    protected LinkedList<String> hr = new LinkedList<>();
    private Object hs = new Object();

    public abstract String G(String str);

    protected abstract boolean I(String str);

    protected abstract ContentValues a(m<T> mVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract m<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int cD();

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public c(com.baidu.adp.base.a.c cVar) {
        this.hm = cVar;
    }

    public void a(f fVar, String str) {
        this.hn = str;
        if (fVar instanceof h) {
            this.ho = (h) fVar;
        }
        if (fVar instanceof g) {
            this.hp = (g) fVar;
        }
    }

    public m<T> J(String str) {
        try {
            return c(this.hm.ak(), str);
        } catch (Throwable th) {
            this.hm.a(th, "get");
            return null;
        }
    }

    public void b(m<T> mVar) {
        String e;
        try {
            synchronized (this.hs) {
                this.hr.remove(mVar.hy);
            }
            ContentValues a = a(mVar);
            SQLiteDatabase ak = this.hm.ak();
            if (ak.update(this.hn, a, "m_key = ?", new String[]{mVar.hy}) == 0) {
                ak.insert(this.hn, null, a);
                if (this.hp != null) {
                    cE();
                }
            }
            if (this.ho != null && (e = this.ho.e(mVar)) != null) {
                K(e);
            }
        } catch (Throwable th) {
            this.hm.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void cE() {
        if (this.hp != null) {
            this.hq++;
            if (this.hq >= ((int) Math.min(this.hp.cI() * 0.2d, 5.0d))) {
                this.hq = 0;
                com.baidu.adp.lib.g.l.ek().c(new d(this));
            }
        }
    }

    public int K(String str) {
        try {
            return this.hm.ak().delete(this.hn, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.hm.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void L(String str) {
        this.hq = 0;
        synchronized (this.hs) {
            this.hr.clear();
        }
        if (I(str)) {
            BdCacheService.cQ().cR().X(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.hs) {
            if (!this.hr.contains(str)) {
                this.hr.addLast(str);
                if (z) {
                    cE();
                }
            }
        }
    }

    public void M(String str) {
        if (this.hp != null) {
            Cursor cursor = null;
            try {
                this.hp.cK();
                cursor = d(this.hm.ak(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.hy = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.hA = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.hB = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.hC = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.hp.d(mVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                cF();
            } catch (Throwable th) {
                try {
                    this.hm.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.hp.cL();
                }
            }
        }
    }

    public void N(String str) {
        if (this.ho != null) {
            Cursor cursor = null;
            try {
                this.ho.cM();
                cursor = d(this.hm.ak(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.hy = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.hA = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.hB = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.hC = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.ho.f(mVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                cF();
            } catch (Throwable th) {
                try {
                    this.hm.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.ho.cN();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cF() {
        String removeFirst;
        if (!this.hr.isEmpty()) {
            SQLiteDatabase ak = this.hm.ak();
            ak.beginTransaction();
            while (true) {
                try {
                    synchronized (this.hs) {
                        if (!this.hr.isEmpty()) {
                            removeFirst = this.hr.removeFirst();
                        } else {
                            ak.setTransactionSuccessful();
                            this.hq = 0;
                            return;
                        }
                    }
                    ak.delete(this.hn, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.hm.a(th, "performCleanup");
                        return;
                    } finally {
                        ak.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.c cG() {
        return this.hm;
    }
}
