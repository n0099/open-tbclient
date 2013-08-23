package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final com.baidu.adp.a.f f375a;
    protected String b;
    protected f c;
    protected e d;
    protected int e;
    protected LinkedList f = new LinkedList();
    private Object g = new Object();

    public abstract int a();

    protected abstract ContentValues a(k kVar);

    public abstract Cursor a(SQLiteDatabase sQLiteDatabase, String str);

    public abstract String a(String str);

    public abstract void a(String str, String str2, int i, int i2);

    protected abstract k b(SQLiteDatabase sQLiteDatabase, String str);

    public a(com.baidu.adp.a.f fVar) {
        this.f375a = fVar;
    }

    public void a(d dVar, String str) {
        this.b = str;
        if (dVar instanceof f) {
            this.c = (f) dVar;
        }
        if (dVar instanceof e) {
            this.d = (e) dVar;
        }
    }

    public k b(String str) {
        try {
            return b(this.f375a.a(), str);
        } catch (Throwable th) {
            this.f375a.a(th);
            com.baidu.adp.lib.e.d.a(getClass(), str, th);
            return null;
        }
    }

    public void b(k kVar) {
        String a2;
        try {
            synchronized (this.g) {
                this.f.remove(kVar.f380a);
            }
            ContentValues a3 = a(kVar);
            if (this.f375a.a().update(this.b, a3, "m_key = ?", new String[]{kVar.f380a}) == 0) {
                this.f375a.a().insert(this.b, null, a3);
                if (this.d != null) {
                    b();
                }
            }
            if (this.c != null && (a2 = this.c.a(kVar)) != null) {
                c(a2);
            }
        } catch (Throwable th) {
            this.f375a.a(th);
            com.baidu.adp.lib.e.d.a(getClass(), "failed to insert " + kVar.f380a + " to db.", th);
        }
    }

    protected void b() {
        if (this.d != null) {
            this.e++;
            if (this.e >= ((int) Math.min(this.d.a() * 0.2d, 5.0d))) {
                this.e = 0;
                com.baidu.adp.lib.e.f.a().a(new b(this));
            }
        }
    }

    public int c(String str) {
        try {
            return this.f375a.a().delete(this.b, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.f375a.a(th);
            com.baidu.adp.lib.e.d.a(getClass(), "failed to delete " + str + " from db.", th);
            return 0;
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

    public void d(String str) {
        if (this.d != null) {
            Cursor cursor = null;
            try {
                this.d.c();
                cursor = a(this.f375a.a(), str);
                while (cursor.moveToNext()) {
                    k kVar = new k();
                    kVar.f380a = cursor.getString(cursor.getColumnIndex("m_key"));
                    kVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    kVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    kVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String a2 = this.d.a(kVar);
                    if (a2 != null) {
                        a(a2, false);
                    }
                }
                c();
            } catch (Throwable th) {
                try {
                    this.f375a.a(th);
                    com.baidu.adp.lib.e.d.a(getClass(), "performEvict", th);
                } finally {
                    com.baidu.adp.lib.e.b.a(cursor);
                    this.d.d();
                }
            }
        }
    }

    public void e(String str) {
        if (this.c != null) {
            Cursor cursor = null;
            try {
                this.c.c();
                cursor = a(this.f375a.a(), str);
                while (cursor.moveToNext()) {
                    k kVar = new k();
                    kVar.f380a = cursor.getString(cursor.getColumnIndex("m_key"));
                    kVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    kVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    kVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String b = this.c.b(kVar);
                    if (b != null) {
                        a(b, false);
                    }
                }
                c();
            } catch (Throwable th) {
                try {
                    this.f375a.a(th);
                    com.baidu.adp.lib.e.d.a(getClass(), "performPump", th);
                } finally {
                    com.baidu.adp.lib.e.b.a(cursor);
                    this.c.d();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        String str;
        if (!this.f.isEmpty()) {
            SQLiteDatabase a2 = this.f375a.a();
            a2.beginTransaction();
            while (true) {
                try {
                    synchronized (this.g) {
                        if (!this.f.isEmpty()) {
                            str = (String) this.f.removeFirst();
                        } else {
                            a2.setTransactionSuccessful();
                            this.e = 0;
                            return;
                        }
                    }
                    a2.delete(this.b, "m_key = ?", new String[]{String.valueOf(str)});
                } catch (Throwable th) {
                    try {
                        this.f375a.a(th);
                        return;
                    } finally {
                        a2.endTransaction();
                    }
                }
            }
        }
    }
}
