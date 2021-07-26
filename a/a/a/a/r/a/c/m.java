package a.a.a.a.r.a.c;

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
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m extends a.a.a.a.b<SplashAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<SplashAD, String> n;

    /* loaded from: classes.dex */
    public class a implements SplashADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1208a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SplashAD[] f1210c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1211d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f1212e;

        public a(m mVar, SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, splashADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1212e = mVar;
            this.f1210c = splashADArr;
            this.f1211d = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.v.d.a();
                this.f1212e.f1015h.a(this.f1209b);
                this.f1209b = true;
                this.f1212e.e();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.a.a.a.v.d.a();
                this.f1212e.f1015h.d();
                this.f1212e.f();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.a();
                this.f1212e.f1015h.b(this.f1208a);
                this.f1208a = true;
                SplashAD splashAD = this.f1210c[0];
                m mVar = this.f1212e;
                mVar.a((m) splashAD, mVar.n.remove(splashAD));
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                a.a.a.a.v.d.a();
                this.f1212e.f1015h.b();
                SplashAD splashAD = this.f1210c[0];
                this.f1212e.n.put(splashAD, this.f1211d.getSid());
                m mVar = this.f1212e;
                mVar.a((m) splashAD);
                mVar.h();
                this.f1212e.l.b(splashAD, this.f1211d.getSid());
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.v.d.a();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                a.a.a.a.v.d.a();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, adError) == null) {
                int errorCode = adError.getErrorCode();
                a.a.a.a.v.d.b("onNoAD code: " + errorCode + ", message: " + adError.getErrorMsg(), new Object[0]);
                if (errorCode == 4005) {
                    this.f1212e.f1015h.b(Integer.valueOf(errorCode));
                    this.f1212e.a(errorCode, adError.getErrorMsg());
                    return;
                }
                this.f1212e.f1015h.a(Integer.valueOf(errorCode));
                this.f1212e.b(errorCode, adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h.a aVar) {
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
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.j(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, splashAD)) == null) {
            SplashAD splashAD2 = splashAD;
            this.f1015h.g();
            this.n.put(splashAD2, str);
            splashAD2.showAd(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            a aVar = new a(this, r0, funAdSlot);
            this.f1015h.a(funAdSlot, this.f1016i);
            SplashAD splashAD = new SplashAD(context.getApplicationContext(), this.f1016i.f1361c, aVar, 0);
            SplashAD[] splashADArr = {splashAD};
            splashAD.fetchAdOnly();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(SplashAD splashAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, splashAD) == null) {
            this.n.remove(splashAD);
        }
    }
}
