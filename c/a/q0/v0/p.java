package c.a.q0.v0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.v0.e2.l f26889a;

    public p(TbPageContext tbPageContext, c.a.q0.v0.e2.l lVar) {
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
        this.f26889a = lVar;
    }

    public void a(c.a.q0.f.d dVar) {
        c.a.q0.v0.e2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.f26889a) == null || lVar.getModelController() == null || this.f26889a.getModelController().d0() == null || this.f26889a.getFrsView() == null || dVar == null || this.f26889a.getFrsView().b0() == null || this.f26889a.getHeaderVC() == null) {
            return;
        }
        BdTypeRecyclerView b0 = this.f26889a.getFrsView().b0();
        int i2 = dVar.f17135a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                b0.removeHeaderView(dVar.a());
                this.f26889a.getHeaderVC().c0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            b0.removeHeaderView(dVar.a());
            b0.addHeaderView(dVar.a(), b0.getHeaderViewsCount() - 1);
            this.f26889a.getHeaderVC().c0(8);
        }
    }
}
