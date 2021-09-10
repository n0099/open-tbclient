package c.a.r0.w0.y1;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import c.a.e.a.f;
import c.a.e.e.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f28031a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.j3.m0.c f28032b;

    public b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28031a = fVar;
    }

    public void a(c.a.r0.j3.m0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f28032b = cVar;
        }
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f28031a.getPageActivity());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), quotaUpdater}) == null) {
            super.onExceededDatabaseQuota(str, str2, j2, j3, j4, quotaUpdater);
            quotaUpdater.updateQuota(j3 * 2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, webView, str, str2, jsResult)) == null) {
            f fVar = this.f28031a;
            if (fVar == null || !g.f(fVar)) {
                return true;
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, webView, str, str2, jsResult)) == null) {
            f fVar = this.f28031a;
            if (fVar == null || !g.f(fVar)) {
                return true;
            }
            return super.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, webView, str, str2, jsResult)) == null) {
            f fVar = this.f28031a;
            if (fVar == null || !g.f(fVar)) {
                return true;
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, webView, str, str2, str3, jsPromptResult)) == null) {
            c.a.r0.j3.m0.c cVar = this.f28032b;
            if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (fVar = this.f28031a) != null && g.f(fVar)) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
