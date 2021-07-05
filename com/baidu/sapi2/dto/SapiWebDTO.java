package com.baidu.sapi2.dto;

import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SapiWebDTO extends SapiDTO {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int closeEnterAnimId;
    public int closeExitAnimId;
    public LoginTypes excludeTypes;
    public int openEnterAnimId;
    public int openExitAnimId;
    public boolean sweepLightLoading;

    public SapiWebDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.openEnterAnimId = 0;
        this.closeExitAnimId = 0;
        this.openExitAnimId = 0;
        this.closeEnterAnimId = 0;
        this.sweepLightLoading = true;
    }
}
