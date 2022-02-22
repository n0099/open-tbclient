package c.a.u0.m0.f.e;

import c.b.a.a.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class a extends c.a.u0.m0.f.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(c.a.u0.m0.f.a context) {
        super(context, r3, null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.u0.m0.f.a) objArr2[0], (g) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        g b2 = g.i(c.a.u0.m0.f.d.d.b.class).b();
        Intrinsics.checkNotNullExpressionValue(b2, "one(ActionComponent::class.java).get()");
    }

    @Override // c.a.u0.m0.f.c.d
    public void l(c.b.a.a.d entity, float f2) {
        c.a.u0.m0.f.d.d.b a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, entity, f2) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            c.a.u0.m0.f.d.b b2 = c.a.u0.m0.g.d.b(entity);
            c.a.u0.m0.e.a a2 = b2 == null ? null : b2.a();
            if (a2 == null || (a = c.a.u0.m0.g.d.a(entity)) == null) {
                return;
            }
            if (c.a.u0.m0.g.c.b(this) >= a2.e().k()) {
                a.h(true);
                a.c(c.a.u0.m0.g.c.b(this) - a2.e().k());
                return;
            }
            a.h(false);
        }
    }
}
