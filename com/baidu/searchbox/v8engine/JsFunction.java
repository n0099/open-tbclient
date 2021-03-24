package com.baidu.searchbox.v8engine;

import com.baidu.smallgame.sdk.Log;
@NotProguard
/* loaded from: classes3.dex */
public class JsFunction extends JsReleaser {
    public static final String TAG = "JsFunction";
    public boolean mReleaseAfterInvoke;

    public JsFunction(long j, long j2, long j3) {
        super(j, j2, j3);
        this.mReleaseAfterInvoke = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freeIfNeeded() {
        if (this.mReleaseAfterInvoke) {
            release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamBoolean(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamBooleanArray(long j, boolean[] zArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamByteArray(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamCharArray(long j, char[] cArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamDouble(long j, double d2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamDoubleArray(long j, double[] dArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamFloatArray(long j, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamInteger(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamIntegerArray(long j, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamLong(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamLongArray(long j, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamObject(long j, Object obj, Object obj2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamShortArray(long j, short[] sArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamString(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamStringArray(long j, String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamUndefined(long j);

    private native boolean nativeStrictEquals(long j, long j2);

    private void runOnJSThreadSafely(Runnable runnable) {
        V8Engine v8Engine = V8Engine.getInstance(this.mOwnedNativeEngine);
        if (v8Engine == null) {
            Log.e(TAG, Log.getStackTraceString(new Exception("engine object is invalid.")));
        } else {
            v8Engine.runOnJSThread(runnable);
        }
    }

    public void call() {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.1
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamUndefined(j);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public boolean equals(Object obj) {
        if (obj instanceof JsFunction) {
            return strictEquals((JsFunction) obj);
        }
        return false;
    }

    public void setReleaseMode(boolean z) {
        this.mReleaseAfterInvoke = z;
    }

    public boolean strictEquals(JsFunction jsFunction) {
        long j = this.mNativeObject.get();
        long j2 = jsFunction.mNativeObject.get();
        if (this == jsFunction || j == j2) {
            return true;
        }
        if (j == 0 || j2 == 0) {
            return false;
        }
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return nativeStrictEquals(j, j2);
    }

    public void call(final boolean z) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.2
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamBoolean(j, z);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final int i) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.3
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamInteger(j, i);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final long j) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.4
            @Override // java.lang.Runnable
            public void run() {
                long j2 = JsFunction.this.mNativeObject.get();
                if (j2 != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamLong(j2, j);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final double d2) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.5
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamDouble(j, d2);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final String str) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.6
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamString(j, str);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(Object obj) {
        call(obj, true);
    }

    public void call(Object obj, boolean z) {
        call(null, obj, z);
    }

    public void call(final Object obj, final Object obj2, final boolean z) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.7
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamObject(j, obj, obj2, z);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final byte[] bArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.8
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamByteArray(j, bArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final boolean[] zArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.9
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamBooleanArray(j, zArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final int[] iArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.10
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamIntegerArray(j, iArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final long[] jArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.11
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamLongArray(j, jArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final float[] fArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.12
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction.this.invokeJsFunctionParamFloatArray(j, fArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final double[] dArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.13
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamDoubleArray(j, dArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final short[] sArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.14
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamShortArray(j, sArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final char[] cArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.15
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamCharArray(j, cArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final String[] strArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.16
            @Override // java.lang.Runnable
            public void run() {
                long j = JsFunction.this.mNativeObject.get();
                if (j != 0) {
                    JsFunction jsFunction = JsFunction.this;
                    V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamStringArray(j, strArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }
}
