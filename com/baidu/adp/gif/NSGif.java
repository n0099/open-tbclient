package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.lib.g.l;
import com.baidu.adp.lib.util.h;
/* loaded from: classes.dex */
public class NSGif implements c {
    public static boolean qX = h.iO().a("nsgif_jni", 2, new d());
    private final int mHeight;
    private final int mWidth;
    private int qY;
    private final int qZ;

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
        this.qY = i;
        this.mWidth = nativeGetWidth(i);
        this.mHeight = nativeGetHeight(i);
        this.qZ = nativeGetFrameCount(i);
    }

    public static NSGif M(String str) {
        int nativeCreate = nativeCreate(str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif e(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    @Override // com.baidu.adp.gif.c
    public void close() {
        if (this.qY != 0) {
            int i = this.qY;
            this.qY = 0;
            l.ht().b(new e(this, i));
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
    public int fl() {
        return this.qZ;
    }

    @Override // com.baidu.adp.gif.c
    public int E(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.qY, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // com.baidu.adp.gif.c
    public boolean D(int i) {
        return nativeDecodeFrame(this.qY, i);
    }

    @Override // com.baidu.adp.gif.c
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.qY, bitmap);
    }
}
