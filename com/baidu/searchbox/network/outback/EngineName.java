package com.baidu.searchbox.network.outback;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class EngineName {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BACK_UP_ENGINE = "BACK_UP";
    public static final String CRONET = "CRONET";
    public static final String CUSTOM_ENGINE = "CUSTOM";
    public static final String DEFAULT_ENGINE = "DEFAULT";
    public static final String OKHTTP = "OKHTTP";
    public static final String URLCONNECTION = "URLCONNECTION";
    public transient /* synthetic */ FieldHolder $fh;

    public EngineName() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
