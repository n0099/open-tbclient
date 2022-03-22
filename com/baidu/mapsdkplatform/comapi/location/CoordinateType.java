package com.baidu.mapsdkplatform.comapi.location;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CoordinateType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BD09LL = "bd09ll";
    public static final String BD09MC = "bd09mc";
    public static final String GCJ02 = "gcj02";
    public static final String WGS84 = "wgs84";
    public transient /* synthetic */ FieldHolder $fh;

    public CoordinateType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
