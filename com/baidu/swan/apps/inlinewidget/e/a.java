package com.baidu.swan.apps.inlinewidget.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class a {
    public static String oI(@NonNull String str) {
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        e aHu = e.aHu();
        if (!com.baidu.swan.apps.storage.b.to(str) || aHu == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aHu);
    }
}
