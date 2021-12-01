package com.baidu.sapi2.ecommerce.dto;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class InvoiceBuildDTO extends SapiWebDTO implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_MANAGE = "0";
    public static final String TYPE_SELECT = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public String TYPE;
    public boolean isExamineVAT;
    public boolean showCheckTag;
    public String tplse;
    public String tplt;

    public InvoiceBuildDTO() {
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
        this.TYPE = "0";
        this.isExamineVAT = false;
        this.showCheckTag = false;
    }
}
