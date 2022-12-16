package com.baidu.android.imsdk.chatmessage.request;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RequestContants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_BDUID = "bduid";
    public static final String EXTRA_CONTACTER_BDUID = "contacter_bduid";
    public static final String EXTRA_CONTACTER_PA_UID = "contacter_pa_uid";
    public static final String EXTRA_CONTACTER_UK = "contacter_uk";
    public static final String EXTRA_CONTACTER_USER_TYPE = "contacter_user_type";
    public static final String EXTRA_TO_USER = "to_user";
    public static final String EXTRA_UK = "uk";
    public static final String EXTRA_USER_TYPE = "user_type";
    public transient /* synthetic */ FieldHolder $fh;

    public RequestContants() {
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
