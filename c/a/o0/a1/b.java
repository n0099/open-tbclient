package c.a.o0.a1;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.o0.a1.e.c;
import c.a.o0.a1.e.d;
import c.a.o0.a1.e.e;
import c.a.o0.a1.g.h;
import c.a.o0.a1.i.g;
import c.a.o0.m.f;
import c.a.o0.m.g;
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
/* loaded from: classes2.dex */
public class b<Q extends c.a.o0.a1.e.c, P extends d> implements c.a.o0.a1.f.a<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public final View f9733b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.o0.a1.i.b f9734c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.o0.a1.g.b f9735d;

    /* renamed from: e  reason: collision with root package name */
    public final e<Q, P> f9736e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.o0.a1.f.d<Q, P> f9737f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.a1.f.b<P> f9738g;

    /* renamed from: h  reason: collision with root package name */
    public final View.OnClickListener f9739h;
    public final g i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.a1.h.a.b(" ----NetRefreshView----");
                this.a.n();
            }
        }
    }

    /* renamed from: c.a.o0.a1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0784b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0784b(b bVar) {
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

        @Override // c.a.o0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                c.a.o0.a1.h.a.b(" ----onActivityDestroyed---- ");
                this.a.i();
            }
        }

        @Override // c.a.o0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                c.a.o0.a1.h.a.b(" ----onActivityPaused---- ");
                this.a.j();
            }
        }

        @Override // c.a.o0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                c.a.o0.a1.h.a.b(" ----onActivityResumed---- ");
                this.a.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c<Q extends c.a.o0.a1.e.c, P extends d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup A;
        public TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public Q f9740b;

        /* renamed from: c  reason: collision with root package name */
        public P f9741c;

        /* renamed from: d  reason: collision with root package name */
        public int f9742d;

        /* renamed from: e  reason: collision with root package name */
        public int f9743e;

        /* renamed from: f  reason: collision with root package name */
        public String f9744f;

        /* renamed from: g  reason: collision with root package name */
        public h.d f9745g;

        /* renamed from: h  reason: collision with root package name */
        public h.b f9746h;
        public h.a i;
        public c.a.o0.a1.g.d j;
        public c.a.o0.a1.g.d k;
        public c.a.o0.a1.g.d l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public c.a.o0.a1.i.d q;
        public c.a.o0.a1.i.c r;
        public h.c s;
        public List<c.a.d.o.e.a> t;
        public List<c.a.d.o.e.a> u;
        public f<c.a.o0.r.r.a> v;
        public c.a.o0.a1.c.q.a w;
        public int x;
        public c.a.o0.a1.i.b y;
        public View z;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9740b == null || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
                return;
            }
            this.f9740b.a(this.a.getPageActivity().getIntent());
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

        public c c(c.a.o0.a1.i.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
                this.p = true;
                this.q = dVar;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c d(f<c.a.o0.r.r.a> fVar) {
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
                    c.a.o0.a1.i.g c2 = fVar.c(this.a);
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
                    c.a.o0.a1.i.g c3 = fVar2.c(this.a);
                    h(c3);
                    this.y = c3;
                } else if (this.p) {
                    g.f fVar3 = new g.f();
                    fVar3.b(this.s);
                    fVar3.a(this.t);
                    fVar3.g(this.v);
                    fVar3.e(this.x);
                    fVar3.h(this.w);
                    c.a.o0.a1.i.g c4 = fVar3.c(this.a);
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

        public final void h(c.a.o0.a1.i.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || ListUtils.isEmpty(this.u)) {
                return;
            }
            gVar.z(this.u);
        }

        public c i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.f9743e = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c j(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f9744f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c k(@NonNull Q q) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, q)) == null) {
                this.f9740b = q;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c l(@NonNull P p) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, p)) == null) {
                this.f9741c = p;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.f9742d = i;
                return this;
            }
            return (c) invokeI.objValue;
        }
    }

    public /* synthetic */ b(c cVar, a aVar) {
        this(cVar);
    }

    public void b(c.a.o0.a1.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f9737f.b(bVar);
        }
    }

    public Q c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9737f.f() : (Q) invokeV.objValue;
    }

    public P d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9737f.g() : (P) invokeV.objValue;
    }

    public LoadType e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.o0.a1.d.a c2 = c().c();
            return c2 != null ? c2.f9778b : LoadType.REFRESH;
        }
        return (LoadType) invokeV.objValue;
    }

    public boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f9737f.i(z) : invokeZ.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9737f.j() : invokeV.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            c.a.o0.a1.g.b bVar = this.f9735d;
            if (bVar != null) {
                bVar.onChangeSkinType(i);
            }
            c.a.o0.a1.i.b bVar2 = this.f9734c;
            if (bVar2 != null) {
                bVar2.onChangeSkinType(i);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.a1.g.b bVar = this.f9735d;
            if (bVar != null) {
                bVar.onDestroy();
            }
            c.a.o0.a1.f.d<Q, P> dVar = this.f9737f;
            if (dVar != null) {
                dVar.k();
            }
            c.a.o0.a1.i.b bVar2 = this.f9734c;
            if (bVar2 != null) {
                bVar2.e();
            }
            u();
        }
    }

    public void j() {
        c.a.o0.a1.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.f9734c) == null) {
            return;
        }
        bVar.f();
    }

    public void k() {
        c.a.o0.a1.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f9734c) == null) {
            return;
        }
        bVar.g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a1.f.a
    /* renamed from: l */
    public void onSuccess(P p) {
        c.a.o0.a1.d.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p) == null) {
            c.a.o0.a1.h.a.b(" ----onSuccess---- ");
            c.a.o0.a1.f.b<P> bVar = this.f9738g;
            if (bVar != null) {
                bVar.onSuccess(p);
            }
            c.a.o0.a1.i.b bVar2 = this.f9734c;
            if (bVar2 != null) {
                cVar = bVar2.a(p);
            } else {
                s();
                cVar = new c.a.o0.a1.d.c();
            }
            c.a.o0.a1.f.b<P> bVar3 = this.f9738g;
            if (bVar3 != null) {
                bVar3.a(cVar);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.o0.a1.i.b bVar = this.f9734c;
            if (bVar != null) {
                bVar.h();
                return;
            }
            r();
            f(true);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            c.a.o0.a1.f.d<Q, P> dVar = this.f9737f;
            if (dVar != null) {
                dVar.s(bdUniqueId);
            }
            c.a.o0.a1.i.b bVar = this.f9734c;
            if (bVar != null) {
                bVar.i(bdUniqueId);
            }
        }
    }

    @Override // c.a.o0.a1.f.a
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            c.a.o0.a1.h.a.b(" ----onError---- ");
            c.a.o0.a1.f.b<P> bVar = this.f9738g;
            if (bVar != null) {
                bVar.onError(i, str);
            }
            c.a.o0.a1.i.b bVar2 = this.f9734c;
            if (bVar2 != null) {
                bVar2.a(d());
            } else {
                q(str);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            c.a.o0.a1.h.a.b(" ----showEmpty---- ");
            this.f9735d.a(ViewType.EMPTY, str);
            t(ViewType.EMPTY);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            c.a.o0.a1.h.a.b(" ----showError---- ");
            this.f9735d.a(ViewType.ERROR, str);
            t(ViewType.ERROR);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.o0.a1.h.a.b(" ----showLoading---- ");
            t(ViewType.LOADING);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.o0.a1.h.a.b(" ----showContent---- ");
            t(ViewType.CONTENT);
        }
    }

    public final void t(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewType) == null) {
            this.f9735d.b(viewType);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9739h = new a(this);
        this.i = new C0784b(this);
        this.a = cVar.a;
        c.a.o0.a1.e.f fVar = new c.a.o0.a1.e.f(cVar.f9742d, cVar.f9743e, cVar.f9744f, cVar.f9740b, cVar.f9741c);
        this.f9736e = fVar;
        this.f9737f = new c.a.o0.a1.f.d<>(cVar.a, fVar, this);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getPageActivity());
        View view = cVar.z;
        this.f9733b = view;
        if (view != null) {
            view.setId(2184);
            this.f9733b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            relativeLayout.addView(this.f9733b);
        }
        c.a.o0.a1.i.b bVar = cVar.y;
        this.f9734c = bVar;
        if (bVar != null) {
            bVar.j(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 2184);
            this.f9734c.getView().setLayoutParams(layoutParams);
            this.f9734c.b(relativeLayout);
        }
        cVar.A.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        h.d dVar = cVar.f9745g;
        dVar = dVar == null ? new h.d() : dVar;
        h.b bVar2 = cVar.f9746h;
        bVar2 = bVar2 == null ? new h.b() : bVar2;
        h.a aVar = cVar.i;
        aVar = aVar == null ? new h.a() : aVar;
        View.OnClickListener onClickListener = this.f9739h;
        bVar2.f9825h = onClickListener;
        aVar.f9818h = onClickListener;
        h hVar = new h();
        hVar.f9810b = aVar;
        hVar.f9811c = bVar2;
        hVar.a = dVar;
        this.f9735d = new c.a.o0.a1.g.c(this.f9734c, relativeLayout, hVar);
        c.a.o0.a1.g.d dVar2 = cVar.j;
        dVar2 = dVar2 == null ? new c.a.o0.a1.g.g(this.a) : dVar2;
        c.a.o0.a1.g.d dVar3 = cVar.k;
        dVar3 = dVar3 == null ? new c.a.o0.a1.g.f(this.a) : dVar3;
        c.a.o0.a1.g.d dVar4 = cVar.l;
        dVar4 = dVar4 == null ? new c.a.o0.a1.g.e(this.a) : dVar4;
        this.f9735d.c(ViewType.LOADING, dVar2);
        this.f9735d.c(ViewType.ERROR, dVar3);
        this.f9735d.c(ViewType.EMPTY, dVar4);
        m();
    }
}
