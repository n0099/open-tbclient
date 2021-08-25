package c.a.q0.i2.k.d;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.i2.k.e.b0;
import c.a.q0.i2.k.e.k;
import c.a.q0.i2.k.e.q0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements c.a.p0.m0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19194e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f19195f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.i2.k.d.d f19196g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.i2.k.d.c f19197h;

    /* renamed from: i  reason: collision with root package name */
    public q0 f19198i;

    /* renamed from: j  reason: collision with root package name */
    public k f19199j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.z m;
    public View.OnLongClickListener n;
    public c.a.q0.i2.i.c o;
    public final MoreGodReplyModel p;
    public c.a.p0.m0.d q;
    public long r;
    public BdListView.p s;
    public AbsListView.OnScrollListener t;
    public b0.b u;
    public PbFragment.y2 v;

    /* renamed from: c.a.q0.i2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0915a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19200e;

        public C0915a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19200e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19200e.p.G()) {
                return;
            }
            this.f19200e.p.H();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f19201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19202f;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19202f = aVar;
            this.f19201e = -1;
        }

        public final boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 == 2 || i2 == 1 : invokeI.booleanValue;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, absListView, i2) == null) {
                if (!a(this.f19201e) && a(i2) && (pbFragment = this.f19202f.f19195f) != null && pbFragment.getPbView() != null) {
                    this.f19202f.f19195f.getPbView().q2();
                    this.f19202f.f19195f.getPbView().d1();
                }
                this.f19201e = i2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19203a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19203a = aVar;
        }

        @Override // c.a.q0.i2.k.e.b0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f19203a.f19198i.D3(str);
        }

        @Override // c.a.q0.i2.k.e.b0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f19203a.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f19204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19205f;

        public d(a aVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19205f = aVar;
            this.f19204e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19205f.f19196g.i();
                this.f19205f.f19194e = false;
                PbFragment pbFragment = this.f19205f.f19195f;
                if (pbFragment != null) {
                    if (pbFragment.getPbView() != null) {
                        this.f19205f.f19195f.getPbView().f3(false);
                        c.a.q0.i2.k.e.g p0 = this.f19205f.f19195f.getPbView().p0();
                        p0.c0(this.f19205f.f19195f.getPbModel().O0(), true);
                        p0.X();
                    }
                    a aVar = this.f19205f;
                    aVar.f19195f.removeBackInterceptor(aVar.v);
                }
                Runnable runnable = this.f19204e;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19206e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19206e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19206e.h();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19207e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19207e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19207e.h();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19208e;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19208e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19208e.p.G()) {
                return;
            }
            this.f19208e.p.H();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements PbFragment.y2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19209a;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19209a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.y2
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f19209a.h();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19210e;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19210e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19210e.f19197h.g(false);
            }
        }
    }

    public a(PbFragment pbFragment, q0 q0Var, ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, q0Var, viewStub};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new C0915a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new h(this);
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.getPbModel());
        this.p = moreGodReplyModel;
        moreGodReplyModel.I(this.u);
        this.f19198i = q0Var;
        this.f19195f = pbFragment;
        this.f19196g = new c.a.q0.i2.k.d.d(pbFragment, viewStub);
        this.f19197h = new c.a.q0.i2.k.d.c(this);
    }

    @Override // c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a053" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.m0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbFragment pbFragment = this.f19195f;
            if (pbFragment == null) {
                return null;
            }
            return pbFragment.getNextPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.p0.m0.a
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
            String currentPageKey = getCurrentPageKey();
            if (ListUtils.isEmpty(arrayList2)) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                arrayList.addAll(arrayList2);
            }
            if (getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
                if (!StringUtils.isNull(currentPageKey)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(currentPageKey);
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.p0.m0.a
    public c.a.p0.m0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (c.a.p0.m0.b) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i(null);
        }
    }

    public void i(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            this.p.cancelLoadData();
            this.f19195f.hideKeyboardAndEditor();
            if (!l() && runnable != null) {
                runnable.run();
                return;
            }
            if (l() && !this.f19197h.e()) {
                this.f19196g.r(new d(this, runnable));
            }
            if (this.r != 0) {
                c.a.p0.m0.d j2 = j();
                j2.w(System.currentTimeMillis() - this.r);
                c.a.p0.m0.e.b().i(this.f19195f.getContext(), j2, getPageStayFilter());
            }
        }
    }

    public c.a.p0.m0.d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.q == null) {
                c.a.p0.m0.d dVar = new c.a.p0.m0.d();
                this.q = dVar;
                dVar.v(getCurrentPageSourceKeyList());
                this.q.q(getCurrentPageKey());
                PbModel pbModel = this.f19195f.getPbModel();
                if (pbModel != null) {
                    this.q.r(c.a.e.e.m.b.f(pbModel.getForumId(), 0L));
                    this.q.A(c.a.e.e.m.b.f(pbModel.e1(), 0L));
                }
            }
            return this.q;
        }
        return (c.a.p0.m0.d) invokeV.objValue;
    }

    public c.a.q0.i2.k.d.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19196g : (c.a.q0.i2.k.d.d) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19194e : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f19196g.o(i2);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && l()) {
            x();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void q(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.m = zVar;
        }
    }

    public void r(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onLongClickListener) == null) {
            this.n = onLongClickListener;
        }
    }

    public void s(c.a.q0.i2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public final void t(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bdTypeListView) == null) && this.f19199j == null) {
            k kVar = new k(this.f19195f, PostData.v0);
            this.f19199j = kVar;
            kVar.T0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f19199j);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean m = this.f19196g.m();
            this.f19196g.p();
            if (!m) {
                this.f19196g.d().setOnClickListener(new e(this));
                this.f19196g.c().setOnClickListener(new f(this));
                this.f19196g.f().z(new g(this));
                this.f19196g.e().setOnScrollListener(this.t);
            }
            this.r = System.currentTimeMillis();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!l()) {
                this.f19195f.hideKeyboardAndEditor();
                this.f19194e = true;
                this.f19197h.h(false);
                this.f19197h.g(true);
                u();
                x();
                this.f19196g.q(new i(this));
                this.f19195f.addBackInterceptorAtFirst(this.v);
                this.p.H();
            }
            this.f19195f.getPbView().d1();
        }
    }

    public final void w(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.f19199j.t(eVar);
            c.a.q0.i2.k.e.g p0 = this.f19198i.p0();
            this.f19199j.setFromCDN(p0.V());
            this.f19199j.q(eVar.O().J().getUserId());
            this.f19199j.c(p0.W());
            this.f19199j.e(this.k);
            this.f19199j.m(this.l);
            this.f19199j.p(this.m);
            this.f19199j.d(this.n);
            this.f19199j.W0(this.o);
        }
    }

    public final void x() {
        List<n> D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (D = this.p.D()) == null) {
            return;
        }
        c.a.q0.i2.h.e O0 = this.p.E().O0();
        this.f19196g.p();
        this.f19196g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f19196g.e();
        this.f19197h.d();
        t(e2);
        w(O0);
        e2.setData(new ArrayList(D));
        this.f19196g.g().setCenterTextTitle(String.format(this.f19195f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(O0.T().f19131b.size())));
        this.f19196g.b(this.p.F());
        if (e2.getAdapter2() instanceof c.a.e.l.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
