package c.a.q0.l2.d;

import c.a.q0.l2.c.d;
import c.a.q0.l2.c.e;
import c.a.q0.l2.c.f;
import c.a.q0.l2.c.g;
import c.a.q0.l2.e.h;
import c.a.q0.l2.e.i;
import c.a.q0.l2.e.k;
import c.a.q0.l2.e.n;
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
    public e f21738a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.l2.c.a f21739b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.l2.c.b f21740c;

    /* renamed from: d  reason: collision with root package name */
    public g f21741d;

    /* renamed from: e  reason: collision with root package name */
    public d f21742e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.l2.c.c f21743f;

    /* renamed from: g  reason: collision with root package name */
    public f f21744g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f21745h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.l.e.a> f21746i;

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
        this.f21746i = new ArrayList();
        this.f21745h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21739b.h0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f21738a = new e(tbPageContext, i.f21791f);
            this.f21739b = new c.a.q0.l2.c.a(tbPageContext, c.a.q0.l2.e.d.k);
            this.f21740c = new c.a.q0.l2.c.b(tbPageContext, c.a.q0.l2.e.e.f21768e);
            this.f21741d = new g(tbPageContext, n.f21811f);
            this.f21742e = new d(tbPageContext, h.p);
            this.f21744g = new f(tbPageContext, k.f21801f);
            this.f21743f = new c.a.q0.l2.c.c(tbPageContext, c.a.q0.l2.e.g.f21779g);
            this.f21746i.add(this.f21738a);
            this.f21746i.add(this.f21739b);
            this.f21746i.add(this.f21740c);
            this.f21746i.add(this.f21741d);
            this.f21746i.add(this.f21742e);
            this.f21746i.add(this.f21743f);
            this.f21746i.add(this.f21744g);
            bdTypeListView.addAdapters(this.f21746i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f21745h) != null && (bdTypeListView.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f21745h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21739b.k0();
        }
    }
}
