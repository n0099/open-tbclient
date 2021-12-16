package c.a.q0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.a1.d;
import c.a.q0.a.h0.m.c;
import c.a.q0.a.h0.m.k;
import c.a.q0.a.z2.j0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class l<T extends k> extends c.a.q0.q.f.b<c.a.q0.q.i.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final T f6101e;

    /* loaded from: classes.dex */
    public class a implements c.InterfaceC0324c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.q.i.i a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f6102b;

        public a(l lVar, c.a.q0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6102b = lVar;
            this.a = iVar;
        }

        @Override // c.a.q0.a.h0.m.c.InterfaceC0324c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f6102b.r(this.a);
            }
        }

        @Override // c.a.q0.a.h0.m.c.InterfaceC0324c
        public void b(PMSDownloadType pMSDownloadType, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6102b.u(this.a, aVar);
            }
        }
    }

    public l(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6101e = t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.q.f.e
    /* renamed from: l */
    public String d(c.a.q0.q.i.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iVar)) == null) ? d.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // c.a.q0.q.f.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f6101e.m(bundle, set) : (Bundle) invokeLL.objValue;
    }

    public PMSDownloadType o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? PMSDownloadType.PLUGIN : (PMSDownloadType) invokeV.objValue;
    }

    public final void p(c.a.q0.q.i.i iVar, c.a.q0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, aVar) == null) {
            u(iVar, aVar);
            c.c().a(iVar, o(), aVar);
        }
    }

    public final void q(@NonNull c.a.q0.q.i.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            r(iVar);
            c.c().b(iVar, o());
        }
    }

    public abstract void r(@NonNull c.a.q0.q.i.i iVar);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
    /* renamed from: s */
    public void e(c.a.q0.q.i.i iVar, c.a.q0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, iVar, bVar) == null) {
            super.e(iVar, bVar);
            c.a.q0.a.w1.e.a.b("plugin download error: " + bVar);
            c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
            aVar.k(17L);
            aVar.i((long) bVar.a);
            aVar.d(bVar.f11016b);
            aVar.f(bVar.toString());
            p(iVar, aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
    /* renamed from: t */
    public void i(c.a.q0.q.i.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            super.i(iVar);
            if (iVar == null) {
                c.a.q0.a.w1.e.a.b("download finish, plugin is null");
                c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
                aVar.k(17L);
                aVar.i(2201L);
                aVar.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, aVar);
            } else if (!j0.a(new File(iVar.a), iVar.m)) {
                c.a.q0.w.d.M(iVar.a);
                c.a.q0.a.w1.e.a.b("download finish, check zip sign failure");
                c.a.q0.a.u2.a aVar2 = new c.a.q0.a.u2.a();
                aVar2.k(17L);
                aVar2.i(2202L);
                aVar2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(iVar, aVar2);
            } else {
                File t = c.a.q0.a.a1.d.t(iVar.f11026g, String.valueOf(iVar.f11028i));
                c.a.q0.w.d.l(t);
                if (t != null && t.exists()) {
                    boolean U = c.a.q0.w.d.U(iVar.a, t.getAbsolutePath());
                    c.a.q0.w.d.M(iVar.a);
                    c.a.q0.a.w1.e.a.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        c.a.q0.a.u2.a aVar3 = new c.a.q0.a.u2.a();
                        aVar3.k(17L);
                        aVar3.i(2320L);
                        aVar3.d("plugin unzip fail.");
                        p(iVar, aVar3);
                        return;
                    }
                    iVar.f11022c = iVar.b();
                    iVar.f11023d = iVar.b();
                    c.a.q0.q.g.a.i().m(iVar);
                    q(iVar);
                    return;
                }
                c.a.q0.w.d.M(iVar.a);
                c.a.q0.a.w1.e.a.b("download finish, create file failure, name = " + iVar.f11026g + " ; version = " + iVar.f11028i);
                c.a.q0.a.u2.a aVar4 = new c.a.q0.a.u2.a();
                aVar4.k(17L);
                aVar4.i(2203L);
                aVar4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(iVar, aVar4);
            }
        }
    }

    public abstract void u(c.a.q0.q.i.i iVar, c.a.q0.a.u2.a aVar);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
    /* renamed from: v */
    public void c(c.a.q0.q.i.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) {
            super.c(iVar);
            if (iVar != null) {
                c.a.q0.a.w1.e.a.b("plugin download start: bundleId = " + iVar.f11026g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
    /* renamed from: w */
    public void f(c.a.q0.q.i.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iVar) == null) {
            super.f(iVar);
            if (iVar != null) {
                c.a.q0.a.w1.e.a.b("plugin on downloading: bundleId = " + iVar.f11026g);
            }
            x(iVar);
        }
    }

    public final void x(c.a.q0.q.i.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iVar) == null) {
            c.c().d(iVar, new a(this, iVar));
        }
    }
}
