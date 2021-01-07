package com.baidu.platform.comjni.map.basemap;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f4743a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f4744b;
    final /* synthetic */ NABaseMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NABaseMap nABaseMap, long j, long j2) {
        this.c = nABaseMap;
        this.f4743a = j;
        this.f4744b = j2;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        ReadWriteLock readWriteLock4;
        boolean a2;
        boolean a3;
        long j;
        boolean z = false;
        try {
            readWriteLock3 = this.c.c;
            z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.c.a(this.f4743a);
                if (!a2) {
                    a3 = this.c.a(this.f4744b);
                    if (!a3) {
                        NABaseMap nABaseMap = this.c;
                        j = this.c.f4724b;
                        nABaseMap.nativeSwitchLayer(j, this.f4743a, this.f4744b);
                    }
                }
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
