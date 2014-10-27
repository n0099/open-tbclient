package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.c fi;
    protected String fj;
    protected h fk;
    protected g fl;
    protected int fm;
    protected LinkedList<String> fn = new LinkedList<>();
    private Object fo = new Object();

    protected abstract ContentValues a(m<T> mVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract m<T> b(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int ce();

    public abstract String r(String str);

    protected abstract boolean s(String str);

    public c(com.baidu.adp.base.a.c cVar) {
        this.fi = cVar;
    }

    public void a(f fVar, String str) {
        this.fj = str;
        if (fVar instanceof h) {
            this.fk = (h) fVar;
        }
        if (fVar instanceof g) {
            this.fl = (g) fVar;
        }
    }

    public m<T> t(String str) {
        try {
            return b(this.fi.P(), str);
        } catch (Throwable th) {
            this.fi.a(th, "get");
            return null;
        }
    }

    public void b(m<T> mVar) {
        String e;
        try {
            synchronized (this.fo) {
                this.fn.remove(mVar.fu);
            }
            ContentValues a = a(mVar);
            SQLiteDatabase P = this.fi.P();
            if (P.update(this.fj, a, "m_key = ?", new String[]{mVar.fu}) == 0) {
                P.insert(this.fj, null, a);
                if (this.fl != null) {
                    cf();
                }
            }
            if (this.fk != null && (e = this.fk.e(mVar)) != null) {
                u(e);
            }
        } catch (Throwable th) {
            this.fi.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void cf() {
        if (this.fl != null) {
            this.fm++;
            if (this.fm >= ((int) Math.min(this.fl.cj() * 0.2d, 5.0d))) {
                this.fm = 0;
                com.baidu.adp.lib.g.k.el().b(new d(this));
            }
        }
    }

    public int u(String str) {
        try {
            return this.fi.P().delete(this.fj, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.fi.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void x(String str) {
        this.fm = 0;
        synchronized (this.fo) {
            this.fn.clear();
        }
        if (s(str)) {
            BdCacheService.cr().cs().J(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.fo) {
            if (!this.fn.contains(str)) {
                this.fn.addLast(str);
                if (z) {
                    cf();
                }
            }
        }
    }

    public void y(String str) {
        if (this.fl != null) {
            Cursor cursor = null;
            try {
                this.fl.cl();
                cursor = c(this.fi.P(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.fu = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.fw = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.fx = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.fy = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.fl.d(mVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                cg();
            } catch (Throwable th) {
                try {
                    this.fi.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.fl.cm();
                }
            }
        }
    }

    public void z(String str) {
        if (this.fk != null) {
            Cursor cursor = null;
            try {
                this.fk.cn();
                cursor = c(this.fi.P(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.fu = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.fw = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.fx = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.fy = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.fk.f(mVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                cg();
            } catch (Throwable th) {
                try {
                    this.fi.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                    this.fk.co();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cg() {
        String removeFirst;
        if (!this.fn.isEmpty()) {
            SQLiteDatabase P = this.fi.P();
            P.beginTransaction();
            while (true) {
                try {
                    synchronized (this.fo) {
                        if (!this.fn.isEmpty()) {
                            removeFirst = this.fn.removeFirst();
                        } else {
                            P.setTransactionSuccessful();
                            this.fm = 0;
                            return;
                        }
                    }
                    P.delete(this.fj, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.fi.a(th, "performCleanup");
                        return;
                    } finally {
                        P.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.c ch() {
        return this.fi;
    }
}
