package com.baidu.sapi2.ecommerce.result;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class InvoiceBuildResult extends SapiResult implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_INVOICE_ID = "invoice_id";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> map;

    public InvoiceBuildResult() {
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
        this.map = new HashMap<>();
    }
}
