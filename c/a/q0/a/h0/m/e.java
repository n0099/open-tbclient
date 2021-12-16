package c.a.q0.a.h0.m;

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
    public static final boolean f6060k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f6061g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.q.p.g f6062h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.a.u2.a f6063i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.q0.q.f.e<c.a.q0.q.i.i> f6064j;

    /* loaded from: classes.dex */
    public class a extends l<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f6065f;

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
            this.f6065f = eVar;
        }

        @Override // c.a.q0.a.h0.m.l
        public void r(@NonNull c.a.q0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (e.f6060k) {
                    String str = "onDownloadAndUnzipSuccess:" + iVar;
                }
                this.f6065f.f6061g.incrementAndGet();
            }
        }

        @Override // c.a.q0.a.h0.m.l
        public void u(c.a.q0.q.i.i iVar, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                c.a.q0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
                if (this.f6065f.f6063i == null) {
                    this.f6065f.f6063i = aVar;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216130247, "Lc/a/q0/a/h0/m/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216130247, "Lc/a/q0/a/h0/m/e;");
                return;
            }
        }
        f6060k = c.a.q0.a.k.a;
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
        this.f6061g = new AtomicInteger(0);
        this.f6064j = new a(this, this);
    }

    @Override // c.a.q0.q.f.i
    public void D(c.a.q0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            c.a.q0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + bVar.toString());
            c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
            aVar.k(17L);
            aVar.c(bVar);
            R(aVar);
        }
    }

    @Override // c.a.q0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            c.a.q0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
            aVar.k(17L);
            aVar.i(2901L);
            aVar.d("Server无包");
            R(aVar);
        }
    }

    @Override // c.a.q0.q.f.i
    public void H(c.a.q0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.H(gVar);
            this.f6062h = gVar;
            if (f6060k) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(gVar == null ? 0 : gVar.n());
                sb.toString();
            }
        }
    }

    public abstract void R(@NonNull c.a.q0.a.u2.a aVar);

    public abstract void S();

    @Override // c.a.q0.q.f.i, c.a.q0.q.f.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            c.a.q0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            c.a.q0.q.p.g gVar = this.f6062h;
            if (gVar == null) {
                c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
                aVar.k(17L);
                aVar.i(2900L);
                aVar.d("unknown error.");
                R(aVar);
                return;
            }
            int n = gVar.n() - this.f6061g.get();
            if (n == 0) {
                S();
                return;
            }
            if (this.f6063i == null) {
                c.a.q0.a.u2.a aVar2 = new c.a.q0.a.u2.a();
                aVar2.k(17L);
                aVar2.i(2900L);
                aVar2.d("unknown error.");
                this.f6063i = aVar2;
            }
            c.a.q0.a.u2.a aVar3 = this.f6063i;
            aVar3.f("failCount:" + n);
            R(this.f6063i);
        }
    }

    @Override // c.a.q0.q.f.i
    public c.a.q0.q.f.e<c.a.q0.q.i.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6064j : (c.a.q0.q.f.e) invokeV.objValue;
    }
}
