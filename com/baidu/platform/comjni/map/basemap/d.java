package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f4729a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NABaseMap f4730b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NABaseMap nABaseMap, Bundle bundle) {
        this.f4730b = nABaseMap;
        this.f4729a = bundle;
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
        b2 = this.f4730b.b();
        if (b2) {
            boolean z = false;
            try {
                readWriteLock3 = this.f4730b.c;
                z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    NABaseMap nABaseMap = this.f4730b;
                    j = this.f4730b.f4724b;
                    nABaseMap.nativeAddOneOverlayItem(j, this.f4729a);
                }
                if (z) {
                    readWriteLock4 = this.f4730b.c;
                    readWriteLock4.readLock().unlock();
                }
            } catch (Exception e) {
                if (z) {
                    readWriteLock2 = this.f4730b.c;
                    readWriteLock2.readLock().unlock();
                }
            } catch (Throwable th) {
                if (z) {
                    readWriteLock = this.f4730b.c;
                    readWriteLock.readLock().unlock();
                }
                throw th;
            }
        }
    }
}
