package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sN;
    protected String sO;
    protected f.b sP;
    protected f.a sQ;
    protected int sR;
    protected LinkedList<String> sS = new LinkedList<>();
    private Object sT = new Object();

    public abstract String P(String str);

    protected abstract boolean Q(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int fX();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sN = bVar;
    }

    public void a(f fVar, String str) {
        this.sO = str;
        if (fVar instanceof f.b) {
            this.sP = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.sQ = (f.a) fVar;
        }
    }

    public h<T> R(String str) {
        try {
            return c(this.sN.dL(), str);
        } catch (Throwable th) {
            this.sN.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.sT) {
                this.sS.remove(hVar.sZ);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase dL = this.sN.dL();
            if (dL.update(this.sO, a, "m_key = ?", new String[]{hVar.sZ}) == 0) {
                dL.insert(this.sO, null, a);
                if (this.sQ != null) {
                    fY();
                }
            }
            if (this.sP != null && (e = this.sP.e(hVar)) != null) {
                S(e);
            }
        } catch (Throwable th) {
            this.sN.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void fY() {
        if (this.sQ != null) {
            this.sR++;
            if (this.sR >= ((int) Math.min(this.sQ.gd() * 0.2d, 5.0d))) {
                this.sR = 0;
                com.baidu.adp.lib.g.k.hg().c(new d(this));
            }
        }
    }

    public int S(String str) {
        try {
            return this.sN.dL().delete(this.sO, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sN.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void T(String str) {
        this.sR = 0;
        synchronized (this.sT) {
            this.sS.clear();
        }
        if (Q(str)) {
            BdCacheService.gl().gm().af(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.sT) {
            if (!this.sS.contains(str)) {
                this.sS.addLast(str);
                if (z) {
                    fY();
                }
            }
        }
    }

    public void U(String str) {
        if (this.sQ != null) {
            Cursor cursor = null;
            try {
                this.sQ.gf();
                cursor = d(this.sN.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.sZ = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tc = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.td = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.te = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.sQ.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                fZ();
            } catch (Throwable th) {
                try {
                    this.sN.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sQ.gg();
                }
            }
        }
    }

    public void V(String str) {
        if (this.sP != null) {
            Cursor cursor = null;
            try {
                this.sP.gh();
                cursor = d(this.sN.dL(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.sZ = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tc = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.td = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.te = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.sP.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                fZ();
            } catch (Throwable th) {
                try {
                    this.sN.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                    this.sP.gi();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fZ() {
        String removeFirst;
        if (!this.sS.isEmpty()) {
            SQLiteDatabase dL = this.sN.dL();
            dL.beginTransaction();
            while (true) {
                try {
                    synchronized (this.sT) {
                        if (!this.sS.isEmpty()) {
                            removeFirst = this.sS.removeFirst();
                        } else {
                            dL.setTransactionSuccessful();
                            this.sR = 0;
                            return;
                        }
                    }
                    dL.delete(this.sO, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sN.a(th, "performCleanup");
                        return;
                    } finally {
                        dL.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ga() {
        return this.sN;
    }
}
