package b.g.a0.c;

import android.content.Context;
import android.view.ViewGroup;
import b.g.a0.c.y;
import b.q.a.d1;
import b.q.a.e1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class m extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d1 f30990a;

    /* loaded from: classes6.dex */
    public class a implements e1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f30991a;

        public a(m mVar, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30991a = rVar;
        }

        @Override // b.q.a.e1
        public void a() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y.a aVar = (y.a) this.f30991a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31028e.mReporter;
                adReporter.recordSplashSkip();
                aVar.f31028e.onAdClose();
            }
        }

        @Override // b.q.a.e1
        public void b(PBError pBError) {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                r rVar = this.f30991a;
                String msg = pBError.getMsg();
                int code = pBError.getCode();
                y.a aVar = (y.a) rVar;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31028e.mReporter;
                adReporter.recordShowFailed(Integer.valueOf(code));
                aVar.f31028e.onAdError(code, msg);
            }
        }

        @Override // b.q.a.e1
        public void e() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                y.a aVar = (y.a) this.f30991a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31028e.mReporter;
                adReporter.recordSplashTimeOver();
                aVar.f31028e.onAdClose();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ((y.a) this.f30991a).a();
            }
        }

        @Override // b.q.a.e1
        public void onDisplayed() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                y.a aVar = (y.a) this.f30991a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31028e.mReporter;
                adReporter.recordShowSucceed(aVar.f31024a);
                aVar.f31024a = true;
                aVar.f31028e.onAdShow(aVar.f31026c);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) {
                ((y.a) this.f30991a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ((y.a) this.f30991a).c();
            }
        }
    }

    public m(Context context, String str) {
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
        this.f30990a = new d1(context.getApplicationContext(), str);
    }

    @Override // b.g.a0.c.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30990a.j();
        }
    }

    @Override // b.g.a0.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30990a.l();
        }
    }

    @Override // b.g.a0.c.h
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f30990a.m(j);
        }
    }

    @Override // b.g.a0.c.h
    public void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.f30990a.o(viewGroup);
        }
    }

    @Override // b.g.a0.c.h
    public void e(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rVar) == null) {
            this.f30990a.n(new a(this, rVar));
        }
    }
}
