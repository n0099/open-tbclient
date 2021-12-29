package c.a.t0.r2;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import c.a.d.f.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.payment.PayVcodeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayVcodeActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.w3.n0.c f22461b;

    public b(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = payVcodeActivity;
    }

    public void a(c.a.t0.w3.n0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f22461b = cVar;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        PayVcodeActivity payVcodeActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            c.a.t0.w3.n0.c cVar = this.f22461b;
            if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (payVcodeActivity = this.a) != null && g.f(payVcodeActivity.getPageContext())) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
