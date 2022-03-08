package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
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
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.d;
import com.alipay.sdk.util.l;
import com.alipay.sdk.widget.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.alipay.sdk.widget.c implements e.f, e.g, e.h {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "action";
    public static final String B = "pushWindow";
    public static final String C = "h5JsFuncCallback";
    public static final String D = "sdkInfo";
    public static final String E = "canUseTaoLogin";
    public static final String F = "taoLogin";
    public static final String l = "sdk_result_code:";
    public static final String m = "alipayjsbridge://";
    public static final String n = "onBack";
    public static final String o = "setTitle";
    public static final String p = "onRefresh";
    public static final String q = "showBackButton";
    public static final String r = "onExit";
    public static final String s = "onLoadJs";
    public static final String t = "callNativeFunc";
    public static final String u = "back";
    public static final String v = "title";
    public static final String w = "refresh";
    public static final String x = "backButton";
    public static final String y = "refreshButton";
    public static final String z = "exit";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29606e;

    /* renamed from: f  reason: collision with root package name */
    public String f29607f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29608g;

    /* renamed from: h  reason: collision with root package name */
    public final com.alipay.sdk.sys.a f29609h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29610i;

    /* renamed from: j  reason: collision with root package name */
    public com.alipay.sdk.widget.e f29611j;
    public com.alipay.sdk.widget.f k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.alipay.sdk.widget.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f29612b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, com.alipay.sdk.widget.e eVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29612b = dVar;
            this.a = eVar;
        }

        @Override // com.alipay.sdk.widget.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.a();
                this.f29612b.f29608g = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.alipay.sdk.widget.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f29613b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f29614c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, com.alipay.sdk.widget.e eVar, String str) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29614c = dVar;
            this.a = eVar;
            this.f29613b = str;
        }

        @Override // com.alipay.sdk.widget.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f29614c.removeView(this.a);
                this.f29614c.f29611j.a(this.f29613b);
                this.f29614c.f29608g = false;
            }
        }
    }

    /* renamed from: com.alipay.sdk.widget.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1692d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f29615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f29616c;

        /* renamed from: com.alipay.sdk.widget.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RunnableC1692d a;

            public a(RunnableC1692d runnableC1692d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1692d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = runnableC1692d;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.a.f29615b.cancel();
                    com.alipay.sdk.app.statistic.a.b(this.a.f29616c.f29609h, "net", com.alipay.sdk.app.statistic.b.E, "2");
                    com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a());
                    this.a.a.finish();
                }
            }
        }

        public RunnableC1692d(d dVar, Activity activity, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, activity, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29616c = dVar;
            this.a = activity;
            this.f29615b = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.alipay.sdk.widget.b.a(this.a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(this), null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
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

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final f a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29621b;

        public g(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f29621b = str;
        }

        @Override // com.alipay.sdk.app.d.a
        public void a(boolean z, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), jSONObject, str}) == null) {
                try {
                    this.a.a(new JSONObject().put("success", z).put("random", this.f29621b).put("code", jSONObject).put("status", str));
                } catch (JSONException unused) {
                }
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
        this.f29606e = true;
        this.f29607f = "GET";
        this.f29608g = false;
        this.f29611j = null;
        this.k = new com.alipay.sdk.widget.f();
        this.f29609h = aVar;
        g();
    }

    private synchronized boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            synchronized (this) {
                if (this.k.b()) {
                    this.a.finish();
                } else {
                    this.f29608g = true;
                    com.alipay.sdk.widget.e eVar = this.f29611j;
                    this.f29611j = this.k.c();
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation.setDuration(400L);
                    translateAnimation.setFillAfter(false);
                    translateAnimation.setAnimationListener(new b(this, eVar));
                    eVar.setAnimation(translateAnimation);
                    removeView(eVar);
                    addView(this.f29611j);
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
                Activity activity = this.a;
                com.alipay.sdk.widget.e eVar = this.f29611j;
                if (activity != null && eVar != null) {
                    if (this.f29606e) {
                        activity.finish();
                    } else {
                        eVar.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
                    }
                }
            }
        }
    }

    private synchronized boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            synchronized (this) {
                try {
                    com.alipay.sdk.widget.e eVar = new com.alipay.sdk.widget.e(this.a, this.f29609h, new e.C1694e(!a(), !a()));
                    this.f29611j = eVar;
                    eVar.setChromeProxy(this);
                    this.f29611j.setWebClientProxy(this);
                    this.f29611j.setWebEventProxy(this);
                    addView(this.f29611j);
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void h() {
        com.alipay.sdk.widget.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (eVar = this.f29611j) == null) {
            return;
        }
        eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
    }

    private synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            synchronized (this) {
                WebView webView = this.f29611j.getWebView();
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    com.alipay.sdk.widget.f fVar = this.k;
                    if (fVar != null && !fVar.b()) {
                        e();
                    } else {
                        a(false);
                    }
                }
            }
        }
    }

    @Override // com.alipay.sdk.widget.c
    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f29611j.a();
                this.k.a();
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.g
    public synchronized boolean d(com.alipay.sdk.widget.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, eVar, str)) == null) {
            synchronized (this) {
                com.alipay.sdk.sys.a aVar = this.f29609h;
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "h5ld", SystemClock.elapsedRealtime() + "|" + l.g(str));
                if (!TextUtils.isEmpty(str) && !str.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                    h();
                }
            }
            return false;
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
                onInterceptTouchEvent = this.f29608g ? true : super.onInterceptTouchEvent(motionEvent);
            }
            return onInterceptTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.c
    public synchronized boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                Activity activity = this.a;
                if (activity == null) {
                    return true;
                }
                if (a()) {
                    com.alipay.sdk.widget.e eVar = this.f29611j;
                    if (eVar != null && eVar.getWebView() != null) {
                        if (eVar.getWebView().canGoBack()) {
                            if (d()) {
                                com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.f29430f.b());
                                com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a(b2.b(), b2.a(), ""));
                                activity.finish();
                            }
                        } else {
                            com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a());
                            activity.finish();
                        }
                        return true;
                    }
                    activity.finish();
                    return true;
                }
                if (!this.f29608g) {
                    f();
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void a(String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, str2, z2) == null) {
            synchronized (this) {
                this.f29607f = str2;
                this.f29611j.getTitle().setText(str);
                this.f29606e = z2;
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.f
    public synchronized void c(com.alipay.sdk.widget.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, eVar, str) == null) {
            synchronized (this) {
                if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
                    this.f29611j.getTitle().setText(str);
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f29610i : invokeV.booleanValue;
    }

    private synchronized void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z2) == null) {
            synchronized (this) {
                com.alipay.sdk.app.b.a(z2);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<com.alipay.sdk.widget.e> a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29617b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29618c;

        /* renamed from: d  reason: collision with root package name */
        public final JSONObject f29619d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f29620e;

        public f(com.alipay.sdk.widget.e eVar, String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29620e = false;
            this.a = new WeakReference<>(eVar);
            this.f29617b = str;
            this.f29618c = str2;
            this.f29619d = jSONObject;
        }

        public void a(JSONObject jSONObject) {
            com.alipay.sdk.widget.e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || this.f29620e || (eVar = (com.alipay.sdk.widget.e) l.a(this.a)) == null) {
                return;
            }
            this.f29620e = true;
            eVar.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.f29618c), a(jSONObject.toString())));
        }

        public static String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : str.replace("'", "") : (String) invokeL.objValue;
        }
    }

    @Override // com.alipay.sdk.widget.c
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                if ("POST".equals(this.f29607f)) {
                    this.f29611j.a(str, (byte[]) null);
                } else {
                    this.f29611j.a(str);
                }
                com.alipay.sdk.widget.c.a(this.f29611j.getWebView());
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.f
    public synchronized boolean a(com.alipay.sdk.widget.e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, eVar, str, str2, str3, jsPromptResult)) == null) {
            synchronized (this) {
                if (str2.startsWith("<head>") && str2.contains(l)) {
                    this.a.runOnUiThread(new a(this));
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
                com.alipay.sdk.widget.e eVar = this.f29611j;
                try {
                    com.alipay.sdk.widget.e eVar2 = new com.alipay.sdk.widget.e(this.a, this.f29609h, new e.C1694e(!a(), !a()));
                    this.f29611j = eVar2;
                    eVar2.setChromeProxy(this);
                    this.f29611j.setWebClientProxy(this);
                    this.f29611j.setWebEventProxy(this);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f29611j.getTitle().setText(str2);
                    }
                    this.f29608g = true;
                    this.k.a(eVar);
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation.setDuration(400L);
                    translateAnimation.setFillAfter(false);
                    translateAnimation.setAnimationListener(new c(this, eVar, str));
                    this.f29611j.setAnimation(translateAnimation);
                    addView(this.f29611j);
                } catch (Throwable unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.g
    public synchronized boolean a(com.alipay.sdk.widget.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, eVar, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Activity activity = this.a;
                if (activity == null) {
                    return true;
                }
                if (l.a(this.f29609h, str, activity)) {
                    return true;
                }
                if (str.startsWith(m)) {
                    b(str.substring(17));
                } else if (TextUtils.equals(str, com.alipay.sdk.cons.a.o)) {
                    a(false);
                } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    activity.startActivity(intent);
                } else {
                    this.f29611j.a(str);
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.g
    public synchronized boolean a(com.alipay.sdk.widget.e eVar, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048579, this, eVar, i2, str, str2)) == null) {
            synchronized (this) {
                this.f29610i = true;
                com.alipay.sdk.sys.a aVar = this.f29609h;
                com.alipay.sdk.app.statistic.a.b(aVar, "net", com.alipay.sdk.app.statistic.b.C, "onReceivedError:" + str2);
                eVar.getRefreshButton().setVisibility(0);
            }
            return false;
        }
        return invokeLILL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.g
    public synchronized boolean b(com.alipay.sdk.widget.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, eVar, str)) == null) {
            synchronized (this) {
                com.alipay.sdk.sys.a aVar = this.f29609h;
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "h5ldd", SystemClock.elapsedRealtime() + "|" + l.g(str));
                h();
                eVar.getRefreshButton().setVisibility(0);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.alipay.sdk.widget.e.g
    public synchronized boolean a(com.alipay.sdk.widget.e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, eVar, sslErrorHandler, sslError)) == null) {
            synchronized (this) {
                Activity activity = this.a;
                if (activity == null) {
                    return true;
                }
                com.alipay.sdk.sys.a aVar = this.f29609h;
                com.alipay.sdk.app.statistic.a.b(aVar, "net", com.alipay.sdk.app.statistic.b.C, "2-" + sslError);
                activity.runOnUiThread(new RunnableC1692d(this, activity, sslErrorHandler));
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    private synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            synchronized (this) {
                Map<String, String> b2 = l.b(this.f29609h, str);
                if (str.startsWith(t)) {
                    a(b2.get("func"), b2.get("cbId"), b2.get("data"));
                } else if (str.startsWith(n)) {
                    i();
                } else if (str.startsWith("setTitle") && b2.containsKey("title")) {
                    this.f29611j.getTitle().setText(b2.get("title"));
                } else if (str.startsWith(p)) {
                    this.f29611j.getWebView().reload();
                } else if (str.startsWith(q) && b2.containsKey("bshow")) {
                    this.f29611j.getBackButton().setVisibility(TextUtils.equals("true", b2.get("bshow")) ? 0 : 4);
                } else if (str.startsWith(r)) {
                    com.alipay.sdk.app.b.a(b2.get("result"));
                    a(TextUtils.equals("true", b2.get("bsucc")));
                } else if (str.startsWith(s)) {
                    this.f29611j.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
                }
            }
        }
    }

    private synchronized void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, str, str2, str3) == null) {
            synchronized (this) {
                com.alipay.sdk.widget.e eVar = this.f29611j;
                if (eVar == null) {
                    return;
                }
                JSONObject f2 = l.f(str3);
                f fVar = new f(eVar, str, str2, f2);
                Context context = eVar.getContext();
                String str4 = fVar.f29617b;
                char c2 = 65535;
                switch (str4.hashCode()) {
                    case -1785164386:
                        if (str4.equals(E)) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -552487705:
                        if (str4.equals(F)) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 3015911:
                        if (str4.equals(u)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3127582:
                        if (str4.equals("exit")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 110371416:
                        if (str4.equals("title")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1085444827:
                        if (str4.equals("refresh")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1703426986:
                        if (str4.equals(B)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1906413305:
                        if (str4.equals(x)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1947723784:
                        if (str4.equals(D)) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 2033767917:
                        if (str4.equals(y)) {
                            c2 = 5;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (f2.has("title")) {
                            eVar.getTitle().setText(f2.optString("title", ""));
                            break;
                        }
                        break;
                    case 1:
                        eVar.getWebView().reload();
                        break;
                    case 2:
                        i();
                        break;
                    case 3:
                        com.alipay.sdk.app.b.a(f2.optString("result", null));
                        a(f2.optBoolean("success", false));
                        break;
                    case 4:
                        eVar.getBackButton().setVisibility(f2.optBoolean("show", true) ? 0 : 4);
                        break;
                    case 5:
                        eVar.getRefreshButton().setVisibility(f2.optBoolean("show", true) ? 0 : 4);
                        break;
                    case 6:
                        b(f2.optString("url"), f2.optString("title", ""));
                        break;
                    case 7:
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sdk_version", "15.8.02");
                        jSONObject.put("app_name", this.f29609h.b());
                        jSONObject.put("app_version", this.f29609h.c());
                        fVar.a(jSONObject);
                        break;
                    case '\b':
                        String url = eVar.getUrl();
                        if (!l.a(this.f29609h, url)) {
                            com.alipay.sdk.app.statistic.a.b(this.f29609h, "biz", "jsUrlErr", url);
                            break;
                        } else {
                            JSONObject jSONObject2 = new JSONObject();
                            boolean a2 = com.alipay.sdk.app.d.a(this.f29609h, context);
                            jSONObject2.put(SapiOptions.KEY_CACHE_ENABLED, a2);
                            com.alipay.sdk.app.statistic.a.a(this.f29609h, "biz", com.alipay.sdk.app.statistic.b.y0, String.valueOf(a2));
                            fVar.a(jSONObject2);
                            break;
                        }
                    case '\t':
                        String url2 = eVar.getUrl();
                        if (!l.a(this.f29609h, url2)) {
                            com.alipay.sdk.app.statistic.a.b(this.f29609h, "biz", "jsUrlErr", url2);
                            break;
                        } else {
                            String optString = f2.optString("random");
                            JSONObject optJSONObject = f2.optJSONObject("options");
                            if (!TextUtils.isEmpty("random") && optJSONObject != null) {
                                String optString2 = optJSONObject.optString("url");
                                String optString3 = optJSONObject.optString("action");
                                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (context instanceof Activity)) {
                                    com.alipay.sdk.app.d.a(this.f29609h, (Activity) context, 1010, optString2, optString3, new g(fVar, optString));
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.h
    public synchronized void b(com.alipay.sdk.widget.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            synchronized (this) {
                f();
            }
        }
    }

    @Override // com.alipay.sdk.widget.e.h
    public synchronized void a(com.alipay.sdk.widget.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            synchronized (this) {
                eVar.getWebView().reload();
                eVar.getRefreshButton().setVisibility(4);
            }
        }
    }
}
