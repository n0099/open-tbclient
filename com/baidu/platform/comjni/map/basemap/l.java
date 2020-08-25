package com.baidu.platform.comjni.map.basemap;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class l implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ NABaseMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NABaseMap nABaseMap, long j) {
        this.b = nABaseMap;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Throwable th;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean a;
        long j;
        ReadWriteLock readWriteLock4;
        try {
            try {
                readWriteLock3 = this.b.c;
                boolean tryLock = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    try {
                        a = this.b.a(this.a);
                        if (!a) {
                            NABaseMap nABaseMap = this.b;
                            j = this.b.b;
                            nABaseMap.nativeClearSDKLayer(j, this.a);
                        }
                    } catch (Throwable th2) {
                        z = tryLock;
                        th = th2;
                        if (z) {
                            readWriteLock2 = this.b.c;
                            readWriteLock2.readLock().unlock();
                        }
                        throw th;
                    }
                }
                if (tryLock) {
                    readWriteLock4 = this.b.c;
                    readWriteLock4.readLock().unlock();
                }
            } catch (Exception e) {
                if (0 != 0) {
                    readWriteLock = this.b.c;
                    readWriteLock.readLock().unlock();
                }
            }
        } catch (Throwable th3) {
            z = false;
            th = th3;
        }
    }
}
