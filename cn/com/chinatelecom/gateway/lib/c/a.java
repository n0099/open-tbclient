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
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public String a(Context context, String str, String str2, String str3, Network network, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, str, str2, str3, network, str4, str5})) == null) {
            String b2 = b();
            String a2 = g.a(context, str, str2, str3, b2);
            String str6 = a;
            CtAuth.info(str6, "request params : " + a2);
            String a3 = d.a(context, "https://id6.me/auth/preauth.do", a2, network, str4, str5);
            String str7 = a;
            CtAuth.info(str7, "request result : " + a3);
            String b3 = b(context, a3, b2, network);
            if (TextUtils.isEmpty(b3)) {
                return "{\"result\":80001,\"msg\":\"请求异常\"}";
            }
            cn.com.chinatelecom.gateway.lib.b.e.a(str5, b3, a2);
            return b3;
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(Context context, List<String> list, String str, Network network) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65541, null, context, list, str, network)) != null) {
            return (String) invokeLLLL.objValue;
        }
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                return null;
            }
            try {
                String str2 = list.get(i);
                if (!TextUtils.isEmpty(list.get(i)) && context != null && Build.VERSION.SDK_INT < 21) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        ((Boolean) Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(e.a(e.b(str2))))).booleanValue();
                    }
                }
                String a2 = a(context, list.get(i), str, network);
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
            i++;
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? cn.com.chinatelecom.gateway.lib.a.a.c(str, str2) : (String) invokeLL.objValue;
    }

    private void a(Context context, String str, i.a aVar, int i, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{context, str, aVar, Integer.valueOf(i), preCodeListener}) == null) {
            i.a().a(new Runnable(this, i.a().b(aVar), i, aVar, str, context, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Future a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f23685b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ i.a f23686c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f23687d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Context f23688e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f23689f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f23690g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Integer.valueOf(i), aVar, str, context, preCodeListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23690g = this;
                    this.a = r7;
                    this.f23685b = i;
                    this.f23686c = aVar;
                    this.f23687d = str;
                    this.f23688e = context;
                    this.f23689f = preCodeListener;
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
                            this.a.get(this.f23685b, TimeUnit.MILLISECONDS);
                            Future future2 = this.a;
                            if (future2 == null || future2.isDone()) {
                            }
                        } catch (Throwable th) {
                            try {
                                this.f23686c.a(true);
                                String str3 = "{\"result\":80000,\"msg\":\"请求超时\"}";
                                if (th instanceof TimeoutException) {
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f23687d, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f23687d).h("submitOnTimeoutInterrupted()");
                                    context2 = this.f23688e;
                                    str2 = this.f23687d;
                                    preCodeListener2 = this.f23689f;
                                } else {
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f23687d, "{\"result\":80001,\"msg\":\"请求异常\"}", "");
                                    cn.com.chinatelecom.gateway.lib.b.b a2 = cn.com.chinatelecom.gateway.lib.b.e.a(this.f23687d);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("submitOnTimeoutInterrupted other exception : ");
                                    sb.append(th.getMessage());
                                    a2.h(sb.toString());
                                    CtAuth.warn(a.a, "submitOnTimeoutInterrupted other exception", th);
                                    context2 = this.f23688e;
                                    str2 = this.f23687d;
                                    preCodeListener2 = this.f23689f;
                                    str3 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                }
                                CtAuth.postResult(context2, str3, str2, preCodeListener2);
                                if (future == null) {
                                    return;
                                }
                            } finally {
                                future = this.a;
                                if (future != null && !future.isDone()) {
                                    this.a.cancel(true);
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
                CtAuth.warn(a, "generateAesKey error", th);
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
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    arrayList.add(optJSONArray.getString(i));
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
                CtAuth.warn(a, "decryptResult error", th);
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
                CtAuth.warn(a, "decryptResult error", th);
                return null;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, str, str2, str3, preCodeListener) == null) {
            int i = CtAuth.mTotalTimeout;
            int i2 = i <= 0 ? 10000 : i;
            String a2 = c.a();
            String a3 = c.a(context);
            cn.com.chinatelecom.gateway.lib.b.e.a(a2).a(str).b(a3).d("preauth").c(f.f(context)).i(context.getPackageName());
            a(context, a2, new i.a(this, context, str, str2, str3, a3, a2, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f23664b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f23665c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f23666d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f23667e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f23668f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f23669g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ a f23670h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, str2, str3, a3, a2, preCodeListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23670h = this;
                    this.a = context;
                    this.f23664b = str;
                    this.f23665c = str2;
                    this.f23666d = str3;
                    this.f23667e = a3;
                    this.f23668f = a2;
                    this.f23669g = preCodeListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String a4 = this.f23670h.a(this.a, this.f23664b, this.f23665c, this.f23666d, null, this.f23667e, this.f23668f);
                        if (a()) {
                            return;
                        }
                        CtAuth.postResult(this.a, a4, this.f23668f, this.f23669g);
                    }
                }
            }, i2, preCodeListener);
        }
    }

    public void b(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3, preCodeListener) == null) {
            int i = CtAuth.mTotalTimeout;
            int i2 = i <= 0 ? 10000 : i;
            String a2 = c.a();
            String a3 = c.a(context);
            cn.com.chinatelecom.gateway.lib.b.e.a(a2).a(str).b(a3).d("preauth").c(f.f(context)).i(context.getPackageName());
            if (Build.VERSION.SDK_INT < 21) {
                a(context, a2, new i.a(this, context, str, str2, str3, a3, a2, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f23678b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f23679c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f23680d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f23681e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ String f23682f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ PreCodeListener f23683g;

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ a f23684h;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2, str3, a3, a2, preCodeListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f23684h = this;
                        this.a = context;
                        this.f23678b = str;
                        this.f23679c = str2;
                        this.f23680d = str3;
                        this.f23681e = a3;
                        this.f23682f = a2;
                        this.f23683g = preCodeListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!new e().a(this.a, "https://id6.me/auth/preauth.do")) {
                                if (a()) {
                                    return;
                                }
                                CtAuth.postResult(this.a, h.a(80800, "WIFI切换超时"), this.f23682f, this.f23683g);
                            } else if (a()) {
                            } else {
                                String a4 = this.f23684h.a(this.a, this.f23678b, this.f23679c, this.f23680d, null, this.f23681e, this.f23682f);
                                if (a()) {
                                    return;
                                }
                                CtAuth.postResult(this.a, a4, this.f23682f, this.f23683g);
                            }
                        }
                    }
                }, i2, preCodeListener);
                return;
            }
            e eVar = new e();
            eVar.a(context, new e.a(this, a2, context, str, str2, str3, a3, preCodeListener) { // from class: cn.com.chinatelecom.gateway.lib.c.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f23671b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f23672c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f23673d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f23674e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f23675f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f23676g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ a f23677h;
                public boolean i;
                public boolean j;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, a2, context, str, str2, str3, a3, preCodeListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23677h = this;
                    this.a = a2;
                    this.f23671b = context;
                    this.f23672c = str;
                    this.f23673d = str2;
                    this.f23674e = str3;
                    this.f23675f = a3;
                    this.f23676g = preCodeListener;
                    this.i = false;
                    this.j = false;
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public synchronized void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this) {
                            this.i = true;
                            if (!this.j) {
                                cn.com.chinatelecom.gateway.lib.b.e.a(this.a, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                                CtAuth.postResult(this.f23671b, "{\"result\":80000,\"msg\":\"请求超时\"}", this.a, this.f23676g);
                            }
                        }
                    }
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public synchronized void a(int i3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), str4, Long.valueOf(j)}) == null) {
                        synchronized (this) {
                            if (!this.i && !this.j) {
                                this.j = true;
                                cn.com.chinatelecom.gateway.lib.b.b a4 = cn.com.chinatelecom.gateway.lib.b.e.a(this.a);
                                a4.h("switchToMobile_L  onFail()  expendTime : " + j).a(i3).f(str4).b(j);
                                CtAuth.postResult(this.f23671b, h.a(i3, str4), this.a, this.f23676g);
                                String str5 = a.a;
                                CtAuth.info(str5, "Switching network failed (L), errorMsg :" + str4 + " , expendTime ：" + j);
                            }
                        }
                    }
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public void a(Network network, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, network, j) == null) {
                        String str4 = a.a;
                        CtAuth.info(str4, "Switching network successfully (L) , expendTime ：" + j);
                        if (this.i || this.j) {
                            return;
                        }
                        cn.com.chinatelecom.gateway.lib.b.e.a(this.a).b(j);
                        String a4 = this.f23677h.a(this.f23671b, this.f23672c, this.f23673d, this.f23674e, network, this.f23675f, this.a);
                        synchronized (this) {
                            if (!this.i && !this.j) {
                                this.j = true;
                                CtAuth.postResult(this.f23671b, a4, this.a, this.f23676g);
                            }
                        }
                    }
                }
            });
            eVar.a(i2);
        }
    }
}
