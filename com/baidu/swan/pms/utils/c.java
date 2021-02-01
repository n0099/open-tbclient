package com.baidu.swan.pms.utils;

import androidx.annotation.Nullable;
import java.io.Closeable;
/* loaded from: classes3.dex */
public class c {
    public static void closeSafely(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
