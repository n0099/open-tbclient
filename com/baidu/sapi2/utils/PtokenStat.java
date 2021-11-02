package com.baidu.sapi2.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PtokenStat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILLNAME_WIDGE = "fillname_widge";
    public static final String LOGIN = "login_";
    public static final String LOGIN_POP = "login_pop";
    public static final String MODIFY_PWD_WIDGE = "modifyPWD_widge";
    public static final String NATIVE_2_WEB = "native2web";
    public static final String NORMAL_GUEST = "normal_guest";
    public static final String NORMAL_INCOMPLETE = "normal_incomplete";
    public static final String SAPI_ACTION_BDUSS_CHANGED = "sapi_action_bduss_changed";
    public static final String WEB_2_NATIVE = "web2native";
    public transient /* synthetic */ FieldHolder $fh;

    public PtokenStat() {
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

    public void onEvent(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            HashMap hashMap = new HashMap();
            hashMap.put("device", Build.MODEL);
            hashMap.put("sys_version", Build.VERSION.RELEASE);
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            hashMap.put("uid", currentAccount == null ? "uid_is_empty" : currentAccount.uid);
            hashMap.put("scenes", str);
            StatService.onEvent("ptoken_is_null", hashMap);
        }
    }
}
