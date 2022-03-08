package androidx.fragment;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action_background = 2131234467;
    public static final int notification_bg = 2131234468;
    public static final int notification_bg_low = 2131234469;
    public static final int notification_bg_low_normal = 2131234470;
    public static final int notification_bg_low_pressed = 2131234471;
    public static final int notification_bg_normal = 2131234472;
    public static final int notification_bg_normal_pressed = 2131234473;
    public static final int notification_icon_background = 2131234474;
    public static final int notification_template_icon_bg = 2131234475;
    public static final int notification_template_icon_low_bg = 2131234476;
    public static final int notification_tile_bg = 2131234477;
    public static final int notify_panel_notification_icon_bg = 2131234479;
    public transient /* synthetic */ FieldHolder $fh;

    public R$drawable() {
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
