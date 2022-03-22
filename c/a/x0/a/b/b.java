package c.a.x0.a.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.a.b.a;
import c.a.x0.c.c;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static volatile b o;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public File f22022b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22023c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22024d;

    /* renamed from: e  reason: collision with root package name */
    public long f22025e;

    /* renamed from: f  reason: collision with root package name */
    public int f22026f;

    /* renamed from: g  reason: collision with root package name */
    public int f22027g;

    /* renamed from: h  reason: collision with root package name */
    public long f22028h;
    public long i;
    public long j;
    public int k;
    public int l;
    public HashMap<String, a> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1361001573, "Lc/a/x0/a/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1361001573, "Lc/a/x0/a/b/b;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                return this.f22023c;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.e();
            }
            return this.f22023c;
        }
        return invokeL.booleanValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.i;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.a();
            }
            return this.i;
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
                return this.f22028h;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.d();
            }
            return this.f22028h;
        }
        return invokeL.longValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.f22027g;
            }
            HashMap<String, a> hashMap = this.m;
            if (hashMap != null && (aVar = hashMap.get(str)) != null) {
                return aVar.c();
            }
            return this.f22027g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.longValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22028h : invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22027g : invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22025e : invokeV.longValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22026f : invokeV.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/config/");
            this.f22022b = file;
            if (!file.exists()) {
                this.f22022b.mkdirs();
            }
            File file2 = new File(this.f22022b, "voyager_config.txt");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f22024d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f22023c : invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String f2 = c.f(this.a);
            if (n) {
                Log.d("VoyagerConfig", "read from local: " + f2);
            }
            if (TextUtils.isEmpty(f2)) {
                r();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(f2);
                this.f22023c = jSONObject.optBoolean("en", c.a.x0.a.c.a.a);
                this.f22024d = jSONObject.optBoolean("c", c.a.x0.a.c.a.f22030c);
                this.f22025e = jSONObject.optLong("ui", c.a.x0.a.c.a.f22032e);
                this.f22026f = jSONObject.optInt("utc", c.a.x0.a.c.a.f22033f);
                this.i = jSONObject.optLong("et", c.a.x0.a.c.a.f22034g);
                this.k = jSONObject.optInt("mfc", c.a.x0.a.c.a.i);
                this.j = jSONObject.optLong("mfs", c.a.x0.a.c.a.f22035h);
                this.l = jSONObject.optInt("an", c.a.x0.a.c.a.l);
                this.f22027g = jSONObject.optInt("stmc", c.a.x0.a.c.a.j);
                this.f22028h = jSONObject.optLong("stms", c.a.x0.a.c.a.k);
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
                        if (optJSONObject2.optInt("en") != c.a.x0.a.c.a.n) {
                            g2.f(c.a.x0.a.c.a.a);
                        } else {
                            g2.f(c.a.x0.a.c.a.f22029b);
                        }
                        long optInt = optJSONObject2.optInt("et", 0);
                        if (optInt > 0) {
                            g2.g(optInt);
                        } else {
                            g2.g(this.i);
                        }
                        int optInt2 = optJSONObject2.optInt("stmc", 0);
                        if (optInt2 > 0) {
                            g2.i(optInt2);
                        } else {
                            g2.i(this.f22027g);
                        }
                        long optLong = optJSONObject2.optLong("stms", 0L);
                        if (optLong > 0) {
                            g2.j(optLong);
                        } else {
                            g2.j(this.f22028h);
                        }
                        if (optJSONObject2.optInt("an") != c.a.x0.a.c.a.m) {
                            g2.h(c.a.x0.a.c.a.l);
                        } else {
                            g2.h(c.a.x0.a.c.a.m);
                        }
                        if (!g2.e() || g2.a() != this.i || g2.c() != this.f22027g || g2.d() != this.f22028h || g2.b() != this.l) {
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
            this.f22023c = c.a.x0.a.c.a.a;
            this.f22024d = c.a.x0.a.c.a.f22030c;
            this.f22025e = c.a.x0.a.c.a.f22032e;
            this.f22026f = c.a.x0.a.c.a.f22033f;
            this.i = c.a.x0.a.c.a.f22034g;
            this.k = c.a.x0.a.c.a.i;
            this.j = c.a.x0.a.c.a.f22035h;
            this.f22027g = c.a.x0.a.c.a.j;
            this.f22028h = c.a.x0.a.c.a.k;
            this.l = c.a.x0.a.c.a.l;
        }
    }
}
