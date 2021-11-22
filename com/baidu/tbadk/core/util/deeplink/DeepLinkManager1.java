package com.baidu.tbadk.core.util.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes8.dex */
public class DeepLinkManager1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_DEEPLINK = "tieba://deeplink?";
    public static final String AD_JUMP = "jump";
    public static final String AD_WAP = "wap";
    public static final String DEEPLINK_APPURL_KEY = "appUrl";
    public static final String DEEPLINK_PKGNAME_KEY = "pkgName";
    public static final String DEEPLINK_WEBURL_KEY = "webUrl";
    public static final int JUMP_FAILED = 0;
    public static final int JUMP_NORMAL_LINK_SUCCESS = 1;
    public static final String TIEBA_DEEPLINK = "tiebaapp://router/deeplink";
    public transient /* synthetic */ FieldHolder $fh;

    public DeepLinkManager1() {
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

    public static int dealDeepLink(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        UriBuilder uriBuilder;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, bundle)) == null) {
            boolean z = false;
            if (context == null || TextUtils.isEmpty(str) || (uri = (uriBuilder = new UriBuilder(str)).getUri()) == null) {
                return 0;
            }
            String queryJumpUrl = getQueryJumpUrl(uri, "appUrl");
            String queryJumpUrl2 = getQueryJumpUrl(uri, "webUrl");
            String queryJumpUrl3 = getQueryJumpUrl(uri, "pkgName");
            if (TextUtils.isEmpty(queryJumpUrl) && TextUtils.isEmpty(queryJumpUrl2)) {
                z = true;
            }
            Bundle params = uriBuilder.getParams();
            if (z && params != null) {
                queryJumpUrl = params.getString("appUrl");
                queryJumpUrl2 = params.getString("webUrl");
                queryJumpUrl3 = params.getString("pkgName");
            }
            if (TextUtils.isEmpty(queryJumpUrl)) {
                queryJumpUrl = getQueryJumpUrl(uri, "jump");
            }
            if (TextUtils.isEmpty(queryJumpUrl2)) {
                queryJumpUrl2 = getQueryJumpUrl(uri, AD_WAP);
            }
            if (str.startsWith("tiebaapp://router/deeplink") || str.startsWith(AD_DEEPLINK)) {
                if (tryOpenApp(context, queryJumpUrl, queryJumpUrl3) || openWebUrl(context, queryJumpUrl2, bundle)) {
                    return 1000;
                }
                return tryOpenSchemeLink(context, str, queryJumpUrl3, bundle);
            }
            return isDeepLinkOpenSucc(tryOpenSchemeLink(context, str, queryJumpUrl3, bundle)) ? 1 : 0;
        }
        return invokeLLL.intValue;
    }

    public static String getQueryJumpUrl(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uri, str)) == null) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isDeepLinkOpenSucc(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 1000 : invokeI.booleanValue;
    }

    public static boolean isDeeplinkCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            switch (i2) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static int openApp(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, uri)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return 1004;
                }
                context.startActivity(intent);
                return 1000;
            } catch (Exception unused) {
                return 1006;
            }
        }
        return invokeLL.intValue;
    }

    public static boolean openWebUrl(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, bundle)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String[] strArr = {str};
            UrlManager urlManager = UrlManager.getInstance();
            if (urlManager == null || (tbPageContext = (TbPageContext) j.a(context)) == null) {
                return false;
            }
            if (urlManager.UrlValidated(str)) {
                urlManager.dealOneLink(tbPageContext, strArr, true, bundle);
                return true;
            }
            return urlManager.dealOneLink(tbPageContext, strArr, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean tryOpenApp(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                i2 = openApp(context, Uri.parse(str));
            } catch (Exception unused) {
                i2 = 1003;
            }
            return i2 == 1000;
        }
        return invokeLLL.booleanValue;
    }

    public static int tryOpenSchemeLink(Context context, String str, String str2, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, context, str, str2, bundle)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return (tryOpenApp(context, str, str2) || openWebUrl(context, str, bundle)) ? 1000 : 0;
        }
        return invokeLLLL.intValue;
    }
}
