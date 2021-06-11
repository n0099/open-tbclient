package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.base.BdBaseApplication;
import d.a.c.e.p.h;
import d.a.c.e.p.i;
/* loaded from: classes.dex */
public class NSGif implements d.a.c.d.b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2151e = BdBaseApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2152f = h.f().k("nsgif_jni", 2, new b());

    /* renamed from: a  reason: collision with root package name */
    public int f2153a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2154b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2155c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2156d;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2157e;

        public a(int i2) {
            this.f2157e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NSGif.nativeDestroy(this.f2157e);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends i {
        @Override // d.a.c.e.p.i
        public void a(boolean z) {
            NSGif.f2152f = z;
        }
    }

    public NSGif(int i2) {
        this.f2153a = i2;
        this.f2154b = nativeGetWidth(i2);
        this.f2155c = nativeGetHeight(i2);
        this.f2156d = nativeGetFrameCount(i2);
    }

    public static NSGif e(String str) {
        int nativeCreate = nativeCreate(f2151e, str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif f(byte[] bArr, int i2, int i3) {
        int nativeCreate = nativeCreate(f2151e, bArr, i2, i3);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static native int nativeCreate(String str, String str2);

    public static native int nativeCreate(String str, byte[] bArr, int i2, int i3);

    public static native boolean nativeDecodeFrame(int i2, int i3);

    public static native int nativeDestroy(int i2);

    public static native int nativeGetCurrentFrame(int i2);

    public static native int nativeGetFrameCount(int i2);

    public static native int nativeGetFrameDelay(int i2, int i3);

    public static native int nativeGetHeight(int i2);

    public static native int nativeGetWidth(int i2);

    public static native boolean nativeWriteTo(int i2, Bitmap bitmap);

    @Override // d.a.c.d.b
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.f2153a, bitmap);
    }

    @Override // d.a.c.d.b
    public int b(int i2) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.f2153a, i2);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // d.a.c.d.b
    public boolean c(int i2) {
        return nativeDecodeFrame(this.f2153a, i2);
    }

    @Override // d.a.c.d.b
    public void close() {
        int i2 = this.f2153a;
        if (i2 == 0) {
            return;
        }
        this.f2153a = 0;
        d.a.c.e.m.h.a().c(new a(i2));
    }

    public void finalize() throws Throwable {
        try {
            close();
            super.finalize();
        } catch (Exception unused) {
        }
    }

    @Override // d.a.c.d.b
    public int getFrameCount() {
        return this.f2156d;
    }

    @Override // d.a.c.d.b
    public int getHeight() {
        return this.f2155c;
    }

    @Override // d.a.c.d.b
    public int getWidth() {
        return this.f2154b;
    }
}
