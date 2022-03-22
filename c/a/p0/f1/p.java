package c.a.p0.f1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.f1.h2.l a;

    public p(TbPageContext tbPageContext, c.a.p0.f1.h2.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lVar;
    }

    public void a(c.a.p0.h.d dVar) {
        c.a.p0.f1.h2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.a) == null || lVar.b0() == null || this.a.b0().f0() == null || this.a.x0() == null || dVar == null || this.a.x0().c0() == null || this.a.N() == null) {
            return;
        }
        BdTypeRecyclerView c0 = this.a.x0().c0();
        int i = dVar.a;
        if (i != 2) {
            if (i == 3 && dVar.a() != null) {
                c0.removeHeaderView(dVar.a());
                this.a.N().b0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            c0.removeHeaderView(dVar.a());
            c0.t(dVar.a(), c0.getHeaderViewsCount() - 1);
            this.a.N().b0(8);
        }
    }
}
