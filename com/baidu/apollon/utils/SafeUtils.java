package com.baidu.apollon.utils;

import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
/* loaded from: classes2.dex */
public final class SafeUtils {
    public static String encrypt(String str, String str2) {
        return !TextUtils.isEmpty(str2) ? SafePay.getInstance().encryptProxy(str2) : "";
    }
}
