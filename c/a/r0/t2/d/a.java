package c.a.r0.t2.d;

import c.a.r0.t2.c.d;
import c.a.r0.t2.c.e;
import c.a.r0.t2.c.f;
import c.a.r0.t2.c.g;
import c.a.r0.t2.e.h;
import c.a.r0.t2.e.i;
import c.a.r0.t2.e.k;
import c.a.r0.t2.e.n;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.t2.c.a f23665b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.t2.c.b f23666c;

    /* renamed from: d  reason: collision with root package name */
    public g f23667d;

    /* renamed from: e  reason: collision with root package name */
    public d f23668e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.t2.c.c f23669f;

    /* renamed from: g  reason: collision with root package name */
    public f f23670g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f23671h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.m.e.a> f23672i;

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
        this.f23672i = new ArrayList();
        this.f23671h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23665b.g0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f23711f);
            this.f23665b = new c.a.r0.t2.c.a(tbPageContext, c.a.r0.t2.e.d.f23681k);
            this.f23666c = new c.a.r0.t2.c.b(tbPageContext, c.a.r0.t2.e.e.f23688e);
            this.f23667d = new g(tbPageContext, n.f23729f);
            this.f23668e = new d(tbPageContext, h.p);
            this.f23670g = new f(tbPageContext, k.f23720f);
            this.f23669f = new c.a.r0.t2.c.c(tbPageContext, c.a.r0.t2.e.g.f23699g);
            this.f23672i.add(this.a);
            this.f23672i.add(this.f23665b);
            this.f23672i.add(this.f23666c);
            this.f23672i.add(this.f23667d);
            this.f23672i.add(this.f23668e);
            this.f23672i.add(this.f23669f);
            this.f23672i.add(this.f23670g);
            bdTypeListView.addAdapters(this.f23672i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f23671h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.m.e.e)) {
            this.f23671h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23665b.j0();
        }
    }
}
