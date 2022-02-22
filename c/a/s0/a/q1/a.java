package c.a.s0.a.q1;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d2.d;
import c.a.s0.a.d2.e;
import c.a.s0.a.g1.f;
import c.a.s0.a.k;
import c.a.s0.a.p.d.m;
import c.a.s0.a.z2.q0;
import c.a.s0.u.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8651c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f8652b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(237807951, "Lc/a/s0/a/q1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(237807951, "Lc/a/s0/a/q1/a;");
                return;
            }
        }
        f8651c = k.a;
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
        this.f8652b = null;
        this.a = AppRuntime.getAppContext();
    }

    @Override // c.a.s0.u.l
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.s0.a.c1.a.n().a() : (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.s0.a.l.a() : (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public boolean c(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            m g0 = c.a.s0.a.c1.a.g0();
            if (g0 != null) {
                g0.getSwitch("ANDROID_UBC_SAMPLE_" + str, "");
            }
            if (TextUtils.isEmpty("")) {
                return false;
            }
            try {
                i2 = new JSONObject("").getInt("probability");
            } catch (JSONException e2) {
                e2.printStackTrace();
                i2 = 0;
            }
            return new Random().nextInt(100) < i2;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.u.l
    public ExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.s0.a.c1.a.z0().d() : (ExecutorService) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public void e(String str, int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, jSONArray) == null) {
            c.a.s0.a.c1.a.z0().e(str, i2, jSONArray);
        }
    }

    @Override // c.a.s0.u.l
    public void f(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            c.a.s0.a.c1.a.z0().f(str, i2);
        }
    }

    @Override // c.a.s0.u.l
    public void g(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            c.a.s0.a.c1.a.z0().g(str, str2, i2, str3, i3);
        }
    }

    @Override // c.a.s0.u.l
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e D = f.U().D();
            return D != null ? D.f5779f : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e D = f.U().D();
            return D != null ? D.X().v1() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? c.a.s0.a.c1.a.h0().i(c.a.s0.a.c1.a.c()) : (String) invokeL.objValue;
    }

    @Override // c.a.s0.u.l
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            m g0 = c.a.s0.a.c1.a.g0();
            return g0 != null ? g0.p() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public void i(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i2, str2) == null) {
            c.a.s0.a.c1.a.z0().i(str, i2, str2);
        }
    }

    @Override // c.a.s0.u.l
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.s0.a.c1.a.g0().j() : invokeV.booleanValue;
    }

    @Override // c.a.s0.u.l
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            e D = f.U().D();
            return D != null ? D.V().T() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? d.J().l() : invokeV.intValue;
    }

    @Override // c.a.s0.u.l
    public c.a.s0.u.m m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.s0.a.c1.a.O().m() : (c.a.s0.u.m) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? c.a.s0.a.q2.b.h(l()) : (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public void o(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            c.a.s0.a.c1.a.z0().o(str, str2, i2, str3, j2, i3);
        }
    }

    @Override // c.a.s0.u.l
    public String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) ? c.a.s0.x.b.b(context).a() : (String) invokeL.objValue;
    }

    @Override // c.a.s0.u.l
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f8652b == null) {
                c.a.s0.a.c1.a.g0().getSwitch("swan_ceres_add_counter", false);
                this.f8652b = false;
            }
            return this.f8652b.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.u.l
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? c.a.s0.a.x1.a.a.X() && (s() || k.f7795b) : invokeV.booleanValue;
    }

    @Override // c.a.s0.u.l
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return f8651c && PreferenceManager.getDefaultSharedPreferences(c.a.s0.a.c1.a.c()).getBoolean("KEY_UBC_DEBUG", true);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.u.l
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String b2 = c.a.s0.a.c1.a.n().b();
            if (q0.G() || TextUtils.isEmpty(b2)) {
                return null;
            }
            return b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? c.a.s0.a.d0.a.b() : (String) invokeV.objValue;
    }

    @Override // c.a.s0.u.l
    public String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) ? c.a.s0.a.c1.a.h0().h(c.a.s0.a.c1.a.c()) : (String) invokeL.objValue;
    }
}
