package c.a.u0.e1.v2.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.g1;
import c.a.u0.k0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d extends c.a.u0.e1.v2.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f17230j;
    public f k;
    public ImageView l;
    public MessageRedDotView m;
    public ImageView n;
    public TextView o;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-123763068, "Lc/a/u0/e1/v2/c/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-123763068, "Lc/a/u0/e1/v2/c/d$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.SEARCH_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.MESSAGE_ICON_CONTROLLER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LogicField.MESSAGE_BTN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LogicField.MESSAGE_RED_DOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LogicField.SHARE_BTN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LogicField.FOLD_TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            switch (a.a[logicField.ordinal()]) {
                case 1:
                    return (T) this.f17230j;
                case 2:
                    return (T) this.k;
                case 3:
                    return (T) this.l;
                case 4:
                    return (T) this.m;
                case 5:
                    return (T) this.n;
                case 6:
                    return (T) this.o;
                default:
                    return (T) super.a(logicField);
            }
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.u0.e1.v2.c.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17225e.setContentPaddingTop(n.f(this.f17223c.getContext(), d1.tbds24));
            q();
            p();
            r();
            o();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = this.f17225e.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.f17222b.getResources().getDimension(d1.ds20);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            this.o.setLayoutParams(layoutParams);
            this.o.setPadding(0, 0, this.f17222b.getResources().getDimensionPixelSize(d1.ds20), 0);
            this.o.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f fVar = new f(this.f17222b);
            this.k = fVar;
            this.f17225e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, fVar.c(), (View.OnClickListener) null);
            this.l = this.k.b();
            MessageRedDotView a2 = this.k.a();
            this.m = a2;
            a2.setShadowEnabled(false);
            this.k.c().setOnClickListener(this.f17224d);
            this.k.f(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f17230j = (ImageView) this.f17225e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, g1.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17230j, e1.ic_icon_pure_topbar_search40_svg, c1.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f17230j.setOnClickListener(this.f17224d);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n = (ImageView) this.f17225e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, g1.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, e1.ic_icon_pure_topbar_share40_svg, c1.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.n.setOnClickListener(this.f17224d);
        }
    }
}
