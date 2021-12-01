package c.a.r0.p1.j;

import c.a.r0.g0.f0.l;
import c.a.r0.p1.l.m;
import c.a.r0.p1.l.n;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeListView a;

    /* renamed from: b  reason: collision with root package name */
    public i f21048b;

    /* renamed from: c  reason: collision with root package name */
    public g f21049c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f21050d;

    /* renamed from: e  reason: collision with root package name */
    public e f21051e;

    /* renamed from: f  reason: collision with root package name */
    public f f21052f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f21053g;

    /* renamed from: h  reason: collision with root package name */
    public h f21054h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.d.m.e.a> f21055i;

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
        this.f21055i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f21051e = new e(hotTopicActivity, c.a.r0.p1.l.g.f21157f);
            this.f21048b = new i(hotTopicActivity, m.p);
            this.f21049c = new g(hotTopicActivity, c.a.r0.p1.l.i.p);
            this.f21050d = new RelateCardForumAdapter(hotTopicActivity, n.f21182g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f21052f = new f(pageContext, c.a.r0.g0.f0.k.v0);
            this.f21053g = new HomePageVideoThreadAdapter(pageContext, l.Z);
            this.f21054h = new h(pageContext, c.a.r0.g0.f0.k.y0);
            this.f21055i.add(this.f21048b);
            this.f21055i.add(this.f21049c);
            this.f21055i.add(this.f21050d);
            this.f21055i.add(this.f21051e);
            this.f21055i.add(this.f21052f);
            this.f21055i.add(this.f21053g);
            this.f21055i.add(this.f21054h);
            this.a = bdTypeListView;
            bdTypeListView.addAdapters(this.f21055i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.a.getAdapter2() instanceof c.a.d.m.e.e)) {
            this.a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f21052f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(c.a.r0.p1.l.e eVar) {
        ArrayList<c.a.d.m.e.n> arrayList;
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
