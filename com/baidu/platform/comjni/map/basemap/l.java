package com.baidu.platform.comjni.map.basemap;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f4744a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NABaseMap f4745b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NABaseMap nABaseMap, long j) {
        this.f4745b = nABaseMap;
        this.f4744a = j;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        ReadWriteLock readWriteLock4;
        boolean a2;
        long j;
        boolean z = false;
        try {
            readWriteLock3 = this.f4745b.c;
            z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.f4745b.a(this.f4744a);
                if (!a2) {
                    NABaseMap nABaseMap = this.f4745b;
                    j = this.f4745b.f4723b;
                    nABaseMap.nativeClearSDKLayer(j, this.f4744a);
                }
            }
            if (z) {
                readWriteLock4 = this.f4745b.c;
                readWriteLock4.readLock().unlock();
            }
        } catch (Exception e) {
            if (z) {
                readWriteLock2 = this.f4745b.c;
                readWriteLock2.readLock().unlock();
            }
        } catch (Throwable th) {
            if (z) {
                readWriteLock = this.f4745b.c;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
    }
}
