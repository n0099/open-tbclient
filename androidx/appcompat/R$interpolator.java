package androidx.appcompat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$interpolator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int btn_checkbox_checked_mtrl_animation_interpolator_0 = 2131492864;
    public static final int btn_checkbox_checked_mtrl_animation_interpolator_1 = 2131492865;
    public static final int btn_checkbox_unchecked_mtrl_animation_interpolator_0 = 2131492866;
    public static final int btn_checkbox_unchecked_mtrl_animation_interpolator_1 = 2131492867;
    public static final int btn_radio_to_off_mtrl_animation_interpolator_0 = 2131492868;
    public static final int btn_radio_to_on_mtrl_animation_interpolator_0 = 2131492869;
    public static final int fast_out_slow_in = 2131492870;
    public transient /* synthetic */ FieldHolder $fh;

    public R$interpolator() {
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
}
