package b.a.r0.j1.j;

import b.a.r0.b0.f0.l;
import b.a.r0.j1.l.m;
import b.a.r0.j1.l.n;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f19674a;

    /* renamed from: b  reason: collision with root package name */
    public i f19675b;

    /* renamed from: c  reason: collision with root package name */
    public g f19676c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f19677d;

    /* renamed from: e  reason: collision with root package name */
    public e f19678e;

    /* renamed from: f  reason: collision with root package name */
    public f f19679f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f19680g;

    /* renamed from: h  reason: collision with root package name */
    public h f19681h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.e.m.e.a> f19682i;

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
        this.f19682i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f19678e = new e(hotTopicActivity, b.a.r0.j1.l.g.f19786f);
            this.f19675b = new i(hotTopicActivity, m.p);
            this.f19676c = new g(hotTopicActivity, b.a.r0.j1.l.i.p);
            this.f19677d = new RelateCardForumAdapter(hotTopicActivity, n.f19811g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f19679f = new f(pageContext, b.a.r0.b0.f0.k.u0);
            this.f19680g = new HomePageVideoThreadAdapter(pageContext, l.Z);
            this.f19681h = new h(pageContext, b.a.r0.b0.f0.k.x0);
            this.f19682i.add(this.f19675b);
            this.f19682i.add(this.f19676c);
            this.f19682i.add(this.f19677d);
            this.f19682i.add(this.f19678e);
            this.f19682i.add(this.f19679f);
            this.f19682i.add(this.f19680g);
            this.f19682i.add(this.f19681h);
            this.f19674a = bdTypeListView;
            bdTypeListView.addAdapters(this.f19682i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f19674a.getAdapter2() instanceof b.a.e.m.e.e)) {
            this.f19674a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f19679f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(b.a.r0.j1.l.e eVar) {
        ArrayList<b.a.e.m.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f19674a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
