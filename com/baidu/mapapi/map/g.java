package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
/* loaded from: classes2.dex */
public class g implements com.baidu.mapsdkplatform.comapi.map.ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BaiduMap a;

    public g(BaiduMap baiduMap) {
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

    @Override // com.baidu.mapsdkplatform.comapi.map.ab
    public Bundle a(int i, int i2, int i3, Context context) {
        InterceptResult invokeCommon;
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), context})) != null) {
            return (Bundle) invokeCommon.objValue;
        }
        lock = this.a.M;
        lock.lock();
        try {
            tileOverlay = this.a.J;
            if (tileOverlay != null) {
                tileOverlay2 = this.a.J;
                Tile a = tileOverlay2.a(i, i2, i3);
                StringBuilder sb = new StringBuilder();
                sb.append("mapLayerDataReq tile t == null = ");
                if (a == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.e("SDKTileLayer", sb.toString());
                if (a != null) {
                    return a.toBundle();
                }
            }
            lock3 = this.a.M;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.a.M;
            lock2.unlock();
        }
    }
}
