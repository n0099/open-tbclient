package com.baidu.ar.external.a.a;

import android.content.Context;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.util.f;
/* loaded from: classes3.dex */
public class a {
    private static a a;
    private c b = null;
    private IARCallback c;
    private int d;

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static void c() {
        if (a != null) {
            a.c = null;
            a = null;
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(Context context, b bVar) {
    }

    public void a(IARCallback iARCallback) {
        this.c = iARCallback;
    }

    public boolean a(Context context) {
        if (f.c(context) || !f.b(context) || this.c == null) {
            return false;
        }
        return this.c.isLogin();
    }

    public int b() {
        return this.d;
    }
}
