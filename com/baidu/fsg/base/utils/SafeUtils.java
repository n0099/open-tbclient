package com.baidu.fsg.base.utils;

import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
/* loaded from: classes2.dex */
public final class SafeUtils {
    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return RimArmor.getInstance().encryptProxy(str2);
        }
        return "";
    }
}
