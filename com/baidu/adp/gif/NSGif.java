package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.lib.g.k;
/* loaded from: classes.dex */
public class NSGif implements c {
    public static boolean ds = com.baidu.adp.lib.util.g.eW().a("nsgif_jni", 2, new d());
    private int dt;
    private final int du;
    private final int mHeight;
    private final int mWidth;

    private static native int nativeCreate(String str);

    private static native int nativeCreate(byte[] bArr, int i, int i2);

    private static native boolean nativeDecodeFrame(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeDestroy(int i);

    private static native int nativeGetFrameCount(int i);

    private static native int nativeGetFrameDelay(int i, int i2);

    private static native int nativeGetHeight(int i);

    private static native int nativeGetWidth(int i);

    private static native boolean nativeWriteTo(int i, Bitmap bitmap);

    private NSGif(int i) {
        this.dt = i;
        this.mWidth = nativeGetWidth(i);
        this.mHeight = nativeGetHeight(i);
        this.du = nativeGetFrameCount(i);
    }

    public static NSGif n(String str) {
        int nativeCreate = nativeCreate(str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif c(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    @Override // com.baidu.adp.gif.c
    public void close() {
        if (this.dt != 0) {
            int i = this.dt;
            this.dt = 0;
            k.el().a(new e(this, i));
        }
    }

    protected void finalize() {
        try {
            close();
            super.finalize();
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.gif.c
    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.baidu.adp.gif.c
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.baidu.adp.gif.c
    public int bj() {
        return this.du;
    }

    @Override // com.baidu.adp.gif.c
    public int l(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.dt, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // com.baidu.adp.gif.c
    public boolean k(int i) {
        return nativeDecodeFrame(this.dt, i);
    }

    @Override // com.baidu.adp.gif.c
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.dt, bitmap);
    }
}
