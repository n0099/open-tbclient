package com.baidu.swan.uuid.b;

import android.content.Context;
import android.os.Build;
/* loaded from: classes24.dex */
public class c {
    public static boolean hasPermission(Context context, String str) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }
}
