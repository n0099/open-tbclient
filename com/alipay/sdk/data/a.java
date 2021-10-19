package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.h;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean A = false;
    public static final boolean B = true;
    public static final boolean C = true;
    public static final String D = "";
    public static final boolean E = false;
    public static final boolean F = false;
    public static final boolean G = false;
    public static final boolean H = true;
    public static final String I = "";
    public static final boolean J = false;
    public static final String K = "";
    public static final int L = 1000;
    public static final int M = 20000;
    public static final String N = "alipay_cashier_dynamic_config";
    public static final String O = "timeout";
    public static final String P = "h5_port_degrade";
    public static final String Q = "st_sdk_config";
    public static final String R = "tbreturl";
    public static final String S = "launchAppSwitch";
    public static final String T = "configQueryInterval";
    public static final String U = "deg_log_mcgw";
    public static final String V = "deg_start_srv_first";
    public static final String W = "prev_jump_dual";
    public static final String X = "use_sc_only";
    public static final String Y = "bind_use_imp";
    public static final String Z = "retry_bnd_once";
    public static final String a0 = "skip_trans";
    public static final String b0 = "up_before_pay";
    public static final String c0 = "lck_k";
    public static final String d0 = "use_sc_lck_a";
    public static final String e0 = "utdid_factor";
    public static final String f0 = "scheme_pay_2";
    public static final String g0 = "intercept_batch";
    public static final String h0 = "bind_with_startActivity";
    public static a i0 = null;
    public static final char[] j0;
    public static final String u = "DynCon";
    public static final int v = 10000;
    public static final String w = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final int x = 10;
    public static final boolean y = true;
    public static final boolean z = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f35991a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35992b;

    /* renamed from: c  reason: collision with root package name */
    public String f35993c;

    /* renamed from: d  reason: collision with root package name */
    public int f35994d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35995e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35996f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35997g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35998h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35999i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36000j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public boolean r;
    public List<b> s;
    public int t;

    /* renamed from: com.alipay.sdk.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1565a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.sys.a f36001a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36002b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f36003c;

        public RunnableC1565a(a aVar, com.alipay.sdk.sys.a aVar2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36003c = aVar;
            this.f36001a = aVar2;
            this.f36002b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.b().a(this.f36001a, this.f36002b);
                    if (a2 != null) {
                        this.f36003c.d(a2.a());
                        this.f36003c.a(com.alipay.sdk.sys.a.e());
                    }
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1481780737, "Lcom/alipay/sdk/data/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1481780737, "Lcom/alipay/sdk/data/a;");
                return;
            }
        }
        j0 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};
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
                return;
            }
        }
        this.f35991a = 10000;
        this.f35992b = false;
        this.f35993c = w;
        this.f35994d = 10;
        this.f35995e = true;
        this.f35996f = true;
        this.f35997g = false;
        this.f35998h = false;
        this.f35999i = true;
        this.f36000j = true;
        this.k = "";
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = "";
        this.q = "";
        this.r = false;
        this.s = null;
        this.t = -1;
    }

    private int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            String c2 = com.alipay.sdk.sys.b.d().c();
            if (TextUtils.isEmpty(c2)) {
                return -1;
            }
            String replaceAll = c2.replaceAll("=", "");
            if (replaceAll.length() >= 5) {
                replaceAll = replaceAll.substring(0, 5);
            }
            int a2 = (int) (a(replaceAll) % 10000);
            return a2 < 0 ? a2 * (-1) : a2;
        }
        return invokeV.intValue;
    }

    public static a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (i0 == null) {
                a aVar = new a();
                i0 = aVar;
                aVar.r();
            }
            return i0;
        }
        return (a) invokeV.objValue;
    }

    private JSONObject v() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timeout", j());
            jSONObject.put(P, s());
            jSONObject.put(R, p());
            jSONObject.put(T, c());
            jSONObject.put(S, b.a(k()));
            jSONObject.put(f0, h());
            jSONObject.put(g0, g());
            jSONObject.put(U, d());
            jSONObject.put(V, e());
            jSONObject.put(W, l());
            jSONObject.put(X, f());
            jSONObject.put(Y, a());
            jSONObject.put(Z, m());
            jSONObject.put(a0, o());
            jSONObject.put(b0, q());
            jSONObject.put(d0, n());
            jSONObject.put(c0, i());
            jSONObject.put(h0, b());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35994d : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35998h : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35999i : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35996f : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35995e : invokeV.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.f35991a;
            if (i2 >= 1000 && i2 <= 20000) {
                c.b(u, "time = " + this.f35991a);
                return this.f35991a;
            }
            c.b(u, "time(def) = 10000");
            return 10000;
        }
        return invokeV.intValue;
    }

    public List<b> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.s : (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36000j : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f35993c : (String) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Context b2 = com.alipay.sdk.sys.b.d().b();
            String a2 = h.a(com.alipay.sdk.sys.a.e(), b2, N, null);
            try {
                this.t = Integer.parseInt(h.a(com.alipay.sdk.sys.a.e(), b2, e0, "-1"));
            } catch (Exception unused) {
            }
            c(a2);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f35992b : invokeV.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            for (int i2 = 0; i2 < 64; i2++) {
                if (str.equals(String.valueOf(j0[i2]))) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(Q);
            if (optJSONObject != null) {
                a(optJSONObject);
            } else {
                c.e(u, "empty config");
            }
        } catch (Throwable th) {
            c.a(th);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f36004a;

        /* renamed from: b  reason: collision with root package name */
        public final int f36005b;

        /* renamed from: c  reason: collision with root package name */
        public final String f36006c;

        public b(String str, int i2, String str2) {
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
            this.f36004a = str;
            this.f36005b = i2;
            this.f36006c = str2;
        }

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                return new b(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
            }
            return (b) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.valueOf(a(this)) : (String) invokeV.objValue;
        }

        public static List<b> a(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
                if (jSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    b a2 = a(jSONArray.optJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public static JSONObject a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar)) == null) {
                if (bVar == null) {
                    return null;
                }
                try {
                    return new JSONObject().put("pn", bVar.f36004a).put("v", bVar.f36005b).put("pk", bVar.f36006c);
                } catch (JSONException e2) {
                    c.a(e2);
                    return null;
                }
            }
            return (JSONObject) invokeL.objValue;
        }

        public static JSONArray a(List<b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
                if (list == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                for (b bVar : list) {
                    jSONArray.put(a(bVar));
                }
                return jSONArray;
            }
            return (JSONArray) invokeL.objValue;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.f35997g = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.sys.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar) == null) {
            try {
                JSONObject v2 = v();
                h.b(aVar, com.alipay.sdk.sys.b.d().b(), N, v2.toString());
            } catch (Exception e2) {
                c.a(e2);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, jSONObject) == null) {
            this.f35991a = jSONObject.optInt("timeout", 10000);
            this.f35992b = jSONObject.optBoolean(P, false);
            this.f35993c = jSONObject.optString(R, w).trim();
            this.f35994d = jSONObject.optInt(T, 10);
            this.s = b.a(jSONObject.optJSONArray(S));
            this.f35995e = jSONObject.optBoolean(f0, true);
            this.f35996f = jSONObject.optBoolean(g0, true);
            this.f35998h = jSONObject.optBoolean(U, false);
            this.f35999i = jSONObject.optBoolean(V, true);
            this.f36000j = jSONObject.optBoolean(W, true);
            this.k = jSONObject.optString(X, "");
            this.l = jSONObject.optBoolean(Y, false);
            this.m = jSONObject.optBoolean(Z, false);
            this.n = jSONObject.optBoolean(a0, false);
            this.o = jSONObject.optBoolean(b0, true);
            this.p = jSONObject.optString(c0, "");
            this.r = jSONObject.optBoolean(d0, false);
            this.q = jSONObject.optString(h0, "");
        }
    }

    public void a(com.alipay.sdk.sys.a aVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, context) == null) {
            new Thread(new RunnableC1565a(this, aVar, context)).start();
        }
    }

    public boolean a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i2)) == null) {
            if (this.t == -1) {
                this.t = t();
                h.b(com.alipay.sdk.sys.a.e(), context, e0, String.valueOf(this.t));
            }
            return this.t < i2;
        }
        return invokeLI.booleanValue;
    }

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(str, 6) : invokeL.longValue;
    }

    public static long a(String str, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            int pow = (int) Math.pow(2.0d, i2);
            int length = str.length();
            long j2 = 0;
            int i4 = length;
            for (int i5 = 0; i5 < length; i5++) {
                j2 += Integer.parseInt(String.valueOf(b(str.substring(i5, i3)))) * ((long) Math.pow(pow, i4 - 1));
                i4--;
            }
            return j2;
        }
        return invokeLI.longValue;
    }
}
