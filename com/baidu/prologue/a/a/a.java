package com.baidu.prologue.a.a;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    public static final boolean ctc = com.baidu.prologue.a.b.a.ctd.get().agp();
    private static String url = "https://afd.baidu.com/afd/entry";

    public static String age() {
        if (!ctc || TextUtils.isEmpty(com.baidu.prologue.a.b.a.ctd.get().agC())) {
            return TextUtils.isEmpty(url) ? "https://afd.baidu.com/afd/entry" : url;
        }
        return com.baidu.prologue.a.b.a.ctd.get().agC();
    }
}
