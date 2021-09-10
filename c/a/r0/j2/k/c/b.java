package c.a.r0.j2.k.c;

import android.view.View;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
import c.a.r0.a0.d0.k;
import c.a.r0.a0.d0.l;
import c.a.r0.j2.h.j;
import c.a.r0.j2.k.e.a0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f19716a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.j2.o.b f19717b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f19718c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19719d;

    /* renamed from: e  reason: collision with root package name */
    public s f19720e;

    /* renamed from: f  reason: collision with root package name */
    public c f19721f;

    /* renamed from: g  reason: collision with root package name */
    public d f19722g;

    /* renamed from: h  reason: collision with root package name */
    public e f19723h;

    /* renamed from: i  reason: collision with root package name */
    public f f19724i;

    /* renamed from: j  reason: collision with root package name */
    public g f19725j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public a0 m;

    public b(c.a.r0.j2.o.b bVar, BdUniqueId bdUniqueId, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19719d = new ArrayList();
        this.f19720e = sVar;
        this.f19716a = bdUniqueId;
        this.f19717b = bVar;
        this.f19718c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f19719d);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19719d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.j0() == null) {
                return null;
            }
            return this.l.j0().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19723h = new e(this.f19718c, k.E0);
            this.f19722g = new d(this.f19718c, k.F0);
            this.f19721f = new c(this.f19718c, k.G0);
            this.f19724i = new f(this.f19718c, k.D0);
            this.f19725j = new g(this.f19718c, k.I0);
            this.k = new h(this.f19718c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f19717b, c.a.r0.a0.e0.e.f15604f);
            this.m = new a0(this.f19717b, j.f19632g, this.f19716a);
            this.f19719d.add(this.f19723h);
            this.f19719d.add(this.f19722g);
            this.f19719d.add(this.f19721f);
            this.f19719d.add(this.f19724i);
            this.f19719d.add(this.f19725j);
            this.f19719d.add(this.k);
            this.f19719d.add(this.l);
            this.f19719d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f19720e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f19720e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f19723h.m0(sVar);
            this.f19722g.m0(sVar);
            this.f19721f.m0(sVar);
            this.f19724i.m0(sVar);
            this.f19725j.m0(sVar);
            this.k.p0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f19720e.setData(list);
        }
    }
}
