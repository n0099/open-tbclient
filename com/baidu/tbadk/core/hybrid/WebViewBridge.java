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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a35;
import com.baidu.tieba.b35;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.c35;
import com.baidu.tieba.e35;
import com.baidu.tieba.hh6;
import com.baidu.tieba.t25;
import com.baidu.tieba.u25;
import com.baidu.tieba.v25;
import com.baidu.tieba.x25;
import com.baidu.tieba.y25;
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
public class WebViewBridge extends b35 implements y25 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public BridgeWebViewClient c;
    public u25 d;
    public c e;
    public HashMap<String, x25> f;
    public HashMap<String, c35> g;
    public String h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public static final class NullHandler implements x25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b35 bridge;
        public final String cmd;

        public NullHandler(b35 b35Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b35Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bridge = b35Var;
            this.cmd = str;
        }

        public /* synthetic */ NullHandler(b35 b35Var, String str, a aVar) {
            this(b35Var, str);
        }

        @Override // com.baidu.tieba.x25
        public void handle(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    v25.a("scope " + this.cmd + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "107");
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "cmd " + this.cmd + " not found");
                this.bridge.c(c35.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements a35 {
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

        @Override // com.baidu.tieba.a35
        public void a(c35 c35Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, c35Var, jSONObject) != null) {
                return;
            }
            this.b.u(c35Var, this.a);
        }

        @Override // com.baidu.tieba.a35
        public void b(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, th) != null) || i != 1) {
                return;
            }
            if (this.a < WebViewBridge.m.length) {
                this.b.v();
            }
            int i2 = this.a;
            if (i2 < 0 || i2 >= WebViewBridge.m.length) {
                BdLog.e("pingIndex " + this.a + " out of bounds.");
                String t = this.b.t();
                v25.b(t, "103", "ping timeout for index " + this.a);
                return;
            }
            this.b.y(String.valueOf(WebViewBridge.m[this.a]), "");
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends b35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.b35
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
                    super((View) objArr2[0], (t25) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(View view2, a aVar) {
            this(view2);
        }

        @Override // com.baidu.tieba.b35
        public void c(c35 c35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c35Var) == null) {
                c35Var.g(4, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<y25> a;

        public c(y25 y25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(y25Var);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                y25 y25Var = this.a.get();
                if (y25Var == null) {
                    v25.a("TimeHandler got null bridge reference.");
                    return;
                }
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        y25Var.a((String) message.obj);
                        return;
                    }
                    throw new IllegalArgumentException("Invalid message.");
                }
                y25Var.b();
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

    @Override // com.baidu.tieba.y25
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.j + 1;
            this.j = i;
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            hashMap.put("version", "1.0");
            hashMap.put("logid", t());
            int[] iArr = k;
            m(c35.i(hashMap, iArr[this.j % iArr.length], new a(this, i)), true);
            y(YYOption.UrlProtocol.USER, "");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBridge(WebView webView, t25 t25Var) {
        super(webView, t25Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, t25Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (t25) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = String.valueOf(System.currentTimeMillis());
        this.i = -1;
        this.j = -1;
        r(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(this.c);
        webView.setWebChromeClient(this.d);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.i = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBridge(TbWebView tbWebView, t25 t25Var) {
        super(tbWebView, t25Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbWebView, t25Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (t25) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = String.valueOf(System.currentTimeMillis());
        this.i = -1;
        this.j = -1;
        r(false);
        tbWebView.setWebViewClient(this.c);
        tbWebView.setWebChromeClient(this.d);
        this.i = 1;
    }

    public final void u(c35 c35Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, c35Var, i) == null) {
            this.i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i >= 0) {
                int[] iArr = l;
                if (i < iArr.length) {
                    y(String.valueOf(iArr[i]), String.valueOf(currentTimeMillis - c35Var.h));
                    return;
                }
            }
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            v25.a("reInject for pingIndex " + this.j);
            s(this.a);
        }
    }

    @Override // com.baidu.tieba.b35
    public void c(c35 c35Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c35Var) == null) {
            if (c35Var.e == 3) {
                z = true;
            } else {
                z = false;
            }
            m(c35Var, z);
        }
    }

    public static b35 n(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            WebViewBridge webViewBridge = new WebViewBridge(webView, (t25) null);
            webViewBridge.c.c(webViewClient);
            webViewBridge.d.d(webChromeClient);
            return webViewBridge;
        }
        return (b35) invokeCommon.objValue;
    }

    public static b35 o(boolean z, TbWebView tbWebView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), tbWebView, webViewClient, webChromeClient})) == null) {
            if (!z) {
                return new b(tbWebView, null);
            }
            WebViewBridge webViewBridge = new WebViewBridge(tbWebView, (t25) null);
            webViewBridge.c.c(webViewClient);
            webViewBridge.d.d(webChromeClient);
            return webViewBridge;
        }
        return (b35) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.y25
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                v25.a("invalid callbackId.");
                return;
            }
            c35 remove = this.g.remove(str);
            if (remove != null) {
                v25.a("(" + remove.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                remove.g(1, null);
            }
        }
    }

    @Override // com.baidu.tieba.b35
    public void e(String str, BridgeHandler bridgeHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, bridgeHandler) != null) || this.f.put(str, bridgeHandler) == null) {
            return;
        }
        throw new IllegalArgumentException("handler " + str + " exists.");
    }

    public final StringBuilder l() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            jSONObject.put("version", "1.0");
            jSONObject.put("logid", t());
            sb.append(jSONObject.toString());
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public final void m(c35 c35Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, c35Var, z) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "oldBridge").param("obj_source", "callJSMethod").param("obj_param1", c35Var.a).param(TiebaStatic.Params.OBJ_PARAM2, c35Var.b));
            if (!z) {
                if (this.i != 0) {
                    String t = t();
                    v25.b(t, ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, "(" + c35Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + c35Var.b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(c35Var.a) || TextUtils.isEmpty(c35Var.b)) {
                    v25.b(t(), WorkPostNotifyFlutterData.FAIL_POST, "the alias class or method is empty");
                    c35Var.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(c35Var.f)) {
                if (c35Var.e != 3) {
                    this.g.put(c35Var.f, c35Var);
                    if (c35Var.g > 0) {
                        c cVar = this.e;
                        cVar.sendMessageDelayed(Message.obtain(cVar, 2, c35Var.f), c35Var.g);
                    } else if (c35Var.a != null || c35Var.b != null) {
                        v25.a("ignore timeout check for method call (" + c35Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + c35Var.b + ").");
                    }
                } else {
                    v25.a("ignore timeout check for response method, callbackId " + c35Var.f);
                }
            }
            try {
                String b2 = c35Var.b();
                hh6.a().e(this.a, b2, null);
                v25.a(b2);
            } catch (NullPointerException e) {
                y("500", e.getMessage());
            } catch (JSONException e2) {
                if (z) {
                    y(WorkPostNotifyFlutterData.FAIL_POST, e2.getMessage());
                } else {
                    v25.a(e2.getMessage());
                }
                c35Var.g(2, e2);
            }
        }
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "oldBridge").param("obj_source", "dispatch").param("obj_param1", str).param(TiebaStatic.Params.OBJ_PARAM2, str2));
            v25.a("got js prompt in url:" + str + " with content:" + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("messageType");
                if ("ping".equals(optString)) {
                    w(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else if ("request".equals(optString)) {
                    x(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
                } else if ("response".equals(optString)) {
                    w(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else {
                    String t = t();
                    v25.b(t, "105", "invalid message type " + optString);
                }
                return null;
            } catch (JSONException e) {
                v25.b(t(), "109", e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = -1;
            int i = this.i;
            if (i != 2 && i != 1) {
                v25.a("current status " + this.i + ", broken because url changed to " + str);
                this.i = 2;
            }
            if (e35.b(str) && e35.a(str)) {
                v25.a("current status " + this.i + ", constructing bridge for " + str);
                s(this.a);
            }
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.h = String.valueOf(System.currentTimeMillis());
            try {
                InputStream open = view2.getContext().getAssets().open("bridge.dist.min.js");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                StringBuilder l2 = l();
                l2.append("javascript:");
                l2.append(new String(bArr));
                if (view2 instanceof WebView) {
                    ((WebView) view2).loadUrl(l2.toString());
                } else if (view2 instanceof TbWebView) {
                    ((TbWebView) view2).loadUrl(l2.toString());
                }
                this.e.sendEmptyMessageDelayed(1, 0L);
            } catch (Throwable th) {
                y(WorkPostNotifyFlutterData.FAIL_POST, th.getMessage());
                v25.a(th.toString());
            }
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = new BridgeWebViewClient(z);
            u25 u25Var = new u25();
            this.d = u25Var;
            u25Var.c(this);
            this.c.b(this);
            this.e = new c(this);
            this.f = new HashMap<>(16);
            this.g = new HashMap<>(8);
        }
    }

    public final void w(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                v25.a("invalid callbackId.");
                return;
            }
            this.e.removeMessages(2, str);
            c35 remove = this.g.remove(str);
            if (remove != null) {
                remove.h(jSONObject);
            }
        }
    }

    public final void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            v25.c(t(), str, str2);
        }
    }

    public final void x(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.i != 0) {
                v25.b(t(), "106", "bridge is not ready");
            }
            x25 x25Var = this.f.get(str);
            if (x25Var == null) {
                x25Var = new NullHandler(this, str, null);
                String t = t();
                v25.b(t, "107", "cmd " + str + " not found");
            }
            x25Var.handle(str2, jSONObject, jSONObject2);
        }
    }
}
