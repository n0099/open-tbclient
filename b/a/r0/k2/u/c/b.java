package b.a.r0.k2.u.c;

import android.view.View;
import b.a.e.m.e.n;
import b.a.e.m.e.s;
import b.a.r0.b0.f0.k;
import b.a.r0.b0.f0.l;
import b.a.r0.k2.u.f.a0;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f20392a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.y.b f20393b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f20394c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.m.e.a> f20395d;

    /* renamed from: e  reason: collision with root package name */
    public s f20396e;

    /* renamed from: f  reason: collision with root package name */
    public c f20397f;

    /* renamed from: g  reason: collision with root package name */
    public d f20398g;

    /* renamed from: h  reason: collision with root package name */
    public e f20399h;

    /* renamed from: i  reason: collision with root package name */
    public f f20400i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public a0 m;

    public b(b.a.r0.k2.y.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f20395d = new ArrayList();
        this.f20396e = sVar;
        this.f20392a = bdUniqueId;
        this.f20393b = bVar;
        this.f20394c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f20395d);
    }

    public List<b.a.e.m.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20395d : (List) invokeV.objValue;
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
            this.f20399h = new e(this.f20394c, k.G0);
            this.f20398g = new d(this.f20394c, k.H0);
            this.f20397f = new c(this.f20394c, k.I0);
            this.f20400i = new f(this.f20394c, k.F0);
            this.j = new g(this.f20394c, k.L0);
            this.k = new h(this.f20394c, l.Z);
            this.l = new PbRecomChildTitleAdapter(this.f20393b, b.a.r0.b0.g0.e.f16274f);
            this.m = new a0(this.f20393b, b.a.r0.k2.r.k.f20312g, this.f20392a);
            this.f20395d.add(this.f20399h);
            this.f20395d.add(this.f20398g);
            this.f20395d.add(this.f20397f);
            this.f20395d.add(this.f20400i);
            this.f20395d.add(this.j);
            this.f20395d.add(this.k);
            this.f20395d.add(this.l);
            this.f20395d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f20396e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f20396e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f20399h.l0(sVar);
            this.f20398g.l0(sVar);
            this.f20397f.l0(sVar);
            this.f20400i.l0(sVar);
            this.j.l0(sVar);
            this.k.o0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f20396e.setData(list);
        }
    }
}
