package com.baidu.prologue.a.a;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    public static final boolean ctc = com.baidu.prologue.a.b.a.ctd.get().ago();
    private static String url = "https://afd.baidu.com/afd/entry";

    public static String agd() {
        if (!ctc || TextUtils.isEmpty(com.baidu.prologue.a.b.a.ctd.get().agB())) {
            return TextUtils.isEmpty(url) ? "https://afd.baidu.com/afd/entry" : url;
        }
        return com.baidu.prologue.a.b.a.ctd.get().agB();
    }
}
