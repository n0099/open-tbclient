package c.a.t0.e1.g2.b;

import android.view.View;
import c.a.d.n.e.n;
import c.a.t0.e1.w;
import c.a.t0.g0.d0;
import c.a.t0.n0.h;
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
    public BdTypeListView f16425b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.n.e.a> f16426c;

    /* renamed from: d  reason: collision with root package name */
    public String f16427d;

    /* renamed from: e  reason: collision with root package name */
    public String f16428e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f16429f;

    /* renamed from: c.a.t0.e1.g2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1046a extends d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f16430b;

        public C1046a(a aVar) {
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
            this.f16430b = aVar;
        }

        @Override // c.a.t0.g0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f16430b.b();
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
        this.f16429f = new C1046a(this);
        this.a = tbPageContext;
        this.f16425b = bdTypeListView;
        this.f16427d = str;
        this.f16428e = str2;
        this.f16426c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.a, this.f16427d, this.f16428e);
            bVar.e0(this.f16429f);
            this.f16426c.add(bVar);
            c cVar = new c(this.a, this.f16427d);
            cVar.e0(this.f16429f);
            this.f16426c.add(cVar);
            this.f16426c.add(new f(this.a, this.f16427d));
            this.f16426c.add(new e(this.a, this.f16427d));
            List<c.a.d.n.e.a> list = this.f16426c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f19689f, tbPageContext.getUniqueId(), this.f16427d));
            d dVar = new d(this.a, this.f16427d);
            dVar.c0(this.f16429f);
            this.f16426c.add(dVar);
            List<c.a.d.n.e.a> list2 = this.f16426c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.t0.n0.c.f19679f, tbPageContext2.getUniqueId(), this.f16427d));
            List<c.a.d.n.e.a> list3 = this.f16426c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.t0.n0.f.f19685f, tbPageContext3.getUniqueId(), this.f16427d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f17032i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.q0();
            frsUserRecommendAdapter.p0(this.f16427d);
            this.f16426c.add(frsUserRecommendAdapter);
            this.f16425b.addAdapters(this.f16426c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f16425b.getAdapter2() instanceof c.a.d.n.e.e)) {
            this.f16425b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f16425b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
