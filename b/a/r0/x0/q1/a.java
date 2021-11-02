package b.a.r0.x0.q1;

import b.a.e.l.e.n;
import b.a.e.l.e.w;
import b.a.r0.x0.k;
import b.a.r0.x0.r;
import b.a.r0.x0.s;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f26183a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26184b;

    /* renamed from: c  reason: collision with root package name */
    public d f26185c;

    /* renamed from: d  reason: collision with root package name */
    public r f26186d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.e.l.e.a> f26187e;

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
        this.f26187e = new ArrayList();
        this.f26183a = frsADFragment;
        this.f26184b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26185c = new d(this.f26183a.getPageContext(), c.l, this.f26183a.getUniqueId());
            this.f26186d = new r(this.f26183a.getPageContext(), s.f26311f);
            this.f26187e.add(this.f26185c);
            this.f26187e.add(this.f26186d);
            e();
            this.f26184b.addAdapters(this.f26187e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26184b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (b.a.e.l.e.a aVar : this.f26187e) {
                if (aVar instanceof k) {
                    ((k) aVar).j0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f26184b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f26187e) || this.f26183a == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26187e) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f26183a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f26187e) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26187e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.c0(wVar);
            }
        }
    }
}
