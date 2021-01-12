package com.baidu.swan.apps.inlinewidget.e;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class a {
    public static String nP(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aIr = e.aIr();
        if (!com.baidu.swan.apps.storage.b.sC(str) || aIr == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aIr);
    }
}
