package c.a.p0.i0.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.f0.g;
import c.a.o0.f0.h;
import c.a.o0.r.l0.f;
import c.a.o0.r.t.a;
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
/* loaded from: classes2.dex */
public class b extends c.a.d.a.d<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChosenPostActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15464b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15465c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f15466d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.i0.a.a f15467e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.k0.g.a f15468f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15469g;

    /* renamed from: h  reason: collision with root package name */
    public g f15470h;
    public NoNetworkView i;
    public h j;
    public int k;
    public int l;
    public c.a.o0.r.l0.g m;

    /* loaded from: classes2.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.a.getModelController().H(z);
            }
        }
    }

    /* renamed from: c.a.p0.i0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1156b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1156b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            tinfo item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.f15467e.getItem(i)) == null) {
                return;
            }
            TiebaStatic.eventStat(this.a.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.a.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes2.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.o0.r.t.a a;

            public a(c cVar, c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.a.dismiss();
                }
            }
        }

        /* renamed from: c.a.p0.i0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1157b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.o0.r.t.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f15471b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f15472c;

            public C1157b(c cVar, c.a.o0.r.t.a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15472c = cVar;
                this.a = aVar;
                this.f15471b = i;
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.a.dismiss();
                    c.a.o0.k0.c.b bVar = new c.a.o0.k0.c.b(4101, null, null, null);
                    bVar.g(this.f15472c.a.f15467e.getItem(this.f15471b));
                    bVar.i(this.f15472c.a.a.getUniqueId());
                    this.f15472c.a.a.getEventCenter().dispatchMvcEvent(bVar);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getActivity());
                aVar.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f03c9));
                aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new a(this, aVar));
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new C1157b(this, aVar, i));
                aVar.create(this.a.a.getPageContext());
                aVar.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void o(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (n.C()) {
                    this.a.a.getModelController().E();
                } else if (this.a.f15468f != null) {
                    this.a.f15468f.d();
                    this.a.f15468f.g(R.string.obfuscated_res_0x7f0f0c46);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.a;
                bVar.o(bVar.m());
                this.a.f15470h.attachView(this.a.m(), true);
                this.a.v();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15469g = false;
        this.a = chosenPostActivity;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15466d : (BdListView) invokeV.objValue;
    }

    public c.a.o0.r.l0.g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new c.a.o0.r.l0.g(this.a.getPageContext());
            }
            return this.m;
        }
        return (c.a.o0.r.l0.g) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15464b : (View) invokeV.objValue;
    }

    public final void n(c.a.o0.k0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            Object c2 = bVar.c();
            if (c2 instanceof Long) {
                this.f15467e.p(((Long) c2).longValue());
                if (this.f15467e.getCount() <= 5) {
                    v();
                }
            }
        }
    }

    public final void o(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.dettachView(view);
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, errorData) == null) {
            g gVar = this.f15470h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (errorData != null && this.f15467e.c() <= 0) {
                w(m(), getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c14, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.f15466d.A(0L);
            c.a.o0.k0.g.a aVar = this.f15468f;
            if (aVar != null) {
                aVar.g(R.string.obfuscated_res_0x7f0f0c46);
            }
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            NavigationBar navigationBar = this.f15465c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i);
            }
            c.a.p0.i0.a.a aVar = this.f15467e;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i);
            }
            c.a.o0.k0.g.a aVar2 = this.f15468f;
            if (aVar2 != null) {
                aVar2.onChangeSkinType(tbPageContext, i);
            }
            NoNetworkView noNetworkView = this.i;
            if (noNetworkView != null) {
                noNetworkView.c(tbPageContext, i);
            }
            c.a.o0.r.l0.g gVar = this.m;
            if (gVar != null) {
                gVar.H(i);
            }
        }
    }

    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View inflate = this.a.getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01e7, (ViewGroup) null);
            this.f15464b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public boolean r(c.a.o0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int b2 = bVar.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.f15469g = false;
                        break;
                    case 4098:
                        this.f15469g = true;
                        break;
                    case 4099:
                        t(bVar.a());
                        break;
                }
            } else {
                n(bVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07022c);
            this.l = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070246);
            NavigationBar navigationBar = (NavigationBar) m().findViewById(R.id.obfuscated_res_0x7f090649);
            this.f15465c = navigationBar;
            navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f0f4b);
            this.f15465c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15466d = (BdListView) m().findViewById(R.id.obfuscated_res_0x7f090648);
            this.i = (NoNetworkView) m().findViewById(R.id.obfuscated_res_0x7f0923d1);
            c.a.p0.i0.a.a aVar = new c.a.p0.i0.a.a(this.a.getPageContext(), new Class[]{c.a.p0.i0.a.c.c.class, c.a.p0.i0.a.c.b.class, c.a.p0.i0.a.c.a.class}, new int[]{R.layout.obfuscated_res_0x7f0d01e6, R.layout.obfuscated_res_0x7f0d01dd, R.layout.obfuscated_res_0x7f0d01dc}, this.a.getEventCenter());
            this.f15467e = aVar;
            this.f15466d.setAdapter((ListAdapter) aVar);
            c.a.o0.r.l0.g l = l();
            this.m = l;
            this.f15466d.setPullRefresh(l);
            this.m.f(new a(this));
            this.f15466d.setOnItemClickListener(new C1156b(this));
            this.f15466d.setOnItemLongClickListener(new c(this));
            this.f15466d.setExOnSrollToBottomListener(new d(this));
            c.a.o0.k0.g.a aVar2 = new c.a.o0.k0.g.a(this.a);
            this.f15468f = aVar2;
            aVar2.a();
            k().setNextPage(this.f15468f);
            g gVar = new g(getActivity());
            this.f15470h = gVar;
            gVar.onChangeSkinType();
            this.f15470h.attachView(m(), true);
            this.a.getModelController().C();
        }
    }

    public void t(c.a.o0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) && (aVar instanceof c.a.p0.i0.a.d.b)) {
            List<tinfo> a2 = ((c.a.p0.i0.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f15466d.setVisibility(0);
            }
            g gVar = this.f15470h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (this.f15469g) {
                this.f15467e.i(a2);
                return;
            }
            this.f15467e.k(a2);
            if (a2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.obfuscated_res_0x7f0f03ca, new Object[]{Integer.valueOf(a2.size())}), 0);
            d2.l(48);
            d2.n(this.k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void u(c.a.o0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) && (bVar instanceof c.a.o0.k0.d.a)) {
            c.a.o0.k0.d.a aVar = (c.a.o0.k0.d.a) bVar;
            if (aVar.d()) {
                this.f15468f.d();
                if (aVar.b()) {
                    this.f15468f.f(R.string.obfuscated_res_0x7f0f0a2e);
                } else if (!aVar.a()) {
                    this.f15468f.g(R.string.obfuscated_res_0x7f0f0c46);
                }
            } else {
                this.f15468f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f15466d.A(0L);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.o0.k0.c.b bVar = new c.a.o0.k0.c.b(4100, null, null, null);
            bVar.i(this.a.getUniqueId());
            this.a.getEventCenter().dispatchMvcEvent(bVar);
        }
    }

    public final void w(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, view, str, z) == null) {
            if (this.j == null) {
                this.j = new h(getPageContext().getPageActivity(), new e(this, null));
            }
            this.j.m(str);
            this.j.attachView(view, z);
            this.j.p();
        }
    }
}
