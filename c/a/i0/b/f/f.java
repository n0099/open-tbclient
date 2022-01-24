package c.a.i0.b.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C0168a> f3920b;

        /* renamed from: c.a.i0.b.f.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0168a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long a;

            /* renamed from: b  reason: collision with root package name */
            public long f3921b;

            public C0168a(long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j2;
                this.f3921b = j3;
            }

            public boolean a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? j2 >= this.a && j2 <= this.f3921b : invokeJ.booleanValue;
            }
        }

        public a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3920b = new ArrayList<>();
            this.a = jSONObject.optLong("expires", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("schedule");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    this.f3920b.add(new C0168a(optJSONObject.optLong("start", 0L), optJSONObject.optLong("end", 0L)));
                }
            }
        }

        @Nullable
        public static a c(@Nullable JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    return new a(jSONObject);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (a) invokeL.objValue;
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e(System.currentTimeMillis() / 1000) : invokeV.booleanValue;
        }

        public final boolean e(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                if (c.a.c0.x.a.k(this.f3920b) == 0) {
                    return false;
                }
                Iterator<C0168a> it = this.f3920b.iterator();
                while (it.hasNext()) {
                    C0168a next = it.next();
                    if (next != null && next.a(j2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? g(System.currentTimeMillis() / 1000) : invokeV.booleanValue;
        }

        public final boolean g(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? this.a > j2 : invokeJ.booleanValue;
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b(false) : invokeV.booleanValue;
    }

    public static boolean b(boolean z) {
        InterceptResult invokeZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            a c2 = c();
            if (c2 == null) {
                i2 = w0.r6;
            } else if (c2.f()) {
                i2 = c2.d() ? w0.t6 : 0;
            } else {
                i2 = 13002;
            }
            if (i2 != 0 && z) {
                BaseVM.k(i2);
            }
            return i2 == 0;
        }
        return invokeZ.booleanValue;
    }

    @Nullable
    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = d();
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String f2 = c.a.i0.a.c.i.f("cpt_config", "");
            if (TextUtils.isEmpty(f2)) {
                return null;
            }
            return a.c(c.a.c0.x.b.b(f2));
        }
        return (a) invokeV.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.i0.a.c.i.c("hot_splash_max_count", 3) : invokeV.intValue;
    }

    public static float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.a.i0.a.c.i.b("hot_background_time", 5.0f) : invokeV.floatValue;
    }

    public static float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.a.i0.a.c.i.b("hot_update_split_time", 5.0f) : invokeV.floatValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a.i0.a.c.i.f("inner_monitor_host", "https://sp0.baidu.com") : (String) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c.a.i0.a.c.i.c("md5_check_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.i0.a.c.i.c("monitor_log_switch", 1) == 1 : invokeV.booleanValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.i0.a.c.i.c("query_time_out_advance", 100) : invokeV.intValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c.a.i0.a.c.i.c("request_count", 10) : invokeV.intValue;
    }

    public static void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, null, i2) == null) {
            c.a.i0.a.c.i.h("open_bes_switch", i2);
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        a = a.c(c.a.c0.x.b.b(str));
        c.a.i0.a.c.i.j("cpt_config", str);
    }

    public static void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            c.a.i0.a.c.i.h("crash_opt", i2);
        }
    }

    public static void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, jSONObject) == null) {
            s((float) jSONObject.optDouble("hot_background_time", 5.0d));
            q(jSONObject.optInt("hot_splash_max_count", 3));
            r(jSONObject.optInt("hot_switch", 1));
        }
    }

    public static void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, null, i2) == null) {
            c.a.i0.a.c.i.h("hot_splash_max_count", i2);
        }
    }

    public static void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, null, i2) == null) {
            c.a.i0.a.c.i.h("hot_switch", 1);
        }
    }

    public static void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65554, null, f2) == null) {
            c.a.i0.a.c.i.g("hot_background_time", f2);
        }
    }

    public static void t(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65555, null, f2) == null) {
            c.a.i0.a.c.i.g("hot_update_split_time", f2);
        }
    }

    public static void u(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.i0.a.c.i.j("inner_monitor_host", str);
    }

    public static void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, null, i2) == null) {
            c.a.i0.a.c.i.h("md5_check_switch", i2);
        }
    }

    public static void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            c.a.i0.a.c.i.h("monitor_log_switch", i2);
        }
    }

    public static void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, null, i2) == null) {
            c.a.i0.a.c.i.h("query_time_out_advance", i2);
        }
    }

    public static void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65560, null, i2) == null) {
            c.a.i0.a.c.i.h("request_count", i2);
        }
    }

    public static void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                p(optJSONObject);
            }
            x(jSONObject.optInt("query_time_out_advance", 100));
            t((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
            m(jSONObject.optInt("open_bes_switch", 0));
            v(jSONObject.optInt("md5_check_switch", 0));
            y(jSONObject.optInt("request_count", 10));
            w(jSONObject.optInt("monitor_log_switch", 1));
            u(jSONObject.optString("inner_monitor_host", "https://sp0.baidu.com"));
            o(jSONObject.optInt("crash_opt", 1));
            n(jSONObject.optString("cpt_config", ""));
        } catch (JSONException unused) {
        }
    }
}
