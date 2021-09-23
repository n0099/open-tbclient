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
    public e f22327a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.m2.c.a f22328b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.m2.c.b f22329c;

    /* renamed from: d  reason: collision with root package name */
    public g f22330d;

    /* renamed from: e  reason: collision with root package name */
    public d f22331e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.m2.c.c f22332f;

    /* renamed from: g  reason: collision with root package name */
    public f f22333g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f22334h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22335i;

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
        this.f22335i = new ArrayList();
        this.f22334h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22328b.h0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f22327a = new e(tbPageContext, i.f22380f);
            this.f22328b = new c.a.r0.m2.c.a(tbPageContext, c.a.r0.m2.e.d.k);
            this.f22329c = new c.a.r0.m2.c.b(tbPageContext, c.a.r0.m2.e.e.f22357e);
            this.f22330d = new g(tbPageContext, n.f22400f);
            this.f22331e = new d(tbPageContext, h.p);
            this.f22333g = new f(tbPageContext, k.f22390f);
            this.f22332f = new c.a.r0.m2.c.c(tbPageContext, c.a.r0.m2.e.g.f22368g);
            this.f22335i.add(this.f22327a);
            this.f22335i.add(this.f22328b);
            this.f22335i.add(this.f22329c);
            this.f22335i.add(this.f22330d);
            this.f22335i.add(this.f22331e);
            this.f22335i.add(this.f22332f);
            this.f22335i.add(this.f22333g);
            bdTypeListView.addAdapters(this.f22335i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f22334h) != null && (bdTypeListView.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f22334h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22328b.k0();
        }
    }
}
