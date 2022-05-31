package androidx.vectordrawable.animated;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$layout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int custom_dialog = 2131558917;
    public static final int notification_action = 2131559946;
    public static final int notification_action_tombstone = 2131559947;
    public static final int notification_template_custom_big = 2131559954;
    public static final int notification_template_icon_group = 2131559955;
    public static final int notification_template_part_chronometer = 2131559959;
    public static final int notification_template_part_time = 2131559960;
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
