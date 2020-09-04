package com.baidu.swan.apps.inlinewidget.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class a {
    public static String mU(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e azI = e.azI();
        if (!com.baidu.swan.apps.storage.b.rB(str) || azI == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, azI);
    }
}
