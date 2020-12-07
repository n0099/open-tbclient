package com.baidu.swan.apps.inlinewidget.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes25.dex */
public class a {
    public static String pj(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aJU = e.aJU();
        if (!com.baidu.swan.apps.storage.b.tQ(str) || aJU == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aJU);
    }
}
