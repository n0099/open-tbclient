package c.a.j0.b.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
        public ArrayList<C0206a> f4289b;

        /* renamed from: c.a.j0.b.f.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0206a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long a;

            /* renamed from: b  reason: collision with root package name */
            public long f4290b;

            public C0206a(long j2, long j3) {
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
                this.f4290b = j3;
            }

            public boolean a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? j2 >= this.a && j2 <= this.f4290b : invokeJ.booleanValue;
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
            this.f4289b = new ArrayList<>();
            this.a = jSONObject.optLong("expires", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("schedule");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    this.f4289b.add(new C0206a(optJSONObject.optLong("start", 0L), optJSONObject.optLong("end", 0L)));
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
                if (c.a.d0.x.a.k(this.f4289b) == 0) {
                    return false;
                }
                Iterator<C0206a> it = this.f4289b.iterator();
                while (it.hasNext()) {
                    C0206a next = it.next();
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

    public static void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("md5_check_switch", i2);
        }
    }

    public static void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("monitor_log_switch", i2);
        }
    }

    public static void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("query_time_out_advance", i2);
        }
    }

    public static void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("request_count", i2);
        }
    }

    public static void E(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                u(optJSONObject);
            }
            C(jSONObject.optInt("query_time_out_advance", 100));
            y((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
            r(jSONObject.optInt("open_bes_switch", 0));
            A(jSONObject.optInt("md5_check_switch", 0));
            D(jSONObject.optInt("request_count", 10));
            B(jSONObject.optInt("monitor_log_switch", 1));
            z(jSONObject.optString("inner_monitor_host", "https://sp0.baidu.com"));
            t(jSONObject.optInt("crash_opt", 1));
            s(jSONObject.optString("cpt_config", ""));
        } catch (JSONException unused) {
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            JSONObject d2 = c.a.j0.a.b.d.a().d();
            if (d2 == null || !d2.has("cpc_show_scene")) {
                return true;
            }
            int optInt = d2.optInt("cpc_show_scene", 0);
            return optInt != 1 ? optInt != 2 || i2 == 1 : i2 == 0;
        }
        return invokeI.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c(false) : invokeV.booleanValue;
    }

    public static boolean c(boolean z) {
        InterceptResult invokeZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65543, null, z)) == null) {
            a e2 = e();
            if (e2 == null) {
                i2 = w0.r6;
            } else if (e2.f()) {
                i2 = e2.d() ? w0.t6 : 0;
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

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            JSONObject d2 = c.a.j0.a.b.d.a().d();
            if (d2 == null || !d2.has("cpc_show_times")) {
                return Integer.MAX_VALUE;
            }
            return d2.optInt("cpc_show_times");
        }
        return invokeV.intValue;
    }

    @Nullable
    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (a == null) {
                a = f();
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String string = c.a.d0.y.e.a().b("splash_sp_name").getString("cpt_config", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return a.c(c.a.d0.x.b.b(string));
        }
        return (a) invokeV.objValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getInt("hot_splash_max_count", 3) : invokeV.intValue;
    }

    public static float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getFloat("hot_background_time", 5.0f) : invokeV.floatValue;
    }

    public static float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getFloat("hot_update_split_time", 5.0f) : invokeV.floatValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getString("inner_monitor_host", "https://sp0.baidu.com") : (String) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getInt("md5_check_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getInt("monitor_log_switch", 1) == 1 : invokeV.booleanValue;
    }

    @NonNull
    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (q()) {
                return o();
            }
            return c.a.j0.a.b.d.a().e();
        }
        return (String) invokeV.objValue;
    }

    public static int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getInt("query_time_out_advance", 100) : invokeV.intValue;
    }

    @NonNull
    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            JSONObject d2 = c.a.j0.a.b.d.a().d();
            return (d2 == null || !d2.has("query_unite_pid")) ? "" : d2.optString("query_unite_pid", "");
        }
        return (String) invokeV.objValue;
    }

    public static int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getInt("request_count", 10) : invokeV.intValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? c.a.d0.l.h.b().info().a("query_uniform_enable", 0) == 1 && !TextUtils.isEmpty(o()) : invokeV.booleanValue;
    }

    public static void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("open_bes_switch", i2);
        }
    }

    public static void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        a = a.c(c.a.d0.x.b.b(str));
        c.a.d0.y.e.a().b("splash_sp_name").i("cpt_config", str);
    }

    public static void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65560, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("crash_opt", i2);
        }
    }

    public static void u(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, jSONObject) == null) {
            x((float) jSONObject.optDouble("hot_background_time", 5.0d));
            v(jSONObject.optInt("hot_splash_max_count", 3));
            w(jSONObject.optInt("hot_switch", 1));
        }
    }

    public static void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65562, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("hot_splash_max_count", i2);
        }
    }

    public static void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65563, null, i2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").g("hot_switch", 1);
        }
    }

    public static void x(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65564, null, f2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").f("hot_background_time", f2);
        }
    }

    public static void y(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65565, null, f2) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").f("hot_update_split_time", f2);
        }
    }

    public static void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.d0.y.e.a().b("splash_sp_name").j("inner_monitor_host", str, false);
    }
}
