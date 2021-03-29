package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.base.BdBaseApplication;
import d.b.b.e.p.h;
import d.b.b.e.p.i;
/* loaded from: classes.dex */
public class NSGif implements d.b.b.d.b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2134e = BdBaseApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2135f = h.f().k("nsgif_jni", 2, new b());

    /* renamed from: a  reason: collision with root package name */
    public int f2136a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2137b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2138c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2139d;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2140e;

        public a(int i) {
            this.f2140e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NSGif.nativeDestroy(this.f2140e);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends i {
        @Override // d.b.b.e.p.i
        public void a(boolean z) {
            NSGif.f2135f = z;
        }
    }

    public NSGif(int i) {
        this.f2136a = i;
        this.f2137b = nativeGetWidth(i);
        this.f2138c = nativeGetHeight(i);
        this.f2139d = nativeGetFrameCount(i);
    }

    public static NSGif e(String str) {
        int nativeCreate = nativeCreate(f2134e, str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif f(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(f2134e, bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static native int nativeCreate(String str, String str2);

    public static native int nativeCreate(String str, byte[] bArr, int i, int i2);

    public static native boolean nativeDecodeFrame(int i, int i2);

    public static native int nativeDestroy(int i);

    public static native int nativeGetCurrentFrame(int i);

    public static native int nativeGetFrameCount(int i);

    public static native int nativeGetFrameDelay(int i, int i2);

    public static native int nativeGetHeight(int i);

    public static native int nativeGetWidth(int i);

    public static native boolean nativeWriteTo(int i, Bitmap bitmap);

    @Override // d.b.b.d.b
    public int a(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.f2136a, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // d.b.b.d.b
    public boolean b(int i) {
        return nativeDecodeFrame(this.f2136a, i);
    }

    @Override // d.b.b.d.b
    public boolean c(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.f2136a, bitmap);
    }

    @Override // d.b.b.d.b
    public void close() {
        int i = this.f2136a;
        if (i == 0) {
            return;
        }
        this.f2136a = 0;
        d.b.b.e.m.h.a().c(new a(i));
    }

    public void finalize() throws Throwable {
        try {
            close();
            super.finalize();
        } catch (Exception unused) {
        }
    }

    @Override // d.b.b.d.b
    public int getFrameCount() {
        return this.f2139d;
    }

    @Override // d.b.b.d.b
    public int getHeight() {
        return this.f2138c;
    }

    @Override // d.b.b.d.b
    public int getWidth() {
        return this.f2137b;
    }
}
