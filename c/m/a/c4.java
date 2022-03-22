package c.m.a;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class c4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f23415b;

    /* renamed from: c  reason: collision with root package name */
    public Info f23416c;

    public c4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        if (r2.a()) {
            a();
        } else {
            r2.a.post(new n3(this));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23415b == null) {
            WebView webView = new WebView(this.a);
            this.f23415b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f23415b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f23415b.removeJavascriptInterface("accessibility");
                this.f23415b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f23415b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f23415b.getSettings().setBlockNetworkImage(true);
            this.f23415b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f23415b.getSettings().setCacheMode(2);
            this.f23415b.getSettings().setAppCacheEnabled(true);
            this.f23415b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setNeedInitialFocus(false);
            this.f23415b.clearCache(true);
            this.f23415b.clearHistory();
            this.f23415b.setWebChromeClient(new r3(this));
            this.f23415b.setWebViewClient(new u3(this));
        }
    }
}
