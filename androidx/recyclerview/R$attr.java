package androidx.recyclerview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$attr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int alpha = 2130968714;
    public static final int fastScrollEnabled = 2130969260;
    public static final int fastScrollHorizontalThumbDrawable = 2130969261;
    public static final int fastScrollHorizontalTrackDrawable = 2130969262;
    public static final int fastScrollVerticalThumbDrawable = 2130969263;
    public static final int fastScrollVerticalTrackDrawable = 2130969264;
    public static final int font = 2130969303;
    public static final int fontProviderAuthority = 2130969305;
    public static final int fontProviderCerts = 2130969306;
    public static final int fontProviderFetchStrategy = 2130969307;
    public static final int fontProviderFetchTimeout = 2130969308;
    public static final int fontProviderPackage = 2130969309;
    public static final int fontProviderQuery = 2130969310;
    public static final int fontStyle = 2130969311;
    public static final int fontVariationSettings = 2130969312;
    public static final int fontWeight = 2130969313;
    public static final int layoutManager = 2130969611;
    public static final int recyclerViewStyle = 2130970026;
    public static final int reverseLayout = 2130970044;
    public static final int spanCount = 2130970177;
    public static final int stackFromEnd = 2130970188;
    public static final int ttcIndex = 2130970441;
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
