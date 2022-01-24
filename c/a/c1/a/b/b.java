package c.a.c1.a.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c1.a.b.a;
import c.a.c1.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.h;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static volatile b o;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public File f2605b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2606c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2607d;

    /* renamed from: e  reason: collision with root package name */
    public long f2608e;

    /* renamed from: f  reason: collision with root package name */
    public int f2609f;

    /* renamed from: g  reason: collision with root package name */
    public int f2610g;

    /* renamed from: h  reason: collision with root package name */
    public long f2611h;

    /* renamed from: i  reason: collision with root package name */
    public long f2612i;

    /* renamed from: j  reason: collision with root package name */
    public long f2613j;
    public int k;
    public int l;
    public HashMap<String, a> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1889317329, "Lc/a/c1/a/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1889317329, "Lc/a/c1/a/b/b;");
                return;
            }
        }
        n = AppConfig.isDebug();
    }

    public b() {
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
        n();
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (o == null) {
                synchronized (b.class) {
                    if (o == null) {
                        o = new b();
                    }
                }
            }
            return o;
        }
        return (b) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.f2606c;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.e();
            }
            return this.f2606c;
        }
        return invokeL.booleanValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.f2612i;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.a();
            }
            return this.f2612i;
        }
        return invokeL.longValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.l;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.b();
            }
            return this.l;
        }
        return invokeL.intValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.f2611h;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.d();
            }
            return this.f2611h;
        }
        return invokeL.longValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.f2610g;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.c();
            }
            return this.f2610g;
        }
        return invokeL.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2613j : invokeV.longValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2611h : invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2610g : invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2608e : invokeV.longValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2609f : invokeV.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/config/");
            this.f2605b = file;
            if (!file.exists()) {
                this.f2605b.mkdirs();
            }
            File file2 = new File(this.f2605b, "voyager_config.txt");
            this.a = file2;
            if (file2.exists()) {
                q();
            } else {
                r();
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2607d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f2606c : invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String f2 = c.f(this.a);
            if (n) {
                String str = "read from local: " + f2;
            }
            if (TextUtils.isEmpty(f2)) {
                r();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(f2);
                this.f2606c = jSONObject.optBoolean(h.a, c.a.c1.a.c.a.a);
                this.f2607d = jSONObject.optBoolean("c", c.a.c1.a.c.a.f2615c);
                this.f2608e = jSONObject.optLong("ui", c.a.c1.a.c.a.f2617e);
                this.f2609f = jSONObject.optInt("utc", c.a.c1.a.c.a.f2618f);
                this.f2612i = jSONObject.optLong("et", c.a.c1.a.c.a.f2619g);
                this.k = jSONObject.optInt("mfc", c.a.c1.a.c.a.f2621i);
                this.f2613j = jSONObject.optLong("mfs", c.a.c1.a.c.a.f2620h);
                this.l = jSONObject.optInt(com.alipay.sdk.sys.a.r, c.a.c1.a.c.a.l);
                this.f2610g = jSONObject.optInt("stmc", c.a.c1.a.c.a.f2622j);
                this.f2611h = jSONObject.optLong("stms", c.a.c1.a.c.a.k);
                JSONObject optJSONObject = jSONObject.optJSONObject("set");
                if (optJSONObject == null || optJSONObject.length() <= 0) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                    if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                        a g2 = new a.b(next).g();
                        if (optJSONObject2.optInt(h.a) != c.a.c1.a.c.a.n) {
                            g2.f(c.a.c1.a.c.a.a);
                        } else {
                            g2.f(c.a.c1.a.c.a.f2614b);
                        }
                        long optInt = optJSONObject2.optInt("et", 0);
                        if (optInt > 0) {
                            g2.g(optInt);
                        } else {
                            g2.g(this.f2612i);
                        }
                        int optInt2 = optJSONObject2.optInt("stmc", 0);
                        if (optInt2 > 0) {
                            g2.i(optInt2);
                        } else {
                            g2.i(this.f2610g);
                        }
                        long optLong = optJSONObject2.optLong("stms", 0L);
                        if (optLong > 0) {
                            g2.j(optLong);
                        } else {
                            g2.j(this.f2611h);
                        }
                        if (optJSONObject2.optInt(com.alipay.sdk.sys.a.r) != c.a.c1.a.c.a.m) {
                            g2.h(c.a.c1.a.c.a.l);
                        } else {
                            g2.h(c.a.c1.a.c.a.m);
                        }
                        if (!g2.e() || g2.a() != this.f2612i || g2.c() != this.f2610g || g2.d() != this.f2611h || g2.b() != this.l) {
                            if (this.m == null) {
                                this.m = new HashMap<>();
                            }
                            this.m.put(next, g2);
                        }
                    }
                }
            } catch (JSONException e2) {
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f2606c = c.a.c1.a.c.a.a;
            this.f2607d = c.a.c1.a.c.a.f2615c;
            this.f2608e = c.a.c1.a.c.a.f2617e;
            this.f2609f = c.a.c1.a.c.a.f2618f;
            this.f2612i = c.a.c1.a.c.a.f2619g;
            this.k = c.a.c1.a.c.a.f2621i;
            this.f2613j = c.a.c1.a.c.a.f2620h;
            this.f2610g = c.a.c1.a.c.a.f2622j;
            this.f2611h = c.a.c1.a.c.a.k;
            this.l = c.a.c1.a.c.a.l;
        }
    }
}
