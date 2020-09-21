package com.baidu.swan.apps.inlinewidget.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes3.dex */
public class a {
    public static String nn(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aAr = e.aAr();
        if (!com.baidu.swan.apps.storage.b.rU(str) || aAr == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aAr);
    }
}
