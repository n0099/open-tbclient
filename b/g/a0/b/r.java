package b.g.a0.b;

import b.g.a0.b.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes6.dex */
public class r implements o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FunNativeAd f30943a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f30944b;

    public r(o oVar, FunNativeAd funNativeAd, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar, funNativeAd, nativeUnifiedADData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30943a = funNativeAd;
        this.f30944b = nativeUnifiedADData;
    }

    @Override // b.g.a0.b.o.e
    public void onADStatusChanged() {
        ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gdtADStatusChangeListener = this.f30943a.getChannelNativeAds().getGdtADStatusChangeListener()) == null) {
            return;
        }
        gdtADStatusChangeListener.onADStatusChanged(this.f30944b);
    }
}
