package b.f.a0.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class h0 implements TTRewardVideoAd.RewardAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31681a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31682b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTRewardVideoAd f31683c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g0 f31684d;

    public h0(g0 g0Var, TTRewardVideoAd tTRewardVideoAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g0Var, tTRewardVideoAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31684d = g0Var;
        this.f31683c = tTRewardVideoAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            adReporter = this.f31684d.mReporter;
            adReporter.recordOnClosed();
            this.f31684d.onAdClose();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            adReporter = this.f31684d.mReporter;
            adReporter.recordShowSucceed(this.f31681a);
            this.f31681a = true;
            this.f31684d.onAdShow(this.f31683c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            adReporter = this.f31684d.mReporter;
            adReporter.recordOnClicked(this.f31682b);
            this.f31682b = true;
            this.f31684d.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            LogPrinter.d("onRewardVerify rewardVerify:%b rewardAmount:%d rewardName:%s errCode:%d errMsg:%s", Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2);
            adReporter = this.f31684d.mReporter;
            adReporter.recordReward(z);
            this.f31684d.onRewardedVideo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.e("CSJRewardVideoAd onSkippedVideo", new Object[0]);
            adReporter = this.f31684d.mReporter;
            adReporter.recordVideoSkipped();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LogPrinter.d();
            adReporter = this.f31684d.mReporter;
            adReporter.recordVideoCompleted();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LogPrinter.d();
            adReporter = this.f31684d.mReporter;
            adReporter.recordVideoErr();
            this.f31684d.onAdError(0, "F:onVideoError");
        }
    }
}
