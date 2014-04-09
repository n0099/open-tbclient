package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public final class bb {
    private static bb a;

    public static synchronized bb a() {
        bb bbVar;
        synchronized (bb.class) {
            if (a == null) {
                a = new bb();
            }
            bbVar = a;
        }
        return bbVar;
    }

    private static String d(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public final Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return w.c(d(str), str);
    }

    public final boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return w.b(d(str), str);
    }

    public final int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) w.a(d(str), str);
    }

    public final boolean a(String str, String str2) {
        String str3 = w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/";
        if (!w.a(str3)) {
            w.l(str3);
        }
        String str4 = String.valueOf(str3) + d(str2);
        if (!w.a(str4)) {
            w.l(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return w.a(str, str5, true);
    }

    public final void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            w.a(d(str), str, bArr);
        }
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "run", "list[i].delete error");
                }
            }
        }
    }

    public final void b() {
        a(new File(w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/image"));
    }

    public final void c() {
        b(new File(w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + w.a(3)));
    }

    private void b(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && !file2.delete()) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "run", "list[i].delete error");
                }
            }
        }
    }
}
