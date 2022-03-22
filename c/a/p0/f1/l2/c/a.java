package c.a.p0.f1.l2.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.e0;
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
    public Context f14209b;

    /* renamed from: c  reason: collision with root package name */
    public View f14210c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f14211d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f14212e;

    /* renamed from: f  reason: collision with root package name */
    public View f14213f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14214g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14215h;
    public ThemeElement i;

    /* renamed from: c.a.p0.f1.l2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1067a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1952081271, "Lc/a/p0/f1/l2/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1952081271, "Lc/a/p0/f1/l2/c/a$a;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14215h = true;
        this.i = c.a.p0.a4.c.b();
    }

    @Override // c.a.p0.f1.l2.c.c
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i = C1067a.a[logicField.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return (T) this.f14214g;
            }
            return (T) this.f14213f;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.p0.f1.l2.c.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // c.a.p0.f1.l2.c.c
    @CallSuper
    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            if (f2 < 0.5f) {
                if (this.f14215h) {
                    return;
                }
                m(true);
                this.f14215h = true;
            } else if (this.f14215h) {
                m(false);
                this.f14215h = false;
            }
        }
    }

    @Override // c.a.p0.f1.l2.c.c
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // c.a.p0.f1.l2.c.c
    @CallSuper
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeElement) == null) {
            this.i = themeElement;
        }
    }

    @Override // c.a.p0.f1.l2.c.c
    @NonNull
    public NavigationBar f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e0.b(this.f14212e);
            return this.f14212e;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // c.a.p0.f1.l2.c.c
    @Nullable
    public c.a.p0.f1.l2.c.f.d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (c.a.p0.f1.l2.c.f.d) invokeV.objValue;
    }

    @Override // c.a.p0.f1.l2.c.c
    @CallSuper
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            SkinManager.setBackgroundColor(this.f14212e.getContentLayout(), z ? R.color.CAM_X0201 : R.color.black_alpha0);
        }
    }

    @Override // c.a.p0.f1.l2.c.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.f1.l2.c.c
    public void j(@NonNull FrsFragment frsFragment, @NonNull View view, @NonNull View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, frsFragment, view, onClickListener) == null) && this.f14210c == null) {
            this.a = frsFragment;
            this.f14209b = view.getContext();
            this.f14210c = view;
            this.f14211d = onClickListener;
            NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f14212e = navigationBar;
            navigationBar.getBarBgView().setAlpha(1.0f);
            l();
            n();
        }
    }

    @Override // c.a.p0.f1.l2.c.c
    @Nullable
    public c.a.p0.f1.l2.c.f.a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (c.a.p0.f1.l2.c.f.a) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            View addSystemImageButton = this.f14212e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f14213f = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.f14211d);
            this.f14214g = (ImageView) this.f14213f.findViewById(R.id.obfuscated_res_0x7f09246f);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public abstract void n();

    @Override // c.a.p0.f1.l2.c.c
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }
}
