package b.a.r0.x0.r1;

import b.a.e.m.e.n;
import b.a.e.m.e.w;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f27778a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27779b;

    /* renamed from: c  reason: collision with root package name */
    public d f27780c;

    /* renamed from: d  reason: collision with root package name */
    public r f27781d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.e.m.e.a> f27782e;

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
        this.f27782e = new ArrayList();
        this.f27778a = frsADFragment;
        this.f27779b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27780c = new d(this.f27778a.getPageContext(), c.l, this.f27778a.getUniqueId());
            this.f27781d = new r(this.f27778a.getPageContext(), s.f27833f);
            this.f27782e.add(this.f27780c);
            this.f27782e.add(this.f27781d);
            e();
            this.f27779b.addAdapters(this.f27782e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27779b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (b.a.e.m.e.a aVar : this.f27782e) {
                if (aVar instanceof k) {
                    ((k) aVar).j0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f27779b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f27782e) || this.f27778a == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27782e) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f27778a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f27782e) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27782e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.c0(wVar);
            }
        }
    }
}
