package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f1859a = 3500;

    /* renamed from: b  reason: collision with root package name */
    public static final String f1860b = "https://h5.m.taobao.com/mlapp/olist.html";

    /* renamed from: c  reason: collision with root package name */
    public static final int f1861c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f1862d = true;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f1863e = true;

    /* renamed from: f  reason: collision with root package name */
    public static final int f1864f = 1000;

    /* renamed from: g  reason: collision with root package name */
    public static final int f1865g = 20000;

    /* renamed from: h  reason: collision with root package name */
    public static final String f1866h = "alipay_cashier_dynamic_config";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1867i = "timeout";
    public static final String j = "st_sdk_config";
    public static final String k = "tbreturl";
    public static final String l = "launchAppSwitch";
    public static final String m = "configQueryInterval";
    public static final String n = "scheme_pay";
    public static final String o = "scheme_pay_2";
    public static final String p = "intercept_batch";
    public static a x;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean q;
    public int r;
    public String s;
    public int t;
    public boolean u;
    public boolean v;
    public List<C0016a> w;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 3500;
        this.s = f1860b;
        this.t = 10;
        this.u = true;
        this.v = true;
        this.q = false;
        this.w = null;
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (x == null) {
                a aVar = new a();
                x = aVar;
                aVar.h();
            }
            return x;
        }
        return (a) invokeV.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            a(j.b(com.alipay.sdk.sys.b.a().b(), f1866h, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeout", a());
                jSONObject.put(k, d());
                jSONObject.put(m, e());
                jSONObject.put(l, C0016a.a(f()));
                jSONObject.put(o, b());
                jSONObject.put(p, c());
                j.a(com.alipay.sdk.sys.b.a().b(), f1866h, jSONObject.toString());
            } catch (Exception e2) {
                com.alipay.sdk.util.c.a(e2);
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : invokeV.intValue;
    }

    public List<C0016a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.w : (List) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(j);
            if (optJSONObject != null) {
                this.r = optJSONObject.optInt("timeout", 3500);
                this.s = optJSONObject.optString(k, f1860b).trim();
                this.t = optJSONObject.optInt(m, 10);
                this.w = C0016a.a(optJSONObject.optJSONArray(l));
                this.u = optJSONObject.optBoolean(o, true);
                this.v = optJSONObject.optBoolean(p, true);
            } else {
                com.alipay.sdk.util.c.d(com.alipay.sdk.net.a.f1894a, "config is null");
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    /* renamed from: com.alipay.sdk.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0016a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f1868a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1869b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1870c;

        public C0016a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1868a = str;
            this.f1869b = i2;
            this.f1870c = str2;
        }

        public static C0016a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                return new C0016a(jSONObject.optString(Config.PACKAGE_NAME), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
            }
            return (C0016a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.valueOf(a(this)) : (String) invokeV.objValue;
        }

        public static List<C0016a> a(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
                if (jSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    C0016a a2 = a(jSONArray.optJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public static JSONObject a(C0016a c0016a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c0016a)) == null) {
                if (c0016a == null) {
                    return null;
                }
                try {
                    return new JSONObject().put(Config.PACKAGE_NAME, c0016a.f1868a).put("v", c0016a.f1869b).put("pk", c0016a.f1870c);
                } catch (JSONException e2) {
                    com.alipay.sdk.util.c.a(e2);
                    return null;
                }
            }
            return (JSONObject) invokeL.objValue;
        }

        public static JSONArray a(List<C0016a> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
                if (list == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                for (C0016a c0016a : list) {
                    jSONArray.put(a(c0016a));
                }
                return jSONArray;
            }
            return (JSONArray) invokeL.objValue;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.r;
            if (i2 >= 1000 && i2 <= 20000) {
                com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout >" + this.r);
                return this.r;
            }
            com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout(default) >3500");
            return 3500;
        }
        return invokeV.intValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.q = z;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.r = jSONObject.optInt("timeout", 3500);
            this.s = jSONObject.optString(k, f1860b).trim();
            this.t = jSONObject.optInt(m, 10);
            this.w = C0016a.a(jSONObject.optJSONArray(l));
            this.u = jSONObject.optBoolean(o, true);
            this.v = jSONObject.optBoolean(p, true);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            new Thread(new b(this, context)).start();
        }
    }
}
