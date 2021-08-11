package com.baidu.sapi2.dto;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class WebRegDTO extends SapiWebDTO {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final String EXTRA_REGISTER_FAST = "extra_fast_reg";
    public static final String EXTRA_REGISTER_MOBILE = "extra_mobile_reg";
    public transient /* synthetic */ FieldHolder $fh;
    public List<PassNameValuePair> extraParams;
    public boolean finishActivityAfterSuc;
    public String regType;

    public WebRegDTO() {
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
        this.regType = EXTRA_REGISTER_MOBILE;
        this.finishActivityAfterSuc = true;
        this.extraParams = new ArrayList();
    }
}
