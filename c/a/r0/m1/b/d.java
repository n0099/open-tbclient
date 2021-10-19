package c.a.r0.m1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.a.f;
import c.a.r0.m1.b.f.b;
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
    public c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.m1.b.a> f22087a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f22088b;

    /* renamed from: c  reason: collision with root package name */
    public View f22089c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f22090d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.f0.g f22091e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.k0.g.a f22092f;

    /* renamed from: g  reason: collision with root package name */
    public View f22093g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f22094h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f22095i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedData> f22096j;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22097e;

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
            this.f22097e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f22097e.j(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22098e;

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
            this.f22098e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f22098e.f22090d.loadMoreData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f22099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f22100b;

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
            this.f22100b = dVar;
            this.f22099a = feedData;
        }

        @Override // c.a.r0.m1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f22100b.f22096j)) {
                return;
            }
            this.f22100b.f22096j.remove(this.f22099a);
            if (this.f22100b.f22087a != null) {
                this.f22100b.f22087a.k(this.f22100b.f22096j);
            }
        }
    }

    /* renamed from: c.a.r0.m1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1036d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22101e;

        public RunnableC1036d(d dVar) {
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
            this.f22101e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22101e.f22088b.startPullRefresh();
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
        this.f22090d = atMessageActivity;
    }

    public void f(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.r0.m1.b.f.a aVar = new c.a.r0.m1.b.f.a();
        aVar.f22125a = 2;
        aVar.f22126b = c.a.e.e.m.b.g(feedData.getThread_id(), 0L);
        aVar.f22127c = c.a.e.e.m.b.g(feedData.getPost_id(), 0L);
        aVar.f22128d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.r0.m1.b.f.b bVar = new c.a.r0.m1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f22088b) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void h(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.m1.b.a> dVar = this.f22087a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.k0.g.a aVar = this.f22092f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.s.f0.g gVar = this.f22091e;
            if (gVar != null) {
                gVar.D(i2);
            }
            this.f22094h.onChangeSkinType(tbPageContext, i2);
            c.a.q0.s.u.c.d(this.f22088b).f(R.color.CAM_X0201);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f22090d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f22089c = inflate;
            this.f22090d.setContentView(inflate);
            this.f22088b = (BdListView) this.f22089c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f22089c.findViewById(R.id.view_navigation_bar);
            this.f22094h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22094h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f22094h.showBottomLine();
            c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f22090d.getPageContext());
            this.f22091e = gVar;
            gVar.V(this.f22090d.getUniqueId());
            this.f22091e.a(this.f22090d);
            c.a.q0.k0.g.a aVar = new c.a.q0.k0.g.a(this.f22090d);
            this.f22092f = aVar;
            aVar.a();
            this.f22093g = new TextView(this.f22090d.getPageContext().getPageActivity());
            this.f22093g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f22090d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f22093g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            this.f22088b.setPullRefresh(this.f22091e);
            this.f22088b.addHeaderView(this.f22093g, 0);
            this.f22088b.setNextPage(this.f22092f);
            this.f22088b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f22089c.findViewById(R.id.no_networkview);
            this.f22095i = noNetworkView;
            noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f22095i.addNetworkChangeListener(new a(this));
            this.f22088b.setExOnSrollToBottomListener(new b(this));
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.m1.b.a> dVar = new c.a.q0.k0.f.d<>(this.f22090d.getPageContext(), c.a.r0.m1.b.a.class, R.layout.mention_atme_item, this.f22090d.getEventCenter());
            this.f22087a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f22090d)), NoDataViewFactory.e.d(null, this.f22090d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f22088b.setAdapter((ListAdapter) this.f22087a);
            return this.f22089c;
        }
        return (View) invokeV.objValue;
    }

    public void j(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f22093g, BdListViewHelper.HeadType.DEFAULT, c.a.e.e.p.j.z());
            if (z && (bdListView = this.f22088b) != null && bdListView.getWrappedAdapter() != null && this.f22088b.getWrappedAdapter().getCount() <= 0) {
                c.a.e.e.m.e.a().post(new RunnableC1036d(this));
            }
        }
    }

    public void k(c.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.f22096j = gVar.a();
            c.a.q0.k0.f.d<FeedData, c.a.q0.k0.d.b, c.a.r0.m1.b.a> dVar = this.f22087a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void l(c.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.q0.k0.d.a)) {
            c.a.q0.k0.d.a aVar = (c.a.q0.k0.d.a) bVar;
            if (this.f22092f != null) {
                if (aVar.d()) {
                    this.f22092f.d();
                    if (aVar.b()) {
                        this.f22092f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f22092f.f(R.string.loading);
                    } else {
                        this.f22092f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f22092f.e();
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
            c.a.q0.s.f0.g gVar = this.f22091e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f22088b;
            if (bdListView != null) {
                bdListView.startPullRefresh();
            }
            c.a.q0.s.f0.g gVar2 = this.f22091e;
            if (gVar2 != null) {
                gVar2.a(this.f22090d);
            }
        }
    }
}
