package c.a.p0.f1.i1;

import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.p0.f1.k;
import c.a.p0.f1.r;
import c.a.p0.f1.s;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsADFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f14061b;

    /* renamed from: c  reason: collision with root package name */
    public d f14062c;

    /* renamed from: d  reason: collision with root package name */
    public r f14063d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14064e;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsADFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14064e = new ArrayList();
        this.a = frsADFragment;
        this.f14061b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14062c = new d(this.a.getPageContext(), c.f14065h, this.a.getUniqueId());
            this.f14063d = new r(this.a.getPageContext(), s.f14508b);
            this.f14064e.add(this.f14062c);
            this.f14064e.add(this.f14063d);
            e();
            this.f14061b.a(this.f14064e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14061b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c.a.d.o.e.a aVar : this.f14064e) {
                if (aVar instanceof k) {
                    ((k) aVar).c0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f14061b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f14064e) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14064e) {
            if (aVar instanceof k) {
                ((k) aVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f14064e) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14064e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.V(wVar);
            }
        }
    }
}
