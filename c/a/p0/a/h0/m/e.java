package c.a.p0.a.h0.m;

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

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f5751k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f5752g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.q.p.g f5753h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.a.u2.a f5754i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.p0.q.f.e<c.a.p0.q.i.i> f5755j;

    /* loaded from: classes.dex */
    public class a extends l<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5756f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, e eVar2) {
            super(eVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, eVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5756f = eVar;
        }

        @Override // c.a.p0.a.h0.m.l
        public void r(@NonNull c.a.p0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (e.f5751k) {
                    String str = "onDownloadAndUnzipSuccess:" + iVar;
                }
                this.f5756f.f5752g.incrementAndGet();
            }
        }

        @Override // c.a.p0.a.h0.m.l
        public void u(c.a.p0.q.i.i iVar, c.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                c.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
                if (this.f5756f.f5754i == null) {
                    this.f5756f.f5754i = aVar;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087047528, "Lc/a/p0/a/h0/m/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087047528, "Lc/a/p0/a/h0/m/e;");
                return;
            }
        }
        f5751k = c.a.p0.a.k.a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5752g = new AtomicInteger(0);
        this.f5755j = new a(this, this);
    }

    @Override // c.a.p0.q.f.i
    public void D(c.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            c.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + bVar.toString());
            c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
            aVar.k(17L);
            aVar.c(bVar);
            R(aVar);
        }
    }

    @Override // c.a.p0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            c.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
            aVar.k(17L);
            aVar.i(2901L);
            aVar.d("Server无包");
            R(aVar);
        }
    }

    @Override // c.a.p0.q.f.i
    public void H(c.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.H(gVar);
            this.f5753h = gVar;
            if (f5751k) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(gVar == null ? 0 : gVar.n());
                sb.toString();
            }
        }
    }

    public abstract void R(@NonNull c.a.p0.a.u2.a aVar);

    public abstract void S();

    @Override // c.a.p0.q.f.i, c.a.p0.q.f.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            c.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            c.a.p0.q.p.g gVar = this.f5753h;
            if (gVar == null) {
                c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
                aVar.k(17L);
                aVar.i(2900L);
                aVar.d("unknown error.");
                R(aVar);
                return;
            }
            int n = gVar.n() - this.f5752g.get();
            if (n == 0) {
                S();
                return;
            }
            if (this.f5754i == null) {
                c.a.p0.a.u2.a aVar2 = new c.a.p0.a.u2.a();
                aVar2.k(17L);
                aVar2.i(2900L);
                aVar2.d("unknown error.");
                this.f5754i = aVar2;
            }
            c.a.p0.a.u2.a aVar3 = this.f5754i;
            aVar3.f("failCount:" + n);
            R(this.f5754i);
        }
    }

    @Override // c.a.p0.q.f.i
    public c.a.p0.q.f.e<c.a.p0.q.i.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5755j : (c.a.p0.q.f.e) invokeV.objValue;
    }
}
