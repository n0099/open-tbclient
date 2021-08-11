package c.a.p0.v0.g1;

import c.a.e.k.e.n;
import c.a.e.k.e.w;
import c.a.p0.v0.k;
import c.a.p0.v0.r;
import c.a.p0.v0.s;
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
    public FrsADFragment f25753a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f25754b;

    /* renamed from: c  reason: collision with root package name */
    public d f25755c;

    /* renamed from: d  reason: collision with root package name */
    public r f25756d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.k.e.a> f25757e;

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
        this.f25757e = new ArrayList();
        this.f25753a = frsADFragment;
        this.f25754b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25755c = new d(this.f25753a.getPageContext(), c.l, this.f25753a.getUniqueId());
            this.f25756d = new r(this.f25753a.getPageContext(), s.f26816f);
            this.f25757e.add(this.f25755c);
            this.f25757e.add(this.f25756d);
            e();
            this.f25754b.addAdapters(this.f25757e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25754b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c.a.e.k.e.a aVar : this.f25757e) {
                if (aVar instanceof k) {
                    ((k) aVar).k0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f25754b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f25757e) || this.f25753a == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25757e) {
            if (aVar instanceof k) {
                ((k) aVar).s0(this.f25753a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f25757e) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25757e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.d0(wVar);
            }
        }
    }
}
