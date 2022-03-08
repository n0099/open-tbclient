package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.ai;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
/* loaded from: classes4.dex */
public class e implements ai {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BaiduMap a;

    public e(BaiduMap baiduMap) {
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

    @Override // com.baidu.mapsdkplatform.comapi.map.ai
    public Bundle a(int i2, int i3, int i4, Context context) {
        InterceptResult invokeCommon;
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), context})) == null) {
            lock = this.a.J;
            lock.lock();
            try {
                tileOverlay = this.a.G;
                if (tileOverlay != null) {
                    tileOverlay2 = this.a.G;
                    Tile a = tileOverlay2.a(i2, i3, i4);
                    if (a != null) {
                        return a.toBundle();
                    }
                }
                lock3 = this.a.J;
                lock3.unlock();
                return null;
            } finally {
                lock2 = this.a.J;
                lock2.unlock();
            }
        }
        return (Bundle) invokeCommon.objValue;
    }
}
