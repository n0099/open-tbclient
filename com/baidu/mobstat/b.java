package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {
    public static b a = new b();

    public synchronized void a(Context context) {
        String m = bw.m(context);
        if (!TextUtils.isEmpty(m)) {
            k.AP_LIST.a(context, System.currentTimeMillis(), m);
        }
    }
}
