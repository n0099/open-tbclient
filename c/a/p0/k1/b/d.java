package c.a.p0.k1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.a.f;
import c.a.p0.k1.b.f.b;
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
    public c.a.o0.i0.f.d<FeedData, c.a.o0.i0.d.b, c.a.p0.k1.b.a> f20983a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f20984b;

    /* renamed from: c  reason: collision with root package name */
    public View f20985c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f20986d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.s.f0.g f20987e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.i0.g.a f20988f;

    /* renamed from: g  reason: collision with root package name */
    public View f20989g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f20990h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f20991i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f20992j;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20993e;

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
            this.f20993e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f20993e.j(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20994e;

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
            this.f20994e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f20994e.f20986d.loadMoreData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f20995a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f20996b;

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
            this.f20996b = dVar;
            this.f20995a = feedData;
        }

        @Override // c.a.p0.k1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f20996b.f20992j)) {
                return;
            }
            this.f20996b.f20992j.remove(this.f20995a);
            if (this.f20996b.f20983a != null) {
                this.f20996b.f20983a.k(this.f20996b.f20992j);
            }
        }
    }

    /* renamed from: c.a.p0.k1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0985d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20997e;

        public RunnableC0985d(d dVar) {
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
            this.f20997e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20997e.f20984b.startPullRefresh();
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
        this.f20986d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.p0.k1.b.f.a aVar = new c.a.p0.k1.b.f.a();
        aVar.f21021a = 2;
        aVar.f21022b = c.a.e.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f21023c = c.a.e.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f21024d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.p0.k1.b.f.b bVar = new c.a.p0.k1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f20984b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.o0.i0.f.d<FeedData, c.a.o0.i0.d.b, c.a.p0.k1.b.a> dVar = this.f20983a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.o0.i0.g.a aVar = this.f20988f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.o0.s.f0.g gVar = this.f20987e;
            if (gVar != null) {
                gVar.D(i2);
            }
            this.f20990h.onChangeSkinType(tbPageContext, i2);
            c.a.o0.s.u.c.d(this.f20984b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f20986d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f20985c = inflate;
            this.f20986d.setContentView(inflate);
            this.f20984b = (BdListView) this.f20985c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f20985c.findViewById(R.id.view_navigation_bar);
            this.f20990h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20990h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f20990h.showBottomLine();
            c.a.o0.s.f0.g gVar = new c.a.o0.s.f0.g(this.f20986d.getPageContext());
            this.f20987e = gVar;
            gVar.V(this.f20986d.getUniqueId());
            this.f20987e.a(this.f20986d);
            c.a.o0.i0.g.a aVar = new c.a.o0.i0.g.a(this.f20986d);
            this.f20988f = aVar;
            aVar.a();
            this.f20989g = new TextView(this.f20986d.getPageContext().getPageActivity());
            this.f20989g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f20986d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f20989g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            this.f20984b.setPullRefresh(this.f20987e);
            this.f20984b.addHeaderView(this.f20989g, 0);
            this.f20984b.setNextPage(this.f20988f);
            this.f20984b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f20985c.findViewById(R.id.no_networkview);
            this.f20991i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f20991i.addNetworkChangeListener(new a(this));
            this.f20984b.setExOnSrollToBottomListener(new b(this));
            c.a.o0.i0.f.d<FeedData, c.a.o0.i0.d.b, c.a.p0.k1.b.a> dVar = new c.a.o0.i0.f.d<>(this.f20986d.getPageContext(), c.a.p0.k1.b.a.class, R.layout.mention_atme_item, this.f20986d.getEventCenter());
            this.f20983a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f20986d)), NoDataViewFactory.e.d(null, this.f20986d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f20984b.setAdapter((ListAdapter) this.f20983a);
            return this.f20985c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f20989g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            if (z && (bdListView = this.f20984b) != null && bdListView.getWrappedAdapter() != null && this.f20984b.getWrappedAdapter().getCount() <= 0) {
                c.a.e.e.m.e.a().post(new RunnableC0985d(this));
            }
        }
    }

    public void k(c.a.o0.i0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f20992j = gVar.a();
            c.a.o0.i0.f.d<FeedData, c.a.o0.i0.d.b, c.a.p0.k1.b.a> dVar = this.f20983a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.o0.i0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.o0.i0.d.a)) {
            c.a.o0.i0.d.a aVar = (c.a.o0.i0.d.a) bVar;
            if (this.f20988f != null) {
                if (aVar.d()) {
                    this.f20988f.d();
                    if (aVar.b()) {
                        this.f20988f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f20988f.f(R.string.loading);
                    } else {
                        this.f20988f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f20988f.e();
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
            c.a.o0.s.f0.g gVar = this.f20987e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f20984b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.o0.s.f0.g gVar2 = this.f20987e;
            if (gVar2 != null) {
                gVar2.a(this.f20986d);
            }
        }
    }
}
