package c.a.q0.h1.d;

import c.a.p0.s.q.c2;
import c.a.q0.v0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.l.e.a> f18671a;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18671a = new ArrayList();
        k kVar = (k) MessageManager.getInstance().runTask(2921336, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.f18671a.add(kVar);
        }
        this.f18671a.add(new c(tbPageContext, c2.D3));
        this.f18671a.add(new a(tbPageContext, c2.E3));
        bdTypeRecyclerView.addAdapters(this.f18671a);
    }

    public void a(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageTag) == null) || ListUtils.isEmpty(this.f18671a)) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f18671a) {
            if (aVar instanceof k) {
                ((k) aVar).s0(tbPageTag);
            }
        }
    }
}
