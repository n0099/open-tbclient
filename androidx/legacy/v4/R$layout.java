package androidx.legacy.v4;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$layout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action = 2131560012;
    public static final int notification_action_tombstone = 2131560013;
    public static final int notification_media_action = 2131560014;
    public static final int notification_media_cancel_action = 2131560015;
    public static final int notification_template_big_media = 2131560016;
    public static final int notification_template_big_media_custom = 2131560017;
    public static final int notification_template_big_media_narrow = 2131560018;
    public static final int notification_template_big_media_narrow_custom = 2131560019;
    public static final int notification_template_custom_big = 2131560020;
    public static final int notification_template_icon_group = 2131560021;
    public static final int notification_template_lines_media = 2131560022;
    public static final int notification_template_media = 2131560023;
    public static final int notification_template_media_custom = 2131560024;
    public static final int notification_template_part_chronometer = 2131560025;
    public static final int notification_template_part_time = 2131560026;
    public transient /* synthetic */ FieldHolder $fh;

    public R$layout() {
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
