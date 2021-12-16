package c.p.a;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes9.dex */
public class h4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f31171b;

    /* renamed from: c  reason: collision with root package name */
    public Info f31172c;

    public h4(Context context) {
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
        this.a = context;
        if (w2.a()) {
            a();
        } else {
            w2.a.post(new s3(this));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f31171b == null) {
            WebView webView = new WebView(this.a);
            this.f31171b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f31171b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f31171b.removeJavascriptInterface("accessibility");
                this.f31171b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f31171b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f31171b.getSettings().setBlockNetworkImage(true);
            this.f31171b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f31171b.getSettings().setCacheMode(2);
            this.f31171b.getSettings().setAppCacheEnabled(true);
            this.f31171b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setNeedInitialFocus(false);
            this.f31171b.clearCache(true);
            this.f31171b.clearHistory();
            this.f31171b.setWebChromeClient(new w3(this));
            this.f31171b.setWebViewClient(new z3(this));
        }
    }
}
