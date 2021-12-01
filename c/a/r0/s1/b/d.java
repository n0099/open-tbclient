package c.a.r0.s1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.r0.s1.b.f.b;
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
/* loaded from: classes6.dex */
public class d extends c.a.d.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.l0.f.d<FeedData, c.a.q0.l0.d.b, c.a.r0.s1.b.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f23332b;

    /* renamed from: c  reason: collision with root package name */
    public View f23333c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f23334d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.g0.g f23335e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.l0.g.a f23336f;

    /* renamed from: g  reason: collision with root package name */
    public View f23337g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f23338h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f23339i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f23340j;

    /* loaded from: classes6.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23341e;

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
            this.f23341e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f23341e.j(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23342e;

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
            this.f23342e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f23342e.f23334d.loadMoreData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f23343b;

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
            this.f23343b = dVar;
            this.a = feedData;
        }

        @Override // c.a.r0.s1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f23343b.f23340j)) {
                return;
            }
            this.f23343b.f23340j.remove(this.a);
            if (this.f23343b.a != null) {
                this.f23343b.a.k(this.f23343b.f23340j);
            }
        }
    }

    /* renamed from: c.a.r0.s1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1348d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23344e;

        public RunnableC1348d(d dVar) {
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
            this.f23344e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23344e.f23332b.startPullRefresh();
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
        this.f23334d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.r0.s1.b.f.a aVar = new c.a.r0.s1.b.f.a();
        aVar.a = 2;
        aVar.f23361b = c.a.d.f.m.b.g(feedData.getThread_id(), 0L);
        aVar.f23362c = c.a.d.f.m.b.g(feedData.getPost_id(), 0L);
        aVar.f23363d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.r0.s1.b.f.b bVar = new c.a.r0.s1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f23332b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.q0.l0.f.d<FeedData, c.a.q0.l0.d.b, c.a.r0.s1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.l0.g.a aVar = this.f23336f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.s.g0.g gVar = this.f23335e;
            if (gVar != null) {
                gVar.C(i2);
            }
            this.f23338h.onChangeSkinType(tbPageContext, i2);
            c.a.q0.s.u.c.d(this.f23332b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f23334d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f23333c = inflate;
            this.f23334d.setContentView(inflate);
            this.f23332b = (BdListView) this.f23333c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f23333c.findViewById(R.id.view_navigation_bar);
            this.f23338h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f23338h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f23338h.showBottomLine();
            c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(this.f23334d.getPageContext());
            this.f23335e = gVar;
            gVar.V(this.f23334d.getUniqueId());
            this.f23335e.a(this.f23334d);
            c.a.q0.l0.g.a aVar = new c.a.q0.l0.g.a(this.f23334d);
            this.f23336f = aVar;
            aVar.a();
            this.f23337g = new TextView(this.f23334d.getPageContext().getPageActivity());
            this.f23337g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.l.f(this.f23334d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f23337g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.j.z());
            this.f23332b.setPullRefresh(this.f23335e);
            this.f23332b.addHeaderView(this.f23337g, 0);
            this.f23332b.setNextPage(this.f23336f);
            this.f23332b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f23333c.findViewById(R.id.no_networkview);
            this.f23339i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f23339i.addNetworkChangeListener(new a(this));
            this.f23332b.setExOnSrollToBottomListener(new b(this));
            c.a.q0.l0.f.d<FeedData, c.a.q0.l0.d.b, c.a.r0.s1.b.a> dVar = new c.a.q0.l0.f.d<>(this.f23334d.getPageContext(), c.a.r0.s1.b.a.class, R.layout.mention_atme_item, this.f23334d.getEventCenter());
            this.a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f23334d)), NoDataViewFactory.e.d(null, this.f23334d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f23332b.setAdapter((ListAdapter) this.a);
            return this.f23333c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f23337g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.j.z());
            if (z && (bdListView = this.f23332b) != null && bdListView.getWrappedAdapter() != null && this.f23332b.getWrappedAdapter().getCount() <= 0) {
                c.a.d.f.m.e.a().post(new RunnableC1348d(this));
            }
        }
    }

    public void k(c.a.q0.l0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f23340j = gVar.a();
            c.a.q0.l0.f.d<FeedData, c.a.q0.l0.d.b, c.a.r0.s1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.q0.l0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.q0.l0.d.a)) {
            c.a.q0.l0.d.a aVar = (c.a.q0.l0.d.a) bVar;
            if (this.f23336f != null) {
                if (aVar.d()) {
                    this.f23336f.d();
                    if (aVar.b()) {
                        this.f23336f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f23336f.f(R.string.loading);
                    } else {
                        this.f23336f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f23336f.e();
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
            c.a.q0.s.g0.g gVar = this.f23335e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f23332b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.q0.s.g0.g gVar2 = this.f23335e;
            if (gVar2 != null) {
                gVar2.a(this.f23334d);
            }
        }
    }
}
