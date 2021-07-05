package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class h extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.sdk.app.b f2028b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f2029c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        WebView webView = new WebView(activity);
        this.f2029c = webView;
        a(webView, activity);
        addView(this.f2029c);
        com.alipay.sdk.app.b bVar = new com.alipay.sdk.app.b(activity);
        this.f2028b = bVar;
        this.f2029c.setWebViewClient(bVar);
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f2028b.a();
            removeAllViews();
        }
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f2029c.canGoBack()) {
                if (this.f2028b.b()) {
                    com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.f1812d.a());
                    com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b2.a(), b2.b(), ""));
                    this.f2027a.finish();
                    return true;
                }
                return true;
            }
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
            this.f2027a.finish();
            return true;
        }
        return invokeV.booleanValue;
    }

    private void a(WebView webView, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, webView, context) == null) {
            WebSettings settings = this.f2029c.getSettings();
            settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.n.c(context));
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setSupportMultipleWindows(true);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
            settings.setAllowFileAccess(false);
            settings.setTextSize(WebSettings.TextSize.NORMAL);
            settings.setDomStorageEnabled(true);
            settings.setCacheMode(1);
            this.f2029c.resumeTimers();
            this.f2029c.setVerticalScrollbarOverlay(true);
            this.f2029c.setDownloadListener(new i(this));
            try {
                try {
                    this.f2029c.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.f2029c.removeJavascriptInterface("accessibility");
                    this.f2029c.removeJavascriptInterface("accessibilityTraversal");
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                Method method = this.f2029c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f2029c, "searchBoxJavaBridge_");
                    method.invoke(this.f2029c, "accessibility");
                    method.invoke(this.f2029c, "accessibilityTraversal");
                }
            }
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f2029c.loadUrl(str);
        }
    }
}
