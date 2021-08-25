package c.a.w.i;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.PathUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static f f30462d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30463a;

    /* renamed from: b  reason: collision with root package name */
    public String f30464b;

    /* renamed from: c  reason: collision with root package name */
    public b f30465c;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f30466a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1663252260, "Lc/a/w/i/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1663252260, "Lc/a/w/i/f$a;");
                    return;
                }
            }
            f30466a = new f();
        }
    }

    public f() {
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
        this.f30464b = "day";
    }

    public static f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f30462d == null) {
                f30462d = a.f30466a;
            }
            return f30462d;
        }
        return (f) invokeV.objValue;
    }

    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (TextUtils.isEmpty(str) || (bVar = this.f30465c) == null) {
                return -16777216;
            }
            return bVar.a(context, z, str);
        }
        return invokeCommon.intValue;
    }

    public int b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (z) {
                return c.a.w.b.g.b.a.a().f30389h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().f30387f;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().f30388g;
            }
            return c.a.w.b.g.b.a.a().f30386e;
        }
        return invokeZ.intValue;
    }

    public int c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (z) {
                return c.a.w.b.g.b.a.a().n;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().l;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().m;
            }
            return c.a.w.b.g.b.a.a().k;
        }
        return invokeZ.intValue;
    }

    public int d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (z) {
                return c.a.w.b.g.b.a.a().t;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().r;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().s;
            }
            return c.a.w.b.g.b.a.a().q;
        }
        return invokeZ.intValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().o;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().m;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().n;
            }
            return c.a.w.b.e.b.a().l;
        }
        return (String) invokeZ.objValue;
    }

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().s;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().q;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().r;
            }
            return c.a.w.b.e.b.a().p;
        }
        return invokeZ.intValue;
    }

    public String h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().w;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().u;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().v;
            }
            return c.a.w.b.e.b.a().t;
        }
        return (String) invokeZ.objValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().A;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().y;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().z;
            }
            return c.a.w.b.e.b.a().x;
        }
        return invokeZ.intValue;
    }

    public int j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return c.a.w.b.g.b.a.a().f30385d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().f30383b;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.g.b.a.a().f30384c;
            }
            return c.a.w.b.g.b.a.a().f30382a;
        }
        return invokeZ.intValue;
    }

    public String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().f30359d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().f30357b;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().f30358c;
            }
            return c.a.w.b.e.b.a().f30356a;
        }
        return (String) invokeZ.objValue;
    }

    public int l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().f30363h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().f30361f;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f30464b)) {
                return c.a.w.b.e.b.a().f30362g;
            }
            return c.a.w.b.e.b.a().f30360e;
        }
        return invokeZ.intValue;
    }

    public GradientDrawable m(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, context, z)) == null) {
            float a2 = c.a.w.b.f.a.a(context, 18.0f);
            float[] fArr = {a2, a2, a2, a2, a2, a2, a2, a2};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(fArr);
            gradientDrawable.setColor(a(context, z, "color_btn_fill"));
            gradientDrawable.setStroke(1, a(context, z, "color_btn_stroke"));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeLZ.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f30464b : (String) invokeV.objValue;
    }

    public void o(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            this.f30463a = str;
            if (p(str2)) {
                this.f30464b = str2;
            }
            if (PathUtils.DIRCTORY_BAIDU.equals(this.f30463a)) {
                this.f30465c = new c.a.w.i.a();
            } else if ("haokan".equals(this.f30463a)) {
                this.f30465c = new c();
            } else if ("quanmin".equals(this.f30463a)) {
                this.f30465c = new d();
            } else if ("tieba".equals(this.f30463a)) {
                this.f30465c = new e();
            }
            this.f30465c.b(str2);
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? "day".equals(str) || SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) || SkinManager.SKIN_TYPE_STR_DARK.equals(str) : invokeL.booleanValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && p(str)) {
            this.f30464b = str;
            b bVar = this.f30465c;
            if (bVar != null) {
                bVar.b(str);
            }
        }
    }
}
