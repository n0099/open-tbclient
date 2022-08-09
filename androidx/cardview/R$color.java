package androidx.cardview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$color {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int cardview_dark_background = 2131100741;
    public static final int cardview_light_background = 2131100742;
    public static final int cardview_shadow_end_color = 2131100743;
    public static final int cardview_shadow_start_color = 2131100744;
    public transient /* synthetic */ FieldHolder $fh;

    public R$color() {
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
