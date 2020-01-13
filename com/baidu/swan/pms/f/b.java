package com.baidu.swan.pms.f;

import android.support.annotation.Nullable;
import java.io.Closeable;
/* loaded from: classes10.dex */
public class b {
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
