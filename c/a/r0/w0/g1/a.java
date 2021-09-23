package c.a.r0.w0.g1;

import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.r0.w0.k;
import c.a.r0.w0.r;
import c.a.r0.w0.s;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f26745a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26746b;

    /* renamed from: c  reason: collision with root package name */
    public d f26747c;

    /* renamed from: d  reason: collision with root package name */
    public r f26748d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26749e;

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
        this.f26749e = new ArrayList();
        this.f26745a = frsADFragment;
        this.f26746b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26747c = new d(this.f26745a.getPageContext(), c.l, this.f26745a.getUniqueId());
            this.f26748d = new r(this.f26745a.getPageContext(), s.f27776f);
            this.f26749e.add(this.f26747c);
            this.f26749e.add(this.f26748d);
            e();
            this.f26746b.addAdapters(this.f26749e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26746b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c.a.e.l.e.a aVar : this.f26749e) {
                if (aVar instanceof k) {
                    ((k) aVar).k0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f26746b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f26749e) || this.f26745a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26749e) {
            if (aVar instanceof k) {
                ((k) aVar).s0(this.f26745a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f26749e) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26749e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.d0(wVar);
            }
        }
    }
}
