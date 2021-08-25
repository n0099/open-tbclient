package c.a.q0.v0.t1.b;

import android.view.View;
import c.a.e.l.e.n;
import c.a.q0.a0.b0;
import c.a.q0.g0.h;
import c.a.q0.v0.w;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27161a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f27162b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f27163c;

    /* renamed from: d  reason: collision with root package name */
    public String f27164d;

    /* renamed from: e  reason: collision with root package name */
    public String f27165e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f27166f;

    /* renamed from: c.a.q0.v0.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1272a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f27167b;

        public C1272a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27167b = aVar;
        }

        @Override // c.a.q0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f27167b.b();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27166f = new C1272a(this);
        this.f27161a = tbPageContext;
        this.f27162b = bdTypeListView;
        this.f27164d = str;
        this.f27165e = str2;
        this.f27163c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f27161a, this.f27164d, this.f27165e);
            bVar.m0(this.f27166f);
            this.f27163c.add(bVar);
            c cVar = new c(this.f27161a, this.f27164d);
            cVar.m0(this.f27166f);
            this.f27163c.add(cVar);
            this.f27163c.add(new f(this.f27161a, this.f27164d));
            this.f27163c.add(new e(this.f27161a, this.f27164d));
            List<c.a.e.l.e.a> list = this.f27163c;
            TbPageContext tbPageContext = this.f27161a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f18319f, tbPageContext.getUniqueId(), this.f27164d));
            d dVar = new d(this.f27161a, this.f27164d);
            dVar.k0(this.f27166f);
            this.f27163c.add(dVar);
            List<c.a.e.l.e.a> list2 = this.f27163c;
            TbPageContext tbPageContext2 = this.f27161a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.q0.g0.c.f18309f, tbPageContext2.getUniqueId(), this.f27164d));
            List<c.a.e.l.e.a> list3 = this.f27163c;
            TbPageContext tbPageContext3 = this.f27161a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.q0.g0.f.f18315f, tbPageContext3.getUniqueId(), this.f27164d));
            TbPageContext tbPageContext4 = this.f27161a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f27306i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.y0();
            frsUserRecommendAdapter.x0(this.f27164d);
            this.f27163c.add(frsUserRecommendAdapter);
            this.f27162b.addAdapters(this.f27163c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f27162b.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f27162b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f27162b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
