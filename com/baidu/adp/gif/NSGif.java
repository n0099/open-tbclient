package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.h;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class NSGif implements b {
    private static final String mc = BdBaseApplication.getInst().getCacheDir().getAbsolutePath();
    public static boolean md = h.gX().a("nsgif_jni", 2, new i() { // from class: com.baidu.adp.gif.NSGif.2
        @Override // com.baidu.adp.lib.util.i
        public void callback(boolean z) {
            NSGif.md = z;
        }
    });
    private final int mFrameCount;
    private final int mHeight;
    private final int mWidth;
    private int mf;

    private static native int nativeCreate(String str, String str2);

    private static native int nativeCreate(String str, byte[] bArr, int i, int i2);

    private static native boolean nativeDecodeFrame(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeDestroy(int i);

    private static native int nativeGetCurrentFrame(int i);

    private static native int nativeGetFrameCount(int i);

    private static native int nativeGetFrameDelay(int i, int i2);

    private static native int nativeGetHeight(int i);

    private static native int nativeGetWidth(int i);

    private static native boolean nativeWriteTo(int i, Bitmap bitmap);

    private NSGif(int i) {
        this.mf = i;
        this.mWidth = nativeGetWidth(i);
        this.mHeight = nativeGetHeight(i);
        this.mFrameCount = nativeGetFrameCount(i);
    }

    public static NSGif S(String str) {
        int nativeCreate = nativeCreate(mc, str);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    public static NSGif e(byte[] bArr, int i, int i2) {
        int nativeCreate = nativeCreate(mc, bArr, i, i2);
        if (nativeCreate != 0) {
            return new NSGif(nativeCreate);
        }
        return null;
    }

    @Override // com.baidu.adp.gif.b
    public void close() {
        if (this.mf != 0) {
            final int i = this.mf;
            this.mf = 0;
            com.baidu.adp.lib.g.h.ga().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.adp.gif.NSGif.1
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
    public int getFrameCount() {
        return this.mFrameCount;
    }

    @Override // com.baidu.adp.gif.b
    public int A(int i) {
        int nativeGetFrameDelay = nativeGetFrameDelay(this.mf, i);
        if (nativeGetFrameDelay <= 0) {
            return 100;
        }
        return nativeGetFrameDelay * 10;
    }

    @Override // com.baidu.adp.gif.b
    public boolean z(int i) {
        return nativeDecodeFrame(this.mf, i);
    }

    @Override // com.baidu.adp.gif.b
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return false;
        }
        return nativeWriteTo(this.mf, bitmap);
    }
}
