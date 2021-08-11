package b.a.a.a.t.a.e;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.PBVideo;
import com.win.opensdk.PBVideoListener;
/* loaded from: classes.dex */
public class d extends b.a.a.a.c<PBVideo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements PBVideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1318a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1319b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBVideo f1320c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f1321d;

        public a(d dVar, PBVideo pBVideo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, pBVideo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1321d = dVar;
            this.f1320c = pBVideo;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.a.a.x.d.a();
                this.f1321d.f1057h.f(this.f1319b);
                this.f1319b = true;
                this.f1321d.r();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                b.a.a.a.x.d.f("onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg(), new Object[0]);
                this.f1321d.f1057h.j(Integer.valueOf(pBError.getCode()));
                this.f1321d.n(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.a();
                this.f1321d.f1057h.h();
                d dVar = this.f1321d;
                dVar.h(this.f1320c);
                dVar.u();
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.a.a.a.x.d.a();
                this.f1321d.f1057h.m();
                this.f1321d.s();
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdOpened() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                b.a.a.a.x.d.a();
                this.f1321d.f1057h.k(this.f1318a);
                this.f1318a = true;
                this.f1321d.i(null, null);
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedShowFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                b.a.a.a.x.d.f("onRewardedShowFail: errorCode: 0, , errorMessage: " + str, new Object[0]);
                this.f1321d.f1057h.j(str);
                this.f1321d.g(0, str);
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onUserEarnedReward(boolean z, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
                b.a.a.a.x.d.a();
                this.f1321d.f1057h.o();
                this.f1321d.v();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h.a aVar) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, PBVideo pBVideo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBVideo)) == null) {
            PBVideo pBVideo2 = pBVideo;
            this.f1057h.p();
            if (pBVideo2.isReady()) {
                pBVideo2.show();
                return true;
            }
            b.a.a.a.x.d.f("Ad isn't ready now", new Object[0]);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            PBVideo pBVideo = new PBVideo(context.getApplicationContext(), this.f1058i.f1448c);
            pBVideo.setVideoListener(new a(this, pBVideo));
            this.f1057h.d(funAdSlot, this.f1058i);
            pBVideo.load();
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(PBVideo pBVideo) {
        PBVideo pBVideo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBVideo) == null) || (pBVideo2 = pBVideo) == null) {
            return;
        }
        pBVideo2.destroy();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean q(PBVideo pBVideo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pBVideo)) == null) {
            PBVideo pBVideo2 = pBVideo;
            return pBVideo2 != null && pBVideo2.isReady();
        }
        return invokeL.booleanValue;
    }
}
