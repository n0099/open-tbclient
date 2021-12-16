package c.a.s0.s2.u.c;

import android.view.View;
import c.a.d.m.e.n;
import c.a.d.m.e.s;
import c.a.s0.g0.f0.k;
import c.a.s0.g0.f0.l;
import c.a.s0.s2.u.f.a0;
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
    public c.a.s0.s2.y.b f22621b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f22622c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f22623d;

    /* renamed from: e  reason: collision with root package name */
    public s f22624e;

    /* renamed from: f  reason: collision with root package name */
    public c f22625f;

    /* renamed from: g  reason: collision with root package name */
    public d f22626g;

    /* renamed from: h  reason: collision with root package name */
    public e f22627h;

    /* renamed from: i  reason: collision with root package name */
    public f f22628i;

    /* renamed from: j  reason: collision with root package name */
    public g f22629j;

    /* renamed from: k  reason: collision with root package name */
    public h f22630k;
    public PbRecomChildTitleAdapter l;
    public a0 m;

    public b(c.a.s0.s2.y.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f22623d = new ArrayList();
        this.f22624e = sVar;
        this.a = bdUniqueId;
        this.f22621b = bVar;
        this.f22622c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f22623d);
    }

    public List<c.a.d.m.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22623d : (List) invokeV.objValue;
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
            this.f22627h = new e(this.f22622c, k.H0);
            this.f22626g = new d(this.f22622c, k.I0);
            this.f22625f = new c(this.f22622c, k.J0);
            this.f22628i = new f(this.f22622c, k.G0);
            this.f22629j = new g(this.f22622c, k.M0);
            this.f22630k = new h(this.f22622c, l.Z);
            this.l = new PbRecomChildTitleAdapter(this.f22621b, c.a.s0.g0.g0.e.f17770f);
            this.m = new a0(this.f22621b, c.a.s0.s2.r.k.f22543g, this.a);
            this.f22623d.add(this.f22627h);
            this.f22623d.add(this.f22626g);
            this.f22623d.add(this.f22625f);
            this.f22623d.add(this.f22628i);
            this.f22623d.add(this.f22629j);
            this.f22623d.add(this.f22630k);
            this.f22623d.add(this.l);
            this.f22623d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f22624e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f22624e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f22627h.l0(sVar);
            this.f22626g.l0(sVar);
            this.f22625f.l0(sVar);
            this.f22628i.l0(sVar);
            this.f22629j.l0(sVar);
            this.f22630k.o0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f22624e.setData(list);
        }
    }
}
