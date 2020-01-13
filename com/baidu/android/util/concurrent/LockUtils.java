package com.baidu.android.util.concurrent;

import java.util.concurrent.locks.Lock;
/* loaded from: classes12.dex */
public final class LockUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "LockUtils";

    /* loaded from: classes12.dex */
    public interface WorkInLock {
        Object work();
    }

    private LockUtils() {
    }

    public static Object doWorkInLock(Lock lock, WorkInLock workInLock) {
        Object obj = null;
        if (lock != null && workInLock != null) {
            try {
                lock.lock();
                try {
                    obj = workInLock.work();
                    try {
                        lock.unlock();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    try {
                        lock.unlock();
                    } catch (Exception e3) {
                    }
                } catch (Throwable th) {
                    try {
                        lock.unlock();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
            }
        }
        return obj;
    }
}
