package com.baidu.swan.apps.component.e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void au(@NonNull String str, @NonNull String str2) {
        c(str, str2, null);
    }

    public static void c(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (th == null) {
                c.e(str, str2);
                if (DEBUG) {
                    throw new RuntimeException(str2);
                }
                return;
            }
            c.e(str, str2, th);
            if (DEBUG) {
                throw new RuntimeException(str2, th);
            }
        }
    }
}
