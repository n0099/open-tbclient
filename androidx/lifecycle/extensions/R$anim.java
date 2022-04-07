package androidx.lifecycle.extensions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$anim {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int fragment_close_enter = 2130772071;
    public static final int fragment_close_exit = 2130772072;
    public static final int fragment_fade_enter = 2130772073;
    public static final int fragment_fade_exit = 2130772074;
    public static final int fragment_fast_out_extra_slow_in = 2130772075;
    public static final int fragment_open_enter = 2130772076;
    public static final int fragment_open_exit = 2130772077;
    public transient /* synthetic */ FieldHolder $fh;

    public R$anim() {
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
