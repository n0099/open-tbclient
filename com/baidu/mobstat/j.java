package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.Closeable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class j implements Closeable {
    public l a;

    public abstract long a(String str, String str2);

    public abstract ArrayList<i> a(int i, int i2);

    public abstract boolean b(long j);

    public j(Context context, String str, String str2) {
        try {
            this.a = new l(context, str);
            if (context.getDatabasePath(y.e) != null) {
                a(str2);
            }
        } catch (Exception unused) {
        }
    }

    public Cursor a(String str, int i, int i2) {
        return this.a.a(null, null, null, null, null, str + " desc", i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i);
    }

    private void a(String str) {
        this.a.a(str);
    }

    public long a(ContentValues contentValues) {
        return this.a.a((String) null, contentValues);
    }

    public Cursor a(String str, String str2, String str3, int i) {
        String str4 = str + "=? ";
        String[] strArr = {str2};
        return this.a.a(null, str4, strArr, null, null, str3 + " desc", i + "");
    }

    public synchronized boolean a() {
        try {
        } catch (Exception e) {
            ba.c().b(e);
            return false;
        }
        return this.a.a();
    }

    public int b() {
        return this.a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.a.close();
        } catch (Exception e) {
            ba.c().b(e);
        }
    }

    public boolean a(long j) {
        if (this.a.a("_id=? ", new String[]{j + ""}) > 0) {
            return true;
        }
        return false;
    }
}
