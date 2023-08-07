package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper;
import com.baidu.tbadk.core.atomData.TbWebContainerActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.bi;
import com.baidu.tieba.bv9;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cz4;
import com.baidu.tieba.e05;
import com.baidu.tieba.jk6;
import com.baidu.tieba.lk6;
import com.baidu.tieba.ow4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
/* loaded from: classes4.dex */
public class BrowserHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] TYPE_WHITE_FORM;
    public static String sAdCookie;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-696413137, "Lcom/baidu/tbadk/browser/BrowserHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-696413137, "Lcom/baidu/tbadk/browser/BrowserHelper;");
                return;
            }
        }
        TYPE_WHITE_FORM = new String[]{"/mo/q/priforum/create/info", "/mo/q/forumtarget"};
    }

    public BrowserHelper() {
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

    public static void WebViewNoDataBase(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, webSettings) == null) {
            CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
        }
    }

    public static boolean allowedUseNewWebContainer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return lk6.e(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean isExistWhiteForum(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            for (String str2 : TYPE_WHITE_FORM) {
                if (str2.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setAdCookie(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            sAdCookie = str;
        }
    }

    public static String appendClientType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!isExistWhiteForum(str) && !bi.isEmpty(str) && str.contains("_client_type=")) {
                return str;
            }
            return str + "&_client_type=2";
        }
        return (String) invokeL.objValue;
    }

    public static String appendVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!bi.isEmpty(str) && str.indexOf("_client_version=") > -1) {
                return str;
            }
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return (String) invokeL.objValue;
    }

    public static String appendCuidParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!bi.isEmpty(str) && str.indexOf("cuid=") <= -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (str.indexOf("?") > 0) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                if (!UtilHelper.isNativeAdURL(str)) {
                    sb.append("cuid=");
                    sb.append(TbadkCoreApplication.getInst().getCuid());
                    sb.append("&cuid_galaxy2=");
                    sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                    sb.append("&cuid_gid=");
                    sb.append(TbadkCoreApplication.getInst().getCuidGid());
                }
                sb.append("&timestamp=");
                sb.append(Long.toString(System.currentTimeMillis()));
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String appendParams(String str, List<Pair<String, String>> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, list)) == null) {
            if (!bi.isEmpty(str) && list != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (str.indexOf("?") < 0) {
                    sb.append("?");
                }
                for (Pair<String, String> pair : list) {
                    if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                        sb.append("&");
                        sb.append((String) pair.first);
                        sb.append("=");
                        sb.append((String) pair.second);
                    }
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static TbWebViewActivityConfig getActivityConfig(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            return getActivityConfig(context, str, str2, true, z, true);
        }
        return (TbWebViewActivityConfig) invokeCommon.objValue;
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            startWebActivity(context, str, str2, true, z, true, true, true);
        }
    }

    public static TbWebViewActivityConfig getActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            return getActivityConfig(context, str, str2, z, z2, z3, false);
        }
        return (TbWebViewActivityConfig) invokeCommon.objValue;
    }

    public static TbWebViewActivityConfig getActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            Context context2 = context;
            if (!allowedUseNewWebContainer(str2) && !z4) {
                return new TbWebViewActivityConfig(context2, str, str2, z, z2, z3);
            }
            jk6.c(str2);
            return new TbWebContainerActivityConfig(context2, str, str2, z, z2, z3);
        }
        return (TbWebViewActivityConfig) invokeCommon.objValue;
    }

    public static String getBaiduId() {
        CookieManager cookieManager;
        String[] split;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager == null) {
                return "";
            }
            String cookie = cookieManager.getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = sAdCookie;
            }
            if (cookie == null) {
                return "";
            }
            for (String str : cookie.split(ParamableElem.DIVIDE_PARAM)) {
                if (str.contains("BAIDUID=")) {
                    return str.trim().substring(8);
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static void initCookie(Context context) {
        ow4 ow4Var;
        AccountLoginCoreHelper.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            try {
                CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
                ow4Var = new ow4();
            } catch (Throwable th) {
                BdLog.e(th);
                ow4Var = null;
            }
            if (ow4Var == null) {
                return;
            }
            ow4Var.setAcceptCookie(true);
            if (AccountLoginCoreHelper.getInstance() != null) {
                aVar = AccountLoginCoreHelper.getInstance().parseBDUSS(TbadkCoreApplication.getCurrentBduss());
            } else {
                aVar = null;
            }
            if (aVar != null) {
                String a = e05.a(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(a)) {
                    sb.append("STOKEN=");
                    sb.append(a);
                    sb.append("; domain=.tieba.baidu.com;");
                    ow4Var.setCookie("tieba.baidu.com", sb.toString());
                }
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        ow4Var.removeAllCookies(null);
                        CookieManager.getInstance().flush();
                    } else {
                        ow4Var.removeAllCookie();
                        CookieSyncManager.createInstance(context);
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            ow4Var.setCookie(".baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + ParamableElem.DIVIDE_PARAM);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                str = new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes()));
            } else {
                str = "";
            }
            ow4Var.setCookie(".baidu.com", "BAIDUCUID=" + str + ParamableElem.DIVIDE_PARAM);
            ow4Var.setCookie(".baidu.com", "need_cookie_decrypt=0" + ParamableElem.DIVIDE_PARAM);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TBBRAND");
            sb2.append("=");
            sb2.append(ParamableElem.DIVIDE_PARAM);
            ow4Var.setCookie(".baidu.com", sb2.toString());
            ow4Var.setCookie(".baidu.com", "DNARBBT=" + ParamableElem.DIVIDE_PARAM);
            if (bv9.b()) {
                ow4Var.setCookie(".baidu.com", "TBBRAND=" + DeviceInfoHelper.getModel() + ParamableElem.DIVIDE_PARAM);
            } else {
                ow4Var.setCookie(".baidu.com", "need_cookie_decrypt=" + bv9.c() + ParamableElem.DIVIDE_PARAM);
                String d = bv9.d("TBBRAND");
                if (!TextUtils.isEmpty(d)) {
                    ow4Var.setCookie(".baidu.com", d + "=" + bv9.e() + ParamableElem.DIVIDE_PARAM);
                }
            }
            ow4Var.setCookie(".baidu.com", "BAIDUZID=" + TbadkCoreApplication.getInst().getZid() + ParamableElem.DIVIDE_PARAM);
            ow4Var.setCookie(".baidu.com", "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti() + ParamableElem.DIVIDE_PARAM);
            ow4Var.setCookie(".baidu.com", "cuid_galaxy2=" + cuidGalaxy2 + ParamableElem.DIVIDE_PARAM);
            ow4Var.setCookie(".baidu.com", "cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ParamableElem.DIVIDE_PARAM);
            ow4Var.setCookie(".baidu.com", "BDUSS=" + TbadkCoreApplication.getCurrentBduss() + ParamableElem.DIVIDE_PARAM + "HttpOnly");
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.getInstance().sync();
                }
                SapiAccountManager.getInstance().getAccountService().webLogin(context);
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
        }
    }

    public static String parseWebViewUrl(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                str = "http://".concat(str);
            }
            if (str.contains("?")) {
                str3 = "&st_type=" + str2;
            } else {
                str3 = "?st_type=" + str2;
            }
            return str.concat(str3);
        }
        return (String) invokeLL.objValue;
    }

    public static void startExternWebActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            startExternWebActivity(context, str, true);
        }
    }

    public static void startInternalWebActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) {
            startWebActivity(context, str);
        }
    }

    public static void startWebActivity(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, context, uri) == null) {
            TbWebContainerActivityConfig tbWebContainerActivityConfig = new TbWebContainerActivityConfig(context);
            tbWebContainerActivityConfig.setUri(uri);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebContainerActivityConfig));
        }
    }

    public static void startExternWebActivity(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65553, null, context, str, z) == null) {
            if (z) {
                str = appendVersionCode(appendCuidParam(str));
            }
            try {
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
                intent.setData(Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void startWebActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, str) == null) {
            startWebActivity(context, true, str);
        }
    }

    public static void startWebActivity(Context context, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, context, str, bundle) == null) {
            startWebActivity(context, "", str, bundle);
        }
    }

    public static void startWebActivity(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, context, str, str2) == null) {
            startWebActivity(context, str, str2, true, true, true, true, true);
        }
    }

    public static void startWebActivity(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, null, context, str, str2, bundle) == null) {
            cz4 j = cz4.j(context, str2);
            j.r(str);
            j.a(bundle);
            j.p();
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, str, str2, Boolean.valueOf(z), bundle}) == null) {
            cz4 j = cz4.j(context, str2);
            j.r(str);
            j.k(z);
            j.a(bundle);
            j.p();
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            startWebActivity(context, str, str2, z, z2, z3, true, true);
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bundle}) == null) {
            cz4 j = cz4.j(context, str2);
            j.r(str);
            j.m(z);
            j.k(z2);
            j.c(z3);
            j.a(bundle);
            j.p();
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            startWebActivity(context, str, str2, z, z2, z3, z4, z5, false, false);
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            startWebActivity(context, str, str2, z, z2, z3, z4, z5, z6, false);
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7)}) == null) {
            cz4 j = cz4.j(context, str2);
            j.r(str);
            j.m(z);
            j.k(z2);
            j.c(z3);
            j.i(z4);
            j.g(z5);
            j.l(z6);
            j.d(z7);
            j.p();
        }
    }

    public static void startWebActivity(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            startWebActivity(context, "", str, true, true, true, true, z);
        }
    }

    public static void startWebActivity(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            startWebActivity(context, str2, str, true, true, true, true, z);
        }
    }

    public static void startWebActivity(boolean z, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{Boolean.valueOf(z), context, str, str2}) == null) {
            startWebActivity(context, str, str2, true, true, true, true, true, false, z);
        }
    }
}
