package b.a.a.a.t.a.f;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
/* loaded from: classes.dex */
public class c extends b.a.a.a.c<KsFullScreenVideoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.FullScreenVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1334a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f1335b;

        public a(c cVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1335b = cVar;
            this.f1334a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                b.a.a.a.x.d.f("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1335b.f1057h.e(Integer.valueOf(i2));
                this.f1335b.n(i2, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                b.a.a.a.x.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1335b.f1057h.h();
                    KsFullScreenVideoAd ksFullScreenVideoAd = list.get(0);
                    c cVar = this.f1335b;
                    cVar.h(ksFullScreenVideoAd);
                    cVar.u();
                    this.f1335b.m.c(ksFullScreenVideoAd, this.f1334a.getSid());
                    return;
                }
                b.a.a.a.x.d.f("onNativeAdLoad error: adList is null or empty", new Object[0]);
                this.f1335b.f1057h.e("NoFill");
                this.f1335b.n(0, "NoFill");
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
    public c(h.a aVar) {
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
    public boolean k(Activity activity, ViewGroup viewGroup, String str, KsFullScreenVideoAd ksFullScreenVideoAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, ksFullScreenVideoAd)) == null) {
            KsFullScreenVideoAd ksFullScreenVideoAd2 = ksFullScreenVideoAd;
            if (!ksFullScreenVideoAd2.isAdEnable()) {
                b.a.a.a.x.d.f("Ad isn't ready now.", new Object[0]);
                return false;
            }
            this.f1057h.p();
            ksFullScreenVideoAd2.setFullScreenVideoAdInteractionListener(new d(this, ksFullScreenVideoAd2, str));
            ksFullScreenVideoAd2.showFullScreenVideoAd(activity, this.f1058i.f1455j ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
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
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new a(this, funAdSlot));
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(KsFullScreenVideoAd ksFullScreenVideoAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ksFullScreenVideoAd) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean q(KsFullScreenVideoAd ksFullScreenVideoAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ksFullScreenVideoAd)) == null) {
            KsFullScreenVideoAd ksFullScreenVideoAd2 = ksFullScreenVideoAd;
            return ksFullScreenVideoAd2 != null && ksFullScreenVideoAd2.isAdEnable();
        }
        return invokeL.booleanValue;
    }
}
