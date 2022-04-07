package androidx.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$color {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int androidx_core_ripple_material_light = 2131100654;
    public static final int androidx_core_secondary_text_default_material_light = 2131100655;
    public static final int notification_action_color_filter = 2131101821;
    public static final int notification_icon_bg_color = 2131101822;
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
