package b.f.a0.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsRewardVideoAd;
/* loaded from: classes6.dex */
public class p extends u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31939a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsRewardVideoAd f31941c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f31942d;

    public p(o oVar, KsRewardVideoAd ksRewardVideoAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar, ksRewardVideoAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31942d = oVar;
        this.f31941c = ksRewardVideoAd;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            adReporter = this.f31942d.mReporter;
            adReporter.recordOnClicked(this.f31940b);
            this.f31940b = true;
            this.f31942d.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            adReporter = this.f31942d.mReporter;
            adReporter.recordOnClosed();
            this.f31942d.onAdClose();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            adReporter = this.f31942d.mReporter;
            adReporter.recordReward();
            this.f31942d.onRewardedVideo();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            adReporter = this.f31942d.mReporter;
            adReporter.recordVideoCompleted();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            LogPrinter.d();
            adReporter = this.f31942d.mReporter;
            adReporter.recordVideoErr(i2);
            this.f31942d.onAdError(i2, String.valueOf(i3));
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        AdReporter adReporter;
        AdReporter adReporter2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LogPrinter.d();
            adReporter = this.f31942d.mReporter;
            adReporter.recordVideoStart();
            adReporter2 = this.f31942d.mReporter;
            adReporter2.recordShowSucceed(this.f31939a);
            this.f31939a = true;
            this.f31942d.onAdShow(this.f31941c);
        }
    }
}
