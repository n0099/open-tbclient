package b.g.a0.b;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
/* loaded from: classes6.dex */
public class y extends BasePidLoader<UnifiedBannerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements UnifiedBannerADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f30972a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedBannerView[] f30974c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f30975d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f30976e;

        public a(y yVar, UnifiedBannerView[] unifiedBannerViewArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, unifiedBannerViewArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30976e = yVar;
            this.f30974c = unifiedBannerViewArr;
            this.f30975d = funAdSlot;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.f30976e.mReporter.recordOnClicked(this.f30973b);
                this.f30973b = true;
                this.f30976e.onAdClicked();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f30976e.mReporter.recordCloseOverlay();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.e();
                this.f30976e.mReporter.recordOnClosed();
                this.f30976e.onAdClose();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f30976e.mReporter.recordShowSucceed(this.f30972a);
                this.f30972a = true;
                this.f30976e.onAdShow(this.f30974c[0]);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.d();
                this.f30976e.mReporter.recordLeftApplication();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogPrinter.e();
                this.f30976e.mReporter.recordOpenOverlay();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                LogPrinter.d();
                this.f30976e.mReporter.recordLoadSucceed();
                UnifiedBannerView unifiedBannerView = this.f30974c[0];
                this.f30976e.onAdLoaded((y) unifiedBannerView);
                this.f30976e.mAdRipper.report(unifiedBannerView, this.f30975d.getSid());
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                this.f30976e.mReporter.recordLoadFailed(Integer.valueOf(adError.getErrorCode()));
                this.f30976e.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Ssp.Pid pid) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new l(pid) : (AdRipper) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unifiedBannerView) == null) || (unifiedBannerView2 = unifiedBannerView) == null) {
            return;
        }
        unifiedBannerView2.destroy();
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            if (!(context instanceof Activity)) {
                this.mReporter.recordLoadFailed("NoA");
                onError(0, "Not Activity");
                return;
            }
            UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.mPid.pid, new a(this, r0, funAdSlot));
            unifiedBannerView.setRefresh(0);
            unifiedBannerView.loadAD();
            UnifiedBannerView[] unifiedBannerViewArr = {unifiedBannerView};
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, UnifiedBannerView unifiedBannerView) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, unifiedBannerView)) == null) {
            UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
            this.mReporter.recordShowStart();
            if (unifiedBannerView2.getParent() != null) {
                ((ViewGroup) unifiedBannerView2.getParent()).removeView(unifiedBannerView2);
            }
            viewGroup.removeAllViews();
            int width = viewGroup.getWidth();
            viewGroup.addView(unifiedBannerView2, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
