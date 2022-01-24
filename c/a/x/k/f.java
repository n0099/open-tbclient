package c.a.x.k;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static f f26715d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26716b;

    /* renamed from: c  reason: collision with root package name */
    public b f26717c;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136816377, "Lc/a/x/k/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(136816377, "Lc/a/x/k/f$a;");
                    return;
                }
            }
            a = new f();
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
        this.f26716b = "day";
    }

    public static f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f26715d == null) {
                f26715d = a.a;
            }
            return f26715d;
        }
        return (f) invokeV.objValue;
    }

    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (TextUtils.isEmpty(str) || (bVar = this.f26717c) == null) {
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
                return c.a.x.b.g.b.a.a().f26660h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().f26658f;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().f26659g;
            }
            return c.a.x.b.g.b.a.a().f26657e;
        }
        return invokeZ.intValue;
    }

    public int c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (z) {
                return c.a.x.b.g.b.a.a().n;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().l;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().m;
            }
            return c.a.x.b.g.b.a.a().k;
        }
        return invokeZ.intValue;
    }

    public int d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (z) {
                return c.a.x.b.g.b.a.a().t;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().r;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().s;
            }
            return c.a.x.b.g.b.a.a().q;
        }
        return invokeZ.intValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                return c.a.x.b.e.b.a().o;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().m;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().n;
            }
            return c.a.x.b.e.b.a().l;
        }
        return (String) invokeZ.objValue;
    }

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                return c.a.x.b.e.b.a().s;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().q;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().r;
            }
            return c.a.x.b.e.b.a().p;
        }
        return invokeZ.intValue;
    }

    public String h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return c.a.x.b.e.b.a().w;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().u;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().v;
            }
            return c.a.x.b.e.b.a().t;
        }
        return (String) invokeZ.objValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return c.a.x.b.e.b.a().A;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().y;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().z;
            }
            return c.a.x.b.e.b.a().x;
        }
        return invokeZ.intValue;
    }

    public int j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return c.a.x.b.g.b.a.a().f26656d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().f26654b;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.g.b.a.a().f26655c;
            }
            return c.a.x.b.g.b.a.a().a;
        }
        return invokeZ.intValue;
    }

    public String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                return c.a.x.b.e.b.a().f26639d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().f26637b;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().f26638c;
            }
            return c.a.x.b.e.b.a().a;
        }
        return (String) invokeZ.objValue;
    }

    public int l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (z) {
                return c.a.x.b.e.b.a().f26643h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().f26641f;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.b.e.b.a().f26642g;
            }
            return c.a.x.b.e.b.a().f26640e;
        }
        return invokeZ.intValue;
    }

    public GradientDrawable m(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, context, z)) == null) {
            float a2 = c.a.x.b.f.a.a(context, 18.0f);
            float[] fArr = {a2, a2, a2, a2, a2, a2, a2, a2};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(fArr);
            gradientDrawable.setColor(a(context, z, "color_btn_fill"));
            gradientDrawable.setStroke(1, a(context, z, "color_btn_stroke"));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeLZ.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26716b)) {
                return c.a.x.c.a.b.live_feed_page_search_icon_night;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26716b)) {
                return c.a.x.c.a.b.live_feed_page_search_icon;
            }
            return c.a.x.c.a.b.live_feed_page_search_icon;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f26716b : (String) invokeV.objValue;
    }

    public void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.a = str;
            if (q(str2)) {
                this.f26716b = str2;
            }
            if ("baidu".equals(this.a)) {
                this.f26717c = new c.a.x.k.a();
            } else if ("haokan".equals(this.a)) {
                this.f26717c = new c();
            } else if ("quanmin".equals(this.a)) {
                this.f26717c = new d();
            } else if ("tieba".equals(this.a)) {
                this.f26717c = new e();
            }
            this.f26717c.b(str2);
        }
    }

    public final boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? "day".equals(str) || SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) || SkinManager.SKIN_TYPE_STR_DARK.equals(str) : invokeL.booleanValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && q(str)) {
            this.f26716b = str;
            b bVar = this.f26717c;
            if (bVar != null) {
                bVar.b(str);
            }
        }
    }
}
