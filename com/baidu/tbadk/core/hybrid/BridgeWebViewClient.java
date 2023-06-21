package com.baidu.tbadk.core.hybrid;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.an9;
import com.baidu.tieba.by4;
import com.baidu.tieba.m85;
import com.baidu.tieba.tm6;
import com.baidu.tieba.ym9;
import com.baidu.tieba.zm9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import okio.BufferedSource;
import okio.Okio;
/* loaded from: classes4.dex */
public class BridgeWebViewClient extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebViewClient a;
    public WebViewBridge b;
    public final HashSet<String> c;
    public final boolean d;

    public BridgeWebViewClient(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = new HashSet<>(6);
        this.d = z;
    }

    public static WebResourceResponse a(String str, Map<String, String> map, InputStream inputStream, long j) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, map, inputStream, Long.valueOf(j)})) == null) {
            String b = tm6.b(str);
            HashMap<String, String> hashMap = new HashMap<String, String>() { // from class: com.baidu.tbadk.core.hybrid.BridgeWebViewClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    put("access-control-allow-origin", "*");
                    put(Headers.CACHE_CONTROL, "no-cache");
                }
            };
            if (map != null && !TextUtils.isEmpty(map.get("Range"))) {
                i = 206;
                hashMap.put(Util.ACCEPT_RANGES, "bytes");
                hashMap.put("Content-Length", j + "");
                hashMap.put("Content-Range", "bytes 0-" + (j - 1) + "/" + j);
            } else {
                i = 200;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(b, "UTF-8", inputStream);
            webResourceResponse.setStatusCodeAndReasonPhrase(i, "OK");
            webResourceResponse.setResponseHeaders(hashMap);
            return webResourceResponse;
        }
        return (WebResourceResponse) invokeCommon.objValue;
    }

    public void b(WebViewBridge webViewBridge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, webViewBridge) == null) {
            this.b = webViewBridge;
        }
    }

    public void c(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webViewClient) == null) {
            this.a = webViewClient;
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, webView, str, z) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, message, message2) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, str, bitmap) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, webView, sslErrorHandler, sslError) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, webView, message, message2) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webView, renderProcessGoneDetail)) == null) {
            by4.a("BridgeWebViewClient", webView);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, webView, keyEvent) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, keyEvent)) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webView, str) == null) {
            m85.a("page " + str + " load finished.");
            if (!this.c.contains(str)) {
                this.b.p(str);
            }
            this.c.clear();
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, webView, i, str, str2) == null) {
            m85.a("Failed url " + str2 + " with description:" + str);
            this.c.add(str2);
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, httpAuthHandler, str, str2) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, webView, str, str2, str3) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{webView, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, webView, webResourceRequest)) == null) {
            if (!this.d) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            } else if (webResourceRequest != null && webResourceRequest.getUrl() != null && QuickWebViewSwitch.getInOn()) {
                String uri = webResourceRequest.getUrl().toString();
                if (ym9.s(uri)) {
                    WebViewClient webViewClient2 = this.a;
                    if (webViewClient2 != null) {
                        return webViewClient2.shouldInterceptRequest(webView, webResourceRequest);
                    }
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                try {
                    String path = new URL(uri).getPath();
                    an9 c = zm9.a().c(path);
                    if (c == null) {
                        if (this.a != null) {
                            return this.a.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    } else if (!c.e) {
                        if (this.a != null) {
                            return this.a.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    } else if (!c.f) {
                        if (this.a != null) {
                            return this.a.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    } else {
                        String str = (ym9.n().m() + "/" + c.b + "/" + ym9.n().p(c.b) + "/") + zm9.a().e(path);
                        File file = new File(str);
                        try {
                            BufferedSource buffer = Okio.buffer(Okio.source(file));
                            if (str.contains(".js")) {
                                return new WebResourceResponse("text/javascript", "UTF-8", buffer.inputStream());
                            }
                            if (str.contains(FileHelper.FILE_CACHE_CSS)) {
                                return new WebResourceResponse("text/css", "UTF-8", buffer.inputStream());
                            }
                            if (str.contains(".html")) {
                                return new WebResourceResponse(SapiWebView.DATA_MIME_TYPE, "UTF-8", buffer.inputStream());
                            }
                            return a(uri, webResourceRequest.getRequestHeaders(), buffer.inputStream(), file.length());
                        } catch (IOException e) {
                            e.printStackTrace();
                            WebViewClient webViewClient3 = this.a;
                            if (webViewClient3 != null) {
                                return webViewClient3.shouldInterceptRequest(webView, webResourceRequest);
                            }
                            return super.shouldInterceptRequest(webView, webResourceRequest);
                        }
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
            } else {
                WebViewClient webViewClient4 = this.a;
                if (webViewClient4 != null) {
                    return webViewClient4.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        } else {
            return (WebResourceResponse) invokeLL.objValue;
        }
    }
}
