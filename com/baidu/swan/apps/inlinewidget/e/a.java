package com.baidu.swan.apps.inlinewidget.e;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class a {
    public static String oq(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aIN = e.aIN();
        if (!com.baidu.swan.apps.storage.b.tc(str) || aIN == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aIN);
    }
}
