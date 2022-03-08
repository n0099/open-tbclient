package c.q.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class v1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, Info info, c4 c4Var, String str2) {
        WebView webView;
        y3 y3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, context, str, info, c4Var, str2) == null) {
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
                new j3().a(context, str, info);
            } else if (b(context, Uri.parse(str), info)) {
            } else {
                if (info.getOpent() == 1) {
                    if (u0.f29141d.f29143c) {
                        Toast.makeText(context, context.getString(R.string.win_wdownload_loading), 1).show();
                        t2 a = x2.a(context);
                        a.q(new b3(info), 5);
                        a.m();
                        return;
                    }
                    if (!TextUtils.isEmpty(info.getDl_name())) {
                        Context applicationContext = context.getApplicationContext();
                        Toast.makeText(applicationContext, context.getString(R.string.win_wdownload_start_load) + info.getDl_name(), 0).show();
                    }
                    t2 a2 = x2.a(context);
                    b3 b3Var = new b3(info);
                    String open = info.getOpen();
                    try {
                        a2.f29126b = x2.d("wdtr", b3Var);
                        a2.l("msg", x2.b(open));
                    } catch (JSONException unused2) {
                    }
                    a2.m();
                    if (c4Var != null) {
                        c4Var.f28931c = info;
                        WebView webView2 = c4Var.f28930b;
                        if (webView2 == null) {
                            return;
                        }
                        webView2.loadUrl(info.getOpen());
                        webView = c4Var.f28930b;
                        y3Var = new y3(c4Var);
                    } else {
                        c4 c4Var2 = new c4(context);
                        c4Var2.f28931c = info;
                        WebView webView3 = c4Var2.f28930b;
                        if (webView3 == null) {
                            return;
                        }
                        webView3.loadUrl(info.getOpen());
                        webView = c4Var2.f28930b;
                        y3Var = new y3(c4Var2);
                    }
                    webView.setDownloadListener(y3Var);
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
                y2.a(context, Uri.parse(str));
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
                                t2 a = x2.a(context);
                                a.i(new b3(info), e2.getMessage(), 2);
                                a.m();
                                d1.x = false;
                            }
                            return false;
                        }
                    }
                    y2.b(context, uri);
                    if (info != null) {
                        t2 a2 = x2.a(context);
                        a2.i(new b3(info), uri.toString(), 0);
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
