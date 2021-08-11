package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.e;
import com.alipay.sdk.util.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35830a = "alipay_tid_storage";

    /* renamed from: b  reason: collision with root package name */
    public static final String f35831b = "tidinfo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f35832c = "tid";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35833d = "client_key";

    /* renamed from: e  reason: collision with root package name */
    public static final String f35834e = "timestamp";

    /* renamed from: f  reason: collision with root package name */
    public static final String f35835f = "vimei";

    /* renamed from: g  reason: collision with root package name */
    public static final String f35836g = "vimsi";

    /* renamed from: h  reason: collision with root package name */
    public static Context f35837h;
    public static a n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public String f35838i;

    /* renamed from: j  reason: collision with root package name */
    public String f35839j;
    public long k;
    public String l;
    public String m;
    public boolean o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(971321338, "Lcom/alipay/sdk/tid/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(971321338, "Lcom/alipay/sdk/tid/a;");
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
                return;
            }
        }
        this.o = false;
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (a.class) {
                if (n == null) {
                    n = new a();
                }
                if (f35837h == null) {
                    n.b(context);
                }
                aVar = n;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            if (context != null) {
                f35837h = context.getApplicationContext();
            }
            if (this.o) {
                return;
            }
            this.o = true;
            k();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        String str;
        String str2;
        String str3;
        String str4;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65543, this) != null) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String str5 = null;
        try {
            a2 = C1562a.a(f35830a, f35831b, true);
        } catch (Exception e2) {
            e = e2;
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject(a2);
            str = jSONObject.optString("tid", "");
            try {
                str2 = jSONObject.optString(f35833d, "");
                try {
                    valueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    str3 = jSONObject.optString(f35835f, "");
                } catch (Exception e3) {
                    e = e3;
                    str3 = null;
                }
                try {
                    str4 = jSONObject.optString(f35836g, "");
                } catch (Exception e4) {
                    e = e4;
                    c.a(e);
                    str4 = null;
                    str5 = str;
                    c.a(com.alipay.sdk.cons.a.x, "tid_str: load");
                    if (!a(str5, str2, str3, str4)) {
                    }
                }
            } catch (Exception e5) {
                e = e5;
                str2 = null;
                str3 = str2;
                c.a(e);
                str4 = null;
                str5 = str;
                c.a(com.alipay.sdk.cons.a.x, "tid_str: load");
                if (!a(str5, str2, str3, str4)) {
                }
            }
            str5 = str;
            c.a(com.alipay.sdk.cons.a.x, "tid_str: load");
            if (!a(str5, str2, str3, str4)) {
                l();
                return;
            }
            this.f35838i = str5;
            this.f35839j = str2;
            this.k = valueOf.longValue();
            this.l = str3;
            this.m = str4;
            return;
        }
        str4 = null;
        str2 = null;
        str3 = null;
        c.a(com.alipay.sdk.cons.a.x, "tid_str: load");
        if (!a(str5, str2, str3, str4)) {
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f35838i = "";
            this.f35839j = f();
            this.k = System.currentTimeMillis();
            this.l = m();
            this.m = m();
            C1562a.b(f35830a, f35831b);
        }
    }

    private String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            Random random = new Random();
            return hexString + (random.nextInt(9000) + 1000);
        }
        return (String) invokeV.objValue;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tid", this.f35838i);
                jSONObject.put(f35833d, this.f35839j);
                jSONObject.put("timestamp", this.k);
                jSONObject.put(f35835f, this.l);
                jSONObject.put(f35836g, this.m);
                C1562a.a(f35830a, f35831b, jSONObject.toString(), true);
            } catch (Exception e2) {
                c.a(e2);
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.isEmpty(this.f35838i) || TextUtils.isEmpty(this.f35839j) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a(com.alipay.sdk.cons.a.x, "tid_str: del");
            l();
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? e() : invokeV.booleanValue;
    }

    public Long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Long.valueOf(this.k) : (Long) invokeV.objValue;
    }

    /* renamed from: com.alipay.sdk.tid.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1562a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1562a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static boolean a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
                if (a.f35837h == null) {
                    return false;
                }
                return a.f35837h.getSharedPreferences(str, 0).contains(str2);
            }
            return invokeLL.booleanValue;
        }

        public static void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) || a.f35837h == null) {
                return;
            }
            a.f35837h.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static String c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? a(str, str2, true) : (String) invokeLL.objValue;
        }

        public static boolean d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
                if (a.f35837h == null) {
                    return false;
                }
                return a.f35837h.getSharedPreferences(str, 0).contains(str2);
            }
            return invokeLL.booleanValue;
        }

        public static String a(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, str2, z)) == null) {
                if (a.f35837h == null) {
                    return null;
                }
                String string = a.f35837h.getSharedPreferences(str, 0).getString(str2, null);
                if (!TextUtils.isEmpty(string) && z) {
                    string = e.b(a(), string, string);
                    if (TextUtils.isEmpty(string)) {
                        c.a(com.alipay.sdk.cons.a.x, "tid_str: pref failed");
                    }
                }
                c.a(com.alipay.sdk.cons.a.x, "tid_str: from local");
                return string;
            }
            return (String) invokeLLZ.objValue;
        }

        public static void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
                a(str, str2, str3, true);
            }
        }

        public static void a(String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || a.f35837h == null) {
                return;
            }
            SharedPreferences sharedPreferences = a.f35837h.getSharedPreferences(str, 0);
            if (z) {
                String a2 = a();
                String a3 = e.a(a2, str3, str3);
                if (TextUtils.isEmpty(a3)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a2);
                }
                str3 = a3;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static String a() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                try {
                    str = a.f35837h.getApplicationContext().getPackageName();
                } catch (Throwable th) {
                    c.a(th);
                    str = "";
                }
                return (str + "0000000000000000000000000000").substring(0, 24);
            }
            return (String) invokeV.objValue;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35839j : (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35838i : (String) invokeV.objValue;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, str3, str4)) == null) ? TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) : invokeLLLL.booleanValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            c.a(com.alipay.sdk.cons.a.x, "tid_str: save");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f35838i = str;
            this.f35839j = str2;
            this.k = System.currentTimeMillis();
            o();
            n();
        }
    }

    private void a(String str, String str2, String str3, String str4, Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65539, this, str, str2, str3, str4, l) == null) || a(str, str2, str3, str4)) {
            return;
        }
        this.f35838i = str;
        this.f35839j = str2;
        this.l = str3;
        this.m = str4;
        if (l == null) {
            this.k = System.currentTimeMillis();
        } else {
            this.k = l.longValue();
        }
        o();
    }
}
