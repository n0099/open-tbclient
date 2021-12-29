package c.a.t0.v2.c;

import c.a.t0.v2.b.d;
import c.a.t0.v2.b.e;
import c.a.t0.v2.b.f;
import c.a.t0.v2.b.g;
import c.a.t0.v2.d.h;
import c.a.t0.v2.d.i;
import c.a.t0.v2.d.k;
import c.a.t0.v2.d.n;
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
    public c.a.t0.v2.b.a f25261b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.v2.b.b f25262c;

    /* renamed from: d  reason: collision with root package name */
    public g f25263d;

    /* renamed from: e  reason: collision with root package name */
    public d f25264e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.v2.b.c f25265f;

    /* renamed from: g  reason: collision with root package name */
    public f f25266g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f25267h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.n.e.a> f25268i;

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
        this.f25268i = new ArrayList();
        this.f25267h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25261b.Z();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f25307f);
            this.f25261b = new c.a.t0.v2.b.a(tbPageContext, c.a.t0.v2.d.d.f25277k);
            this.f25262c = new c.a.t0.v2.b.b(tbPageContext, c.a.t0.v2.d.e.f25284e);
            this.f25263d = new g(tbPageContext, n.f25325f);
            this.f25264e = new d(tbPageContext, h.p);
            this.f25266g = new f(tbPageContext, k.f25316f);
            this.f25265f = new c.a.t0.v2.b.c(tbPageContext, c.a.t0.v2.d.g.f25295g);
            this.f25268i.add(this.a);
            this.f25268i.add(this.f25261b);
            this.f25268i.add(this.f25262c);
            this.f25268i.add(this.f25263d);
            this.f25268i.add(this.f25264e);
            this.f25268i.add(this.f25265f);
            this.f25268i.add(this.f25266g);
            bdTypeListView.addAdapters(this.f25268i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f25267h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.n.e.e)) {
            this.f25267h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25261b.c0();
        }
    }
}
