package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b zI;
    protected String zJ;
    protected e.b zK;
    protected e.a zL;
    protected int zM;
    protected LinkedList<String> zN = new LinkedList<>();
    private Object zO = new Object();

    protected abstract ContentValues a(g<T> gVar);

    public abstract String as(String str);

    protected abstract boolean at(String str);

    public abstract void b(String str, String str2, int i, int i2);

    protected abstract g<T> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract Cursor d(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int hX();

    public c(com.baidu.adp.base.a.b bVar) {
        this.zI = bVar;
    }

    public void a(e eVar, String str) {
        this.zJ = str;
        if (eVar instanceof e.b) {
            this.zK = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.zL = (e.a) eVar;
        }
    }

    public g<T> au(String str) {
        try {
            return c(this.zI.fL(), str);
        } catch (Throwable th) {
            this.zI.a(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.zO) {
                this.zN.remove(gVar.zU);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase fL = this.zI.fL();
            if (fL.update(this.zJ, a, "m_key = ?", new String[]{gVar.zU}) == 0) {
                fL.insert(this.zJ, null, a);
                if (this.zL != null) {
                    hY();
                }
            }
            if (this.zK != null && (e = this.zK.e(gVar)) != null) {
                av(e);
            }
        } catch (Throwable th) {
            this.zI.a(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void hY() {
        if (this.zL != null) {
            this.zM++;
            if (this.zM >= ((int) Math.min(this.zL.getMaxSize() * 0.2d, 5.0d))) {
                this.zM = 0;
                com.baidu.adp.lib.g.h.ju().d(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hZ();
                    }
                });
            }
        }
    }

    public int av(String str) {
        try {
            return this.zI.fL().delete(this.zJ, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.zI.a(th, "deleteCacheItem");
            return 0;
        }
    }

    public void aw(String str) {
        this.zM = 0;
        synchronized (this.zO) {
            this.zN.clear();
        }
        if (at(str)) {
            BdCacheService.ij().ik().aI(str);
        }
    }

    public synchronized void c(String str, boolean z) {
        synchronized (this.zO) {
            if (!this.zN.contains(str)) {
                this.zN.addLast(str);
                if (z) {
                    hY();
                }
            }
        }
    }

    public void ax(String str) {
        if (this.zL != null) {
            Cursor cursor = null;
            try {
                this.zL.id();
                cursor = d(this.zI.fL(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.zU = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.zW = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.zX = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.zY = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.zL.d(gVar);
                    if (d != null) {
                        c(d, false);
                    }
                }
                hZ();
            } catch (Throwable th) {
                try {
                    this.zI.a(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.zL.ie();
                }
            }
        }
    }

    public void ay(String str) {
        if (this.zK != null) {
            Cursor cursor = null;
            try {
                this.zK.mo10if();
                cursor = d(this.zI.fL(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.zU = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.zW = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.zX = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.zY = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.zK.f(gVar);
                    if (f != null) {
                        c(f, false);
                    }
                }
                hZ();
            } catch (Throwable th) {
                try {
                    this.zI.a(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                    this.zK.ig();
                }
            }
        }
    }

    protected void hZ() {
        String removeFirst;
        if (!this.zN.isEmpty()) {
            SQLiteDatabase fL = this.zI.fL();
            fL.beginTransaction();
            while (true) {
                try {
                    synchronized (this.zO) {
                        if (!this.zN.isEmpty()) {
                            removeFirst = this.zN.removeFirst();
                        } else {
                            fL.setTransactionSuccessful();
                            this.zM = 0;
                            return;
                        }
                    }
                    fL.delete(this.zJ, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.zI.a(th, "performCleanup");
                        return;
                    } finally {
                        fL.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b ia() {
        return this.zI;
    }
}
