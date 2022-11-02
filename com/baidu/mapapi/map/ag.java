package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ag implements f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ CustomMapStyleCallBack a;
    public final /* synthetic */ MapCustomStyleOptions b;
    public final /* synthetic */ WearMapView c;

    public ag(WearMapView wearMapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wearMapView, customMapStyleCallBack, mapCustomStyleOptions};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = wearMapView;
        this.a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(int i, String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
            CustomMapStyleCallBack customMapStyleCallBack = this.a;
            if (customMapStyleCallBack != null && customMapStyleCallBack.onCustomMapStyleLoadFailed(i, str, str2)) {
                return;
            }
            z = this.c.H;
            if (z) {
                return;
            }
            this.c.a(str2, this.b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            CustomMapStyleCallBack customMapStyleCallBack = this.a;
            if (customMapStyleCallBack != null && customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
                return;
            }
            this.c.H = true;
            this.c.a(str, this.b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
            CustomMapStyleCallBack customMapStyleCallBack = this.a;
            if ((customMapStyleCallBack != null && customMapStyleCallBack.onCustomMapStyleLoadSuccess(z, str)) || TextUtils.isEmpty(str)) {
                return;
            }
            this.c.a(str, "");
            this.c.setMapCustomStyleEnable(true);
        }
    }
}
