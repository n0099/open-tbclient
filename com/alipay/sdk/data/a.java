package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "prev_jump_dual";
    public static final String B = "use_sc_only";
    public static final String C = "bind_use_imp";
    public static final String D = "retry_bnd_once";
    public static final String E = "skip_trans";
    public static final String F = "up_before_pay";
    public static final String G = "scheme_pay_2";
    public static final String H = "intercept_batch";
    public static a X = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f35953b = "DynCon";

    /* renamed from: c  reason: collision with root package name */
    public static final int f35954c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public static final String f35955d = "https://h5.m.taobao.com/mlapp/olist.html";

    /* renamed from: e  reason: collision with root package name */
    public static final int f35956e = 10;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f35957f = true;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f35958g = true;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f35959h = false;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f35960i = true;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f35961j = true;
    public static final String k = "";
    public static final boolean l = false;
    public static final boolean m = false;
    public static final boolean n = false;
    public static final boolean o = false;
    public static final int p = 1000;
    public static final int q = 20000;
    public static final String r = "alipay_cashier_dynamic_config";
    public static final String s = "timeout";
    public static final String t = "h5_port_degrade";
    public static final String u = "st_sdk_config";
    public static final String v = "tbreturl";
    public static final String w = "launchAppSwitch";
    public static final String x = "configQueryInterval";
    public static final String y = "deg_log_mcgw";
    public static final String z = "deg_start_srv_first";
    public transient /* synthetic */ FieldHolder $fh;
    public int I;
    public boolean J;
    public String K;
    public int L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public String R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public List<C1563a> W;

    /* renamed from: a  reason: collision with root package name */
    public boolean f35962a;

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
        this.I = 10000;
        this.J = false;
        this.K = f35955d;
        this.L = 10;
        this.M = true;
        this.N = true;
        this.f35962a = false;
        this.O = false;
        this.P = true;
        this.Q = true;
        this.R = "";
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = null;
    }

    public static a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (X == null) {
                a aVar = new a();
                X = aVar;
                aVar.q();
            }
            return X;
        }
        return (a) invokeV.objValue;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            a(g.b(com.alipay.sdk.sys.a.a(), com.alipay.sdk.sys.b.a().b(), r, null));
        }
    }

    private JSONObject r() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timeout", a());
            jSONObject.put(t, b());
            jSONObject.put(v, e());
            jSONObject.put(x, f());
            jSONObject.put(w, C1563a.a(o()));
            jSONObject.put(G, c());
            jSONObject.put(H, d());
            jSONObject.put(y, g());
            jSONObject.put(z, h());
            jSONObject.put(A, i());
            jSONObject.put(B, j());
            jSONObject.put(C, k());
            jSONObject.put(D, l());
            jSONObject.put(E, m());
            jSONObject.put(F, n());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.N : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.L : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.P : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.T : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.V : invokeV.booleanValue;
    }

    public List<C1563a> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.W : (List) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(u);
            if (optJSONObject != null) {
                a(optJSONObject);
            } else {
                c.c(f35953b, "empty config");
            }
        } catch (Throwable th) {
            c.a(th);
        }
    }

    /* renamed from: com.alipay.sdk.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1563a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f35966a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35967b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35968c;

        public C1563a(String str, int i2, String str2) {
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
            this.f35966a = str;
            this.f35967b = i2;
            this.f35968c = str2;
        }

        public static C1563a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                return new C1563a(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
            }
            return (C1563a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.valueOf(a(this)) : (String) invokeV.objValue;
        }

        public static List<C1563a> a(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
                if (jSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    C1563a a2 = a(jSONArray.optJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public static JSONObject a(C1563a c1563a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c1563a)) == null) {
                if (c1563a == null) {
                    return null;
                }
                try {
                    return new JSONObject().put("pn", c1563a.f35966a).put("v", c1563a.f35967b).put("pk", c1563a.f35968c);
                } catch (JSONException e2) {
                    c.a(e2);
                    return null;
                }
            }
            return (JSONObject) invokeL.objValue;
        }

        public static JSONArray a(List<C1563a> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
                if (list == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                for (C1563a c1563a : list) {
                    jSONArray.put(a(c1563a));
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
            int i2 = this.I;
            if (i2 >= 1000 && i2 <= 20000) {
                c.a(f35953b, "time = " + this.I);
                return this.I;
            }
            c.a(f35953b, "time(def) = 10000");
            return 10000;
        }
        return invokeV.intValue;
    }

    public void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            this.f35962a = z2;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.sys.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            try {
                g.a(aVar, com.alipay.sdk.sys.b.a().b(), r, r().toString());
            } catch (Exception e2) {
                c.a(e2);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, jSONObject) == null) {
            this.I = jSONObject.optInt("timeout", 10000);
            this.J = jSONObject.optBoolean(t, false);
            this.K = jSONObject.optString(v, f35955d).trim();
            this.L = jSONObject.optInt(x, 10);
            this.W = C1563a.a(jSONObject.optJSONArray(w));
            this.M = jSONObject.optBoolean(G, true);
            this.N = jSONObject.optBoolean(H, true);
            this.O = jSONObject.optBoolean(y, false);
            this.P = jSONObject.optBoolean(z, true);
            this.Q = jSONObject.optBoolean(A, true);
            this.R = jSONObject.optString(B, "");
            this.S = jSONObject.optBoolean(C, false);
            this.T = jSONObject.optBoolean(D, false);
            this.U = jSONObject.optBoolean(E, false);
            this.V = jSONObject.optBoolean(F, false);
        }
    }

    public void a(com.alipay.sdk.sys.a aVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, context) == null) {
            new Thread(new Runnable(this, aVar, context) { // from class: com.alipay.sdk.data.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.alipay.sdk.sys.a f35963a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f35964b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f35965c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35965c = this;
                    this.f35963a = aVar;
                    this.f35964b = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.b().a(this.f35963a, this.f35964b);
                            if (a2 != null) {
                                this.f35965c.b(a2.b());
                                this.f35965c.a(com.alipay.sdk.sys.a.a());
                            }
                        } catch (Throwable th) {
                            c.a(th);
                        }
                    }
                }
            }).start();
        }
    }
}
