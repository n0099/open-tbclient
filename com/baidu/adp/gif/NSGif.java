package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/* loaded from: classes.dex */
public class NSGif implements c {
    public static boolean a = com.baidu.adp.lib.util.f.a().a("nsgif_jni", 2, new d());
    private int b;
    private final int c;
    private final int d;
    private final int e;

    private static native int nativeCreate(String str);

    private static native int nativeCreate(byte[] bArr, int i, int i2);

    private static native boolean nativeDecodeFrame(int i, int i2);

    private static native int nativeDestroy(int i);

    private static native int nativeGetFrameCount(int i);

    private static native int nativeGetFrameDelay(int i, int i2);

    private static native int nativeGetHeight(int i);

    private static native int nativeGetWidth(int i);

    private static native boolean nativeWriteTo(int i, Bitmap bitmap);

    private NSGif(int i) {
        this.b = i;
        this.c = nativeGetWidth(i);
        this.d = nativeGetHeight(i);
        this.e = nativeGetFrameCount(i);
    }

    public static NSGif a(String str) {
        int nativeCreate = nativeCreate(str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif a(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    @Override // com.baidu.adp.gif.c
    public void a() {
        this.b = nativeDestroy(this.b);
    }

    protected void finalize() {
        try {
            a();
            super.finalize();
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.gif.c
    public int b() {
        return this.c;
    }

    @Override // com.baidu.adp.gif.c
    public int c() {
        return this.d;
    }

    @Override // com.baidu.adp.gif.c
    public int d() {
        return this.e;
    }

    @Override // com.baidu.adp.gif.c
    public int b(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.b, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // com.baidu.adp.gif.c
    public boolean a(int i) {
        return nativeDecodeFrame(this.b, i);
    }

    @Override // com.baidu.adp.gif.c
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.b, bitmap);
    }
}
