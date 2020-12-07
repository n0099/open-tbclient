package com.baidu.sofire.j;

import android.content.Context;
import android.os.Build;
import com.baidu.sofire.o.b;
/* loaded from: classes8.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private static a f3654a;
    private b b = null;
    private boolean c = false;

    private a() {
    }

    public static a a() {
        if (f3654a == null) {
            synchronized (a.class) {
                if (f3654a == null) {
                    f3654a = new a();
                }
            }
        }
        return f3654a;
    }

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, c cVar) {
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            switch (b.a.a(Build.MANUFACTURER)) {
                case VIVO:
                    this.b = new com.baidu.sofire.m.c();
                    break;
                case OPPO:
                    this.b = new com.baidu.sofire.l.c();
                    break;
                case XIAOMI:
                    this.b = new com.baidu.sofire.n.b();
                    break;
                case HUA_WEI:
                    this.b = new com.baidu.sofire.k.b();
                    break;
                case UNSUPPORT:
                    this.b = null;
                    break;
            }
            if (this.b != null) {
                this.b.a(context, cVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        if (this.b == null) {
            return null;
        }
        try {
            return this.b.b();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
