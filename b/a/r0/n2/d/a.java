package b.a.r0.n2.d;

import b.a.r0.n2.c.d;
import b.a.r0.n2.c.e;
import b.a.r0.n2.c.f;
import b.a.r0.n2.c.g;
import b.a.r0.n2.e.h;
import b.a.r0.n2.e.i;
import b.a.r0.n2.e.k;
import b.a.r0.n2.e.n;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f21410a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.n2.c.a f21411b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.n2.c.b f21412c;

    /* renamed from: d  reason: collision with root package name */
    public g f21413d;

    /* renamed from: e  reason: collision with root package name */
    public d f21414e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.n2.c.c f21415f;

    /* renamed from: g  reason: collision with root package name */
    public f f21416g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f21417h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.e.l.e.a> f21418i;

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
        this.f21418i = new ArrayList();
        this.f21417h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21411b.g0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f21410a = new e(tbPageContext, i.f21460f);
            this.f21411b = new b.a.r0.n2.c.a(tbPageContext, b.a.r0.n2.e.d.k);
            this.f21412c = new b.a.r0.n2.c.b(tbPageContext, b.a.r0.n2.e.e.f21439e);
            this.f21413d = new g(tbPageContext, n.f21480f);
            this.f21414e = new d(tbPageContext, h.p);
            this.f21416g = new f(tbPageContext, k.f21470f);
            this.f21415f = new b.a.r0.n2.c.c(tbPageContext, b.a.r0.n2.e.g.f21449g);
            this.f21418i.add(this.f21410a);
            this.f21418i.add(this.f21411b);
            this.f21418i.add(this.f21412c);
            this.f21418i.add(this.f21413d);
            this.f21418i.add(this.f21414e);
            this.f21418i.add(this.f21415f);
            this.f21418i.add(this.f21416g);
            bdTypeListView.addAdapters(this.f21418i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f21417h) != null && (bdTypeListView.getAdapter2() instanceof b.a.e.l.e.e)) {
            this.f21417h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21411b.j0();
        }
    }
}
