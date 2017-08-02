package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.lib.util.g;
import com.baidu.adp.lib.util.h;
/* loaded from: classes.dex */
public class NSGif implements b {
    public static boolean rm = g.gT().a("nsgif_jni", 2, new h() { // from class: com.baidu.adp.gif.NSGif.2
        @Override // com.baidu.adp.lib.util.h
        public void p(boolean z) {
            NSGif.rm = z;
        }
    });
    private final int mFrameCount;
    private final int mHeight;
    private final int mWidth;
    private int ro;

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
        this.ro = i;
        this.mWidth = nativeGetWidth(i);
        this.mHeight = nativeGetHeight(i);
        this.mFrameCount = nativeGetFrameCount(i);
    }

    public static NSGif F(String str) {
        int nativeCreate = nativeCreate(str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif h(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    @Override // com.baidu.adp.gif.b
    public void close() {
        if (this.ro != 0) {
            final int i = this.ro;
            this.ro = 0;
            com.baidu.adp.lib.g.h.fQ().e(new Runnable() { // from class: com.baidu.adp.gif.NSGif.1
                @Override // java.lang.Runnable
                public void run() {
                    NSGif.nativeDestroy(i);
                }
            });
        }
    }

    protected void finalize() throws Throwable {
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
    public int dD() {
        return this.mFrameCount;
    }

    @Override // com.baidu.adp.gif.b
    public int U(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.ro, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // com.baidu.adp.gif.b
    public boolean T(int i) {
        return nativeDecodeFrame(this.ro, i);
    }

    @Override // com.baidu.adp.gif.b
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.ro, bitmap);
    }
}
