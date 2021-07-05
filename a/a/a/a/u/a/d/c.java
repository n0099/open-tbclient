package a.a.a.a.u.a.d;

import a.a.a.a.v.e;
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
import com.win.opensdk.PBError;
import com.win.opensdk.PBVideo;
import com.win.opensdk.PBVideoListener;
/* loaded from: classes.dex */
public class c extends a.a.a.a.c<PBVideo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements PBVideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1237a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1238b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBVideo f1239c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f1240d;

        public a(c cVar, PBVideo pBVideo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, pBVideo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1240d = cVar;
            this.f1239c = pBVideo;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.y.d.a();
                this.f1240d.f1017h.a(this.f1238b);
                this.f1238b = true;
                this.f1240d.e();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                a.a.a.a.y.d.b("onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg(), new Object[0]);
                this.f1240d.f1017h.b(Integer.valueOf(pBError.getCode()));
                this.f1240d.b(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.y.d.a();
                this.f1240d.f1017h.b();
                c cVar = this.f1240d;
                cVar.a((c) this.f1239c);
                cVar.h();
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.y.d.a();
                this.f1240d.f1017h.d();
                this.f1240d.f();
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdOpened() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.y.d.a();
                this.f1240d.f1017h.b(this.f1237a);
                this.f1237a = true;
                this.f1240d.a((c) null, (String) null);
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedShowFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                a.a.a.a.y.d.b("onRewardedShowFail: errorCode: 0, , errorMessage: " + str, new Object[0]);
                this.f1240d.f1017h.b(str);
                this.f1240d.a(0, str);
            }
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onUserEarnedReward(boolean z, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
                a.a.a.a.y.d.a();
                this.f1240d.f1017h.f();
                this.f1240d.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e.a aVar) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBVideo pBVideo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBVideo)) == null) {
            PBVideo pBVideo2 = pBVideo;
            this.f1017h.g();
            if (pBVideo2.isReady()) {
                pBVideo2.show();
                return true;
            }
            a.a.a.a.y.d.b("Ad isn't ready now", new Object[0]);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            PBVideo pBVideo = new PBVideo(context.getApplicationContext(), this.f1018i.f1345c);
            pBVideo.setVideoListener(new a(this, pBVideo));
            this.f1017h.a(funAdSlot, this.f1018i);
            pBVideo.load();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBVideo pBVideo) {
        PBVideo pBVideo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBVideo) == null) || (pBVideo2 = pBVideo) == null) {
            return;
        }
        pBVideo2.destroy();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(PBVideo pBVideo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pBVideo)) == null) {
            PBVideo pBVideo2 = pBVideo;
            return pBVideo2 != null && pBVideo2.isReady();
        }
        return invokeL.booleanValue;
    }
}
