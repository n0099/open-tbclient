package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.lib.h.k;
import com.baidu.adp.lib.util.g;
/* loaded from: classes.dex */
public class NSGif implements b {
    public static boolean qV = g.iC().a("nsgif_jni", 2, new c());
    private final int mHeight;
    private final int mWidth;
    private int qW;
    private final int qX;

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
        this.qW = i;
        this.mWidth = nativeGetWidth(i);
        this.mHeight = nativeGetHeight(i);
        this.qX = nativeGetFrameCount(i);
    }

    public static NSGif f(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    @Override // com.baidu.adp.gif.b
    public void close() {
        if (this.qW != 0) {
            int i = this.qW;
            this.qW = 0;
            k.hk().b(new d(this, i));
        }
    }

    protected void finalize() {
        try {
            close();
            super.finalize();
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.gif.b
    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.baidu.adp.gif.b
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.baidu.adp.gif.b
    public int ff() {
        return this.qX;
    }

    @Override // com.baidu.adp.gif.b
    public int H(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.qW, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // com.baidu.adp.gif.b
    public boolean G(int i) {
        return nativeDecodeFrame(this.qW, i);
    }

    @Override // com.baidu.adp.gif.b
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.qW, bitmap);
    }
}
