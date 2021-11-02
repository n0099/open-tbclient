package b.g.a0.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes6.dex */
public class r extends v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31087a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31088b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsSplashScreenAd f31089c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q f31090d;

    public r(q qVar, KsSplashScreenAd ksSplashScreenAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar, ksSplashScreenAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31090d = qVar;
        this.f31089c = ksSplashScreenAd;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            adReporter = this.f31090d.mReporter;
            adReporter.recordOnClicked(this.f31088b);
            this.f31088b = true;
            this.f31090d.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            adReporter = this.f31090d.mReporter;
            adReporter.recordOnClosed();
            this.f31090d.onAdClose();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i2, String str) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            LogPrinter.e("onAdShowError code: " + i2 + ", message: " + str, new Object[0]);
            adReporter = this.f31090d.mReporter;
            adReporter.recordShowFailed(Integer.valueOf(i2));
            this.f31090d.onAdError(i2, str);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            adReporter = this.f31090d.mReporter;
            adReporter.recordShowSucceed(this.f31087a);
            this.f31087a = true;
            this.f31090d.onAdShow(this.f31089c);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
            adReporter = this.f31090d.mReporter;
            adReporter.recordSplashSkip();
            this.f31090d.onAdClose();
        }
    }
}
