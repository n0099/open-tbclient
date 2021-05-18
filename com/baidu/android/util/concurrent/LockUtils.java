package com.baidu.android.util.concurrent;

import android.util.Log;
import java.util.concurrent.locks.Lock;
@Deprecated
/* loaded from: classes.dex */
public final class LockUtils {
    public static boolean DEBUG = false;
    public static final String TAG = "LockUtils";

    /* loaded from: classes.dex */
    public interface WorkInLock {
        Object work();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
        if (com.baidu.android.util.concurrent.LockUtils.DEBUG == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
        android.util.Log.d(com.baidu.android.util.concurrent.LockUtils.TAG, "Utility.doWorkInLock [lock.unlock()] Exception.", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
        if (com.baidu.android.util.concurrent.LockUtils.DEBUG == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object doWorkInLock(Lock lock, WorkInLock workInLock) {
        Object obj = null;
        if (lock != null && workInLock != null) {
            try {
                lock.lock();
                try {
                    try {
                        obj = workInLock.work();
                        try {
                            lock.unlock();
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        if (DEBUG) {
                            Log.d(TAG, "Utility.doWorkInLock [work.work()] Exception.", e3);
                        }
                        try {
                            lock.unlock();
                        } catch (Exception e4) {
                            e = e4;
                        }
                    }
                    return obj;
                } catch (Throwable th) {
                    try {
                        lock.unlock();
                    } catch (Exception e5) {
                        if (DEBUG) {
                            Log.d(TAG, "Utility.doWorkInLock [lock.unlock()] Exception.", e5);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                if (DEBUG) {
                    Log.d(TAG, "Utility.doWorkInLock [lock.lock()] Exception.", e6);
                }
                return null;
            }
        }
        if (DEBUG) {
            Log.d(TAG, "Utility.doWorkInLock [parameters is null] :lock = " + lock + ", work = " + workInLock);
        }
        return null;
    }
}
