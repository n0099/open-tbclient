package com.baidu.platform.comjni.map.basemap;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f4740a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NABaseMap f4741b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NABaseMap nABaseMap, long j) {
        this.f4741b = nABaseMap;
        this.f4740a = j;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        ReadWriteLock readWriteLock4;
        Set set;
        long j;
        boolean z = false;
        try {
            readWriteLock3 = this.f4741b.c;
            z = readWriteLock3.writeLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                set = this.f4741b.d;
                set.add(Long.valueOf(this.f4740a));
                NABaseMap nABaseMap = this.f4741b;
                j = this.f4741b.f4723b;
                nABaseMap.nativeRemoveLayer(j, this.f4740a);
            }
            if (z) {
                readWriteLock4 = this.f4741b.c;
                readWriteLock4.writeLock().unlock();
            }
        } catch (Exception e) {
            if (z) {
                readWriteLock2 = this.f4741b.c;
                readWriteLock2.writeLock().unlock();
            }
        } catch (Throwable th) {
            if (z) {
                readWriteLock = this.f4741b.c;
                readWriteLock.writeLock().unlock();
            }
            throw th;
        }
    }
}
