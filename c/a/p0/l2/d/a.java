package c.a.p0.l2.d;

import c.a.p0.l2.c.d;
import c.a.p0.l2.c.e;
import c.a.p0.l2.c.f;
import c.a.p0.l2.c.g;
import c.a.p0.l2.e.h;
import c.a.p0.l2.e.i;
import c.a.p0.l2.e.k;
import c.a.p0.l2.e.n;
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
    public e f21408a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.l2.c.a f21409b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.l2.c.b f21410c;

    /* renamed from: d  reason: collision with root package name */
    public g f21411d;

    /* renamed from: e  reason: collision with root package name */
    public d f21412e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.l2.c.c f21413f;

    /* renamed from: g  reason: collision with root package name */
    public f f21414g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f21415h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.k.e.a> f21416i;

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
        this.f21416i = new ArrayList();
        this.f21415h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21409b.h0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f21408a = new e(tbPageContext, i.f21461f);
            this.f21409b = new c.a.p0.l2.c.a(tbPageContext, c.a.p0.l2.e.d.k);
            this.f21410c = new c.a.p0.l2.c.b(tbPageContext, c.a.p0.l2.e.e.f21438e);
            this.f21411d = new g(tbPageContext, n.f21481f);
            this.f21412e = new d(tbPageContext, h.p);
            this.f21414g = new f(tbPageContext, k.f21471f);
            this.f21413f = new c.a.p0.l2.c.c(tbPageContext, c.a.p0.l2.e.g.f21449g);
            this.f21416i.add(this.f21408a);
            this.f21416i.add(this.f21409b);
            this.f21416i.add(this.f21410c);
            this.f21416i.add(this.f21411d);
            this.f21416i.add(this.f21412e);
            this.f21416i.add(this.f21413f);
            this.f21416i.add(this.f21414g);
            bdTypeListView.addAdapters(this.f21416i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f21415h) != null && (bdTypeListView.getAdapter2() instanceof c.a.e.k.e.e)) {
            this.f21415h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21409b.k0();
        }
    }
}
