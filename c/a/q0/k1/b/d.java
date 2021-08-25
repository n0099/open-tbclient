package c.a.q0.k1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.a.f;
import c.a.q0.k1.b.f.b;
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
/* loaded from: classes3.dex */
public class d extends c.a.e.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.i0.f.d<FeedData, c.a.p0.i0.d.b, c.a.q0.k1.b.a> f21313a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f21314b;

    /* renamed from: c  reason: collision with root package name */
    public View f21315c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f21316d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.s.f0.g f21317e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.i0.g.a f21318f;

    /* renamed from: g  reason: collision with root package name */
    public View f21319g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f21320h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f21321i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f21322j;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21323e;

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
            this.f21323e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21323e.j(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21324e;

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
            this.f21324e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f21324e.f21316d.loadMoreData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f21325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f21326b;

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
            this.f21326b = dVar;
            this.f21325a = feedData;
        }

        @Override // c.a.q0.k1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f21326b.f21322j)) {
                return;
            }
            this.f21326b.f21322j.remove(this.f21325a);
            if (this.f21326b.f21313a != null) {
                this.f21326b.f21313a.k(this.f21326b.f21322j);
            }
        }
    }

    /* renamed from: c.a.q0.k1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0996d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21327e;

        public RunnableC0996d(d dVar) {
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
            this.f21327e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21327e.f21314b.startPullRefresh();
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
        this.f21316d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.q0.k1.b.f.a aVar = new c.a.q0.k1.b.f.a();
        aVar.f21351a = 2;
        aVar.f21352b = c.a.e.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f21353c = c.a.e.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f21354d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.q0.k1.b.f.b bVar = new c.a.q0.k1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f21314b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.p0.i0.f.d<FeedData, c.a.p0.i0.d.b, c.a.q0.k1.b.a> dVar = this.f21313a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.p0.i0.g.a aVar = this.f21318f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.p0.s.f0.g gVar = this.f21317e;
            if (gVar != null) {
                gVar.D(i2);
            }
            this.f21320h.onChangeSkinType(tbPageContext, i2);
            c.a.p0.s.u.c.d(this.f21314b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f21316d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f21315c = inflate;
            this.f21316d.setContentView(inflate);
            this.f21314b = (BdListView) this.f21315c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f21315c.findViewById(R.id.view_navigation_bar);
            this.f21320h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21320h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f21320h.showBottomLine();
            c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(this.f21316d.getPageContext());
            this.f21317e = gVar;
            gVar.V(this.f21316d.getUniqueId());
            this.f21317e.a(this.f21316d);
            c.a.p0.i0.g.a aVar = new c.a.p0.i0.g.a(this.f21316d);
            this.f21318f = aVar;
            aVar.a();
            this.f21319g = new TextView(this.f21316d.getPageContext().getPageActivity());
            this.f21319g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f21316d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f21319g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            this.f21314b.setPullRefresh(this.f21317e);
            this.f21314b.addHeaderView(this.f21319g, 0);
            this.f21314b.setNextPage(this.f21318f);
            this.f21314b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f21315c.findViewById(R.id.no_networkview);
            this.f21321i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f21321i.addNetworkChangeListener(new a(this));
            this.f21314b.setExOnSrollToBottomListener(new b(this));
            c.a.p0.i0.f.d<FeedData, c.a.p0.i0.d.b, c.a.q0.k1.b.a> dVar = new c.a.p0.i0.f.d<>(this.f21316d.getPageContext(), c.a.q0.k1.b.a.class, R.layout.mention_atme_item, this.f21316d.getEventCenter());
            this.f21313a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f21316d)), NoDataViewFactory.e.d(null, this.f21316d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f21314b.setAdapter((ListAdapter) this.f21313a);
            return this.f21315c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f21319g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            if (z && (bdListView = this.f21314b) != null && bdListView.getWrappedAdapter() != null && this.f21314b.getWrappedAdapter().getCount() <= 0) {
                c.a.e.e.m.e.a().post(new RunnableC0996d(this));
            }
        }
    }

    public void k(c.a.p0.i0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f21322j = gVar.a();
            c.a.p0.i0.f.d<FeedData, c.a.p0.i0.d.b, c.a.q0.k1.b.a> dVar = this.f21313a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.p0.i0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.p0.i0.d.a)) {
            c.a.p0.i0.d.a aVar = (c.a.p0.i0.d.a) bVar;
            if (this.f21318f != null) {
                if (aVar.d()) {
                    this.f21318f.d();
                    if (aVar.b()) {
                        this.f21318f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f21318f.f(R.string.loading);
                    } else {
                        this.f21318f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f21318f.e();
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
            c.a.p0.s.f0.g gVar = this.f21317e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f21314b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.p0.s.f0.g gVar2 = this.f21317e;
            if (gVar2 != null) {
                gVar2.a(this.f21316d);
            }
        }
    }
}
