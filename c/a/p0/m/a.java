package c.a.p0.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.util.Base64Encoder;
import com.dxmpay.wallet.core.Domains;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f13575a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, webSettings) == null) {
            CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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
                sb.append("&cuid_gid=");
                sb.append(TbadkCoreApplication.getInst().getCuidGid());
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, List<Pair<String, String>> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (k.isEmpty(str) || list == null) {
                return str;
            }
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
        return (String) invokeLL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (k.isEmpty(str) || str.indexOf("_client_version=") <= -1) {
                return str + "&_client_version=" + TbConfig.getVersion();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void e(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            i();
            try {
                if (StringUtils.isNull(str)) {
                    return;
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, "", str, true, false, false, false);
                tbWebViewActivityConfig.setLoadType(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static String f() {
        CookieManager cookieManager;
        String[] split;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager == null) {
                return "";
            }
            String cookie = cookieManager.getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = f13575a;
            }
            if (cookie != null) {
                for (String str : cookie.split(";")) {
                    if (str.contains("BAIDUID=")) {
                        return str.trim().substring(8);
                    }
                }
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static void g(Context context) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
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
            if ((c.a.p0.s.l.a.b() != null ? c.a.p0.s.l.a.b().d(TbadkCoreApplication.getCurrentBduss()) : null) != null) {
                String a2 = c.a.p0.s.l.e.a(TbadkCoreApplication.getCurrentAccountInfo());
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
            cookieManager.setCookie(Domains.BAIDU, "CUID=" + TbadkCoreApplication.getInst().getCuid() + ";");
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            cookieManager.setCookie(Domains.BAIDU, "BAIDUCUID=" + (!TextUtils.isEmpty(cuidGalaxy2) ? new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())) : "") + ";");
            cookieManager.setCookie(Domains.BAIDU, "TBBRAND=" + Build.MODEL + ";");
            cookieManager.setCookie(Domains.BAIDU, "BAIDUZID=" + TbadkCoreApplication.getInst().getZid() + ";");
            cookieManager.setCookie(Domains.BAIDU, "cuid_galaxy2=" + cuidGalaxy2 + ";");
            cookieManager.setCookie(Domains.BAIDU, "cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ";");
            cookieManager.setCookie(Domains.BAIDU, "BDUSS=" + TbadkCoreApplication.getCurrentBduss() + ";HttpOnly");
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

    public static String h(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
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

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            new PvThread("open_webview", true).start();
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            f13575a = str;
        }
    }

    public static void k(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) {
            String d2 = d(b(str));
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(d2));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void l(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, str) == null) {
            m(context, str);
        }
    }

    public static void m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            t(context, true, str);
        }
    }

    public static void n(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, str, str2) == null) {
            q(context, str, str2, true, true, true, true, true);
        }
    }

    public static void o(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            q(context, str, str2, true, z, true, true, true);
        }
    }

    public static void p(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            q(context, str, str2, z, z2, z3, true, true);
        }
    }

    public static void q(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            i();
            try {
                if (StringUtils.isNull(str2)) {
                    return;
                }
                if (z5) {
                    str2 = d(b(str2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, str, str2, z, z2, z3)));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void r(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            s(context, str, str2, z, z2, z3, z4, z5, z6, false);
        }
    }

    public static void s(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7)}) == null) {
            i();
            try {
                if (StringUtils.isNull(str2)) {
                    return;
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, str, z5 ? d(b(str2)) : str2, z, z2, z3, z6);
                tbWebViewActivityConfig.setFixTitle(z7);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void t(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            q(context, "", str, true, true, true, true, z);
        }
    }

    public static void u(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            q(context, str2, str, true, true, true, true, z);
        }
    }

    public static void v(boolean z, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{Boolean.valueOf(z), context, str, str2}) == null) {
            s(context, str, str2, true, true, true, true, true, false, z);
        }
    }
}
