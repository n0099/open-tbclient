package b.q.a;

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
/* loaded from: classes6.dex */
public class j3 implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public z f33353a;

    /* renamed from: b  reason: collision with root package name */
    public r f33354b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f33355c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33356d;

    /* renamed from: e  reason: collision with root package name */
    public String f33357e;

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
        this.f33355c = webView;
        webView.setScrollContainer(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        r0.m(webView);
        this.f33355c.getSettings().setJavaScriptEnabled(true);
        JsBridge.getInstance().clazz(JsInvokeJavaScope.class).inject();
        this.f33355c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.f33355c.setWebViewClient(new f3(this));
    }

    public void a(String str, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, info) == null) {
            if ((!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) || str.startsWith(ImageSource.FILE_SCHEME)) {
                this.f33355c.loadUrl(str);
            } else {
                this.f33355c.loadDataWithBaseURL("http://abcd/", str, SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
            }
            z zVar = this.f33353a;
            if (zVar != null) {
                zVar.a();
            }
            this.f33355c.setOnTouchListener(new m3(info, new b3(this)));
        }
    }
}
