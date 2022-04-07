package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
/* loaded from: classes2.dex */
public class d implements com.baidu.mapsdkplatform.comapi.map.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BaiduMap a;

    public d(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.o
    public Bundle a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        HeatMap heatMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i, i2, i3)) == null) {
            lock = this.a.I;
            lock.lock();
            try {
                heatMap = this.a.H;
                if (heatMap != null) {
                    heatMap2 = this.a.H;
                    Tile a = heatMap2.a(i, i2, i3);
                    if (a != null) {
                        return a.toBundle();
                    }
                }
                lock3 = this.a.I;
                lock3.unlock();
                return null;
            } finally {
                lock2 = this.a.I;
                lock2.unlock();
            }
        }
        return (Bundle) invokeIII.objValue;
    }
}
