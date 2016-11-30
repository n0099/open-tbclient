package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b lR;
    protected String lS;
    protected f.b lT;
    protected f.a lU;
    protected int lV;
    protected LinkedList<String> lW = new LinkedList<>();
    private Object lX = new Object();

    public abstract String G(String str);

    protected abstract boolean H(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int dp();

    public c(com.baidu.adp.base.a.b bVar) {
        this.lR = bVar;
    }

    public void a(f fVar, String str) {
        this.lS = str;
        if (fVar instanceof f.b) {
            this.lT = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.lU = (f.a) fVar;
        }
    }

    public h<T> I(String str) {
        try {
            return c(this.lR.aZ(), str);
        } catch (Throwable th) {
            this.lR.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.lX) {
                this.lW.remove(hVar.md);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase aZ = this.lR.aZ();
            if (aZ.update(this.lS, a, "m_key = ?", new String[]{hVar.md}) == 0) {
                aZ.insert(this.lS, null, a);
                if (this.lU != null) {
                    dq();
                }
            }
            if (this.lT != null && (e = this.lT.e(hVar)) != null) {
                J(e);
            }
        } catch (Throwable th) {
            this.lR.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void dq() {
        if (this.lU != null) {
            this.lV++;
            if (this.lV >= ((int) Math.min(this.lU.getMaxSize() * 0.2d, 5.0d))) {
                this.lV = 0;
                com.baidu.adp.lib.h.k.eH().f(new d(this));
            }
        }
    }

    public int J(String str) {
        try {
            return this.lR.aZ().delete(this.lS, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.lR.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void K(String str) {
        this.lV = 0;
        synchronized (this.lX) {
            this.lW.clear();
        }
        if (H(str)) {
            BdCacheService.dB().dC().W(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.lX) {
            if (!this.lW.contains(str)) {
                this.lW.addLast(str);
                if (z) {
                    dq();
                }
            }
        }
    }

    public void L(String str) {
        if (this.lU != null) {
            Cursor cursor = null;
            try {
                this.lU.dv();
                cursor = d(this.lR.aZ(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.md = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.mg = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.mh = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.mi = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.lU.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                dr();
            } catch (Throwable th) {
                try {
                    this.lR.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.lU.dw();
                }
            }
        }
    }

    public void M(String str) {
        if (this.lT != null) {
            Cursor cursor = null;
            try {
                this.lT.dx();
                cursor = d(this.lR.aZ(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.md = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.mg = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.mh = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.mi = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.lT.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                dr();
            } catch (Throwable th) {
                try {
                    this.lR.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.lT.dy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dr() {
        String removeFirst;
        if (!this.lW.isEmpty()) {
            SQLiteDatabase aZ = this.lR.aZ();
            aZ.beginTransaction();
            while (true) {
                try {
                    synchronized (this.lX) {
                        if (!this.lW.isEmpty()) {
                            removeFirst = this.lW.removeFirst();
                        } else {
                            aZ.setTransactionSuccessful();
                            this.lV = 0;
                            return;
                        }
                    }
                    aZ.delete(this.lS, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.lR.a(th, "performCleanup");
                        return;
                    } finally {
                        aZ.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ds() {
        return this.lR;
    }
}
