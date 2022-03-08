package c.a.w.i;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static f f26392d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26393b;

    /* renamed from: c  reason: collision with root package name */
    public b f26394c;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;
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
        this.f26393b = "day";
    }

    public static f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f26392d == null) {
                f26392d = a.a;
            }
            return f26392d;
        }
        return (f) invokeV.objValue;
    }

    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (TextUtils.isEmpty(str) || (bVar = this.f26394c) == null) {
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
                return c.a.w.b.g.b.a.a().f26337h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.g.b.a.a().f26335f;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
                return c.a.w.b.g.b.a.a().f26336g;
            }
            return c.a.w.b.g.b.a.a().f26334e;
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
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.g.b.a.a().l;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
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
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.g.b.a.a().r;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
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
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().m;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
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
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().q;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
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
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().u;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
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
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().y;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
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
                return c.a.w.b.g.b.a.a().f26333d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.g.b.a.a().f26331b;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
                return c.a.w.b.g.b.a.a().f26332c;
            }
            return c.a.w.b.g.b.a.a().a;
        }
        return invokeZ.intValue;
    }

    public String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().f26316d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().f26314b;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().f26315c;
            }
            return c.a.w.b.e.b.a().a;
        }
        return (String) invokeZ.objValue;
    }

    public int l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (z) {
                return c.a.w.b.e.b.a().f26320h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().f26318f;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
                return c.a.w.b.e.b.a().f26319g;
            }
            return c.a.w.b.e.b.a().f26317e;
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

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.f26393b)) {
                return R.drawable.live_feed_page_search_icon_night;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(this.f26393b)) {
            }
            return R.drawable.live_feed_page_search_icon;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f26393b : (String) invokeV.objValue;
    }

    public void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.a = str;
            if (q(str2)) {
                this.f26393b = str2;
            }
            if ("baidu".equals(this.a)) {
                this.f26394c = new c.a.w.i.a();
            } else if ("haokan".equals(this.a)) {
                this.f26394c = new c();
            } else if ("quanmin".equals(this.a)) {
                this.f26394c = new d();
            } else if ("tieba".equals(this.a)) {
                this.f26394c = new e();
            }
            this.f26394c.b(str2);
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
            this.f26393b = str;
            b bVar = this.f26394c;
            if (bVar != null) {
                bVar.b(str);
            }
        }
    }
}
