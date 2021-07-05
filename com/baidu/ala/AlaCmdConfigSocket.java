package com.baidu.ala;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaCmdConfigSocket {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALA_SOCKET_GET_LIVE_STATUS2 = 602007;
    public static final int ALA_SOCKET_PUSH_ALERT = 601009;
    public static final int CMD_ALA_SUB_LIVE_LIST = 309454;
    public static final int CMD_SQUARE_LIVE = 309451;
    public transient /* synthetic */ FieldHolder $fh;

    public AlaCmdConfigSocket() {
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
