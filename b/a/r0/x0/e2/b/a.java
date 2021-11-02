package b.a.r0.x0.e2.b;

import android.view.View;
import b.a.e.l.e.n;
import b.a.r0.b0.c0;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25690a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25691b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.l.e.a> f25692c;

    /* renamed from: d  reason: collision with root package name */
    public String f25693d;

    /* renamed from: e  reason: collision with root package name */
    public String f25694e;

    /* renamed from: f  reason: collision with root package name */
    public c0 f25695f;

    /* renamed from: b.a.r0.x0.e2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1266a extends c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f25696b;

        public C1266a(a aVar) {
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
            this.f25696b = aVar;
        }

        @Override // b.a.r0.b0.c0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f25696b.b();
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
        this.f25695f = new C1266a(this);
        this.f25690a = tbPageContext;
        this.f25691b = bdTypeListView;
        this.f25693d = str;
        this.f25694e = str2;
        this.f25692c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f25690a, this.f25693d, this.f25694e);
            bVar.l0(this.f25695f);
            this.f25692c.add(bVar);
            c cVar = new c(this.f25690a, this.f25693d);
            cVar.l0(this.f25695f);
            this.f25692c.add(cVar);
            this.f25692c.add(new f(this.f25690a, this.f25693d));
            this.f25692c.add(new e(this.f25690a, this.f25693d));
            List<b.a.e.l.e.a> list = this.f25692c;
            TbPageContext tbPageContext = this.f25690a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f16890f, tbPageContext.getUniqueId(), this.f25693d));
            d dVar = new d(this.f25690a, this.f25693d);
            dVar.j0(this.f25695f);
            this.f25692c.add(dVar);
            List<b.a.e.l.e.a> list2 = this.f25692c;
            TbPageContext tbPageContext2 = this.f25690a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, b.a.r0.h0.c.f16880f, tbPageContext2.getUniqueId(), this.f25693d));
            List<b.a.e.l.e.a> list3 = this.f25692c;
            TbPageContext tbPageContext3 = this.f25690a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, b.a.r0.h0.f.f16886f, tbPageContext3.getUniqueId(), this.f25693d));
            TbPageContext tbPageContext4 = this.f25690a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f26491i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.x0();
            frsUserRecommendAdapter.w0(this.f25693d);
            this.f25692c.add(frsUserRecommendAdapter);
            this.f25691b.addAdapters(this.f25692c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f25691b.getAdapter2() instanceof b.a.e.l.e.e)) {
            this.f25691b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f25691b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
