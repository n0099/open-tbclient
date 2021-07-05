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
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes.dex */
public class a extends a.a.a.a.c<PBInterstitial> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a.a.a.a.u.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001a implements PBInterstitialListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1226a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1227b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBInterstitial f1228c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f1229d;

        public C0001a(a aVar, PBInterstitial pBInterstitial) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pBInterstitial};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1229d = aVar;
            this.f1228c = pBInterstitial;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.y.d.a();
                this.f1229d.f1017h.a(this.f1227b);
                this.f1227b = true;
                this.f1229d.e();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                a.a.a.a.y.d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1229d.f1017h.a(Integer.valueOf(pBError.getCode()));
                this.f1229d.b(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.y.d.a();
                this.f1229d.f1017h.d();
                this.f1229d.f();
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.y.d.a();
                this.f1229d.f1017h.b(this.f1226a);
                this.f1226a = true;
                this.f1229d.a((a) null, (String) null);
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                a.a.a.a.y.d.a();
                this.f1229d.f1017h.b((Object) 0);
                this.f1229d.a(0, str);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                a.a.a.a.y.d.a();
                this.f1229d.f1017h.b();
                a aVar = this.f1229d;
                aVar.a((a) this.f1228c);
                aVar.h();
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBInterstitial pBInterstitial) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBInterstitial)) == null) {
            PBInterstitial pBInterstitial2 = pBInterstitial;
            this.f1017h.g();
            if (pBInterstitial2.isReady()) {
                pBInterstitial2.show();
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
            PBInterstitial pBInterstitial = new PBInterstitial(context.getApplicationContext(), this.f1018i.f1345c);
            pBInterstitial.setInterstitialListener(new C0001a(this, pBInterstitial));
            this.f1017h.a(funAdSlot, this.f1018i);
            pBInterstitial.load();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBInterstitial) == null) || (pBInterstitial2 = pBInterstitial) == null) {
            return;
        }
        pBInterstitial2.destroy();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(PBInterstitial pBInterstitial) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pBInterstitial)) == null) {
            PBInterstitial pBInterstitial2 = pBInterstitial;
            return pBInterstitial2 != null && pBInterstitial2.isReady();
        }
        return invokeL.booleanValue;
    }
}
