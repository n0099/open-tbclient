package com.baidu.platform.comjni.map.basemap;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class k implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ NABaseMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NABaseMap nABaseMap, long j, long j2) {
        this.c = nABaseMap;
        this.a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Throwable th;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean a;
        boolean a2;
        long j;
        ReadWriteLock readWriteLock4;
        try {
            try {
                readWriteLock3 = this.c.c;
                boolean tryLock = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    try {
                        a = this.c.a(this.a);
                        if (!a) {
                            a2 = this.c.a(this.b);
                            if (!a2) {
                                NABaseMap nABaseMap = this.c;
                                j = this.c.b;
                                nABaseMap.nativeSwitchLayer(j, this.a, this.b);
                            }
                        }
                    } catch (Throwable th2) {
                        z = tryLock;
                        th = th2;
                        if (z) {
                            readWriteLock2 = this.c.c;
                            readWriteLock2.readLock().unlock();
                        }
                        throw th;
                    }
                }
                if (tryLock) {
                    readWriteLock4 = this.c.c;
                    readWriteLock4.readLock().unlock();
                }
            } catch (Exception e) {
                if (0 != 0) {
                    readWriteLock = this.c.c;
                    readWriteLock.readLock().unlock();
                }
            }
        } catch (Throwable th3) {
            z = false;
            th = th3;
        }
    }
}
