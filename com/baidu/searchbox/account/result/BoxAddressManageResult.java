package com.baidu.searchbox.account.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class BoxAddressManageResult extends BoxSapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ADDR_ID = "addrId";
    public static final String KEY_ADDR_INFO = "addrInfo";
    public static final String KEY_ADDR_REGION = "addrRegion";
    public static final String KEY_IS_DEFAULT = "isDefault";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_NAME = "name";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> map;

    public BoxAddressManageResult() {
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
