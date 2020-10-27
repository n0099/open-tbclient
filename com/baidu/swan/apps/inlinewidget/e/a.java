package com.baidu.swan.apps.inlinewidget.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class a {
    public static String ou(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aEU = e.aEU();
        if (!com.baidu.swan.apps.storage.b.ta(str) || aEU == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aEU);
    }
}
