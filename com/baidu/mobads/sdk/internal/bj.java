package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bj {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "mobads_builds";
    public static final String b = "brand_period";
    public static final String c = "version_period";
    public static final long d = 604800000;
    public static final long e = 172800000;
    public static final String f = "sdk_int";
    public static final String g = "sdk";
    public static final String h = "release";
    public static final String i = "model";
    public static final String j = "brand";
    public static final String k = "netopera";
    public static final String l = "tags";
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public Context t;
    public SharedPreferences u;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final bj a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1243038186, "Lcom/baidu/mobads/sdk/internal/bj$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1243038186, "Lcom/baidu/mobads/sdk/internal/bj$a;");
                    return;
                }
            }
            a = new bj(null);
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
    }

    public bj() {
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
        this.m = 0;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
    }

    public /* synthetic */ bj(bk bkVar) {
        this();
    }

    public static bj a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            a.a.b(context);
            return a.a;
        }
        return (bj) invokeL.objValue;
    }

    private Long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            try {
                return Long.valueOf(this.u.getLong(str, 0L));
            } catch (Throwable th) {
                br.a().c(th.getMessage());
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    private int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            try {
                return this.u.getInt(str, 0);
            } catch (Throwable th) {
                br.a().c(th.getMessage());
                return 0;
            }
        }
        return invokeL.intValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            try {
                return this.u.getString(str, "");
            } catch (Throwable th) {
                br.a().c(th.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(9)
    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i2) == null) {
            try {
                SharedPreferences.Editor k2 = k();
                k2.putInt(str, i2);
                k2.apply();
            } catch (Throwable th) {
                br.a().c(th.getMessage());
            }
        }
    }

    @TargetApi(9)
    private void a(String str, Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, l2) == null) {
            try {
                SharedPreferences.Editor k2 = k();
                k2.putLong(str, l2.longValue());
                k2.apply();
            } catch (Throwable th) {
                br.a().c(th.getMessage());
            }
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) {
            try {
                SharedPreferences.Editor k2 = k();
                k2.putString(str, str2);
                k2.apply();
            } catch (Throwable th) {
                br.a().c(th.getMessage());
            }
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            i();
            j();
        }
    }

    private SharedPreferences.Editor k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return this.u.edit();
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.m == 0) {
                this.m = Build.VERSION.SDK_INT;
            }
            return this.m;
        }
        return invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.n)) {
                this.n = Build.VERSION.SDK;
            }
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                if (System.currentTimeMillis() > b(b).longValue()) {
                    this.p = Build.MODEL;
                    this.q = Build.BRAND;
                    this.r = ((TelephonyManager) this.t.getSystemService("phone")).getNetworkOperator();
                    this.s = Build.TAGS;
                    a("model", this.p);
                    a("brand", this.q);
                    a(k, this.r);
                    a("tags", this.s);
                    a(b, Long.valueOf(System.currentTimeMillis() + 604800000));
                } else {
                    this.p = a("model");
                    this.q = a("brand");
                    this.r = a(k);
                    this.s = a("tags");
                }
            } catch (Throwable th) {
                br.a().c(th.getMessage());
            }
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                if (System.currentTimeMillis() > b(c).longValue()) {
                    int i2 = Build.VERSION.SDK_INT;
                    this.m = i2;
                    this.n = Build.VERSION.SDK;
                    this.o = Build.VERSION.RELEASE;
                    a(f, i2);
                    a("sdk", this.n);
                    a("release", this.o);
                    a(c, Long.valueOf(System.currentTimeMillis() + e));
                } else {
                    this.m = c(f);
                    this.n = a("sdk");
                    this.o = a("release");
                }
            } catch (Throwable th) {
                br.a().c(th.getMessage());
            }
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (this.t == null && context != null) {
                Context applicationContext = context.getApplicationContext();
                this.t = applicationContext;
                try {
                    if (this.u == null) {
                        this.u = applicationContext.getSharedPreferences(a, 0);
                        h();
                    }
                } catch (Throwable th) {
                    br.a().c(th.getMessage());
                }
            } else if (a.a == null) {
                ay.a(context);
            }
        }
    }
}
