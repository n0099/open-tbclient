package androidx.constraintlayout.widget;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$id {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int bottom = 2131297316;
    public static final int end = 2131298931;
    public static final int gone = 2131300011;
    public static final int invisible = 2131300722;
    public static final int left = 2131301455;
    public static final int packed = 2131302601;
    public static final int parent = 2131302607;
    public static final int percent = 2131302957;
    public static final int right = 2131303821;
    public static final int spread = 2131304595;
    public static final int spread_inside = 2131304597;
    public static final int start = 2131304651;
    public static final int top = 2131305487;
    public static final int wrap = 2131306764;
    public transient /* synthetic */ FieldHolder $fh;

    public R$id() {
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
