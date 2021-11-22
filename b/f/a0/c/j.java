package b.f.a0.c;

import android.content.Context;
import b.f.a0.c.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBError;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes6.dex */
public class j extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PBInterstitial f31842a;

    /* loaded from: classes6.dex */
    public class a implements PBInterstitialListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f31843a;

        public a(j jVar, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31843a = oVar;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((u.a) this.f31843a).a();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                ((u.a) this.f31843a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                u.a aVar = (u.a) this.f31843a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31867d.mReporter;
                adReporter.recordOnClosed();
                aVar.f31867d.onAdClose();
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                u.a aVar = (u.a) this.f31843a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31867d.mReporter;
                adReporter.recordShowSucceed(aVar.f31864a);
                aVar.f31864a = true;
                aVar.f31867d.onAdShow(aVar.f31866c);
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                u.a aVar = (u.a) this.f31843a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31867d.mReporter;
                adReporter.recordShowFailed(0);
                aVar.f31867d.onAdError(0, str);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                ((u.a) this.f31843a).c();
            }
        }
    }

    public j(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31842a = new PBInterstitial(context.getApplicationContext(), str);
    }

    @Override // b.f.a0.c.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31842a.destroy();
        }
    }

    @Override // b.f.a0.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31842a.load();
        }
    }

    @Override // b.f.a0.c.e
    public void c(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVar) == null) {
            this.f31842a.setInterstitialListener(new a(this, oVar));
        }
    }

    @Override // b.f.a0.c.e
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31842a.isReady() : invokeV.booleanValue;
    }

    @Override // b.f.a0.c.e
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f31842a.show();
        }
    }
}
