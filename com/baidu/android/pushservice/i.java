package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.httpapi.TokenBindListener;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.m;
import com.baidu.ar.constants.HttpConstants;
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
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile i f33299b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f33300c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f33301d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f33302e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f33303f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, TokenBindListener> f33304g;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33301d = new AtomicInteger();
    }

    public static i a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f33299b == null) {
                synchronized (i.class) {
                    if (f33299b == null) {
                        f33299b = new i();
                        f33300c = context;
                    }
                }
            }
            return f33299b;
        }
        return (i) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            String str = g.f32981h;
            if (i2 == 1) {
                str = "/v2/bccs/upload";
            }
            return g.f32976c + str;
        }
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65544, this, str, i2, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, com.baidu.android.pushservice.i.i.a(f33300c, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
                jSONObject2.put("timestamp", (System.currentTimeMillis() / 1000) + "");
                jSONObject2.put("cid", com.baidu.android.pushservice.i.i.a(f33300c, "cid"));
                jSONObject2.put(HttpConstants.DEVICE_TYPE, "3");
                jSONObject2.put("sdk_int", Build.VERSION.SDK_INT + "");
                jSONObject2.put("push_sdk_version", ((int) a.a()) + "");
                String m = m.m(f33300c);
                if (!TextUtils.isEmpty(m)) {
                    jSONObject2.put("app_version", m);
                }
                if (m.n()) {
                    jSONObject2.put("rom", m.l(f33300c));
                }
                int i3 = m.o(f33300c) ? 3 : 2;
                jSONObject2.put("connect_version", i3 + "");
                jSONObject2.put("bind_name", Build.MODEL);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("push_proxy", str);
                }
                jSONObject2.put(HttpConstants.OS_VERSION, Build.DISPLAY);
                jSONObject2.put(HttpConstants.HTTP_MANUFACTURER, m.a(false));
                jSONObject2.put("bind_notify_status", com.baidu.android.pushservice.i.h.b(f33300c));
                if (i2 == 1) {
                    jSONObject2.put("iid", str2);
                    jSONObject2.put("source", 1);
                } else {
                    jSONObject2.put("source", 2);
                }
                JSONArray a2 = k.a(jSONObject2.toString(), 3, 2);
                jSONObject.put("info", a2);
                jSONObject.put("info_len", a2.length());
            } catch (JSONException | Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLIL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TokenBindListener tokenBindListener, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, this, tokenBindListener, str, str2) == null) || tokenBindListener == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
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

    public void a(int i2, String str, TokenBindListener tokenBindListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, tokenBindListener) == null) {
            if (this.f33304g == null || this.f33303f == null || this.f33302e == null) {
                this.f33304g = new HashMap<>();
                this.f33303f = new LinkedHashMap<>();
                this.f33302e = new HashMap<>();
            }
            String str2 = "key" + System.currentTimeMillis() + this.f33301d.incrementAndGet();
            this.f33304g.put(str2, tokenBindListener);
            this.f33303f.put(str2, Integer.valueOf(i2));
            this.f33302e.put(str2, str);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String key = this.f33303f.entrySet().iterator().next().getKey();
            a(str, this.f33303f.remove(key).intValue(), this.f33302e.remove(key), this.f33304g.remove(key));
        }
    }

    public void a(String str, int i2, String str2, TokenBindListener tokenBindListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2, tokenBindListener) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "requestNewBind", (short) 100, str, tokenBindListener, i2, str2, hashMap) { // from class: com.baidu.android.pushservice.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TokenBindListener f33305b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f33306c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f33307d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ HashMap f33308e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ i f33309f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10), str, tokenBindListener, Integer.valueOf(i2), str2, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33309f = this;
                    this.a = str;
                    this.f33305b = tokenBindListener;
                    this.f33306c = i2;
                    this.f33307d = str2;
                    this.f33308e = hashMap;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String b2 = this.f33309f.b(this.a);
                        this.f33309f.a(this.f33305b, b2, this.a);
                        com.baidu.android.pushservice.d.b a2 = com.baidu.android.pushservice.d.c.a(i.f33300c, this.f33309f.a(this.f33306c), "POST", this.f33309f.a(this.a, this.f33306c, this.f33307d), this.f33308e, "application/json");
                        if (a2 != null) {
                            String a3 = m.a(i.f33300c, a2.a());
                            int b3 = a2.b();
                            try {
                                JSONObject jSONObject = new JSONObject(a3);
                                b3 = jSONObject.getInt("error_code");
                                com.baidu.android.pushservice.i.i.a(i.f33300c, "cid", jSONObject.getJSONObject("response_params").getString("cid"));
                                if (!TextUtils.isEmpty(b2)) {
                                    com.baidu.android.pushservice.i.i.a(i.f33300c, "token", b2);
                                }
                            } catch (JSONException unused) {
                            }
                            TokenBindListener tokenBindListener2 = this.f33305b;
                            if (tokenBindListener2 == null || b3 != 0) {
                                return;
                            }
                            tokenBindListener2.onResult(b3, "success");
                        }
                    }
                }
            });
        }
    }
}
