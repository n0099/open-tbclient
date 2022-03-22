package c.a.p0.w2.m.c;

import android.view.View;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
import c.a.p0.h0.e0.k;
import c.a.p0.h0.e0.l;
import c.a.p0.w2.m.f.g0;
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
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.q.c f19913b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f19914c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f19915d;

    /* renamed from: e  reason: collision with root package name */
    public s f19916e;

    /* renamed from: f  reason: collision with root package name */
    public c f19917f;

    /* renamed from: g  reason: collision with root package name */
    public d f19918g;

    /* renamed from: h  reason: collision with root package name */
    public e f19919h;
    public f i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public g0 m;

    public b(c.a.p0.w2.q.c cVar, BdUniqueId bdUniqueId, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19915d = new ArrayList();
        this.f19916e = sVar;
        this.a = bdUniqueId;
        this.f19913b = cVar;
        this.f19914c = cVar.getPageContext();
        c();
        g(sVar);
        sVar.a(this.f19915d);
    }

    public List<c.a.d.o.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19915d : (List) invokeV.objValue;
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
            this.f19919h = new e(this.f19914c, k.B0);
            this.f19918g = new d(this.f19914c, k.C0);
            this.f19917f = new c(this.f19914c, k.D0);
            this.i = new f(this.f19914c, k.A0);
            this.j = new g(this.f19914c, k.G0);
            this.k = new h(this.f19914c, l.U);
            this.l = new PbRecomChildTitleAdapter(this.f19913b, c.a.p0.h0.f0.e.f15354b);
            this.m = new g0(this.f19913b, c.a.p0.w2.i.l.f19833c, this.a);
            this.f19915d.add(this.f19919h);
            this.f19915d.add(this.f19918g);
            this.f19915d.add(this.f19917f);
            this.f19915d.add(this.i);
            this.f19915d.add(this.j);
            this.f19915d.add(this.k);
            this.f19915d.add(this.l);
            this.f19915d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f19916e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f19916e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f19919h.e0(sVar);
            this.f19918g.e0(sVar);
            this.f19917f.e0(sVar);
            this.i.e0(sVar);
            this.j.e0(sVar);
            this.k.h0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f19916e.setData(list);
        }
    }
}
