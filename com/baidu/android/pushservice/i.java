package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.a0.l;
import com.baidu.android.pushservice.httpapi.TokenBindListener;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i f;
    public static volatile boolean g;
    public static Context h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger a;
    public HashMap<String, String> b;
    public LinkedHashMap<String, Integer> c;
    public HashMap<String, TokenBindListener> d;
    public HashMap<String, ClientEventInfo> e;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ TokenBindListener d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ HashMap g;
        public final /* synthetic */ ClientEventInfo h;
        public final /* synthetic */ i i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, String str, short s, String str2, TokenBindListener tokenBindListener, int i, String str3, HashMap hashMap, ClientEventInfo clientEventInfo) {
            super(str, s);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {iVar, str, Short.valueOf(s), str2, tokenBindListener, Integer.valueOf(i), str3, hashMap, clientEventInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = iVar;
            this.c = str2;
            this.d = tokenBindListener;
            this.e = i;
            this.f = str3;
            this.g = hashMap;
            this.h = clientEventInfo;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String b = this.i.b(this.c);
                this.i.a(this.d, b, this.c);
                com.baidu.android.pushservice.q.b a = com.baidu.android.pushservice.q.c.a(i.h, this.i.a(this.e), "POST", this.i.a(this.c, this.e, this.f), this.g, "application/json");
                if (a != null) {
                    String a2 = Utility.a(i.h, a.b());
                    int a3 = a.a();
                    try {
                        JSONObject jSONObject = new JSONObject(a2);
                        a3 = jSONObject.getInt("error_code");
                        String string = jSONObject.getJSONObject("response_params").getString("cid");
                        String string2 = jSONObject.getJSONObject("response_params").getString("appid");
                        com.baidu.android.pushservice.a0.i.b(i.h, "cid", string);
                        com.baidu.android.pushservice.a0.i.d(i.h, string2);
                        if (!TextUtils.isEmpty(b)) {
                            com.baidu.android.pushservice.a0.i.b(i.h, "token", b);
                        }
                        if (!TextUtils.isEmpty(this.h.getIId()) && com.baidu.android.pushservice.y.c.g(i.h) != 0) {
                            com.baidu.android.pushservice.y.d.d(i.h, this.h);
                        }
                    } catch (JSONException unused) {
                    }
                    TokenBindListener tokenBindListener = this.d;
                    if (tokenBindListener == null || a3 != 0) {
                        return;
                    }
                    tokenBindListener.onResult(a3, "success");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-840926892, "Lcom/baidu/android/pushservice/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-840926892, "Lcom/baidu/android/pushservice/i;");
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicInteger();
    }

    public static i a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f == null) {
                synchronized (i.class) {
                    if (f == null) {
                        f = new i();
                        h = context;
                    }
                }
            }
            return f;
        }
        return (i) invokeL.objValue;
    }

    public final String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            String str = g.j;
            if (i == 1) {
                str = "/v2/bccs/upload";
            }
            return g.g + str;
        }
        return (String) invokeI.objValue;
    }

    public final String a(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, com.baidu.android.pushservice.a0.i.c(h, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                jSONObject2.put("timestamp", currentTimeMillis + "");
                jSONObject2.put("cid", com.baidu.android.pushservice.a0.i.c(h, "cid"));
                jSONObject2.put(HttpConstants.DEVICE_TYPE, "3");
                jSONObject2.put(bj.f, Build.VERSION.SDK_INT + "");
                jSONObject2.put("push_sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                String r = Utility.r(h);
                if (!TextUtils.isEmpty(r)) {
                    jSONObject2.put("app_version", r);
                }
                if (Utility.O(h)) {
                    jSONObject2.put(Config.ROM, Utility.y(h));
                }
                int i2 = Utility.D(h) ? 3 : 2;
                jSONObject2.put("connect_version", i2 + "");
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("push_proxy", str);
                }
                jSONObject2.put(HttpConstants.HTTP_MANUFACTURER, Utility.a(h, false));
                jSONObject2.put("bind_notify_status", com.baidu.android.pushservice.a0.h.b(h));
                jSONObject2.put("source", i);
                jSONObject2.put("iid", str2);
                JSONArray a2 = l.a(jSONObject2.toString(), 3, 2);
                jSONObject.put("info", a2);
                jSONObject.put("info_len", a2.length());
            } catch (JSONException | Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLIL.objValue;
    }

    public void a(int i, String str, ClientEventInfo clientEventInfo, TokenBindListener tokenBindListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, clientEventInfo, tokenBindListener}) == null) {
            if (this.d == null || this.c == null || this.b == null || this.e == null) {
                this.d = new HashMap<>();
                this.c = new LinkedHashMap<>();
                this.b = new HashMap<>();
                this.e = new HashMap<>();
            }
            String str2 = "key" + System.currentTimeMillis() + this.a.incrementAndGet();
            this.d.put(str2, tokenBindListener);
            this.c.put(str2, Integer.valueOf(i));
            this.b.put(str2, str);
            this.e.put(str2, clientEventInfo);
        }
    }

    public final void a(TokenBindListener tokenBindListener, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, tokenBindListener, str, str2) == null) || tokenBindListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            str3 = "http_no_proxy";
        } else if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str3 = "http_no_token";
        } else if (TextUtils.isEmpty(str)) {
            return;
        } else {
            str3 = "http_has_token";
        }
        tokenBindListener.onResult(0, str3);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String key = this.c.entrySet().iterator().next().getKey();
            String remove = this.b.remove(key);
            TokenBindListener remove2 = this.d.remove(key);
            a(str, this.c.remove(key).intValue(), remove, this.e.remove(key), remove2);
        }
    }

    public void a(String str, int i, String str2, ClientEventInfo clientEventInfo, TokenBindListener tokenBindListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), str2, clientEventInfo, tokenBindListener}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            com.baidu.android.pushservice.z.e.a().a(new a(this, "requestNewBind", (short) 100, str, tokenBindListener, i, str2, hashMap, clientEventInfo));
        }
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str).getJSONObject("info").getString("token");
                } catch (JSONException unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
