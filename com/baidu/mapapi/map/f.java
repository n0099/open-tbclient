package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
/* loaded from: classes2.dex */
public class f implements com.baidu.mapsdkplatform.comapi.map.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BaiduMap a;

    public f(BaiduMap baiduMap) {
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

    @Override // com.baidu.mapsdkplatform.comapi.map.m
    public Bundle a(int i, int i2) {
        InterceptResult invokeII;
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        BaiduMap.OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack;
        HeatMap heatMap2;
        BaiduMap.OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(1048576, this, i, i2)) != null) {
            return (Bundle) invokeII.objValue;
        }
        lock = this.a.L;
        lock.lock();
        try {
            heatMap = this.a.K;
            if (heatMap == null) {
                return null;
            }
            onHeatMapDrawFrameCallBack = this.a.H;
            if (onHeatMapDrawFrameCallBack != null) {
                onHeatMapDrawFrameCallBack2 = this.a.H;
                onHeatMapDrawFrameCallBack2.frameIndex(i);
            }
            heatMap2 = this.a.K;
            HeatMapData data = heatMap2.getData(i, i2);
            if (data == null) {
                return null;
            }
            return data.toBundle();
        } finally {
            lock2 = this.a.L;
            lock2.unlock();
        }
    }
}
