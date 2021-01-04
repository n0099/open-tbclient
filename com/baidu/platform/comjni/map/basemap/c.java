package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f4726a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NABaseMap f4727b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NABaseMap nABaseMap, Bundle bundle) {
        this.f4727b = nABaseMap;
        this.f4726a = bundle;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        ReadWriteLock readWriteLock4;
        long j;
        boolean a2;
        ReadWriteLock readWriteLock5;
        boolean z = false;
        try {
            readWriteLock3 = this.f4727b.c;
            z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                if (this.f4726a != null) {
                    a2 = this.f4727b.a(this.f4726a.getLong("itemaddr", 0L));
                    if (a2) {
                        if (z) {
                            readWriteLock5 = this.f4727b.c;
                            readWriteLock5.readLock().unlock();
                            return;
                        }
                        return;
                    }
                }
                NABaseMap nABaseMap = this.f4727b;
                j = this.f4727b.f4723b;
                nABaseMap.nativeRemoveItemData(j, this.f4726a);
            }
            if (z) {
                readWriteLock4 = this.f4727b.c;
                readWriteLock4.readLock().unlock();
            }
        } catch (Exception e) {
            if (z) {
                readWriteLock2 = this.f4727b.c;
                readWriteLock2.readLock().unlock();
            }
        } catch (Throwable th) {
            if (z) {
                readWriteLock = this.f4727b.c;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
    }
}
