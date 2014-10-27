package com.baidu.adp.lib.util.commonsio;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class c {
    public static final char nS = File.separatorChar;

    public static void c(InputStream inputStream) {
        b(inputStream);
    }

    public static void c(OutputStream outputStream) {
        b(outputStream);
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
