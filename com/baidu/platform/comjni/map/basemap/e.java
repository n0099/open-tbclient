package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements Runnable {
    final /* synthetic */ Bundle[] a;
    final /* synthetic */ int b;
    final /* synthetic */ NABaseMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NABaseMap nABaseMap, Bundle[] bundleArr, int i) {
        this.c = nABaseMap;
        this.a = bundleArr;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean z;
        Throwable th;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        long j;
        ReadWriteLock readWriteLock4;
        b = this.c.b();
        if (!b) {
            return;
        }
        try {
            try {
                readWriteLock3 = this.c.c;
                boolean tryLock = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    try {
                        NABaseMap nABaseMap = this.c;
                        j = this.c.b;
                        nABaseMap.nativeAddOverlayItems(j, this.a, this.b);
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
