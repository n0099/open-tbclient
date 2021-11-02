package b.a.r0.k2.u.c;

import android.view.View;
import b.a.e.l.e.n;
import b.a.e.l.e.s;
import b.a.r0.b0.e0.k;
import b.a.r0.b0.e0.l;
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
    public BdUniqueId f18855a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.y.b f18856b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f18857c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.l.e.a> f18858d;

    /* renamed from: e  reason: collision with root package name */
    public s f18859e;

    /* renamed from: f  reason: collision with root package name */
    public c f18860f;

    /* renamed from: g  reason: collision with root package name */
    public d f18861g;

    /* renamed from: h  reason: collision with root package name */
    public e f18862h;

    /* renamed from: i  reason: collision with root package name */
    public f f18863i;
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
        this.f18858d = new ArrayList();
        this.f18859e = sVar;
        this.f18855a = bdUniqueId;
        this.f18856b = bVar;
        this.f18857c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f18858d);
    }

    public List<b.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18858d : (List) invokeV.objValue;
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
            this.f18862h = new e(this.f18857c, k.E0);
            this.f18861g = new d(this.f18857c, k.F0);
            this.f18860f = new c(this.f18857c, k.G0);
            this.f18863i = new f(this.f18857c, k.D0);
            this.j = new g(this.f18857c, k.I0);
            this.k = new h(this.f18857c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f18856b, b.a.r0.b0.f0.e.f14787f);
            this.m = new a0(this.f18856b, b.a.r0.k2.r.k.f18776g, this.f18855a);
            this.f18858d.add(this.f18862h);
            this.f18858d.add(this.f18861g);
            this.f18858d.add(this.f18860f);
            this.f18858d.add(this.f18863i);
            this.f18858d.add(this.j);
            this.f18858d.add(this.k);
            this.f18858d.add(this.l);
            this.f18858d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f18859e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f18859e.getListAdapter().notifyDataSetChanged();
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
            this.f18862h.l0(sVar);
            this.f18861g.l0(sVar);
            this.f18860f.l0(sVar);
            this.f18863i.l0(sVar);
            this.j.l0(sVar);
            this.k.o0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18859e.setData(list);
        }
    }
}
