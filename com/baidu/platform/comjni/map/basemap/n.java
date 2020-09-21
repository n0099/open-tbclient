package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class n implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ NABaseMap e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NABaseMap nABaseMap, long j, long j2, boolean z, Bundle bundle) {
        this.e = nABaseMap;
        this.a = j;
        this.b = j2;
        this.c = z;
        this.d = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        boolean z;
        Throwable th;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean a;
        long j;
        ReadWriteLock readWriteLock4;
        try {
            try {
                readWriteLock3 = this.e.c;
                boolean tryLock = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    try {
                        a = this.e.a(this.a);
                        if (!a) {
                            NABaseMap nABaseMap = this.e;
                            j = this.e.b;
                            nABaseMap.nativeSetFocus(j, this.a, this.b, this.c, this.d);
                        }
                    } catch (Throwable th2) {
                        z = tryLock;
                        th = th2;
                        if (z) {
                            readWriteLock2 = this.e.c;
                            readWriteLock2.readLock().unlock();
                        }
                        throw th;
                    }
                }
                if (tryLock) {
                    readWriteLock4 = this.e.c;
                    readWriteLock4.readLock().unlock();
                }
            } catch (Throwable th3) {
                z = false;
                th = th3;
            }
        } catch (Exception e) {
            if (0 != 0) {
                readWriteLock = this.e.c;
                readWriteLock.readLock().unlock();
            }
        }
    }
}
