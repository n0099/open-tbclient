package b.f.a0.b;

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
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.util.List;
/* loaded from: classes6.dex */
public class k extends BasePidLoader<NativeExpressADView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f31785a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f31787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f31788d;

        public a(k kVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31788d = kVar;
            this.f31787c = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nativeExpressADView) == null) {
                LogPrinter.d();
                this.f31788d.mReporter.recordOnClicked(this.f31786b);
                this.f31786b = true;
                this.f31788d.onAdClicked();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeExpressADView) == null) {
                LogPrinter.e("GDTNativeExpressAd onADCloseOverlay", new Object[0]);
                this.f31788d.mReporter.recordCloseOverlay();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeExpressADView) == null) {
                LogPrinter.e("GDTNativeExpressAd onADClosed", new Object[0]);
                this.f31788d.mReporter.recordOnClosed();
                this.f31788d.onAdClose();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, nativeExpressADView) == null) {
                LogPrinter.d();
                this.f31788d.mReporter.recordShowSucceed(this.f31785a);
                this.f31785a = true;
                this.f31788d.onAdShow(nativeExpressADView);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, nativeExpressADView) == null) {
                LogPrinter.e("GDTNativeExpressAd onADLeftApplication", new Object[0]);
                this.f31788d.mReporter.recordLeftApplication();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    this.f31788d.mReporter.recordLoadFailed("NoFill");
                    this.f31788d.onError(0, "NoFill");
                    return;
                }
                this.f31788d.mReporter.recordLoadSucceed();
                NativeExpressADView nativeExpressADView = list.get(0);
                this.f31788d.mAdRipper.report(nativeExpressADView, this.f31787c.getSid());
                nativeExpressADView.render();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, nativeExpressADView) == null) {
                LogPrinter.e("GDTNativeExpressAd onADOpenOverlay", new Object[0]);
                this.f31788d.mReporter.recordOpenOverlay();
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                LogPrinter.e("GDTNativeExpressAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f31788d.mReporter.recordLoadFailed(Integer.valueOf(adError.getErrorCode()));
                this.f31788d.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nativeExpressADView) == null) {
                LogPrinter.e();
                this.f31788d.mReporter.recordRenderFailed();
                this.f31788d.onError(0, "RenderFail");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, nativeExpressADView) == null) {
                LogPrinter.d();
                this.f31788d.mReporter.recordRenderSucceed();
                this.f31788d.onAdLoaded((k) nativeExpressADView);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Ssp.Pid pid) {
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

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new b.f.a0.b.a(pid) : (AdRipper) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeExpressADView) == null) || (nativeExpressADView2 = nativeExpressADView) == null) {
            return;
        }
        nativeExpressADView2.destroy();
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            if (!(context instanceof Activity)) {
                this.mReporter.recordLoadFailed("NoA");
                onError(0, "NotActvity");
                return;
            }
            NativeExpressAD nativeExpressAD = new NativeExpressAD((Activity) context, new ADSize(-1, -2), this.mPid.pid, new a(this, funAdSlot));
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
            nativeExpressAD.setMinVideoDuration(0);
            nativeExpressAD.setMaxVideoDuration(0);
            nativeExpressAD.setVideoPlayPolicy(1);
            nativeExpressAD.loadAD(1);
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, NativeExpressADView nativeExpressADView) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, nativeExpressADView)) == null) {
            NativeExpressADView nativeExpressADView2 = nativeExpressADView;
            if (nativeExpressADView2.getBoundData().getAdPatternType() == 2) {
                nativeExpressADView2.setMediaListener(new n(this));
            }
            this.mReporter.recordShowStart();
            if (nativeExpressADView2.getParent() != null) {
                ((ViewGroup) nativeExpressADView2.getParent()).removeView(nativeExpressADView2);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(nativeExpressADView2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
