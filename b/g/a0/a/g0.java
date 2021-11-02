package b.g.a0.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class g0 extends q<TTRewardVideoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.RewardVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f30819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f30820b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g0 f30821c;

        public a(g0 g0Var, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30821c = g0Var;
            this.f30820b = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogPrinter.e("CSJRewardVideoAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f30821c.mReporter.recordLoadFailed(Integer.valueOf(i2));
                if (this.f30819a) {
                    return;
                }
                this.f30821c.onError(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTRewardVideoAd) == null) {
                this.f30819a = true;
                LogPrinter.d();
                this.f30821c.mReporter.recordLoadSucceed();
                this.f30821c.onAdLoaded((g0) tTRewardVideoAd);
                this.f30821c.mAdRipper.report(tTRewardVideoAd, this.f30820b.getSid());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f30821c.mReporter.recordOnCached();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, tTRewardVideoAd) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Ssp.Pid pid) {
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
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
        }
    }

    @Override // b.g.a0.a.q, com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            super.loadInternal(context, funAdSlot);
            AdSlot build = new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setUserID(null).setOrientation(this.mPid.isHorizontal ? 2 : 1).setMediaExtra("media_extra").build();
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            this.f30863h.loadRewardVideoAd(build, new a(this, funAdSlot));
            onLoadStart();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, obj)) == null) {
            TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
            this.mReporter.recordShowStart();
            tTRewardVideoAd.setRewardAdInteractionListener(new h0(this, tTRewardVideoAd));
            tTRewardVideoAd.setDownloadListener(new h(null));
            tTRewardVideoAd.showRewardVideoAd(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
