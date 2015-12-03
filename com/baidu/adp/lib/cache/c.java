package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sO;
    protected String sP;
    protected f.b sQ;
    protected f.a sR;
    protected int sS;
    protected LinkedList<String> sT = new LinkedList<>();
    private Object sU = new Object();

    public abstract String N(String str);

    protected abstract boolean O(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int fX();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sO = bVar;
    }

    public void a(f fVar, String str) {
        this.sP = str;
        if (fVar instanceof f.b) {
            this.sQ = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.sR = (f.a) fVar;
        }
    }

    public h<T> P(String str) {
        try {
            return c(this.sO.dL(), str);
        } catch (Throwable th) {
            this.sO.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.sU) {
                this.sT.remove(hVar.tb);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase dL = this.sO.dL();
            if (dL.update(this.sP, a, "m_key = ?", new String[]{hVar.tb}) == 0) {
                dL.insert(this.sP, null, a);
                if (this.sR != null) {
                    fY();
                }
            }
            if (this.sQ != null && (e = this.sQ.e(hVar)) != null) {
                Q(e);
            }
        } catch (Throwable th) {
            this.sO.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void fY() {
        if (this.sR != null) {
            this.sS++;
            if (this.sS >= ((int) Math.min(this.sR.getMaxSize() * 0.2d, 5.0d))) {
                this.sS = 0;
                com.baidu.adp.lib.h.k.hk().c(new d(this));
            }
        }
    }

    public int Q(String str) {
        try {
            return this.sO.dL().delete(this.sP, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sO.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void R(String str) {
        this.sS = 0;
        synchronized (this.sU) {
            this.sT.clear();
        }
        if (O(str)) {
            BdCacheService.gk().gl().ad(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sU) {
            if (!this.sT.contains(str)) {
                this.sT.addLast(str);
                if (z) {
                    fY();
                }
            }
        }
    }

    public void S(String str) {
        if (this.sR != null) {
            Cursor cursor = null;
            try {
                this.sR.ge();
                cursor = d(this.sO.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tb = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.td = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.te = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tf = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sR.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                fZ();
            } catch (Throwable th) {
                try {
                    this.sO.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.b(cursor);
                    this.sR.gf();
                }
            }
        }
    }

    public void T(String str) {
        if (this.sQ != null) {
            Cursor cursor = null;
            try {
                this.sQ.gg();
                cursor = d(this.sO.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tb = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.td = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.te = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tf = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sQ.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                fZ();
            } catch (Throwable th) {
                try {
                    this.sO.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.b(cursor);
                    this.sQ.gh();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fZ() {
        String removeFirst;
        if (!this.sT.isEmpty()) {
            SQLiteDatabase dL = this.sO.dL();
            dL.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sU) {
                        if (!this.sT.isEmpty()) {
                            removeFirst = this.sT.removeFirst();
                        } else {
                            dL.setTransactionSuccessful();
                            this.sS = 0;
                            return;
                        }
                    }
                    dL.delete(this.sP, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sO.d(th, "performCleanup");
                        return;
                    } finally {
                        dL.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ga() {
        return this.sO;
    }
}
