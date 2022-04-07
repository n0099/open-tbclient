package com.baidu.sapi2.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ThirdPartyUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_QQ = "qzone";
    public static final String TYPE_WEIBO = "tsina";
    public static final String TYPE_WEIXIN = "weixin";
    public static HashMap<String, String> wxAuthCodeMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1414265322, "Lcom/baidu/sapi2/utils/ThirdPartyUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1414265322, "Lcom/baidu/sapi2/utils/ThirdPartyUtil;");
                return;
            }
        }
        wxAuthCodeMap = new HashMap<>();
    }

    public ThirdPartyUtil() {
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

    public static boolean checkAliPayInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null : invokeL.booleanValue;
    }

    public static Message getVerificationMsg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Message message = new Message();
            if (str.equals("qzone")) {
                message.what = SocialType.QQ_SSO.getType();
                message.obj = SocialType.QQ_SSO;
            } else if (str.equals(TYPE_WEIXIN)) {
                message.what = SocialType.WEIXIN.getType();
                message.obj = SocialType.WEIXIN;
            } else if (str.equals("tsina")) {
                message.what = SocialType.SINA_WEIBO_SSO.getType();
                message.obj = SocialType.SINA_WEIBO_SSO;
            }
            return message;
        }
        return (Message) invokeL.objValue;
    }

    public static boolean isQQClientAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? SapiUtils.isAppInstalled(context, "com.tencent.mobileqq") || SapiUtils.isAppInstalled(context, Constants.PACKAGE_QQ_SPEED) : invokeL.booleanValue;
    }

    public static boolean isSinaInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? SapiUtils.isAppInstalled(context, "com.sina.weibo") : invokeL.booleanValue;
    }

    public static boolean isWeixinAvilible(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? SapiUtils.isAppInstalled(context, "com.tencent.mm") : invokeL.booleanValue;
    }
}
