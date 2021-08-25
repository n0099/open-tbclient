package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.k;
import com.alipay.sdk.widget.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends c implements e.b, e.c, e.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f36017d = "alipayjsbridge://";

    /* renamed from: e  reason: collision with root package name */
    public static final String f36018e = "onBack";

    /* renamed from: f  reason: collision with root package name */
    public static final String f36019f = "setTitle";

    /* renamed from: g  reason: collision with root package name */
    public static final String f36020g = "onRefresh";

    /* renamed from: h  reason: collision with root package name */
    public static final String f36021h = "showBackButton";

    /* renamed from: i  reason: collision with root package name */
    public static final String f36022i = "onExit";

    /* renamed from: j  reason: collision with root package name */
    public static final String f36023j = "onLoadJs";
    public static final String k = "callNativeFunc";
    public static final String l = "back";
    public static final String m = "title";
    public static final String n = "refresh";
    public static final String o = "backButton";
    public static final String p = "refreshButton";
    public static final String q = "exit";
    public static final String r = "action";
    public static final String s = "pushWindow";
    public static final String t = "h5JsFuncCallback";
    public static final String u = "sdkInfo";
    public static final String v = "sdk_result_code:";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public e B;
    public f C;
    public boolean w;
    public String x;
    public boolean y;
    public final com.alipay.sdk.sys.a z;

    /* loaded from: classes4.dex */
    public abstract class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f36034d;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36034d = dVar;
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Activity activity, com.alipay.sdk.sys.a aVar, String str) {
        super(activity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = true;
        this.x = "GET";
        this.y = false;
        this.B = null;
        this.C = new f();
        this.z = aVar;
        e();
    }

    private synchronized boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            synchronized (this) {
                try {
                    e eVar = new e(this.f36015a, this.z, new e.a(!c(), !c()));
                    this.B = eVar;
                    eVar.setChromeProxy(this);
                    this.B.setWebClientProxy(this);
                    this.B.setWebEventProxy(this);
                    addView(this.B);
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            synchronized (this) {
                Activity activity = this.f36015a;
                e eVar = this.B;
                if (activity != null && eVar != null) {
                    if (this.w) {
                        activity.finish();
                    } else {
                        eVar.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
                    }
                }
            }
        }
    }

    private synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            synchronized (this) {
                WebView webView = this.B.getWebView();
                if (webView.canGoBack()) {
                    webView.goBack();
                } else if (this.C != null && !this.C.b()) {
                    h();
                } else {
                    a(false);
                }
            }
        }
    }

    private synchronized boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            synchronized (this) {
                if (this.C.b()) {
                    this.f36015a.finish();
                } else {
                    this.y = true;
                    e eVar = this.B;
                    this.B = this.C.a();
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation.setDuration(400L);
                    translateAnimation.setFillAfter(false);
                    translateAnimation.setAnimationListener(new a(this, eVar) { // from class: com.alipay.sdk.widget.d.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ e f36025a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f36026b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super();
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, eVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super();
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f36026b = this;
                            this.f36025a = eVar;
                        }

                        @Override // com.alipay.sdk.widget.d.a, android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                                this.f36025a.a();
                                this.f36026b.y = false;
                            }
                        }
                    });
                    eVar.setAnimation(translateAnimation);
                    removeView(eVar);
                    addView(this.B);
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.c
    public synchronized boolean c(e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, eVar, str)) == null) {
            synchronized (this) {
                com.alipay.sdk.sys.a aVar = this.z;
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "h5ld", SystemClock.elapsedRealtime() + "|" + k.e(str));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.c
    public synchronized boolean d(e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, eVar, str)) == null) {
            synchronized (this) {
                com.alipay.sdk.sys.a aVar = this.z;
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "h5ldd", SystemClock.elapsedRealtime() + "|" + k.e(str));
                eVar.a("javascript:window.prompt('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
                eVar.getRefreshButton().setVisibility(0);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean onInterceptTouchEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            synchronized (this) {
                onInterceptTouchEvent = this.y ? true : super.onInterceptTouchEvent(motionEvent);
            }
            return onInterceptTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.c
    public synchronized boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                Activity activity = this.f36015a;
                if (activity == null) {
                    return true;
                }
                if (c()) {
                    e eVar = this.B;
                    if (eVar != null && eVar.getWebView() != null) {
                        if (eVar.getWebView().canGoBack()) {
                            if (d()) {
                                com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.f35791d.a());
                                com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a(b2.a(), b2.b(), ""));
                                activity.finish();
                            }
                        } else {
                            com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.c());
                            activity.finish();
                        }
                        return true;
                    }
                    activity.finish();
                    return true;
                }
                if (!this.y) {
                    f();
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, str2, z) == null) {
            synchronized (this) {
                this.x = str2;
                this.B.getTitle().setText(str);
                this.w = z;
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.A : invokeV.booleanValue;
    }

    private synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            synchronized (this) {
                com.alipay.sdk.app.b.a(z);
                this.f36015a.finish();
            }
        }
    }

    @Override // com.alipay.sdk.widget.c
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                if ("POST".equals(this.x)) {
                    this.B.a(str, (byte[]) null);
                } else {
                    this.B.a(str);
                }
                c.a(this.B.getWebView());
            }
        }
    }

    @Override // com.alipay.sdk.widget.c
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.B.a();
                this.C.c();
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.b
    public synchronized boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048583, this, eVar, str, str2, str3, jsPromptResult)) == null) {
            synchronized (this) {
                if (str2.startsWith("<head>") && str2.contains(v)) {
                    this.f36015a.runOnUiThread(new Runnable(this) { // from class: com.alipay.sdk.widget.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ d f36024a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f36024a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f36024a.f36015a.finish();
                            }
                        }
                    });
                }
                jsPromptResult.cancel();
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    private synchronized boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, str2)) == null) {
            synchronized (this) {
                e eVar = this.B;
                try {
                    e eVar2 = new e(this.f36015a, this.z, new e.a(!c(), !c()));
                    this.B = eVar2;
                    eVar2.setChromeProxy(this);
                    this.B.setWebClientProxy(this);
                    this.B.setWebEventProxy(this);
                    if (!TextUtils.isEmpty(str2)) {
                        this.B.getTitle().setText(str2);
                    }
                    this.y = true;
                    this.C.a(eVar);
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation.setDuration(400L);
                    translateAnimation.setFillAfter(false);
                    translateAnimation.setAnimationListener(new a(this, eVar, str) { // from class: com.alipay.sdk.widget.d.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ e f36027a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f36028b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f36029c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super();
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, eVar, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super();
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f36029c = this;
                            this.f36027a = eVar;
                            this.f36028b = str;
                        }

                        @Override // com.alipay.sdk.widget.d.a, android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                                this.f36029c.removeView(this.f36027a);
                                this.f36029c.B.a(this.f36028b);
                                this.f36029c.y = false;
                            }
                        }
                    });
                    this.B.setAnimation(translateAnimation);
                    addView(this.B);
                } catch (Throwable unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.b
    public synchronized void a(e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str) == null) {
            synchronized (this) {
                if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
                    this.B.getTitle().setText(str);
                }
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.c
    public synchronized boolean a(e eVar, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048581, this, eVar, i2, str, str2)) == null) {
            synchronized (this) {
                this.A = true;
                com.alipay.sdk.sys.a aVar = this.z;
                com.alipay.sdk.app.statistic.a.a(aVar, "net", com.alipay.sdk.app.statistic.b.s, "onReceivedError:" + str2);
                eVar.getRefreshButton().setVisibility(0);
            }
            return false;
        }
        return invokeLILL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.c
    public synchronized boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, eVar, sslErrorHandler, sslError)) == null) {
            synchronized (this) {
                Activity activity = this.f36015a;
                if (activity == null) {
                    return true;
                }
                com.alipay.sdk.sys.a aVar = this.z;
                com.alipay.sdk.app.statistic.a.a(aVar, "net", com.alipay.sdk.app.statistic.b.s, "2-" + sslError);
                activity.runOnUiThread(new Runnable(this, activity, sslErrorHandler) { // from class: com.alipay.sdk.widget.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Activity f36030a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ SslErrorHandler f36031b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f36032c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, sslErrorHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36032c = this;
                        this.f36030a = activity;
                        this.f36031b = sslErrorHandler;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b.a(this.f36030a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new DialogInterface.OnClickListener(this) { // from class: com.alipay.sdk.widget.d.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f36033a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f36033a = this;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                        this.f36033a.f36031b.cancel();
                                        com.alipay.sdk.app.statistic.a.a(this.f36033a.f36032c.z, "net", com.alipay.sdk.app.statistic.b.u, "2");
                                        com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.c());
                                        this.f36033a.f36030a.finish();
                                    }
                                }
                            }, null, null);
                        }
                    }
                });
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    private synchronized void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, str, str2, str3) == null) {
            synchronized (this) {
                e eVar = this.B;
                if (eVar == null) {
                    return;
                }
                JSONObject c2 = k.c(str3);
                if ("title".equals(str) && c2.has("title")) {
                    eVar.getTitle().setText(c2.optString("title", ""));
                } else if ("refresh".equals(str)) {
                    eVar.getWebView().reload();
                } else if (l.equals(str)) {
                    g();
                } else {
                    int i2 = 0;
                    if ("exit".equals(str)) {
                        com.alipay.sdk.app.b.a(c2.optString("result", null));
                        a(c2.optBoolean("success", false));
                    } else if (o.equals(str)) {
                        boolean optBoolean = c2.optBoolean("show", true);
                        ImageView backButton = eVar.getBackButton();
                        if (!optBoolean) {
                            i2 = 4;
                        }
                        backButton.setVisibility(i2);
                    } else if (p.equals(str)) {
                        boolean optBoolean2 = c2.optBoolean("show", true);
                        ImageView refreshButton = eVar.getRefreshButton();
                        if (!optBoolean2) {
                            i2 = 4;
                        }
                        refreshButton.setVisibility(i2);
                    } else if (s.equals(str) && c2.optString("url", null) != null) {
                        b(c2.optString("url"), c2.optString("title", ""));
                    } else if (u.equals(str)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "15.7.7");
                        jSONObject.put("app_name", this.z.b());
                        jSONObject.put("app_version", this.z.c());
                        eVar.a(String.format("window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", str2, jSONObject.toString().replace("'", "")));
                    }
                }
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.c
    public synchronized boolean b(e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, eVar, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Activity activity = this.f36015a;
                if (activity == null) {
                    return true;
                }
                if (k.a(this.z, str, activity)) {
                    return true;
                }
                if (str.startsWith(f36017d)) {
                    b(str.substring(17));
                } else if (TextUtils.equals(str, com.alipay.sdk.cons.a.o)) {
                    a(false);
                } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    activity.startActivity(intent);
                } else {
                    this.B.a(str);
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    private synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            synchronized (this) {
                Map<String, String> a2 = k.a(this.z, str);
                if (str.startsWith(k)) {
                    a(a2.get(WebChromeClient.KEY_FUNCTION_NAME), a2.get("cbId"), a2.get("data"));
                } else if (str.startsWith(f36018e)) {
                    g();
                } else if (str.startsWith("setTitle") && a2.containsKey("title")) {
                    this.B.getTitle().setText(a2.get("title"));
                } else if (str.startsWith(f36020g)) {
                    this.B.getWebView().reload();
                } else if (str.startsWith(f36021h) && a2.containsKey("bshow")) {
                    this.B.getBackButton().setVisibility(TextUtils.equals("true", a2.get("bshow")) ? 0 : 4);
                } else if (str.startsWith(f36022i)) {
                    com.alipay.sdk.app.b.a(a2.get("result"));
                    a(TextUtils.equals("true", a2.get("bsucc")));
                } else if (str.startsWith(f36023j)) {
                    this.B.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
                }
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.d
    public synchronized void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            synchronized (this) {
                f();
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.d
    public synchronized void b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            synchronized (this) {
                eVar.getWebView().reload();
                eVar.getRefreshButton().setVisibility(4);
            }
        }
    }
}
