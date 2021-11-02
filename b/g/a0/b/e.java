package b.g.a0.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressAD2;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends BasePidLoader<NativeExpressADData2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<NativeExpressADData2, ExpressAdListenerWrapper<AdEventListener>> f30916h;

    /* loaded from: classes6.dex */
    public class a implements NativeExpressAD2.AdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f30917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f30918b;

        public a(e eVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30918b = eVar;
            this.f30917a = funAdSlot;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: com.qq.e.ads.nativ.express2.NativeExpressADData2 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [b.g.a0.b.h, A, com.qq.e.ads.nativ.express2.AdEventListener] */
        @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
        public void onLoadSuccess(List<NativeExpressADData2> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    this.f30918b.mReporter.recordLoadFailed("NoFill");
                    this.f30918b.onError(0, "NoFill");
                    return;
                }
                this.f30918b.mReporter.recordLoadSucceed();
                NativeExpressADData2 nativeExpressADData2 = list.get(0);
                e eVar = this.f30918b;
                String sid = this.f30917a.getSid();
                eVar.getClass();
                ExpressAdListenerWrapper expressAdListenerWrapper = new ExpressAdListenerWrapper();
                ?? hVar = new h(eVar, expressAdListenerWrapper, sid, nativeExpressADData2);
                expressAdListenerWrapper.listener = hVar;
                nativeExpressADData2.setAdEventListener(hVar);
                nativeExpressADData2.render();
                this.f30918b.mAdRipper.report(nativeExpressADData2, this.f30917a.getSid());
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                LogPrinter.e("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f30918b.mReporter.recordLoadFailed(Integer.valueOf(adError.getErrorCode()));
                this.f30918b.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30916h = new HashMap<>();
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new e0(pid) : (AdRipper) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(NativeExpressADData2 nativeExpressADData2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeExpressADData2) == null) {
            NativeExpressADData2 nativeExpressADData22 = nativeExpressADData2;
            this.f30916h.remove(nativeExpressADData22);
            if (nativeExpressADData22 != null) {
                nativeExpressADData22.destroy();
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, NativeExpressADData2 nativeExpressADData2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, nativeExpressADData2)) == null) ? new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, nativeExpressADData2, new j(this)) : (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(context.getApplicationContext(), this.mPid.pid, new a(this, funAdSlot));
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            nativeExpressAD2.setAdSize(expressWidth, expressHeight);
            VideoOption2.Builder builder = new VideoOption2.Builder();
            builder.setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? VideoOption2.AutoPlayPolicy.ALWAYS : VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setMaxVideoDuration(0).setMinVideoDuration(0);
            nativeExpressAD2.setVideoOption2(builder.build());
            nativeExpressAD2.loadAd(1);
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, NativeExpressADData2 nativeExpressADData2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, nativeExpressADData2)) == null) {
            this.mReporter.recordShowStart();
            View adView = nativeExpressADData2.getAdView();
            if (adView.getParent() != null) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(adView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
