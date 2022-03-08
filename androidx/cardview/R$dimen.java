package androidx.cardview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$dimen {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int cardview_compat_inset_shadow = 2131165700;
    public static final int cardview_default_elevation = 2131165701;
    public static final int cardview_default_radius = 2131165702;
    public transient /* synthetic */ FieldHolder $fh;

    public R$dimen() {
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
