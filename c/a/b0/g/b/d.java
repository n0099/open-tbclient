package c.a.b0.g.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a.b0.w.a.a a(@NonNull c.a.b0.g.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            c.a.b0.w.a.a aVar2 = new c.a.b0.w.a.a();
            aVar2.h(aVar.d());
            aVar2.n(aVar.f1494b);
            aVar2.m(aVar.f1495c.status);
            aVar2.j(aVar.f1496d);
            aVar2.o(aVar.f1499g);
            File file = aVar.f1500h;
            if (file != null) {
                aVar2.f(file.getAbsolutePath());
            } else {
                aVar2.f("");
            }
            aVar2.k((int) (aVar.f1501i * 1000.0f));
            aVar2.p((int) (aVar.f1502j * 1000.0f));
            aVar2.l(aVar.l);
            aVar2.g(aVar.m);
            c.a.b0.g.d.d dVar = aVar.n;
            if (dVar != null) {
                aVar2.i(c.a.b0.g.d.d.a(dVar));
            } else {
                aVar2.i("");
            }
            c.a.b0.g.d.b bVar = aVar.o;
            if (bVar != null) {
                aVar2.d(c.a.b0.g.d.b.a(bVar));
            } else {
                aVar2.d("");
            }
            c.a.b0.g.d.c cVar = aVar.p;
            if (cVar != null) {
                aVar2.e(c.a.b0.g.d.c.a(cVar));
            } else {
                aVar2.e("");
            }
            return aVar2;
        }
        return (c.a.b0.w.a.a) invokeL.objValue;
    }
}
