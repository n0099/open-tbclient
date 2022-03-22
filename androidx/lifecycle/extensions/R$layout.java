package androidx.lifecycle.extensions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$layout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int custom_dialog = 2131558929;
    public static final int notification_action = 2131559972;
    public static final int notification_action_tombstone = 2131559973;
    public static final int notification_template_custom_big = 2131559980;
    public static final int notification_template_icon_group = 2131559981;
    public static final int notification_template_part_chronometer = 2131559985;
    public static final int notification_template_part_time = 2131559986;
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
