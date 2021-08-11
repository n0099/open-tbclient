package c.a.p0.i2.k.c;

import android.view.View;
import c.a.e.k.e.n;
import c.a.e.k.e.s;
import c.a.p0.a0.d0.k;
import c.a.p0.a0.d0.l;
import c.a.p0.i2.h.j;
import c.a.p0.i2.k.e.b0;
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
    public BdUniqueId f18834a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.i2.o.b f18835b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f18836c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.k.e.a> f18837d;

    /* renamed from: e  reason: collision with root package name */
    public s f18838e;

    /* renamed from: f  reason: collision with root package name */
    public c f18839f;

    /* renamed from: g  reason: collision with root package name */
    public d f18840g;

    /* renamed from: h  reason: collision with root package name */
    public e f18841h;

    /* renamed from: i  reason: collision with root package name */
    public f f18842i;

    /* renamed from: j  reason: collision with root package name */
    public g f18843j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(c.a.p0.i2.o.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f18837d = new ArrayList();
        this.f18838e = sVar;
        this.f18834a = bdUniqueId;
        this.f18835b = bVar;
        this.f18836c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f18837d);
    }

    public List<c.a.e.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18837d : (List) invokeV.objValue;
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
            this.f18841h = new e(this.f18836c, k.E0);
            this.f18840g = new d(this.f18836c, k.F0);
            this.f18839f = new c(this.f18836c, k.G0);
            this.f18842i = new f(this.f18836c, k.D0);
            this.f18843j = new g(this.f18836c, k.I0);
            this.k = new h(this.f18836c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f18835b, c.a.p0.a0.e0.e.f15001f);
            this.m = new b0(this.f18835b, j.f18750g, this.f18834a);
            this.f18837d.add(this.f18841h);
            this.f18837d.add(this.f18840g);
            this.f18837d.add(this.f18839f);
            this.f18837d.add(this.f18842i);
            this.f18837d.add(this.f18843j);
            this.f18837d.add(this.k);
            this.f18837d.add(this.l);
            this.f18837d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f18838e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f18838e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f18841h.m0(sVar);
            this.f18840g.m0(sVar);
            this.f18839f.m0(sVar);
            this.f18842i.m0(sVar);
            this.f18843j.m0(sVar);
            this.k.p0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18838e.setData(list);
        }
    }
}
