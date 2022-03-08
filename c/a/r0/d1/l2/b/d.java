package c.a.r0.d1.l2.b;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes2.dex */
public class d extends c.a.r0.d1.l2.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f15787d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f15788e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15789f;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(385512377, "Lc/a/r0/d1/l2/b/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(385512377, "Lc/a/r0/d1/l2/b/d$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.LIKE_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.SIGN_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LogicField.SPEED_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LogicField.SERVICE_AREA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LogicField.TOP_AREA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LogicField.ROUND_CORNER_STYLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[LogicField.TOP_DIVIDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[LogicField.BANNER_AND_BOTTOM_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
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

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.b.c, c.a.r0.d1.l2.c.f.a
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i2 = a.a[logicField.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return (T) super.a(logicField);
                    }
                    return (T) this.f15789f;
                }
                return (T) Collections.singletonList(this.f15788e);
            }
            return (T) Collections.singletonList(this.f15787d);
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f15787d.setVisibility(8);
                this.f15788e.setVisibility(0);
                return;
            }
            this.f15787d.setVisibility(0);
            this.f15788e.setVisibility(8);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f15787d.setOnClickListener(onClickListener);
            this.f15788e.setOnClickListener(onClickListener);
        }
    }

    @Override // c.a.r0.d1.l2.b.c
    public void i(@Nullable Integer num, @Nullable Integer num2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, num, num2, z) == null) {
        }
    }

    @Override // c.a.r0.d1.l2.b.c
    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.b.c
    public int n(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, logicField)) == null) {
            switch (a.a[logicField.ordinal()]) {
                case 4:
                case 5:
                case 6:
                case 7:
                    return 0;
                case 8:
                    return 8;
                default:
                    return super.n(logicField);
            }
        }
        return invokeL.intValue;
    }

    @Override // c.a.r0.d1.l2.b.a
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            p();
            q();
            this.f15789f = (ImageView) this.f15786c.findViewById(R.id.speed_icon);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15786c.findViewById(R.id.frs_header_view_forum_info_container).setVisibility(8);
            this.f15786c.findViewById(R.id.widget_frs_forum_trial_operations).setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f15786c.findViewById(R.id.tv_love);
            this.f15787d = tBSpecificationBtn;
            tBSpecificationBtn.setText(this.f15785b.getResources().getString(R.string.attention));
            this.f15787d.setTextSize(R.dimen.T_X08);
            c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
            bVar.p(R.color.CAM_X0901, R.color.CAM_X0105);
            this.f15787d.setConfig(bVar);
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f15786c.findViewById(R.id.tv_sign);
            this.f15788e = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X08);
            c.a.q0.r.l0.n.b bVar2 = new c.a.q0.r.l0.n.b();
            bVar2.u(R.color.CAM_X0105);
            bVar2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
            bVar2.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.f15788e.setConfig(bVar2);
            this.f15788e.setText(this.f15785b.getResources().getString(R.string.sign));
        }
    }
}
