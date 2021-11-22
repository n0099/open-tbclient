package b.a.r0.x0.f2.b;

import android.view.View;
import b.a.e.m.e.n;
import b.a.r0.b0.d0;
import b.a.r0.h0.h;
import b.a.r0.x0.w;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27285a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f27286b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.a> f27287c;

    /* renamed from: d  reason: collision with root package name */
    public String f27288d;

    /* renamed from: e  reason: collision with root package name */
    public String f27289e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f27290f;

    /* renamed from: b.a.r0.x0.f2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1339a extends d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f27291b;

        public C1339a(a aVar) {
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
            this.f27291b = aVar;
        }

        @Override // b.a.r0.b0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f27291b.b();
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
        this.f27290f = new C1339a(this);
        this.f27285a = tbPageContext;
        this.f27286b = bdTypeListView;
        this.f27288d = str;
        this.f27289e = str2;
        this.f27287c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f27285a, this.f27288d, this.f27289e);
            bVar.l0(this.f27290f);
            this.f27287c.add(bVar);
            c cVar = new c(this.f27285a, this.f27288d);
            cVar.l0(this.f27290f);
            this.f27287c.add(cVar);
            this.f27287c.add(new f(this.f27285a, this.f27288d));
            this.f27287c.add(new e(this.f27285a, this.f27288d));
            List<b.a.e.m.e.a> list = this.f27287c;
            TbPageContext tbPageContext = this.f27285a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f18357f, tbPageContext.getUniqueId(), this.f27288d));
            d dVar = new d(this.f27285a, this.f27288d);
            dVar.j0(this.f27290f);
            this.f27287c.add(dVar);
            List<b.a.e.m.e.a> list2 = this.f27287c;
            TbPageContext tbPageContext2 = this.f27285a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, b.a.r0.h0.c.f18347f, tbPageContext2.getUniqueId(), this.f27288d));
            List<b.a.e.m.e.a> list3 = this.f27287c;
            TbPageContext tbPageContext3 = this.f27285a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, b.a.r0.h0.f.f18353f, tbPageContext3.getUniqueId(), this.f27288d));
            TbPageContext tbPageContext4 = this.f27285a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f28009i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.x0();
            frsUserRecommendAdapter.w0(this.f27288d);
            this.f27287c.add(frsUserRecommendAdapter);
            this.f27286b.addAdapters(this.f27287c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f27286b.getAdapter2() instanceof b.a.e.m.e.e)) {
            this.f27286b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f27286b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
