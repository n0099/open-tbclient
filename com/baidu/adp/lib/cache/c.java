package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.c sH;
    protected String sI;
    protected h sJ;
    protected g sK;
    protected int sL;
    protected LinkedList<String> sM = new LinkedList<>();
    private Object sN = new Object();

    public abstract String O(String str);

    protected abstract boolean P(String str);

    protected abstract ContentValues a(m<T> mVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract m<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gb();

    public c(com.baidu.adp.base.a.c cVar) {
        this.sH = cVar;
    }

    public void a(f fVar, String str) {
        this.sI = str;
        if (fVar instanceof h) {
            this.sJ = (h) fVar;
        }
        if (fVar instanceof g) {
            this.sK = (g) fVar;
        }
    }

    public m<T> Q(String str) {
        try {
            return c(this.sH.dI(), str);
        } catch (Throwable th) {
            this.sH.a(th, "get");
            return null;
        }
    }

    public void b(m<T> mVar) {
        String e;
        try {
            synchronized (this.sN) {
                this.sM.remove(mVar.sT);
            }
            ContentValues a = a(mVar);
            SQLiteDatabase dI = this.sH.dI();
            if (dI.update(this.sI, a, "m_key = ?", new String[]{mVar.sT}) == 0) {
                dI.insert(this.sI, null, a);
                if (this.sK != null) {
                    gd();
                }
            }
            if (this.sJ != null && (e = this.sJ.e(mVar)) != null) {
                R(e);
            }
        } catch (Throwable th) {
            this.sH.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gd() {
        if (this.sK != null) {
            this.sL++;
            if (this.sL >= ((int) Math.min(this.sK.gh() * 0.2d, 5.0d))) {
                this.sL = 0;
                com.baidu.adp.lib.g.l.hJ().c(new d(this));
            }
        }
    }

    public int R(String str) {
        try {
            return this.sH.dI().delete(this.sI, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sH.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void S(String str) {
        this.sL = 0;
        synchronized (this.sN) {
            this.sM.clear();
        }
        if (P(str)) {
            BdCacheService.gp().gq().ae(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sN) {
            if (!this.sM.contains(str)) {
                this.sM.addLast(str);
                if (z) {
                    gd();
                }
            }
        }
    }

    public void T(String str) {
        if (this.sK != null) {
            Cursor cursor = null;
            try {
                this.sK.gj();
                cursor = d(this.sH.dI(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.sT = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.sV = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.sW = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.sX = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sK.d(mVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ge();
            } catch (Throwable th) {
                try {
                    this.sH.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sK.gk();
                }
            }
        }
    }

    public void U(String str) {
        if (this.sJ != null) {
            Cursor cursor = null;
            try {
                this.sJ.gl();
                cursor = d(this.sH.dI(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.sT = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.sV = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.sW = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.sX = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sJ.f(mVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ge();
            } catch (Throwable th) {
                try {
                    this.sH.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sJ.gm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ge() {
        String removeFirst;
        if (!this.sM.isEmpty()) {
            SQLiteDatabase dI = this.sH.dI();
            dI.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sN) {
                        if (!this.sM.isEmpty()) {
                            removeFirst = this.sM.removeFirst();
                        } else {
                            dI.setTransactionSuccessful();
                            this.sL = 0;
                            return;
                        }
                    }
                    dI.delete(this.sI, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sH.a(th, "performCleanup");
                        return;
                    } finally {
                        dI.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.c gf() {
        return this.sH;
    }
}
