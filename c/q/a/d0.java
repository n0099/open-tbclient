package c.q.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d0 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ H5OpenActivity a;

    public d0(H5OpenActivity h5OpenActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h5OpenActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h5OpenActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
            Context applicationContext = this.a.getApplicationContext();
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if ((TextUtils.isEmpty(scheme) || scheme.equals("http") || scheme.equals("https")) ? false : true) {
                try {
                    t2 a = x2.a(applicationContext);
                    a.i(new b3(this.a.f59386d), parse.toString(), 0);
                    a.m();
                    HashMap hashMap = new HashMap();
                    hashMap.put("__SCHEME__", parse.toString());
                    Info info = this.a.f59386d;
                    if (info != null) {
                        r0.K(r0.i((String) info.getEvents().get(600, ""), "", info.isHo_c_sw(), hashMap));
                    }
                    y2.b(applicationContext, parse);
                    return true;
                } catch (Exception e2) {
                    t2 a2 = x2.a(applicationContext);
                    a2.i(new b3(this.a.f59386d), e2.getMessage(), 2);
                    a2.m();
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
