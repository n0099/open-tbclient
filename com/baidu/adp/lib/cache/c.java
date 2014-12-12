package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.c hk;
    protected String hl;
    protected h hm;
    protected g hn;
    protected int ho;
    protected LinkedList<String> hp = new LinkedList<>();
    private Object hq = new Object();

    public abstract String G(String str);

    protected abstract boolean I(String str);

    protected abstract ContentValues a(m<T> mVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract m<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int cF();

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public c(com.baidu.adp.base.a.c cVar) {
        this.hk = cVar;
    }

    public void a(f fVar, String str) {
        this.hl = str;
        if (fVar instanceof h) {
            this.hm = (h) fVar;
        }
        if (fVar instanceof g) {
            this.hn = (g) fVar;
        }
    }

    public m<T> J(String str) {
        try {
            return c(this.hk.ak(), str);
        } catch (Throwable th) {
            this.hk.a(th, "get");
            return null;
        }
    }

    public void b(m<T> mVar) {
        String e;
        try {
            synchronized (this.hq) {
                this.hp.remove(mVar.hw);
            }
            ContentValues a = a(mVar);
            SQLiteDatabase ak = this.hk.ak();
            if (ak.update(this.hl, a, "m_key = ?", new String[]{mVar.hw}) == 0) {
                ak.insert(this.hl, null, a);
                if (this.hn != null) {
                    cG();
                }
            }
            if (this.hm != null && (e = this.hm.e(mVar)) != null) {
                K(e);
            }
        } catch (Throwable th) {
            this.hk.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void cG() {
        if (this.hn != null) {
            this.ho++;
            if (this.ho >= ((int) Math.min(this.hn.cK() * 0.2d, 5.0d))) {
                this.ho = 0;
                com.baidu.adp.lib.g.l.em().c(new d(this));
            }
        }
    }

    public int K(String str) {
        try {
            return this.hk.ak().delete(this.hl, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.hk.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void L(String str) {
        this.ho = 0;
        synchronized (this.hq) {
            this.hp.clear();
        }
        if (I(str)) {
            BdCacheService.cS().cT().X(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.hq) {
            if (!this.hp.contains(str)) {
                this.hp.addLast(str);
                if (z) {
                    cG();
                }
            }
        }
    }

    public void M(String str) {
        if (this.hn != null) {
            Cursor cursor = null;
            try {
                this.hn.cM();
                cursor = d(this.hk.ak(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.hw = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.hy = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.hz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.hA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.hn.d(mVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                cH();
            } catch (Throwable th) {
                try {
                    this.hk.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.hn.cN();
                }
            }
        }
    }

    public void N(String str) {
        if (this.hm != null) {
            Cursor cursor = null;
            try {
                this.hm.cO();
                cursor = d(this.hk.ak(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.hw = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.hy = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.hz = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.hA = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.hm.f(mVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                cH();
            } catch (Throwable th) {
                try {
                    this.hk.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.hm.cP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cH() {
        String removeFirst;
        if (!this.hp.isEmpty()) {
            SQLiteDatabase ak = this.hk.ak();
            ak.beginTransaction();
            while (true) {
                try {
                    synchronized (this.hq) {
                        if (!this.hp.isEmpty()) {
                            removeFirst = this.hp.removeFirst();
                        } else {
                            ak.setTransactionSuccessful();
                            this.ho = 0;
                            return;
                        }
                    }
                    ak.delete(this.hl, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.hk.a(th, "performCleanup");
                        return;
                    } finally {
                        ak.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.c cI() {
        return this.hk;
    }
}
