package b.g.a0.d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends BasePidLoader<KsFeedAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.FeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f31054a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f31055b;

        public a(j jVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31055b = jVar;
            this.f31054a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogPrinter.e("KSNativeExpressAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f31055b.mReporter.recordLoadFailed(Integer.valueOf(i2));
                this.f31055b.onError(i2, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onNativeAdLoad error: adList is null or empty", new Object[0]);
                    this.f31055b.mReporter.recordLoadFailed("NoFill");
                    onError(0, "NoFill");
                    return;
                }
                this.f31055b.mReporter.recordLoadSucceed();
                KsFeedAd ksFeedAd = list.get(0);
                this.f31055b.onAdLoaded((j) ksFeedAd);
                this.f31055b.mAdRipper.report(ksFeedAd, this.f31054a.getSid());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final KsFeedAd f31056a;

        /* renamed from: b  reason: collision with root package name */
        public final View f31057b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31058c;

        /* renamed from: d  reason: collision with root package name */
        public FunAdInteractionListener f31059d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31060e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31061f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f31062g;

        public b(j jVar, KsFeedAd ksFeedAd, View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, ksFeedAd, view, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31062g = jVar;
            this.f31056a = ksFeedAd;
            this.f31057b = view;
            this.f31058c = str;
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.f31062g.mReporter.recordOnClicked(this.f31061f);
                this.f31061f = true;
                this.f31062g.onAdClicked();
                FunAdInteractionListener funAdInteractionListener = this.f31059d;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClicked(this.f31058c, this.f31062g.mPid.ssp.type, this.f31062g.mPid.pid);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f31062g.mReporter.recordShowSucceed(this.f31060e);
                this.f31060e = true;
                this.f31062g.onAdShow(this.f31056a);
                FunAdInteractionListener funAdInteractionListener = this.f31059d;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdShow(this.f31058c, this.f31062g.mPid.ssp.type, this.f31062g.mPid.pid);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f31062g.mReporter.recordUnlikeSelected();
                View view = this.f31057b;
                if (view != null && view.getParent() != null) {
                    ((ViewGroup) this.f31057b.getParent()).removeView(this.f31057b);
                }
                this.f31062g.onAdClose();
                FunAdInteractionListener funAdInteractionListener = this.f31059d;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(this.f31058c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Ssp.Pid pid) {
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

    public final View a(Context context, KsFeedAd ksFeedAd) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ksFeedAd)) == null) {
            View feedView = ksFeedAd.getFeedView(context);
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int dp2px = PxUtils.dp2px(10.0f);
            layoutParams.leftMargin = dp2px;
            layoutParams.rightMargin = dp2px;
            layoutParams.topMargin = dp2px;
            layoutParams.bottomMargin = dp2px;
            frameLayout.addView(feedView, layoutParams);
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid)) == null) ? new y(pid) : (AdRipper) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(KsFeedAd ksFeedAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksFeedAd) == null) {
        }
    }

    public final void e(KsFeedAd ksFeedAd, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, ksFeedAd, bVar) == null) {
            ksFeedAd.setAdInteractionListener(bVar);
            ksFeedAd.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, KsFeedAd ksFeedAd) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, ksFeedAd)) == null) ? new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, ksFeedAd, new k(this, context)) : (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(1).build();
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            KsAdSDK.getLoadManager().loadFeedAd(build, new a(this, funAdSlot));
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, KsFeedAd ksFeedAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, ksFeedAd)) == null) {
            KsFeedAd ksFeedAd2 = ksFeedAd;
            View a2 = a(activity, ksFeedAd2);
            this.mReporter.recordShowStart();
            e(ksFeedAd2, new b(this, ksFeedAd2, a2, str));
            if (a2.getParent() != null) {
                ((ViewGroup) a2.getParent()).removeView(a2);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
