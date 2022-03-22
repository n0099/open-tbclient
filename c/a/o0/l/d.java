package c.a.o0.l;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBar f10396b;

    /* renamed from: c  reason: collision with root package name */
    public final View f10397c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<c> f10398d;

    /* renamed from: e  reason: collision with root package name */
    public float f10399e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10400f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10401g;

    /* renamed from: h  reason: collision with root package name */
    public int f10402h;

    public d(NavigationBar navigationBar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {navigationBar, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds300);
        this.f10398d = new HashSet();
        this.f10399e = 1.0f;
        this.f10400f = false;
        this.f10401g = false;
        this.f10402h = Integer.MAX_VALUE;
        this.f10396b = navigationBar;
        this.f10397c = view;
    }

    public void a(c... cVarArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVarArr) == null) || cVarArr == null || cVarArr.length <= 0) {
            return;
        }
        this.f10398d.addAll(Arrays.asList(cVarArr));
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.f10400f) {
            if (z || !this.f10401g || this.f10399e >= 0.5f) {
                if (this.f10399e < 0.5f) {
                    this.f10401g = true;
                } else {
                    this.f10401g = false;
                }
                for (c cVar : this.f10398d) {
                    if (cVar.b() != null) {
                        if (cVar.b() instanceof TextView) {
                            if (this.f10401g && !c.a.p0.a4.c.d(this.f10402h)) {
                                ((TextView) cVar.b()).setTextColor(this.f10402h);
                            } else {
                                SkinManager.setViewTextColor(cVar.b(), d());
                            }
                        } else if (cVar.b() instanceof ImageView) {
                            if (this.f10401g) {
                                if (!c.a.p0.a4.c.d(this.f10402h)) {
                                    ((ImageView) cVar.b()).setImageDrawable(SvgManager.getInstance().getPureDrawableWithColorInt(cVar.a(), this.f10402h, SvgManager.SvgResourceStateType.NORMAL_PRESS));
                                } else {
                                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) cVar.b(), cVar.a(), R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                                }
                            } else {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) cVar.b(), cVar.a(), R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f10400f) {
            float abs = Math.abs(this.f10399e - 0.5f) * 2.0f;
            for (c cVar : this.f10398d) {
                if (cVar.b() != null) {
                    cVar.b().setAlpha(abs);
                }
            }
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (!this.f10400f || this.f10401g) ? R.color.CAM_X0101 : R.color.CAM_X0106 : invokeV.intValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f10400f = true;
            this.f10399e = 0.0f;
            this.f10402h = c.a.p0.a4.c.e(i(str, "opacitybtnhex"));
            NavigationBar navigationBar = this.f10396b;
            if (navigationBar != null && navigationBar.getBackground() != null && this.f10396b.getBackground().mutate() != null) {
                this.f10396b.getBackground().mutate().setAlpha(0);
            }
            View view = this.f10397c;
            if (view != null) {
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            b(true);
        }
    }

    public void f(int i) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.f10400f && (navigationBar = this.f10396b) != null) {
            if (navigationBar.getBackground() != null && this.f10396b.getBackground().mutate() != null) {
                this.f10396b.getBackground().mutate().setAlpha((int) (this.f10399e * 255.0f));
            }
            b(true);
            c();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f10400f) {
            b(true);
            c();
        }
    }

    public void h(int i, int i2, int i3, int i4) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) || !this.f10400f || (navigationBar = this.f10396b) == null || navigationBar.getBackground() == null || this.f10396b.getBackground().mutate() == null) {
            return;
        }
        int i5 = this.a;
        if (i2 < i5) {
            this.f10399e = (i2 * 1.0f) / i5;
        } else {
            this.f10399e = 1.0f;
        }
        this.f10396b.getBackground().mutate().setAlpha((int) (this.f10399e * 255.0f));
        b(false);
        c();
    }

    public final String i(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                try {
                    String query = new URL(str).getQuery();
                    if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                        return null;
                    }
                    for (String str3 : split) {
                        String[] split2 = str3.split("=");
                        if (split2 != null && split2.length == 2) {
                            String str4 = split2[0];
                            String str5 = split2[1];
                            if (str2.equalsIgnoreCase(str4)) {
                                return str5;
                            }
                        }
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f10400f = false;
            this.f10399e = 1.0f;
            NavigationBar navigationBar = this.f10396b;
            if (navigationBar != null && navigationBar.getBackground() != null && this.f10396b.getBackground().mutate() != null) {
                this.f10396b.getBackground().mutate().setAlpha(1);
            }
            b(true);
            c();
            this.f10398d.clear();
        }
    }
}
