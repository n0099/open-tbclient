package com.baidu.baiduarsdk.util;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class a {
    public static String a(File file) {
        FileInputStream fileInputStream;
        String str = null;
        try {
            if (c(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        str = b.a((InputStream) fileInputStream);
                        b.a((Closeable) fileInputStream);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        b.a((Closeable) fileInputStream);
                        return str;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th) {
                    fileInputStream = null;
                    th = th;
                    b.a((Closeable) fileInputStream);
                    throw th;
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new File(str));
    }

    public static InputStream b(File file) {
        if (c(file)) {
            try {
                return new FileInputStream(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static InputStream b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(new File(str));
    }

    public static boolean c(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
