package c.a.u0.a.e;

import android.text.TextUtils;
import c.a.u0.a.c;
import c.a.u0.a.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<String, Long> f30225a;

    /* loaded from: classes4.dex */
    public class a extends c.a.u0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.l f30226e;

        public a(l lVar, com.baidu.ubs.analytics.a.l lVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, lVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30226e = lVar2;
        }

        @Override // c.a.u0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new c.j().c(this.f30226e);
            }
        }
    }

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30225a = new LinkedHashMap<>();
    }

    public final void a(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
        synchronized (this.f30225a) {
            Long remove = this.f30225a.remove(str);
            if (remove == null) {
                return;
            }
            try {
                lVar.setStartTime(String.valueOf(remove));
                lVar.t(str);
                lVar.z(String.valueOf(System.currentTimeMillis()));
                dVar = d.a.f30203a;
                lVar.setPath(dVar.b());
                lVar.x(m.e().I());
            } catch (Exception e2) {
                c.a.u0.a.f.i.a(e2.toString());
                c.a.u0.a.f.a.b(e2.toString());
            }
            c.a.u0.a.f.b.c(new a(this, lVar));
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f30225a) {
            this.f30225a.put(str, Long.valueOf(System.currentTimeMillis()));
            String.valueOf(System.currentTimeMillis());
        }
    }
}
