package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import cn.com.chinatelecom.gateway.lib.c.e;
import cn.com.chinatelecom.gateway.lib.c.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35531a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293515452, "Lcn/com/chinatelecom/gateway/lib/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293515452, "Lcn/com/chinatelecom/gateway/lib/c/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Context context, String str, String str2, Network network) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, str2, network)) == null) ? c(context, d.a(context, str, network), str2, network) : (String) invokeLLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str, String str2, String str3, Network network, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, str, str2, str3, network, str4})) == null) {
            String b2 = b();
            String a2 = g.a(context, str, str2, str3, b2);
            String str5 = f35531a;
            CtAuth.info(str5, "request params : " + a2);
            String a3 = d.a(context, "https://id6.me/auth/preauth.do", a2, network, str4);
            String str6 = f35531a;
            CtAuth.info(str6, "request result : " + a3);
            String b3 = b(context, a3, b2, network);
            if (TextUtils.isEmpty(b3)) {
                return "{\"result\":80001,\"msg\":\"请求异常\"}";
            }
            cn.com.chinatelecom.gateway.lib.b.e.a(str4, b3, a2);
            return b3;
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(Context context, List<String> list, String str, Network network) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, context, list, str, network)) != null) {
            return (String) invokeLLLL.objValue;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                return null;
            }
            try {
                String str2 = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2)) && context != null && Build.VERSION.SDK_INT < 21) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        ((Boolean) Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(e.a(e.b(str2))))).booleanValue();
                    }
                }
                String a2 = a(context, list.get(i2), str, network);
                try {
                    JSONObject jSONObject = TextUtils.isEmpty(a2) ? null : new JSONObject(a2);
                    if (jSONObject != null && jSONObject.getInt("result") == 0) {
                        return a2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            i2++;
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? cn.com.chinatelecom.gateway.lib.a.a.c(str, str2) : (String) invokeLL.objValue;
    }

    private void a(Context context, String str, i.a aVar, int i2, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{context, str, aVar, Integer.valueOf(i2), preCodeListener}) == null) {
            i.a(new Runnable(this, i.b(aVar), i2, aVar, str, context, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Future f35555a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f35556b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ i.a f35557c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f35558d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Context f35559e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f35560f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f35561g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Integer.valueOf(i2), aVar, str, context, preCodeListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35561g = this;
                    this.f35555a = r7;
                    this.f35556b = i2;
                    this.f35557c = aVar;
                    this.f35558d = str;
                    this.f35559e = context;
                    this.f35560f = preCodeListener;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF, INVOKE, IF] complete} */
                @Override // java.lang.Runnable
                public void run() {
                    Future future;
                    Context context2;
                    String str2;
                    PreCodeListener preCodeListener2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f35555a.get(this.f35556b, TimeUnit.MILLISECONDS);
                            Future future2 = this.f35555a;
                            if (future2 == null || future2.isDone()) {
                            }
                        } catch (Throwable th) {
                            try {
                                this.f35557c.a(true);
                                String str3 = "{\"result\":80000,\"msg\":\"请求超时\"}";
                                if (th instanceof TimeoutException) {
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f35558d, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f35558d).h("submitOnTimeoutInterrupted()");
                                    context2 = this.f35559e;
                                    str2 = this.f35558d;
                                    preCodeListener2 = this.f35560f;
                                } else {
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f35558d, "{\"result\":80001,\"msg\":\"请求异常\"}", "");
                                    cn.com.chinatelecom.gateway.lib.b.b a2 = cn.com.chinatelecom.gateway.lib.b.e.a(this.f35558d);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("submitOnTimeoutInterrupted other exception : ");
                                    sb.append(th.getMessage());
                                    a2.h(sb.toString());
                                    CtAuth.warn(a.f35531a, "submitOnTimeoutInterrupted other exception", th);
                                    context2 = this.f35559e;
                                    str2 = this.f35558d;
                                    preCodeListener2 = this.f35560f;
                                    str3 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                }
                                CtAuth.postResultOnMainThread(context2, str3, str2, preCodeListener2);
                                if (future == null) {
                                    return;
                                }
                            } finally {
                                future = this.f35555a;
                                if (future != null && !future.isDone()) {
                                    this.f35555a.cancel(true);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            try {
                String uuid = UUID.randomUUID().toString();
                if (TextUtils.isEmpty(uuid)) {
                    return "";
                }
                String replace = uuid.replace("-", "");
                return replace.length() >= 16 ? replace.substring(0, 16) : replace;
            } catch (Throwable th) {
                CtAuth.warn(f35531a, "generateAesKey error", th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    private String b(Context context, String str, String str2, Network network) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, this, context, str, str2, network)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result");
                String optString = jSONObject.optString("data");
                if ((optInt == 0 || optInt == 30002) && !TextUtils.isEmpty(optString)) {
                    String a2 = a(optString, str2);
                    if (!TextUtils.isEmpty(a2)) {
                        try {
                            jSONObject.put("data", new JSONObject(a2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            jSONObject.put("data", a2);
                        }
                        if (optInt == 30002) {
                            JSONObject jSONObject2 = (JSONObject) jSONObject.opt("data");
                            ArrayList arrayList = new ArrayList();
                            JSONArray optJSONArray = jSONObject2.optJSONArray("urls");
                            if (optJSONArray != null) {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    arrayList.add(optJSONArray.getString(i2));
                                }
                            }
                            if (arrayList.isEmpty()) {
                                return null;
                            }
                            return a(context, arrayList, str2, network);
                        }
                        return jSONObject.toString();
                    }
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                CtAuth.warn(f35531a, "decryptResult error", th);
                return null;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public static String c(Context context, String str, String str2, Network network) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, context, str, str2, network)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result");
                String optString = jSONObject.optString("data");
                if (optInt == 0 && !TextUtils.isEmpty(optString)) {
                    String a2 = a(optString, str2);
                    if (!TextUtils.isEmpty(a2)) {
                        try {
                            jSONObject.put("data", new JSONObject(a2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            jSONObject.put("data", a2);
                        }
                    }
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                CtAuth.warn(f35531a, "decryptResult error", th);
                return null;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, str, str2, str3, preCodeListener) == null) {
            int i2 = CtAuth.mTotalTimeout;
            int i3 = i2 <= 0 ? 10000 : i2;
            String a2 = c.a();
            cn.com.chinatelecom.gateway.lib.b.e.a(a2).a(str).b(c.a(context)).d("preauth").c(f.f(context));
            a(context, a2, new i.a(this, context, str, str2, str3, a2, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f35532a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f35533b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f35534c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f35535d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f35536e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f35537f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f35538g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, str2, str3, a2, preCodeListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35538g = this;
                    this.f35532a = context;
                    this.f35533b = str;
                    this.f35534c = str2;
                    this.f35535d = str3;
                    this.f35536e = a2;
                    this.f35537f = preCodeListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String a3 = this.f35538g.a(this.f35532a, this.f35533b, this.f35534c, this.f35535d, null, this.f35536e);
                        if (a()) {
                            return;
                        }
                        CtAuth.postResultOnMainThread(this.f35532a, a3, this.f35536e, this.f35537f);
                    }
                }
            }, i3, preCodeListener);
        }
    }

    public void b(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3, preCodeListener) == null) {
            int i2 = CtAuth.mTotalTimeout;
            int i3 = i2 <= 0 ? 10000 : i2;
            String a2 = c.a();
            cn.com.chinatelecom.gateway.lib.b.e.a(a2).a(str).b(c.a(context)).d("preauth").c(f.f(context));
            if (Build.VERSION.SDK_INT < 21) {
                a(context, a2, new i.a(this, context, str, str2, str3, a2, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f35548a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f35549b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f35550c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f35551d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f35552e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ PreCodeListener f35553f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ a f35554g;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2, str3, a2, preCodeListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35554g = this;
                        this.f35548a = context;
                        this.f35549b = str;
                        this.f35550c = str2;
                        this.f35551d = str3;
                        this.f35552e = a2;
                        this.f35553f = preCodeListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!new e().a(this.f35548a, "https://id6.me/auth/preauth.do")) {
                                if (a()) {
                                    return;
                                }
                                CtAuth.postResultOnMainThread(this.f35548a, h.a(80800, "WIFI切换超时"), this.f35552e, this.f35553f);
                            } else if (a()) {
                            } else {
                                String a3 = this.f35554g.a(this.f35548a, this.f35549b, this.f35550c, this.f35551d, null, this.f35552e);
                                if (a()) {
                                    return;
                                }
                                CtAuth.postResultOnMainThread(this.f35548a, a3, this.f35552e, this.f35553f);
                            }
                        }
                    }
                }, i3, preCodeListener);
                return;
            }
            e eVar = new e();
            eVar.a(context, new e.a(this, a2, context, str, str2, str3, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f35539a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f35540b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f35541c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f35542d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f35543e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f35544f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f35545g;

                /* renamed from: h  reason: collision with root package name */
                public boolean f35546h;

                /* renamed from: i  reason: collision with root package name */
                public boolean f35547i;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, a2, context, str, str2, str3, preCodeListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35545g = this;
                    this.f35539a = a2;
                    this.f35540b = context;
                    this.f35541c = str;
                    this.f35542d = str2;
                    this.f35543e = str3;
                    this.f35544f = preCodeListener;
                    this.f35546h = false;
                    this.f35547i = false;
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public synchronized void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this) {
                            this.f35546h = true;
                            if (!this.f35547i) {
                                cn.com.chinatelecom.gateway.lib.b.e.a(this.f35539a, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                                CtAuth.postResultOnMainThread(this.f35540b, "{\"result\":80000,\"msg\":\"请求超时\"}", this.f35539a, this.f35544f);
                            }
                        }
                    }
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public synchronized void a(int i4, String str4, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i4), str4, Long.valueOf(j2)}) == null) {
                        synchronized (this) {
                            if (!this.f35546h && !this.f35547i) {
                                this.f35547i = true;
                                cn.com.chinatelecom.gateway.lib.b.b a3 = cn.com.chinatelecom.gateway.lib.b.e.a(this.f35539a);
                                a3.h("switchToMobile_L  onFail()  expendTime : " + j2).a(i4).f(str4).b(j2);
                                CtAuth.postResultOnMainThread(this.f35540b, h.a(i4, str4), this.f35539a, this.f35544f);
                                String str5 = a.f35531a;
                                CtAuth.info(str5, "Switching network failed (L), errorMsg :" + str4 + " , expendTime ：" + j2);
                            }
                        }
                    }
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public void a(Network network, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, network, j2) == null) {
                        String str4 = a.f35531a;
                        CtAuth.info(str4, "Switching network successfully (L) , expendTime ：" + j2);
                        if (this.f35546h || this.f35547i) {
                            return;
                        }
                        cn.com.chinatelecom.gateway.lib.b.e.a(this.f35539a).b(j2);
                        String a3 = this.f35545g.a(this.f35540b, this.f35541c, this.f35542d, this.f35543e, network, this.f35539a);
                        synchronized (this) {
                            if (!this.f35546h && !this.f35547i) {
                                this.f35547i = true;
                                CtAuth.postResultOnMainThread(this.f35540b, a3, this.f35539a, this.f35544f);
                            }
                        }
                    }
                }
            });
            eVar.a(i3);
        }
    }
}
