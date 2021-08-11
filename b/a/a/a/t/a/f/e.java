package b.a.a.a.t.a.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import b.a.a.a.r;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes.dex */
public class e extends b.a.a.a.c<KsFeedAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.FeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1341a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f1342b;

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
            this.f1342b = eVar;
            this.f1341a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                b.a.a.a.x.d.f("KSNativeExpressAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1342b.f1057h.e(Integer.valueOf(i2));
                this.f1342b.n(i2, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                b.a.a.a.x.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1342b.f1057h.h();
                    KsFeedAd ksFeedAd = list.get(0);
                    e eVar = this.f1342b;
                    eVar.h(ksFeedAd);
                    eVar.u();
                    this.f1342b.m.c(ksFeedAd, this.f1341a.getSid());
                    return;
                }
                b.a.a.a.x.d.f("onNativeAdLoad error: adList is null or empty", new Object[0]);
                this.f1342b.f1057h.e("NoFill");
                onError(0, "NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.a.a.c
    public b.a.a.a.w.a e(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new b.a.a.a.w.m(aVar) : (b.a.a.a.w.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, KsFeedAd ksFeedAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, ksFeedAd)) == null) {
            KsFeedAd ksFeedAd2 = ksFeedAd;
            View feedView = ksFeedAd2.getFeedView(activity);
            this.f1057h.p();
            ksFeedAd2.setAdInteractionListener(new f(this, ksFeedAd2, str, feedView));
            ksFeedAd2.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
            if (feedView != null && feedView.getParent() != null) {
                ((ViewGroup) feedView.getParent()).removeView(feedView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int a2 = r.a(10.0f);
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            layoutParams.topMargin = a2;
            layoutParams.bottomMargin = a2;
            viewGroup.removeAllViews();
            viewGroup.addView(feedView, layoutParams);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.f1058i.f1448c)).adNum(1).build();
            this.f1057h.d(funAdSlot, this.f1058i);
            KsAdSDK.getLoadManager().loadFeedAd(build, new a(this, funAdSlot));
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(KsFeedAd ksFeedAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ksFeedAd) == null) {
        }
    }
}
