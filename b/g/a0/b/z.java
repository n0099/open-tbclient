package b.g.a0.b;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
/* loaded from: classes6.dex */
public class z extends BasePidLoader<UnifiedInterstitialAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements UnifiedInterstitialADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f30977a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30978b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedInterstitialAD[] f30979c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f30980d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f30981e;

        public a(z zVar, UnifiedInterstitialAD[] unifiedInterstitialADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, unifiedInterstitialADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30981e = zVar;
            this.f30979c = unifiedInterstitialADArr;
            this.f30980d = funAdSlot;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.f30981e.mReporter.recordOnClicked(this.f30978b);
                this.f30978b = true;
                this.f30981e.onAdClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f30981e.mReporter.recordOnClosed();
                this.f30981e.onAdClose();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f30981e.mReporter.recordShowSucceed(this.f30977a);
                UnifiedInterstitialAD unifiedInterstitialAD = this.f30979c[0];
                this.f30977a = true;
                this.f30981e.onAdShow(unifiedInterstitialAD);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f30981e.mReporter.recordLeftApplication();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogPrinter.d("onADReceive", new Object[0]);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, adError) == null) {
                LogPrinter.e("onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f30981e.mReporter.recordLoadFailed(Integer.valueOf(adError.getErrorCode()));
                this.f30981e.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f30981e.mReporter.recordLoadFailed("renderFail");
                this.f30981e.onError(0, "renderFail");
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f30981e.mReporter.recordLoadSucceed();
                UnifiedInterstitialAD unifiedInterstitialAD = this.f30979c[0];
                this.f30981e.onAdLoaded((z) unifiedInterstitialAD);
                this.f30981e.mAdRipper.report(unifiedInterstitialAD, this.f30980d.getSid());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                LogPrinter.d();
                this.f30981e.mReporter.recordOnCached();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Ssp.Pid pid) {
        super(pid, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, unifiedInterstitialAD) == null) {
            unifiedInterstitialAD.show(activity);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid)) == null) ? new m(pid) : (AdRipper) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(UnifiedInterstitialAD unifiedInterstitialAD) {
        UnifiedInterstitialAD unifiedInterstitialAD2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unifiedInterstitialAD) == null) || (unifiedInterstitialAD2 = unifiedInterstitialAD) == null) {
            return;
        }
        try {
            unifiedInterstitialAD2.destroy();
        } catch (Exception unused) {
        }
    }

    public void e(UnifiedInterstitialAD unifiedInterstitialAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, unifiedInterstitialAD) == null) {
            unifiedInterstitialAD.loadAD();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, funAdSlot) == null) {
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            if (!(context instanceof Activity)) {
                this.mReporter.recordLoadFailed("NoA");
                onError(0, "NotActivity");
                return;
            }
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.mPid.pid, new a(this, r2, funAdSlot));
            UnifiedInterstitialAD[] unifiedInterstitialADArr = {unifiedInterstitialAD};
            unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(false).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
            unifiedInterstitialAD.setMinVideoDuration(0);
            unifiedInterstitialAD.setMaxVideoDuration(0);
            unifiedInterstitialAD.setVideoPlayPolicy(1);
            e(unifiedInterstitialAD);
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, activity, viewGroup, str, unifiedInterstitialAD)) == null) {
            this.mReporter.recordShowStart();
            b(activity, unifiedInterstitialAD);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
