package c.a.t0.s2.u.c;

import android.view.View;
import c.a.d.n.e.n;
import c.a.d.n.e.s;
import c.a.t0.g0.f0.k;
import c.a.t0.g0.f0.l;
import c.a.t0.s2.u.f.a0;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.s2.y.b f23133b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f23134c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f23135d;

    /* renamed from: e  reason: collision with root package name */
    public s f23136e;

    /* renamed from: f  reason: collision with root package name */
    public c f23137f;

    /* renamed from: g  reason: collision with root package name */
    public d f23138g;

    /* renamed from: h  reason: collision with root package name */
    public e f23139h;

    /* renamed from: i  reason: collision with root package name */
    public f f23140i;

    /* renamed from: j  reason: collision with root package name */
    public g f23141j;

    /* renamed from: k  reason: collision with root package name */
    public h f23142k;
    public PbRecomChildTitleAdapter l;
    public a0 m;

    public b(c.a.t0.s2.y.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f23135d = new ArrayList();
        this.f23136e = sVar;
        this.a = bdUniqueId;
        this.f23133b = bVar;
        this.f23134c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f23135d);
    }

    public List<c.a.d.n.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23135d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.b0() == null) {
                return null;
            }
            return this.l.b0().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23139h = new e(this.f23134c, k.I0);
            this.f23138g = new d(this.f23134c, k.J0);
            this.f23137f = new c(this.f23134c, k.K0);
            this.f23140i = new f(this.f23134c, k.H0);
            this.f23141j = new g(this.f23134c, k.N0);
            this.f23142k = new h(this.f23134c, l.Z);
            this.l = new PbRecomChildTitleAdapter(this.f23133b, c.a.t0.g0.g0.e.f18265f);
            this.m = new a0(this.f23133b, c.a.t0.s2.r.k.f23055g, this.a);
            this.f23135d.add(this.f23139h);
            this.f23135d.add(this.f23138g);
            this.f23135d.add(this.f23137f);
            this.f23135d.add(this.f23140i);
            this.f23135d.add(this.f23141j);
            this.f23135d.add(this.f23142k);
            this.f23135d.add(this.l);
            this.f23135d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f23136e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f23136e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f23139h.e0(sVar);
            this.f23138g.e0(sVar);
            this.f23137f.e0(sVar);
            this.f23140i.e0(sVar);
            this.f23141j.e0(sVar);
            this.f23142k.h0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f23136e.setData(list);
        }
    }
}
