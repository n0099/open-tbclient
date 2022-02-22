package c.a.t0.b1;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.t0.b1.e.c;
import c.a.t0.b1.e.d;
import c.a.t0.b1.e.e;
import c.a.t0.b1.g.h;
import c.a.t0.b1.i.g;
import c.a.t0.n.f;
import c.a.t0.n.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class b<Q extends c.a.t0.b1.e.c, P extends d> implements c.a.t0.b1.f.a<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public final View f12516b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.t0.b1.i.b f12517c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.t0.b1.g.b f12518d;

    /* renamed from: e  reason: collision with root package name */
    public final e<Q, P> f12519e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.t0.b1.f.d<Q, P> f12520f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.b1.f.b<P> f12521g;

    /* renamed from: h  reason: collision with root package name */
    public final View.OnClickListener f12522h;

    /* renamed from: i  reason: collision with root package name */
    public final g f12523i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12524e;

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
            this.f12524e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.b1.h.a.b(" ----NetRefreshView----");
                this.f12524e.n();
            }
        }
    }

    /* renamed from: c.a.t0.b1.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0845b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12525e;

        public C0845b(b bVar) {
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
            this.f12525e = bVar;
        }

        @Override // c.a.t0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (tbPageContext = this.f12525e.a) != null && tbPageContext.getPageActivity() == activity) {
                c.a.t0.b1.h.a.b(" ----onActivityDestroyed---- ");
                this.f12525e.i();
            }
        }

        @Override // c.a.t0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && (tbPageContext = this.f12525e.a) != null && tbPageContext.getPageActivity() == activity) {
                c.a.t0.b1.h.a.b(" ----onActivityPaused---- ");
                this.f12525e.j();
            }
        }

        @Override // c.a.t0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (tbPageContext = this.f12525e.a) != null && tbPageContext.getPageActivity() == activity) {
                c.a.t0.b1.h.a.b(" ----onActivityResumed---- ");
                this.f12525e.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c<Q extends c.a.t0.b1.e.c, P extends d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup A;
        public TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public Q f12526b;

        /* renamed from: c  reason: collision with root package name */
        public P f12527c;

        /* renamed from: d  reason: collision with root package name */
        public int f12528d;

        /* renamed from: e  reason: collision with root package name */
        public int f12529e;

        /* renamed from: f  reason: collision with root package name */
        public String f12530f;

        /* renamed from: g  reason: collision with root package name */
        public h.d f12531g;

        /* renamed from: h  reason: collision with root package name */
        public h.b f12532h;

        /* renamed from: i  reason: collision with root package name */
        public h.a f12533i;

        /* renamed from: j  reason: collision with root package name */
        public c.a.t0.b1.g.d f12534j;
        public c.a.t0.b1.g.d k;
        public c.a.t0.b1.g.d l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public c.a.t0.b1.i.d q;
        public c.a.t0.b1.i.c r;
        public h.c s;
        public List<c.a.d.o.e.a> t;
        public List<c.a.d.o.e.a> u;
        public f<c.a.t0.s.r.a> v;
        public c.a.t0.b1.c.q.a w;
        public int x;
        public c.a.t0.b1.i.b y;
        public View z;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.p = false;
        }

        public final void a() {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12526b == null || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
                return;
            }
            this.f12526b.a(this.a.getPageActivity().getIntent());
        }

        public c b(List<c.a.d.o.e.a> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                this.p = true;
                this.t = list;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c c(c.a.t0.b1.i.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
                this.p = true;
                this.q = dVar;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c d(f<c.a.t0.s.r.a> fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                this.p = true;
                this.v = fVar;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public b e(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
                this.A = viewGroup;
                this.a = (TbPageContext) j.a(viewGroup.getContext());
                a();
                g();
                f();
                return new b(this, null);
            }
            return (b) invokeL.objValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.p && this.q != null && this.r != null) {
                    g.f fVar = new g.f();
                    fVar.i(this.q);
                    fVar.f(this.r);
                    fVar.b(this.s);
                    fVar.a(this.t);
                    fVar.g(this.v);
                    fVar.e(this.x);
                    fVar.h(this.w);
                    c.a.t0.b1.i.g c2 = fVar.c(this.a);
                    h(c2);
                    this.y = c2;
                } else if (this.p && this.q != null) {
                    g.f fVar2 = new g.f();
                    fVar2.i(this.q);
                    fVar2.b(this.s);
                    fVar2.a(this.t);
                    fVar2.g(this.v);
                    fVar2.e(this.x);
                    fVar2.h(this.w);
                    c.a.t0.b1.i.g c3 = fVar2.c(this.a);
                    h(c3);
                    this.y = c3;
                } else if (this.p) {
                    g.f fVar3 = new g.f();
                    fVar3.b(this.s);
                    fVar3.a(this.t);
                    fVar3.g(this.v);
                    fVar3.e(this.x);
                    fVar3.h(this.w);
                    c.a.t0.b1.i.g c4 = fVar3.c(this.a);
                    h(c4);
                    this.y = c4;
                }
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.o) {
                NavigationBar navigationBar = new NavigationBar(this.a.getPageActivity());
                if (this.n) {
                    navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                }
                navigationBar.setCenterTextTitle(this.m);
                this.z = navigationBar;
            }
        }

        public final void h(c.a.t0.b1.i.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || ListUtils.isEmpty(this.u)) {
                return;
            }
            gVar.y(this.u);
        }

        public c i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f12529e = i2;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c j(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f12530f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c k(@NonNull Q q) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, q)) == null) {
                this.f12526b = q;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c l(@NonNull P p) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, p)) == null) {
                this.f12527c = p;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                this.f12528d = i2;
                return this;
            }
            return (c) invokeI.objValue;
        }
    }

    public /* synthetic */ b(c cVar, a aVar) {
        this(cVar);
    }

    public void b(c.a.t0.b1.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f12520f.b(bVar);
        }
    }

    public Q c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12520f.f() : (Q) invokeV.objValue;
    }

    public P d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12520f.g() : (P) invokeV.objValue;
    }

    public LoadType e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.t0.b1.d.a c2 = c().c();
            return c2 != null ? c2.f12582b : LoadType.REFRESH;
        }
        return (LoadType) invokeV.objValue;
    }

    public boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f12520f.i(z) : invokeZ.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12520f.j() : invokeV.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            c.a.t0.b1.g.b bVar = this.f12518d;
            if (bVar != null) {
                bVar.onChangeSkinType(i2);
            }
            c.a.t0.b1.i.b bVar2 = this.f12517c;
            if (bVar2 != null) {
                bVar2.onChangeSkinType(i2);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.t0.b1.g.b bVar = this.f12518d;
            if (bVar != null) {
                bVar.onDestroy();
            }
            c.a.t0.b1.f.d<Q, P> dVar = this.f12520f;
            if (dVar != null) {
                dVar.k();
            }
            c.a.t0.b1.i.b bVar2 = this.f12517c;
            if (bVar2 != null) {
                bVar2.d();
            }
            u();
        }
    }

    public void j() {
        c.a.t0.b1.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.f12517c) == null) {
            return;
        }
        bVar.e();
    }

    public void k() {
        c.a.t0.b1.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f12517c) == null) {
            return;
        }
        bVar.f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.b1.f.a
    /* renamed from: l */
    public void onSuccess(P p) {
        c.a.t0.b1.d.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p) == null) {
            c.a.t0.b1.h.a.b(" ----onSuccess---- ");
            c.a.t0.b1.f.b<P> bVar = this.f12521g;
            if (bVar != null) {
                bVar.onSuccess(p);
            }
            c.a.t0.b1.i.b bVar2 = this.f12517c;
            if (bVar2 != null) {
                cVar = bVar2.onBindDataToView(p);
            } else {
                s();
                cVar = new c.a.t0.b1.d.c();
            }
            c.a.t0.b1.f.b<P> bVar3 = this.f12521g;
            if (bVar3 != null) {
                bVar3.a(cVar);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f12523i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.t0.b1.i.b bVar = this.f12517c;
            if (bVar != null) {
                bVar.g();
                return;
            }
            r();
            f(true);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            c.a.t0.b1.f.d<Q, P> dVar = this.f12520f;
            if (dVar != null) {
                dVar.s(bdUniqueId);
            }
            c.a.t0.b1.i.b bVar = this.f12517c;
            if (bVar != null) {
                bVar.h(bdUniqueId);
            }
        }
    }

    @Override // c.a.t0.b1.f.a
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            c.a.t0.b1.h.a.b(" ----onError---- ");
            c.a.t0.b1.f.b<P> bVar = this.f12521g;
            if (bVar != null) {
                bVar.onError(i2, str);
            }
            c.a.t0.b1.i.b bVar2 = this.f12517c;
            if (bVar2 != null) {
                bVar2.onBindDataToView(d());
            } else {
                q(str);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            c.a.t0.b1.h.a.b(" ----showEmpty---- ");
            this.f12518d.a(ViewType.EMPTY, str);
            t(ViewType.EMPTY);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            c.a.t0.b1.h.a.b(" ----showError---- ");
            this.f12518d.a(ViewType.ERROR, str);
            t(ViewType.ERROR);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.t0.b1.h.a.b(" ----showLoading---- ");
            t(ViewType.LOADING);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.t0.b1.h.a.b(" ----showContent---- ");
            t(ViewType.CONTENT);
        }
    }

    public final void t(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewType) == null) {
            this.f12518d.b(viewType);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.f12523i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(c<Q, P> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12522h = new a(this);
        this.f12523i = new C0845b(this);
        this.a = cVar.a;
        c.a.t0.b1.e.f fVar = new c.a.t0.b1.e.f(cVar.f12528d, cVar.f12529e, cVar.f12530f, cVar.f12526b, cVar.f12527c);
        this.f12519e = fVar;
        this.f12520f = new c.a.t0.b1.f.d<>(cVar.a, fVar, this);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getPageActivity());
        View view = cVar.z;
        this.f12516b = view;
        if (view != null) {
            view.setId(2184);
            this.f12516b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            relativeLayout.addView(this.f12516b);
        }
        c.a.t0.b1.i.b bVar = cVar.y;
        this.f12517c = bVar;
        if (bVar != null) {
            bVar.i(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 2184);
            this.f12517c.getView().setLayoutParams(layoutParams);
            this.f12517c.a(relativeLayout);
        }
        cVar.A.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        h.d dVar = cVar.f12531g;
        dVar = dVar == null ? new h.d() : dVar;
        h.b bVar2 = cVar.f12532h;
        bVar2 = bVar2 == null ? new h.b() : bVar2;
        h.a aVar = cVar.f12533i;
        aVar = aVar == null ? new h.a() : aVar;
        View.OnClickListener onClickListener = this.f12522h;
        bVar2.f12631h = onClickListener;
        aVar.f12624h = onClickListener;
        h hVar = new h();
        hVar.f12616b = aVar;
        hVar.f12617c = bVar2;
        hVar.a = dVar;
        this.f12518d = new c.a.t0.b1.g.c(this.f12517c, relativeLayout, hVar);
        c.a.t0.b1.g.d dVar2 = cVar.f12534j;
        dVar2 = dVar2 == null ? new c.a.t0.b1.g.g(this.a) : dVar2;
        c.a.t0.b1.g.d dVar3 = cVar.k;
        dVar3 = dVar3 == null ? new c.a.t0.b1.g.f(this.a) : dVar3;
        c.a.t0.b1.g.d dVar4 = cVar.l;
        dVar4 = dVar4 == null ? new c.a.t0.b1.g.e(this.a) : dVar4;
        this.f12518d.c(ViewType.LOADING, dVar2);
        this.f12518d.c(ViewType.ERROR, dVar3);
        this.f12518d.c(ViewType.EMPTY, dVar4);
        m();
    }
}
