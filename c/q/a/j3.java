package c.q.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.win.opensdk.bridge.JsBridge;
import com.win.opensdk.bridge.JsInvokeJavaScope;
import com.win.opensdk.bridge.core.JsBridgeWebChromeClient;
import com.win.opensdk.core.Info;
/* loaded from: classes9.dex */
public class j3 implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z a;

    /* renamed from: b  reason: collision with root package name */
    public r f30371b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f30372c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30373d;

    /* renamed from: e  reason: collision with root package name */
    public String f30374e;

    public j3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        WebView webView = new WebView(context);
        this.f30372c = webView;
        webView.setScrollContainer(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        r0.m(webView);
        this.f30372c.getSettings().setJavaScriptEnabled(true);
        JsBridge.getInstance().clazz(JsInvokeJavaScope.class).inject();
        this.f30372c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.f30372c.setWebViewClient(new f3(this));
    }

    public void a(String str, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, info) == null) {
            if ((!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) || str.startsWith(ImageSource.FILE_SCHEME)) {
                this.f30372c.loadUrl(str);
            } else {
                this.f30372c.loadDataWithBaseURL("http://abcd/", str, SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
            }
            z zVar = this.a;
            if (zVar != null) {
                zVar.a();
            }
            this.f30372c.setOnTouchListener(new m3(info, new b3(this)));
        }
    }
}
