package c.a.n0.a.g1;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.d.m;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.e;
import c.a.n0.a.w0.f;
import c.a.n0.u.l;
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
    public static final boolean f4550c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f4551b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1211140266, "Lc/a/n0/a/g1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1211140266, "Lc/a/n0/a/g1/a;");
                return;
            }
        }
        f4550c = c.a.n0.a.a.a;
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
                return;
            }
        }
        this.f4551b = null;
        this.a = AppRuntime.getAppContext();
    }

    @Override // c.a.n0.u.l
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.n0.a.s0.a.n().a() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.n0.a.b.a() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public boolean c(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            m g0 = c.a.n0.a.s0.a.g0();
            if (g0 != null) {
                g0.getSwitch("ANDROID_UBC_SAMPLE_" + str, "");
            }
            if (TextUtils.isEmpty("")) {
                return false;
            }
            try {
                i = new JSONObject("").getInt("probability");
            } catch (JSONException e2) {
                e2.printStackTrace();
                i = 0;
            }
            return new Random().nextInt(100) < i;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.u.l
    public ExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.n0.a.s0.a.z0().d() : (ExecutorService) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public void e(String str, int i, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, jSONArray) == null) {
            c.a.n0.a.s0.a.z0().e(str, i, jSONArray);
        }
    }

    @Override // c.a.n0.u.l
    public void f(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            c.a.n0.a.s0.a.z0().f(str, i);
        }
    }

    @Override // c.a.n0.u.l
    public void g(String str, String str2, int i, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)}) == null) {
            c.a.n0.a.s0.a.z0().g(str, str2, i, str3, i2);
        }
    }

    @Override // c.a.n0.u.l
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e D = f.U().D();
            return D != null ? D.f6344b : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e D = f.U().D();
            return D != null ? D.X().v1() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? c.a.n0.a.s0.a.h0().i(c.a.n0.a.s0.a.c()) : (String) invokeL.objValue;
    }

    @Override // c.a.n0.u.l
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            m g0 = c.a.n0.a.s0.a.g0();
            return g0 != null ? g0.p() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public void i(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i, str2) == null) {
            c.a.n0.a.s0.a.z0().i(str, i, str2);
        }
    }

    @Override // c.a.n0.u.l
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.n0.a.s0.a.g0().j() : invokeV.booleanValue;
    }

    @Override // c.a.n0.u.l
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            e D = f.U().D();
            return D != null ? D.V().T() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? d.J().l() : invokeV.intValue;
    }

    @Override // c.a.n0.u.l
    public c.a.n0.u.m m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.n0.a.s0.a.O().m() : (c.a.n0.u.m) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? c.a.n0.a.g2.b.h(l()) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public void o(String str, String str2, int i, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            c.a.n0.a.s0.a.z0().o(str, str2, i, str3, j, i2);
        }
    }

    @Override // c.a.n0.u.l
    public String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) ? c.a.n0.x.b.b(context).a() : (String) invokeL.objValue;
    }

    @Override // c.a.n0.u.l
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f4551b == null) {
                c.a.n0.a.s0.a.g0().getSwitch("swan_ceres_add_counter", false);
                this.f4551b = false;
            }
            return this.f4551b.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.u.l
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? c.a.n0.a.n1.a.a.X() && (s() || c.a.n0.a.a.f3847b) : invokeV.booleanValue;
    }

    @Override // c.a.n0.u.l
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return f4550c && PreferenceManager.getDefaultSharedPreferences(c.a.n0.a.s0.a.c()).getBoolean("KEY_UBC_DEBUG", true);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.u.l
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String b2 = c.a.n0.a.s0.a.n().b();
            if (q0.G() || TextUtils.isEmpty(b2)) {
                return null;
            }
            return b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? c.a.n0.a.t.a.b() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.u.l
    public String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) ? c.a.n0.a.s0.a.h0().h(c.a.n0.a.s0.a.c()) : (String) invokeL.objValue;
    }
}
