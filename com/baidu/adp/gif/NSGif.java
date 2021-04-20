package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.base.BdBaseApplication;
import d.b.c.e.p.h;
import d.b.c.e.p.i;
/* loaded from: classes.dex */
public class NSGif implements d.b.c.d.b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2169e = BdBaseApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2170f = h.f().k("nsgif_jni", 2, new b());

    /* renamed from: a  reason: collision with root package name */
    public int f2171a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2172b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2173c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2174d;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2175e;

        public a(int i) {
            this.f2175e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NSGif.nativeDestroy(this.f2175e);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends i {
        @Override // d.b.c.e.p.i
        public void a(boolean z) {
            NSGif.f2170f = z;
        }
    }

    public NSGif(int i) {
        this.f2171a = i;
        this.f2172b = nativeGetWidth(i);
        this.f2173c = nativeGetHeight(i);
        this.f2174d = nativeGetFrameCount(i);
    }

    public static NSGif e(String str) {
        int nativeCreate = nativeCreate(f2169e, str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif f(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(f2169e, bArr, i, i2);
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

    @Override // d.b.c.d.b
    public int a(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.f2171a, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // d.b.c.d.b
    public boolean b(int i) {
        return nativeDecodeFrame(this.f2171a, i);
    }

    @Override // d.b.c.d.b
    public boolean c(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.f2171a, bitmap);
    }

    @Override // d.b.c.d.b
    public void close() {
        int i = this.f2171a;
        if (i == 0) {
            return;
        }
        this.f2171a = 0;
        d.b.c.e.m.h.a().c(new a(i));
    }

    public void finalize() throws Throwable {
        try {
            close();
            super.finalize();
        } catch (Exception unused) {
        }
    }

    @Override // d.b.c.d.b
    public int getFrameCount() {
        return this.f2174d;
    }

    @Override // d.b.c.d.b
    public int getHeight() {
        return this.f2173c;
    }

    @Override // d.b.c.d.b
    public int getWidth() {
        return this.f2172b;
    }
}
