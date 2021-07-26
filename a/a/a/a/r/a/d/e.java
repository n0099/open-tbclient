package a.a.a.a.r.a.d;

import a.a.a.a.s.h;
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
public class e extends a.a.a.a.b<PBSplash> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements PBSplashListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1243a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1244b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBSplash f1245c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1246d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f1247e;

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
            this.f1247e = eVar;
            this.f1245c = pBSplash;
            this.f1246d = funAdSlot;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.v.d.a();
                this.f1247e.f1015h.a(this.f1244b);
                this.f1244b = true;
                this.f1247e.e();
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayError(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                a.a.a.a.v.d.a();
                this.f1247e.f1015h.b(Integer.valueOf(pBError.getCode()));
                this.f1247e.a(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.a();
                this.f1247e.f1015h.b(this.f1243a);
                this.f1243a = true;
                this.f1247e.a((e) this.f1245c, this.f1246d.getSid());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
                a.a.a.a.v.d.b("JySplashAd onError code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1247e.f1015h.a(Integer.valueOf(pBError.getCode()));
                this.f1247e.b(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.v.d.a();
                this.f1247e.f1015h.b();
                e eVar = this.f1247e;
                eVar.a((e) this.f1245c);
                eVar.h();
                this.f1247e.l.b(this.f1245c, this.f1246d.getSid());
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                a.a.a.a.v.d.a();
                this.f1247e.f1015h.h();
                this.f1247e.f();
            }
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onTimeOver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                a.a.a.a.v.d.a();
                a.a.a.a.v.g.g.c.a(this.f1247e.f1015h.f1441a, "splash_timeover", new Object[0]);
                this.f1247e.f();
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBSplash pBSplash) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBSplash)) == null) {
            this.f1015h.g();
            pBSplash.show(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            this.f1015h.a(funAdSlot, this.f1016i);
            PBSplash pBSplash = new PBSplash(context.getApplicationContext(), this.f1016i.f1361c);
            pBSplash.setLoadTimeOut(5000L);
            pBSplash.setSplashListener(new a(this, pBSplash, funAdSlot));
            pBSplash.load();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(PBSplash pBSplash) {
        PBSplash pBSplash2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBSplash) == null) || (pBSplash2 = pBSplash) == null) {
            return;
        }
        pBSplash2.destroy();
    }
}
