package com.baidu.sofire.j;

import android.content.Context;
import android.os.Build;
import com.baidu.sofire.o.b;
/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static a f10343a;

    /* renamed from: b  reason: collision with root package name */
    public b f10344b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10345c = false;

    /* renamed from: com.baidu.sofire.j.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10346a;

        static {
            int[] iArr = new int[b.a.values().length];
            f10346a = iArr;
            try {
                iArr[b.a.VIVO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10346a[b.a.OPPO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10346a[b.a.XIAOMI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10346a[b.a.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10346a[b.a.UNSUPPORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static a a() {
        if (f10343a == null) {
            synchronized (a.class) {
                if (f10343a == null) {
                    f10343a = new a();
                }
            }
        }
        return f10343a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #0 {all -> 0x004d, blocks: (B:2:0x0000, B:5:0x0005, B:22:0x0043, B:24:0x0047, B:16:0x0025, B:17:0x0029, B:18:0x002e, B:19:0x0031, B:20:0x0037, B:21:0x003d), top: B:29:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.sofire.j.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Context context, c cVar) {
        b cVar2;
        try {
            if (this.f10345c) {
                return;
            }
            this.f10345c = true;
            int i2 = AnonymousClass1.f10346a[b.a.a(Build.MANUFACTURER).ordinal()];
            if (i2 == 1) {
                cVar2 = new com.baidu.sofire.m.c();
            } else if (i2 == 2) {
                cVar2 = new com.baidu.sofire.l.c();
            } else if (i2 == 3) {
                cVar2 = new com.baidu.sofire.n.b();
            } else if (i2 != 4) {
                if (i2 == 5) {
                    this.f10344b = null;
                }
                if (this.f10344b == null) {
                    this.f10344b.a(context, cVar);
                    return;
                }
                return;
            } else {
                cVar2 = new com.baidu.sofire.k.b();
            }
            this.f10344b = cVar2;
            if (this.f10344b == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        b bVar = this.f10344b;
        if (bVar == null) {
            return null;
        }
        try {
            return bVar.b();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
