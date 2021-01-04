package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f4748a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f4749b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ NABaseMap e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NABaseMap nABaseMap, long j, long j2, boolean z, Bundle bundle) {
        this.e = nABaseMap;
        this.f4748a = j;
        this.f4749b = j2;
        this.c = z;
        this.d = bundle;
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
            readWriteLock3 = this.e.c;
            z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.e.a(this.f4748a);
                if (!a2) {
                    NABaseMap nABaseMap = this.e;
                    j = this.e.f4723b;
                    nABaseMap.nativeSetFocus(j, this.f4748a, this.f4749b, this.c, this.d);
                }
            }
            if (z) {
                readWriteLock4 = this.e.c;
                readWriteLock4.readLock().unlock();
            }
        } catch (Exception e) {
            if (z) {
                readWriteLock2 = this.e.c;
                readWriteLock2.readLock().unlock();
            }
        } catch (Throwable th) {
            if (z) {
                readWriteLock = this.e.c;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
    }
}
