package c.a.u0.u2.u.c;

import android.view.View;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
import c.a.u0.g0.d0.k;
import c.a.u0.g0.d0.l;
import c.a.u0.u2.u.f.b0;
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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.u0.u2.y.c f23272b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f23273c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f23274d;

    /* renamed from: e  reason: collision with root package name */
    public s f23275e;

    /* renamed from: f  reason: collision with root package name */
    public c f23276f;

    /* renamed from: g  reason: collision with root package name */
    public d f23277g;

    /* renamed from: h  reason: collision with root package name */
    public e f23278h;

    /* renamed from: i  reason: collision with root package name */
    public f f23279i;

    /* renamed from: j  reason: collision with root package name */
    public g f23280j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(c.a.u0.u2.y.c cVar, BdUniqueId bdUniqueId, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23274d = new ArrayList();
        this.f23275e = sVar;
        this.a = bdUniqueId;
        this.f23272b = cVar;
        this.f23273c = cVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f23274d);
    }

    public List<c.a.d.o.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23274d : (List) invokeV.objValue;
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
            this.f23278h = new e(this.f23273c, k.F0);
            this.f23277g = new d(this.f23273c, k.G0);
            this.f23276f = new c(this.f23273c, k.H0);
            this.f23279i = new f(this.f23273c, k.E0);
            this.f23280j = new g(this.f23273c, k.K0);
            this.k = new h(this.f23273c, l.Y);
            this.l = new PbRecomChildTitleAdapter(this.f23272b, c.a.u0.g0.e0.e.f17926f);
            this.m = new b0(this.f23272b, c.a.u0.u2.r.k.f23197g, this.a);
            this.f23274d.add(this.f23278h);
            this.f23274d.add(this.f23277g);
            this.f23274d.add(this.f23276f);
            this.f23274d.add(this.f23279i);
            this.f23274d.add(this.f23280j);
            this.f23274d.add(this.k);
            this.f23274d.add(this.l);
            this.f23274d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f23275e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f23275e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.u0.u2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f23278h.e0(sVar);
            this.f23277g.e0(sVar);
            this.f23276f.e0(sVar);
            this.f23279i.e0(sVar);
            this.f23280j.e0(sVar);
            this.k.h0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f23275e.setData(list);
        }
    }
}
