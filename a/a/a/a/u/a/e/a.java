package a.a.a.a.u.a.e;

import a.a.a.a.v.e;
import a.a.a.a.x.n;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes.dex */
public class a extends a.a.a.a.c<KsDrawAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a.a.a.a.u.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0003a implements KsLoadManager.DrawAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1246a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1247b;

        public C0003a(a aVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1247b = aVar;
            this.f1246a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                a.a.a.a.y.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1247b.f1017h.b();
                    for (KsDrawAd ksDrawAd : list) {
                        this.f1247b.l.b(ksDrawAd, this.f1246a.getSid());
                    }
                    this.f1247b.a((List) list);
                    return;
                }
                a.a.a.a.y.d.b("onDrawAdLoad error: adList is null or empty", new Object[0]);
                onError(0, "NoFill");
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1247b.f1017h.a(Integer.valueOf(i2));
                this.f1247b.b(i2, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e.a aVar) {
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
                super((e.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new n(aVar) : (a.a.a.a.x.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsDrawAd ksDrawAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, ksDrawAd)) == null) {
            KsDrawAd ksDrawAd2 = ksDrawAd;
            this.f1017h.g();
            ksDrawAd2.setAdInteractionListener(new b(this, ksDrawAd2, str));
            View drawView = ksDrawAd2.getDrawView(viewGroup.getContext());
            if (drawView == null) {
                a.a.a.a.y.d.b("drawView is null", new Object[0]);
                return false;
            }
            if (drawView.getParent() != null) {
                ((ViewGroup) drawView.getParent()).removeView(drawView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(drawView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.f1018i.f1345c)).adNum(a.a.a.a.a.a(funAdSlot.getAdCount(), 1, 5)).build();
            this.f1017h.a(funAdSlot, this.f1018i);
            KsAdSDK.getLoadManager().loadDrawAd(build, new C0003a(this, funAdSlot));
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsDrawAd ksDrawAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ksDrawAd) == null) {
        }
    }
}
