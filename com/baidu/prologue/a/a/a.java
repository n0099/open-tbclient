package com.baidu.prologue.a.a;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    public static final boolean GLOBAL_DEBUG = com.baidu.prologue.a.b.a.bzx.get().ND();
    private static String url = "https://afd.baidu.com/afd/entry";

    public static String Ns() {
        if (!GLOBAL_DEBUG || TextUtils.isEmpty(com.baidu.prologue.a.b.a.bzx.get().NQ())) {
            return TextUtils.isEmpty(url) ? "https://afd.baidu.com/afd/entry" : url;
        }
        return com.baidu.prologue.a.b.a.bzx.get().NQ();
    }
}
