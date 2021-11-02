package b.g.a0.c;

import android.content.Context;
import b.g.a0.c.x;
import b.q.a.f1;
import b.q.a.g1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class l extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f1 f30988a;

    /* loaded from: classes6.dex */
    public class a implements g1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f30989a;

        public a(l lVar, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30989a = qVar;
        }

        @Override // b.q.a.g1
        public void c(boolean z, long j) {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
                x.a aVar = (x.a) this.f30989a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31023d.mReporter;
                adReporter.recordReward();
                aVar.f31023d.onRewardedVideo();
            }
        }

        @Override // b.q.a.g1
        public void d(String str) {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                x.a aVar = (x.a) this.f30989a;
                aVar.getClass();
                LogPrinter.e("onRewardedShowFail: errorCode: 0, , errorMessage: " + str, new Object[0]);
                adReporter = aVar.f31023d.mReporter;
                adReporter.recordShowFailed(str);
                aVar.f31023d.onAdError(0, str);
            }
        }

        @Override // b.q.a.g1
        public void f() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                x.a aVar = (x.a) this.f30989a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31023d.mReporter;
                adReporter.recordOnClosed();
                aVar.f31023d.onAdClose();
            }
        }

        @Override // b.q.a.g1
        public void g() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                x.a aVar = (x.a) this.f30989a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31023d.mReporter;
                adReporter.recordShowSucceed(aVar.f31020a);
                aVar.f31020a = true;
                aVar.f31023d.onAdShow(aVar.f31022c);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ((x.a) this.f30989a).a();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) {
                ((x.a) this.f30989a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ((x.a) this.f30989a).c();
            }
        }
    }

    public l(Context context, String str) {
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
        this.f30988a = new f1(context.getApplicationContext(), str);
    }

    @Override // b.g.a0.c.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30988a.a();
        }
    }

    @Override // b.g.a0.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30988a.c();
        }
    }

    @Override // b.g.a0.c.g
    public void c(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qVar) == null) {
            this.f30988a.d(new a(this, qVar));
        }
    }

    @Override // b.g.a0.c.g
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30988a.b() : invokeV.booleanValue;
    }

    @Override // b.g.a0.c.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f30988a.e();
        }
    }
}
