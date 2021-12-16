package c.p.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes9.dex */
public class a2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, Info info, h4 h4Var, String str2) {
        WebView webView;
        d4 d4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, context, str, info, h4Var, str2) == null) {
            if (info != null) {
                try {
                    if (info.getOpent() == 3 && TextUtils.isEmpty(str)) {
                        str = info.getOpen();
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            if (info != null && info.getOpent() == 0 && TextUtils.isEmpty(str)) {
                str = info.getOpen();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    str = r0.i(str, str2, info.isHo_c_sw(), null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if ((info != null ? info.getPs() : 0) != 0) {
                new o3().a(context, str, info);
            } else if (b(context, Uri.parse(str), info)) {
            } else {
                if (info.getOpent() == 1) {
                    if (u0.f31323d.f31325c) {
                        Toast.makeText(context, context.getString(m1.win_wdownload_loading), 1).show();
                        y2 a = c3.a(context);
                        a.q(new g3(info), 5);
                        a.m();
                        return;
                    }
                    if (!TextUtils.isEmpty(info.getDl_name())) {
                        Context applicationContext = context.getApplicationContext();
                        Toast.makeText(applicationContext, context.getString(m1.win_wdownload_start_load) + info.getDl_name(), 0).show();
                    }
                    y2 a2 = c3.a(context);
                    g3 g3Var = new g3(info);
                    String open = info.getOpen();
                    try {
                        a2.f31377b = c3.d("wdtr", g3Var);
                        a2.l("msg", c3.b(open));
                    } catch (JSONException unused2) {
                    }
                    a2.m();
                    if (h4Var != null) {
                        h4Var.f31172c = info;
                        WebView webView2 = h4Var.f31171b;
                        if (webView2 == null) {
                            return;
                        }
                        webView2.loadUrl(info.getOpen());
                        webView = h4Var.f31171b;
                        d4Var = new d4(h4Var);
                    } else {
                        h4 h4Var2 = new h4(context);
                        h4Var2.f31172c = info;
                        WebView webView3 = h4Var2.f31171b;
                        if (webView3 == null) {
                            return;
                        }
                        webView3.loadUrl(info.getOpen());
                        webView = h4Var2.f31171b;
                        d4Var = new d4(h4Var2);
                    }
                    webView.setDownloadListener(d4Var);
                    return;
                }
                if (info.getOpent() == 3) {
                    Intent intent = new Intent(context, H5OpenActivity.class);
                    info.setOph5Url(str);
                    intent.putExtra("Key_H5OpenActData", info);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                d3.a(context, Uri.parse(str));
            }
        }
    }

    public static boolean b(Context context, Uri uri, Info info) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, uri, info)) == null) {
            if (context != null && uri != null) {
                String scheme = uri.getScheme();
                if ((info != null && !TextUtils.isEmpty(info.getDpl())) || (scheme != null && !scheme.equals("http") && !scheme.equals("https"))) {
                    if (info != null) {
                        try {
                            if (!TextUtils.isEmpty(info.getDpl())) {
                                uri = Uri.parse(info.getDpl());
                            }
                        } catch (Exception e2) {
                            if (info != null) {
                                y2 a = c3.a(context);
                                a.i(new g3(info), e2.getMessage(), 2);
                                a.m();
                                d1.x = false;
                            }
                            return false;
                        }
                    }
                    d3.b(context, uri);
                    if (info != null) {
                        y2 a2 = c3.a(context);
                        a2.i(new g3(info), uri.toString(), 0);
                        a2.m();
                        d1.x = true;
                    }
                    return true;
                } else if ((scheme == null || !scheme.equals("http")) && scheme.equals("https")) {
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, info)) == null) ? info != null && info.getOpent() == 3 : invokeL.booleanValue;
    }

    public static boolean d(Info info, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, info, j2)) == null) ? info != null && System.currentTimeMillis() - j2 > 1000 : invokeLJ.booleanValue;
    }
}
