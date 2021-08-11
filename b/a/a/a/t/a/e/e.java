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
import com.win.opensdk.PBSplash;
import com.win.opensdk.PBSplashListener;
/* loaded from: classes.dex */
public class e extends b.a.a.a.c<PBSplash> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements PBSplashListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1322a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1323b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBSplash f1324c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1325d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f1326e;

        public a(e eVar, PBSplash pBSplash, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, pBSplash, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1326e = eVar;
            this.f1324c = pBSplash;
            this.f1325d = funAdSlot;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.a.a.x.d.a();
                this.f1326e.f1057h.f(this.f1323b);
                this.f1323b = true;
                this.f1326e.r();
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayError(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                b.a.a.a.x.d.a();
                this.f1326e.f1057h.j(Integer.valueOf(pBError.getCode()));
                this.f1326e.g(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.a();
                this.f1326e.f1057h.k(this.f1322a);
                this.f1322a = true;
                this.f1326e.i(this.f1324c, this.f1325d.getSid());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
                b.a.a.a.x.d.f("JySplashAd onError code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1326e.f1057h.e(Integer.valueOf(pBError.getCode()));
                this.f1326e.n(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                b.a.a.a.x.d.a();
                this.f1326e.f1057h.h();
                e eVar = this.f1326e;
                eVar.h(this.f1324c);
                eVar.u();
                this.f1326e.m.c(this.f1324c, this.f1325d.getSid());
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                b.a.a.a.x.d.a();
                this.f1326e.f1057h.q();
                this.f1326e.s();
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onTimeOver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                b.a.a.a.x.d.a();
                b.a.a.a.x.f.g.b.c(this.f1326e.f1057h.f1519a, "splash_timeover", new Object[0]);
                this.f1326e.s();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h.a aVar) {
        super(aVar, true, false, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, PBSplash pBSplash) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBSplash)) == null) {
            this.f1057h.p();
            pBSplash.show(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            this.f1057h.d(funAdSlot, this.f1058i);
            PBSplash pBSplash = new PBSplash(context.getApplicationContext(), this.f1058i.f1448c);
            pBSplash.setLoadTimeOut(5000L);
            pBSplash.setSplashListener(new a(this, pBSplash, funAdSlot));
            pBSplash.load();
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(PBSplash pBSplash) {
        PBSplash pBSplash2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBSplash) == null) || (pBSplash2 = pBSplash) == null) {
            return;
        }
        pBSplash2.destroy();
    }
}
