package androidx.cardview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$style {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int Base_CardView = 2131755030;
    public static final int CardView = 2131755260;
    public static final int CardView_Dark = 2131755262;
    public static final int CardView_Light = 2131755263;
    public transient /* synthetic */ FieldHolder $fh;

    public R$style() {
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
