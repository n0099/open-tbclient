package com.baidu.swan.apps.component.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void br(@NonNull String str, @NonNull String str2) {
        f(str, str2, null);
    }

    public static void f(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
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
