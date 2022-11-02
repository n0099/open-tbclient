package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class j implements com.baidu.platform.comapi.map.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BaiduMap a;

    public j(BaiduMap baiduMap) {
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

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, bitmap) != null) {
            return;
        }
        snapshotReadyCallback = this.a.D;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
