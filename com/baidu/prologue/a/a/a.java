package com.baidu.prologue.a.a;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    public static final boolean GLOBAL_DEBUG = com.baidu.prologue.a.b.a.brU.get().Lq();
    private static String url = "https://afd.baidu.com/afd/entry";

    public static String Lf() {
        if (!GLOBAL_DEBUG || TextUtils.isEmpty(com.baidu.prologue.a.b.a.brU.get().LD())) {
            return TextUtils.isEmpty(url) ? "https://afd.baidu.com/afd/entry" : url;
        }
        return com.baidu.prologue.a.b.a.brU.get().LD();
    }
}
