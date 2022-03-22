package c.a.p0.f1.l2.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.p0.l0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends c.a.p0.f1.l2.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView j;
    public f k;
    public ImageView l;
    public MessageRedDotView m;
    public ImageView n;
    public TextView o;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1952170644, "Lc/a/p0/f1/l2/c/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1952170644, "Lc/a/p0/f1/l2/c/d$a;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            switch (a.a[logicField.ordinal()]) {
                case 1:
                    return (T) this.j;
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

    @Override // c.a.p0.f1.l2.c.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14212e.setContentPaddingTop(n.f(this.f14210c.getContext(), R.dimen.tbds24));
            q();
            p();
            r();
            o();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = this.f14212e.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.f14209b.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            this.o.setLayoutParams(layoutParams);
            this.o.setPadding(0, 0, this.f14209b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), 0);
            this.o.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f fVar = new f(this.f14209b);
            this.k = fVar;
            this.f14212e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, fVar.c(), (View.OnClickListener) null);
            this.l = this.k.b();
            MessageRedDotView a2 = this.k.a();
            this.m = a2;
            a2.setShadowEnabled(false);
            this.k.c().setOnClickListener(this.f14211d);
            this.k.f(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j = (ImageView) this.f14212e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d035a, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080625, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.j.setOnClickListener(this.f14211d);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n = (ImageView) this.f14212e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d035b, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.obfuscated_res_0x7f080626, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.n.setOnClickListener(this.f14211d);
        }
    }
}
