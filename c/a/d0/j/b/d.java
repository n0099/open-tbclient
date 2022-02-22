package c.a.d0.j.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a.d0.z.a.a a(@NonNull c.a.d0.j.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            c.a.d0.z.a.a aVar2 = new c.a.d0.z.a.a();
            aVar2.h(aVar.d());
            aVar2.n(aVar.f2797b);
            aVar2.m(aVar.f2798c.status);
            aVar2.j(aVar.f2799d);
            aVar2.o(aVar.f2802g);
            File file = aVar.f2803h;
            if (file != null) {
                aVar2.f(file.getAbsolutePath());
            } else {
                aVar2.f("");
            }
            aVar2.k((int) (aVar.f2804i * 1000.0f));
            aVar2.p((int) (aVar.f2805j * 1000.0f));
            aVar2.l(aVar.l);
            aVar2.g(aVar.m);
            c.a.d0.j.d.d dVar = aVar.n;
            if (dVar != null) {
                aVar2.i(c.a.d0.j.d.d.a(dVar));
            } else {
                aVar2.i("");
            }
            c.a.d0.j.d.b bVar = aVar.o;
            if (bVar != null) {
                aVar2.d(c.a.d0.j.d.b.a(bVar));
            } else {
                aVar2.d("");
            }
            c.a.d0.j.d.c cVar = aVar.p;
            if (cVar != null) {
                aVar2.e(c.a.d0.j.d.c.a(cVar));
            } else {
                aVar2.e("");
            }
            return aVar2;
        }
        return (c.a.d0.z.a.a) invokeL.objValue;
    }
}
