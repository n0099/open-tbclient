package com.baidu.sofire.j;

import android.content.Context;
import android.os.Build;
import com.baidu.sofire.o.b;
/* loaded from: classes15.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private static a f5570a;

    /* renamed from: b  reason: collision with root package name */
    private b f5571b = null;
    private boolean c = false;

    private a() {
    }

    public static a a() {
        if (f5570a == null) {
            synchronized (a.class) {
                if (f5570a == null) {
                    f5570a = new a();
                }
            }
        }
        return f5570a;
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
                    this.f5571b = new com.baidu.sofire.m.c();
                    break;
                case OPPO:
                    this.f5571b = new com.baidu.sofire.l.c();
                    break;
                case XIAOMI:
                    this.f5571b = new com.baidu.sofire.n.b();
                    break;
                case HUA_WEI:
                    this.f5571b = new com.baidu.sofire.k.b();
                    break;
                case UNSUPPORT:
                    this.f5571b = null;
                    break;
            }
            if (this.f5571b != null) {
                this.f5571b.a(context, cVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        if (this.f5571b == null) {
            return null;
        }
        try {
            return this.f5571b.b();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
