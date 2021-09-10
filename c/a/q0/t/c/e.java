package c.a.q0.t.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f14650a = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1672264679, "Lc/a/q0/t/c/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1672264679, "Lc/a/q0/t/c/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int k = c.a.q0.s.d0.b.j().k("pref_key_fun_ad_first_floor_min", 2);
            int k2 = c.a.q0.s.d0.b.j().k("pref_key_fun_ad_first_floor_max", 3);
            if (k < k2) {
                f14650a = c.a.r0.h1.a.a.a(k, k2);
            } else {
                f14650a = c.a.r0.h1.a.a.a(k2, k);
            }
            if (f14650a < 0) {
                f14650a = 2;
            }
            return f14650a;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f14650a < 0) {
                f14650a = 2;
            }
            return f14650a;
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int k = c.a.q0.s.d0.b.j().k("pref_key_fun_ad_density", 6);
            if (k > 0) {
                return k;
            }
            return 6;
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? c.a.q0.s.d0.b.j().k("pref_key_fun_ad_frs_density", 5) : invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? c.a.q0.s.d0.b.j().k("pref_key_fun_ad_frs_first_floor", 2) : invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a.q0.s.d0.b.j().k("key_pb_comment_bear_density", 6) : invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int k = c.a.q0.s.d0.b.j().k("key_pb_comment_bear_first", 4);
            if (k <= 0) {
                return 4;
            }
            return k;
        }
        return invokeV.intValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.q0.s.d0.b.j().k("key_pb_comment_bear_maxsize", 1) : invokeV.intValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.q0.s.d0.b.j().k("key_video_middle_density", 4) : invokeV.intValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            int k = c.a.q0.s.d0.b.j().k("key_video_middle_first", 2);
            if (k <= 0) {
                return 2;
            }
            return k;
        }
        return invokeV.intValue;
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
            int optInt2 = jSONObject.optInt("frs_bear_density", 5);
            c.a.q0.s.d0.b.j().v("pref_key_fun_ad_frs_first_floor", optInt);
            c.a.q0.s.d0.b.j().v("pref_key_fun_ad_frs_density", optInt2);
            int optInt3 = jSONObject.optInt("index_bear_density", 6);
            int optInt4 = jSONObject.optInt("index_bear_first_floor_max", 3);
            int optInt5 = jSONObject.optInt("index_bear_first_floor_min", 2);
            c.a.q0.s.d0.b.j().v("pref_key_fun_ad_density", optInt3);
            c.a.q0.s.d0.b.j().v("pref_key_fun_ad_first_floor_max", optInt4);
            c.a.q0.s.d0.b.j().v("pref_key_fun_ad_first_floor_min", optInt5);
            int optInt6 = jSONObject.optInt("video_bear_density", 4);
            int optInt7 = jSONObject.optInt("video_bear_first_floor", 2);
            c.a.q0.s.d0.b.j().v("key_video_middle_density", optInt6);
            c.a.q0.s.d0.b.j().v("key_video_middle_first", optInt7);
            int optInt8 = jSONObject.optInt("pb_comment_bear_density", 6);
            int optInt9 = jSONObject.optInt("pb_comment_bear_first_floor", 4);
            int optInt10 = jSONObject.optInt("pb_comment_bear_max_size", 1);
            c.a.q0.s.d0.b.j().v("key_pb_comment_bear_density", optInt8);
            c.a.q0.s.d0.b.j().v("key_pb_comment_bear_first", optInt9);
            c.a.q0.s.d0.b.j().v("key_pb_comment_bear_maxsize", optInt10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
