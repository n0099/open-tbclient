package c.a.t0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.t0.u1.b.f.b;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionImageUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.AtMessageActivity;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends c.a.d.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.l0.f.d<FeedData, c.a.s0.l0.d.b, c.a.t0.u1.b.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f23949b;

    /* renamed from: c  reason: collision with root package name */
    public View f23950c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f23951d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.s.k0.g f23952e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.l0.g.a f23953f;

    /* renamed from: g  reason: collision with root package name */
    public View f23954g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f23955h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f23956i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f23957j;

    /* loaded from: classes8.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23958e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23958e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f23958e.j(z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23959e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23959e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f23959e.f23951d.loadMoreData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f23960b;

        public c(d dVar, FeedData feedData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, feedData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23960b = dVar;
            this.a = feedData;
        }

        @Override // c.a.t0.u1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f23960b.f23957j)) {
                return;
            }
            this.f23960b.f23957j.remove(this.a);
            if (this.f23960b.a != null) {
                this.f23960b.a.k(this.f23960b.f23957j);
            }
        }
    }

    /* renamed from: c.a.t0.u1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1457d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23961e;

        public RunnableC1457d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23961e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23961e.f23949b.startPullRefresh();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23951d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.t0.u1.b.f.a aVar = new c.a.t0.u1.b.f.a();
        aVar.a = 2;
        aVar.f23977b = c.a.d.f.m.b.g(feedData.getThread_id(), 0L);
        aVar.f23978c = c.a.d.f.m.b.g(feedData.getPost_id(), 0L);
        aVar.f23979d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.t0.u1.b.f.b bVar = new c.a.t0.u1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f23949b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.s0.l0.f.d<FeedData, c.a.s0.l0.d.b, c.a.t0.u1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.s0.l0.g.a aVar = this.f23953f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.s0.s.k0.g gVar = this.f23952e;
            if (gVar != null) {
                gVar.C(i2);
            }
            this.f23955h.onChangeSkinType(tbPageContext, i2);
            c.a.s0.s.u.c.d(this.f23949b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f23951d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f23950c = inflate;
            this.f23951d.setContentView(inflate);
            this.f23949b = (BdListView) this.f23950c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f23950c.findViewById(R.id.view_navigation_bar);
            this.f23955h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f23955h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f23955h.showBottomLine();
            c.a.s0.s.k0.g gVar = new c.a.s0.s.k0.g(this.f23951d.getPageContext());
            this.f23952e = gVar;
            gVar.V(this.f23951d.getUniqueId());
            this.f23952e.a(this.f23951d);
            c.a.s0.l0.g.a aVar = new c.a.s0.l0.g.a(this.f23951d);
            this.f23953f = aVar;
            aVar.a();
            this.f23954g = new TextView(this.f23951d.getPageContext().getPageActivity());
            this.f23954g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.n.f(this.f23951d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f23954g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            this.f23949b.setPullRefresh(this.f23952e);
            this.f23949b.addHeaderView(this.f23954g, 0);
            this.f23949b.setNextPage(this.f23953f);
            this.f23949b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f23950c.findViewById(R.id.no_networkview);
            this.f23956i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f23956i.addNetworkChangeListener(new a(this));
            this.f23949b.setExOnSrollToBottomListener(new b(this));
            c.a.s0.l0.f.d<FeedData, c.a.s0.l0.d.b, c.a.t0.u1.b.a> dVar = new c.a.s0.l0.f.d<>(this.f23951d.getPageContext(), c.a.t0.u1.b.a.class, R.layout.mention_atme_item, this.f23951d.getEventCenter());
            this.a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f23951d)), NoDataViewFactory.e.d(null, this.f23951d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f23949b.setAdapter((ListAdapter) this.a);
            return this.f23950c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f23954g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            if (z && (bdListView = this.f23949b) != null && bdListView.getWrappedAdapter() != null && this.f23949b.getWrappedAdapter().getCount() <= 0) {
                c.a.d.f.m.e.a().post(new RunnableC1457d(this));
            }
        }
    }

    public void k(c.a.s0.l0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f23957j = gVar.a();
            c.a.s0.l0.f.d<FeedData, c.a.s0.l0.d.b, c.a.t0.u1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.s0.l0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.s0.l0.d.a)) {
            c.a.s0.l0.d.a aVar = (c.a.s0.l0.d.a) bVar;
            if (this.f23953f != null) {
                if (aVar.d()) {
                    this.f23953f.d();
                    if (aVar.b()) {
                        this.f23953f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f23953f.f(R.string.loading);
                    } else {
                        this.f23953f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f23953f.e();
                }
            }
            if (aVar.c()) {
                m();
            } else {
                g();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.s0.s.k0.g gVar = this.f23952e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f23949b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.s0.s.k0.g gVar2 = this.f23952e;
            if (gVar2 != null) {
                gVar2.a(this.f23951d);
            }
        }
    }
}
