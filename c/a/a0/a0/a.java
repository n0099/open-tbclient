package c.a.a0.a0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.a0.c.d;
import c.a.a0.a0.c.e;
import c.a.a0.u.g;
import c.a.a0.u.p.b;
import c.a.a0.u.s.c;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0008a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1047b;

        public RunnableC0008a(d dVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f1047b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.d(this.a, this.f1047b);
            }
        }
    }

    public static void b(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dVar) == null) {
            c(dVar, null);
        }
    }

    public static <T> void c(@NonNull d dVar, @Nullable b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, dVar, bVar) == null) {
            if (c.a.a0.a.a && (dVar instanceof ClogBuilder)) {
                ClogBuilder clogBuilder = (ClogBuilder) dVar;
                c.a.a0.i.b.b.a aVar = (c.a.a0.i.b.b.a) c.a.a0.i.b.a.a().a(c.a.a0.i.b.b.a.class);
                if (aVar != null) {
                    aVar.a(clogBuilder.f());
                }
            }
            c.a.a0.d0.b.c(new RunnableC0008a(dVar, bVar), "als_async_executor", 2);
        }
    }

    public static <T> void d(d dVar, @Nullable b<T> bVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, dVar, bVar) == null) && dVar != null && dVar.isValid()) {
            String dVar2 = dVar.toString();
            if (dVar instanceof ClogBuilder) {
                str = c.a.a0.a.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (dVar instanceof e) {
                str = c.a.a0.a.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : TbConfig.REPORT_PLOG;
            } else if (!(dVar instanceof c.a.a0.a0.c.b)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            c cVar = new c();
            cVar.h(dVar2);
            cVar.k(BodyStyle.STRING);
            cVar.i("application/x-www-form-urlencoded");
            c.a.a0.u.s.d dVar3 = new c.a.a0.u.s.d();
            dVar3.k(str);
            dVar3.f(cVar);
            g.b().a().a(dVar3, bVar);
        }
    }
}
