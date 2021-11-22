package b.f.a0.c;

import android.content.Context;
import android.view.ViewGroup;
import b.f.a0.c.y;
import b.o.a.d1;
import b.o.a.e1;
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
    public final d1 f31848a;

    /* loaded from: classes6.dex */
    public class a implements e1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f31849a;

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
            this.f31849a = rVar;
        }

        @Override // b.o.a.e1
        public void a() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y.a aVar = (y.a) this.f31849a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31886e.mReporter;
                adReporter.recordSplashSkip();
                aVar.f31886e.onAdClose();
            }
        }

        @Override // b.o.a.e1
        public void b(PBError pBError) {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                r rVar = this.f31849a;
                String msg = pBError.getMsg();
                int code = pBError.getCode();
                y.a aVar = (y.a) rVar;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31886e.mReporter;
                adReporter.recordShowFailed(Integer.valueOf(code));
                aVar.f31886e.onAdError(code, msg);
            }
        }

        @Override // b.o.a.e1
        public void e() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                y.a aVar = (y.a) this.f31849a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31886e.mReporter;
                adReporter.recordSplashTimeOver();
                aVar.f31886e.onAdClose();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ((y.a) this.f31849a).a();
            }
        }

        @Override // b.o.a.e1
        public void onDisplayed() {
            AdReporter adReporter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                y.a aVar = (y.a) this.f31849a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31886e.mReporter;
                adReporter.recordShowSucceed(aVar.f31882a);
                aVar.f31882a = true;
                aVar.f31886e.onAdShow(aVar.f31884c);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) {
                ((y.a) this.f31849a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ((y.a) this.f31849a).c();
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
        this.f31848a = new d1(context.getApplicationContext(), str);
    }

    @Override // b.f.a0.c.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31848a.j();
        }
    }

    @Override // b.f.a0.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31848a.l();
        }
    }

    @Override // b.f.a0.c.h
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f31848a.m(j);
        }
    }

    @Override // b.f.a0.c.h
    public void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.f31848a.o(viewGroup);
        }
    }

    @Override // b.f.a0.c.h
    public void e(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rVar) == null) {
            this.f31848a.n(new a(this, rVar));
        }
    }
}
