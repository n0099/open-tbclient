package c.a.r0.c0.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import c.a.q0.s.f0.f;
import c.a.q0.s.s.a;
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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.d<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ChosenPostActivity f16052a;

    /* renamed from: b  reason: collision with root package name */
    public View f16053b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16054c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f16055d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.c0.a.a f16056e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.k0.g.a f16057f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16058g;

    /* renamed from: h  reason: collision with root package name */
    public g f16059h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f16060i;

    /* renamed from: j  reason: collision with root package name */
    public h f16061j;
    public int k;
    public int l;
    public c.a.q0.s.f0.g m;

    /* loaded from: classes3.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16062e;

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
            this.f16062e = bVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f16062e.f16052a.getModelController().F(z);
            }
        }
    }

    /* renamed from: c.a.r0.c0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0765b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16063e;

        public C0765b(b bVar) {
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
            this.f16063e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            tinfo item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f16063e.f16056e.getItem(i2)) == null) {
                return;
            }
            TiebaStatic.eventStat(this.f16063e.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.f16063e.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f16063e.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16064e;

        /* loaded from: classes3.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.s.s.a f16065e;

            public a(c cVar, c.a.q0.s.s.a aVar) {
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
                this.f16065e = aVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f16065e.dismiss();
                }
            }
        }

        /* renamed from: c.a.r0.c0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0766b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.s.s.a f16066e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16067f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f16068g;

            public C0766b(c cVar, c.a.q0.s.s.a aVar, int i2) {
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
                this.f16068g = cVar;
                this.f16066e = aVar;
                this.f16067f = i2;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f16066e.dismiss();
                    c.a.q0.k0.c.b bVar = new c.a.q0.k0.c.b(4101, null, null, null);
                    bVar.g(this.f16068g.f16064e.f16056e.getItem(this.f16067f));
                    bVar.i(this.f16068g.f16064e.f16052a.getUniqueId());
                    this.f16068g.f16064e.f16052a.getEventCenter().dispatchMvcEvent(bVar);
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
            this.f16064e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f16064e.getActivity());
                aVar.setMessage(this.f16064e.getActivity().getString(R.string.chosen_post_dialog_text));
                aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
                aVar.setPositiveButton(R.string.confirm, new C0766b(this, aVar, i2));
                aVar.create(this.f16064e.f16052a.getPageContext());
                aVar.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16069e;

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
            this.f16069e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void onScrollToBottom(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (l.D()) {
                    this.f16069e.f16052a.getModelController().C();
                } else if (this.f16069e.f16057f != null) {
                    this.f16069e.f16057f.d();
                    this.f16069e.f16057f.g(R.string.no_more_msg);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16070e;

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
            this.f16070e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f16070e;
                bVar.m(bVar.k());
                this.f16070e.f16059h.attachView(this.f16070e.k(), true);
                this.f16070e.t();
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16058g = false;
        this.f16052a = chosenPostActivity;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16052a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16055d : (BdListView) invokeV.objValue;
    }

    public c.a.q0.s.f0.g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new c.a.q0.s.f0.g(this.f16052a.getPageContext());
            }
            return this.m;
        }
        return (c.a.q0.s.f0.g) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16053b : (View) invokeV.objValue;
    }

    public final void l(c.a.q0.k0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            Object c2 = bVar.c();
            if (c2 instanceof Long) {
                this.f16056e.p(((Long) c2).longValue());
                if (this.f16056e.getCount() <= 5) {
                    t();
                }
            }
        }
    }

    public final void m(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (hVar = this.f16061j) == null) {
            return;
        }
        hVar.dettachView(view);
    }

    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            NavigationBar navigationBar = this.f16054c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.r0.c0.a.a aVar = this.f16056e;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.k0.g.a aVar2 = this.f16057f;
            if (aVar2 != null) {
                aVar2.onChangeSkinType(tbPageContext, i2);
            }
            NoNetworkView noNetworkView = this.f16060i;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(tbPageContext, i2);
            }
            c.a.q0.s.f0.g gVar = this.m;
            if (gVar != null) {
                gVar.D(i2);
            }
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View inflate = this.f16052a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
            this.f16053b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, errorData) == null) {
            g gVar = this.f16059h;
            if (gVar != null) {
                gVar.dettachView(k());
            }
            if (errorData != null && this.f16056e.c() <= 0) {
                u(k(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.f16055d.completePullRefreshPostDelayed(0L);
            c.a.q0.k0.g.a aVar = this.f16057f;
            if (aVar != null) {
                aVar.g(R.string.no_more_msg);
            }
        }
    }

    public boolean p(c.a.q0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int b2 = bVar.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.f16058g = false;
                        break;
                    case 4098:
                        this.f16058g = true;
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
            this.k = this.f16052a.getResources().getDimensionPixelSize(R.dimen.ds108);
            this.l = this.f16052a.getResources().getDimensionPixelSize(R.dimen.ds150);
            NavigationBar navigationBar = (NavigationBar) k().findViewById(R.id.chosen_post_navigation_bar);
            this.f16054c = navigationBar;
            navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
            this.f16054c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16055d = (BdListView) k().findViewById(R.id.chosen_post_list);
            this.f16060i = (NoNetworkView) k().findViewById(R.id.view_no_network);
            c.a.r0.c0.a.a aVar = new c.a.r0.c0.a.a(this.f16052a.getPageContext(), new Class[]{c.a.r0.c0.a.c.c.class, c.a.r0.c0.a.c.b.class, c.a.r0.c0.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.f16052a.getEventCenter());
            this.f16056e = aVar;
            this.f16055d.setAdapter((ListAdapter) aVar);
            c.a.q0.s.f0.g j2 = j();
            this.m = j2;
            this.f16055d.setPullRefresh(j2);
            this.m.a(new a(this));
            this.f16055d.setOnItemClickListener(new C0765b(this));
            this.f16055d.setOnItemLongClickListener(new c(this));
            this.f16055d.setExOnSrollToBottomListener(new d(this));
            c.a.q0.k0.g.a aVar2 = new c.a.q0.k0.g.a(this.f16052a);
            this.f16057f = aVar2;
            aVar2.a();
            i().setNextPage(this.f16057f);
            g gVar = new g(getActivity());
            this.f16059h = gVar;
            gVar.onChangeSkinType();
            this.f16059h.attachView(k(), true);
            this.f16052a.getModelController().A();
        }
    }

    public void r(c.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) && (aVar instanceof c.a.r0.c0.a.d.b)) {
            List<tinfo> a2 = ((c.a.r0.c0.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f16055d.setVisibility(0);
            }
            g gVar = this.f16059h;
            if (gVar != null) {
                gVar.dettachView(k());
            }
            if (this.f16058g) {
                this.f16056e.i(a2);
                return;
            }
            this.f16056e.k(a2);
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

    public void s(c.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) && (bVar instanceof c.a.q0.k0.d.a)) {
            c.a.q0.k0.d.a aVar = (c.a.q0.k0.d.a) bVar;
            if (aVar.d()) {
                this.f16057f.d();
                if (aVar.b()) {
                    this.f16057f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f16057f.g(R.string.no_more_msg);
                }
            } else {
                this.f16057f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f16055d.completePullRefreshPostDelayed(0L);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.q0.k0.c.b bVar = new c.a.q0.k0.c.b(4100, null, null, null);
            bVar.i(this.f16052a.getUniqueId());
            this.f16052a.getEventCenter().dispatchMvcEvent(bVar);
        }
    }

    public final void u(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, view, str, z) == null) {
            if (this.f16061j == null) {
                this.f16061j = new h(getPageContext().getPageActivity(), new e(this, null));
            }
            this.f16061j.l(str);
            this.f16061j.attachView(view, z);
            this.f16061j.o();
        }
    }
}
