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
    public b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> f21001a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f21002b;

    /* renamed from: c  reason: collision with root package name */
    public View f21003c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f21004d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.g0.g f21005e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.k0.g.a f21006f;

    /* renamed from: g  reason: collision with root package name */
    public View f21007g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f21008h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f21009i;
    public List<FeedData> j;

    /* loaded from: classes5.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21010e;

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
            this.f21010e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21010e.j(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21011e;

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
            this.f21011e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f21011e.f21004d.loadMoreData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f21012a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f21013b;

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
            this.f21013b = dVar;
            this.f21012a = feedData;
        }

        @Override // b.a.r0.m1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f21013b.j)) {
                return;
            }
            this.f21013b.j.remove(this.f21012a);
            if (this.f21013b.f21001a != null) {
                this.f21013b.f21001a.k(this.f21013b.j);
            }
        }
    }

    /* renamed from: b.a.r0.m1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1032d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21014e;

        public RunnableC1032d(d dVar) {
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
            this.f21014e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21014e.f21002b.startPullRefresh();
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
        this.f21004d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        b.a.r0.m1.b.f.a aVar = new b.a.r0.m1.b.f.a();
        aVar.f21037a = 2;
        aVar.f21038b = b.a.e.e.m.b.g(feedData.getThread_id(), 0L);
        aVar.f21039c = b.a.e.e.m.b.g(feedData.getPost_id(), 0L);
        aVar.f21040d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        b.a.r0.m1.b.f.b bVar = new b.a.r0.m1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f21002b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> dVar = this.f21001a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            b.a.q0.k0.g.a aVar = this.f21006f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            b.a.q0.s.g0.g gVar = this.f21005e;
            if (gVar != null) {
                gVar.C(i2);
            }
            this.f21008h.onChangeSkinType(tbPageContext, i2);
            b.a.q0.s.u.c.d(this.f21002b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f21004d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f21003c = inflate;
            this.f21004d.setContentView(inflate);
            this.f21002b = (BdListView) this.f21003c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f21003c.findViewById(R.id.view_navigation_bar);
            this.f21008h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21008h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f21008h.showBottomLine();
            b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(this.f21004d.getPageContext());
            this.f21005e = gVar;
            gVar.U(this.f21004d.getUniqueId());
            this.f21005e.a(this.f21004d);
            b.a.q0.k0.g.a aVar = new b.a.q0.k0.g.a(this.f21004d);
            this.f21006f = aVar;
            aVar.a();
            this.f21007g = new TextView(this.f21004d.getPageContext().getPageActivity());
            this.f21007g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + b.a.e.e.p.l.g(this.f21004d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f21007g, BdListViewHelper.HeadType.DEFAULT, b.a.e.e.p.j.z());
            this.f21002b.setPullRefresh(this.f21005e);
            this.f21002b.addHeaderView(this.f21007g, 0);
            this.f21002b.setNextPage(this.f21006f);
            this.f21002b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f21003c.findViewById(R.id.no_networkview);
            this.f21009i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f21009i.addNetworkChangeListener(new a(this));
            this.f21002b.setExOnSrollToBottomListener(new b(this));
            b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> dVar = new b.a.q0.k0.f.d<>(this.f21004d.getPageContext(), b.a.r0.m1.b.a.class, R.layout.mention_atme_item, this.f21004d.getEventCenter());
            this.f21001a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f21004d)), NoDataViewFactory.e.d(null, this.f21004d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f21002b.setAdapter((ListAdapter) this.f21001a);
            return this.f21003c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f21007g, BdListViewHelper.HeadType.DEFAULT, b.a.e.e.p.j.z());
            if (z && (bdListView = this.f21002b) != null && bdListView.getWrappedAdapter() != null && this.f21002b.getWrappedAdapter().getCount() <= 0) {
                b.a.e.e.m.e.a().post(new RunnableC1032d(this));
            }
        }
    }

    public void k(b.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            b.a.q0.k0.f.d<FeedData, b.a.q0.k0.d.b, b.a.r0.m1.b.a> dVar = this.f21001a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(b.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof b.a.q0.k0.d.a)) {
            b.a.q0.k0.d.a aVar = (b.a.q0.k0.d.a) bVar;
            if (this.f21006f != null) {
                if (aVar.d()) {
                    this.f21006f.d();
                    if (aVar.b()) {
                        this.f21006f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f21006f.f(R.string.loading);
                    } else {
                        this.f21006f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f21006f.e();
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
            b.a.q0.s.g0.g gVar = this.f21005e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f21002b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            b.a.q0.s.g0.g gVar2 = this.f21005e;
            if (gVar2 != null) {
                gVar2.a(this.f21004d);
            }
        }
    }
}
