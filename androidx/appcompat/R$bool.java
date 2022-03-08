package androidx.appcompat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$bool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int abc_action_bar_embed_tabs = 2131034112;
    public static final int abc_allow_stacked_button_bar = 2131034113;
    public static final int abc_config_actionMenuItemAllCaps = 2131034114;
    public transient /* synthetic */ FieldHolder $fh;

    public R$bool() {
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
