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
    public e f22906a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.n2.c.a f22907b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.n2.c.b f22908c;

    /* renamed from: d  reason: collision with root package name */
    public g f22909d;

    /* renamed from: e  reason: collision with root package name */
    public d f22910e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.n2.c.c f22911f;

    /* renamed from: g  reason: collision with root package name */
    public f f22912g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f22913h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.e.m.e.a> f22914i;

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
        this.f22914i = new ArrayList();
        this.f22913h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22907b.g0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f22906a = new e(tbPageContext, i.f22956f);
            this.f22907b = new b.a.r0.n2.c.a(tbPageContext, b.a.r0.n2.e.d.k);
            this.f22908c = new b.a.r0.n2.c.b(tbPageContext, b.a.r0.n2.e.e.f22935e);
            this.f22909d = new g(tbPageContext, n.f22976f);
            this.f22910e = new d(tbPageContext, h.p);
            this.f22912g = new f(tbPageContext, k.f22966f);
            this.f22911f = new b.a.r0.n2.c.c(tbPageContext, b.a.r0.n2.e.g.f22945g);
            this.f22914i.add(this.f22906a);
            this.f22914i.add(this.f22907b);
            this.f22914i.add(this.f22908c);
            this.f22914i.add(this.f22909d);
            this.f22914i.add(this.f22910e);
            this.f22914i.add(this.f22911f);
            this.f22914i.add(this.f22912g);
            bdTypeListView.addAdapters(this.f22914i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f22913h) != null && (bdTypeListView.getAdapter2() instanceof b.a.e.m.e.e)) {
            this.f22913h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22907b.j0();
        }
    }
}
