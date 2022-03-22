package c.a.p0.v1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.p0.v1.b.f.b;
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
    public c.a.o0.k0.f.d<FeedData, c.a.o0.k0.d.b, c.a.p0.v1.b.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f19103b;

    /* renamed from: c  reason: collision with root package name */
    public View f19104c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f19105d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.r.l0.g f19106e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.k0.g.a f19107f;

    /* renamed from: g  reason: collision with root package name */
    public View f19108g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f19109h;
    public NoNetworkView i;
    public List<FeedData> j;

    /* loaded from: classes2.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.l(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void o(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.a.f19105d.loadMoreData();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f19110b;

        public c(d dVar, FeedData feedData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, feedData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19110b = dVar;
            this.a = feedData;
        }

        @Override // c.a.p0.v1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f19110b.j)) {
                return;
            }
            this.f19110b.j.remove(this.a);
            if (this.f19110b.a != null) {
                this.f19110b.a.k(this.f19110b.j);
            }
        }
    }

    /* renamed from: c.a.p0.v1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1447d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public RunnableC1447d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f19103b.F();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19105d = atMessageActivity;
    }

    public void h(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        c.a.p0.v1.b.f.a aVar = new c.a.p0.v1.b.f.a();
        aVar.a = 2;
        aVar.f19119b = c.a.d.f.m.b.g(feedData.getThread_id(), 0L);
        aVar.f19120c = c.a.d.f.m.b.g(feedData.getPost_id(), 0L);
        aVar.f19121d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        c.a.p0.v1.b.f.b bVar = new c.a.p0.v1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void i() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f19103b) == null) {
            return;
        }
        bdListView.A(0L);
    }

    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            c.a.o0.k0.f.d<FeedData, c.a.o0.k0.d.b, c.a.p0.v1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i);
            }
            c.a.o0.k0.g.a aVar = this.f19107f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i);
            }
            c.a.o0.r.l0.g gVar = this.f19106e;
            if (gVar != null) {
                gVar.H(i);
            }
            this.f19109h.onChangeSkinType(tbPageContext, i);
            c.a.o0.r.v.c.d(this.f19103b).f(R.color.CAM_X0201);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f19105d.getActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0125, (ViewGroup) null);
            this.f19104c = inflate;
            this.f19105d.setContentView(inflate);
            this.f19103b = (BdListView) this.f19104c.findViewById(R.id.obfuscated_res_0x7f0902b8);
            NavigationBar navigationBar = (NavigationBar) this.f19104c.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f19109h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19109h.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0299));
            this.f19109h.showBottomLine();
            c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(this.f19105d.getPageContext());
            this.f19106e = gVar;
            gVar.a0(this.f19105d.getUniqueId());
            this.f19106e.f(this.f19105d);
            c.a.o0.k0.g.a aVar = new c.a.o0.k0.g.a(this.f19105d);
            this.f19107f = aVar;
            aVar.a();
            this.f19108g = new TextView(this.f19105d.getPageContext().getPageActivity());
            this.f19108g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.n.f(this.f19105d.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702ff)));
            BdListViewHelper.c(this.f19108g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            this.f19103b.setPullRefresh(this.f19106e);
            this.f19103b.x(this.f19108g, 0);
            this.f19103b.setNextPage(this.f19107f);
            this.f19103b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f19104c.findViewById(R.id.obfuscated_res_0x7f09159e);
            this.i = noNetworkView;
            noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.i.a(new a(this));
            this.f19103b.setExOnSrollToBottomListener(new b(this));
            c.a.o0.k0.f.d<FeedData, c.a.o0.k0.d.b, c.a.p0.v1.b.a> dVar = new c.a.o0.k0.f.d<>(this.f19105d.getPageContext(), c.a.p0.v1.b.a.class, R.layout.obfuscated_res_0x7f0d0552, this.f19105d.getEventCenter());
            this.a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f19105d)), NoDataViewFactory.e.d(null, this.f19105d.getResources().getString(R.string.obfuscated_res_0x7f0f0ab5)), null, null);
            this.f19103b.setAdapter((ListAdapter) this.a);
            return this.f19104c;
        }
        return (View) invokeV.objValue;
    }

    public void l(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f19108g, BdListViewHelper.HeadType.DEFAULT, c.a.d.f.p.l.z());
            if (z && (bdListView = this.f19103b) != null && bdListView.getWrappedAdapter() != null && this.f19103b.getWrappedAdapter().getCount() <= 0) {
                c.a.d.f.m.e.a().post(new RunnableC1447d(this));
            }
        }
    }

    public void m(c.a.o0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            c.a.o0.k0.f.d<FeedData, c.a.o0.k0.d.b, c.a.p0.v1.b.a> dVar = this.a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void n(c.a.o0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof c.a.o0.k0.d.a)) {
            c.a.o0.k0.d.a aVar = (c.a.o0.k0.d.a) bVar;
            if (this.f19107f != null) {
                if (aVar.d()) {
                    this.f19107f.d();
                    if (aVar.b()) {
                        this.f19107f.f(R.string.obfuscated_res_0x7f0f0a2e);
                    } else if (aVar.a()) {
                        this.f19107f.f(R.string.obfuscated_res_0x7f0f0a2e);
                    } else {
                        this.f19107f.g(R.string.obfuscated_res_0x7f0f0c46);
                    }
                } else {
                    this.f19107f.e();
                }
            }
            if (aVar.c()) {
                o();
            } else {
                i();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.r.l0.g gVar = this.f19106e;
            if (gVar != null) {
                gVar.f(null);
            }
            BdListView bdListView = this.f19103b;
            if (bdListView != null) {
                bdListView.F();
            }
            c.a.o0.r.l0.g gVar2 = this.f19106e;
            if (gVar2 != null) {
                gVar2.f(this.f19105d);
            }
        }
    }
}
