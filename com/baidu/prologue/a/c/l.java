package com.baidu.prologue.a.c;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes19.dex */
public class l {
    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                g.cbu.e("SafeUtil", "error closing " + closeable.getClass().getName(), e);
            }
        }
    }
}
