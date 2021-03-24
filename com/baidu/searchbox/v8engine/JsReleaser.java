package com.baidu.searchbox.v8engine;

import com.baidu.smallgame.sdk.Log;
import java.util.concurrent.atomic.AtomicLong;
@NotProguard
/* loaded from: classes3.dex */
public abstract class JsReleaser {
    public static final boolean DEBUG = false;
    public static final String TAG = "JsReleaser";
    public AtomicLong mNativeObject;
    public final long mOwnedNativeEngine;
    public final long mOwnedThreadId;

    public JsReleaser() {
        this.mNativeObject = new AtomicLong(0L);
        this.mOwnedThreadId = 0L;
        this.mOwnedNativeEngine = 0L;
    }

    public static void safeRelease(final long j, final long j2, final long j3, final boolean z, final String str) {
        V8Engine v8Engine = V8Engine.getInstance(j);
        if (v8Engine != null) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsReleaser.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j3 == 0) {
                        return;
                    }
                    long id = Thread.currentThread().getId();
                    boolean z2 = j2 == id;
                    if (!z2) {
                        Log.w(JsReleaser.TAG, "[JsReleaser][ERROR] Incorrect thread ID, current ID = " + id + ", expect ID = " + j2 + ", finalize=" + z);
                        return;
                    }
                    V8Engine.nativeDeleteJsReleaser(j, j3, z2);
                }
            });
        }
    }

    public void finalize() throws Throwable {
        try {
            long andSet = this.mNativeObject.getAndSet(0L);
            if (andSet != 0) {
                safeRelease(this.mOwnedNativeEngine, this.mOwnedThreadId, andSet, true, getClass().getName());
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public long nativePtr() {
        return this.mNativeObject.get();
    }

    public void release() {
        long andSet = this.mNativeObject.getAndSet(0L);
        if (andSet != 0) {
            safeRelease(this.mOwnedNativeEngine, this.mOwnedThreadId, andSet, false, getClass().getName());
        }
    }

    public JsReleaser(long j, long j2, long j3) {
        AtomicLong atomicLong = new AtomicLong(0L);
        this.mNativeObject = atomicLong;
        atomicLong.set(j);
        this.mOwnedThreadId = j3;
        this.mOwnedNativeEngine = j2;
    }
}
