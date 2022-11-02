package com.baidu.platform.comjni.map.basemap;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
/* loaded from: classes2.dex */
public class m implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ NABaseMap b;

    public m(NABaseMap nABaseMap, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nABaseMap, Long.valueOf(j)};
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
        this.a = j;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        Set set;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = false;
            try {
                readWriteLock3 = this.b.d;
                z = readWriteLock3.writeLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    set = this.b.e;
                    set.add(Long.valueOf(this.a));
                    NABaseMap nABaseMap = this.b;
                    j = this.b.b;
                    nABaseMap.nativeRemoveLayer(j, this.a);
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
                    readWriteLock = this.b.d;
                    readWriteLock.writeLock().unlock();
                }
                throw th;
            }
            readWriteLock2 = this.b.d;
            readWriteLock2.writeLock().unlock();
        }
    }
}
