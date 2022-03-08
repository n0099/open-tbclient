package c.a.r0.d1.w1.b;

import android.view.View;
import c.a.d.o.e.n;
import c.a.r0.d1.w;
import c.a.r0.f0.b0;
import c.a.r0.m0.h;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f16645b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f16646c;

    /* renamed from: d  reason: collision with root package name */
    public String f16647d;

    /* renamed from: e  reason: collision with root package name */
    public String f16648e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f16649f;

    /* renamed from: c.a.r0.d1.w1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1061a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f16650b;

        public C1061a(a aVar) {
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
            this.f16650b = aVar;
        }

        @Override // c.a.r0.f0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f16650b.b();
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
        this.f16649f = new C1061a(this);
        this.a = tbPageContext;
        this.f16645b = bdTypeListView;
        this.f16647d = str;
        this.f16648e = str2;
        this.f16646c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.a, this.f16647d, this.f16648e);
            bVar.e0(this.f16649f);
            this.f16646c.add(bVar);
            c cVar = new c(this.a, this.f16647d);
            cVar.e0(this.f16649f);
            this.f16646c.add(cVar);
            this.f16646c.add(new f(this.a, this.f16647d));
            this.f16646c.add(new e(this.a, this.f16647d));
            List<c.a.d.o.e.a> list = this.f16646c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f19255f, tbPageContext.getUniqueId(), this.f16647d));
            d dVar = new d(this.a, this.f16647d);
            dVar.c0(this.f16649f);
            this.f16646c.add(dVar);
            List<c.a.d.o.e.a> list2 = this.f16646c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.r0.m0.c.f19245f, tbPageContext2.getUniqueId(), this.f16647d));
            List<c.a.d.o.e.a> list3 = this.f16646c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.r0.m0.f.f19251f, tbPageContext3.getUniqueId(), this.f16647d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f16640i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.q0();
            frsUserRecommendAdapter.p0(this.f16647d);
            this.f16646c.add(frsUserRecommendAdapter);
            this.f16645b.addAdapters(this.f16646c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f16645b.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f16645b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f16645b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
