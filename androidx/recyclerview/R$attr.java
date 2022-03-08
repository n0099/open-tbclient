package androidx.recyclerview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$attr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int alpha = 2130968711;
    public static final int fastScrollEnabled = 2130969100;
    public static final int fastScrollHorizontalThumbDrawable = 2130969101;
    public static final int fastScrollHorizontalTrackDrawable = 2130969102;
    public static final int fastScrollVerticalThumbDrawable = 2130969103;
    public static final int fastScrollVerticalTrackDrawable = 2130969104;
    public static final int font = 2130969159;
    public static final int fontProviderAuthority = 2130969169;
    public static final int fontProviderCerts = 2130969170;
    public static final int fontProviderFetchStrategy = 2130969171;
    public static final int fontProviderFetchTimeout = 2130969172;
    public static final int fontProviderPackage = 2130969174;
    public static final int fontProviderQuery = 2130969175;
    public static final int fontStyle = 2130969176;
    public static final int fontVariationSettings = 2130969177;
    public static final int fontWeight = 2130969178;
    public static final int layoutManager = 2130969481;
    public static final int recyclerViewStyle = 2130969866;
    public static final int reverseLayout = 2130969883;
    public static final int spanCount = 2130970013;
    public static final int stackFromEnd = 2130970024;
    public static final int ttcIndex = 2130970260;
    public transient /* synthetic */ FieldHolder $fh;

    public R$attr() {
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
