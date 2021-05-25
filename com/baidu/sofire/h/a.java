package com.baidu.sofire.h;

import android.content.Context;
import android.os.Build;
import com.baidu.sofire.m.b;
/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static a f10267a;

    /* renamed from: b  reason: collision with root package name */
    public b f10268b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10269c = false;

    /* renamed from: com.baidu.sofire.h.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10270a;

        static {
            int[] iArr = new int[b.a.values().length];
            f10270a = iArr;
            try {
                iArr[b.a.VIVO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10270a[b.a.OPPO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10270a[b.a.XIAOMI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10270a[b.a.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10270a[b.a.UNSUPPORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static a a() {
        if (f10267a == null) {
            synchronized (a.class) {
                if (f10267a == null) {
                    f10267a = new a();
                }
            }
        }
        return f10267a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #0 {all -> 0x004d, blocks: (B:2:0x0000, B:5:0x0005, B:22:0x0043, B:24:0x0047, B:16:0x0025, B:17:0x0029, B:18:0x002e, B:19:0x0031, B:20:0x0037, B:21:0x003d), top: B:29:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.sofire.h.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Context context, c cVar) {
        b cVar2;
        try {
            if (this.f10269c) {
                return;
            }
            this.f10269c = true;
            int i2 = AnonymousClass1.f10270a[b.a.a(Build.MANUFACTURER).ordinal()];
            if (i2 == 1) {
                cVar2 = new com.baidu.sofire.k.c();
            } else if (i2 == 2) {
                cVar2 = new com.baidu.sofire.j.c();
            } else if (i2 == 3) {
                cVar2 = new com.baidu.sofire.l.b();
            } else if (i2 != 4) {
                if (i2 == 5) {
                    this.f10268b = null;
                }
                if (this.f10268b == null) {
                    this.f10268b.a(context, cVar);
                    return;
                }
                return;
            } else {
                cVar2 = new com.baidu.sofire.i.b();
            }
            this.f10268b = cVar2;
            if (this.f10268b == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        b bVar = this.f10268b;
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
