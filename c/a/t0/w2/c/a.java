package c.a.t0.w2.c;

import c.a.t0.w2.b.d;
import c.a.t0.w2.b.e;
import c.a.t0.w2.b.f;
import c.a.t0.w2.b.g;
import c.a.t0.w2.d.h;
import c.a.t0.w2.d.i;
import c.a.t0.w2.d.k;
import c.a.t0.w2.d.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.w2.b.a f24772b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.w2.b.b f24773c;

    /* renamed from: d  reason: collision with root package name */
    public g f24774d;

    /* renamed from: e  reason: collision with root package name */
    public d f24775e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.w2.b.c f24776f;

    /* renamed from: g  reason: collision with root package name */
    public f f24777g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f24778h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.n.e.a> f24779i;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24779i = new ArrayList();
        this.f24778h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24772b.Z();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f24815f);
            this.f24772b = new c.a.t0.w2.b.a(tbPageContext, c.a.t0.w2.d.d.k);
            this.f24773c = new c.a.t0.w2.b.b(tbPageContext, c.a.t0.w2.d.e.f24794e);
            this.f24774d = new g(tbPageContext, n.f24833f);
            this.f24775e = new d(tbPageContext, h.p);
            this.f24777g = new f(tbPageContext, k.f24824f);
            this.f24776f = new c.a.t0.w2.b.c(tbPageContext, c.a.t0.w2.d.g.f24804g);
            this.f24779i.add(this.a);
            this.f24779i.add(this.f24772b);
            this.f24779i.add(this.f24773c);
            this.f24779i.add(this.f24774d);
            this.f24779i.add(this.f24775e);
            this.f24779i.add(this.f24776f);
            this.f24779i.add(this.f24777g);
            bdTypeListView.addAdapters(this.f24779i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f24778h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.n.e.e)) {
            this.f24778h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24772b.c0();
        }
    }
}
