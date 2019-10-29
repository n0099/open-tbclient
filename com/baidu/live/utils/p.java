package com.baidu.live.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.NativeBds;
/* loaded from: classes6.dex */
public final class p {
    public static String T(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.encode(NativeBds.ae(str2, str), 11));
        } catch (Exception e) {
            return "";
        }
    }

    public static String U(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(NativeBds.dae(str2, Base64.decode(str, 11)));
        } catch (Exception e) {
            return "";
        }
    }
}
