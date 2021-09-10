package c.a.p0.a.o1;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.d;
import c.a.p0.a.a2.e;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.a.p.d.m;
import c.a.p0.a.v2.q0;
import c.a.p0.r.l;
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
    public static final boolean f7818c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f7819a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f7820b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(825501424, "Lc/a/p0/a/o1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(825501424, "Lc/a/p0/a/o1/a;");
                return;
            }
        }
        f7818c = k.f7077a;
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
        this.f7820b = null;
        this.f7819a = AppRuntime.getAppContext();
    }

    @Override // c.a.p0.r.l
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.p0.a.c1.a.m().a() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.p0.a.l.a() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public boolean c(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            m Z = c.a.p0.a.c1.a.Z();
            if (Z != null) {
                Z.getSwitch("ANDROID_UBC_SAMPLE_" + str, "");
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

    @Override // c.a.p0.r.l
    public ExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.p0.a.c1.a.p0().d() : (ExecutorService) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public void e(String str, int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, jSONArray) == null) {
            c.a.p0.a.c1.a.p0().e(str, i2, jSONArray);
        }
    }

    @Override // c.a.p0.r.l
    public void f(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            c.a.p0.a.c1.a.p0().f(str, i2);
        }
    }

    @Override // c.a.p0.r.l
    public void g(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            c.a.p0.a.c1.a.p0().g(str, str2, i2, str3, i3);
        }
    }

    @Override // c.a.p0.r.l
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e F = f.V().F();
            return F != null ? F.f4558f : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e F = f.V().F();
            return F != null ? F.N().u1() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? c.a.p0.a.c1.a.a0().i(c.a.p0.a.c1.a.b()) : (String) invokeL.objValue;
    }

    @Override // c.a.p0.r.l
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            m Z = c.a.p0.a.c1.a.Z();
            return Z != null ? Z.q() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public void i(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i2, str2) == null) {
            c.a.p0.a.c1.a.p0().i(str, i2, str2);
        }
    }

    @Override // c.a.p0.r.l
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.p0.a.c1.a.Z().j() : invokeV.booleanValue;
    }

    @Override // c.a.p0.r.l
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            e F = f.V().F();
            return F != null ? F.L().T() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? d.g().l() : invokeV.intValue;
    }

    @Override // c.a.p0.r.l
    public c.a.p0.r.m m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.p0.a.c1.a.J().m() : (c.a.p0.r.m) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? c.a.p0.a.m2.b.h(l()) : (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public void o(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            c.a.p0.a.c1.a.p0().o(str, str2, i2, str3, j2, i3);
        }
    }

    @Override // c.a.p0.r.l
    public String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) ? c.a.p0.u.b.b(context).a() : (String) invokeL.objValue;
    }

    @Override // c.a.p0.r.l
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f7820b == null) {
                c.a.p0.a.c1.a.Z().getSwitch("swan_ceres_add_counter", false);
                this.f7820b = false;
            }
            return this.f7820b.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.r.l
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? c.a.p0.a.u1.a.a.V() && (s() || k.f7078b) : invokeV.booleanValue;
    }

    @Override // c.a.p0.r.l
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return f7818c && PreferenceManager.getDefaultSharedPreferences(c.a.p0.a.c1.a.b()).getBoolean("KEY_UBC_DEBUG", true);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.r.l
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String b2 = c.a.p0.a.c1.a.m().b();
            if (q0.G() || TextUtils.isEmpty(b2)) {
                return null;
            }
            return b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? c.a.p0.a.d0.a.b() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.r.l
    public String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) ? c.a.p0.a.c1.a.a0().h(c.a.p0.a.c1.a.b()) : (String) invokeL.objValue;
    }
}
