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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f34608a = "a";
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
            String str5 = f34608a;
            CtAuth.info(str5, "request params : " + a2);
            String a3 = d.a(context, "https://id6.me/auth/preauth.do", a2, network, str4);
            String str6 = f34608a;
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
                public final /* synthetic */ Future f34632a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f34633b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ i.a f34634c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f34635d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Context f34636e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f34637f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f34638g;

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
                    this.f34638g = this;
                    this.f34632a = r7;
                    this.f34633b = i2;
                    this.f34634c = aVar;
                    this.f34635d = str;
                    this.f34636e = context;
                    this.f34637f = preCodeListener;
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
                            this.f34632a.get(this.f34633b, TimeUnit.MILLISECONDS);
                            Future future2 = this.f34632a;
                            if (future2 == null || future2.isDone()) {
                            }
                        } catch (Throwable th) {
                            try {
                                this.f34634c.a(true);
                                String str3 = "{\"result\":80000,\"msg\":\"请求超时\"}";
                                if (th instanceof TimeoutException) {
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f34635d, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f34635d).h("submitOnTimeoutInterrupted()");
                                    context2 = this.f34636e;
                                    str2 = this.f34635d;
                                    preCodeListener2 = this.f34637f;
                                } else {
                                    cn.com.chinatelecom.gateway.lib.b.e.a(this.f34635d, "{\"result\":80001,\"msg\":\"请求异常\"}", "");
                                    cn.com.chinatelecom.gateway.lib.b.b a2 = cn.com.chinatelecom.gateway.lib.b.e.a(this.f34635d);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("submitOnTimeoutInterrupted other exception : ");
                                    sb.append(th.getMessage());
                                    a2.h(sb.toString());
                                    CtAuth.warn(a.f34608a, "submitOnTimeoutInterrupted other exception", th);
                                    context2 = this.f34636e;
                                    str2 = this.f34635d;
                                    preCodeListener2 = this.f34637f;
                                    str3 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                }
                                CtAuth.postResultOnMainThread(context2, str3, str2, preCodeListener2);
                                if (future == null) {
                                    return;
                                }
                            } finally {
                                future = this.f34632a;
                                if (future != null && !future.isDone()) {
                                    this.f34632a.cancel(true);
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
                CtAuth.warn(f34608a, "generateAesKey error", th);
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
                CtAuth.warn(f34608a, "decryptResult error", th);
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
                CtAuth.warn(f34608a, "decryptResult error", th);
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
                public final /* synthetic */ Context f34609a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f34610b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f34611c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f34612d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f34613e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f34614f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f34615g;

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
                    this.f34615g = this;
                    this.f34609a = context;
                    this.f34610b = str;
                    this.f34611c = str2;
                    this.f34612d = str3;
                    this.f34613e = a2;
                    this.f34614f = preCodeListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String a3 = this.f34615g.a(this.f34609a, this.f34610b, this.f34611c, this.f34612d, null, this.f34613e);
                        if (a()) {
                            return;
                        }
                        CtAuth.postResultOnMainThread(this.f34609a, a3, this.f34613e, this.f34614f);
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
                    public final /* synthetic */ Context f34625a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f34626b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f34627c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f34628d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f34629e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ PreCodeListener f34630f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ a f34631g;

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
                        this.f34631g = this;
                        this.f34625a = context;
                        this.f34626b = str;
                        this.f34627c = str2;
                        this.f34628d = str3;
                        this.f34629e = a2;
                        this.f34630f = preCodeListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!new e().a(this.f34625a, "https://id6.me/auth/preauth.do")) {
                                if (a()) {
                                    return;
                                }
                                CtAuth.postResultOnMainThread(this.f34625a, h.a(80800, "WIFI切换超时"), this.f34629e, this.f34630f);
                            } else if (a()) {
                            } else {
                                String a3 = this.f34631g.a(this.f34625a, this.f34626b, this.f34627c, this.f34628d, null, this.f34629e);
                                if (a()) {
                                    return;
                                }
                                CtAuth.postResultOnMainThread(this.f34625a, a3, this.f34629e, this.f34630f);
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
                public final /* synthetic */ String f34616a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f34617b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f34618c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f34619d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f34620e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ PreCodeListener f34621f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f34622g;

                /* renamed from: h  reason: collision with root package name */
                public boolean f34623h;

                /* renamed from: i  reason: collision with root package name */
                public boolean f34624i;

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
                    this.f34622g = this;
                    this.f34616a = a2;
                    this.f34617b = context;
                    this.f34618c = str;
                    this.f34619d = str2;
                    this.f34620e = str3;
                    this.f34621f = preCodeListener;
                    this.f34623h = false;
                    this.f34624i = false;
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public synchronized void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this) {
                            this.f34623h = true;
                            if (!this.f34624i) {
                                cn.com.chinatelecom.gateway.lib.b.e.a(this.f34616a, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                                CtAuth.postResultOnMainThread(this.f34617b, "{\"result\":80000,\"msg\":\"请求超时\"}", this.f34616a, this.f34621f);
                            }
                        }
                    }
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public synchronized void a(int i4, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i4), str4, Long.valueOf(j)}) == null) {
                        synchronized (this) {
                            if (!this.f34623h && !this.f34624i) {
                                this.f34624i = true;
                                cn.com.chinatelecom.gateway.lib.b.b a3 = cn.com.chinatelecom.gateway.lib.b.e.a(this.f34616a);
                                a3.h("switchToMobile_L  onFail()  expendTime : " + j).a(i4).f(str4).b(j);
                                CtAuth.postResultOnMainThread(this.f34617b, h.a(i4, str4), this.f34616a, this.f34621f);
                                String str5 = a.f34608a;
                                CtAuth.info(str5, "Switching network failed (L), errorMsg :" + str4 + " , expendTime ：" + j);
                            }
                        }
                    }
                }

                @Override // cn.com.chinatelecom.gateway.lib.c.e.a
                public void a(Network network, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, network, j) == null) {
                        String str4 = a.f34608a;
                        CtAuth.info(str4, "Switching network successfully (L) , expendTime ：" + j);
                        if (this.f34623h || this.f34624i) {
                            return;
                        }
                        cn.com.chinatelecom.gateway.lib.b.e.a(this.f34616a).b(j);
                        String a3 = this.f34622g.a(this.f34617b, this.f34618c, this.f34619d, this.f34620e, network, this.f34616a);
                        synchronized (this) {
                            if (!this.f34623h && !this.f34624i) {
                                this.f34624i = true;
                                CtAuth.postResultOnMainThread(this.f34617b, a3, this.f34616a, this.f34621f);
                            }
                        }
                    }
                }
            });
            eVar.a(i3);
        }
    }
}
