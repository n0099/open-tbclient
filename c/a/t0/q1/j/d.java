package c.a.t0.q1.j;

import c.a.t0.g0.f0.l;
import c.a.t0.q1.l.m;
import c.a.t0.q1.l.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeListView a;

    /* renamed from: b  reason: collision with root package name */
    public i f21448b;

    /* renamed from: c  reason: collision with root package name */
    public g f21449c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f21450d;

    /* renamed from: e  reason: collision with root package name */
    public e f21451e;

    /* renamed from: f  reason: collision with root package name */
    public f f21452f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f21453g;

    /* renamed from: h  reason: collision with root package name */
    public h f21454h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.n.e.a> f21455i;

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotTopicActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21455i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f21451e = new e(hotTopicActivity, c.a.t0.q1.l.g.f21549f);
            this.f21448b = new i(hotTopicActivity, m.p);
            this.f21449c = new g(hotTopicActivity, c.a.t0.q1.l.i.p);
            this.f21450d = new RelateCardForumAdapter(hotTopicActivity, n.f21572g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f21452f = new f(pageContext, c.a.t0.g0.f0.k.v0);
            this.f21453g = new HomePageVideoThreadAdapter(pageContext, l.Z);
            this.f21454h = new h(pageContext, c.a.t0.g0.f0.k.y0);
            this.f21455i.add(this.f21448b);
            this.f21455i.add(this.f21449c);
            this.f21455i.add(this.f21450d);
            this.f21455i.add(this.f21451e);
            this.f21455i.add(this.f21452f);
            this.f21455i.add(this.f21453g);
            this.f21455i.add(this.f21454h);
            this.a = bdTypeListView;
            bdTypeListView.addAdapters(this.f21455i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.a.getAdapter2() instanceof c.a.d.n.e.e)) {
            this.a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f21452f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(c.a.t0.q1.l.e eVar) {
        ArrayList<c.a.d.n.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
