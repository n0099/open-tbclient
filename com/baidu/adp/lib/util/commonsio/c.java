package com.baidu.adp.lib.util.commonsio;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class c {
    public static final char a = File.separatorChar;

    public static void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
