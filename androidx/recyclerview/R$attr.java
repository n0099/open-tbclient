package androidx.recyclerview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$attr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int alpha = 2130968711;
    public static final int fastScrollEnabled = 2130969096;
    public static final int fastScrollHorizontalThumbDrawable = 2130969097;
    public static final int fastScrollHorizontalTrackDrawable = 2130969098;
    public static final int fastScrollVerticalThumbDrawable = 2130969099;
    public static final int fastScrollVerticalTrackDrawable = 2130969100;
    public static final int font = 2130969114;
    public static final int fontProviderAuthority = 2130969116;
    public static final int fontProviderCerts = 2130969117;
    public static final int fontProviderFetchStrategy = 2130969159;
    public static final int fontProviderFetchTimeout = 2130969168;
    public static final int fontProviderPackage = 2130969169;
    public static final int fontProviderQuery = 2130969170;
    public static final int fontStyle = 2130969171;
    public static final int fontVariationSettings = 2130969172;
    public static final int fontWeight = 2130969174;
    public static final int layoutManager = 2130969476;
    public static final int recyclerViewStyle = 2130969832;
    public static final int reverseLayout = 2130969849;
    public static final int spanCount = 2130969973;
    public static final int stackFromEnd = 2130969984;
    public static final int ttcIndex = 2130970220;
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
