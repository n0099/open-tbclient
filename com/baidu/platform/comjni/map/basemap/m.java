package com.baidu.platform.comjni.map.basemap;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f4746a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NABaseMap f4747b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NABaseMap nABaseMap, long j) {
        this.f4747b = nABaseMap;
        this.f4746a = j;
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
            readWriteLock3 = this.f4747b.c;
            z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.f4747b.a(this.f4746a);
                if (!a2) {
                    NABaseMap nABaseMap = this.f4747b;
                    j = this.f4747b.f4723b;
                    nABaseMap.nativeClearLayer(j, this.f4746a);
                }
            }
            if (z) {
                readWriteLock4 = this.f4747b.c;
                readWriteLock4.readLock().unlock();
            }
        } catch (Exception e) {
            if (z) {
                readWriteLock2 = this.f4747b.c;
                readWriteLock2.readLock().unlock();
            }
        } catch (Throwable th) {
            if (z) {
                readWriteLock = this.f4747b.c;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
    }
}
