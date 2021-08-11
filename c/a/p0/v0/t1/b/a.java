package c.a.p0.v0.t1.b;

import android.view.View;
import c.a.e.k.e.n;
import c.a.p0.a0.b0;
import c.a.p0.g0.h;
import c.a.p0.v0.w;
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
    public TbPageContext f26822a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26823b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.k.e.a> f26824c;

    /* renamed from: d  reason: collision with root package name */
    public String f26825d;

    /* renamed from: e  reason: collision with root package name */
    public String f26826e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f26827f;

    /* renamed from: c.a.p0.v0.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1262a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f26828b;

        public C1262a(a aVar) {
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
            this.f26828b = aVar;
        }

        @Override // c.a.p0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f26828b.b();
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
        this.f26827f = new C1262a(this);
        this.f26822a = tbPageContext;
        this.f26823b = bdTypeListView;
        this.f26825d = str;
        this.f26826e = str2;
        this.f26824c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f26822a, this.f26825d, this.f26826e);
            bVar.m0(this.f26827f);
            this.f26824c.add(bVar);
            c cVar = new c(this.f26822a, this.f26825d);
            cVar.m0(this.f26827f);
            this.f26824c.add(cVar);
            this.f26824c.add(new f(this.f26822a, this.f26825d));
            this.f26824c.add(new e(this.f26822a, this.f26825d));
            List<c.a.e.k.e.a> list = this.f26824c;
            TbPageContext tbPageContext = this.f26822a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f17986f, tbPageContext.getUniqueId(), this.f26825d));
            d dVar = new d(this.f26822a, this.f26825d);
            dVar.k0(this.f26827f);
            this.f26824c.add(dVar);
            List<c.a.e.k.e.a> list2 = this.f26824c;
            TbPageContext tbPageContext2 = this.f26822a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.p0.g0.c.f17976f, tbPageContext2.getUniqueId(), this.f26825d));
            List<c.a.e.k.e.a> list3 = this.f26824c;
            TbPageContext tbPageContext3 = this.f26822a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.p0.g0.f.f17982f, tbPageContext3.getUniqueId(), this.f26825d));
            TbPageContext tbPageContext4 = this.f26822a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f26967i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.y0();
            frsUserRecommendAdapter.x0(this.f26825d);
            this.f26824c.add(frsUserRecommendAdapter);
            this.f26823b.addAdapters(this.f26824c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f26823b.getAdapter2() instanceof c.a.e.k.e.e)) {
            this.f26823b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f26823b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
