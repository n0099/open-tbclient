package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b lL;
    protected String lM;
    protected f.b lN;
    protected f.a lO;
    protected int lP;
    protected LinkedList<String> lQ = new LinkedList<>();
    private Object lR = new Object();

    public abstract String G(String str);

    protected abstract boolean H(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int dn();

    public c(com.baidu.adp.base.a.b bVar) {
        this.lL = bVar;
    }

    public void a(f fVar, String str) {
        this.lM = str;
        if (fVar instanceof f.b) {
            this.lN = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.lO = (f.a) fVar;
        }
    }

    public h<T> I(String str) {
        try {
            return c(this.lL.aZ(), str);
        } catch (Throwable th) {
            this.lL.a(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.lR) {
                this.lQ.remove(hVar.lX);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase aZ = this.lL.aZ();
            if (aZ.update(this.lM, a, "m_key = ?", new String[]{hVar.lX}) == 0) {
                aZ.insert(this.lM, null, a);
                if (this.lO != null) {
                    m4do();
                }
            }
            if (this.lN != null && (e = this.lN.e(hVar)) != null) {
                J(e);
            }
        } catch (Throwable th) {
            this.lL.a(th, "addOrUpdateTextCacheItem");
        }
    }

    /* renamed from: do  reason: not valid java name */
    protected void m4do() {
        if (this.lO != null) {
            this.lP++;
            if (this.lP >= ((int) Math.min(this.lO.getMaxSize() * 0.2d, 5.0d))) {
                this.lP = 0;
                com.baidu.adp.lib.g.k.eF().f(new d(this));
            }
        }
    }

    public int J(String str) {
        try {
            return this.lL.aZ().delete(this.lM, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.lL.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void K(String str) {
        this.lP = 0;
        synchronized (this.lR) {
            this.lQ.clear();
        }
        if (H(str)) {
            BdCacheService.dz().dA().W(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.lR) {
            if (!this.lQ.contains(str)) {
                this.lQ.addLast(str);
                if (z) {
                    m4do();
                }
            }
        }
    }

    public void L(String str) {
        if (this.lO != null) {
            Cursor cursor = null;
            try {
                this.lO.dt();
                cursor = d(this.lL.aZ(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.lX = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.lZ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.ma = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.mb = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.lO.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                dp();
            } catch (Throwable th) {
                try {
                    this.lL.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.lO.du();
                }
            }
        }
    }

    public void M(String str) {
        if (this.lN != null) {
            Cursor cursor = null;
            try {
                this.lN.dv();
                cursor = d(this.lL.aZ(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.lX = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.lZ = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.ma = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.mb = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.lN.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                dp();
            } catch (Throwable th) {
                try {
                    this.lL.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.lN.dw();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dp() {
        String removeFirst;
        if (!this.lQ.isEmpty()) {
            SQLiteDatabase aZ = this.lL.aZ();
            aZ.beginTransaction();
            while (true) {
                try {
                    synchronized (this.lR) {
                        if (!this.lQ.isEmpty()) {
                            removeFirst = this.lQ.removeFirst();
                        } else {
                            aZ.setTransactionSuccessful();
                            this.lP = 0;
                            return;
                        }
                    }
                    aZ.delete(this.lM, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.lL.a(th, "performCleanup");
                        return;
                    } finally {
                        aZ.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b dq() {
        return this.lL;
    }
}
