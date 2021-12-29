package c.a.t0.d1.r1;

import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.t0.d1.k;
import c.a.t0.d1.r;
import c.a.t0.d1.s;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsADFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f16794b;

    /* renamed from: c  reason: collision with root package name */
    public d f16795c;

    /* renamed from: d  reason: collision with root package name */
    public r f16796d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.n.e.a> f16797e;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsADFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16797e = new ArrayList();
        this.a = frsADFragment;
        this.f16794b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16795c = new d(this.a.getPageContext(), c.l, this.a.getUniqueId());
            this.f16796d = new r(this.a.getPageContext(), s.f16847f);
            this.f16797e.add(this.f16795c);
            this.f16797e.add(this.f16796d);
            e();
            this.f16794b.addAdapters(this.f16797e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16794b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c.a.d.n.e.a aVar : this.f16797e) {
                if (aVar instanceof k) {
                    ((k) aVar).c0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f16794b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f16797e) || this.a == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16797e) {
            if (aVar instanceof k) {
                ((k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f16797e) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16797e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.V(wVar);
            }
        }
    }
}
