package c.a.u0.x2.c;

import c.a.u0.x2.b.d;
import c.a.u0.x2.b.e;
import c.a.u0.x2.b.f;
import c.a.u0.x2.b.g;
import c.a.u0.x2.d.h;
import c.a.u0.x2.d.i;
import c.a.u0.x2.d.k;
import c.a.u0.x2.d.n;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.u0.x2.b.a f25182b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.u0.x2.b.b f25183c;

    /* renamed from: d  reason: collision with root package name */
    public g f25184d;

    /* renamed from: e  reason: collision with root package name */
    public d f25185e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.u0.x2.b.c f25186f;

    /* renamed from: g  reason: collision with root package name */
    public f f25187g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f25188h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.o.e.a> f25189i;

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
        this.f25189i = new ArrayList();
        this.f25188h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25182b.Z();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f25225f);
            this.f25182b = new c.a.u0.x2.b.a(tbPageContext, c.a.u0.x2.d.d.k);
            this.f25183c = new c.a.u0.x2.b.b(tbPageContext, c.a.u0.x2.d.e.f25204e);
            this.f25184d = new g(tbPageContext, n.f25243f);
            this.f25185e = new d(tbPageContext, h.p);
            this.f25187g = new f(tbPageContext, k.f25234f);
            this.f25186f = new c.a.u0.x2.b.c(tbPageContext, c.a.u0.x2.d.g.f25214g);
            this.f25189i.add(this.a);
            this.f25189i.add(this.f25182b);
            this.f25189i.add(this.f25183c);
            this.f25189i.add(this.f25184d);
            this.f25189i.add(this.f25185e);
            this.f25189i.add(this.f25186f);
            this.f25189i.add(this.f25187g);
            bdTypeListView.addAdapters(this.f25189i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f25188h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f25188h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25182b.c0();
        }
    }
}
