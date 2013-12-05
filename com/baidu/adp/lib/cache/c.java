package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final com.baidu.adp.a.h f428a;
    protected String b;
    protected h c;
    protected g d;
    protected int e;
    protected LinkedList<String> f = new LinkedList<>();
    private Object g = new Object();

    public abstract int a();

    protected abstract ContentValues a(m<T> mVar);

    protected abstract m<T> a(SQLiteDatabase sQLiteDatabase, String str);

    public abstract String a(String str);

    public abstract void a(String str, String str2, int i, int i2);

    public abstract Cursor b(SQLiteDatabase sQLiteDatabase, String str);

    protected abstract boolean b(String str);

    public c(com.baidu.adp.a.h hVar) {
        this.f428a = hVar;
    }

    public void a(f fVar, String str) {
        this.b = str;
        if (fVar instanceof h) {
            this.c = (h) fVar;
        }
        if (fVar instanceof g) {
            this.d = (g) fVar;
        }
    }

    public m<T> c(String str) {
        try {
            return a(this.f428a.a(), str);
        } catch (Throwable th) {
            this.f428a.a(th);
            com.baidu.adp.lib.h.e.a(getClass(), str, th);
            return null;
        }
    }

    public void b(m<T> mVar) {
        String a2;
        try {
            synchronized (this.g) {
                this.f.remove(mVar.f433a);
            }
            ContentValues a3 = a(mVar);
            if (this.f428a.a().update(this.b, a3, "m_key = ?", new String[]{mVar.f433a}) == 0) {
                this.f428a.a().insert(this.b, null, a3);
                if (this.d != null) {
                    b();
                }
            }
            if (this.c != null && (a2 = this.c.a(mVar)) != null) {
                d(a2);
            }
        } catch (Throwable th) {
            this.f428a.a(th);
            com.baidu.adp.lib.h.e.a(getClass(), "failed to insert " + mVar.f433a + " to db.", th);
        }
    }

    protected void b() {
        if (this.d != null) {
            this.e++;
            if (this.e >= ((int) Math.min(this.d.a() * 0.2d, 5.0d))) {
                this.e = 0;
                com.baidu.adp.lib.f.c.a().a(new d(this));
            }
        }
    }

    public int d(String str) {
        try {
            return this.f428a.a().delete(this.b, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.f428a.a(th);
            com.baidu.adp.lib.h.e.a(getClass(), "failed to delete " + str + " from db.", th);
            return 0;
        }
    }

    public void e(String str) {
        this.e = 0;
        synchronized (this.g) {
            this.f.clear();
        }
        if (b(str)) {
            BdCacheService.c().d().b(str);
        }
    }

    public synchronized void a(String str, boolean z) {
        synchronized (this.g) {
            if (!this.f.contains(str)) {
                this.f.addLast(str);
                if (z) {
                    b();
                }
            }
        }
    }

    public void f(String str) {
        if (this.d != null) {
            Cursor cursor = null;
            try {
                this.d.c();
                cursor = b(this.f428a.a(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.f433a = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String a2 = this.d.a(mVar);
                    if (a2 != null) {
                        a(a2, false);
                    }
                }
                c();
            } catch (Throwable th) {
                try {
                    this.f428a.a(th);
                    com.baidu.adp.lib.h.e.a(getClass(), "performEvict", th);
                } finally {
                    com.baidu.adp.lib.f.a.a(cursor);
                    this.d.d();
                }
            }
        }
    }

    public void g(String str) {
        if (this.c != null) {
            Cursor cursor = null;
            try {
                this.c.c();
                cursor = b(this.f428a.a(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.f433a = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String b = this.c.b(mVar);
                    if (b != null) {
                        a(b, false);
                    }
                }
                c();
            } catch (Throwable th) {
                try {
                    this.f428a.a(th);
                    com.baidu.adp.lib.h.e.a(getClass(), "performPump", th);
                } finally {
                    com.baidu.adp.lib.f.a.a(cursor);
                    this.c.d();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        String removeFirst;
        if (!this.f.isEmpty()) {
            SQLiteDatabase a2 = this.f428a.a();
            a2.beginTransaction();
            while (true) {
                try {
                    synchronized (this.g) {
                        if (!this.f.isEmpty()) {
                            removeFirst = this.f.removeFirst();
                        } else {
                            a2.setTransactionSuccessful();
                            this.e = 0;
                            return;
                        }
                    }
                    a2.delete(this.b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.f428a.a(th);
                        return;
                    } finally {
                        a2.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.a.h d() {
        return this.f428a;
    }
}
