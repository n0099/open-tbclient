package c.a.o0.s.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(963577127, "Lc/a/o0/s/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(963577127, "Lc/a/o0/s/c/d;");
        }
    }

    public d() {
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

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int l = c.a.o0.r.j0.b.k().l("pref_key_fun_ad_first_floor_min", 2);
            int l2 = c.a.o0.r.j0.b.k().l("pref_key_fun_ad_first_floor_max", 3);
            if (l < l2) {
                a = c.a.p0.r1.a.a.a(l, l2);
            } else {
                a = c.a.p0.r1.a.a.a(l2, l);
            }
            if (a < 0) {
                a = 2;
            }
            return a;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.o0.r.j0.b.k().l("fun_ad_big_image_density", 6) : invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.o0.r.j0.b.k().l("fun_ad_big_image_floor", 5) : invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.a.o0.r.j0.b.k().l("fun_ad_big_image_size", 1) : invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (a < 0) {
                a = 2;
            }
            return a;
        }
        return invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            int l = c.a.o0.r.j0.b.k().l("pref_key_fun_ad_density", 6);
            if (l > 0) {
                return l;
            }
            return 6;
        }
        return invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c.a.o0.r.j0.b.k().l("pref_key_fun_ad_frs_density", 5) : invokeV.intValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.o0.r.j0.b.k().l("pref_key_fun_ad_frs_first_floor", 2) : invokeV.intValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.o0.r.j0.b.k().l("key_pb_comment_bear_density", 6) : invokeV.intValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            int l = c.a.o0.r.j0.b.k().l("key_pb_comment_bear_first", 4);
            if (l <= 0) {
                return 4;
            }
            return l;
        }
        return invokeV.intValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.a.o0.r.j0.b.k().l("key_pb_comment_bear_maxsize", 1) : invokeV.intValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? c.a.o0.r.j0.b.k().l("key_video_middle_density", 4) : invokeV.intValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            int l = c.a.o0.r.j0.b.k().l("key_video_middle_first", 2);
            if (l <= 0) {
                return 2;
            }
            return l;
        }
        return invokeV.intValue;
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
            int optInt2 = jSONObject.optInt("frs_bear_density", 5);
            c.a.o0.r.j0.b.k().w("pref_key_fun_ad_frs_first_floor", optInt);
            c.a.o0.r.j0.b.k().w("pref_key_fun_ad_frs_density", optInt2);
            int optInt3 = jSONObject.optInt("index_bear_density", 6);
            int optInt4 = jSONObject.optInt("index_bear_first_floor_max", 3);
            int optInt5 = jSONObject.optInt("index_bear_first_floor_min", 2);
            c.a.o0.r.j0.b.k().w("pref_key_fun_ad_density", optInt3);
            c.a.o0.r.j0.b.k().w("pref_key_fun_ad_first_floor_max", optInt4);
            c.a.o0.r.j0.b.k().w("pref_key_fun_ad_first_floor_min", optInt5);
            int optInt6 = jSONObject.optInt("video_bear_density", 4);
            int optInt7 = jSONObject.optInt("video_bear_first_floor", 2);
            c.a.o0.r.j0.b.k().w("key_video_middle_density", optInt6);
            c.a.o0.r.j0.b.k().w("key_video_middle_first", optInt7);
            int optInt8 = jSONObject.optInt("pb_comment_bear_density", 6);
            int optInt9 = jSONObject.optInt("pb_comment_bear_first_floor", 4);
            int optInt10 = jSONObject.optInt("pb_comment_bear_max_size", 1);
            c.a.o0.r.j0.b.k().w("key_pb_comment_bear_density", optInt8);
            c.a.o0.r.j0.b.k().w("key_pb_comment_bear_first", optInt9);
            c.a.o0.r.j0.b.k().w("key_pb_comment_bear_maxsize", optInt10);
            int optInt11 = jSONObject.optInt("picpage_bear_first_floor", 5);
            int optInt12 = jSONObject.optInt("picpage_bear_density", 6);
            int optInt13 = jSONObject.optInt("picpage_bear_max_size", 1);
            int optInt14 = jSONObject.optInt("picpage_bear_last_frame_switch", 0);
            c.a.o0.r.j0.b.k().w("fun_ad_big_image_floor", optInt11);
            c.a.o0.r.j0.b.k().w("fun_ad_big_image_density", optInt12);
            c.a.o0.r.j0.b.k().w("fun_ad_big_image_size", optInt13);
            c.a.o0.r.j0.b.k().w("fun_ad_big_image_switch", optInt14);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
