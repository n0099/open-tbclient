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
import com.baidu.tieba.b45;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.c45;
import com.baidu.tieba.d45;
import com.baidu.tieba.f45;
import com.baidu.tieba.rj6;
import com.baidu.tieba.u35;
import com.baidu.tieba.v35;
import com.baidu.tieba.w35;
import com.baidu.tieba.y35;
import com.baidu.tieba.z35;
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
public class WebViewBridge extends c45 implements z35 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public BridgeWebViewClient c;
    public v35 d;
    public c e;
    public HashMap<String, y35> f;
    public HashMap<String, d45> g;
    public String h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public static final class NullHandler implements y35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c45 bridge;
        public final String cmd;

        public NullHandler(c45 c45Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c45Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bridge = c45Var;
            this.cmd = str;
        }

        public /* synthetic */ NullHandler(c45 c45Var, String str, a aVar) {
            this(c45Var, str);
        }

        @Override // com.baidu.tieba.y35
        public void handle(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    w35.a("scope " + this.cmd + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "107");
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "cmd " + this.cmd + " not found");
                this.bridge.c(d45.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements b45 {
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

        @Override // com.baidu.tieba.b45
        public void a(d45 d45Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, d45Var, jSONObject) != null) {
                return;
            }
            this.b.u(d45Var, this.a);
        }

        @Override // com.baidu.tieba.b45
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
                w35.b(t, "103", "ping timeout for index " + this.a);
                return;
            }
            this.b.y(String.valueOf(WebViewBridge.m[this.a]), "");
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends c45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.c45
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
                    super((View) objArr2[0], (u35) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(View view2, a aVar) {
            this(view2);
        }

        @Override // com.baidu.tieba.c45
        public void c(d45 d45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d45Var) == null) {
                d45Var.g(4, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<z35> a;

        public c(z35 z35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(z35Var);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                z35 z35Var = this.a.get();
                if (z35Var == null) {
                    w35.a("TimeHandler got null bridge reference.");
                    return;
                }
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        z35Var.a((String) message.obj);
                        return;
                    }
                    throw new IllegalArgumentException("Invalid message.");
                }
                z35Var.b();
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

    @Override // com.baidu.tieba.z35
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
            m(d45.i(hashMap, iArr[this.j % iArr.length], new a(this, i)), true);
            y(YYOption.UrlProtocol.USER, "");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBridge(WebView webView, u35 u35Var) {
        super(webView, u35Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, u35Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (u35) objArr2[1]);
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
    public WebViewBridge(TbWebView tbWebView, u35 u35Var) {
        super(tbWebView, u35Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbWebView, u35Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (u35) objArr2[1]);
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

    public final void u(d45 d45Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, d45Var, i) == null) {
            this.i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i >= 0) {
                int[] iArr = l;
                if (i < iArr.length) {
                    y(String.valueOf(iArr[i]), String.valueOf(currentTimeMillis - d45Var.h));
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
            w35.a("reInject for pingIndex " + this.j);
            s(this.a);
        }
    }

    @Override // com.baidu.tieba.c45
    public void c(d45 d45Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d45Var) == null) {
            if (d45Var.e == 3) {
                z = true;
            } else {
                z = false;
            }
            m(d45Var, z);
        }
    }

    public static c45 n(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            WebViewBridge webViewBridge = new WebViewBridge(webView, (u35) null);
            webViewBridge.c.c(webViewClient);
            webViewBridge.d.d(webChromeClient);
            return webViewBridge;
        }
        return (c45) invokeCommon.objValue;
    }

    public static c45 o(boolean z, TbWebView tbWebView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), tbWebView, webViewClient, webChromeClient})) == null) {
            if (!z) {
                return new b(tbWebView, null);
            }
            WebViewBridge webViewBridge = new WebViewBridge(tbWebView, (u35) null);
            webViewBridge.c.c(webViewClient);
            webViewBridge.d.d(webChromeClient);
            return webViewBridge;
        }
        return (c45) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.z35
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                w35.a("invalid callbackId.");
                return;
            }
            d45 remove = this.g.remove(str);
            if (remove != null) {
                w35.a("(" + remove.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                remove.g(1, null);
            }
        }
    }

    @Override // com.baidu.tieba.c45
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

    public final void m(d45 d45Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, d45Var, z) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "oldBridge").param("obj_source", "callJSMethod").param("obj_param1", d45Var.a).param(TiebaStatic.Params.OBJ_PARAM2, d45Var.b));
            if (!z) {
                if (this.i != 0) {
                    String t = t();
                    w35.b(t, ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, "(" + d45Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + d45Var.b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(d45Var.a) || TextUtils.isEmpty(d45Var.b)) {
                    w35.b(t(), WorkPostNotifyFlutterData.FAIL_POST, "the alias class or method is empty");
                    d45Var.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(d45Var.f)) {
                if (d45Var.e != 3) {
                    this.g.put(d45Var.f, d45Var);
                    if (d45Var.g > 0) {
                        c cVar = this.e;
                        cVar.sendMessageDelayed(Message.obtain(cVar, 2, d45Var.f), d45Var.g);
                    } else if (d45Var.a != null || d45Var.b != null) {
                        w35.a("ignore timeout check for method call (" + d45Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + d45Var.b + ").");
                    }
                } else {
                    w35.a("ignore timeout check for response method, callbackId " + d45Var.f);
                }
            }
            try {
                String b2 = d45Var.b();
                rj6.a().e(this.a, b2, null);
                w35.a(b2);
            } catch (NullPointerException e) {
                y("500", e.getMessage());
            } catch (JSONException e2) {
                if (z) {
                    y(WorkPostNotifyFlutterData.FAIL_POST, e2.getMessage());
                } else {
                    w35.a(e2.getMessage());
                }
                d45Var.g(2, e2);
            }
        }
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "oldBridge").param("obj_source", "dispatch").param("obj_param1", str).param(TiebaStatic.Params.OBJ_PARAM2, str2));
            w35.a("got js prompt in url:" + str + " with content:" + str2);
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
                    w35.b(t, "105", "invalid message type " + optString);
                }
                return null;
            } catch (JSONException e) {
                w35.b(t(), "109", e.getMessage());
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
                w35.a("current status " + this.i + ", broken because url changed to " + str);
                this.i = 2;
            }
            if (f45.b(str) && f45.a(str)) {
                w35.a("current status " + this.i + ", constructing bridge for " + str);
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
                w35.a(th.toString());
            }
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = new BridgeWebViewClient(z);
            v35 v35Var = new v35();
            this.d = v35Var;
            v35Var.c(this);
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
                w35.a("invalid callbackId.");
                return;
            }
            this.e.removeMessages(2, str);
            d45 remove = this.g.remove(str);
            if (remove != null) {
                remove.h(jSONObject);
            }
        }
    }

    public final void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            w35.c(t(), str, str2);
        }
    }

    public final void x(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.i != 0) {
                w35.b(t(), "106", "bridge is not ready");
            }
            y35 y35Var = this.f.get(str);
            if (y35Var == null) {
                y35Var = new NullHandler(this, str, null);
                String t = t();
                w35.b(t, "107", "cmd " + str + " not found");
            }
            y35Var.handle(str2, jSONObject, jSONObject2);
        }
    }
}
