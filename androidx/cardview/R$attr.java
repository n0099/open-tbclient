package androidx.cardview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$attr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int cardBackgroundColor = 2130968863;
    public static final int cardCornerRadius = 2130968864;
    public static final int cardElevation = 2130968865;
    public static final int cardMaxElevation = 2130968867;
    public static final int cardPreventCornerOverlap = 2130968868;
    public static final int cardUseCompatPadding = 2130968869;
    public static final int cardViewStyle = 2130968858;
    public static final int contentPadding = 2130968963;
    public static final int contentPaddingBottom = 2130968964;
    public static final int contentPaddingLeft = 2130968965;
    public static final int contentPaddingRight = 2130968966;
    public static final int contentPaddingTop = 2130968967;
    public transient /* synthetic */ FieldHolder $fh;

    public R$attr() {
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
