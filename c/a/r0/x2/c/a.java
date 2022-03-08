package c.a.r0.x2.c;

import c.a.r0.x2.b.d;
import c.a.r0.x2.b.e;
import c.a.r0.x2.b.f;
import c.a.r0.x2.b.g;
import c.a.r0.x2.d.h;
import c.a.r0.x2.d.i;
import c.a.r0.x2.d.k;
import c.a.r0.x2.d.n;
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
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.x2.b.a f24534b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.x2.b.b f24535c;

    /* renamed from: d  reason: collision with root package name */
    public g f24536d;

    /* renamed from: e  reason: collision with root package name */
    public d f24537e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.x2.b.c f24538f;

    /* renamed from: g  reason: collision with root package name */
    public f f24539g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f24540h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.o.e.a> f24541i;

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
        this.f24541i = new ArrayList();
        this.f24540h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24534b.Z();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f24577f);
            this.f24534b = new c.a.r0.x2.b.a(tbPageContext, c.a.r0.x2.d.d.k);
            this.f24535c = new c.a.r0.x2.b.b(tbPageContext, c.a.r0.x2.d.e.f24556e);
            this.f24536d = new g(tbPageContext, n.f24595f);
            this.f24537e = new d(tbPageContext, h.p);
            this.f24539g = new f(tbPageContext, k.f24586f);
            this.f24538f = new c.a.r0.x2.b.c(tbPageContext, c.a.r0.x2.d.g.f24566g);
            this.f24541i.add(this.a);
            this.f24541i.add(this.f24534b);
            this.f24541i.add(this.f24535c);
            this.f24541i.add(this.f24536d);
            this.f24541i.add(this.f24537e);
            this.f24541i.add(this.f24538f);
            this.f24541i.add(this.f24539g);
            bdTypeListView.addAdapters(this.f24541i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f24540h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f24540h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24534b.c0();
        }
    }
}
