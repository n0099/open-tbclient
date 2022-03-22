package c.a.n0.a.x.m;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class e extends k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f7254g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f7255c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.q.o.g f7256d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.k2.a f7257e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.n0.q.e.e<c.a.n0.q.h.i> f7258f;

    /* loaded from: classes.dex */
    public class a extends l<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f7259b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, e eVar2) {
            super(eVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, eVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7259b = eVar;
        }

        @Override // c.a.n0.a.x.m.l
        public void r(@NonNull c.a.n0.q.h.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (e.f7254g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + iVar);
                }
                this.f7259b.f7255c.incrementAndGet();
            }
        }

        @Override // c.a.n0.a.x.m.l
        public void u(c.a.n0.q.h.i iVar, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                c.a.n0.a.u.d.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
                if (this.f7259b.f7257e == null) {
                    this.f7259b.f7257e = aVar;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708540, "Lc/a/n0/a/x/m/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708540, "Lc/a/n0/a/x/m/e;");
                return;
            }
        }
        f7254g = c.a.n0.a.a.a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7255c = new AtomicInteger(0);
        this.f7258f = new a(this, this);
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            c.a.n0.a.u.d.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + bVar.toString());
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(17L);
            aVar.c(bVar);
            R(aVar);
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            c.a.n0.a.u.d.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(17L);
            aVar.i(2901L);
            aVar.d("Server无包");
            R(aVar);
        }
    }

    @Override // c.a.n0.q.e.i
    public void H(c.a.n0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.H(gVar);
            this.f7256d = gVar;
            if (f7254g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(gVar == null ? 0 : gVar.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void R(@NonNull c.a.n0.a.k2.a aVar);

    public abstract void S();

    @Override // c.a.n0.q.e.i, c.a.n0.q.e.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            c.a.n0.a.u.d.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            c.a.n0.q.o.g gVar = this.f7256d;
            if (gVar == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(17L);
                aVar.i(2900L);
                aVar.d("unknown error.");
                R(aVar);
                return;
            }
            int n = gVar.n() - this.f7255c.get();
            if (n == 0) {
                S();
                return;
            }
            if (this.f7257e == null) {
                c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                aVar2.k(17L);
                aVar2.i(2900L);
                aVar2.d("unknown error.");
                this.f7257e = aVar2;
            }
            c.a.n0.a.k2.a aVar3 = this.f7257e;
            aVar3.f("failCount:" + n);
            R(this.f7257e);
        }
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7258f : (c.a.n0.q.e.e) invokeV.objValue;
    }
}
