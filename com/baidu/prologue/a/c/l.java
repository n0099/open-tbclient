package com.baidu.prologue.a.c;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes6.dex */
public class l {
    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                g.ctf.e("SafeUtil", "error closing " + closeable.getClass().getName(), e);
            }
        }
    }
}
