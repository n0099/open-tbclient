package c.a.u0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.u0.u1.b.f.b;
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
/* loaded from: classes9.dex */
public class d extends c.a.d.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.l0.f.d<FeedData, c.a.t0.l0.d.b, c.a.u0.u1.b.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f22944b;

    /* renamed from: c  reason: collision with root package name */
    public View f22945c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f22946d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.s.l0.g f22947e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.l0.g.a f22948f;

    /* renamed from: g  reason: collision with root package name */
    public View f22949g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f22950h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f22951i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f22952j;

    /* loaded from: classes9.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22953e;

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
            this.f22953e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f22953e.j(z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22954e;

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
            this.f22954e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f22954e.f22946d.loadMoreData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f22955b;

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
            this.f22955b = dVar;
            this.a = feedData;
        }

        @Override // c.a.u0.u1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f22955b.f22952j)) {
                return;
            }
            this.f22955b.f22952j.remove(this.a);
            if (this.f22955b.a != null) {
                this.f22955b.a.k(this.f22955b.f22952j);
            }
        }
    }

    /* renamed from: c.a.u0.u1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1412d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22956e;

        public RunnableC1412d(d dVar) {
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
            this.f22956e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22956e.f22944b.startPullRefresh();
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
        this.f22946d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.u0.u1.b.f.a aVar = new c.a.u0.u1.b.f.a();
        aVar.a = 2;
        aVar.f22972b = c.a.d.f.m.b.g(feedData.getThread_id(), 0L);
        aVar.f22973c = c.a.d.f.m.b.g(feedData.getPost_id(), 0L);
        aVar.f22974d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.u0.u1.b.f.b bVar = new c.a.u0.u1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f22944b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.t0.l0.f.d<FeedData, c.a.t0.l0.d.b, c.a.u0.u1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.t0.l0.g.a aVar = this.f22948f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.t0.s.l0.g gVar = this.f22947e;
            if (gVar != null) {
                gVar.C(i2);
            }
            this.f22950h.onChangeSkinType(tbPageContext, i2);
            c.a.t0.s.v.c.d(this.f22944b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f22946d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f22945c = inflate;
            this.f22946d.setContentView(inflate);
            this.f22944b = (BdListView) this.f22945c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f22945c.findViewById(R.id.view_navigation_bar);
            this.f22950h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22950h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f22950h.showBottomLine();
            c.a.t0.s.l0.g gVar = new c.a.t0.s.l0.g(this.f22946d.getPageContext());
            this.f22947e = gVar;
            gVar.V(this.f22946d.getUniqueId());
            this.f22947e.a(this.f22946d);
            c.a.t0.l0.g.a aVar = new c.a.t0.l0.g.a(this.f22946d);
            this.f22948f = aVar;
            aVar.a();
            this.f22949g = new TextView(this.f22946d.getPageContext().getPageActivity());
            this.f22949g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.n.f(this.f22946d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f22949g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            this.f22944b.setPullRefresh(this.f22947e);
            this.f22944b.addHeaderView(this.f22949g, 0);
            this.f22944b.setNextPage(this.f22948f);
            this.f22944b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f22945c.findViewById(R.id.no_networkview);
            this.f22951i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f22951i.addNetworkChangeListener(new a(this));
            this.f22944b.setExOnSrollToBottomListener(new b(this));
            c.a.t0.l0.f.d<FeedData, c.a.t0.l0.d.b, c.a.u0.u1.b.a> dVar = new c.a.t0.l0.f.d<>(this.f22946d.getPageContext(), c.a.u0.u1.b.a.class, R.layout.mention_atme_item, this.f22946d.getEventCenter());
            this.a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f22946d)), NoDataViewFactory.e.d(null, this.f22946d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f22944b.setAdapter((ListAdapter) this.a);
            return this.f22945c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f22949g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            if (z && (bdListView = this.f22944b) != null && bdListView.getWrappedAdapter() != null && this.f22944b.getWrappedAdapter().getCount() <= 0) {
                c.a.d.f.m.e.a().post(new RunnableC1412d(this));
            }
        }
    }

    public void k(c.a.t0.l0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f22952j = gVar.a();
            c.a.t0.l0.f.d<FeedData, c.a.t0.l0.d.b, c.a.u0.u1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.t0.l0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.t0.l0.d.a)) {
            c.a.t0.l0.d.a aVar = (c.a.t0.l0.d.a) bVar;
            if (this.f22948f != null) {
                if (aVar.d()) {
                    this.f22948f.d();
                    if (aVar.b()) {
                        this.f22948f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f22948f.f(R.string.loading);
                    } else {
                        this.f22948f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f22948f.e();
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
            c.a.t0.s.l0.g gVar = this.f22947e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f22944b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.t0.s.l0.g gVar2 = this.f22947e;
            if (gVar2 != null) {
                gVar2.a(this.f22946d);
            }
        }
    }
}
