package b.f.a0.d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
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
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends BasePidLoader<KsFullScreenVideoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.FullScreenVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f31902a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f31903b;

        public a(f fVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31903b = fVar;
            this.f31902a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogPrinter.e("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f31903b.mReporter.recordLoadFailed(Integer.valueOf(i2));
                this.f31903b.onError(i2, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onNativeAdLoad error: adList is null or empty", new Object[0]);
                    this.f31903b.mReporter.recordLoadFailed("NoFill");
                    this.f31903b.onError(0, "NoFill");
                    return;
                }
                this.f31903b.mReporter.recordLoadSucceed();
                KsFullScreenVideoAd ksFullScreenVideoAd = list.get(0);
                this.f31903b.onAdLoaded((f) ksFullScreenVideoAd);
                this.f31903b.mAdRipper.report(ksFullScreenVideoAd, this.f31902a.getSid());
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onRequestResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Ssp.Pid pid) {
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
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new y(pid) : (AdRipper) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(KsFullScreenVideoAd ksFullScreenVideoAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksFullScreenVideoAd) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean isAdAvailable(KsFullScreenVideoAd ksFullScreenVideoAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksFullScreenVideoAd)) == null) {
            KsFullScreenVideoAd ksFullScreenVideoAd2 = ksFullScreenVideoAd;
            return ksFullScreenVideoAd2 != null && ksFullScreenVideoAd2.isAdEnable();
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(1).build();
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new a(this, funAdSlot));
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, KsFullScreenVideoAd ksFullScreenVideoAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, ksFullScreenVideoAd)) == null) {
            KsFullScreenVideoAd ksFullScreenVideoAd2 = ksFullScreenVideoAd;
            if (!ksFullScreenVideoAd2.isAdEnable()) {
                LogPrinter.e("Ad isn't ready now.", new Object[0]);
                return false;
            }
            this.mReporter.recordShowStart();
            ksFullScreenVideoAd2.setFullScreenVideoAdInteractionListener(new g(this, ksFullScreenVideoAd2));
            ksFullScreenVideoAd2.showFullScreenVideoAd(activity, this.mPid.isHorizontal ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
