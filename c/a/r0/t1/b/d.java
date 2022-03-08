package c.a.r0.t1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.r0.t1.b.f.b;
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
/* loaded from: classes2.dex */
public class d extends c.a.d.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.t1.b.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f22230b;

    /* renamed from: c  reason: collision with root package name */
    public View f22231c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f22232d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.r.l0.g f22233e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.k0.g.a f22234f;

    /* renamed from: g  reason: collision with root package name */
    public View f22235g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f22236h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f22237i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f22238j;

    /* loaded from: classes2.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22239e;

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
            this.f22239e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f22239e.j(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22240e;

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
            this.f22240e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f22240e.f22232d.loadMoreData();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f22241b;

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
            this.f22241b = dVar;
            this.a = feedData;
        }

        @Override // c.a.r0.t1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f22241b.f22238j)) {
                return;
            }
            this.f22241b.f22238j.remove(this.a);
            if (this.f22241b.a != null) {
                this.f22241b.a.k(this.f22241b.f22238j);
            }
        }
    }

    /* renamed from: c.a.r0.t1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1394d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22242e;

        public RunnableC1394d(d dVar) {
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
            this.f22242e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22242e.f22230b.startPullRefresh();
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
        this.f22232d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.r0.t1.b.f.a aVar = new c.a.r0.t1.b.f.a();
        aVar.a = 2;
        aVar.f22258b = c.a.d.f.m.b.g(feedData.getThread_id(), 0L);
        aVar.f22259c = c.a.d.f.m.b.g(feedData.getPost_id(), 0L);
        aVar.f22260d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.r0.t1.b.f.b bVar = new c.a.r0.t1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f22230b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.t1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.k0.g.a aVar = this.f22234f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.r.l0.g gVar = this.f22233e;
            if (gVar != null) {
                gVar.C(i2);
            }
            this.f22236h.onChangeSkinType(tbPageContext, i2);
            c.a.q0.r.v.c.d(this.f22230b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f22232d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f22231c = inflate;
            this.f22232d.setContentView(inflate);
            this.f22230b = (BdListView) this.f22231c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f22231c.findViewById(R.id.view_navigation_bar);
            this.f22236h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22236h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f22236h.showBottomLine();
            c.a.q0.r.l0.g gVar = new c.a.q0.r.l0.g(this.f22232d.getPageContext());
            this.f22233e = gVar;
            gVar.V(this.f22232d.getUniqueId());
            this.f22233e.a(this.f22232d);
            c.a.q0.k0.g.a aVar = new c.a.q0.k0.g.a(this.f22232d);
            this.f22234f = aVar;
            aVar.a();
            this.f22235g = new TextView(this.f22232d.getPageContext().getPageActivity());
            this.f22235g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.n.f(this.f22232d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f22235g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            this.f22230b.setPullRefresh(this.f22233e);
            this.f22230b.addHeaderView(this.f22235g, 0);
            this.f22230b.setNextPage(this.f22234f);
            this.f22230b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f22231c.findViewById(R.id.no_networkview);
            this.f22237i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f22237i.addNetworkChangeListener(new a(this));
            this.f22230b.setExOnSrollToBottomListener(new b(this));
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.t1.b.a> dVar = new c.a.q0.k0.f.d<>(this.f22232d.getPageContext(), c.a.r0.t1.b.a.class, R.layout.mention_atme_item, this.f22232d.getEventCenter());
            this.a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f22232d)), NoDataViewFactory.e.d(null, this.f22232d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f22230b.setAdapter((ListAdapter) this.a);
            return this.f22231c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f22235g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            if (z && (bdListView = this.f22230b) != null && bdListView.getWrappedAdapter() != null && this.f22230b.getWrappedAdapter().getCount() <= 0) {
                c.a.d.f.m.e.a().post(new RunnableC1394d(this));
            }
        }
    }

    public void k(c.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f22238j = gVar.a();
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.t1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.q0.k0.d.a)) {
            c.a.q0.k0.d.a aVar = (c.a.q0.k0.d.a) bVar;
            if (this.f22234f != null) {
                if (aVar.d()) {
                    this.f22234f.d();
                    if (aVar.b()) {
                        this.f22234f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f22234f.f(R.string.loading);
                    } else {
                        this.f22234f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f22234f.e();
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
            c.a.q0.r.l0.g gVar = this.f22233e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f22230b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.q0.r.l0.g gVar2 = this.f22233e;
            if (gVar2 != null) {
                gVar2.a(this.f22232d);
            }
        }
    }
}
