package com.baidu.android.pushservice.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.util.PushDatabase;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private Context f706a;
    private e b;
    private h c;
    private long d;
    private o e;

    public s(Context context) {
        this.f706a = context;
        this.b = e.a(context);
        this.e = new o(context);
        this.c = new h(context);
        this.d = com.baidu.android.pushservice.util.m.s(context);
    }

    public static long a(Context context, a aVar) {
        SQLiteDatabase db = PushDatabase.getDb(context);
        if (db != null) {
            return PushDatabase.insertApiBehavior(db, aVar);
        }
        return -1L;
    }

    public static long a(Context context, b bVar) {
        SQLiteDatabase db = PushDatabase.getDb(context);
        if (db != null) {
            return PushDatabase.insertAppInfo(db, bVar);
        }
        return -1L;
    }

    public static long a(Context context, i iVar) {
        SQLiteDatabase db = PushDatabase.getDb(context);
        if (db != null) {
            return PushDatabase.insertPromptBehavior(db, iVar);
        }
        return -1L;
    }

    public static long a(Context context, j jVar) {
        SQLiteDatabase db = PushDatabase.getDb(context);
        if (db != null) {
            return PushDatabase.insertPushBehavior(db, jVar);
        }
        return -1L;
    }

    private boolean c() {
        return PushSettings.f() && System.currentTimeMillis() - PushSettings.d(this.f706a) > 1800000;
    }

    public void a() {
        this.e.b();
    }

    public void b() {
        if (this.c == null) {
            this.c = h.a(this.f706a);
        }
        if (c()) {
            this.c.g();
        }
    }
}
