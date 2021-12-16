package c.a.s0.d1.f2.b;

import android.view.View;
import c.a.d.m.e.n;
import c.a.s0.d1.w;
import c.a.s0.g0.d0;
import c.a.s0.n0.h;
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
    public BdTypeListView f15881b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.m.e.a> f15882c;

    /* renamed from: d  reason: collision with root package name */
    public String f15883d;

    /* renamed from: e  reason: collision with root package name */
    public String f15884e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f15885f;

    /* renamed from: c.a.s0.d1.f2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0982a extends d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15886b;

        public C0982a(a aVar) {
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
            this.f15886b = aVar;
        }

        @Override // c.a.s0.g0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f15886b.b();
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
        this.f15885f = new C0982a(this);
        this.a = tbPageContext;
        this.f15881b = bdTypeListView;
        this.f15883d = str;
        this.f15884e = str2;
        this.f15882c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.a, this.f15883d, this.f15884e);
            bVar.l0(this.f15885f);
            this.f15882c.add(bVar);
            c cVar = new c(this.a, this.f15883d);
            cVar.l0(this.f15885f);
            this.f15882c.add(cVar);
            this.f15882c.add(new f(this.a, this.f15883d));
            this.f15882c.add(new e(this.a, this.f15883d));
            List<c.a.d.m.e.a> list = this.f15882c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f19874f, tbPageContext.getUniqueId(), this.f15883d));
            d dVar = new d(this.a, this.f15883d);
            dVar.j0(this.f15885f);
            this.f15882c.add(dVar);
            List<c.a.d.m.e.a> list2 = this.f15882c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.s0.n0.c.f19864f, tbPageContext2.getUniqueId(), this.f15883d));
            List<c.a.d.m.e.a> list3 = this.f15882c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.s0.n0.f.f19870f, tbPageContext3.getUniqueId(), this.f15883d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f16507i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.x0();
            frsUserRecommendAdapter.w0(this.f15883d);
            this.f15882c.add(frsUserRecommendAdapter);
            this.f15881b.addAdapters(this.f15882c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f15881b.getAdapter2() instanceof c.a.d.m.e.e)) {
            this.f15881b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f15881b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
