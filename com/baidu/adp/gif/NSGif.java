package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.lib.h.k;
import com.baidu.adp.lib.util.g;
/* loaded from: classes.dex */
public class NSGif implements b {
    public static boolean gY = g.fc().a("nsgif_jni", 2, new c());
    private int gZ;
    private final int ha;
    private final int mHeight;
    private final int mWidth;

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
        this.gZ = i;
        this.mWidth = nativeGetWidth(i);
        this.mHeight = nativeGetHeight(i);
        this.ha = nativeGetFrameCount(i);
    }

    public static NSGif e(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    @Override // com.baidu.adp.gif.b
    public void close() {
        if (this.gZ != 0) {
            int i = this.gZ;
            this.gZ = 0;
            k.dM().b(new d(this, i));
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
    public int bC() {
        return this.ha;
    }

    @Override // com.baidu.adp.gif.b
    public int F(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.gZ, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // com.baidu.adp.gif.b
    public boolean E(int i) {
        return nativeDecodeFrame(this.gZ, i);
    }

    @Override // com.baidu.adp.gif.b
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.gZ, bitmap);
    }
}
