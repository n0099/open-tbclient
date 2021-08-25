package c.a.q0.h1.a;

import c.a.q0.a0.d0.l;
import c.a.q0.h1.c.m;
import c.a.q0.h1.c.n;
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
    public BdTypeListView f18510a;

    /* renamed from: b  reason: collision with root package name */
    public i f18511b;

    /* renamed from: c  reason: collision with root package name */
    public g f18512c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f18513d;

    /* renamed from: e  reason: collision with root package name */
    public e f18514e;

    /* renamed from: f  reason: collision with root package name */
    public f f18515f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f18516g;

    /* renamed from: h  reason: collision with root package name */
    public h f18517h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.l.e.a> f18518i;

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
        this.f18518i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f18514e = new e(hotTopicActivity, c.a.q0.h1.c.g.f18629f);
            this.f18511b = new i(hotTopicActivity, m.p);
            this.f18512c = new g(hotTopicActivity, c.a.q0.h1.c.i.p);
            this.f18513d = new RelateCardForumAdapter(hotTopicActivity, n.f18656g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f18515f = new f(pageContext, c.a.q0.a0.d0.k.s0);
            this.f18516g = new HomePageVideoThreadAdapter(pageContext, l.X);
            this.f18517h = new h(pageContext, c.a.q0.a0.d0.k.v0);
            this.f18518i.add(this.f18511b);
            this.f18518i.add(this.f18512c);
            this.f18518i.add(this.f18513d);
            this.f18518i.add(this.f18514e);
            this.f18518i.add(this.f18515f);
            this.f18518i.add(this.f18516g);
            this.f18518i.add(this.f18517h);
            this.f18510a = bdTypeListView;
            bdTypeListView.addAdapters(this.f18518i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f18510a.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f18510a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f18515f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(c.a.q0.h1.c.e eVar) {
        ArrayList<c.a.e.l.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f18510a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
