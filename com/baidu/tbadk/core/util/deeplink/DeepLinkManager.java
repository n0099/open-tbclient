package com.baidu.tbadk.core.util.deeplink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.t3.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.deeplink.DeepLinkCallback;
import com.baidu.tbadk.core.util.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class DeepLinkManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUNDLE_NEED_BLACKLIST = "need_scheme_blacklist";
    public static final String BUNDLE_NEED_WHITELIST = "need_scheme_whitelist";
    public static final String TIEBA_DEEPLINK = "tiebaapp://router/deeplink";
    public transient /* synthetic */ FieldHolder $fh;

    public DeepLinkManager() {
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

    public static void callbackFailed(DeepLinkCallback deepLinkCallback, int i2, String str, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65537, null, deepLinkCallback, i2, str, deepLinkResponse) == null) {
            DeepLinkParser.printLog("callback onFailed-->errNo=" + i2 + ",errMsg =" + str);
            if (deepLinkCallback != null) {
                deepLinkCallback.onFailed(i2, str, deepLinkResponse);
            }
        }
    }

    public static void callbackSuccess(DeepLinkCallback deepLinkCallback, String str, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, deepLinkCallback, str, deepLinkResponse) == null) {
            DeepLinkParser.printLog("callback onSuccess-->" + str + " open");
            if (deepLinkCallback != null) {
                deepLinkCallback.onSuccess(str, deepLinkResponse);
            }
        }
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? dealDeepLink(context, str, null) : (DeepLinkCallback.DeepLinkResponse) invokeLL.objValue;
    }

    public static boolean isTieBaDeepLink(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().startsWith("tiebaapp://router/deeplink");
        }
        return invokeL.booleanValue;
    }

    public static boolean openApp(Context context, String str, String str2, Bundle bundle, boolean z, OpenAppCallback openAppCallback) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, bundle, Boolean.valueOf(z), openAppCallback})) == null) {
            if (bundle != null) {
                try {
                    if (bundle.getBoolean("need_scheme_blacklist", false) && UrlSchemaJumpHelper.isHitBlackList(str)) {
                        if (openAppCallback != null) {
                            openAppCallback.onFailed(-105);
                        }
                        return false;
                    }
                } catch (Exception unused) {
                    if (openAppCallback != null) {
                        openAppCallback.onFailed(-101);
                    }
                    return false;
                }
            }
            Intent createIntent = OpenAppIntentUtil.createIntent(context, str, str2, z, openAppCallback);
            if (createIntent == null) {
                return false;
            }
            context.startActivity(createIntent);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean openWebUrl(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        TbPageContext<?> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, bundle)) == null) {
            String[] strArr = {str};
            UrlManager urlManager = UrlManager.getInstance();
            if (urlManager == null || (a = a.a(context)) == null) {
                return false;
            }
            if (urlManager.UrlValidated(str)) {
                urlManager.dealOneLink(a, strArr, true, bundle);
                return true;
            }
            return urlManager.dealOneLink(a, strArr, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public static DeepLinkCallback.DeepLinkResponse processResponseMessage(DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, deepLinkResponse)) == null) {
            DeepLinkParser.printLog("returnDeepLinkResponse-->" + deepLinkResponse.toString());
            return deepLinkResponse;
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeL.objValue;
    }

    public static boolean tryOpenApp(Context context, String str, String str2, Bundle bundle, DeepLinkCallback deepLinkCallback, boolean z, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, str, str2, bundle, deepLinkCallback, Boolean.valueOf(z), deepLinkResponse})) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed("app", -4);
                return false;
            } else if (openApp(context, str, str2, bundle, z, new OpenAppCallback(deepLinkResponse) { // from class: com.baidu.tbadk.core.util.deeplink.DeepLinkManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DeepLinkCallback.DeepLinkResponse val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {deepLinkResponse};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$msg = deepLinkResponse;
                }

                @Override // com.baidu.tbadk.core.util.deeplink.OpenAppCallback
                public void onFailed(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.val$msg.onFailed("app", i2);
                    }
                }
            })) {
                DeepLinkParser.printLog("app open success-->" + str);
                deepLinkResponse.onSucceed("app");
                callbackSuccess(deepLinkCallback, "app", deepLinkResponse);
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean tryOpenInnerLink(Context context, String str, DeepLinkCallback deepLinkCallback, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeLLLL;
        int dealOneLinkWithOutJumpWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, context, str, deepLinkCallback, deepLinkResponse)) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER, -1);
                return false;
            }
            TbPageContext<?> a = a.a(context);
            if (a == null || !((dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(a, new String[]{str})) == 0 || dealOneLinkWithOutJumpWebView == 1)) {
                return false;
            }
            DeepLinkParser.printLog("inner open success-->" + str);
            deepLinkResponse.onSucceed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER);
            callbackSuccess(deepLinkCallback, DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER, deepLinkResponse);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean tryOpenMarket(Context context, String str, String str2, Bundle bundle, DeepLinkCallback deepLinkCallback, boolean z, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, str, str2, bundle, deepLinkCallback, Boolean.valueOf(z), deepLinkResponse})) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed("market", -5);
                return false;
            } else if (openApp(context, str, str2, bundle, z, new OpenAppCallback(deepLinkResponse) { // from class: com.baidu.tbadk.core.util.deeplink.DeepLinkManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DeepLinkCallback.DeepLinkResponse val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {deepLinkResponse};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$msg = deepLinkResponse;
                }

                @Override // com.baidu.tbadk.core.util.deeplink.OpenAppCallback
                public void onFailed(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.val$msg.onFailed("market", i2);
                    }
                }
            })) {
                DeepLinkParser.printLog("market open success-->" + str);
                deepLinkResponse.onSucceed("market");
                callbackSuccess(deepLinkCallback, "market", deepLinkResponse);
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean tryOpenWebUrl(Context context, String str, Bundle bundle, DeepLinkCallback deepLinkCallback, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, context, str, bundle, deepLinkCallback, deepLinkResponse)) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, -6);
                callbackFailed(deepLinkCallback, -6, "Uri web url is empty", deepLinkResponse);
                return false;
            } else if (openWebUrl(context, str, bundle)) {
                DeepLinkParser.printLog("web open success-->" + str);
                deepLinkResponse.onSucceed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB);
                callbackSuccess(deepLinkCallback, DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, deepLinkResponse);
                return true;
            } else {
                deepLinkResponse.onFailed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, -7);
                callbackFailed(deepLinkCallback, -7, "Uri web url open failed", deepLinkResponse);
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, bundle)) == null) ? dealDeepLink(context, str, null, bundle) : (DeepLinkCallback.DeepLinkResponse) invokeLLL.objValue;
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, String str, DeepLinkCallback deepLinkCallback, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, str, deepLinkCallback, bundle)) == null) {
            DeepLinkParser.printLog("deepLink=" + str);
            DeepLinkCallback.DeepLinkResponse deepLinkResponse = new DeepLinkCallback.DeepLinkResponse();
            if (str == null) {
                callbackFailed(deepLinkCallback, -1, "DeepLink is empty.", deepLinkResponse);
                return processResponseMessage(deepLinkResponse);
            } else if (!isTieBaDeepLink(str)) {
                callbackFailed(deepLinkCallback, -2, "Uri is invalid.", deepLinkResponse);
                return processResponseMessage(deepLinkResponse);
            } else {
                UriBuilder uriBuilder = new UriBuilder(str);
                if (uriBuilder.getUri() != null && uriBuilder.isValidated()) {
                    DeepLinkItem deepLinkItem = new DeepLinkItem(uriBuilder);
                    String str2 = deepLinkItem.appUrl;
                    String str3 = deepLinkItem.webUrl;
                    String str4 = deepLinkItem.pkgName;
                    String str5 = deepLinkItem.marketUrl;
                    String str6 = deepLinkItem.marketPkgName;
                    boolean z = deepLinkItem.isDesignatePkg;
                    if (tryOpenInnerLink(context, str2, deepLinkCallback, deepLinkResponse)) {
                        return processResponseMessage(deepLinkResponse);
                    }
                    if (tryOpenApp(context, str2, str4, bundle, deepLinkCallback, z, deepLinkResponse)) {
                        return processResponseMessage(deepLinkResponse);
                    }
                    if (tryOpenMarket(context, str5, str6, bundle, deepLinkCallback, z, deepLinkResponse)) {
                        return processResponseMessage(deepLinkResponse);
                    }
                    tryOpenWebUrl(context, str3, bundle, deepLinkCallback, deepLinkResponse);
                    return processResponseMessage(deepLinkResponse);
                }
                callbackFailed(deepLinkCallback, -2, "Uri is invalid.", deepLinkResponse);
                return processResponseMessage(deepLinkResponse);
            }
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeLLLL.objValue;
    }
}
