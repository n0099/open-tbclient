package b.a.p0.a.h0.m;

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
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f5811g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.q.p.g f5812h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.a.u2.a f5813i;
    public final b.a.p0.q.f.e<b.a.p0.q.i.i> j;

    /* loaded from: classes.dex */
    public class a extends l<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5814f;

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
            this.f5814f = eVar;
        }

        @Override // b.a.p0.a.h0.m.l
        public void r(@NonNull b.a.p0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (e.k) {
                    String str = "onDownloadAndUnzipSuccess:" + iVar;
                }
                this.f5814f.f5811g.incrementAndGet();
            }
        }

        @Override // b.a.p0.a.h0.m.l
        public void u(b.a.p0.q.i.i iVar, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                b.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
                if (this.f5814f.f5813i == null) {
                    this.f5814f.f5813i = aVar;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581705, "Lb/a/p0/a/h0/m/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581705, "Lb/a/p0/a/h0/m/e;");
                return;
            }
        }
        k = b.a.p0.a.k.f6863a;
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
        this.f5811g = new AtomicInteger(0);
        this.j = new a(this, this);
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.C(bVar);
            b.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + bVar.toString());
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(17L);
            aVar.c(bVar);
            Q(aVar);
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            b.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(17L);
            aVar.i(2901L);
            aVar.d("Server无包");
            Q(aVar);
        }
    }

    @Override // b.a.p0.q.f.i
    public void G(b.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.G(gVar);
            this.f5812h = gVar;
            if (k) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(gVar == null ? 0 : gVar.n());
                sb.toString();
            }
        }
    }

    public abstract void Q(@NonNull b.a.p0.a.u2.a aVar);

    public abstract void R();

    @Override // b.a.p0.q.f.i, b.a.p0.q.f.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            b.a.p0.a.e0.d.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            b.a.p0.q.p.g gVar = this.f5812h;
            if (gVar == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(17L);
                aVar.i(2900L);
                aVar.d("unknown error.");
                Q(aVar);
                return;
            }
            int n = gVar.n() - this.f5811g.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.f5813i == null) {
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(17L);
                aVar2.i(2900L);
                aVar2.d("unknown error.");
                this.f5813i = aVar2;
            }
            b.a.p0.a.u2.a aVar3 = this.f5813i;
            aVar3.f("failCount:" + n);
            Q(this.f5813i);
        }
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.i> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (b.a.p0.q.f.e) invokeV.objValue;
    }
}
