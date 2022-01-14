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
    public c.a.t0.v2.b.a f24555b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.v2.b.b f24556c;

    /* renamed from: d  reason: collision with root package name */
    public g f24557d;

    /* renamed from: e  reason: collision with root package name */
    public d f24558e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.v2.b.c f24559f;

    /* renamed from: g  reason: collision with root package name */
    public f f24560g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f24561h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.n.e.a> f24562i;

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
        this.f24562i = new ArrayList();
        this.f24561h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24555b.Z();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f24598f);
            this.f24555b = new c.a.t0.v2.b.a(tbPageContext, c.a.t0.v2.d.d.k);
            this.f24556c = new c.a.t0.v2.b.b(tbPageContext, c.a.t0.v2.d.e.f24577e);
            this.f24557d = new g(tbPageContext, n.f24616f);
            this.f24558e = new d(tbPageContext, h.p);
            this.f24560g = new f(tbPageContext, k.f24607f);
            this.f24559f = new c.a.t0.v2.b.c(tbPageContext, c.a.t0.v2.d.g.f24587g);
            this.f24562i.add(this.a);
            this.f24562i.add(this.f24555b);
            this.f24562i.add(this.f24556c);
            this.f24562i.add(this.f24557d);
            this.f24562i.add(this.f24558e);
            this.f24562i.add(this.f24559f);
            this.f24562i.add(this.f24560g);
            bdTypeListView.addAdapters(this.f24562i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f24561h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.n.e.e)) {
            this.f24561h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24555b.c0();
        }
    }
}
