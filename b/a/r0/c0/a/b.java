package b.a.r0.c0.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.g0.g;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.s.a;
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
/* loaded from: classes4.dex */
public class b extends b.a.e.a.d<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ChosenPostActivity f15088a;

    /* renamed from: b  reason: collision with root package name */
    public View f15089b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15090c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f15091d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.c0.a.a f15092e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.k0.g.a f15093f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15094g;

    /* renamed from: h  reason: collision with root package name */
    public g f15095h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f15096i;
    public h j;
    public int k;
    public int l;
    public b.a.q0.s.g0.g m;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15097e;

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
            this.f15097e = bVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f15097e.f15088a.getModelController().F(z);
            }
        }
    }

    /* renamed from: b.a.r0.c0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0760b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15098e;

        public C0760b(b bVar) {
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
            this.f15098e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            tinfo item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f15098e.f15092e.getItem(i2)) == null) {
                return;
            }
            TiebaStatic.eventStat(this.f15098e.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.f15098e.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f15098e.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15099e;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.q0.s.s.a f15100e;

            public a(c cVar, b.a.q0.s.s.a aVar) {
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
                this.f15100e = aVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f15100e.dismiss();
                }
            }
        }

        /* renamed from: b.a.r0.c0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0761b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.q0.s.s.a f15101e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f15102f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f15103g;

            public C0761b(c cVar, b.a.q0.s.s.a aVar, int i2) {
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
                this.f15103g = cVar;
                this.f15101e = aVar;
                this.f15102f = i2;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f15101e.dismiss();
                    b.a.q0.k0.c.b bVar = new b.a.q0.k0.c.b(4101, null, null, null);
                    bVar.g(this.f15103g.f15099e.f15092e.getItem(this.f15102f));
                    bVar.i(this.f15103g.f15099e.f15088a.getUniqueId());
                    this.f15103g.f15099e.f15088a.getEventCenter().dispatchMvcEvent(bVar);
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
            this.f15099e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f15099e.getActivity());
                aVar.setMessage(this.f15099e.getActivity().getString(R.string.chosen_post_dialog_text));
                aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
                aVar.setPositiveButton(R.string.confirm, new C0761b(this, aVar, i2));
                aVar.create(this.f15099e.f15088a.getPageContext());
                aVar.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15104e;

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
            this.f15104e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (l.D()) {
                    this.f15104e.f15088a.getModelController().C();
                } else if (this.f15104e.f15093f != null) {
                    this.f15104e.f15093f.d();
                    this.f15104e.f15093f.g(R.string.no_more_msg);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15105e;

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
            this.f15105e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f15105e;
                bVar.m(bVar.k());
                this.f15105e.f15095h.attachView(this.f15105e.k(), true);
                this.f15105e.t();
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15094g = false;
        this.f15088a = chosenPostActivity;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15088a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15091d : (BdListView) invokeV.objValue;
    }

    public b.a.q0.s.g0.g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new b.a.q0.s.g0.g(this.f15088a.getPageContext());
            }
            return this.m;
        }
        return (b.a.q0.s.g0.g) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15089b : (View) invokeV.objValue;
    }

    public final void l(b.a.q0.k0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            Object c2 = bVar.c();
            if (c2 instanceof Long) {
                this.f15092e.p(((Long) c2).longValue());
                if (this.f15092e.getCount() <= 5) {
                    t();
                }
            }
        }
    }

    public final void m(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.dettachView(view);
    }

    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            NavigationBar navigationBar = this.f15090c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i2);
            }
            b.a.r0.c0.a.a aVar = this.f15092e;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            b.a.q0.k0.g.a aVar2 = this.f15093f;
            if (aVar2 != null) {
                aVar2.onChangeSkinType(tbPageContext, i2);
            }
            NoNetworkView noNetworkView = this.f15096i;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(tbPageContext, i2);
            }
            b.a.q0.s.g0.g gVar = this.m;
            if (gVar != null) {
                gVar.C(i2);
            }
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View inflate = this.f15088a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
            this.f15089b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, errorData) == null) {
            g gVar = this.f15095h;
            if (gVar != null) {
                gVar.dettachView(k());
            }
            if (errorData != null && this.f15092e.c() <= 0) {
                u(k(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.f15091d.completePullRefreshPostDelayed(0L);
            b.a.q0.k0.g.a aVar = this.f15093f;
            if (aVar != null) {
                aVar.g(R.string.no_more_msg);
            }
        }
    }

    public boolean p(b.a.q0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int b2 = bVar.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.f15094g = false;
                        break;
                    case 4098:
                        this.f15094g = true;
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
            this.k = this.f15088a.getResources().getDimensionPixelSize(R.dimen.ds108);
            this.l = this.f15088a.getResources().getDimensionPixelSize(R.dimen.ds150);
            NavigationBar navigationBar = (NavigationBar) k().findViewById(R.id.chosen_post_navigation_bar);
            this.f15090c = navigationBar;
            navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
            this.f15090c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15091d = (BdListView) k().findViewById(R.id.chosen_post_list);
            this.f15096i = (NoNetworkView) k().findViewById(R.id.view_no_network);
            b.a.r0.c0.a.a aVar = new b.a.r0.c0.a.a(this.f15088a.getPageContext(), new Class[]{b.a.r0.c0.a.c.c.class, b.a.r0.c0.a.c.b.class, b.a.r0.c0.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.f15088a.getEventCenter());
            this.f15092e = aVar;
            this.f15091d.setAdapter((ListAdapter) aVar);
            b.a.q0.s.g0.g j = j();
            this.m = j;
            this.f15091d.setPullRefresh(j);
            this.m.a(new a(this));
            this.f15091d.setOnItemClickListener(new C0760b(this));
            this.f15091d.setOnItemLongClickListener(new c(this));
            this.f15091d.setExOnSrollToBottomListener(new d(this));
            b.a.q0.k0.g.a aVar2 = new b.a.q0.k0.g.a(this.f15088a);
            this.f15093f = aVar2;
            aVar2.a();
            i().setNextPage(this.f15093f);
            g gVar = new g(getActivity());
            this.f15095h = gVar;
            gVar.onChangeSkinType();
            this.f15095h.attachView(k(), true);
            this.f15088a.getModelController().A();
        }
    }

    public void r(b.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) && (aVar instanceof b.a.r0.c0.a.d.b)) {
            List<tinfo> a2 = ((b.a.r0.c0.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f15091d.setVisibility(0);
            }
            g gVar = this.f15095h;
            if (gVar != null) {
                gVar.dettachView(k());
            }
            if (this.f15094g) {
                this.f15092e.i(a2);
                return;
            }
            this.f15092e.k(a2);
            if (a2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(a2.size())}), 0);
            d2.l(48);
            d2.n(this.k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void s(b.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) && (bVar instanceof b.a.q0.k0.d.a)) {
            b.a.q0.k0.d.a aVar = (b.a.q0.k0.d.a) bVar;
            if (aVar.d()) {
                this.f15093f.d();
                if (aVar.b()) {
                    this.f15093f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f15093f.g(R.string.no_more_msg);
                }
            } else {
                this.f15093f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f15091d.completePullRefreshPostDelayed(0L);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b.a.q0.k0.c.b bVar = new b.a.q0.k0.c.b(4100, null, null, null);
            bVar.i(this.f15088a.getUniqueId());
            this.f15088a.getEventCenter().dispatchMvcEvent(bVar);
        }
    }

    public final void u(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, view, str, z) == null) {
            if (this.j == null) {
                this.j = new h(getPageContext().getPageActivity(), new e(this, null));
            }
            this.j.l(str);
            this.j.attachView(view, z);
            this.j.o();
        }
    }
}
