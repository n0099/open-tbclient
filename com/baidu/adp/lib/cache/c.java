package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sQ;
    protected String sR;
    protected f.b sS;
    protected f.a sT;
    protected int sU;
    protected LinkedList<String> sV = new LinkedList<>();
    private Object sW = new Object();

    public abstract String N(String str);

    protected abstract boolean O(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int fX();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sQ = bVar;
    }

    public void a(f fVar, String str) {
        this.sR = str;
        if (fVar instanceof f.b) {
            this.sS = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.sT = (f.a) fVar;
        }
    }

    public h<T> P(String str) {
        try {
            return c(this.sQ.dL(), str);
        } catch (Throwable th) {
            this.sQ.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.sW) {
                this.sV.remove(hVar.td);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase dL = this.sQ.dL();
            if (dL.update(this.sR, a, "m_key = ?", new String[]{hVar.td}) == 0) {
                dL.insert(this.sR, null, a);
                if (this.sT != null) {
                    fY();
                }
            }
            if (this.sS != null && (e = this.sS.e(hVar)) != null) {
                Q(e);
            }
        } catch (Throwable th) {
            this.sQ.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void fY() {
        if (this.sT != null) {
            this.sU++;
            if (this.sU >= ((int) Math.min(this.sT.getMaxSize() * 0.2d, 5.0d))) {
                this.sU = 0;
                com.baidu.adp.lib.h.k.hk().c(new d(this));
            }
        }
    }

    public int Q(String str) {
        try {
            return this.sQ.dL().delete(this.sR, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sQ.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void R(String str) {
        this.sU = 0;
        synchronized (this.sW) {
            this.sV.clear();
        }
        if (O(str)) {
            BdCacheService.gk().gl().ad(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sW) {
            if (!this.sV.contains(str)) {
                this.sV.addLast(str);
                if (z) {
                    fY();
                }
            }
        }
    }

    public void S(String str) {
        if (this.sT != null) {
            Cursor cursor = null;
            try {
                this.sT.ge();
                cursor = d(this.sQ.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.td = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tf = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tg = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.th = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sT.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                fZ();
            } catch (Throwable th) {
                try {
                    this.sQ.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.b(cursor);
                    this.sT.gf();
                }
            }
        }
    }

    public void T(String str) {
        if (this.sS != null) {
            Cursor cursor = null;
            try {
                this.sS.gg();
                cursor = d(this.sQ.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.td = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tf = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tg = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.th = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sS.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                fZ();
            } catch (Throwable th) {
                try {
                    this.sQ.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.b(cursor);
                    this.sS.gh();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fZ() {
        String removeFirst;
        if (!this.sV.isEmpty()) {
            SQLiteDatabase dL = this.sQ.dL();
            dL.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sW) {
                        if (!this.sV.isEmpty()) {
                            removeFirst = this.sV.removeFirst();
                        } else {
                            dL.setTransactionSuccessful();
                            this.sU = 0;
                            return;
                        }
                    }
                    dL.delete(this.sR, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sQ.d(th, "performCleanup");
                        return;
                    } finally {
                        dL.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ga() {
        return this.sQ;
    }
}
