package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
abstract class q implements Closeable {
    private t a;

    public abstract long a(String str, String str2);

    public abstract ArrayList<p> a(int i, int i2);

    public abstract boolean b(long j);

    public q(String str, String str2) {
        s sVar = new s();
        this.a = new t(sVar, str);
        File databasePath = sVar.getDatabasePath(".confd");
        if (databasePath != null && databasePath.canWrite()) {
            a(str2);
        }
    }

    private void a(String str) {
        this.a.a(str);
    }

    public synchronized boolean a() {
        boolean z;
        try {
            z = this.a.a();
        } catch (Exception e) {
            bi.c().b(e);
            z = false;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.a.close();
        } catch (Exception e) {
            bi.c().b(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor a(String str, int i, int i2) {
        return this.a.a(null, null, null, null, null, str + " desc", i2 + ", " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor a(String str, String str2, String str3, int i) {
        return this.a.a(null, str + "=? ", new String[]{str2}, null, null, str3 + " desc", i + "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long a(ContentValues contentValues) {
        return this.a.a((String) null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(long j) {
        return this.a.a("_id=? ", new String[]{new StringBuilder().append(j).append("").toString()}) > 0;
    }
}
