package com.baidu.ar.arplay.d;

import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.d.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b gf;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup gg;
    public View.OnTouchListener gh;
    public View.OnTouchListener gi;
    public String gj;
    public List<com.baidu.ar.arplay.d.a> gk;
    public ViewGroup gl;
    public WebView gm;
    public Handler gn;
    public WebViewClient go;
    public WebChromeClient gp;
    public Context mContext;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int dY;
        public final /* synthetic */ b gq;
        public String gt;
        public String gu;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.gq = bVar;
            this.gt = "android";
            this.dY = 0;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1109054402, "Lcom/baidu/ar/arplay/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1109054402, "Lcom/baidu/ar/arplay/d/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.gk = new ArrayList();
        this.gn = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.ar.arplay.d.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b gq;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.gq = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.ar.arplay.d.a n;
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    Object obj = message.obj;
                    a.C0071a c0071a = obj instanceof a.C0071a ? (a.C0071a) obj : null;
                    switch (message.what) {
                        case 103:
                            this.gq.a(c0071a);
                            return;
                        case 104:
                            if (c0071a == null || (n = this.gq.n(c0071a.dM)) == null || (str = c0071a.ge) == null) {
                                return;
                            }
                            n.evaluateJavascript(str, new ValueCallback<String>(this, n) { // from class: com.baidu.ar.arplay.d.b.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ com.baidu.ar.arplay.d.a gr;
                                public final /* synthetic */ AnonymousClass1 gs;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr = {this, n};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i4 = newInitContext2.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.gs = this;
                                    this.gr = n;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // android.webkit.ValueCallback
                                /* renamed from: K */
                                public void onReceiveValue(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                        this.gr.invalidate();
                                        this.gr.setIsNeedRender(true);
                                        this.gs.gq.m(((Integer) this.gr.getTag()).intValue());
                                    }
                                }
                            });
                            return;
                        case 105:
                            com.baidu.ar.arplay.d.a n2 = this.gq.n(message.arg1);
                            if (n2 != null) {
                                n2.setIsNeedRender(true);
                                n2.invalidate();
                                return;
                            }
                            return;
                        case 106:
                            this.gq.b(c0071a);
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.go = new WebViewClient(this) { // from class: com.baidu.ar.arplay.d.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b gq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.gq = this;
            }

            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(WebView webView, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                    super.onPageCommitVisible(webView, str);
                    int intValue = ((Integer) webView.getTag()).intValue();
                    this.gq.l(intValue);
                    this.gq.o(intValue);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, webResourceError) == null) {
                    if (webResourceError != null) {
                        a aVar = new a(this.gq);
                        aVar.dY = webResourceError.getErrorCode();
                        if (webResourceError.getDescription() != null) {
                            aVar.gu = webResourceError.getDescription().toString();
                        }
                        this.gq.a(((Integer) webView.getTag()).intValue(), aVar);
                    }
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceResponse) == null) {
                    if (webResourceResponse != null) {
                        a aVar = new a(this.gq);
                        aVar.dY = webResourceResponse.getStatusCode();
                        aVar.gu = webResourceResponse.getReasonPhrase();
                        this.gq.a(((Integer) webView.getTag()).intValue(), aVar);
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                    if (sslError != null) {
                        a aVar = new a(this.gq);
                        aVar.dY = sslError.getPrimaryError();
                        aVar.gu = "ssl error!";
                        this.gq.a(((Integer) webView.getTag()).intValue(), aVar);
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
            }
        };
        this.gp = new WebChromeClient(this) { // from class: com.baidu.ar.arplay.d.b.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b gq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.gq = this;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i4) == null) {
                    super.onProgressChanged(webView, i4);
                    if (i4 == 100) {
                        this.gq.o(((com.baidu.ar.arplay.d.a) webView).getWebViewData().dM);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, aVar) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "webView_operation_load_failed");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("texture_id", Integer.valueOf(i2));
            HashMap hashMap3 = new HashMap();
            hashMap3.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, aVar.gt);
            hashMap3.put("error_code", Integer.valueOf(aVar.dY));
            hashMap3.put("error_msg", aVar.gu);
            hashMap2.put("data", hashMap3);
            hashMap.put("event_data", hashMap2);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
            o(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0071a c0071a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, c0071a) == null) && c0071a != null && isValid()) {
            com.baidu.ar.arplay.d.a e2 = e(c0071a.width, c0071a.height);
            e2.setWebViewData(c0071a);
            d.bp().b(c0071a.dM, c0071a.width, c0071a.height);
            e2.setTag(Integer.valueOf(c0071a.dM));
            String str = c0071a.url;
            if (!c0071a.gd) {
                str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
            }
            e2.loadUrl(str);
            e2.invalidate();
            e2.setIsNeedRender(true);
            e(c0071a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0071a c0071a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, c0071a) == null) && c0071a != null && bn()) {
            if (this.gm == null) {
                WebView webView = new WebView(this.mContext);
                this.gm = webView;
                webView.setBackgroundColor(17170445);
                WebSettings settings = this.gm.getSettings();
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(true);
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                settings.setJavaScriptEnabled(true);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                this.gm.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.ar.arplay.d.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b gq;

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
                        this.gq = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            if (this.gq.gi != null) {
                                return this.gq.gi.onTouch(view, motionEvent);
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                this.gl.addView(this.gm, layoutParams);
            }
            String str = c0071a.url;
            if (!c0071a.gd) {
                str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
            }
            this.gm.loadUrl(str);
            this.gm.invalidate();
        }
    }

    public static b bm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (gf == null) {
                synchronized (b.class) {
                    if (gf == null) {
                        gf = new b();
                    }
                }
            }
            return gf;
        }
        return (b) invokeV.objValue;
    }

    private boolean bn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (this.mContext == null || this.gl == null) {
                Log.e("GLWebView", "Native WebView context or root is null!");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private com.baidu.ar.arplay.d.a e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65555, this, i2, i3)) == null) {
            com.baidu.ar.arplay.d.a aVar = new com.baidu.ar.arplay.d.a(this.mContext);
            ViewGroup viewGroup = this.gg;
            ViewGroup.LayoutParams layoutParams = viewGroup instanceof FrameLayout ? new FrameLayout.LayoutParams(i2, i3) : viewGroup instanceof LinearLayout ? new LinearLayout.LayoutParams(i2, i3) : viewGroup instanceof RelativeLayout ? new RelativeLayout.LayoutParams(i2, i3) : null;
            aVar.setBackgroundColor(17170445);
            aVar.setWebViewClient(this.go);
            aVar.setWebChromeClient(this.gp);
            aVar.setHorizontalScrollBarEnabled(false);
            aVar.setVerticalScrollBarEnabled(false);
            WebSettings settings = aVar.getSettings();
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.addJavascriptInterface(new Object(this, aVar) { // from class: com.baidu.ar.arplay.d.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b gq;
                    public final /* synthetic */ com.baidu.ar.arplay.d.a gr;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.gq = this;
                        this.gr = aVar;
                    }

                    @JavascriptInterface
                    public void updateFinish(String str) {
                        com.baidu.ar.arplay.d.a aVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || (aVar2 = this.gr) == null) {
                            return;
                        }
                        this.gq.o(((Integer) aVar2.getTag()).intValue());
                    }
                }, "NativeCallback");
            }
            aVar.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.ar.arplay.d.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b gq;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.gq = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (this.gq.gh != null) {
                            return this.gq.gh.onTouch(view, motionEvent);
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.gg.addView(aVar, layoutParams);
            this.gk.add(aVar);
            return aVar;
        }
        return (com.baidu.ar.arplay.d.a) invokeII.objValue;
    }

    private boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            if (this.mContext == null || this.gg == null) {
                Log.e("GLWebView", "GLWebView context or root is null!");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i2) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "webView_operation_load_finish");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("texture_id", Integer.valueOf(i2));
            hashMap.put("event_data", hashMap2);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i2) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "webView_operation_update_finish");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("texture_id", Integer.valueOf(i2));
            hashMap.put("event_data", hashMap2);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.ar.arplay.d.a n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65559, this, i2)) == null) {
            for (com.baidu.ar.arplay.d.a aVar : this.gk) {
                if (aVar != null && aVar.getWebViewData() != null && aVar.getWebViewData().dM == i2) {
                    return aVar;
                }
            }
            return null;
        }
        return (com.baidu.ar.arplay.d.a) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65560, this, i2) == null) {
            Message obtainMessage = this.gn.obtainMessage();
            obtainMessage.what = 105;
            obtainMessage.arg1 = i2;
            this.gn.sendMessage(obtainMessage);
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.gj = str;
        }
    }

    public void a(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup, onTouchListener) == null) {
            this.mContext = context;
            this.gg = viewGroup;
            this.gh = onTouchListener;
            ARPEngine.getInstance().setHtmlUpdateCallback(new ARPDataInteraction.a(this) { // from class: com.baidu.ar.arplay.d.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b gq;

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
                    this.gq = this;
                }

                @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.a
                public boolean c(int i2, int i3) {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) {
                        this.gq.o(i2);
                        return true;
                    }
                    return invokeII.booleanValue;
                }
            });
        }
    }

    public void b(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, viewGroup, onTouchListener) == null) {
            this.mContext = context;
            this.gl = viewGroup;
            this.gi = onTouchListener;
        }
    }

    public void c(a.C0071a c0071a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c0071a) == null) {
            Message obtainMessage = this.gn.obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.obj = c0071a;
            this.gn.sendMessage(obtainMessage);
        }
    }

    public void d(a.C0071a c0071a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0071a) == null) {
            Message obtainMessage = this.gn.obtainMessage();
            obtainMessage.what = 106;
            obtainMessage.obj = c0071a;
            this.gn.sendMessage(obtainMessage);
        }
    }

    public void e(a.C0071a c0071a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c0071a) == null) {
            Message obtainMessage = this.gn.obtainMessage();
            obtainMessage.what = 104;
            obtainMessage.obj = c0071a;
            com.baidu.ar.arplay.d.a n = n(c0071a.dM);
            if (n != null) {
                n.setWebViewData(c0071a);
                this.gn.sendMessage(obtainMessage);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mContext = null;
            d.bp().release();
            ARPEngine.getInstance().setHtmlUpdateCallback(null);
            Handler handler = this.gn;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                runOnUiThread(new Runnable(this) { // from class: com.baidu.ar.arplay.d.b.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b gq;

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
                        this.gq = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.baidu.ar.arplay.c.b.b(b.class.getName(), "remove webviewList in ui thread");
                            if (this.gq.gk != null) {
                                for (com.baidu.ar.arplay.d.a aVar : this.gq.gk) {
                                    if (aVar != null) {
                                        if (aVar.getParent() == this.gq.gg) {
                                            this.gq.gg.removeView(aVar);
                                        }
                                        aVar.destroy();
                                    }
                                }
                                this.gq.gk.clear();
                                this.gq.gk = null;
                            }
                        }
                    }
                });
                this.gn = null;
            }
            gf = null;
            this.gm = null;
            this.gi = null;
        }
    }

    public void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, runnable) == null) || runnable == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.gn.post(runnable);
        }
    }
}
