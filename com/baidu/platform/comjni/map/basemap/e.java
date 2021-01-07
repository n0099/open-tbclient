package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle[] f4731a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f4732b;
    final /* synthetic */ NABaseMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NABaseMap nABaseMap, Bundle[] bundleArr, int i) {
        this.c = nABaseMap;
        this.f4731a = bundleArr;
        this.f4732b = i;
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
                    j = this.c.f4724b;
                    nABaseMap.nativeAddOverlayItems(j, this.f4731a, this.f4732b);
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
