package androidx.cardview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$color {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int cardview_dark_background = 2131100838;
    public static final int cardview_light_background = 2131100839;
    public static final int cardview_shadow_end_color = 2131100840;
    public static final int cardview_shadow_start_color = 2131100841;
    public transient /* synthetic */ FieldHolder $fh;

    public R$color() {
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
