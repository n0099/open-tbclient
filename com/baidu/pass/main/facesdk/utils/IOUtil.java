package com.baidu.pass.main.facesdk.utils;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes2.dex */
public class IOUtil {
    public static void close(Closeable... closeableArr) throws IOException {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        }
    }

    public static void closeQuietly(Closeable... closeableArr) {
        try {
            close(closeableArr);
        } catch (IOException unused) {
        }
    }
}
