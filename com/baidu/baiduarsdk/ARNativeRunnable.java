package com.baidu.baiduarsdk;
/* loaded from: classes3.dex */
public final class ARNativeRunnable implements Runnable {
    private long mNativeRunnable;

    private ARNativeRunnable(long j) {
        this.mNativeRunnable = j;
    }

    private native void nativeFinalize();

    private native void nativeRun();

    protected void finalize() {
        try {
            nativeFinalize();
        } catch (Throwable th) {
        }
        super.finalize();
    }

    @Override // java.lang.Runnable
    public void run() {
        nativeRun();
    }
}
