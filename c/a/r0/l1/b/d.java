package c.a.r0.l1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.a.f;
import c.a.r0.l1.b.f.b;
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
    public c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> f21893a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f21894b;

    /* renamed from: c  reason: collision with root package name */
    public View f21895c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f21896d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.f0.g f21897e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.k0.g.a f21898f;

    /* renamed from: g  reason: collision with root package name */
    public View f21899g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f21900h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f21901i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f21902j;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21903e;

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
            this.f21903e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21903e.j(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21904e;

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
            this.f21904e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f21904e.f21896d.loadMoreData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f21905a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f21906b;

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
            this.f21906b = dVar;
            this.f21905a = feedData;
        }

        @Override // c.a.r0.l1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f21906b.f21902j)) {
                return;
            }
            this.f21906b.f21902j.remove(this.f21905a);
            if (this.f21906b.f21893a != null) {
                this.f21906b.f21893a.k(this.f21906b.f21902j);
            }
        }
    }

    /* renamed from: c.a.r0.l1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1029d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21907e;

        public RunnableC1029d(d dVar) {
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
            this.f21907e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21907e.f21894b.startPullRefresh();
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
        this.f21896d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.r0.l1.b.f.a aVar = new c.a.r0.l1.b.f.a();
        aVar.f21931a = 2;
        aVar.f21932b = c.a.e.e.m.b.g(feedData.getThread_id(), 0L);
        aVar.f21933c = c.a.e.e.m.b.g(feedData.getPost_id(), 0L);
        aVar.f21934d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.r0.l1.b.f.b bVar = new c.a.r0.l1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f21894b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> dVar = this.f21893a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.k0.g.a aVar = this.f21898f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.s.f0.g gVar = this.f21897e;
            if (gVar != null) {
                gVar.D(i2);
            }
            this.f21900h.onChangeSkinType(tbPageContext, i2);
            c.a.q0.s.u.c.d(this.f21894b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f21896d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f21895c = inflate;
            this.f21896d.setContentView(inflate);
            this.f21894b = (BdListView) this.f21895c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f21895c.findViewById(R.id.view_navigation_bar);
            this.f21900h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21900h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f21900h.showBottomLine();
            c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f21896d.getPageContext());
            this.f21897e = gVar;
            gVar.V(this.f21896d.getUniqueId());
            this.f21897e.a(this.f21896d);
            c.a.q0.k0.g.a aVar = new c.a.q0.k0.g.a(this.f21896d);
            this.f21898f = aVar;
            aVar.a();
            this.f21899g = new TextView(this.f21896d.getPageContext().getPageActivity());
            this.f21899g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f21896d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f21899g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            this.f21894b.setPullRefresh(this.f21897e);
            this.f21894b.addHeaderView(this.f21899g, 0);
            this.f21894b.setNextPage(this.f21898f);
            this.f21894b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f21895c.findViewById(R.id.no_networkview);
            this.f21901i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f21901i.addNetworkChangeListener(new a(this));
            this.f21894b.setExOnSrollToBottomListener(new b(this));
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> dVar = new c.a.q0.k0.f.d<>(this.f21896d.getPageContext(), c.a.r0.l1.b.a.class, R.layout.mention_atme_item, this.f21896d.getEventCenter());
            this.f21893a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f21896d)), NoDataViewFactory.e.d(null, this.f21896d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f21894b.setAdapter((ListAdapter) this.f21893a);
            return this.f21895c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f21899g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            if (z && (bdListView = this.f21894b) != null && bdListView.getWrappedAdapter() != null && this.f21894b.getWrappedAdapter().getCount() <= 0) {
                c.a.e.e.m.e.a().post(new RunnableC1029d(this));
            }
        }
    }

    public void k(c.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f21902j = gVar.a();
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> dVar = this.f21893a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.q0.k0.d.a)) {
            c.a.q0.k0.d.a aVar = (c.a.q0.k0.d.a) bVar;
            if (this.f21898f != null) {
                if (aVar.d()) {
                    this.f21898f.d();
                    if (aVar.b()) {
                        this.f21898f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f21898f.f(R.string.loading);
                    } else {
                        this.f21898f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f21898f.e();
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
            c.a.q0.s.f0.g gVar = this.f21897e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f21894b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.q0.s.f0.g gVar2 = this.f21897e;
            if (gVar2 != null) {
                gVar2.a(this.f21896d);
            }
        }
    }
}
