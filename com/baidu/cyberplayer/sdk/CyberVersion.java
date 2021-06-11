package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
@Keep
/* loaded from: classes2.dex */
public class CyberVersion {
    public static String getCoreVersion() {
        String a2 = d.a();
        return TextUtils.isEmpty(a2) ? "0.0.0.0" : a2;
    }
}
