package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i {
    static i a = new i();

    i() {
    }

    public synchronized void a(Context context) {
        String o = cc.o(context);
        if (!TextUtils.isEmpty(o)) {
            r.AP_LIST.a(System.currentTimeMillis(), o);
        }
    }
}
