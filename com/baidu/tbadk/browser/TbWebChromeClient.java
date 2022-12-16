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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.tieba.ch;
import com.baidu.tieba.ct8;
import com.baidu.tieba.gt8;
import com.baidu.tieba.p25;
import com.baidu.tieba.xi;
import com.baidu.tieba.zs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbWebChromeClient extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zs8 callback;
    public TBWebViewActivity mActivity;

    public TbWebChromeClient(TBWebViewActivity tBWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tBWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = tBWebViewActivity;
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

    public void setOnJsPromptCallback(zs8 zs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, zs8Var) == null) {
            this.callback = zs8Var;
        }
    }

    private void callJsMethod(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, this, webView, str, str2) == null) && webView != null && !xi.isEmpty(str) && !xi.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "('" + str2 + "')");
        }
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
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            quotaUpdater.updateQuota(j2 * 2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, jsResult)) == null) {
            TBWebViewActivity tBWebViewActivity = this.mActivity;
            if (tBWebViewActivity != null && ch.f(tBWebViewActivity.getPageContext())) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, webView, str, str2, jsResult)) == null) {
            TBWebViewActivity tBWebViewActivity = this.mActivity;
            if (tBWebViewActivity != null && ch.f(tBWebViewActivity.getPageContext())) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, webView, str, str2, jsResult)) == null) {
            TBWebViewActivity tBWebViewActivity = this.mActivity;
            if (tBWebViewActivity != null && ch.f(tBWebViewActivity.getPageContext())) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        zs8 zs8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!p25.a(str) && str2.startsWith("tiebaapp")) {
                ct8 ct8Var = new ct8();
                ct8Var.v(gt8.b(str2));
                ct8Var.x(301);
                callJsMethod(webView, ct8Var.c(), ct8Var.d());
            }
            if (p25.a(str) && (zs8Var = this.callback) != null && zs8Var.onJsPrompt(str2, jsPromptResult)) {
                return true;
            }
            jsPromptResult.cancel();
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        TBWebViewActivity tBWebViewActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, webView, i) == null) {
            super.onProgressChanged(webView, i);
            if (i >= 80 && (tBWebViewActivity = this.mActivity) != null) {
                tBWebViewActivity.hideProgressBar();
                this.mActivity.stopLoadTimer();
            }
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

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        TBWebViewActivity tBWebViewActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) {
            super.onReceivedTitle(webView, str);
            TBWebViewActivity tBWebViewActivity2 = this.mActivity;
            if (tBWebViewActivity2 != null) {
                tBWebViewActivity2.refreshTitle(str);
            }
            if (Build.VERSION.SDK_INT >= 23 || StringUtils.isNull(str)) {
                return;
            }
            if ((str.contains("404") || str.contains("500") || str.contains(V8ExceptionInfo.V8_EXCEPTION_ERROR)) && (tBWebViewActivity = this.mActivity) != null) {
                tBWebViewActivity.onReceivedTitle();
            }
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
