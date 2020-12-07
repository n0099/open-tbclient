package com.baidu.swan.apps.ac.d;

import android.text.TextUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void print(String str) {
        if (DEBUG && !TextUtils.isEmpty(str)) {
            c.i("Module-Plugin", str);
        }
    }
}
