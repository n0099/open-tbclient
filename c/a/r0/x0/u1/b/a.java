package c.a.r0.x0.u1.b;

import android.view.View;
import c.a.e.l.e.n;
import c.a.r0.b0.c0;
import c.a.r0.h0.h;
import c.a.r0.x0.w;
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
    public TbPageContext f28035a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f28036b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f28037c;

    /* renamed from: d  reason: collision with root package name */
    public String f28038d;

    /* renamed from: e  reason: collision with root package name */
    public String f28039e;

    /* renamed from: f  reason: collision with root package name */
    public c0 f28040f;

    /* renamed from: c.a.r0.x0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1318a extends c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f28041b;

        public C1318a(a aVar) {
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
            this.f28041b = aVar;
        }

        @Override // c.a.r0.b0.c0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f28041b.b();
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
        this.f28040f = new C1318a(this);
        this.f28035a = tbPageContext;
        this.f28036b = bdTypeListView;
        this.f28038d = str;
        this.f28039e = str2;
        this.f28037c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f28035a, this.f28038d, this.f28039e);
            bVar.m0(this.f28040f);
            this.f28037c.add(bVar);
            c cVar = new c(this.f28035a, this.f28038d);
            cVar.m0(this.f28040f);
            this.f28037c.add(cVar);
            this.f28037c.add(new f(this.f28035a, this.f28038d));
            this.f28037c.add(new e(this.f28035a, this.f28038d));
            List<c.a.e.l.e.a> list = this.f28037c;
            TbPageContext tbPageContext = this.f28035a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f17936f, tbPageContext.getUniqueId(), this.f28038d));
            d dVar = new d(this.f28035a, this.f28038d);
            dVar.k0(this.f28040f);
            this.f28037c.add(dVar);
            List<c.a.e.l.e.a> list2 = this.f28037c;
            TbPageContext tbPageContext2 = this.f28035a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.r0.h0.c.f17926f, tbPageContext2.getUniqueId(), this.f28038d));
            List<c.a.e.l.e.a> list3 = this.f28037c;
            TbPageContext tbPageContext3 = this.f28035a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.r0.h0.f.f17932f, tbPageContext3.getUniqueId(), this.f28038d));
            TbPageContext tbPageContext4 = this.f28035a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f28101i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.y0();
            frsUserRecommendAdapter.x0(this.f28038d);
            this.f28037c.add(frsUserRecommendAdapter);
            this.f28036b.addAdapters(this.f28037c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f28036b.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f28036b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f28036b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
