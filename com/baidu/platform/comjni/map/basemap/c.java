package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f3171a;
    final /* synthetic */ NABaseMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NABaseMap nABaseMap, Bundle bundle) {
        this.b = nABaseMap;
        this.f3171a = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Throwable th;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        long j;
        boolean a2;
        ReadWriteLock readWriteLock4;
        ReadWriteLock readWriteLock5;
        try {
            try {
                readWriteLock3 = this.b.c;
                boolean tryLock = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    try {
                        if (this.f3171a != null) {
                            a2 = this.b.a(this.f3171a.getLong("itemaddr", 0L));
                            if (a2) {
                                if (tryLock) {
                                    readWriteLock4 = this.b.c;
                                    readWriteLock4.readLock().unlock();
                                    return;
                                }
                                return;
                            }
                        }
                        NABaseMap nABaseMap = this.b;
                        j = this.b.b;
                        nABaseMap.nativeRemoveItemData(j, this.f3171a);
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
                    readWriteLock5 = this.b.c;
                    readWriteLock5.readLock().unlock();
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
