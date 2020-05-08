package com.baidu.prologue.a.c;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes6.dex */
public class k {
    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                f.brW.e("SafeUtil", "error closing " + closeable.getClass().getName(), e);
            }
        }
    }
}
