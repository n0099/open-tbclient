package c.a.s0.h0.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.r0.g0.g;
import c.a.r0.g0.h;
import c.a.r0.s.i0.f;
import c.a.r0.s.t.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class b extends c.a.d.a.d<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChosenPostActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17915b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f17916c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f17917d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.h0.a.a f17918e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.l0.g.a f17919f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17920g;

    /* renamed from: h  reason: collision with root package name */
    public g f17921h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f17922i;

    /* renamed from: j  reason: collision with root package name */
    public h f17923j;

    /* renamed from: k  reason: collision with root package name */
    public int f17924k;
    public int l;
    public c.a.r0.s.i0.g m;

    /* loaded from: classes7.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17925e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17925e = bVar;
        }

        @Override // c.a.r0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f17925e.a.getModelController().F(z);
            }
        }
    }

    /* renamed from: c.a.s0.h0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1080b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17926e;

        public C1080b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17926e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            tinfo item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f17926e.f17918e.getItem(i2)) == null) {
                return;
            }
            TiebaStatic.eventStat(this.f17926e.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.f17926e.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f17926e.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17927e;

        /* loaded from: classes7.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.s.t.a f17928e;

            public a(c cVar, c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17928e = aVar;
            }

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f17928e.dismiss();
                }
            }
        }

        /* renamed from: c.a.s0.h0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1081b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.s.t.a f17929e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f17930f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f17931g;

            public C1081b(c cVar, c.a.r0.s.t.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17931g = cVar;
                this.f17929e = aVar;
                this.f17930f = i2;
            }

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f17929e.dismiss();
                    c.a.r0.l0.c.b bVar = new c.a.r0.l0.c.b(4101, null, null, null);
                    bVar.g(this.f17931g.f17927e.f17918e.getItem(this.f17930f));
                    bVar.i(this.f17931g.f17927e.a.getUniqueId());
                    this.f17931g.f17927e.a.getEventCenter().dispatchMvcEvent(bVar);
                }
            }
        }

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17927e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.f17927e.getActivity());
                aVar.setMessage(this.f17927e.getActivity().getString(R.string.chosen_post_dialog_text));
                aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
                aVar.setPositiveButton(R.string.confirm, new C1081b(this, aVar, i2));
                aVar.create(this.f17927e.a.getPageContext());
                aVar.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17932e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17932e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (m.C()) {
                    this.f17932e.a.getModelController().C();
                } else if (this.f17932e.f17919f != null) {
                    this.f17932e.f17919f.d();
                    this.f17932e.f17919f.g(R.string.no_more_msg);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17933e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17933e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f17933e;
                bVar.m(bVar.k());
                this.f17933e.f17921h.attachView(this.f17933e.k(), true);
                this.f17933e.t();
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chosenPostActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17920g = false;
        this.a = chosenPostActivity;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17917d : (BdListView) invokeV.objValue;
    }

    public c.a.r0.s.i0.g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new c.a.r0.s.i0.g(this.a.getPageContext());
            }
            return this.m;
        }
        return (c.a.r0.s.i0.g) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17915b : (View) invokeV.objValue;
    }

    public final void l(c.a.r0.l0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            Object c2 = bVar.c();
            if (c2 instanceof Long) {
                this.f17918e.p(((Long) c2).longValue());
                if (this.f17918e.getCount() <= 5) {
                    t();
                }
            }
        }
    }

    public final void m(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (hVar = this.f17923j) == null) {
            return;
        }
        hVar.dettachView(view);
    }

    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            NavigationBar navigationBar = this.f17916c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.s0.h0.a.a aVar = this.f17918e;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.r0.l0.g.a aVar2 = this.f17919f;
            if (aVar2 != null) {
                aVar2.onChangeSkinType(tbPageContext, i2);
            }
            NoNetworkView noNetworkView = this.f17922i;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(tbPageContext, i2);
            }
            c.a.r0.s.i0.g gVar = this.m;
            if (gVar != null) {
                gVar.C(i2);
            }
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View inflate = this.a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
            this.f17915b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, errorData) == null) {
            g gVar = this.f17921h;
            if (gVar != null) {
                gVar.dettachView(k());
            }
            if (errorData != null && this.f17918e.c() <= 0) {
                u(k(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.f17917d.completePullRefreshPostDelayed(0L);
            c.a.r0.l0.g.a aVar = this.f17919f;
            if (aVar != null) {
                aVar.g(R.string.no_more_msg);
            }
        }
    }

    public boolean p(c.a.r0.l0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int b2 = bVar.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.f17920g = false;
                        break;
                    case 4098:
                        this.f17920g = true;
                        break;
                    case 4099:
                        r(bVar.a());
                        break;
                }
            } else {
                l(bVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f17924k = this.a.getResources().getDimensionPixelSize(R.dimen.ds108);
            this.l = this.a.getResources().getDimensionPixelSize(R.dimen.ds150);
            NavigationBar navigationBar = (NavigationBar) k().findViewById(R.id.chosen_post_navigation_bar);
            this.f17916c = navigationBar;
            navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
            this.f17916c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f17917d = (BdListView) k().findViewById(R.id.chosen_post_list);
            this.f17922i = (NoNetworkView) k().findViewById(R.id.view_no_network);
            c.a.s0.h0.a.a aVar = new c.a.s0.h0.a.a(this.a.getPageContext(), new Class[]{c.a.s0.h0.a.c.c.class, c.a.s0.h0.a.c.b.class, c.a.s0.h0.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.a.getEventCenter());
            this.f17918e = aVar;
            this.f17917d.setAdapter((ListAdapter) aVar);
            c.a.r0.s.i0.g j2 = j();
            this.m = j2;
            this.f17917d.setPullRefresh(j2);
            this.m.a(new a(this));
            this.f17917d.setOnItemClickListener(new C1080b(this));
            this.f17917d.setOnItemLongClickListener(new c(this));
            this.f17917d.setExOnSrollToBottomListener(new d(this));
            c.a.r0.l0.g.a aVar2 = new c.a.r0.l0.g.a(this.a);
            this.f17919f = aVar2;
            aVar2.a();
            i().setNextPage(this.f17919f);
            g gVar = new g(getActivity());
            this.f17921h = gVar;
            gVar.onChangeSkinType();
            this.f17921h.attachView(k(), true);
            this.a.getModelController().A();
        }
    }

    public void r(c.a.r0.l0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) && (aVar instanceof c.a.s0.h0.a.d.b)) {
            List<tinfo> a2 = ((c.a.s0.h0.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f17917d.setVisibility(0);
            }
            g gVar = this.f17921h;
            if (gVar != null) {
                gVar.dettachView(k());
            }
            if (this.f17920g) {
                this.f17918e.i(a2);
                return;
            }
            this.f17918e.k(a2);
            if (a2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(a2.size())}), 0);
            d2.l(48);
            d2.n(this.f17924k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void s(c.a.r0.l0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) && (bVar instanceof c.a.r0.l0.d.a)) {
            c.a.r0.l0.d.a aVar = (c.a.r0.l0.d.a) bVar;
            if (aVar.d()) {
                this.f17919f.d();
                if (aVar.b()) {
                    this.f17919f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f17919f.g(R.string.no_more_msg);
                }
            } else {
                this.f17919f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f17917d.completePullRefreshPostDelayed(0L);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.r0.l0.c.b bVar = new c.a.r0.l0.c.b(4100, null, null, null);
            bVar.i(this.a.getUniqueId());
            this.a.getEventCenter().dispatchMvcEvent(bVar);
        }
    }

    public final void u(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, view, str, z) == null) {
            if (this.f17923j == null) {
                this.f17923j = new h(getPageContext().getPageActivity(), new e(this, null));
            }
            this.f17923j.m(str);
            this.f17923j.attachView(view, z);
            this.f17923j.p();
        }
    }
}
