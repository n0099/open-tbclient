package com.baidu.tbadk.core.util.httpNet;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.switchs.ComplianceParmasSwitch;
import com.baidu.tieba.ji;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class ComplianceParmasHelper {
    public static /* synthetic */ Interceptable $ic;
    public static String SERVER_ADDRESS_PEIWAN;
    public static final List TIEBAHOST_CHANGE_LIST;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1980409862, "Lcom/baidu/tbadk/core/util/httpNet/ComplianceParmasHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1980409862, "Lcom/baidu/tbadk/core/util/httpNet/ComplianceParmasHelper;");
                return;
            }
        }
        TIEBAHOST_CHANGE_LIST = Arrays.asList("c/s/sync", "c/s/msg", "c/e/meme/suggest", TbConfig.LOG_UPLOAD_URL, TbConfig.LOAD_REG_PV_ADDRESS, TbConfig.URL_FUN_AD_RECORD, TbConfig.GET_PAY_CONFIG, TbConfig.URL_PLAY_STATISTICS, TbConfig.IMAGE_PB_ADDRESS, TbConfig.URL_PLAY_DURATION_STATISTICS, TbConfig.URL_VIDEO_HOLY_CARD, TbConfig.STAT_CLIENT_START);
        SERVER_ADDRESS_PEIWAN = TbConfig.SERVER_GAME_PLAY_ADRESS;
    }

    public ComplianceParmasHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getBase64Value(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return ji.j(str.getBytes());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getRenameKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (HttpRequest.PHONE_IMEI.equals(str)) {
                return HttpRequest.PHONE_IMEI_REVERSAL;
            }
            if (HttpRequest.PHONE_NEWIMEI.equals(str)) {
                return HttpRequest.PHONE_NEWIMEI_REVERSAL;
            }
            if ("mac".equals(str)) {
                return HttpRequest.MAC_REVERSAL;
            }
            if (HttpRequest.ANDROID_ID.equals(str)) {
                return HttpRequest.ANDROID_ID_REVERSAL;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isNeedChange(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && ComplianceParmasSwitch.getIsOn()) {
                if (str.contains(TbConfig.SERVER_ADDRESS)) {
                    if (TIEBAHOST_CHANGE_LIST.contains(str.replace(TbConfig.SERVER_ADDRESS, ""))) {
                        return true;
                    }
                    return false;
                } else if (SERVER_ADDRESS_PEIWAN.equalsIgnoreCase(str)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
