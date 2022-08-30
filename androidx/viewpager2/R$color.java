package androidx.viewpager2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$color {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action_color_filter = 2131101850;
    public static final int notification_icon_bg_color = 2131101851;
    public static final int ripple_material_light = 2131101951;
    public static final int secondary_text_default_material_light = 2131102235;
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
