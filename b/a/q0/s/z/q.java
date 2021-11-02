package b.a.q0.s.z;

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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends l implements i {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final f f13682c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a.q0.s.z.c f13683d;

    /* renamed from: e  reason: collision with root package name */
    public final d f13684e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, h> f13685f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, m> f13686g;

    /* renamed from: h  reason: collision with root package name */
    public String f13687h;

    /* renamed from: i  reason: collision with root package name */
    public int f13688i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13689a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f13690b;

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
            this.f13690b = qVar;
            this.f13689a = i2;
        }

        @Override // b.a.q0.s.z.k
        public void a(m mVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, mVar, jSONObject) == null) {
                this.f13690b.t(mVar, this.f13689a);
            }
        }

        @Override // b.a.q0.s.z.k
        public void b(int i2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, th) == null) && i2 == 1) {
                if (this.f13689a < q.m.length) {
                    this.f13690b.u();
                }
                int i3 = this.f13689a;
                if (i3 >= 0 && i3 < q.m.length) {
                    this.f13690b.x(String.valueOf(q.m[this.f13689a]), "");
                    return;
                }
                BdLog.e("pingIndex " + this.f13689a + " out of bounds.");
                String s = this.f13690b.s();
                e.b(s, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + this.f13689a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(WebView webView, a aVar) {
            this(webView);
        }

        @Override // b.a.q0.s.z.l
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
                mVar.g(4, null);
            }
        }

        @Override // b.a.q0.s.z.l
        public void e(String str, b.a.q0.s.z.d dVar) {
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
                    super((WebView) objArr2[0], (b.a.q0.s.z.b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l f13691a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13692b;

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
            this.f13691a = lVar;
            this.f13692b = str;
        }

        @Override // b.a.q0.s.z.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    e.a("scope " + this.f13692b + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
                hashMap.put("errMsg", "cmd " + this.f13692b + " not found");
                this.f13691a.c(m.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<i> f13693a;

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
            this.f13693a = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                i iVar = this.f13693a.get();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1937724100, "Lb/a/q0/s/z/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1937724100, "Lb/a/q0/s/z/q;");
                return;
            }
        }
        k = new int[]{1500, 2000, 3500, 4600, 6000, 8000};
        l = new int[]{201, 202, 203};
        m = new int[]{501, 502, 503};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(WebView webView, b.a.q0.s.z.b bVar) {
        this(webView, new f(), new b.a.q0.s.z.c(), bVar);
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
                this((WebView) objArr2[0], (f) objArr2[1], (b.a.q0.s.z.c) objArr2[2], (b.a.q0.s.z.b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static l m(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, b.a.q0.s.z.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient, bVar})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            q qVar = new q(webView, bVar);
            qVar.f13682c.b(webViewClient);
            qVar.f13683d.d(webChromeClient);
            return qVar;
        }
        return (l) invokeCommon.objValue;
    }

    public static l n(boolean z, BridgeWebView bridgeWebView, b.a.q0.s.z.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), bridgeWebView, bVar})) == null) {
            if (!z) {
                return new b(bridgeWebView, null);
            }
            WebViewClient webViewClient = bridgeWebView.webViewClient;
            WebChromeClient webChromeClient = bridgeWebView.chromeClient;
            q qVar = new q(bridgeWebView, bVar);
            qVar.f13682c.b(webViewClient);
            qVar.f13683d.d(webChromeClient);
            return qVar;
        }
        return (l) invokeCommon.objValue;
    }

    @Override // b.a.q0.s.z.i
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                e.a("invalid callbackId.");
                return;
            }
            m remove = this.f13686g.remove(str);
            if (remove != null) {
                e.a("(" + remove.f13674a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.f13675b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                remove.g(1, null);
            }
        }
    }

    @Override // b.a.q0.s.z.i
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.j + 1;
            this.j = i2;
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            hashMap.put("version", "1.0");
            hashMap.put("logid", s());
            int[] iArr = k;
            l(m.i(hashMap, iArr[this.j % iArr.length], new a(this, i2)), true);
            x(HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP, "");
        }
    }

    @Override // b.a.q0.s.z.l
    public void c(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            l(mVar, mVar.f13678e == 3);
        }
    }

    @Override // b.a.q0.s.z.l
    public void e(String str, b.a.q0.s.z.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, dVar) == null) || this.f13685f.put(str, dVar) == null) {
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
            sb.append(';');
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public final void l(m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, mVar, z) == null) {
            if (!z) {
                if (this.f13688i != 0) {
                    String s = s();
                    e.b(s, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY, "(" + mVar.f13674a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f13675b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(mVar.f13674a) || TextUtils.isEmpty(mVar.f13675b)) {
                    e.b(s(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                    mVar.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(mVar.f13679f)) {
                if (mVar.f13678e != 3) {
                    this.f13686g.put(mVar.f13679f, mVar);
                    if (mVar.f13680g > 0) {
                        d dVar = this.f13684e;
                        dVar.sendMessageDelayed(Message.obtain(dVar, 2, mVar.f13679f), mVar.f13680g);
                    } else if (mVar.f13674a != null || mVar.f13675b != null) {
                        e.a("ignore timeout check for method call (" + mVar.f13674a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f13675b + ").");
                    }
                } else {
                    e.a("ignore timeout check for response method, callbackId " + mVar.f13679f);
                }
            }
            try {
                String b2 = mVar.b();
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f13671a.evaluateJavascript(b2, null);
                } else {
                    this.f13671a.loadUrl(b2);
                }
                e.a(b2);
            } catch (NullPointerException e2) {
                x("500", e2.getMessage());
            } catch (JSONException e3) {
                if (z) {
                    x(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e3.getMessage());
                } else {
                    e.a(e3.getMessage());
                }
                mVar.g(2, e3);
            }
        }
    }

    public String o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            e.a("got js prompt in url:" + str + " with content:" + str2);
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
                    e.b(s, TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
                }
                return null;
            } catch (JSONException e2) {
                e.b(s(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e2.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = -1;
            int i2 = this.f13688i;
            if (i2 != 2 && i2 != 1) {
                e.a("current status " + this.f13688i + ", broken because url changed to " + str);
                this.f13688i = 2;
            }
            if (p.b(str) && p.a(str)) {
                e.a("current status " + this.f13688i + ", constructing bridge for " + str);
                b.a.q0.s.z.b bVar = this.f13672b;
                if (bVar != null) {
                    bVar.b();
                }
                r(this.f13671a);
                b.a.q0.s.z.b bVar2 = this.f13672b;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f13688i == -1) {
                this.f13671a.getSettings().setJavaScriptEnabled(true);
                this.f13671a.setWebViewClient(this.f13682c);
                this.f13671a.setWebChromeClient(this.f13683d);
                this.f13671a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f13688i = 1;
                return;
            }
            throw new IllegalStateException("Can't init bridge more than once.");
        }
    }

    public final void r(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, webView) == null) {
            this.f13687h = String.valueOf(System.currentTimeMillis());
            try {
                InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                StringBuilder k2 = k();
                k2.append(new String(bArr));
                webView.loadUrl("javascript:" + k2.toString());
                this.f13684e.sendEmptyMessageDelayed(1, 0L);
            } catch (Throwable th) {
                x(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
                e.a(th.toString());
            }
        }
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13687h : (String) invokeV.objValue;
    }

    public final void t(m mVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, mVar, i2) == null) {
            this.f13688i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i2 >= 0) {
                int[] iArr = l;
                if (i2 < iArr.length) {
                    x(String.valueOf(iArr[i2]), String.valueOf(currentTimeMillis - mVar.f13681h));
                    return;
                }
            }
            BdLog.e("pingIndex " + i2 + " out of bounds.");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e.a("reInject for pingIndex " + this.j);
            r(this.f13671a);
        }
    }

    public final void v(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                e.a("invalid callbackId.");
                return;
            }
            this.f13684e.removeMessages(2, str);
            m remove = this.f13686g.remove(str);
            if (remove != null) {
                remove.h(jSONObject);
            }
        }
    }

    public final void w(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.f13688i != 0) {
                e.b(s(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
            }
            h hVar = this.f13685f.get(str);
            if (hVar == null) {
                hVar = new c(this, str);
                String s = s();
                e.b(s, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
            }
            hVar.a(str2, jSONObject, jSONObject2);
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            e.c(s(), str, str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(WebView webView, f fVar, b.a.q0.s.z.c cVar, b.a.q0.s.z.b bVar) {
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
                super((WebView) objArr2[0], (b.a.q0.s.z.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13687h = String.valueOf(System.currentTimeMillis());
        this.f13688i = -1;
        this.j = -1;
        this.f13682c = fVar;
        this.f13683d = cVar;
        cVar.c(this);
        this.f13682c.a(this);
        this.f13684e = new d(this);
        this.f13685f = new HashMap<>(16);
        this.f13686g = new HashMap<>(8);
        q();
    }
}
