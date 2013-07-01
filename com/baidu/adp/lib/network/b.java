package com.baidu.adp.lib.network;

import android.content.Context;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f180a;
    private Context b;

    public static b a() {
        if (f180a == null) {
            f180a = new b();
        }
        return f180a;
    }

    public void a(Context context, boolean z) {
        this.b = context;
        a.f179a = z;
    }

    private b() {
    }
}
