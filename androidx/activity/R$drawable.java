package androidx.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action_background = 2131234370;
    public static final int notification_bg = 2131234371;
    public static final int notification_bg_low = 2131234372;
    public static final int notification_bg_low_normal = 2131234373;
    public static final int notification_bg_low_pressed = 2131234374;
    public static final int notification_bg_normal = 2131234375;
    public static final int notification_bg_normal_pressed = 2131234376;
    public static final int notification_icon_background = 2131234377;
    public static final int notification_template_icon_bg = 2131234378;
    public static final int notification_template_icon_low_bg = 2131234379;
    public static final int notification_tile_bg = 2131234380;
    public static final int notify_panel_notification_icon_bg = 2131234382;
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
