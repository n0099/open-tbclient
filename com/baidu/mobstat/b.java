package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f8942a = new b();

    public synchronized void a(Context context) {
        String o = bw.o(context);
        if (!TextUtils.isEmpty(o)) {
            k.AP_LIST.a(System.currentTimeMillis(), o);
        }
    }
}
