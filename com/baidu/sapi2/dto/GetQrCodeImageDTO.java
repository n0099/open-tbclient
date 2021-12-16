package com.baidu.sapi2.dto;

import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class GetQrCodeImageDTO implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENABLE_USE_CUID = "1";
    public static final String LP_TYPE_APP = "app";
    public static final String LP_TYPE_PC = "pc";
    public transient /* synthetic */ FieldHolder $fh;
    public String encuid;
    public String hostDeviceId;
    public String lp;
    public boolean needQrCodeContent;
    public String openPlatformId;

    public GetQrCodeImageDTO() {
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
        this.lp = "pc";
    }
}
