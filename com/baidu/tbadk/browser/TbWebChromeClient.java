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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gx4;
import com.repackage.ni;
import com.repackage.rg;
import com.repackage.sl8;
import com.repackage.vl8;
import com.repackage.zl8;
/* loaded from: classes2.dex */
public class TbWebChromeClient extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sl8 callback;
    public TbWebViewActivity mActivity;

    public TbWebChromeClient(TbWebViewActivity tbWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = tbWebViewActivity;
    }

    private void callJsMethod(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, webView, str, str2) == null) || webView == null || ni.isEmpty(str) || ni.isEmpty(str2)) {
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
            TbWebViewActivity tbWebViewActivity = this.mActivity;
            if (tbWebViewActivity == null || !rg.f(tbWebViewActivity.getPageContext())) {
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
            if (tbWebViewActivity == null || !rg.f(tbWebViewActivity.getPageContext())) {
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
            if (tbWebViewActivity == null || !rg.f(tbWebViewActivity.getPageContext())) {
                return true;
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        sl8 sl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!gx4.a(str) && str2.startsWith("tiebaapp")) {
                vl8 vl8Var = new vl8();
                vl8Var.v(zl8.b(str2));
                vl8Var.x(301);
                callJsMethod(webView, vl8Var.c(), vl8Var.d());
            }
            if (gx4.a(str) && (sl8Var = this.callback) != null && sl8Var.onJsPrompt(str2, jsPromptResult)) {
                return true;
            }
            jsPromptResult.cancel();
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        TbWebViewActivity tbWebViewActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, webView, i) == null) {
            super.onProgressChanged(webView, i);
            if (i < 80 || (tbWebViewActivity = this.mActivity) == null) {
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

    public void setOnJsPromptCallback(sl8 sl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sl8Var) == null) {
            this.callback = sl8Var;
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
