package androidx.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$attr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int alpha = 2130968711;
    public static final int font = 2130969236;
    public static final int fontProviderAuthority = 2130969238;
    public static final int fontProviderCerts = 2130969239;
    public static final int fontProviderFetchStrategy = 2130969240;
    public static final int fontProviderFetchTimeout = 2130969241;
    public static final int fontProviderPackage = 2130969242;
    public static final int fontProviderQuery = 2130969243;
    public static final int fontStyle = 2130969244;
    public static final int fontVariationSettings = 2130969245;
    public static final int fontWeight = 2130969246;
    public static final int ttcIndex = 2130970282;
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
