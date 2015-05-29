package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.c sS;
    protected String sT;
    protected h sU;
    protected g sV;
    protected int sW;
    protected LinkedList<String> sX = new LinkedList<>();
    private Object sY = new Object();

    public abstract String Q(String str);

    protected abstract boolean R(String str);

    protected abstract ContentValues a(m<T> mVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract m<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gg();

    public c(com.baidu.adp.base.a.c cVar) {
        this.sS = cVar;
    }

    public void a(f fVar, String str) {
        this.sT = str;
        if (fVar instanceof h) {
            this.sU = (h) fVar;
        }
        if (fVar instanceof g) {
            this.sV = (g) fVar;
        }
    }

    public m<T> S(String str) {
        try {
            return c(this.sS.dK(), str);
        } catch (Throwable th) {
            this.sS.a(th, "get");
            return null;
        }
    }

    public void b(m<T> mVar) {
        String e;
        try {
            synchronized (this.sY) {
                this.sX.remove(mVar.tf);
            }
            ContentValues a = a(mVar);
            SQLiteDatabase dK = this.sS.dK();
            if (dK.update(this.sT, a, "m_key = ?", new String[]{mVar.tf}) == 0) {
                dK.insert(this.sT, null, a);
                if (this.sV != null) {
                    gh();
                }
            }
            if (this.sU != null && (e = this.sU.e(mVar)) != null) {
                T(e);
            }
        } catch (Throwable th) {
            this.sS.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gh() {
        if (this.sV != null) {
            this.sW++;
            if (this.sW >= ((int) Math.min(this.sV.gl() * 0.2d, 5.0d))) {
                this.sW = 0;
                com.baidu.adp.lib.g.l.ht().c(new d(this));
            }
        }
    }

    public int T(String str) {
        try {
            return this.sS.dK().delete(this.sT, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sS.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void U(String str) {
        this.sW = 0;
        synchronized (this.sY) {
            this.sX.clear();
        }
        if (R(str)) {
            BdCacheService.gt().gu().ag(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sY) {
            if (!this.sX.contains(str)) {
                this.sX.addLast(str);
                if (z) {
                    gh();
                }
            }
        }
    }

    public void V(String str) {
        if (this.sV != null) {
            Cursor cursor = null;
            try {
                this.sV.gn();
                cursor = d(this.sS.dK(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.tf = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.th = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.ti = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.tj = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sV.d(mVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                gi();
            } catch (Throwable th) {
                try {
                    this.sS.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sV.go();
                }
            }
        }
    }

    public void W(String str) {
        if (this.sU != null) {
            Cursor cursor = null;
            try {
                this.sU.gp();
                cursor = d(this.sS.dK(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.tf = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.th = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.ti = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.tj = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sU.f(mVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                gi();
            } catch (Throwable th) {
                try {
                    this.sS.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sU.gq();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gi() {
        String removeFirst;
        if (!this.sX.isEmpty()) {
            SQLiteDatabase dK = this.sS.dK();
            dK.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sY) {
                        if (!this.sX.isEmpty()) {
                            removeFirst = this.sX.removeFirst();
                        } else {
                            dK.setTransactionSuccessful();
                            this.sW = 0;
                            return;
                        }
                    }
                    dK.delete(this.sT, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sS.a(th, "performCleanup");
                        return;
                    } finally {
                        dK.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.c gj() {
        return this.sS;
    }
}
