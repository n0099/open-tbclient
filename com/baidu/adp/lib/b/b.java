package com.baidu.adp.lib.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static b a;
    private Context b;

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public void a(Context context, boolean z) {
        this.b = context;
        a.a = z;
    }

    private b() {
    }
}
