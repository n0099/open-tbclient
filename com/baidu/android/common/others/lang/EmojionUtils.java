package com.baidu.android.common.others.lang;

import android.text.TextUtils;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class EmojionUtils {
    public static boolean containsEmoji(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66).matcher(str).find();
    }

    public static String removeEmoji(String str) {
        return TextUtils.isEmpty(str) ? "" : str.trim().replaceAll("([\ue000-\ue5ff])", "");
    }
}
