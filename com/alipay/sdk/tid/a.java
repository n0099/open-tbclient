package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.e;
import com.alipay.sdk.util.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f31765g = "alipay_tid_storage";

    /* renamed from: h  reason: collision with root package name */
    public static final String f31766h = "tidinfo";

    /* renamed from: i  reason: collision with root package name */
    public static final String f31767i = "tid";

    /* renamed from: j  reason: collision with root package name */
    public static final String f31768j = "client_key";

    /* renamed from: k  reason: collision with root package name */
    public static final String f31769k = "timestamp";
    public static final String l = "vimei";
    public static final String m = "vimsi";
    public static Context n;
    public static a o;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f31770b;

    /* renamed from: c  reason: collision with root package name */
    public long f31771c;

    /* renamed from: d  reason: collision with root package name */
    public String f31772d;

    /* renamed from: e  reason: collision with root package name */
    public String f31773e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31774f;

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
        this.f31774f = false;
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (a.class) {
                if (o == null) {
                    o = new a();
                }
                if (n == null) {
                    o.b(context);
                }
                aVar = o;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            if (context != null) {
                n = context.getApplicationContext();
            }
            if (this.f31774f) {
                return;
            }
            this.f31774f = true;
            l();
        }
    }

    private String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            Random random = new Random();
            return hexString + (random.nextInt(9000) + 1000);
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l() {
        String str;
        String str2;
        String str3;
        String str4;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65544, this) != null) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String str5 = null;
        try {
            a = C1680a.a(f31765g, f31766h, true);
        } catch (Exception e2) {
            e = e2;
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(a)) {
            JSONObject jSONObject = new JSONObject(a);
            str = jSONObject.optString("tid", "");
            try {
                str2 = jSONObject.optString(f31768j, "");
                try {
                    valueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    str3 = jSONObject.optString(l, "");
                } catch (Exception e3) {
                    e = e3;
                    str3 = null;
                }
                try {
                    str5 = jSONObject.optString(m, "");
                } catch (Exception e4) {
                    e = e4;
                    c.a(e);
                    str4 = str5;
                    str5 = str;
                    c.b(com.alipay.sdk.cons.a.x, "tid_str: load");
                    if (!a(str5, str2, str3, str4)) {
                    }
                }
            } catch (Exception e5) {
                e = e5;
                str2 = null;
                str3 = str2;
                c.a(e);
                str4 = str5;
                str5 = str;
                c.b(com.alipay.sdk.cons.a.x, "tid_str: load");
                if (!a(str5, str2, str3, str4)) {
                }
            }
            str4 = str5;
            str5 = str;
            c.b(com.alipay.sdk.cons.a.x, "tid_str: load");
            if (!a(str5, str2, str3, str4)) {
                m();
                return;
            }
            this.a = str5;
            this.f31770b = str2;
            this.f31771c = valueOf.longValue();
            this.f31772d = str3;
            this.f31773e = str4;
            return;
        }
        str4 = null;
        str2 = null;
        str3 = null;
        c.b(com.alipay.sdk.cons.a.x, "tid_str: load");
        if (!a(str5, str2, str3, str4)) {
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.a = "";
            this.f31770b = b();
            this.f31771c = System.currentTimeMillis();
            this.f31772d = k();
            this.f31773e = k();
            C1680a.b(f31765g, f31766h);
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tid", this.a);
                jSONObject.put(f31768j, this.f31770b);
                jSONObject.put("timestamp", this.f31771c);
                jSONObject.put(l, this.f31772d);
                jSONObject.put(m, this.f31773e);
                C1680a.a(f31765g, f31766h, jSONObject.toString(), true);
            } catch (Exception e2) {
                c.a(e2);
            }
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31770b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public Long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Long.valueOf(this.f31771c) : (Long) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31772d : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31773e : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? i() : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f31770b) || TextUtils.isEmpty(this.f31772d) || TextUtils.isEmpty(this.f31773e) : invokeV.booleanValue;
    }

    /* renamed from: com.alipay.sdk.tid.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1680a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1680a() {
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
                if (a.n == null) {
                    return false;
                }
                return a.n.getSharedPreferences(str, 0).contains(str2);
            }
            return invokeLL.booleanValue;
        }

        public static void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) || a.n == null) {
                return;
            }
            a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static boolean c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
                if (a.n == null) {
                    return false;
                }
                return a.n.getSharedPreferences(str, 0).contains(str2);
            }
            return invokeLL.booleanValue;
        }

        public static String d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? a(str, str2, true) : (String) invokeLL.objValue;
        }

        public static String a(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, str2, z)) == null) {
                if (a.n == null) {
                    return null;
                }
                String string = a.n.getSharedPreferences(str, 0).getString(str2, null);
                if (!TextUtils.isEmpty(string) && z) {
                    string = e.a(a(), string, string);
                    if (TextUtils.isEmpty(string)) {
                        c.b(com.alipay.sdk.cons.a.x, "tid_str: pref failed");
                    }
                }
                c.b(com.alipay.sdk.cons.a.x, "tid_str: from local");
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
            if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || a.n == null) {
                return;
            }
            SharedPreferences sharedPreferences = a.n.getSharedPreferences(str, 0);
            if (z) {
                String a = a();
                String b2 = e.b(a, str3, str3);
                if (TextUtils.isEmpty(b2)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a);
                }
                str3 = b2;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static String a() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                try {
                    str = a.n.getApplicationContext().getPackageName();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
        }
        return (String) invokeV.objValue;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, str3, str4)) == null) ? TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) : invokeLLLL.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b(com.alipay.sdk.cons.a.x, "tid_str: del");
            m();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            c.b(com.alipay.sdk.cons.a.x, "tid_str: save");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.a = str;
            this.f31770b = str2;
            this.f31771c = System.currentTimeMillis();
            n();
            o();
        }
    }

    private void a(String str, String str2, String str3, String str4, Long l2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65539, this, str, str2, str3, str4, l2) == null) || a(str, str2, str3, str4)) {
            return;
        }
        this.a = str;
        this.f31770b = str2;
        this.f31772d = str3;
        this.f31773e = str4;
        if (l2 == null) {
            this.f31771c = System.currentTimeMillis();
        } else {
            this.f31771c = l2.longValue();
        }
        n();
    }
}
