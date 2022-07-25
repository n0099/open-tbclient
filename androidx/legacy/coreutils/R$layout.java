package androidx.legacy.coreutils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$layout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int notification_action = 2131559981;
    public static final int notification_action_tombstone = 2131559982;
    public static final int notification_template_custom_big = 2131559989;
    public static final int notification_template_icon_group = 2131559990;
    public static final int notification_template_part_chronometer = 2131559994;
    public static final int notification_template_part_time = 2131559995;
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
