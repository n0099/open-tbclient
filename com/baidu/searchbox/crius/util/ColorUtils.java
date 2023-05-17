package com.baidu.searchbox.crius.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.crius.CriusRuntime;
/* loaded from: classes3.dex */
public class ColorUtils {
    public static int getColorRes(boolean z, int i, int i2) {
        return (!z || i == 0 || i == Integer.MAX_VALUE) ? i2 : i;
    }

    public static int parseColor(String str) {
        int parseColor;
        if (TextUtils.isEmpty(str)) {
            return Integer.MAX_VALUE;
        }
        try {
            if (str.startsWith("#")) {
                parseColor = Color.parseColor(str);
            } else if (str.startsWith("$")) {
                parseColor = CriusRuntime.context().getResources().getColor(CriusRuntime.context().getResources().getIdentifier(str.substring(1), "color", CriusRuntime.context().getPackageName()));
            } else {
                parseColor = Color.parseColor("#" + str);
            }
            return parseColor;
        } catch (Throwable unused) {
            return Integer.MAX_VALUE;
        }
    }
}
