package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.o
    public Bundle a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        HeatMap heatMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            lock = this.a.I;
            lock.lock();
            try {
                heatMap = this.a.H;
                if (heatMap != null) {
                    heatMap2 = this.a.H;
                    Tile a = heatMap2.a(i2, i3, i4);
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
