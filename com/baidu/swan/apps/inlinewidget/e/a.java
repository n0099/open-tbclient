package com.baidu.swan.apps.inlinewidget.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class a {
    public static String oC(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aGM = e.aGM();
        if (!com.baidu.swan.apps.storage.b.tj(str) || aGM == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aGM);
    }
}
