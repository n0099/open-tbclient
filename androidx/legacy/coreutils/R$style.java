package androidx.legacy.coreutils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$style {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TextAppearance_Compat_Notification = 2131755493;
    public static final int TextAppearance_Compat_Notification_Info = 2131755494;
    public static final int TextAppearance_Compat_Notification_Line2 = 2131755498;
    public static final int TextAppearance_Compat_Notification_Time = 2131755501;
    public static final int TextAppearance_Compat_Notification_Title = 2131755503;
    public static final int Widget_Compat_NotificationActionContainer = 2131755809;
    public static final int Widget_Compat_NotificationActionText = 2131755810;
    public transient /* synthetic */ FieldHolder $fh;

    public R$style() {
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
