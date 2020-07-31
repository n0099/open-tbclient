package com.baidu.prologue.a.a;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class a {
    public static final boolean GLOBAL_DEBUG = com.baidu.prologue.a.b.a.bEI.get().OY();
    private static String url = "https://afd.baidu.com/afd/entry";

    public static String ON() {
        if (!GLOBAL_DEBUG || TextUtils.isEmpty(com.baidu.prologue.a.b.a.bEI.get().Pl())) {
            return TextUtils.isEmpty(url) ? "https://afd.baidu.com/afd/entry" : url;
        }
        return com.baidu.prologue.a.b.a.bEI.get().Pl();
    }
}
