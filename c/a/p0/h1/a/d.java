package c.a.p0.h1.a;

import c.a.p0.a0.d0.l;
import c.a.p0.h1.c.m;
import c.a.p0.h1.c.n;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f18177a;

    /* renamed from: b  reason: collision with root package name */
    public i f18178b;

    /* renamed from: c  reason: collision with root package name */
    public g f18179c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f18180d;

    /* renamed from: e  reason: collision with root package name */
    public e f18181e;

    /* renamed from: f  reason: collision with root package name */
    public f f18182f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f18183g;

    /* renamed from: h  reason: collision with root package name */
    public h f18184h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.k.e.a> f18185i;

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
        this.f18185i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f18181e = new e(hotTopicActivity, c.a.p0.h1.c.g.f18296f);
            this.f18178b = new i(hotTopicActivity, m.p);
            this.f18179c = new g(hotTopicActivity, c.a.p0.h1.c.i.p);
            this.f18180d = new RelateCardForumAdapter(hotTopicActivity, n.f18323g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f18182f = new f(pageContext, c.a.p0.a0.d0.k.s0);
            this.f18183g = new HomePageVideoThreadAdapter(pageContext, l.X);
            this.f18184h = new h(pageContext, c.a.p0.a0.d0.k.v0);
            this.f18185i.add(this.f18178b);
            this.f18185i.add(this.f18179c);
            this.f18185i.add(this.f18180d);
            this.f18185i.add(this.f18181e);
            this.f18185i.add(this.f18182f);
            this.f18185i.add(this.f18183g);
            this.f18185i.add(this.f18184h);
            this.f18177a = bdTypeListView;
            bdTypeListView.addAdapters(this.f18185i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f18177a.getAdapter2() instanceof c.a.e.k.e.e)) {
            this.f18177a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f18182f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(c.a.p0.h1.c.e eVar) {
        ArrayList<c.a.e.k.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f18177a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
