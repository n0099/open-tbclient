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
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes.dex */
public class b extends b.a.a.a.c<PBInterstitial> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements PBInterstitialListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1307a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1308b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBInterstitial f1309c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f1310d;

        public a(b bVar, PBInterstitial pBInterstitial) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pBInterstitial};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1310d = bVar;
            this.f1309c = pBInterstitial;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.a.a.x.d.a();
                this.f1310d.f1057h.f(this.f1308b);
                this.f1308b = true;
                this.f1310d.r();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                b.a.a.a.x.d.f("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1310d.f1057h.e(Integer.valueOf(pBError.getCode()));
                this.f1310d.n(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.a();
                this.f1310d.f1057h.m();
                this.f1310d.s();
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.a.a.a.x.d.a();
                this.f1310d.f1057h.k(this.f1307a);
                this.f1307a = true;
                this.f1310d.i(null, null);
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                b.a.a.a.x.d.a();
                this.f1310d.f1057h.j(0);
                this.f1310d.g(0, str);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                b.a.a.a.x.d.a();
                this.f1310d.f1057h.h();
                b bVar = this.f1310d;
                bVar.h(this.f1309c);
                bVar.u();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(h.a aVar) {
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
    public boolean k(Activity activity, ViewGroup viewGroup, String str, PBInterstitial pBInterstitial) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBInterstitial)) == null) {
            PBInterstitial pBInterstitial2 = pBInterstitial;
            this.f1057h.p();
            if (pBInterstitial2.isReady()) {
                pBInterstitial2.show();
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
            PBInterstitial pBInterstitial = new PBInterstitial(context.getApplicationContext(), this.f1058i.f1448c);
            pBInterstitial.setInterstitialListener(new a(this, pBInterstitial));
            this.f1057h.d(funAdSlot, this.f1058i);
            pBInterstitial.load();
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBInterstitial) == null) || (pBInterstitial2 = pBInterstitial) == null) {
            return;
        }
        pBInterstitial2.destroy();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean q(PBInterstitial pBInterstitial) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pBInterstitial)) == null) {
            PBInterstitial pBInterstitial2 = pBInterstitial;
            return pBInterstitial2 != null && pBInterstitial2.isReady();
        }
        return invokeL.booleanValue;
    }
}
