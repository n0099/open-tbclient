package androidx.legacy.v4;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$layout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action = 2131559943;
    public static final int notification_action_tombstone = 2131559944;
    public static final int notification_media_action = 2131559945;
    public static final int notification_media_cancel_action = 2131559946;
    public static final int notification_template_big_media = 2131559947;
    public static final int notification_template_big_media_custom = 2131559948;
    public static final int notification_template_big_media_narrow = 2131559949;
    public static final int notification_template_big_media_narrow_custom = 2131559950;
    public static final int notification_template_custom_big = 2131559951;
    public static final int notification_template_icon_group = 2131559952;
    public static final int notification_template_lines_media = 2131559953;
    public static final int notification_template_media = 2131559954;
    public static final int notification_template_media_custom = 2131559955;
    public static final int notification_template_part_chronometer = 2131559956;
    public static final int notification_template_part_time = 2131559957;
    public transient /* synthetic */ FieldHolder $fh;

    public R$layout() {
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
