package b.a.r0.x0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.x0.q2.l f27620a;

    public p(TbPageContext tbPageContext, b.a.r0.x0.q2.l lVar) {
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
        this.f27620a = lVar;
    }

    public void a(b.a.r0.g.d dVar) {
        b.a.r0.x0.q2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.f27620a) == null || lVar.getModelController() == null || this.f27620a.getModelController().d0() == null || this.f27620a.getFrsView() == null || dVar == null || this.f27620a.getFrsView().a0() == null || this.f27620a.getHeaderVC() == null) {
            return;
        }
        BdTypeRecyclerView a0 = this.f27620a.getFrsView().a0();
        int i2 = dVar.f18121a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                a0.removeHeaderView(dVar.a());
                this.f27620a.getHeaderVC().c0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            a0.removeHeaderView(dVar.a());
            a0.addHeaderView(dVar.a(), a0.getHeaderViewsCount() - 1);
            this.f27620a.getHeaderVC().c0(8);
        }
    }
}
