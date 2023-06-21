package com.baidu.tbadk.core.hybrid;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tieba.am6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.k85;
import com.baidu.tieba.l85;
import com.baidu.tieba.m85;
import com.baidu.tieba.o85;
import com.baidu.tieba.p85;
import com.baidu.tieba.r85;
import com.baidu.tieba.s85;
import com.baidu.tieba.t85;
import com.baidu.tieba.v85;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WebViewBridge extends s85 implements p85 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public BridgeWebViewClient c;
    public l85 d;
    public c e;
    public HashMap<String, o85> f;
    public HashMap<String, t85> g;
    public String h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public static final class NullHandler implements o85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final s85 bridge;
        public final String cmd;

        public NullHandler(s85 s85Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s85Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bridge = s85Var;
            this.cmd = str;
        }

        public /* synthetic */ NullHandler(s85 s85Var, String str, a aVar) {
            this(s85Var, str);
        }

        @Override // com.baidu.tieba.o85
        public void handle(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    m85.a("scope " + this.cmd + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "107");
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "cmd " + this.cmd + " not found");
                this.bridge.c(t85.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements r85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ WebViewBridge b;

        public a(WebViewBridge webViewBridge, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewBridge, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = webViewBridge;
            this.a = i;
        }

        @Override // com.baidu.tieba.r85
        public void a(t85 t85Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, t85Var, jSONObject) != null) {
                return;
            }
            this.b.t(t85Var, this.a);
        }

        @Override // com.baidu.tieba.r85
        public void b(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, th) != null) || i != 1) {
                return;
            }
            if (this.a < WebViewBridge.m.length) {
                this.b.u();
            }
            int i2 = this.a;
            if (i2 < 0 || i2 >= WebViewBridge.m.length) {
                BdLog.e("pingIndex " + this.a + " out of bounds.");
                String s = this.b.s();
                m85.b(s, "103", "ping timeout for index " + this.a);
                return;
            }
            this.b.x(String.valueOf(WebViewBridge.m[this.a]), "");
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends s85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.s85
        public void e(String str, BridgeHandler bridgeHandler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bridgeHandler) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view2) {
            super(view2, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (k85) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(View view2, a aVar) {
            this(view2);
        }

        @Override // com.baidu.tieba.s85
        public void c(t85 t85Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t85Var) == null) {
                t85Var.g(4, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<p85> a;

        public c(p85 p85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(p85Var);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                p85 p85Var = this.a.get();
                if (p85Var == null) {
                    m85.a("TimeHandler got null bridge reference.");
                    return;
                }
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        p85Var.a((String) message.obj);
                        return;
                    }
                    throw new IllegalArgumentException("Invalid message.");
                }
                p85Var.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-942242721, "Lcom/baidu/tbadk/core/hybrid/WebViewBridge;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-942242721, "Lcom/baidu/tbadk/core/hybrid/WebViewBridge;");
                return;
            }
        }
        k = new int[]{1500, 2000, 3500, 4600, 6000, 8000};
        l = new int[]{201, 202, 203};
        m = new int[]{501, 502, 503};
    }

    @Override // com.baidu.tieba.p85
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.j + 1;
            this.j = i;
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            hashMap.put("version", "1.0");
            hashMap.put("logid", s());
            int[] iArr = k;
            l(t85.i(hashMap, iArr[this.j % iArr.length], new a(this, i)), true);
            x(YYOption.UrlProtocol.USER, "");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBridge(WebView webView, k85 k85Var) {
        super(webView, k85Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, k85Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (k85) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = String.valueOf(System.currentTimeMillis());
        this.i = -1;
        this.j = -1;
        q(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(this.c);
        webView.setWebChromeClient(this.d);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.i = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBridge(TbWebView tbWebView, k85 k85Var) {
        super(tbWebView, k85Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbWebView, k85Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (k85) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = String.valueOf(System.currentTimeMillis());
        this.i = -1;
        this.j = -1;
        q(false);
        tbWebView.setWebViewClient(this.c);
        tbWebView.setWebChromeClient(this.d);
        this.i = 1;
    }

    public final void t(t85 t85Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, t85Var, i) == null) {
            this.i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i >= 0) {
                int[] iArr = l;
                if (i < iArr.length) {
                    x(String.valueOf(iArr[i]), String.valueOf(currentTimeMillis - t85Var.h));
                    return;
                }
            }
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m85.a("reInject for pingIndex " + this.j);
            r(this.a);
        }
    }

    @Override // com.baidu.tieba.s85
    public void c(t85 t85Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t85Var) == null) {
            if (t85Var.e == 3) {
                z = true;
            } else {
                z = false;
            }
            l(t85Var, z);
        }
    }

    public static s85 m(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            WebViewBridge webViewBridge = new WebViewBridge(webView, (k85) null);
            webViewBridge.c.c(webViewClient);
            webViewBridge.d.d(webChromeClient);
            return webViewBridge;
        }
        return (s85) invokeCommon.objValue;
    }

    public static s85 n(boolean z, TbWebView tbWebView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), tbWebView, webViewClient, webChromeClient})) == null) {
            if (!z) {
                return new b(tbWebView, null);
            }
            WebViewBridge webViewBridge = new WebViewBridge(tbWebView, (k85) null);
            webViewBridge.c.c(webViewClient);
            webViewBridge.d.d(webChromeClient);
            return webViewBridge;
        }
        return (s85) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.p85
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                m85.a("invalid callbackId.");
                return;
            }
            t85 remove = this.g.remove(str);
            if (remove != null) {
                m85.a("(" + remove.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                remove.g(1, null);
            }
        }
    }

    @Override // com.baidu.tieba.s85
    public void e(String str, BridgeHandler bridgeHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, bridgeHandler) != null) || this.f.put(str, bridgeHandler) == null) {
            return;
        }
        throw new IllegalArgumentException("handler " + str + " exists.");
    }

    public final StringBuilder k() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            jSONObject.put("version", "1.0");
            jSONObject.put("logid", s());
            sb.append(jSONObject.toString());
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public final void l(t85 t85Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, t85Var, z) == null) {
            if (!z) {
                if (this.i != 0) {
                    String s = s();
                    m85.b(s, ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, "(" + t85Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + t85Var.b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(t85Var.a) || TextUtils.isEmpty(t85Var.b)) {
                    m85.b(s(), WorkPostNotifyFlutterData.FAIL_POST, "the alias class or method is empty");
                    t85Var.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(t85Var.f)) {
                if (t85Var.e != 3) {
                    this.g.put(t85Var.f, t85Var);
                    if (t85Var.g > 0) {
                        c cVar = this.e;
                        cVar.sendMessageDelayed(Message.obtain(cVar, 2, t85Var.f), t85Var.g);
                    } else if (t85Var.a != null || t85Var.b != null) {
                        m85.a("ignore timeout check for method call (" + t85Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + t85Var.b + ").");
                    }
                } else {
                    m85.a("ignore timeout check for response method, callbackId " + t85Var.f);
                }
            }
            try {
                String b2 = t85Var.b();
                am6.a().e(this.a, b2, null);
                m85.a(b2);
            } catch (NullPointerException e) {
                x("500", e.getMessage());
            } catch (JSONException e2) {
                if (z) {
                    x(WorkPostNotifyFlutterData.FAIL_POST, e2.getMessage());
                } else {
                    m85.a(e2.getMessage());
                }
                t85Var.g(2, e2);
            }
        }
    }

    public String o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            m85.a("got js prompt in url:" + str + " with content:" + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("messageType");
                if ("ping".equals(optString)) {
                    v(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else if ("request".equals(optString)) {
                    w(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
                } else if ("response".equals(optString)) {
                    v(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else {
                    String s = s();
                    m85.b(s, "105", "invalid message type " + optString);
                }
                return null;
            } catch (JSONException e) {
                m85.b(s(), "109", e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = -1;
            int i = this.i;
            if (i != 2 && i != 1) {
                m85.a("current status " + this.i + ", broken because url changed to " + str);
                this.i = 2;
            }
            if (v85.b(str) && v85.a(str)) {
                m85.a("current status " + this.i + ", constructing bridge for " + str);
                r(this.a);
            }
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.h = String.valueOf(System.currentTimeMillis());
            try {
                InputStream open = view2.getContext().getAssets().open("bridge.dist.min.js");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                StringBuilder k2 = k();
                k2.append("javascript:");
                k2.append(new String(bArr));
                if (view2 instanceof WebView) {
                    ((WebView) view2).loadUrl(k2.toString());
                } else if (view2 instanceof TbWebView) {
                    ((TbWebView) view2).loadUrl(k2.toString());
                }
                this.e.sendEmptyMessageDelayed(1, 0L);
            } catch (Throwable th) {
                x(WorkPostNotifyFlutterData.FAIL_POST, th.getMessage());
                m85.a(th.toString());
            }
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = new BridgeWebViewClient(z);
            l85 l85Var = new l85();
            this.d = l85Var;
            l85Var.c(this);
            this.c.b(this);
            this.e = new c(this);
            this.f = new HashMap<>(16);
            this.g = new HashMap<>(8);
        }
    }

    public final void v(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                m85.a("invalid callbackId.");
                return;
            }
            this.e.removeMessages(2, str);
            t85 remove = this.g.remove(str);
            if (remove != null) {
                remove.h(jSONObject);
            }
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            m85.c(s(), str, str2);
        }
    }

    public final void w(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.i != 0) {
                m85.b(s(), "106", "bridge is not ready");
            }
            o85 o85Var = this.f.get(str);
            if (o85Var == null) {
                o85Var = new NullHandler(this, str, null);
                String s = s();
                m85.b(s, "107", "cmd " + str + " not found");
            }
            o85Var.handle(str2, jSONObject, jSONObject2);
        }
    }
}
