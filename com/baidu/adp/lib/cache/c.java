package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b yj;
    protected String yk;
    protected e.b yl;
    protected e.a ym;
    protected int yn;
    protected LinkedList<String> yo = new LinkedList<>();
    private Object yp = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String ac(String str);

    protected abstract boolean ad(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int hn();

    public c(com.baidu.adp.base.a.b bVar) {
        this.yj = bVar;
    }

    public void a(e eVar, String str) {
        this.yk = str;
        if (eVar instanceof e.b) {
            this.yl = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.ym = (e.a) eVar;
        }
    }

    public g<T> ae(String str) {
        try {
            return c(this.yj.fa(), str);
        } catch (Throwable th) {
            this.yj.c(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.yp) {
                this.yo.remove(gVar.yv);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase fa = this.yj.fa();
            if (fa.update(this.yk, a, "m_key = ?", new String[]{gVar.yv}) == 0) {
                fa.insert(this.yk, null, a);
                if (this.ym != null) {
                    ho();
                }
            }
            if (this.yl != null && (e = this.yl.e(gVar)) != null) {
                af(e);
            }
        } catch (Throwable th) {
            this.yj.c(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void ho() {
        if (this.ym != null) {
            this.yn++;
            if (this.yn >= ((int) Math.min(this.ym.hs() * 0.2d, 5.0d))) {
                this.yn = 0;
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hp();
                    }
                });
            }
        }
    }

    public int af(String str) {
        try {
            return this.yj.fa().delete(this.yk, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.yj.c(th, "deleteCacheItem");
            return 0;
        }
    }

    public void ag(String str) {
        this.yn = 0;
        synchronized (this.yp) {
            this.yo.clear();
        }
        if (ad(str)) {
            BdCacheService.hA().hB().at(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.yp) {
            if (!this.yo.contains(str)) {
                this.yo.addLast(str);
                if (z) {
                    ho();
                }
            }
        }
    }

    public void ah(String str) {
        if (this.ym != null) {
            Cursor cursor = null;
            try {
                this.ym.hu();
                cursor = d(this.yj.fa(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.yv = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.yx = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.yy = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.yz = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.ym.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                hp();
            } catch (Throwable th) {
                try {
                    this.yj.c(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.ym.hv();
                }
            }
        }
    }

    public void ai(String str) {
        if (this.yl != null) {
            Cursor cursor = null;
            try {
                this.yl.hw();
                cursor = d(this.yj.fa(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.yv = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.yx = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.yy = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.yz = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.yl.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                hp();
            } catch (Throwable th) {
                try {
                    this.yj.c(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.yl.hx();
                }
            }
        }
    }

    protected void hp() {
        String removeFirst;
        if (!this.yo.isEmpty()) {
            SQLiteDatabase fa = this.yj.fa();
            fa.beginTransaction();
            while (true) {
                try {
                    synchronized (this.yp) {
                        if (!this.yo.isEmpty()) {
                            removeFirst = this.yo.removeFirst();
                        } else {
                            fa.setTransactionSuccessful();
                            this.yn = 0;
                            return;
                        }
                    }
                    fa.delete(this.yk, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.yj.c(th, "performCleanup");
                        return;
                    } finally {
                        fa.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b hq() {
        return this.yj;
    }
}
