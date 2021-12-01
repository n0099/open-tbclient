package com.baidu.sapi2.dto;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AccountToolsDTO extends SapiWebDTO {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_APPEAL_ACCOUNT = 4;
    public static final int TYPE_CANCEL_ACCOUNT = 3;
    public static final int TYPE_FIND_ACCOUNT = 2;
    public static final int TYPE_FROST_ACCOUNT = 1;
    public static final int TYPE_MODIFY_PWD = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public int toolsType;

    public AccountToolsDTO() {
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
