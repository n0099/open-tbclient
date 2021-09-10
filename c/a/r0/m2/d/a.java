package c.a.r0.m2.d;

import c.a.r0.m2.c.d;
import c.a.r0.m2.c.e;
import c.a.r0.m2.c.f;
import c.a.r0.m2.c.g;
import c.a.r0.m2.e.h;
import c.a.r0.m2.e.i;
import c.a.r0.m2.e.k;
import c.a.r0.m2.e.n;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f22311a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.m2.c.a f22312b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.m2.c.b f22313c;

    /* renamed from: d  reason: collision with root package name */
    public g f22314d;

    /* renamed from: e  reason: collision with root package name */
    public d f22315e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.m2.c.c f22316f;

    /* renamed from: g  reason: collision with root package name */
    public f f22317g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f22318h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22319i;

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
        this.f22319i = new ArrayList();
        this.f22318h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22312b.h0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f22311a = new e(tbPageContext, i.f22364f);
            this.f22312b = new c.a.r0.m2.c.a(tbPageContext, c.a.r0.m2.e.d.k);
            this.f22313c = new c.a.r0.m2.c.b(tbPageContext, c.a.r0.m2.e.e.f22341e);
            this.f22314d = new g(tbPageContext, n.f22384f);
            this.f22315e = new d(tbPageContext, h.p);
            this.f22317g = new f(tbPageContext, k.f22374f);
            this.f22316f = new c.a.r0.m2.c.c(tbPageContext, c.a.r0.m2.e.g.f22352g);
            this.f22319i.add(this.f22311a);
            this.f22319i.add(this.f22312b);
            this.f22319i.add(this.f22313c);
            this.f22319i.add(this.f22314d);
            this.f22319i.add(this.f22315e);
            this.f22319i.add(this.f22316f);
            this.f22319i.add(this.f22317g);
            bdTypeListView.addAdapters(this.f22319i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f22318h) != null && (bdTypeListView.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f22318h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22312b.k0();
        }
    }
}
