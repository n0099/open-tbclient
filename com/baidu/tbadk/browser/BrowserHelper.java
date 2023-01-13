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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebContainerActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.bj;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.rr4;
import com.baidu.tieba.sr4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BrowserHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static String b;
    public static boolean c;
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
        a = new String[]{"/mo/q/priforum/create/info", "/mo/q/forumtarget"};
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65548, null) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        new PvThread("open_webview", true).start();
    }

    public static void A(boolean z, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), context, str, str2}) == null) {
            w(context, str, str2, true, true, true, true, true, false, z);
        }
    }

    public static void s(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            u(context, str, str2, true, z, true, true, true);
        }
    }

    public static void z(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            u(context, str2, str, true, true, true, true, z);
        }
    }

    public static void a(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, webSettings) == null) {
            CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
        }
    }

    public static boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            for (String str2 : a) {
                if (str2.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            b = str;
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (UbsABTestHelper.isWebViewOptimizeTestGroup()) {
                for (String str2 : new ArrayList<String>() { // from class: com.baidu.tbadk.browser.BrowserHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        add("https://tieba.baidu.com/mo/q/wise-main-share/godTlist");
                        add("https://tieba.baidu.com/mo/q/newtopic/topicTemplate");
                    }
                }) {
                    if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!i(str) && !yi.isEmpty(str) && str.contains("_client_type=")) {
                return str;
            }
            return str + "&_client_type=2";
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!yi.isEmpty(str) && str.indexOf("_client_version=") > -1) {
                return str;
            }
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!yi.isEmpty(str) && str.indexOf("cuid=") <= -1) {
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

    public static String e(String str, List<Pair<String, String>> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, list)) == null) {
            if (!yi.isEmpty(str) && list != null) {
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

    public static String g() {
        CookieManager cookieManager;
        String[] split;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
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
                cookie = b;
            }
            if (cookie == null) {
                return "";
            }
            for (String str : cookie.split(";")) {
                if (str.contains("BAIDUID=")) {
                    return str.trim().substring(8);
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static void h(Context context) {
        CookieManager cookieManager;
        sr4.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            try {
                CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
                cookieManager = CookieManager.getInstance();
            } catch (Throwable th) {
                BdLog.e(th);
                cookieManager = null;
            }
            if (cookieManager == null) {
                return;
            }
            cookieManager.setAcceptCookie(true);
            if (sr4.b() != null) {
                bVar = sr4.b().c(TbadkCoreApplication.getCurrentBduss());
            } else {
                bVar = null;
            }
            if (bVar != null) {
                String a2 = rr4.a(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(a2)) {
                    sb.append("STOKEN=");
                    sb.append(a2);
                    sb.append("; domain=.tieba.baidu.com;");
                    cookieManager.setCookie("tieba.baidu.com", sb.toString());
                }
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        cookieManager.removeAllCookies(null);
                        CookieManager.getInstance().flush();
                    } else {
                        cookieManager.removeAllCookie();
                        CookieSyncManager.createInstance(context);
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            cookieManager.setCookie(".baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + ";");
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                str = new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes()));
            } else {
                str = "";
            }
            cookieManager.setCookie(".baidu.com", "BAIDUCUID=" + str + ";");
            cookieManager.setCookie(".baidu.com", "TBBRAND=" + bj.g() + ";");
            cookieManager.setCookie(".baidu.com", "BAIDUZID=" + TbadkCoreApplication.getInst().getZid() + ";");
            cookieManager.setCookie(".baidu.com", "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti() + ";");
            cookieManager.setCookie(".baidu.com", "cuid_galaxy2=" + cuidGalaxy2 + ";");
            cookieManager.setCookie(".baidu.com", "cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ";");
            cookieManager.setCookie(".baidu.com", "BDUSS=" + TbadkCoreApplication.getCurrentBduss() + ";HttpOnly");
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

    public static String j(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
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

    public static void m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            n(context, str, true);
        }
    }

    public static void o(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            p(context, str);
        }
    }

    public static void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
            y(context, true, str);
        }
    }

    public static void n(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65551, null, context, str, z) == null) {
            if (z) {
                str = f(d(str));
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
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

    public static void q(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, context, str, str2) == null) {
            u(context, str, str2, true, true, true, true, true);
        }
    }

    public static void y(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            u(context, "", str, true, true, true, true, z);
        }
    }

    public static void r(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, null, context, str, str2, bundle) == null) {
            x(context, str, str2, true, true, true, true, true, false, false, bundle);
        }
    }

    public static void t(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            u(context, str, str2, z, z2, z3, true, true);
        }
    }

    public static void u(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            w(context, str, str2, z, z2, z3, z4, z5, false, false);
        }
    }

    public static void v(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            w(context, str, str2, z, z2, z3, z4, z5, z6, false);
        }
    }

    public static void w(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7)}) == null) {
            x(context, str, str2, z, z2, z3, z4, z5, z6, z7, null);
        }
    }

    public static void x(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Bundle bundle) {
        boolean z8;
        String str3;
        TbWebViewActivityConfig tbWebViewActivityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), bundle}) == null) {
            k();
            try {
                if (StringUtils.isNull(str2)) {
                    return;
                }
                if (bundle != null && !bundle.getBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, true)) {
                    z8 = false;
                } else {
                    z8 = z5;
                }
                if (z8) {
                    str3 = c(f(d(str2)));
                } else {
                    str3 = str2;
                }
                if (b(str3)) {
                    tbWebViewActivityConfig = new TbWebContainerActivityConfig(context, str, str3, z, z2, z3);
                } else {
                    tbWebViewActivityConfig = new TbWebViewActivityConfig(context, str, str3, z, z2, z3);
                }
                tbWebViewActivityConfig.setNeedImmerSiveSticky(z6);
                tbWebViewActivityConfig.setFixTitle(z7);
                tbWebViewActivityConfig.setBundle(bundle);
                if (bundle != null && bundle.getBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false)) {
                    tbWebViewActivityConfig.setTextAutoSize(true);
                }
                if (bundle != null && "1".equals(bundle.getString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE))) {
                    tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                    tbWebViewActivityConfig.setLoadingSwitch(1);
                    tbWebViewActivityConfig.setLoadingStyle(1);
                }
                if (c) {
                    tbWebViewActivityConfig.setUseCustomHistoryStack(true);
                    c = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
