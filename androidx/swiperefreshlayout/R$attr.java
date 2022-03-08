package androidx.swiperefreshlayout;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$attr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int alpha = 2130968711;
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
