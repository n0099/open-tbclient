package com.baidu.swan.apps.inlinewidget.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class a {
    public static String nZ(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aDa = e.aDa();
        if (!com.baidu.swan.apps.storage.b.sH(str) || aDa == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aDa);
    }
}
