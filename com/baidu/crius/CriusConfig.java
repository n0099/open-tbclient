package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes10.dex */
public class CriusConfig {
    long mNativePointer = jni_CSConfigNew();

    private native void jni_CSConfigFree(long j);

    private native long jni_CSConfigNew();

    private native void jni_CSConfigSetLoggerEnabled(long j, boolean z);

    private native void jni_CSConfigSetPointScaleFactor(long j, float f);

    static {
        System.loadLibrary("criusbase");
        System.loadLibrary("crius");
    }

    public CriusConfig() {
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    protected void finalize() throws Throwable {
        try {
            jni_CSConfigFree(this.mNativePointer);
        } finally {
            super.finalize();
        }
    }

    public void setPointScaleFactor(float f) {
        jni_CSConfigSetPointScaleFactor(this.mNativePointer, f);
    }

    public void setLoggerEnabled(boolean z) {
        jni_CSConfigSetLoggerEnabled(this.mNativePointer, z);
    }
}
