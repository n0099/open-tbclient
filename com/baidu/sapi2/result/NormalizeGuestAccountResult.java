package com.baidu.sapi2.result;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity activity;
    public boolean isAccountMerge;
    public String normalizeWay;
    public HashMap<String, Integer> normalizeWayMap;

    public NormalizeGuestAccountResult() {
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
        HashMap<String, Integer> hashMap = new HashMap<>(3);
        this.normalizeWayMap = hashMap;
        hashMap.put("sms_upgrade", 1);
        this.normalizeWayMap.put("sms_upgrade_exist", 2);
        this.normalizeWayMap.put("pwd_upgrade", 3);
    }

    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public int getNormalizeWay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.normalizeWayMap.containsKey(this.normalizeWay)) {
                return this.normalizeWayMap.get(this.normalizeWay).intValue();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void setNormalizeWay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.normalizeWay = str;
        }
    }
}
