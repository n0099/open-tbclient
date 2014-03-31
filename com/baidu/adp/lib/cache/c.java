package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.a.i a;
    protected String b;
    protected h c;
    protected g d;
    protected int e;
    protected LinkedList<String> f = new LinkedList<>();
    private Object g = new Object();

    protected abstract ContentValues a(m<T> mVar);

    protected abstract m<T> a(SQLiteDatabase sQLiteDatabase, String str);

    public abstract String a(String str);

    public abstract Cursor b(SQLiteDatabase sQLiteDatabase, String str);

    protected abstract boolean b(String str);

    public c(com.baidu.adp.a.i iVar) {
        this.a = iVar;
    }

    public final void a(f fVar, String str) {
        this.b = str;
        if (fVar instanceof h) {
            this.c = (h) fVar;
        }
        if (fVar instanceof g) {
            this.d = (g) fVar;
        }
    }

    public final m<T> c(String str) {
        try {
            return a(this.a.a(), str);
        } catch (Throwable th) {
            this.a.b();
            com.baidu.adp.lib.util.f.a(getClass(), str, th);
            return null;
        }
    }

    public final void b(m<T> mVar) {
        String a;
        try {
            synchronized (this.g) {
                this.f.remove(mVar.a);
            }
            ContentValues a2 = a(mVar);
            if (this.a.a().update(this.b, a2, "m_key = ?", new String[]{mVar.a}) == 0) {
                this.a.a().insert(this.b, null, a2);
                if (this.d != null) {
                    c();
                }
            }
            if (this.c != null && (a = this.c.a(mVar)) != null) {
                d(a);
            }
        } catch (Throwable th) {
            this.a.b();
            com.baidu.adp.lib.util.f.a(getClass(), "failed to insert " + mVar.a + " to db.", th);
        }
    }

    private void c() {
        if (this.d != null) {
            this.e++;
            if (this.e >= ((int) Math.min(this.d.a() * 0.2d, 5.0d))) {
                this.e = 0;
                com.baidu.adp.lib.f.d.a();
                com.baidu.adp.lib.f.d.a(new d(this));
            }
        }
    }

    public final int d(String str) {
        try {
            return this.a.a().delete(this.b, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.a.b();
            com.baidu.adp.lib.util.f.a(getClass(), "failed to delete " + str + " from db.", th);
            return 0;
        }
    }

    public final void e(String str) {
        this.e = 0;
        synchronized (this.g) {
            this.f.clear();
        }
        if (b(str)) {
            BdCacheService.a().b().b(str);
        }
    }

    public final synchronized void a(String str, boolean z) {
        synchronized (this.g) {
            if (!this.f.contains(str)) {
                this.f.addLast(str);
                if (z) {
                    c();
                }
            }
        }
    }

    public final void f(String str) {
        if (this.d != null) {
            Cursor cursor = null;
            try {
                this.d.c();
                cursor = b(this.a.a(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String a = this.d.a(mVar);
                    if (a != null) {
                        a(a, false);
                    }
                }
                a();
            } catch (Throwable th) {
                try {
                    this.a.b();
                    com.baidu.adp.lib.util.f.a(getClass(), "performEvict", th);
                } finally {
                    com.baidu.adp.lib.f.a.a(cursor);
                    this.d.d();
                }
            }
        }
    }

    public final void g(String str) {
        if (this.c != null) {
            Cursor cursor = null;
            try {
                h hVar = this.c;
                cursor = b(this.a.a(), str);
                while (cursor.moveToNext()) {
                    m<?> mVar = new m<>();
                    mVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                    mVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    mVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    mVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String b = this.c.b(mVar);
                    if (b != null) {
                        a(b, false);
                    }
                }
                a();
            } catch (Throwable th) {
                try {
                    this.a.b();
                    com.baidu.adp.lib.util.f.a(getClass(), "performPump", th);
                } finally {
                    com.baidu.adp.lib.f.a.a(cursor);
                    h hVar2 = this.c;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        String removeFirst;
        if (!this.f.isEmpty()) {
            SQLiteDatabase a = this.a.a();
            a.beginTransaction();
            while (true) {
                try {
                    synchronized (this.g) {
                        if (!this.f.isEmpty()) {
                            removeFirst = this.f.removeFirst();
                        } else {
                            a.setTransactionSuccessful();
                            this.e = 0;
                            return;
                        }
                    }
                    a.delete(this.b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.a.b();
                        return;
                    } finally {
                        a.endTransaction();
                    }
                }
            }
        }
    }

    public final com.baidu.adp.a.i b() {
        return this.a;
    }
}
