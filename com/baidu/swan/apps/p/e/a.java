package com.baidu.swan.apps.p.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class a {
    public static String lb(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e arv = e.arv();
        if (!com.baidu.swan.apps.storage.b.pA(str) || arv == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, arv);
    }
}
