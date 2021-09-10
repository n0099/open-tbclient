package c.a.q0.s.y;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q extends l implements i {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final f f14561c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.q0.s.y.c f14562d;

    /* renamed from: e  reason: collision with root package name */
    public final d f14563e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, h> f14564f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, m> f14565g;

    /* renamed from: h  reason: collision with root package name */
    public String f14566h;

    /* renamed from: i  reason: collision with root package name */
    public int f14567i;

    /* renamed from: j  reason: collision with root package name */
    public int f14568j;

    /* loaded from: classes3.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f14569a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f14570b;

        public a(q qVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14570b = qVar;
            this.f14569a = i2;
        }

        @Override // c.a.q0.s.y.k
        public void a(m mVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, mVar, jSONObject) == null) {
                this.f14570b.u(mVar, this.f14569a);
            }
        }

        @Override // c.a.q0.s.y.k
        public void b(int i2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, th) == null) && i2 == 1) {
                if (this.f14569a < q.m.length) {
                    this.f14570b.v();
                }
                int i3 = this.f14569a;
                if (i3 >= 0 && i3 < q.m.length) {
                    this.f14570b.y(String.valueOf(q.m[this.f14569a]), "");
                    return;
                }
                BdLog.e("pingIndex " + this.f14569a + " out of bounds.");
                String t = this.f14570b.t();
                e.b(t, "103", "ping timeout for index " + this.f14569a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(WebView webView, a aVar) {
            this(webView);
        }

        @Override // c.a.q0.s.y.l
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
                mVar.g(4, null);
            }
        }

        @Override // c.a.q0.s.y.l
        public void e(String str, c.a.q0.s.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebView webView) {
            super(webView, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (c.a.q0.s.y.b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l f14571a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14572b;

        public c(l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14571a = lVar;
            this.f14572b = str;
        }

        @Override // c.a.q0.s.y.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    e.a("scope " + this.f14572b + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
                hashMap.put("errMsg", "cmd " + this.f14572b + " not found");
                this.f14571a.c(m.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<i> f14573a;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14573a = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                i iVar = this.f14573a.get();
                if (iVar == null) {
                    e.a("TimeHandler got null bridge reference.");
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    iVar.b();
                } else if (i2 == 2) {
                    iVar.a((String) message.obj);
                } else {
                    throw new IllegalArgumentException("Invalid message.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644291302, "Lc/a/q0/s/y/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644291302, "Lc/a/q0/s/y/q;");
                return;
            }
        }
        k = new int[]{1500, 2000, 3500, 4600, 6000, 8000};
        l = new int[]{201, 202, 203};
        m = new int[]{501, 502, 503};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(WebView webView, c.a.q0.s.y.b bVar) {
        this(webView, new f(), new c.a.q0.s.y.c(), bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((WebView) objArr2[0], (f) objArr2[1], (c.a.q0.s.y.c) objArr2[2], (c.a.q0.s.y.b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static l n(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, c.a.q0.s.y.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient, bVar})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            q qVar = new q(webView, bVar);
            qVar.f14561c.b(webViewClient);
            qVar.f14562d.d(webChromeClient);
            return qVar;
        }
        return (l) invokeCommon.objValue;
    }

    public static l o(boolean z, BridgeWebView bridgeWebView, c.a.q0.s.y.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), bridgeWebView, bVar})) == null) {
            if (!z) {
                return new b(bridgeWebView, null);
            }
            WebViewClient webViewClient = bridgeWebView.webViewClient;
            WebChromeClient webChromeClient = bridgeWebView.chromeClient;
            q qVar = new q(bridgeWebView, bVar);
            qVar.f14561c.b(webViewClient);
            qVar.f14562d.d(webChromeClient);
            return qVar;
        }
        return (l) invokeCommon.objValue;
    }

    @Override // c.a.q0.s.y.i
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                e.a("invalid callbackId.");
                return;
            }
            m remove = this.f14565g.remove(str);
            if (remove != null) {
                e.a("(" + remove.f14552a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.f14553b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                remove.g(1, null);
            }
        }
    }

    @Override // c.a.q0.s.y.i
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f14568j + 1;
            this.f14568j = i2;
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            hashMap.put("version", "1.0");
            hashMap.put("logid", t());
            int[] iArr = k;
            m(m.i(hashMap, iArr[this.f14568j % iArr.length], new a(this, i2)), true);
            y("100", "");
        }
    }

    @Override // c.a.q0.s.y.l
    public void c(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            m(mVar, mVar.f14556e == 3);
        }
    }

    @Override // c.a.q0.s.y.l
    public void e(String str, c.a.q0.s.y.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, dVar) == null) || this.f14564f.put(str, dVar) == null) {
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
            sb.append(';');
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public final void m(m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, mVar, z) == null) {
            if (!z) {
                if (this.f14567i != 0) {
                    String t = t();
                    e.b(t, "101", "(" + mVar.f14552a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f14553b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(mVar.f14552a) || TextUtils.isEmpty(mVar.f14553b)) {
                    e.b(t(), "102", "the alias class or method is empty");
                    mVar.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(mVar.f14557f)) {
                if (mVar.f14556e != 3) {
                    this.f14565g.put(mVar.f14557f, mVar);
                    if (mVar.f14558g > 0) {
                        d dVar = this.f14563e;
                        dVar.sendMessageDelayed(Message.obtain(dVar, 2, mVar.f14557f), mVar.f14558g);
                    } else if (mVar.f14552a != null || mVar.f14553b != null) {
                        e.a("ignore timeout check for method call (" + mVar.f14552a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f14553b + ").");
                    }
                } else {
                    e.a("ignore timeout check for response method, callbackId " + mVar.f14557f);
                }
            }
            try {
                String b2 = mVar.b();
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f14549a.evaluateJavascript(b2, null);
                } else {
                    this.f14549a.loadUrl(b2);
                }
                e.a(b2);
            } catch (NullPointerException e2) {
                y("500", e2.getMessage());
            } catch (JSONException e3) {
                if (z) {
                    y("102", e3.getMessage());
                } else {
                    e.a(e3.getMessage());
                }
                mVar.g(2, e3);
            }
        }
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            e.a("got js prompt in url:" + str + " with content:" + str2);
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
                    e.b(t, TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
                }
                return null;
            } catch (JSONException e2) {
                e.b(t(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e2.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f14568j = -1;
            int i2 = this.f14567i;
            if (i2 != 2 && i2 != 1) {
                e.a("current status " + this.f14567i + ", broken because url changed to " + str);
                this.f14567i = 2;
            }
            if (p.b(str) && p.a(str)) {
                e.a("current status " + this.f14567i + ", constructing bridge for " + str);
                c.a.q0.s.y.b bVar = this.f14550b;
                if (bVar != null) {
                    bVar.b();
                }
                s(this.f14549a);
                c.a.q0.s.y.b bVar2 = this.f14550b;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f14567i == -1) {
                this.f14549a.getSettings().setJavaScriptEnabled(true);
                this.f14549a.setWebViewClient(this.f14561c);
                this.f14549a.setWebChromeClient(this.f14562d);
                this.f14549a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f14567i = 1;
                return;
            }
            throw new IllegalStateException("Can't init bridge more than once.");
        }
    }

    public final void s(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, webView) == null) {
            this.f14566h = String.valueOf(System.currentTimeMillis());
            try {
                InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                StringBuilder l2 = l();
                l2.append(new String(bArr));
                webView.loadUrl("javascript:" + l2.toString());
                this.f14563e.sendEmptyMessageDelayed(1, 0L);
            } catch (Throwable th) {
                y("102", th.getMessage());
                e.a(th.toString());
            }
        }
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f14566h : (String) invokeV.objValue;
    }

    public final void u(m mVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, mVar, i2) == null) {
            this.f14567i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i2 >= 0) {
                int[] iArr = l;
                if (i2 < iArr.length) {
                    y(String.valueOf(iArr[i2]), String.valueOf(currentTimeMillis - mVar.f14559h));
                    return;
                }
            }
            BdLog.e("pingIndex " + i2 + " out of bounds.");
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e.a("reInject for pingIndex " + this.f14568j);
            s(this.f14549a);
        }
    }

    public final void w(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                e.a("invalid callbackId.");
                return;
            }
            this.f14563e.removeMessages(2, str);
            m remove = this.f14565g.remove(str);
            if (remove != null) {
                remove.h(jSONObject);
            }
        }
    }

    public final void x(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.f14567i != 0) {
                e.b(t(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
            }
            h hVar = this.f14564f.get(str);
            if (hVar == null) {
                hVar = new c(this, str);
                String t = t();
                e.b(t, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
            }
            hVar.a(str2, jSONObject, jSONObject2);
        }
    }

    public final void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            e.c(t(), str, str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(WebView webView, f fVar, c.a.q0.s.y.c cVar, c.a.q0.s.y.b bVar) {
        super(webView, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, fVar, cVar, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((WebView) objArr2[0], (c.a.q0.s.y.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f14566h = String.valueOf(System.currentTimeMillis());
        this.f14567i = -1;
        this.f14568j = -1;
        this.f14561c = fVar;
        this.f14562d = cVar;
        cVar.c(this);
        this.f14561c.a(this);
        this.f14563e = new d(this);
        this.f14564f = new HashMap<>(16);
        this.f14565g = new HashMap<>(8);
        r();
    }
}
