package com.baidu.pass.main.facesdk.utils;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes3.dex */
public class IOUtil {
    public static void close(Closeable... closeableArr) {
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
