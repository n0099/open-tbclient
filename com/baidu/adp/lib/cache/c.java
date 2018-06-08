package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected e.a xA;
    protected int xB;
    protected LinkedList<String> xC = new LinkedList<>();
    private Object xD = new Object();
    protected final com.baidu.adp.base.a.b xx;
    protected String xy;
    protected e.b xz;

    protected abstract ContentValues a(g<T> gVar);

    public abstract String aa(String str);

    protected abstract boolean ab(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int gS();

    public c(com.baidu.adp.base.a.b bVar) {
        this.xx = bVar;
    }

    public void a(e eVar, String str) {
        this.xy = str;
        if (eVar instanceof e.b) {
            this.xz = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.xA = (e.a) eVar;
        }
    }

    public g<T> ac(String str) {
        try {
            return c(this.xx.eE(), str);
        } catch (Throwable th) {
            this.xx.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.xD) {
                this.xC.remove(gVar.xJ);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase eE = this.xx.eE();
            if (eE.update(this.xy, a, "m_key = ?", new String[]{gVar.xJ}) == 0) {
                eE.insert(this.xy, null, a);
                if (this.xA != null) {
                    gT();
                }
            }
            if (this.xz != null && (e = this.xz.e(gVar)) != null) {
                ad(e);
            }
        } catch (Throwable th) {
            this.xx.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void gT() {
        if (this.xA != null) {
            this.xB++;
            if (this.xB >= ((int) Math.min(this.xA.getMaxSize() * 0.2d, 5.0d))) {
                this.xB = 0;
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gU();
                    }
                });
            }
        }
    }

    public int ad(String str) {
        try {
            return this.xx.eE().delete(this.xy, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.xx.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void ae(String str) {
        this.xB = 0;
        synchronized (this.xD) {
            this.xC.clear();
        }
        if (ab(str)) {
            BdCacheService.he().hf().aq(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.xD) {
            if (!this.xC.contains(str)) {
                this.xC.addLast(str);
                if (z) {
                    gT();
                }
            }
        }
    }

    public void af(String str) {
        if (this.xA != null) {
            Cursor cursor = null;
            try {
                this.xA.gY();
                cursor = d(this.xx.eE(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xJ = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xL = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xM = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xN = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.xA.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                gU();
            } catch (Throwable th) {
                try {
                    this.xx.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xA.gZ();
                }
            }
        }
    }

    public void ag(String str) {
        if (this.xz != null) {
            Cursor cursor = null;
            try {
                this.xz.ha();
                cursor = d(this.xx.eE(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.xJ = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.xL = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.xM = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.xN = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.xz.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                gU();
            } catch (Throwable th) {
                try {
                    this.xx.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.xz.hb();
                }
            }
        }
    }

    protected void gU() {
        String removeFirst;
        if (!this.xC.isEmpty()) {
            SQLiteDatabase eE = this.xx.eE();
            eE.beginTransaction();
            while (true) {
                try {
                    synchronized (this.xD) {
                        if (!this.xC.isEmpty()) {
                            removeFirst = this.xC.removeFirst();
                        } else {
                            eE.setTransactionSuccessful();
                            this.xB = 0;
                            return;
                        }
                    }
                    eE.delete(this.xy, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.xx.a(th, "performCleanup");
                        return;
                    } finally {
                        eE.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b gV() {
        return this.xx;
    }
}
