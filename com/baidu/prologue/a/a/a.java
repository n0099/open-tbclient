package com.baidu.prologue.a.a;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    public static final boolean coo = com.baidu.prologue.a.b.a.cop.get().acv();
    private static String url = "https://afd.baidu.com/afd/entry";

    public static String ack() {
        if (!coo || TextUtils.isEmpty(com.baidu.prologue.a.b.a.cop.get().acI())) {
            return TextUtils.isEmpty(url) ? "https://afd.baidu.com/afd/entry" : url;
        }
        return com.baidu.prologue.a.b.a.cop.get().acI();
    }
}
