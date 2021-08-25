package c.b.c.b.h.a;

import android.content.Context;
import c.b.c.b.l;
import c.b.c.b.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, b bVar, d dVar) {
        super(com.bytedance.tea.crash.c.f68728b, context, bVar, dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.bytedance.tea.crash.c) objArr2[0], (Context) objArr2[1], (b) objArr2[2], (d) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.b.c.b.h.a.c
    public c.b.c.b.e.a a(c.b.c.b.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            c.b.c.b.e.a a2 = super.a(aVar);
            a2.k("app_count", 1);
            a2.k("magic_tag", "ss_app_log");
            e(a2);
            c.b.c.b.e.b a3 = c.b.c.b.e.b.a(this.f31437b);
            a3.d(m.a().a());
            a3.c(m.d().a());
            a3.g(this.f31438c.c());
            a2.d(a3);
            l.C1450l.b(a2, a3, this.f31436a);
            return a2;
        }
        return (c.b.c.b.e.a) invokeL.objValue;
    }
}
