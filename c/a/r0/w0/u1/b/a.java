package c.a.r0.w0.u1.b;

import android.view.View;
import c.a.e.l.e.n;
import c.a.r0.a0.b0;
import c.a.r0.g0.h;
import c.a.r0.w0.w;
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
    public TbPageContext f27859a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f27860b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f27861c;

    /* renamed from: d  reason: collision with root package name */
    public String f27862d;

    /* renamed from: e  reason: collision with root package name */
    public String f27863e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f27864f;

    /* renamed from: c.a.r0.w0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1309a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f27865b;

        public C1309a(a aVar) {
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
            this.f27865b = aVar;
        }

        @Override // c.a.r0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f27865b.b();
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
        this.f27864f = new C1309a(this);
        this.f27859a = tbPageContext;
        this.f27860b = bdTypeListView;
        this.f27862d = str;
        this.f27863e = str2;
        this.f27861c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f27859a, this.f27862d, this.f27863e);
            bVar.m0(this.f27864f);
            this.f27861c.add(bVar);
            c cVar = new c(this.f27859a, this.f27862d);
            cVar.m0(this.f27864f);
            this.f27861c.add(cVar);
            this.f27861c.add(new f(this.f27859a, this.f27862d));
            this.f27861c.add(new e(this.f27859a, this.f27862d));
            List<c.a.e.l.e.a> list = this.f27861c;
            TbPageContext tbPageContext = this.f27859a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f17769f, tbPageContext.getUniqueId(), this.f27862d));
            d dVar = new d(this.f27859a, this.f27862d);
            dVar.k0(this.f27864f);
            this.f27861c.add(dVar);
            List<c.a.e.l.e.a> list2 = this.f27861c;
            TbPageContext tbPageContext2 = this.f27859a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.r0.g0.c.f17759f, tbPageContext2.getUniqueId(), this.f27862d));
            List<c.a.e.l.e.a> list3 = this.f27861c;
            TbPageContext tbPageContext3 = this.f27859a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.r0.g0.f.f17765f, tbPageContext3.getUniqueId(), this.f27862d));
            TbPageContext tbPageContext4 = this.f27859a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f27925i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.y0();
            frsUserRecommendAdapter.x0(this.f27862d);
            this.f27861c.add(frsUserRecommendAdapter);
            this.f27860b.addAdapters(this.f27861c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f27860b.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f27860b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f27860b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
