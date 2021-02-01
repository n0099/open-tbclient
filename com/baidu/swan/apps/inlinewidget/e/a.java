package com.baidu.swan.apps.inlinewidget.e;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class a {
    public static String oi(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aIK = e.aIK();
        if (!com.baidu.swan.apps.storage.b.sV(str) || aIK == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aIK);
    }
}
