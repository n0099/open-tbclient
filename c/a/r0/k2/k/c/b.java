package c.a.r0.k2.k.c;

import android.view.View;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
import c.a.r0.b0.e0.k;
import c.a.r0.b0.e0.l;
import c.a.r0.k2.h.j;
import c.a.r0.k2.k.e.a0;
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
    public BdUniqueId f19908a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.k2.o.b f19909b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f19910c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19911d;

    /* renamed from: e  reason: collision with root package name */
    public s f19912e;

    /* renamed from: f  reason: collision with root package name */
    public c f19913f;

    /* renamed from: g  reason: collision with root package name */
    public d f19914g;

    /* renamed from: h  reason: collision with root package name */
    public e f19915h;

    /* renamed from: i  reason: collision with root package name */
    public f f19916i;

    /* renamed from: j  reason: collision with root package name */
    public g f19917j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public a0 m;

    public b(c.a.r0.k2.o.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f19911d = new ArrayList();
        this.f19912e = sVar;
        this.f19908a = bdUniqueId;
        this.f19909b = bVar;
        this.f19910c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f19911d);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19911d : (List) invokeV.objValue;
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
            this.f19915h = new e(this.f19910c, k.E0);
            this.f19914g = new d(this.f19910c, k.F0);
            this.f19913f = new c(this.f19910c, k.G0);
            this.f19916i = new f(this.f19910c, k.D0);
            this.f19917j = new g(this.f19910c, k.I0);
            this.k = new h(this.f19910c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f19909b, c.a.r0.b0.f0.e.f15763f);
            this.m = new a0(this.f19909b, j.f19824g, this.f19908a);
            this.f19911d.add(this.f19915h);
            this.f19911d.add(this.f19914g);
            this.f19911d.add(this.f19913f);
            this.f19911d.add(this.f19916i);
            this.f19911d.add(this.f19917j);
            this.f19911d.add(this.k);
            this.f19911d.add(this.l);
            this.f19911d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f19912e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f19912e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f19915h.m0(sVar);
            this.f19914g.m0(sVar);
            this.f19913f.m0(sVar);
            this.f19916i.m0(sVar);
            this.f19917j.m0(sVar);
            this.k.p0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f19912e.setData(list);
        }
    }
}
