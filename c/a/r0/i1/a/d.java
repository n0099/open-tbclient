package c.a.r0.i1.a;

import c.a.r0.a0.d0.l;
import c.a.r0.i1.c.m;
import c.a.r0.i1.c.n;
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
    public BdTypeListView f19181a;

    /* renamed from: b  reason: collision with root package name */
    public i f19182b;

    /* renamed from: c  reason: collision with root package name */
    public g f19183c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f19184d;

    /* renamed from: e  reason: collision with root package name */
    public e f19185e;

    /* renamed from: f  reason: collision with root package name */
    public f f19186f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f19187g;

    /* renamed from: h  reason: collision with root package name */
    public h f19188h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19189i;

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
        this.f19189i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f19185e = new e(hotTopicActivity, c.a.r0.i1.c.g.f19300f);
            this.f19182b = new i(hotTopicActivity, m.p);
            this.f19183c = new g(hotTopicActivity, c.a.r0.i1.c.i.p);
            this.f19184d = new RelateCardForumAdapter(hotTopicActivity, n.f19327g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f19186f = new f(pageContext, c.a.r0.a0.d0.k.s0);
            this.f19187g = new HomePageVideoThreadAdapter(pageContext, l.X);
            this.f19188h = new h(pageContext, c.a.r0.a0.d0.k.v0);
            this.f19189i.add(this.f19182b);
            this.f19189i.add(this.f19183c);
            this.f19189i.add(this.f19184d);
            this.f19189i.add(this.f19185e);
            this.f19189i.add(this.f19186f);
            this.f19189i.add(this.f19187g);
            this.f19189i.add(this.f19188h);
            this.f19181a = bdTypeListView;
            bdTypeListView.addAdapters(this.f19189i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f19181a.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f19181a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f19186f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(c.a.r0.i1.c.e eVar) {
        ArrayList<c.a.e.l.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f19181a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
