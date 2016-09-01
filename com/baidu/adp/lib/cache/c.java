package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b lQ;
    protected String lR;
    protected f.b lS;
    protected f.a lT;
    protected int lU;
    protected LinkedList<String> lV = new LinkedList<>();
    private Object lW = new Object();

    public abstract String G(String str);

    protected abstract boolean H(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int dp();

    public c(com.baidu.adp.base.a.b bVar) {
        this.lQ = bVar;
    }

    public void a(f fVar, String str) {
        this.lR = str;
        if (fVar instanceof f.b) {
            this.lS = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.lT = (f.a) fVar;
        }
    }

    public h<T> I(String str) {
        try {
            return c(this.lQ.aZ(), str);
        } catch (Throwable th) {
            this.lQ.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.lW) {
                this.lV.remove(hVar.mc);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase aZ = this.lQ.aZ();
            if (aZ.update(this.lR, a, "m_key = ?", new String[]{hVar.mc}) == 0) {
                aZ.insert(this.lR, null, a);
                if (this.lT != null) {
                    dq();
                }
            }
            if (this.lS != null && (e = this.lS.e(hVar)) != null) {
                J(e);
            }
        } catch (Throwable th) {
            this.lQ.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void dq() {
        if (this.lT != null) {
            this.lU++;
            if (this.lU >= ((int) Math.min(this.lT.getMaxSize() * 0.2d, 5.0d))) {
                this.lU = 0;
                com.baidu.adp.lib.h.k.eH().f(new d(this));
            }
        }
    }

    public int J(String str) {
        try {
            return this.lQ.aZ().delete(this.lR, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.lQ.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void K(String str) {
        this.lU = 0;
        synchronized (this.lW) {
            this.lV.clear();
        }
        if (H(str)) {
            BdCacheService.dB().dC().W(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.lW) {
            if (!this.lV.contains(str)) {
                this.lV.addLast(str);
                if (z) {
                    dq();
                }
            }
        }
    }

    public void L(String str) {
        if (this.lT != null) {
            Cursor cursor = null;
            try {
                this.lT.dv();
                cursor = d(this.lQ.aZ(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.mc = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.mf = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.mg = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.mh = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.lT.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                dr();
            } catch (Throwable th) {
                try {
                    this.lQ.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.lT.dw();
                }
            }
        }
    }

    public void M(String str) {
        if (this.lS != null) {
            Cursor cursor = null;
            try {
                this.lS.dx();
                cursor = d(this.lQ.aZ(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.mc = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.mf = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.mg = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.mh = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.lS.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                dr();
            } catch (Throwable th) {
                try {
                    this.lQ.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.lS.dy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dr() {
        String removeFirst;
        if (!this.lV.isEmpty()) {
            SQLiteDatabase aZ = this.lQ.aZ();
            aZ.beginTransaction();
            while (true) {
                try {
                    synchronized (this.lW) {
                        if (!this.lV.isEmpty()) {
                            removeFirst = this.lV.removeFirst();
                        } else {
                            aZ.setTransactionSuccessful();
                            this.lU = 0;
                            return;
                        }
                    }
                    aZ.delete(this.lR, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.lQ.d(th, "performCleanup");
                        return;
                    } finally {
                        aZ.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ds() {
        return this.lQ;
    }
}
