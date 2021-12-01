package com.baidu.tbadk.browser;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.d.f.p.k;
import c.a.q0.t.c.c0;
import c.a.r0.t3.n0.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TbWebChromeClient extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c callback;
    public TbWebViewActivity mActivity;

    public TbWebChromeClient(TbWebViewActivity tbWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = tbWebViewActivity;
    }

    private void callJsMethod(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, webView, str, str2) == null) || webView == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "('" + str2 + "')");
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.mActivity.getPageContext().getPageActivity());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), quotaUpdater}) == null) {
            super.onExceededDatabaseQuota(str, str2, j2, j3, j4, quotaUpdater);
            quotaUpdater.updateQuota(j3 * 2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, jsResult)) == null) {
            TbWebViewActivity tbWebViewActivity = this.mActivity;
            if (tbWebViewActivity == null || !g.f(tbWebViewActivity.getPageContext())) {
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, webView, str, str2, jsResult)) == null) {
            TbWebViewActivity tbWebViewActivity = this.mActivity;
            if (tbWebViewActivity == null || !g.f(tbWebViewActivity.getPageContext())) {
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, webView, str, str2, jsResult)) == null) {
            TbWebViewActivity tbWebViewActivity = this.mActivity;
            if (tbWebViewActivity == null || !g.f(tbWebViewActivity.getPageContext())) {
                return true;
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!c0.a(str) && str2.startsWith("tiebaapp")) {
                c.a.r0.t3.n0.d.c cVar2 = new c.a.r0.t3.n0.d.c();
                cVar2.v(c.a.r0.t3.n0.d.g.b(str2));
                cVar2.x(301);
                callJsMethod(webView, cVar2.c(), cVar2.d());
            }
            if (c0.a(str) && (cVar = this.callback) != null && cVar.onJsPrompt(str2, jsPromptResult)) {
                return true;
            }
            jsPromptResult.cancel();
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        TbWebViewActivity tbWebViewActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, webView, i2) == null) {
            super.onProgressChanged(webView, i2);
            if (i2 < 80 || (tbWebViewActivity = this.mActivity) == null) {
                return;
            }
            tbWebViewActivity.hideProgressBar();
            this.mActivity.stopLoadTimer();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        TbWebViewActivity tbWebViewActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) {
            super.onReceivedTitle(webView, str);
            TbWebViewActivity tbWebViewActivity2 = this.mActivity;
            if (tbWebViewActivity2 != null) {
                tbWebViewActivity2.refreshTitle(str);
            }
            if (Build.VERSION.SDK_INT >= 23 || StringUtils.isNull(str)) {
                return;
            }
            if ((str.contains("404") || str.contains("500") || str.contains(V8ExceptionInfo.V8_EXCEPTION_ERROR)) && (tbWebViewActivity = this.mActivity) != null) {
                tbWebViewActivity.onReceivedTitle();
            }
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, valueCallback) == null) {
            this.mActivity.setUploadMessage(valueCallback);
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        }
    }

    public void setOnJsPromptCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.callback = cVar;
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, valueCallback, str) == null) {
            this.mActivity.setUploadMessage(valueCallback);
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, valueCallback, str, str2) == null) {
            this.mActivity.setUploadMessage(valueCallback);
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        }
    }
}
