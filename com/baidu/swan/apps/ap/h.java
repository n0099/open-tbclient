package com.baidu.swan.apps.ap;

import android.support.annotation.ColorInt;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes10.dex */
public class h {
    public static boolean kS(@ColorInt int i) {
        return ((int) (((((double) ((65280 & i) >> 8)) * 0.587d) + (0.299d * ((double) ((16711680 & i) >> 16)))) + (((double) (i & 255)) * 0.114d))) >= 220;
    }

    public static String toColorRGBA(String str) {
        return V8Engine.toColorRGBA(str);
    }
}
