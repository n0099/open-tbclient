package c.a.r0.q.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.s.l.a;
import c.a.q0.s.l.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdWebViewActivityConfig;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (k.isEmpty(str) || str.indexOf("cuid=") > -1) {
                return str;
            }
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
                sb.append("&c3_aid=");
                sb.append(TbadkCoreApplication.getInst().getCuidGalaxy3());
                sb.append("&cuid_gid=");
                sb.append(TbadkCoreApplication.getInst().getCuidGid());
            }
            sb.append("&timestamp=");
            sb.append(System.currentTimeMillis());
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (k.isEmpty(str) || str.indexOf("_client_version=") <= -1) {
                return str + "&_client_version=" + TbConfig.getVersion();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void c(Context context) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            a.b d2 = c.a.q0.s.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
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
            if (d2 != null) {
                cookieManager.setAcceptCookie(true);
                cookieManager.setCookie("baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + "; domain=.baidu.com; cuid_galaxy2=" + TbadkCoreApplication.getInst().getCuidGalaxy2() + "; c3_aid=" + TbadkCoreApplication.getInst().getCuidGalaxy3() + "; cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ";");
                String a2 = e.a(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(a2)) {
                    sb.append("STOKEN=");
                    sb.append(a2);
                    sb.append("; domain=.tieba.baidu.com;");
                    cookieManager.setCookie(TbPatternsCompat.TB_DOMAIN_NAME, sb.toString());
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
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
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

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            new PvThread("open_webview", true).start();
        }
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) {
            String b2 = b(a(str));
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(b2));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void g(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2, bundle) == null) {
            h(context, str2, str, true, true, true, bundle);
        }
    }

    public static void h(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bundle}) == null) {
            e();
            try {
                if (StringUtils.isNull(str2)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AdWebViewActivityConfig(context, str, str2, z, z2, z3, bundle)));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
