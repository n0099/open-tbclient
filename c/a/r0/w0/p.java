package c.a.r0.w0;

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
    public c.a.r0.w0.f2.l f27513a;

    public p(TbPageContext tbPageContext, c.a.r0.w0.f2.l lVar) {
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
        this.f27513a = lVar;
    }

    public void a(c.a.r0.f.d dVar) {
        c.a.r0.w0.f2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.f27513a) == null || lVar.getModelController() == null || this.f27513a.getModelController().d0() == null || this.f27513a.getFrsView() == null || dVar == null || this.f27513a.getFrsView().b0() == null || this.f27513a.getHeaderVC() == null) {
            return;
        }
        BdTypeRecyclerView b0 = this.f27513a.getFrsView().b0();
        int i2 = dVar.f17475a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                b0.removeHeaderView(dVar.a());
                this.f27513a.getHeaderVC().c0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            b0.removeHeaderView(dVar.a());
            b0.addHeaderView(dVar.a(), b0.getHeaderViewsCount() - 1);
            this.f27513a.getHeaderVC().c0(8);
        }
    }
}
