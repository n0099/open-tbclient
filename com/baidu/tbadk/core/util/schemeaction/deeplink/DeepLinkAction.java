package com.baidu.tbadk.core.util.schemeaction.deeplink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionName;
import com.baidu.tbadk.core.util.schemeaction.UriBuilder;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCallback;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.tieba.oq8;
import com.baidu.tieba.wp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DeepLinkAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUNDLE_NEED_BLACKLIST = "need_scheme_blacklist";
    public static final String BUNDLE_NEED_WHITELIST = "need_scheme_whitelist";
    public transient /* synthetic */ FieldHolder $fh;

    public DeepLinkAction() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void callbackFailed(DeepLinkCallback deepLinkCallback, int i, String str, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65537, null, deepLinkCallback, i, str, deepLinkResponse) == null) {
            SchemeActionHelper.printLog("callback onFailed-->errNo=" + i + ",errMsg =" + str);
            if (deepLinkCallback != null) {
                deepLinkCallback.onFailed(i, str, deepLinkResponse);
            }
        }
    }

    public static void callbackSuccess(DeepLinkCallback deepLinkCallback, String str, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, deepLinkCallback, str, deepLinkResponse) == null) {
            SchemeActionHelper.printLog("callback onSuccess-->" + str + " open");
            if (deepLinkCallback != null) {
                deepLinkCallback.onSuccess(str, deepLinkResponse);
            }
        }
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, UriBuilder uriBuilder, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, uriBuilder, bundle)) == null) {
            return dealDeepLink(context, uriBuilder, bundle, null);
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeLLL.objValue;
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, UriBuilder uriBuilder) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, uriBuilder)) == null) {
            return dealDeepLink(context, uriBuilder, null, null);
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeLL.objValue;
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, UriBuilder uriBuilder, Bundle bundle, DeepLinkCallback deepLinkCallback) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, uriBuilder, bundle, deepLinkCallback)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("deepLink=");
            if (uriBuilder != null) {
                str = uriBuilder.getUriString();
            } else {
                str = "";
            }
            sb.append(str);
            SchemeActionHelper.printLog(sb.toString());
            DeepLinkCallback.DeepLinkResponse deepLinkResponse = new DeepLinkCallback.DeepLinkResponse();
            if (uriBuilder == null) {
                callbackFailed(deepLinkCallback, -1, "DeepLink is empty.", deepLinkResponse);
                return processResponseMessage(deepLinkResponse);
            } else if (uriBuilder.getUri() != null && uriBuilder.isValidated()) {
                return dealDeepLink(context, new DeepLinkItem(uriBuilder), bundle, deepLinkResponse, deepLinkCallback);
            } else {
                callbackFailed(deepLinkCallback, -2, "Uri is invalid.", deepLinkResponse);
                return processResponseMessage(deepLinkResponse);
            }
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeLLLL.objValue;
    }

    public static boolean tryOpenInnerLink(Context context, String str, DeepLinkCallback deepLinkCallback, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, context, str, deepLinkCallback, deepLinkResponse)) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER, -1);
                return false;
            }
            TbPageContext<?> a = oq8.a(context);
            if (a != null) {
                int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(a, new String[]{str});
                SchemeActionHelper.printLog("inner tryOpenInnerLink-->" + str + ",retType=" + dealOneLinkWithOutJumpWebView);
                if (dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1) {
                    SchemeActionHelper.printLog("inner open success-->" + str);
                    deepLinkResponse.onSucceed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER);
                    callbackSuccess(deepLinkCallback, DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER, deepLinkResponse);
                    return true;
                }
            }
            deepLinkResponse.onFailed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER, -200);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, DeepLinkItem deepLinkItem, Bundle bundle, DeepLinkCallback.DeepLinkResponse deepLinkResponse, DeepLinkCallback deepLinkCallback) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65542, null, context, deepLinkItem, bundle, deepLinkResponse, deepLinkCallback)) == null) {
            if (deepLinkResponse == null) {
                deepLinkResponse = new DeepLinkCallback.DeepLinkResponse();
            }
            if (deepLinkItem == null) {
                return deepLinkResponse;
            }
            String str = deepLinkItem.appUrl;
            String str2 = deepLinkItem.webUrl;
            String str3 = deepLinkItem.pkgName;
            String str4 = deepLinkItem.marketUrl;
            String str5 = deepLinkItem.marketPkgName;
            boolean z = deepLinkItem.isDesignatePkg;
            if (tryOpenInnerLink(context, str, deepLinkCallback, deepLinkResponse)) {
                return processResponseMessage(deepLinkResponse);
            }
            if (tryOpenApp(context, str, str3, bundle, deepLinkCallback, z, deepLinkResponse)) {
                return processResponseMessage(deepLinkResponse);
            }
            if (tryOpenMarket(context, str4, str5, bundle, deepLinkCallback, z, deepLinkResponse)) {
                return processResponseMessage(deepLinkResponse);
            }
            tryOpenWebUrl(context, str2, bundle, deepLinkCallback, deepLinkResponse);
            return processResponseMessage(deepLinkResponse);
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeLLLLL.objValue;
    }

    public static boolean tryOpenWebUrl(Context context, String str, Bundle bundle, DeepLinkCallback deepLinkCallback, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65552, null, context, str, bundle, deepLinkCallback, deepLinkResponse)) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, -6);
                callbackFailed(deepLinkCallback, -6, "Uri web url is empty", deepLinkResponse);
                return false;
            }
            SchemeActionHelper.printLog("web tryOpenWebUrl-->" + str);
            if (openWebUrl(context, str, bundle)) {
                deepLinkResponse.onSucceed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB);
                callbackSuccess(deepLinkCallback, DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, deepLinkResponse);
                return true;
            }
            deepLinkResponse.onFailed(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, -7);
            callbackFailed(deepLinkCallback, -7, "Uri web url open failed", deepLinkResponse);
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            return dealDeepLink(context, new UriBuilder(str), null, null);
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeLL.objValue;
    }

    public static DeepLinkCallback.DeepLinkResponse dealDeepLink(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, context, str, str2, str3, str4)) == null) {
            return dealDeepLink(context, new DeepLinkItem(str, str2, str3, str4), (Bundle) null, new DeepLinkCallback.DeepLinkResponse(), (DeepLinkCallback) null);
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeLLLLL.objValue;
    }

    public static boolean isTieBaDeepLink(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return SchemeActionHelper.isSchemeAction(str, SchemeActionName.SCHEME_ACTION_DEEPLINK);
        }
        return invokeL.booleanValue;
    }

    public static DeepLinkCallback.DeepLinkResponse processResponseMessage(DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, deepLinkResponse)) == null) {
            SchemeActionHelper.printLog("returnDeepLinkResponse-->" + deepLinkResponse.toString());
            return deepLinkResponse;
        }
        return (DeepLinkCallback.DeepLinkResponse) invokeL.objValue;
    }

    public static boolean openApp(Context context, String str, String str2, Bundle bundle, boolean z, OpenAppCallback openAppCallback) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, str, str2, bundle, Boolean.valueOf(z), openAppCallback})) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, str, bundle)) == null) {
            String[] strArr = {wp4.k(str)};
            UrlManager urlManager = UrlManager.getInstance();
            if (urlManager == null || (a = oq8.a(context)) == null) {
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

    public static boolean tryOpenApp(Context context, String str, String str2, Bundle bundle, DeepLinkCallback deepLinkCallback, boolean z, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, str, str2, bundle, deepLinkCallback, Boolean.valueOf(z), deepLinkResponse})) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed("app", -4);
                return false;
            }
            OpenAppCallback openAppCallback = new OpenAppCallback(deepLinkResponse) { // from class: com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkAction.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$msg = deepLinkResponse;
                }

                @Override // com.baidu.tbadk.core.util.schemeaction.deeplink.OpenAppCallback
                public void onFailed(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.val$msg.onFailed("app", i);
                    }
                }
            };
            SchemeActionHelper.printLog("app tryOpenApp-->" + str);
            if (!openApp(context, str, str2, bundle, z, openAppCallback)) {
                return false;
            }
            deepLinkResponse.onSucceed("app");
            callbackSuccess(deepLinkCallback, "app", deepLinkResponse);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean tryOpenMarket(Context context, String str, String str2, Bundle bundle, DeepLinkCallback deepLinkCallback, boolean z, DeepLinkCallback.DeepLinkResponse deepLinkResponse) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, str, str2, bundle, deepLinkCallback, Boolean.valueOf(z), deepLinkResponse})) == null) {
            if (TextUtils.isEmpty(str)) {
                deepLinkResponse.onFailed("market", -5);
                return false;
            } else if (!openApp(context, str, str2, bundle, z, new OpenAppCallback(deepLinkResponse) { // from class: com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkAction.2
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$msg = deepLinkResponse;
                }

                @Override // com.baidu.tbadk.core.util.schemeaction.deeplink.OpenAppCallback
                public void onFailed(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.val$msg.onFailed("market", i);
                    }
                }
            })) {
                return false;
            } else {
                deepLinkResponse.onSucceed("market");
                callbackSuccess(deepLinkCallback, "market", deepLinkResponse);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }
}
