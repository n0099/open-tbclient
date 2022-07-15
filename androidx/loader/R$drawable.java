package androidx.loader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action_background = 2131234274;
    public static final int notification_bg = 2131234275;
    public static final int notification_bg_low = 2131234276;
    public static final int notification_bg_low_normal = 2131234277;
    public static final int notification_bg_low_pressed = 2131234278;
    public static final int notification_bg_normal = 2131234279;
    public static final int notification_bg_normal_pressed = 2131234280;
    public static final int notification_icon_background = 2131234281;
    public static final int notification_template_icon_bg = 2131234282;
    public static final int notification_template_icon_low_bg = 2131234283;
    public static final int notification_tile_bg = 2131234284;
    public static final int notify_panel_notification_icon_bg = 2131234286;
    public transient /* synthetic */ FieldHolder $fh;

    public R$drawable() {
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
