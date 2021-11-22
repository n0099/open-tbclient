package b.a.r0.m1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.a.e.a.f;
import b.a.r0.m1.b.f.b;
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
/* loaded from: classes5.dex */
public class d extends b.a.e.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> f22156a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f22157b;

    /* renamed from: c  reason: collision with root package name */
    public View f22158c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f22159d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.g0.g f22160e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.k0.g.a f22161f;

    /* renamed from: g  reason: collision with root package name */
    public View f22162g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f22163h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f22164i;
    public List<FeedData> j;

    /* loaded from: classes5.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22165e;

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
            this.f22165e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f22165e.j(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22166e;

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
            this.f22166e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f22166e.f22159d.loadMoreData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f22167a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f22168b;

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
            this.f22168b = dVar;
            this.f22167a = feedData;
        }

        @Override // b.a.r0.m1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f22168b.j)) {
                return;
            }
            this.f22168b.j.remove(this.f22167a);
            if (this.f22168b.f22156a != null) {
                this.f22168b.f22156a.k(this.f22168b.j);
            }
        }
    }

    /* renamed from: b.a.r0.m1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1094d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22169e;

        public RunnableC1094d(d dVar) {
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
            this.f22169e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22169e.f22157b.startPullRefresh();
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
        this.f22159d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        b.a.r0.m1.b.f.a aVar = new b.a.r0.m1.b.f.a();
        aVar.f22192a = 2;
        aVar.f22193b = b.a.e.f.m.b.g(feedData.getThread_id(), 0L);
        aVar.f22194c = b.a.e.f.m.b.g(feedData.getPost_id(), 0L);
        aVar.f22195d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        b.a.r0.m1.b.f.b bVar = new b.a.r0.m1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f22157b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> dVar = this.f22156a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            b.a.q0.k0.g.a aVar = this.f22161f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            b.a.q0.s.g0.g gVar = this.f22160e;
            if (gVar != null) {
                gVar.C(i2);
            }
            this.f22163h.onChangeSkinType(tbPageContext, i2);
            b.a.q0.s.u.c.d(this.f22157b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f22159d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f22158c = inflate;
            this.f22159d.setContentView(inflate);
            this.f22157b = (BdListView) this.f22158c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f22158c.findViewById(R.id.view_navigation_bar);
            this.f22163h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22163h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f22163h.showBottomLine();
            b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(this.f22159d.getPageContext());
            this.f22160e = gVar;
            gVar.U(this.f22159d.getUniqueId());
            this.f22160e.a(this.f22159d);
            b.a.q0.k0.g.a aVar = new b.a.q0.k0.g.a(this.f22159d);
            this.f22161f = aVar;
            aVar.a();
            this.f22162g = new TextView(this.f22159d.getPageContext().getPageActivity());
            this.f22162g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + b.a.e.f.p.l.g(this.f22159d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f22162g, BdListViewHelper.HeadType.DEFAULT, b.a.e.f.p.j.z());
            this.f22157b.setPullRefresh(this.f22160e);
            this.f22157b.addHeaderView(this.f22162g, 0);
            this.f22157b.setNextPage(this.f22161f);
            this.f22157b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f22158c.findViewById(R.id.no_networkview);
            this.f22164i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f22164i.addNetworkChangeListener(new a(this));
            this.f22157b.setExOnSrollToBottomListener(new b(this));
            b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> dVar = new b.a.q0.k0.f.d<>(this.f22159d.getPageContext(), b.a.r0.m1.b.a.class, R.layout.mention_atme_item, this.f22159d.getEventCenter());
            this.f22156a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f22159d)), NoDataViewFactory.e.d(null, this.f22159d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f22157b.setAdapter((ListAdapter) this.f22156a);
            return this.f22158c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f22162g, BdListViewHelper.HeadType.DEFAULT, b.a.e.f.p.j.z());
            if (z && (bdListView = this.f22157b) != null && bdListView.getWrappedAdapter() != null && this.f22157b.getWrappedAdapter().getCount() <= 0) {
                b.a.e.f.m.e.a().post(new RunnableC1094d(this));
            }
        }
    }

    public void k(b.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> dVar = this.f22156a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(b.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof b.a.q0.k0.d.a)) {
            b.a.q0.k0.d.a aVar = (b.a.q0.k0.d.a) bVar;
            if (this.f22161f != null) {
                if (aVar.d()) {
                    this.f22161f.d();
                    if (aVar.b()) {
                        this.f22161f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f22161f.f(R.string.loading);
                    } else {
                        this.f22161f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f22161f.e();
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
            b.a.q0.s.g0.g gVar = this.f22160e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f22157b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            b.a.q0.s.g0.g gVar2 = this.f22160e;
            if (gVar2 != null) {
                gVar2.a(this.f22159d);
            }
        }
    }
}
