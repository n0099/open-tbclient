package c.a.r0.n2.d;

import c.a.r0.n2.c.d;
import c.a.r0.n2.c.e;
import c.a.r0.n2.c.f;
import c.a.r0.n2.c.g;
import c.a.r0.n2.e.h;
import c.a.r0.n2.e.i;
import c.a.r0.n2.e.k;
import c.a.r0.n2.e.n;
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
    public e f22511a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.n2.c.a f22512b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.n2.c.b f22513c;

    /* renamed from: d  reason: collision with root package name */
    public g f22514d;

    /* renamed from: e  reason: collision with root package name */
    public d f22515e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.n2.c.c f22516f;

    /* renamed from: g  reason: collision with root package name */
    public f f22517g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f22518h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22519i;

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
        this.f22519i = new ArrayList();
        this.f22518h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22512b.h0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f22511a = new e(tbPageContext, i.f22564f);
            this.f22512b = new c.a.r0.n2.c.a(tbPageContext, c.a.r0.n2.e.d.k);
            this.f22513c = new c.a.r0.n2.c.b(tbPageContext, c.a.r0.n2.e.e.f22541e);
            this.f22514d = new g(tbPageContext, n.f22584f);
            this.f22515e = new d(tbPageContext, h.p);
            this.f22517g = new f(tbPageContext, k.f22574f);
            this.f22516f = new c.a.r0.n2.c.c(tbPageContext, c.a.r0.n2.e.g.f22552g);
            this.f22519i.add(this.f22511a);
            this.f22519i.add(this.f22512b);
            this.f22519i.add(this.f22513c);
            this.f22519i.add(this.f22514d);
            this.f22519i.add(this.f22515e);
            this.f22519i.add(this.f22516f);
            this.f22519i.add(this.f22517g);
            bdTypeListView.addAdapters(this.f22519i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f22518h) != null && (bdTypeListView.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f22518h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22512b.k0();
        }
    }
}
