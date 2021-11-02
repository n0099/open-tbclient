package b.g.a0.b;

import b.g.a0.b.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes6.dex */
public class t implements o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChannelNativeAds.GdtADStatusChangeListener f30947a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f30948b;

    public t(v vVar, ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vVar, gdtADStatusChangeListener, nativeUnifiedADData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30947a = gdtADStatusChangeListener;
        this.f30948b = nativeUnifiedADData;
    }

    @Override // b.g.a0.b.o.e
    public void onADStatusChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30947a.onADStatusChanged(this.f30948b);
        }
    }
}
