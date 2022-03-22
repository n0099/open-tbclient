package androidx.legacy.v4;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action_background = 2131234361;
    public static final int notification_bg = 2131234362;
    public static final int notification_bg_low = 2131234363;
    public static final int notification_bg_low_normal = 2131234364;
    public static final int notification_bg_low_pressed = 2131234365;
    public static final int notification_bg_normal = 2131234366;
    public static final int notification_bg_normal_pressed = 2131234367;
    public static final int notification_icon_background = 2131234368;
    public static final int notification_template_icon_bg = 2131234369;
    public static final int notification_template_icon_low_bg = 2131234370;
    public static final int notification_tile_bg = 2131234371;
    public static final int notify_panel_notification_icon_bg = 2131234373;
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
