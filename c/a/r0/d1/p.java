package c.a.r0.d1;

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
    public c.a.r0.d1.h2.l a;

    public p(TbPageContext tbPageContext, c.a.r0.d1.h2.l lVar) {
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

    public void a(c.a.r0.h.d dVar) {
        c.a.r0.d1.h2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.a) == null || lVar.getModelController() == null || this.a.getModelController().d0() == null || this.a.getFrsView() == null || dVar == null || this.a.getFrsView().c0() == null || this.a.getHeaderVC() == null) {
            return;
        }
        BdTypeRecyclerView c0 = this.a.getFrsView().c0();
        int i2 = dVar.a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                c0.removeHeaderView(dVar.a());
                this.a.getHeaderVC().W(0);
            }
        } else if (dVar.a() == null) {
        } else {
            c0.removeHeaderView(dVar.a());
            c0.addHeaderView(dVar.a(), c0.getHeaderViewsCount() - 1);
            this.a.getHeaderVC().W(8);
        }
    }
}
