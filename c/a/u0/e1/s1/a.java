package c.a.u0.e1.s1;

import c.a.d.o.e.n;
import c.a.d.o.e.v;
import c.a.u0.e1.k;
import c.a.u0.e1.r;
import c.a.u0.e1.s;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsADFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17042b;

    /* renamed from: c  reason: collision with root package name */
    public d f17043c;

    /* renamed from: d  reason: collision with root package name */
    public r f17044d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.o.e.a> f17045e;

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
        this.f17045e = new ArrayList();
        this.a = frsADFragment;
        this.f17042b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17043c = new d(this.a.getPageContext(), c.l, this.a.getUniqueId());
            this.f17044d = new r(this.a.getPageContext(), s.f17040f);
            this.f17045e.add(this.f17043c);
            this.f17045e.add(this.f17044d);
            e();
            this.f17042b.addAdapters(this.f17045e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17042b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c.a.d.o.e.a aVar : this.f17045e) {
                if (aVar instanceof k) {
                    ((k) aVar).c0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f17042b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f17045e) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f17045e) {
            if (aVar instanceof k) {
                ((k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public void f(v vVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vVar) == null) || (list = this.f17045e) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f17045e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.V(vVar);
            }
        }
    }
}
