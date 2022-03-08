package androidx.lifecycle.extensions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$anim {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int fragment_close_enter = 2130772101;
    public static final int fragment_close_exit = 2130772102;
    public static final int fragment_fade_enter = 2130772103;
    public static final int fragment_fade_exit = 2130772104;
    public static final int fragment_fast_out_extra_slow_in = 2130772105;
    public static final int fragment_open_enter = 2130772106;
    public static final int fragment_open_exit = 2130772107;
    public transient /* synthetic */ FieldHolder $fh;

    public R$anim() {
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
}
