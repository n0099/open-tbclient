package b.a.r0.j1.j;

import b.a.r0.b0.e0.l;
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
    public BdTypeListView f18340a;

    /* renamed from: b  reason: collision with root package name */
    public i f18341b;

    /* renamed from: c  reason: collision with root package name */
    public g f18342c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f18343d;

    /* renamed from: e  reason: collision with root package name */
    public e f18344e;

    /* renamed from: f  reason: collision with root package name */
    public f f18345f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f18346g;

    /* renamed from: h  reason: collision with root package name */
    public h f18347h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.e.l.e.a> f18348i;

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
        this.f18348i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f18344e = new e(hotTopicActivity, b.a.r0.j1.l.g.f18452f);
            this.f18341b = new i(hotTopicActivity, m.p);
            this.f18342c = new g(hotTopicActivity, b.a.r0.j1.l.i.p);
            this.f18343d = new RelateCardForumAdapter(hotTopicActivity, n.f18477g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f18345f = new f(pageContext, b.a.r0.b0.e0.k.s0);
            this.f18346g = new HomePageVideoThreadAdapter(pageContext, l.X);
            this.f18347h = new h(pageContext, b.a.r0.b0.e0.k.v0);
            this.f18348i.add(this.f18341b);
            this.f18348i.add(this.f18342c);
            this.f18348i.add(this.f18343d);
            this.f18348i.add(this.f18344e);
            this.f18348i.add(this.f18345f);
            this.f18348i.add(this.f18346g);
            this.f18348i.add(this.f18347h);
            this.f18340a = bdTypeListView;
            bdTypeListView.addAdapters(this.f18348i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f18340a.getAdapter2() instanceof b.a.e.l.e.e)) {
            this.f18340a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f18345f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(b.a.r0.j1.l.e eVar) {
        ArrayList<b.a.e.l.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f18340a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
