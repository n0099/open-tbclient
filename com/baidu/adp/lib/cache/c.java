package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sP;
    protected String sQ;
    protected f.b sR;
    protected f.a sS;
    protected int sT;
    protected LinkedList<String> sU = new LinkedList<>();
    private Object sV = new Object();

    public abstract String P(String str);

    protected abstract boolean Q(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int ga();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sP = bVar;
    }

    public void a(f fVar, String str) {
        this.sQ = str;
        if (fVar instanceof f.b) {
            this.sR = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.sS = (f.a) fVar;
        }
    }

    public h<T> R(String str) {
        try {
            return c(this.sP.dL(), str);
        } catch (Throwable th) {
            this.sP.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.sV) {
                this.sU.remove(hVar.tc);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase dL = this.sP.dL();
            if (dL.update(this.sQ, a, "m_key = ?", new String[]{hVar.tc}) == 0) {
                dL.insert(this.sQ, null, a);
                if (this.sS != null) {
                    gb();
                }
            }
            if (this.sR != null && (e = this.sR.e(hVar)) != null) {
                S(e);
            }
        } catch (Throwable th) {
            this.sP.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gb() {
        if (this.sS != null) {
            this.sT++;
            if (this.sT >= ((int) Math.min(this.sS.gg() * 0.2d, 5.0d))) {
                this.sT = 0;
                com.baidu.adp.lib.g.k.hj().c(new d(this));
            }
        }
    }

    public int S(String str) {
        try {
            return this.sP.dL().delete(this.sQ, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sP.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void T(String str) {
        this.sT = 0;
        synchronized (this.sV) {
            this.sU.clear();
        }
        if (Q(str)) {
            BdCacheService.go().gp().af(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sV) {
            if (!this.sU.contains(str)) {
                this.sU.addLast(str);
                if (z) {
                    gb();
                }
            }
        }
    }

    public void U(String str) {
        if (this.sS != null) {
            Cursor cursor = null;
            try {
                this.sS.gi();
                cursor = d(this.sP.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tc = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.te = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tf = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tg = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sS.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                gd();
            } catch (Throwable th) {
                try {
                    this.sP.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sS.gj();
                }
            }
        }
    }

    public void V(String str) {
        if (this.sR != null) {
            Cursor cursor = null;
            try {
                this.sR.gk();
                cursor = d(this.sP.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tc = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.te = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tf = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tg = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sR.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                gd();
            } catch (Throwable th) {
                try {
                    this.sP.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sR.gl();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gd() {
        String removeFirst;
        if (!this.sU.isEmpty()) {
            SQLiteDatabase dL = this.sP.dL();
            dL.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sV) {
                        if (!this.sU.isEmpty()) {
                            removeFirst = this.sU.removeFirst();
                        } else {
                            dL.setTransactionSuccessful();
                            this.sT = 0;
                            return;
                        }
                    }
                    dL.delete(this.sQ, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sP.a(th, "performCleanup");
                        return;
                    } finally {
                        dL.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ge() {
        return this.sP;
    }
}
