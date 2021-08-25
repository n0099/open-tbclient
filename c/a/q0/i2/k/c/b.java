package c.a.q0.i2.k.c;

import android.view.View;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
import c.a.q0.a0.d0.k;
import c.a.q0.a0.d0.l;
import c.a.q0.i2.h.j;
import c.a.q0.i2.k.e.z;
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
    public BdUniqueId f19167a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.i2.o.b f19168b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f19169c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19170d;

    /* renamed from: e  reason: collision with root package name */
    public s f19171e;

    /* renamed from: f  reason: collision with root package name */
    public c f19172f;

    /* renamed from: g  reason: collision with root package name */
    public d f19173g;

    /* renamed from: h  reason: collision with root package name */
    public e f19174h;

    /* renamed from: i  reason: collision with root package name */
    public f f19175i;

    /* renamed from: j  reason: collision with root package name */
    public g f19176j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public z m;

    public b(c.a.q0.i2.o.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f19170d = new ArrayList();
        this.f19171e = sVar;
        this.f19167a = bdUniqueId;
        this.f19168b = bVar;
        this.f19169c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f19170d);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19170d : (List) invokeV.objValue;
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
            this.f19174h = new e(this.f19169c, k.E0);
            this.f19173g = new d(this.f19169c, k.F0);
            this.f19172f = new c(this.f19169c, k.G0);
            this.f19175i = new f(this.f19169c, k.D0);
            this.f19176j = new g(this.f19169c, k.I0);
            this.k = new h(this.f19169c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f19168b, c.a.q0.a0.e0.e.f15287f);
            this.m = new z(this.f19168b, j.f19083g, this.f19167a);
            this.f19170d.add(this.f19174h);
            this.f19170d.add(this.f19173g);
            this.f19170d.add(this.f19172f);
            this.f19170d.add(this.f19175i);
            this.f19170d.add(this.f19176j);
            this.f19170d.add(this.k);
            this.f19170d.add(this.l);
            this.f19170d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f19171e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f19171e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f19174h.m0(sVar);
            this.f19173g.m0(sVar);
            this.f19172f.m0(sVar);
            this.f19175i.m0(sVar);
            this.f19176j.m0(sVar);
            this.k.p0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f19171e.setData(list);
        }
    }
}
