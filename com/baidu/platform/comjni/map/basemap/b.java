package com.baidu.platform.comjni.map.basemap;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* loaded from: classes2.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ NABaseMap c;

    public b(NABaseMap nABaseMap, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nABaseMap, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = nABaseMap;
        this.a = j;
        this.b = z;
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
                readWriteLock3 = this.c.d;
                z = readWriteLock3.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    a = this.c.a(this.a);
                    if (!a) {
                        NABaseMap nABaseMap = this.c;
                        j = this.c.b;
                        nABaseMap.nativeShowLayers(j, this.a, this.b);
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
                    readWriteLock = this.c.d;
                    readWriteLock.readLock().unlock();
                }
                throw th;
            }
            readWriteLock2 = this.c.d;
            readWriteLock2.readLock().unlock();
        }
    }
}
