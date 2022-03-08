package c.a.r0.u2.k.c;

import android.view.View;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
import c.a.r0.f0.d0.k;
import c.a.r0.f0.d0.l;
import c.a.r0.u2.k.f.b0;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.u2.o.c f23186b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f23187c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f23188d;

    /* renamed from: e  reason: collision with root package name */
    public s f23189e;

    /* renamed from: f  reason: collision with root package name */
    public c f23190f;

    /* renamed from: g  reason: collision with root package name */
    public d f23191g;

    /* renamed from: h  reason: collision with root package name */
    public e f23192h;

    /* renamed from: i  reason: collision with root package name */
    public f f23193i;

    /* renamed from: j  reason: collision with root package name */
    public g f23194j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(c.a.r0.u2.o.c cVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f23188d = new ArrayList();
        this.f23189e = sVar;
        this.a = bdUniqueId;
        this.f23186b = cVar;
        this.f23187c = cVar.getPageContext();
        c();
        g(sVar);
        sVar.addAdapters(this.f23188d);
    }

    public List<c.a.d.o.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23188d : (List) invokeV.objValue;
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
            this.f23192h = new e(this.f23187c, k.F0);
            this.f23191g = new d(this.f23187c, k.G0);
            this.f23190f = new c(this.f23187c, k.H0);
            this.f23193i = new f(this.f23187c, k.E0);
            this.f23194j = new g(this.f23187c, k.K0);
            this.k = new h(this.f23187c, l.Y);
            this.l = new PbRecomChildTitleAdapter(this.f23186b, c.a.r0.f0.e0.e.f17312f);
            this.m = new b0(this.f23186b, c.a.r0.u2.h.k.f23111g, this.a);
            this.f23188d.add(this.f23192h);
            this.f23188d.add(this.f23191g);
            this.f23188d.add(this.f23190f);
            this.f23188d.add(this.f23193i);
            this.f23188d.add(this.f23194j);
            this.f23188d.add(this.k);
            this.f23188d.add(this.l);
            this.f23188d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f23189e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f23189e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f23192h.e0(sVar);
            this.f23191g.e0(sVar);
            this.f23190f.e0(sVar);
            this.f23193i.e0(sVar);
            this.f23194j.e0(sVar);
            this.k.h0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f23189e.setData(list);
        }
    }
}
