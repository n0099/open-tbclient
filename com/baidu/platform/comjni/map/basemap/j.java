package com.baidu.platform.comjni.map.basemap;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f3178a;
    final /* synthetic */ NABaseMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NABaseMap nABaseMap, long j) {
        this.b = nABaseMap;
        this.f3178a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        boolean z;
        Throwable th;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        Set set;
        long j;
        ReadWriteLock readWriteLock4;
        try {
            try {
                readWriteLock3 = this.b.c;
                boolean tryLock = readWriteLock3.writeLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    try {
                        set = this.b.d;
                        set.add(Long.valueOf(this.f3178a));
                        NABaseMap nABaseMap = this.b;
                        j = this.b.b;
                        nABaseMap.nativeRemoveLayer(j, this.f3178a);
                    } catch (Throwable th2) {
                        z = tryLock;
                        th = th2;
                        if (z) {
                            readWriteLock2 = this.b.c;
                            readWriteLock2.writeLock().unlock();
                        }
                        throw th;
                    }
                }
                if (tryLock) {
                    readWriteLock4 = this.b.c;
                    readWriteLock4.writeLock().unlock();
                }
            } catch (Throwable th3) {
                z = false;
                th = th3;
            }
        } catch (Exception e) {
            if (0 != 0) {
                readWriteLock = this.b.c;
                readWriteLock.writeLock().unlock();
            }
        }
    }
}
