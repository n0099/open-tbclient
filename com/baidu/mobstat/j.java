package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes7.dex */
abstract class j implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private m f2625a;

    public abstract long a(String str, String str2);

    public abstract ArrayList<i> a(int i, int i2);

    public abstract boolean b(long j);

    public j(String str, String str2) {
        l lVar = new l();
        this.f2625a = new m(lVar, str);
        File databasePath = lVar.getDatabasePath(".confd");
        if (databasePath != null && databasePath.canWrite()) {
            a(str2);
        }
    }

    private void a(String str) {
        this.f2625a.a(str);
    }

    public synchronized boolean a() {
        boolean z;
        try {
            z = this.f2625a.a();
        } catch (Exception e) {
            bb.c().b(e);
            z = false;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.f2625a.close();
        } catch (Exception e) {
            bb.c().b(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return this.f2625a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor a(String str, int i, int i2) {
        return this.f2625a.a(null, null, null, null, null, str + " desc", i2 + ", " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor a(String str, String str2, String str3, int i) {
        return this.f2625a.a(null, str + "=? ", new String[]{str2}, null, null, str3 + " desc", i + "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long a(ContentValues contentValues) {
        return this.f2625a.a((String) null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(long j) {
        return this.f2625a.a("_id=? ", new String[]{new StringBuilder().append(j).append("").toString()}) > 0;
    }
}
