package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle[] f4730a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f4731b;
    final /* synthetic */ NABaseMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NABaseMap nABaseMap, Bundle[] bundleArr, int i) {
        this.c = nABaseMap;
        this.f4730a = bundleArr;
        this.f4731b = i;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        ReadWriteLock readWriteLock4;
        long j;
        b2 = this.c.b();
        if (b2) {
            boolean z = false;
            try {
                readWriteLock3 = this.c.c;
                z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    NABaseMap nABaseMap = this.c;
                    j = this.c.f4723b;
                    nABaseMap.nativeAddOverlayItems(j, this.f4730a, this.f4731b);
                }
                if (z) {
                    readWriteLock4 = this.c.c;
                    readWriteLock4.readLock().unlock();
                }
            } catch (Exception e) {
                if (z) {
                    readWriteLock2 = this.c.c;
                    readWriteLock2.readLock().unlock();
                }
            } catch (Throwable th) {
                if (z) {
                    readWriteLock = this.c.c;
                    readWriteLock.readLock().unlock();
                }
                throw th;
            }
        }
    }
}
