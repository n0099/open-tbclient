package b.a.r0.j1.m;

import b.a.q0.s.q.d2;
import b.a.r0.x0.k;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.e.l.e.a> f18490a;

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
        this.f18490a = new ArrayList();
        k kVar = (k) MessageManager.getInstance().runTask(2921336, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.f18490a.add(kVar);
        }
        this.f18490a.add(new c(tbPageContext, d2.H3));
        this.f18490a.add(new a(tbPageContext, d2.I3));
        bdTypeRecyclerView.addAdapters(this.f18490a);
    }

    public void a(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageTag) == null) || ListUtils.isEmpty(this.f18490a)) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f18490a) {
            if (aVar instanceof k) {
                ((k) aVar).r0(tbPageTag);
            }
        }
    }
}
