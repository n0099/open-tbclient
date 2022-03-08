package c.a.r0.d1.l2.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.e0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15804b;

    /* renamed from: c  reason: collision with root package name */
    public View f15805c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15806d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f15807e;

    /* renamed from: f  reason: collision with root package name */
    public View f15808f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15809g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15810h;

    /* renamed from: i  reason: collision with root package name */
    public ThemeElement f15811i;

    /* renamed from: c.a.r0.d1.l2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1008a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(414052155, "Lc/a/r0/d1/l2/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(414052155, "Lc/a/r0/d1/l2/c/a$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.BACK_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.BACK_IV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a() {
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
        this.f15810h = true;
        this.f15811i = c.a.r0.y3.c.b();
    }

    @Override // c.a.r0.d1.l2.c.c
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i2 = C1008a.a[logicField.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return (T) this.f15809g;
            }
            return (T) this.f15808f;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.r0.d1.l2.c.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // c.a.r0.d1.l2.c.c
    @CallSuper
    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            if (f2 < 0.5f) {
                if (this.f15810h) {
                    return;
                }
                m(true);
                this.f15810h = true;
            } else if (this.f15810h) {
                m(false);
                this.f15810h = false;
            }
        }
    }

    @Override // c.a.r0.d1.l2.c.c
    public void d(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // c.a.r0.d1.l2.c.c
    @CallSuper
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeElement) == null) {
            this.f15811i = themeElement;
        }
    }

    @Override // c.a.r0.d1.l2.c.c
    @NonNull
    public NavigationBar f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e0.b(this.f15807e);
            return this.f15807e;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // c.a.r0.d1.l2.c.c
    @Nullable
    public c.a.r0.d1.l2.c.f.d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (c.a.r0.d1.l2.c.f.d) invokeV.objValue;
    }

    @Override // c.a.r0.d1.l2.c.c
    @CallSuper
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            SkinManager.setBackgroundColor(this.f15807e, z ? R.color.CAM_X0201 : R.color.CAM_X0501);
        }
    }

    @Override // c.a.r0.d1.l2.c.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.l2.c.c
    public void j(@NonNull FrsFragment frsFragment, @NonNull View view, @NonNull View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, frsFragment, view, onClickListener) == null) && this.f15805c == null) {
            this.a = frsFragment;
            this.f15804b = view.getContext();
            this.f15805c = view;
            this.f15806d = onClickListener;
            NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
            this.f15807e = navigationBar;
            navigationBar.getBarBgView().setAlpha(1.0f);
            l();
            n();
        }
    }

    @Override // c.a.r0.d1.l2.c.c
    @Nullable
    public c.a.r0.d1.l2.c.f.a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (c.a.r0.d1.l2.c.f.a) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            View addSystemImageButton = this.f15807e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15808f = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.f15806d);
            this.f15809g = (ImageView) this.f15808f.findViewById(R.id.widget_navi_back_button);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public abstract void n();

    @Override // c.a.r0.d1.l2.c.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }
}
