package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b sZ;
    protected String tb;
    protected f.b tc;
    protected f.a td;
    protected int te;
    protected LinkedList<String> tf = new LinkedList<>();
    private Object tg = new Object();

    public abstract String M(String str);

    protected abstract boolean N(String str);

    protected abstract ContentValues a(h<T> hVar);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract h<T> c(SQLiteDatabase sQLiteDatabase, String str);

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gg();

    public c(com.baidu.adp.base.a.b bVar) {
        this.sZ = bVar;
    }

    public void a(f fVar, String str) {
        this.tb = str;
        if (fVar instanceof f.b) {
            this.tc = (f.b) fVar;
        }
        if (fVar instanceof f.a) {
            this.td = (f.a) fVar;
        }
    }

    public h<T> O(String str) {
        try {
            return c(this.sZ.dO(), str);
        } catch (Throwable th) {
            this.sZ.d(th, "get");
            return null;
        }
    }

    public void b(h<T> hVar) {
        String e;
        try {
            synchronized (this.tg) {
                this.tf.remove(hVar.tm);
            }
            ContentValues a = a(hVar);
            SQLiteDatabase dO = this.sZ.dO();
            if (dO.update(this.tb, a, "m_key = ?", new String[]{hVar.tm}) == 0) {
                dO.insert(this.tb, null, a);
                if (this.td != null) {
                    gh();
                }
            }
            if (this.tc != null && (e = this.tc.e(hVar)) != null) {
                P(e);
            }
        } catch (Throwable th) {
            this.sZ.d(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gh() {
        if (this.td != null) {
            this.te++;
            if (this.te >= ((int) Math.min(this.td.getMaxSize() * 0.2d, 5.0d))) {
                this.te = 0;
                com.baidu.adp.lib.h.k.hs().c(new d(this));
            }
        }
    }

    public int P(String str) {
        try {
            return this.sZ.dO().delete(this.tb, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.sZ.d(th, "deleteCacheItem");
            return 0;
        }
    }

    public void Q(String str) {
        this.te = 0;
        synchronized (this.tg) {
            this.tf.clear();
        }
        if (N(str)) {
            BdCacheService.gs().gt().ac(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.tg) {
            if (!this.tf.contains(str)) {
                this.tf.addLast(str);
                if (z) {
                    gh();
                }
            }
        }
    }

    public void R(String str) {
        if (this.td != null) {
            Cursor cursor = null;
            try {
                this.td.gm();
                cursor = d(this.sZ.dO(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tm = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tq = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tr = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.ts = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.td.d(hVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                gi();
            } catch (Throwable th) {
                try {
                    this.sZ.d(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.h.a.b(cursor);
                    this.td.gn();
                }
            }
        }
    }

    public void S(String str) {
        if (this.tc != null) {
            Cursor cursor = null;
            try {
                this.tc.go();
                cursor = d(this.sZ.dO(), str);
                while (cursor.moveToNext()) {
                    h<?> hVar = new h<>();
                    hVar.tm = cursor.getString(cursor.getColumnIndex("m_key"));
                    hVar.tq = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    hVar.tr = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    hVar.ts = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.tc.f(hVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                gi();
            } catch (Throwable th) {
                try {
                    this.sZ.d(th, "performPump");
                } finally {
                    com.baidu.adp.lib.h.a.b(cursor);
                    this.tc.gp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gi() {
        String removeFirst;
        if (!this.tf.isEmpty()) {
            SQLiteDatabase dO = this.sZ.dO();
            dO.beginTransaction();
            while (true) {
                try {
                    synchronized (this.tg) {
                        if (!this.tf.isEmpty()) {
                            removeFirst = this.tf.removeFirst();
                        } else {
                            dO.setTransactionSuccessful();
                            this.te = 0;
                            return;
                        }
                    }
                    dO.delete(this.tb, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.sZ.d(th, "performCleanup");
                        return;
                    } finally {
                        dO.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b gj() {
        return this.sZ;
    }
}
