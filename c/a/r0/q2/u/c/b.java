package c.a.r0.q2.u.c;

import android.view.View;
import c.a.d.m.e.n;
import c.a.d.m.e.s;
import c.a.r0.g0.f0.k;
import c.a.r0.g0.f0.l;
import c.a.r0.q2.u.f.a0;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.q2.y.b f21615b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f21616c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f21617d;

    /* renamed from: e  reason: collision with root package name */
    public s f21618e;

    /* renamed from: f  reason: collision with root package name */
    public c f21619f;

    /* renamed from: g  reason: collision with root package name */
    public d f21620g;

    /* renamed from: h  reason: collision with root package name */
    public e f21621h;

    /* renamed from: i  reason: collision with root package name */
    public f f21622i;

    /* renamed from: j  reason: collision with root package name */
    public g f21623j;

    /* renamed from: k  reason: collision with root package name */
    public h f21624k;
    public PbRecomChildTitleAdapter l;
    public a0 m;

    public b(c.a.r0.q2.y.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f21617d = new ArrayList();
        this.f21618e = sVar;
        this.a = bdUniqueId;
        this.f21615b = bVar;
        this.f21616c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f21617d);
    }

    public List<c.a.d.m.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21617d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.i0() == null) {
                return null;
            }
            return this.l.i0().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21621h = new e(this.f21616c, k.H0);
            this.f21620g = new d(this.f21616c, k.I0);
            this.f21619f = new c(this.f21616c, k.J0);
            this.f21622i = new f(this.f21616c, k.G0);
            this.f21623j = new g(this.f21616c, k.M0);
            this.f21624k = new h(this.f21616c, l.Z);
            this.l = new PbRecomChildTitleAdapter(this.f21615b, c.a.r0.g0.g0.e.f17288f);
            this.m = new a0(this.f21615b, c.a.r0.q2.r.k.f21537g, this.a);
            this.f21617d.add(this.f21621h);
            this.f21617d.add(this.f21620g);
            this.f21617d.add(this.f21619f);
            this.f21617d.add(this.f21622i);
            this.f21617d.add(this.f21623j);
            this.f21617d.add(this.f21624k);
            this.f21617d.add(this.l);
            this.f21617d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f21618e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f21618e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.r0.q2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f21621h.l0(sVar);
            this.f21620g.l0(sVar);
            this.f21619f.l0(sVar);
            this.f21622i.l0(sVar);
            this.f21623j.l0(sVar);
            this.f21624k.o0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f21618e.setData(list);
        }
    }
}
