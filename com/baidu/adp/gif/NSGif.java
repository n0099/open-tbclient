package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.io.File;
/* loaded from: classes.dex */
public class NSGif implements c {
    public static boolean a;
    private int b;
    private final int c;
    private final int d;
    private final int e;

    private static native int nativeCreate(String str);

    private static native boolean nativeDecodeFrame(int i, int i2);

    private static native int nativeDestroy(int i);

    private static native int nativeGetCurrentFrame(int i);

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
    public int c() {
        return this.c;
    }

    @Override // com.baidu.adp.gif.c
    public int d() {
        return this.d;
    }

    @Override // com.baidu.adp.gif.c
    public int e() {
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
    public int b() {
        return nativeGetCurrentFrame(this.b);
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

    static {
        try {
            if (com.baidu.adp.a.b.a() != null && com.baidu.adp.a.b.a().getApplicationInfo() != null) {
                String str = com.baidu.adp.a.b.a().getApplicationInfo().dataDir + File.separator + "lib/libnsgif_jni.so";
                if (new File(str).exists()) {
                    System.load(str);
                } else {
                    System.loadLibrary("nsgif_jni");
                }
            }
            a = true;
        } catch (Throwable th) {
            try {
                System.loadLibrary("nsgif_jni");
                a = true;
            } catch (Throwable th2) {
                a = false;
            }
        }
    }
}
