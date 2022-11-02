package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* loaded from: classes2.dex */
public class q implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ NABaseMap e;

    public q(NABaseMap nABaseMap, long j, long j2, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nABaseMap, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = nABaseMap;
        this.a = j;
        this.b = j2;
        this.c = z;
        this.d = bundle;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean a;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = false;
            try {
                readWriteLock3 = this.e.d;
                z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    a = this.e.a(this.a);
                    if (!a) {
                        NABaseMap nABaseMap = this.e;
                        j = this.e.b;
                        nABaseMap.nativeSetFocus(j, this.a, this.b, this.c, this.d);
                    }
                }
                if (!z) {
                    return;
                }
            } catch (Exception unused) {
                if (!z) {
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    readWriteLock = this.e.d;
                    readWriteLock.readLock().unlock();
                }
                throw th;
            }
            readWriteLock2 = this.e.d;
            readWriteLock2.readLock().unlock();
        }
    }
}
