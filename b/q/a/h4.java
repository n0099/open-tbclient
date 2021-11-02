package b.q.a;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class h4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f33336a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f33337b;

    /* renamed from: c  reason: collision with root package name */
    public Info f33338c;

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
        this.f33336a = context;
        if (w2.a()) {
            a();
        } else {
            w2.f33550a.post(new s3(this));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f33337b == null) {
            WebView webView = new WebView(this.f33336a);
            this.f33337b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f33337b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f33337b.removeJavascriptInterface("accessibility");
                this.f33337b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f33337b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f33337b.getSettings().setBlockNetworkImage(true);
            this.f33337b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f33337b.getSettings().setCacheMode(2);
            this.f33337b.getSettings().setAppCacheEnabled(true);
            this.f33337b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setNeedInitialFocus(false);
            this.f33337b.clearCache(true);
            this.f33337b.clearHistory();
            this.f33337b.setWebChromeClient(new w3(this));
            this.f33337b.setWebViewClient(new z3(this));
        }
    }
}
