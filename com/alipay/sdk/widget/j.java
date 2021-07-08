package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.widget.WebViewWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends g implements WebViewWindow.a, WebViewWindow.b, WebViewWindow.c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f2032b = "alipayjsbridge://";

    /* renamed from: c  reason: collision with root package name */
    public static final String f2033c = "onBack";

    /* renamed from: d  reason: collision with root package name */
    public static final String f2034d = "setTitle";

    /* renamed from: e  reason: collision with root package name */
    public static final String f2035e = "onRefresh";

    /* renamed from: f  reason: collision with root package name */
    public static final String f2036f = "showBackButton";

    /* renamed from: g  reason: collision with root package name */
    public static final String f2037g = "onExit";

    /* renamed from: h  reason: collision with root package name */
    public static final String f2038h = "onLoadJs";

    /* renamed from: i  reason: collision with root package name */
    public static final String f2039i = "callNativeFunc";
    public static final String j = "back";
    public static final String k = "title";
    public static final String l = "refresh";
    public static final String m = "backButton";
    public static final String n = "refreshButton";
    public static final String o = "exit";
    public static final String p = "action";
    public static final String q = "pushWindow";
    public static final String r = "h5JsFuncCallback";
    public static final String s = "sdk_result_code:";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public String u;
    public boolean v;
    public boolean w;
    public WebViewWindow x;
    public u y;

    /* loaded from: classes.dex */
    public abstract class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j f2040d;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2040d = jVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public /* synthetic */ a(j jVar, k kVar) {
            this(jVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Activity activity) {
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
        this.t = true;
        this.u = "GET";
        this.v = false;
        this.x = null;
        this.y = new u();
        c();
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            try {
                WebViewWindow webViewWindow = new WebViewWindow(this.f2028a);
                this.x = webViewWindow;
                webViewWindow.setChromeProxy(this);
                this.x.setWebClientProxy(this);
                this.x.setWebEventProxy(this);
                addView(this.x);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.t) {
                this.f2028a.finish();
            } else {
                this.x.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            WebView webView = this.x.getWebView();
            if (webView.canGoBack()) {
                webView.goBack();
                return;
            }
            u uVar = this.y;
            if (uVar != null && !uVar.b()) {
                f();
            } else {
                a(false);
            }
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.y.b()) {
                this.f2028a.finish();
            } else {
                this.v = true;
                WebViewWindow webViewWindow = this.x;
                this.x = this.y.a();
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(false);
                translateAnimation.setAnimationListener(new l(this, webViewWindow));
                webViewWindow.setAnimation(translateAnimation);
                removeView(webViewWindow);
                addView(this.x);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            if (this.v) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.v) {
                return true;
            }
            d();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, str2, z) == null) {
            this.u = str2;
            this.x.getTitle().setText(str);
            this.t = z;
        }
    }

    private boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, str2)) == null) {
            WebViewWindow webViewWindow = this.x;
            try {
                WebViewWindow webViewWindow2 = new WebViewWindow(this.f2028a);
                this.x = webViewWindow2;
                webViewWindow2.setChromeProxy(this);
                this.x.setWebClientProxy(this);
                this.x.setWebEventProxy(this);
                if (!TextUtils.isEmpty(str2)) {
                    this.x.getTitle().setText(str2);
                }
                this.v = true;
                this.y.a(webViewWindow);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(false);
                translateAnimation.setAnimationListener(new m(this, webViewWindow, str));
                this.x.setAnimation(translateAnimation);
                addView(this.x);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            com.alipay.sdk.app.j.a(z);
            this.f2028a.finish();
        }
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean c(WebViewWindow webViewWindow, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webViewWindow, str)) == null) {
            webViewWindow.a("javascript:window.prompt('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
            webViewWindow.getRefreshButton().setVisibility(0);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if ("POST".equals(this.u)) {
                this.x.a(str, (byte[]) null);
            } else {
                this.x.a(str);
            }
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.x.a();
            this.y.c();
        }
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.a
    public boolean a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048583, this, webViewWindow, str, str2, str3, jsPromptResult)) == null) {
            if (str2.startsWith("<head>") && str2.contains(s)) {
                this.f2028a.runOnUiThread(new k(this));
            }
            jsPromptResult.cancel();
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.a
    public void a(WebViewWindow webViewWindow, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webViewWindow, str) == null) || str.startsWith("http") || webViewWindow.getUrl().endsWith(str)) {
            return;
        }
        this.x.getTitle().setText(str);
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean b(WebViewWindow webViewWindow, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webViewWindow, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.startsWith(f2032b)) {
                b(str.substring(17));
                return true;
            } else if (TextUtils.equals(str, com.alipay.sdk.cons.a.m)) {
                a(false);
                return true;
            } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    this.f2028a.startActivity(intent);
                    return true;
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a("biz", th);
                    return true;
                }
            } else {
                this.x.a(str);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean a(WebViewWindow webViewWindow, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048581, this, webViewWindow, i2, str, str2)) == null) {
            com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.r, "onReceivedError:" + str2);
            webViewWindow.getRefreshButton().setVisibility(0);
            return false;
        }
        return invokeLILL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean a(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webViewWindow, sslErrorHandler, sslError)) == null) {
            com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.r, "2-" + sslError);
            if (this.w) {
                sslErrorHandler.proceed();
                this.w = false;
                return true;
            }
            this.f2028a.runOnUiThread(new n(this, sslErrorHandler));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    private void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, str, str2, str3) == null) {
            JSONObject d2 = com.alipay.sdk.util.n.d(str3);
            if ("title".equals(str) && d2.has("title")) {
                this.x.getTitle().setText(d2.optString("title", ""));
            } else if ("refresh".equals(str)) {
                this.x.getWebView().reload();
            } else if (j.equals(str)) {
                e();
            } else {
                if ("exit".equals(str)) {
                    com.alipay.sdk.app.j.a(d2.optString("result", null));
                    a(d2.optBoolean("success", false));
                } else if (m.equals(str)) {
                    this.x.getBackButton().setVisibility(d2.optBoolean("show", true) ? 0 : 4);
                } else if (n.equals(str)) {
                    this.x.getRefreshButton().setVisibility(d2.optBoolean("show", true) ? 0 : 4);
                } else if (!q.equals(str) || d2.optString("url", null) == null) {
                } else {
                    b(d2.optString("url"), d2.optString("title", ""));
                }
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) {
            Map<String, String> c2 = com.alipay.sdk.util.n.c(str);
            if (str.startsWith(f2039i)) {
                a(c2.get(WebChromeClient.KEY_FUNCTION_NAME), c2.get("cbId"), c2.get("data"));
            } else if (str.startsWith(f2033c)) {
                e();
            } else if (str.startsWith("setTitle") && c2.containsKey("title")) {
                this.x.getTitle().setText(c2.get("title"));
            } else if (str.startsWith(f2035e)) {
                this.x.getWebView().reload();
            } else if (str.startsWith(f2036f) && c2.containsKey("bshow")) {
                this.x.getBackButton().setVisibility(TextUtils.equals("true", c2.get("bshow")) ? 0 : 4);
            } else if (str.startsWith(f2037g)) {
                com.alipay.sdk.app.j.a(c2.get("result"));
                a(TextUtils.equals("true", c2.get("bsucc")));
            } else if (str.startsWith(f2038h)) {
                this.x.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
            }
        }
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.c
    public void a(WebViewWindow webViewWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webViewWindow) == null) {
            d();
        }
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.c
    public void b(WebViewWindow webViewWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webViewWindow) == null) {
            webViewWindow.getWebView().reload();
            webViewWindow.getRefreshButton().setVisibility(4);
        }
    }
}
