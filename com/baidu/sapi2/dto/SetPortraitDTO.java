package com.baidu.sapi2.dto;

import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SetPortraitDTO extends SapiDTO implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PORTRAIT_TYPE_CARTOON = 2;
    public static final int PORTRAIT_TYPE_DEFAULT = 0;
    public static final int PORTRAIT_TYPE_PRODUCT_DEFINE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String bduss;
    public String contentType;
    public byte[] file;
    public int portraitType;

    public SetPortraitDTO() {
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
        this.portraitType = 0;
    }
}
