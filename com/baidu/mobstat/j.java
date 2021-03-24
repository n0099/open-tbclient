package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class j implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public m f9235a;

    public j(String str, String str2) {
        l lVar = new l();
        this.f9235a = new m(lVar, str);
        File databasePath = lVar.getDatabasePath(".confd");
        if (databasePath == null || !databasePath.canWrite()) {
            return;
        }
        a(str2);
    }

    private void a(String str) {
        this.f9235a.a(str);
    }

    public abstract long a(String str, String str2);

    public abstract ArrayList<i> a(int i, int i2);

    public int b() {
        return this.f9235a.b();
    }

    public abstract boolean b(long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.f9235a.close();
        } catch (Exception e2) {
            bb.c().b(e2);
        }
    }

    public synchronized boolean a() {
        try {
        } catch (Exception e2) {
            bb.c().b(e2);
            return false;
        }
        return this.f9235a.a();
    }

    public Cursor a(String str, int i, int i2) {
        return this.f9235a.a(null, null, null, null, null, str + " desc", i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i);
    }

    public Cursor a(String str, String str2, String str3, int i) {
        String str4 = str + "=? ";
        String[] strArr = {str2};
        return this.f9235a.a(null, str4, strArr, null, null, str3 + " desc", i + "");
    }

    public long a(ContentValues contentValues) {
        return this.f9235a.a((String) null, contentValues);
    }

    public boolean a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("");
        return this.f9235a.a("_id=? ", new String[]{sb.toString()}) > 0;
    }
}
