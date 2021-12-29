package c.a.t0.d1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.d1.q2.l a;

    public p(TbPageContext tbPageContext, c.a.t0.d1.q2.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lVar;
    }

    public void a(c.a.t0.h.d dVar) {
        c.a.t0.d1.q2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.a) == null || lVar.getModelController() == null || this.a.getModelController().d0() == null || this.a.getFrsView() == null || dVar == null || this.a.getFrsView().a0() == null || this.a.getHeaderVC() == null) {
            return;
        }
        BdTypeRecyclerView a0 = this.a.getFrsView().a0();
        int i2 = dVar.a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                a0.removeHeaderView(dVar.a());
                this.a.getHeaderVC().V(0);
            }
        } else if (dVar.a() == null) {
        } else {
            a0.removeHeaderView(dVar.a());
            a0.addHeaderView(dVar.a(), a0.getHeaderViewsCount() - 1);
            this.a.getHeaderVC().V(8);
        }
    }
}
