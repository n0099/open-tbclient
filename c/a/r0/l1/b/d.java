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
    public c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> f21907a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f21908b;

    /* renamed from: c  reason: collision with root package name */
    public View f21909c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f21910d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.f0.g f21911e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.k0.g.a f21912f;

    /* renamed from: g  reason: collision with root package name */
    public View f21913g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f21914h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f21915i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f21916j;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21917e;

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
            this.f21917e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21917e.j(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21918e;

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
            this.f21918e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f21918e.f21910d.loadMoreData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f21919a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f21920b;

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
            this.f21920b = dVar;
            this.f21919a = feedData;
        }

        @Override // c.a.r0.l1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f21920b.f21916j)) {
                return;
            }
            this.f21920b.f21916j.remove(this.f21919a);
            if (this.f21920b.f21907a != null) {
                this.f21920b.f21907a.k(this.f21920b.f21916j);
            }
        }
    }

    /* renamed from: c.a.r0.l1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1027d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21921e;

        public RunnableC1027d(d dVar) {
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
            this.f21921e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21921e.f21908b.startPullRefresh();
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
        this.f21910d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.r0.l1.b.f.a aVar = new c.a.r0.l1.b.f.a();
        aVar.f21945a = 2;
        aVar.f21946b = c.a.e.e.m.b.g(feedData.getThread_id(), 0L);
        aVar.f21947c = c.a.e.e.m.b.g(feedData.getPost_id(), 0L);
        aVar.f21948d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.r0.l1.b.f.b bVar = new c.a.r0.l1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f21908b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> dVar = this.f21907a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.k0.g.a aVar = this.f21912f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.s.f0.g gVar = this.f21911e;
            if (gVar != null) {
                gVar.D(i2);
            }
            this.f21914h.onChangeSkinType(tbPageContext, i2);
            c.a.q0.s.u.c.d(this.f21908b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f21910d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f21909c = inflate;
            this.f21910d.setContentView(inflate);
            this.f21908b = (BdListView) this.f21909c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f21909c.findViewById(R.id.view_navigation_bar);
            this.f21914h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21914h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f21914h.showBottomLine();
            c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f21910d.getPageContext());
            this.f21911e = gVar;
            gVar.V(this.f21910d.getUniqueId());
            this.f21911e.a(this.f21910d);
            c.a.q0.k0.g.a aVar = new c.a.q0.k0.g.a(this.f21910d);
            this.f21912f = aVar;
            aVar.a();
            this.f21913g = new TextView(this.f21910d.getPageContext().getPageActivity());
            this.f21913g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f21910d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f21913g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            this.f21908b.setPullRefresh(this.f21911e);
            this.f21908b.addHeaderView(this.f21913g, 0);
            this.f21908b.setNextPage(this.f21912f);
            this.f21908b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f21909c.findViewById(R.id.no_networkview);
            this.f21915i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f21915i.addNetworkChangeListener(new a(this));
            this.f21908b.setExOnSrollToBottomListener(new b(this));
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> dVar = new c.a.q0.k0.f.d<>(this.f21910d.getPageContext(), c.a.r0.l1.b.a.class, R.layout.mention_atme_item, this.f21910d.getEventCenter());
            this.f21907a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f21910d)), NoDataViewFactory.e.d(null, this.f21910d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f21908b.setAdapter((ListAdapter) this.f21907a);
            return this.f21909c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f21913g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            if (z && (bdListView = this.f21908b) != null && bdListView.getWrappedAdapter() != null && this.f21908b.getWrappedAdapter().getCount() <= 0) {
                c.a.e.e.m.e.a().post(new RunnableC1027d(this));
            }
        }
    }

    public void k(c.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f21916j = gVar.a();
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.l1.b.a> dVar = this.f21907a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.q0.k0.d.a)) {
            c.a.q0.k0.d.a aVar = (c.a.q0.k0.d.a) bVar;
            if (this.f21912f != null) {
                if (aVar.d()) {
                    this.f21912f.d();
                    if (aVar.b()) {
                        this.f21912f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f21912f.f(R.string.loading);
                    } else {
                        this.f21912f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f21912f.e();
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
            c.a.q0.s.f0.g gVar = this.f21911e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f21908b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.q0.s.f0.g gVar2 = this.f21911e;
            if (gVar2 != null) {
                gVar2.a(this.f21910d);
            }
        }
    }
}
