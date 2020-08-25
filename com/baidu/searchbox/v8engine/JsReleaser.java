package com.baidu.searchbox.v8engine;

import com.baidu.smallgame.sdk.Log;
import java.util.concurrent.atomic.AtomicLong;
@NotProguard
/* loaded from: classes20.dex */
public abstract class JsReleaser {
    private static final boolean DEBUG = false;
    private static final String TAG = "JsReleaser";
    public AtomicLong mNativeObject;
    final long mOwnedNativeEngine;
    final long mOwnedThreadId;

    public JsReleaser() {
        this.mNativeObject = new AtomicLong(0L);
        this.mOwnedThreadId = 0L;
        this.mOwnedNativeEngine = 0L;
    }

    public JsReleaser(long j, long j2, long j3) {
        this.mNativeObject = new AtomicLong(0L);
        this.mNativeObject.set(j);
        this.mOwnedThreadId = j3;
        this.mOwnedNativeEngine = j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            long andSet = this.mNativeObject.getAndSet(0L);
            if (andSet != 0) {
                safeRelease(this.mOwnedNativeEngine, this.mOwnedThreadId, andSet, true, getClass().getName());
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                super.finalize();
            }
        }
    }

    private static void safeRelease(final long j, final long j2, final long j3, final boolean z, final String str) {
        V8Engine v8Engine = V8Engine.getInstance(j);
        if (v8Engine != null) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.JsReleaser.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j3 != 0) {
                        long id = Thread.currentThread().getId();
                        boolean z2 = j2 == id;
                        if (!z2) {
                            Log.w(JsReleaser.TAG, "[JsReleaser][ERROR] Incorrect thread ID, current ID = " + id + ", expect ID = " + j2 + ", finalize=" + z);
                        } else {
                            V8Engine.nativeDeleteJsReleaser(j, j3, z2);
                        }
                    }
                }
            });
        }
    }

    public void release() {
        long andSet = this.mNativeObject.getAndSet(0L);
        if (andSet != 0) {
            safeRelease(this.mOwnedNativeEngine, this.mOwnedThreadId, andSet, false, getClass().getName());
        }
    }

    public long nativePtr() {
        return this.mNativeObject.get();
    }
}
