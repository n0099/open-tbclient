package com.baidu.searchbox.v8engine;

import com.baidu.smallgame.sdk.Log;
@NotProguard
/* loaded from: classes2.dex */
public class JsFunction {
    private static final String TAG = "JsFunction";
    private long mNativeObject;
    private final long mOwnedNativeEngine;
    private final long mOwnedThreadId;
    private boolean mReleaseAfterInvoke = true;

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamBoolean(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamBooleanArray(long j, boolean[] zArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamByteArray(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamCharArray(long j, char[] cArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamDouble(long j, double d);

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

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeRelease(long j);

    private native boolean nativeStrictEquals(long j, long j2);

    public JsFunction(long j, long j2, long j3) {
        this.mNativeObject = 0L;
        this.mNativeObject = j;
        this.mOwnedThreadId = j3;
        this.mOwnedNativeEngine = j2;
    }

    public void setReleaseMode(boolean z) {
        this.mReleaseAfterInvoke = z;
    }

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
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamUndefined(JsFunction.this.mNativeObject);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final boolean z) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.2
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamBoolean(JsFunction.this.mNativeObject, z);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final int i) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.3
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamInteger(JsFunction.this.mNativeObject, i);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final long j) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.4
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamLong(JsFunction.this.mNativeObject, j);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final double d) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.5
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamDouble(JsFunction.this.mNativeObject, d);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final String str) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.6
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamString(JsFunction.this.mNativeObject, str);
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
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamObject(JsFunction.this.mNativeObject, obj, obj2, z);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final byte[] bArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.8
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamByteArray(JsFunction.this.mNativeObject, bArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final boolean[] zArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.9
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamBooleanArray(JsFunction.this.mNativeObject, zArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final int[] iArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.10
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamIntegerArray(JsFunction.this.mNativeObject, iArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final long[] jArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.11
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamLongArray(JsFunction.this.mNativeObject, jArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final float[] fArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.12
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    JsFunction.this.invokeJsFunctionParamFloatArray(JsFunction.this.mNativeObject, fArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final double[] dArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.13
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamDoubleArray(JsFunction.this.mNativeObject, dArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final short[] sArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.14
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamShortArray(JsFunction.this.mNativeObject, sArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final char[] cArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.15
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamCharArray(JsFunction.this.mNativeObject, cArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public void call(final String[] strArr) {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.16
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.invokeJsFunctionParamStringArray(JsFunction.this.mNativeObject, strArr);
                    JsFunction.this.freeIfNeeded();
                }
            }
        });
    }

    public boolean strictEquals(JsFunction jsFunction) {
        if (this.mNativeObject == 0 || jsFunction == null) {
            return false;
        }
        if (this == jsFunction || this.mNativeObject == jsFunction.mNativeObject) {
            return true;
        }
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return nativeStrictEquals(this.mNativeObject, jsFunction.mNativeObject);
    }

    public boolean equals(Object obj) {
        if (obj instanceof JsFunction) {
            return strictEquals((JsFunction) obj);
        }
        return false;
    }

    public void release() {
        runOnJSThreadSafely(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsFunction.17
            @Override // java.lang.Runnable
            public void run() {
                if (JsFunction.this.mNativeObject != 0) {
                    V8Engine.checkValid(JsFunction.this.mOwnedNativeEngine, JsFunction.this.mOwnedThreadId);
                    JsFunction.this.nativeRelease(JsFunction.this.mNativeObject);
                    JsFunction.this.mNativeObject = 0L;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freeIfNeeded() {
        if (this.mReleaseAfterInvoke && this.mNativeObject != 0) {
            nativeRelease(this.mNativeObject);
            this.mNativeObject = 0L;
        }
    }
}
