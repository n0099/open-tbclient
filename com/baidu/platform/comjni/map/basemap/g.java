package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f4734a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NABaseMap f4735b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NABaseMap nABaseMap, Bundle bundle) {
        this.f4735b = nABaseMap;
        this.f4734a = bundle;
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
        b2 = this.f4735b.b();
        if (b2) {
            boolean z = false;
            try {
                readWriteLock3 = this.f4735b.c;
                z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    NABaseMap nABaseMap = this.f4735b;
                    j = this.f4735b.f4723b;
                    nABaseMap.nativeRemoveOneOverlayItem(j, this.f4734a);
                }
                if (z) {
                    readWriteLock4 = this.f4735b.c;
                    readWriteLock4.readLock().unlock();
                }
            } catch (Exception e) {
                if (z) {
                    readWriteLock2 = this.f4735b.c;
                    readWriteLock2.readLock().unlock();
                }
            } catch (Throwable th) {
                if (z) {
                    readWriteLock = this.f4735b.c;
                    readWriteLock.readLock().unlock();
                }
                throw th;
            }
        }
    }
}
