package b.f.a0.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsFullScreenVideoAd;
/* loaded from: classes6.dex */
public class g implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31904a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFullScreenVideoAd f31906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f f31907d;

    public g(f fVar, KsFullScreenVideoAd ksFullScreenVideoAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, ksFullScreenVideoAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31907d = fVar;
        this.f31906c = ksFullScreenVideoAd;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            adReporter = this.f31907d.mReporter;
            adReporter.recordOnClicked(this.f31905b);
            this.f31905b = true;
            this.f31907d.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            adReporter = this.f31907d.mReporter;
            adReporter.recordOnClosed();
            this.f31907d.onAdClose();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            adReporter = this.f31907d.mReporter;
            adReporter.recordVideoSkipped();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            adReporter = this.f31907d.mReporter;
            adReporter.recordVideoCompleted();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            LogPrinter.e("onVideoPlayError code:%d extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            adReporter = this.f31907d.mReporter;
            adReporter.recordVideoErr();
            this.f31907d.onAdError(i2, String.valueOf(i3));
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        AdReporter adReporter;
        AdReporter adReporter2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LogPrinter.d();
            adReporter = this.f31907d.mReporter;
            adReporter.recordVideoStart();
            adReporter2 = this.f31907d.mReporter;
            adReporter2.recordShowSucceed(this.f31904a);
            this.f31904a = true;
            this.f31907d.onAdShow(this.f31906c);
        }
    }
}
