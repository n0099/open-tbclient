package c.a.u0.e1.g2.b;

import android.view.View;
import c.a.d.o.e.n;
import c.a.u0.e1.w;
import c.a.u0.g0.b0;
import c.a.u0.n0.h;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f16596b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f16597c;

    /* renamed from: d  reason: collision with root package name */
    public String f16598d;

    /* renamed from: e  reason: collision with root package name */
    public String f16599e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f16600f;

    /* renamed from: c.a.u0.e1.g2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1052a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f16601b;

        public C1052a(a aVar) {
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
            this.f16601b = aVar;
        }

        @Override // c.a.u0.g0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f16601b.b();
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
        this.f16600f = new C1052a(this);
        this.a = tbPageContext;
        this.f16596b = bdTypeListView;
        this.f16598d = str;
        this.f16599e = str2;
        this.f16597c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.a, this.f16598d, this.f16599e);
            bVar.e0(this.f16600f);
            this.f16597c.add(bVar);
            c cVar = new c(this.a, this.f16598d);
            cVar.e0(this.f16600f);
            this.f16597c.add(cVar);
            this.f16597c.add(new f(this.a, this.f16598d));
            this.f16597c.add(new e(this.a, this.f16598d));
            List<c.a.d.o.e.a> list = this.f16597c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f19712f, tbPageContext.getUniqueId(), this.f16598d));
            d dVar = new d(this.a, this.f16598d);
            dVar.c0(this.f16600f);
            this.f16597c.add(dVar);
            List<c.a.d.o.e.a> list2 = this.f16597c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.u0.n0.c.f19702f, tbPageContext2.getUniqueId(), this.f16598d));
            List<c.a.d.o.e.a> list3 = this.f16597c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.u0.n0.f.f19708f, tbPageContext3.getUniqueId(), this.f16598d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f17251i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.q0();
            frsUserRecommendAdapter.p0(this.f16598d);
            this.f16597c.add(frsUserRecommendAdapter);
            this.f16596b.addAdapters(this.f16597c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f16596b.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f16596b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f16596b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
