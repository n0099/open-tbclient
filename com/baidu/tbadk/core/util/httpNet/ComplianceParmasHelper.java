package com.baidu.tbadk.core.util.httpNet;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.switchs.ComplianceParmasSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes11.dex */
public class ComplianceParmasHelper {
    public static /* synthetic */ Interceptable $ic;
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
        TIEBAHOST_CHANGE_LIST = Arrays.asList(TbConfig.GET_SYNC_ADDRESS, "c/s/msg", "c/e/meme/suggest", TbConfig.LOG_UPLOAD_URL, TbConfig.LOAD_REG_PV_ADDRESS, TbConfig.URL_FUN_AD_RECORD, TbConfig.GET_PAY_CONFIG, TbConfig.URL_PLAY_STATISTICS, TbConfig.IMAGE_PB_ADDRESS, TbConfig.URL_PLAY_DURATION_STATISTICS, TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, TbConfig.URL_VIDEO_HOLY_CARD, TbConfig.STAT_CLIENT_START);
    }

    public ComplianceParmasHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getBase64Value(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? !TextUtils.isEmpty(str) ? e.j(str.getBytes()) : str : (String) invokeL.objValue;
    }

    public static String getRenameKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? HttpRequest.PHONE_IMEI.equals(str) ? HttpRequest.PHONE_IMEI_REVERSAL : HttpRequest.PHONE_NEWIMEI.equals(str) ? HttpRequest.PHONE_NEWIMEI_REVERSAL : "mac".equals(str) ? HttpRequest.MAC_REVERSAL : HttpRequest.ANDROID_ID.equals(str) ? HttpRequest.ANDROID_ID_REVERSAL : str : (String) invokeL.objValue;
    }

    public static boolean isNeedChange(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? !TextUtils.isEmpty(str) && ComplianceParmasSwitch.getIsOn() && str.contains(TbConfig.SERVER_ADDRESS) && TIEBAHOST_CHANGE_LIST.contains(str.replace(TbConfig.SERVER_ADDRESS, "")) : invokeL.booleanValue;
    }
}
