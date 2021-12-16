package c.a.s0.v2.d;

import c.a.s0.v2.c.d;
import c.a.s0.v2.c.e;
import c.a.s0.v2.c.f;
import c.a.s0.v2.c.g;
import c.a.s0.v2.e.h;
import c.a.s0.v2.e.i;
import c.a.s0.v2.e.k;
import c.a.s0.v2.e.n;
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
    public c.a.s0.v2.c.a f24750b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.v2.c.b f24751c;

    /* renamed from: d  reason: collision with root package name */
    public g f24752d;

    /* renamed from: e  reason: collision with root package name */
    public d f24753e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.v2.c.c f24754f;

    /* renamed from: g  reason: collision with root package name */
    public f f24755g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f24756h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.m.e.a> f24757i;

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
        this.f24757i = new ArrayList();
        this.f24756h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24750b.g0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f24796f);
            this.f24750b = new c.a.s0.v2.c.a(tbPageContext, c.a.s0.v2.e.d.f24766k);
            this.f24751c = new c.a.s0.v2.c.b(tbPageContext, c.a.s0.v2.e.e.f24773e);
            this.f24752d = new g(tbPageContext, n.f24814f);
            this.f24753e = new d(tbPageContext, h.p);
            this.f24755g = new f(tbPageContext, k.f24805f);
            this.f24754f = new c.a.s0.v2.c.c(tbPageContext, c.a.s0.v2.e.g.f24784g);
            this.f24757i.add(this.a);
            this.f24757i.add(this.f24750b);
            this.f24757i.add(this.f24751c);
            this.f24757i.add(this.f24752d);
            this.f24757i.add(this.f24753e);
            this.f24757i.add(this.f24754f);
            this.f24757i.add(this.f24755g);
            bdTypeListView.addAdapters(this.f24757i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f24756h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.m.e.e)) {
            this.f24756h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24750b.j0();
        }
    }
}
