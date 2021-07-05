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
import com.win.opensdk.PBSplash;
import com.win.opensdk.PBSplashListener;
/* loaded from: classes.dex */
public class d extends a.a.a.a.c<PBSplash> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements PBSplashListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1241a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1242b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBSplash f1243c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1244d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f1245e;

        public a(d dVar, PBSplash pBSplash, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, pBSplash, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1245e = dVar;
            this.f1243c = pBSplash;
            this.f1244d = funAdSlot;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.y.d.a();
                this.f1245e.f1017h.a(this.f1242b);
                this.f1242b = true;
                this.f1245e.e();
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayError(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                a.a.a.a.y.d.a();
                this.f1245e.f1017h.b(Integer.valueOf(pBError.getCode()));
                this.f1245e.a(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.y.d.a();
                this.f1245e.f1017h.b(this.f1241a);
                this.f1241a = true;
                this.f1245e.a((d) this.f1243c, this.f1244d.getSid());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
                a.a.a.a.y.d.b("JySplashAd onError code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1245e.f1017h.a(Integer.valueOf(pBError.getCode()));
                this.f1245e.b(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.y.d.a();
                this.f1245e.f1017h.b();
                d dVar = this.f1245e;
                dVar.a((d) this.f1243c);
                dVar.h();
                this.f1245e.l.b(this.f1243c, this.f1244d.getSid());
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                a.a.a.a.y.d.a();
                this.f1245e.f1017h.h();
                this.f1245e.f();
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onTimeOver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                a.a.a.a.y.d.a();
                a.a.a.a.y.f.g.c.a(this.f1245e.f1017h.f1409a, "splash_timeover", new Object[0]);
                this.f1245e.f();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e.a aVar) {
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
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBSplash pBSplash) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBSplash)) == null) {
            this.f1017h.g();
            pBSplash.show(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            this.f1017h.a(funAdSlot, this.f1018i);
            PBSplash pBSplash = new PBSplash(context.getApplicationContext(), this.f1018i.f1345c);
            pBSplash.setLoadTimeOut(5000L);
            pBSplash.setSplashListener(new a(this, pBSplash, funAdSlot));
            pBSplash.load();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBSplash pBSplash) {
        PBSplash pBSplash2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBSplash) == null) || (pBSplash2 = pBSplash) == null) {
            return;
        }
        pBSplash2.destroy();
    }
}
