package c.a.p0.f1.w1.b;

import android.view.View;
import c.a.d.o.e.n;
import c.a.p0.f1.w;
import c.a.p0.h0.b0;
import c.a.p0.o0.h;
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
    public BdTypeListView f14801b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14802c;

    /* renamed from: d  reason: collision with root package name */
    public String f14803d;

    /* renamed from: e  reason: collision with root package name */
    public String f14804e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f14805f;

    /* renamed from: c.a.p0.f1.w1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1118a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14806b;

        public C1118a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14806b = aVar;
        }

        @Override // c.a.p0.h0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f14806b.b();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14805f = new C1118a(this);
        this.a = tbPageContext;
        this.f14801b = bdTypeListView;
        this.f14803d = str;
        this.f14804e = str2;
        this.f14802c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.a, this.f14803d, this.f14804e);
            bVar.e0(this.f14805f);
            this.f14802c.add(bVar);
            c cVar = new c(this.a, this.f14803d);
            cVar.e0(this.f14805f);
            this.f14802c.add(cVar);
            this.f14802c.add(new f(this.a, this.f14803d));
            this.f14802c.add(new e(this.a, this.f14803d));
            List<c.a.d.o.e.a> list = this.f14802c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f16801b, tbPageContext.getUniqueId(), this.f14803d));
            d dVar = new d(this.a, this.f14803d);
            dVar.c0(this.f14805f);
            this.f14802c.add(dVar);
            List<c.a.d.o.e.a> list2 = this.f14802c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, c.a.p0.o0.c.f16796b, tbPageContext2.getUniqueId(), this.f14803d));
            List<c.a.d.o.e.a> list3 = this.f14802c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, c.a.p0.o0.f.f16799b, tbPageContext3.getUniqueId(), this.f14803d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f14796e, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.p0();
            frsUserRecommendAdapter.o0(this.f14803d);
            this.f14802c.add(frsUserRecommendAdapter);
            this.f14801b.a(this.f14802c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f14801b.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f14801b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f14801b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
