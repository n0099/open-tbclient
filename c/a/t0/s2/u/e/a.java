package c.a.t0.s2.u.e;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.t0.s2.u.f.d0;
import c.a.t0.s2.u.f.l;
import c.a.t0.s2.u.f.t0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
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
/* loaded from: classes8.dex */
public class a implements c.a.s0.q0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23219e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f23220f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.s2.u.e.d f23221g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.s2.u.e.c f23222h;

    /* renamed from: i  reason: collision with root package name */
    public t0 f23223i;

    /* renamed from: j  reason: collision with root package name */
    public l f23224j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f23225k;
    public View.OnClickListener l;
    public TbRichTextView.y m;
    public View.OnLongClickListener n;
    public c.a.t0.s2.s.c o;
    public final MoreGodReplyModel p;
    public c.a.s0.q0.d q;
    public long r;
    public BdListView.p s;
    public AbsListView.OnScrollListener t;
    public d0.b u;
    public PbFragment.b3 v;

    /* renamed from: c.a.t0.s2.u.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1378a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23226e;

        public C1378a(a aVar) {
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
            this.f23226e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23226e.p.G()) {
                return;
            }
            this.f23226e.p.H();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f23227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23228f;

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
            this.f23228f = aVar;
            this.f23227e = -1;
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
                if (!a(this.f23227e) && a(i2) && (pbFragment = this.f23228f.f23220f) != null && pbFragment.getPbView() != null) {
                    this.f23228f.f23220f.getPbView().o2();
                    this.f23228f.f23220f.getPbView().c1();
                }
                this.f23227e = i2;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.s2.u.f.d0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.f23223i.A3(str);
        }

        @Override // c.a.t0.s2.u.f.d0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f23229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23230f;

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
            this.f23230f = aVar;
            this.f23229e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23230f.f23221g.i();
                this.f23230f.f23219e = false;
                PbFragment pbFragment = this.f23230f.f23220f;
                if (pbFragment != null) {
                    if (pbFragment.getPbView() != null) {
                        this.f23230f.f23220f.getPbView().c3(false);
                        c.a.t0.s2.u.f.h n0 = this.f23230f.f23220f.getPbView().n0();
                        n0.e0(this.f23230f.f23220f.getPbModel().R0(), true);
                        n0.X();
                    }
                    a aVar = this.f23230f;
                    aVar.f23220f.removeBackInterceptor(aVar.v);
                }
                Runnable runnable = this.f23229e;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23231e;

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
            this.f23231e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23231e.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23232e;

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
            this.f23232e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23232e.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23233e;

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
            this.f23233e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23233e.p.G()) {
                return;
            }
            this.f23233e.p.H();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements PbFragment.b3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.h();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23234e;

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
            this.f23234e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23234e.f23222h.g(false);
            }
        }
    }

    public a(PbFragment pbFragment, t0 t0Var, ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, t0Var, viewStub};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new C1378a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new h(this);
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.getPbModel());
        this.p = moreGodReplyModel;
        moreGodReplyModel.I(this.u);
        this.f23223i = t0Var;
        this.f23220f = pbFragment;
        this.f23221g = new c.a.t0.s2.u.e.d(pbFragment, viewStub);
        this.f23222h = new c.a.t0.s2.u.e.c(this);
    }

    @Override // c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a053" : (String) invokeV.objValue;
    }

    @Override // c.a.s0.q0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbFragment pbFragment = this.f23220f;
            if (pbFragment == null) {
                return null;
            }
            return pbFragment.getNextPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.s0.q0.a
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

    @Override // c.a.s0.q0.a
    public c.a.s0.q0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (c.a.s0.q0.b) invokeV.objValue;
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
            this.f23220f.hideKeyboardAndEditor();
            if (!l() && runnable != null) {
                runnable.run();
                return;
            }
            if (l() && !this.f23222h.e()) {
                this.f23221g.r(new d(this, runnable));
            }
            if (this.r != 0) {
                c.a.s0.q0.d j2 = j();
                j2.y(System.currentTimeMillis() - this.r);
                c.a.s0.q0.e.b().k(this.f23220f.getContext(), j2, getPageStayFilter());
            }
        }
    }

    public c.a.s0.q0.d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.q == null) {
                c.a.s0.q0.d dVar = new c.a.s0.q0.d();
                this.q = dVar;
                dVar.x(getCurrentPageSourceKeyList());
                this.q.s(getCurrentPageKey());
                PbModel pbModel = this.f23220f.getPbModel();
                if (pbModel != null) {
                    this.q.t(c.a.d.f.m.b.g(pbModel.getForumId(), 0L));
                    this.q.C(c.a.d.f.m.b.g(pbModel.h1(), 0L));
                }
            }
            return this.q;
        }
        return (c.a.s0.q0.d) invokeV.objValue;
    }

    public c.a.t0.s2.u.e.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23221g : (c.a.t0.s2.u.e.d) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23219e : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f23221g.o(i2);
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
            this.f23225k = onClickListener;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void q(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, yVar) == null) {
            this.m = yVar;
        }
    }

    public void r(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onLongClickListener) == null) {
            this.n = onLongClickListener;
        }
    }

    public void s(c.a.t0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public final void t(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bdTypeListView) == null) && this.f23224j == null) {
            l lVar = new l(this.f23220f, PostData.A0);
            this.f23224j = lVar;
            lVar.M0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f23224j);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean m = this.f23221g.m();
            this.f23221g.p();
            if (!m) {
                this.f23221g.d().setOnClickListener(new e(this));
                this.f23221g.c().setOnClickListener(new f(this));
                this.f23221g.f().C(new g(this));
                this.f23221g.e().setOnScrollListener(this.t);
            }
            this.r = System.currentTimeMillis();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!l()) {
                this.f23220f.hideKeyboardAndEditor();
                this.f23219e = true;
                this.f23222h.h(false);
                this.f23222h.g(true);
                u();
                x();
                this.f23221g.q(new i(this));
                this.f23220f.addBackInterceptorAtFirst(this.v);
                this.p.H();
            }
            this.f23220f.getPbView().c1();
        }
    }

    public final void w(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.f23224j.t(fVar);
            c.a.t0.s2.u.f.h n0 = this.f23223i.n0();
            this.f23224j.setFromCDN(n0.V());
            this.f23224j.q(fVar.O().J().getUserId());
            this.f23224j.c(n0.W());
            this.f23224j.e(this.f23225k);
            this.f23224j.m(this.l);
            this.f23224j.p(this.m);
            this.f23224j.d(this.n);
            this.f23224j.P0(this.o);
        }
    }

    public final void x() {
        List<n> D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (D = this.p.D()) == null) {
            return;
        }
        c.a.t0.s2.r.f R0 = this.p.E().R0();
        this.f23221g.p();
        this.f23221g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f23221g.e();
        this.f23222h.d();
        t(e2);
        w(R0);
        e2.setData(new ArrayList(D));
        this.f23221g.g().setCenterTextTitle(String.format(this.f23220f.getResources().getString(c.a.t0.s2.l.more_god_reply_count), StringHelper.numFormatOver10000(R0.T().f23100b.size())));
        this.f23221g.b(this.p.F());
        if (e2.getAdapter2() instanceof c.a.d.n.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
