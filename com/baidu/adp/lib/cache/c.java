package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b tj;
    protected String tk;
    protected f.b tl;
    protected f.a tm;
    protected int tp;
    protected LinkedList<String> tq = new LinkedList<>();
    private Object tr = new Object();

    public abstract String M(String str);

    protected abstract boolean N(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gg();

    public c(com.baidu.adp.base.a.b bVar) {
        this.tj = bVar;
    }

    public void a(f fVar, String str) {
        this.tk = str;
        if (fVar instanceof f.b) {
            this.tl = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.tm = (f.a) fVar;
        }
    }

    public h<T> O(String str) {
        try {
            return c(this.tj.dO(), str);
        } catch (Throwable th) {
            this.tj.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.tr) {
                this.tq.remove(hVar.tx);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase dO = this.tj.dO();
            if (dO.update(this.tk, a, "m_key = ?", new String[]{hVar.tx}) == 0) {
                dO.insert(this.tk, null, a);
                if (this.tm != null) {
                    gh();
                }
            }
            if (this.tl != null && (e = this.tl.e(hVar)) != null) {
                P(e);
            }
        } catch (Throwable th) {
            this.tj.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gh() {
        if (this.tm != null) {
            this.tp++;
            if (this.tp >= ((int) Math.min(this.tm.getMaxSize() * 0.2d, 5.0d))) {
                this.tp = 0;
                com.baidu.adp.lib.h.k.hy().c(new d(this));
            }
        }
    }

    public int P(String str) {
        try {
            return this.tj.dO().delete(this.tk, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.tj.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void Q(String str) {
        this.tp = 0;
        synchronized (this.tr) {
            this.tq.clear();
        }
        if (N(str)) {
            BdCacheService.gs().gt().ac(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.tr) {
            if (!this.tq.contains(str)) {
                this.tq.addLast(str);
                if (z) {
                    gh();
                }
            }
        }
    }

    public void R(String str) {
        if (this.tm != null) {
            Cursor cursor = null;
            try {
                this.tm.gm();
                cursor = d(this.tj.dO(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tx = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tz = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tA = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tB = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.tm.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                gi();
            } catch (Throwable th) {
                try {
                    this.tj.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.tm.gn();
                }
            }
        }
    }

    public void S(String str) {
        if (this.tl != null) {
            Cursor cursor = null;
            try {
                this.tl.go();
                cursor = d(this.tj.dO(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tx = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tz = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tA = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.tB = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.tl.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                gi();
            } catch (Throwable th) {
                try {
                    this.tj.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                    this.tl.gp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gi() {
        String removeFirst;
        if (!this.tq.isEmpty()) {
            SQLiteDatabase dO = this.tj.dO();
            dO.beginTransaction();
            while (true) {
                try {
                    synchronized (this.tr) {
                        if (!this.tq.isEmpty()) {
                            removeFirst = this.tq.removeFirst();
                        } else {
                            dO.setTransactionSuccessful();
                            this.tp = 0;
                            return;
                        }
                    }
                    dO.delete(this.tk, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.tj.d(th, "performCleanup");
                        return;
                    } finally {
                        dO.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b gj() {
        return this.tj;
    }
}
