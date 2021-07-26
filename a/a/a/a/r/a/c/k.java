package a.a.a.a.r.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
/* loaded from: classes.dex */
public class k implements NativeADEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ChannelNativeAds_6.GdtADStatusChangeListener f1201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f1202d;

    public k(g gVar, NativeUnifiedADData nativeUnifiedADData, String str, ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, nativeUnifiedADData, str, gdtADStatusChangeListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1202d = gVar;
        this.f1199a = nativeUnifiedADData;
        this.f1200b = str;
        this.f1201c = gdtADStatusChangeListener;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1202d.n.b(this.f1199a);
            this.f1202d.e();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
            this.f1202d.f1015h.b(Integer.valueOf(adError.getErrorCode()));
            this.f1202d.a(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1202d.n.c(this.f1199a);
            this.f1202d.a((g) this.f1199a, this.f1200b);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
        ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gdtADStatusChangeListener = this.f1201c) == null) {
            return;
        }
        gdtADStatusChangeListener.onADStatusChanged(this.f1199a);
    }
}
