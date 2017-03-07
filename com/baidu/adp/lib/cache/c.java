package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b tG;
    protected String tH;
    protected f.b tI;
    protected f.a tJ;
    protected int tK;
    protected LinkedList<String> tL = new LinkedList<>();
    private Object tM = new Object();

    public abstract String F(String str);

    protected abstract boolean G(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int ew();

    public c(com.baidu.adp.base.a.b bVar) {
        this.tG = bVar;
    }

    public void a(f fVar, String str) {
        this.tH = str;
        if (fVar instanceof f.b) {
            this.tI = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.tJ = (f.a) fVar;
        }
    }

    public h<T> H(String str) {
        try {
            return c(this.tG.ci(), str);
        } catch (Throwable th) {
            this.tG.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.tM) {
                this.tL.remove(hVar.tS);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase ci = this.tG.ci();
            if (ci.update(this.tH, a, "m_key = ?", new String[]{hVar.tS}) == 0) {
                ci.insert(this.tH, null, a);
                if (this.tJ != null) {
                    ex();
                }
            }
            if (this.tI != null && (e = this.tI.e(hVar)) != null) {
                I(e);
            }
        } catch (Throwable th) {
            this.tG.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void ex() {
        if (this.tJ != null) {
            this.tK++;
            if (this.tK >= ((int) Math.min(this.tJ.getMaxSize() * 0.2d, 5.0d))) {
                this.tK = 0;
                com.baidu.adp.lib.g.k.fN().f(new d(this));
            }
        }
    }

    public int I(String str) {
        try {
            return this.tG.ci().delete(this.tH, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.tG.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void J(String str) {
        this.tK = 0;
        synchronized (this.tM) {
            this.tL.clear();
        }
        if (G(str)) {
            BdCacheService.eI().eJ().V(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.tM) {
            if (!this.tL.contains(str)) {
                this.tL.addLast(str);
                if (z) {
                    ex();
                }
            }
        }
    }

    public void K(String str) {
        if (this.tJ != null) {
            Cursor cursor = null;
            try {
                this.tJ.eC();
                cursor = d(this.tG.ci(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tS = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tU = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tV = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tW = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.tJ.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                ey();
            } catch (Throwable th) {
                try {
                    this.tG.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.tJ.eD();
                }
            }
        }
    }

    public void L(String str) {
        if (this.tI != null) {
            Cursor cursor = null;
            try {
                this.tI.eE();
                cursor = d(this.tG.ci(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tS = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tU = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tV = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tW = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.tI.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                ey();
            } catch (Throwable th) {
                try {
                    this.tG.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.tI.eF();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ey() {
        String removeFirst;
        if (!this.tL.isEmpty()) {
            SQLiteDatabase ci = this.tG.ci();
            ci.beginTransaction();
            while (true) {
                try {
                    synchronized (this.tM) {
                        if (!this.tL.isEmpty()) {
                            removeFirst = this.tL.removeFirst();
                        } else {
                            ci.setTransactionSuccessful();
                            this.tK = 0;
                            return;
                        }
                    }
                    ci.delete(this.tH, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.tG.a(th, "performCleanup");
                        return;
                    } finally {
                        ci.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ez() {
        return this.tG;
    }
}
