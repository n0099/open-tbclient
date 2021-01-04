package com.baidu.swan.apps.inlinewidget.e;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class a {
    public static String pc(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aMk = e.aMk();
        if (!com.baidu.swan.apps.storage.b.tN(str) || aMk == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aMk);
    }
}
