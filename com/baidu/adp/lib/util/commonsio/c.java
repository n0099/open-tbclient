package com.baidu.adp.lib.util.commonsio;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class c {
    public static final char nU = File.separatorChar;

    public static void f(InputStream inputStream) {
        d(inputStream);
    }

    public static void d(OutputStream outputStream) {
        d((Closeable) outputStream);
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
