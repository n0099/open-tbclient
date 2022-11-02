package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* loaded from: classes2.dex */
public class h implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bundle[] a;
    public final /* synthetic */ NABaseMap b;

    public h(NABaseMap nABaseMap, Bundle[] bundleArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nABaseMap, bundleArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = nABaseMap;
        this.a = bundleArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        Throwable th;
        boolean z;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean z2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        b = this.b.b();
        if (!b) {
            return;
        }
        int i = 0;
        try {
            readWriteLock3 = this.b.d;
            z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                try {
                    Bundle[] bundleArr = this.a;
                    int length = bundleArr.length;
                    while (i < length) {
                        Bundle bundle = bundleArr[i];
                        z2 = this.b.c;
                        if (z2) {
                            break;
                        }
                        NABaseMap nABaseMap = this.b;
                        j = this.b.b;
                        nABaseMap.nativeRemoveOneOverlayItem(j, bundle);
                        i++;
                    }
                } catch (Exception unused) {
                    i = z;
                    if (i == 0) {
                        return;
                    }
                    readWriteLock2 = this.b.d;
                    readWriteLock2.readLock().unlock();
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        readWriteLock = this.b.d;
                        readWriteLock.readLock().unlock();
                    }
                    throw th;
                }
            }
            if (z == 0) {
                return;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
        readWriteLock2 = this.b.d;
        readWriteLock2.readLock().unlock();
    }
}
