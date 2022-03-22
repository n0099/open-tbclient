package com.baidu.searchbox.live.interfaces.net;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LiveNetConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_KEY_ENABLE_STAT = "enableStat";
    public static final String EXTRA_KEY_REQUEST_FROM = "requestFrom";
    public static final String EXTRA_KEY_REQUEST_SUB_FROM = "requestSubFrom";
    public transient /* synthetic */ FieldHolder $fh;

    public LiveNetConstants() {
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
