package com.baidu.sofire.utility;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PrivacyConfigConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANDROID_ID = 40;
    public static final String BACKGROUND_NETWORK = "0";
    public static final String BLOCK_ARRAY = "1";
    public static final int IMEI = 27;
    public static final int NETWORK_OPERATOR = 46;
    public static final int OAID = 41;
    public static final int READ_SD_CARD = 44;
    public static final int READ_SETTINGS = 42;
    public static final int SIM_OPERATOR = 34;
    public static final int WRITE_SD_CARD = 45;
    public static final int WRITE_SETTINGS = 43;
    public transient /* synthetic */ FieldHolder $fh;

    public PrivacyConfigConstant() {
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
