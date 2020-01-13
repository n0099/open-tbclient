package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class b {
    static b a = new b();

    b() {
    }

    public synchronized void a(Context context) {
        String o = bw.o(context);
        if (!TextUtils.isEmpty(o)) {
            k.AP_LIST.a(System.currentTimeMillis(), o);
        }
    }
}
