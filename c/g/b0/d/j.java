package c.g.b0.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsInterstitialAd;
/* loaded from: classes9.dex */
public class j implements KsInterstitialAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ KsInterstitialAd a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f28370b;

    public j(i iVar, KsInterstitialAd ksInterstitialAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, ksInterstitialAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28370b = iVar;
        this.a = ksInterstitialAd;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.f28370b.onAdClicked(false);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            this.f28370b.onAdShow(this.a, false);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onPageDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            this.f28370b.onAdClose();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onSkippedAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LogPrinter.d();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            LogPrinter.e("onVideoPlayError code:%d extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            this.f28370b.onAdError(i2, String.valueOf(i3));
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LogPrinter.d();
        }
    }
}
