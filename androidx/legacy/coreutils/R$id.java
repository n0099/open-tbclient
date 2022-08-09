package androidx.legacy.coreutils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$id {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int action_container = 2131296355;
    public static final int action_divider = 2131296357;
    public static final int action_image = 2131296359;
    public static final int action_text = 2131296367;
    public static final int actions = 2131296368;
    public static final int async = 2131296962;
    public static final int blocking = 2131297189;
    public static final int chronometer = 2131297835;
    public static final int forever = 2131298855;
    public static final int icon = 2131299845;
    public static final int icon_group = 2131299853;
    public static final int info = 2131300105;
    public static final int italic = 2131300209;
    public static final int line1 = 2131301096;
    public static final int line3 = 2131301098;
    public static final int normal = 2131302073;
    public static final int notification_background = 2131302093;
    public static final int notification_main_column = 2131302095;
    public static final int notification_main_column_container = 2131302096;
    public static final int right_icon = 2131303408;
    public static final int right_side = 2131303414;
    public static final int tag_transition_group = 2131304505;
    public static final int tag_unhandled_key_event_manager = 2131304507;
    public static final int tag_unhandled_key_listeners = 2131304508;
    public static final int text = 2131304617;
    public static final int text2 = 2131304618;
    public static final int time = 2131304847;
    public static final int title = 2131304890;
    public transient /* synthetic */ FieldHolder $fh;

    public R$id() {
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
