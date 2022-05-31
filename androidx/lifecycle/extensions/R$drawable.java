package androidx.lifecycle.extensions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action_background = 2131234419;
    public static final int notification_bg = 2131234420;
    public static final int notification_bg_low = 2131234421;
    public static final int notification_bg_low_normal = 2131234422;
    public static final int notification_bg_low_pressed = 2131234423;
    public static final int notification_bg_normal = 2131234424;
    public static final int notification_bg_normal_pressed = 2131234425;
    public static final int notification_icon_background = 2131234426;
    public static final int notification_template_icon_bg = 2131234427;
    public static final int notification_template_icon_low_bg = 2131234428;
    public static final int notification_tile_bg = 2131234429;
    public static final int notify_panel_notification_icon_bg = 2131234431;
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
