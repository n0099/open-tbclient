package c.a.p0.z2.c;

import c.a.p0.z2.b.d;
import c.a.p0.z2.b.e;
import c.a.p0.z2.b.f;
import c.a.p0.z2.b.g;
import c.a.p0.z2.d.h;
import c.a.p0.z2.d.i;
import c.a.p0.z2.d.k;
import c.a.p0.z2.d.n;
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
    public c.a.p0.z2.b.a f20913b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.z2.b.b f20914c;

    /* renamed from: d  reason: collision with root package name */
    public g f20915d;

    /* renamed from: e  reason: collision with root package name */
    public d f20916e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.z2.b.c f20917f;

    /* renamed from: g  reason: collision with root package name */
    public f f20918g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f20919h;
    public List<c.a.d.o.e.a> i;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.f20919h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20913b.Z();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e(tbPageContext, i.f20952b);
            this.f20913b = new c.a.p0.z2.b.a(tbPageContext, c.a.p0.z2.d.d.f20928g);
            this.f20914c = new c.a.p0.z2.b.b(tbPageContext, c.a.p0.z2.d.e.a);
            this.f20915d = new g(tbPageContext, n.f20968b);
            this.f20916e = new d(tbPageContext, h.l);
            this.f20918g = new f(tbPageContext, k.f20960b);
            this.f20917f = new c.a.p0.z2.b.c(tbPageContext, c.a.p0.z2.d.g.f20941c);
            this.i.add(this.a);
            this.i.add(this.f20913b);
            this.i.add(this.f20914c);
            this.i.add(this.f20915d);
            this.i.add(this.f20916e);
            this.i.add(this.f20917f);
            this.i.add(this.f20918g);
            bdTypeListView.a(this.i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f20919h) != null && (bdTypeListView.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f20919h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20913b.c0();
        }
    }
}
