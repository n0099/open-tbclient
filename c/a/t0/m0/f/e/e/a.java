package c.a.t0.m0.f.e.e;

import c.a.t0.m0.f.c.d;
import c.a.t0.m0.f.d.b;
import c.a.t0.m0.g.e;
import c.a.t0.m0.h.c;
import c.b.a.a.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public int n;
    public C1191a o;
    public final CacheManager p;
    public c q;

    /* renamed from: c.a.t0.m0.f.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C1191a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public C1191a(a this$0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.a = -1;
            CollectionsKt__CollectionsKt.emptyList();
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.a = i2;
            }
        }

        public final void c(List<? extends Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(c.a.t0.m0.f.a context) {
        super(context, r3, null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.t0.m0.f.a) objArr2[0], (g) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends c.a.t0.m0.f.c.a>[] b2 = c.a.t0.m0.k.d.a.b();
        g b3 = g.d((Class[]) Arrays.copyOf(b2, b2.length)).b();
        Intrinsics.checkNotNullExpressionValue(b3, "all(*Families.layoutComponentTypes).get()");
        this.m = -1;
        this.n = -1;
        this.o = new C1191a(this);
        this.p = context.b();
        this.q = new c.a.t0.m0.h.d();
    }

    @Override // c.a.t0.m0.f.c.d, c.b.a.a.e
    public void a(c.b.a.a.d entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            c cVar = this.q;
            b b2 = c.a.t0.m0.g.d.b(entity);
            c.a.t0.m0.e.a a = b2 == null ? null : b2.a();
            if (a == null) {
                return;
            }
            cVar.b(a);
        }
    }

    @Override // c.a.t0.m0.f.c.d
    public void l(c.b.a.a.d entity, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f2) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    public final c.a.t0.m0.j.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.t0.m0.g.c.c(this) : (c.a.t0.m0.j.b) invokeV.objValue;
    }

    public final c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (c) invokeV.objValue;
    }

    public final void p(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.q = cVar;
        }
    }

    @Override // c.a.t0.m0.f.c.d, c.b.a.a.f
    public void update(float f2) {
        c.a.t0.m0.f.d.c cVar;
        DrawState drawState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            e.b("LayoutSystem_update");
            c.a.t0.m0.a c2 = i().c();
            boolean z = false;
            boolean z2 = (this.m == c2.r() && this.n == c2.o()) ? false : true;
            if (c.a.t0.m0.g.c.e(this) && !z2) {
                e.a();
                return;
            }
            if (this.m != c2.r()) {
                BdLog.v("DanmakuEngine [Layout] RetainerGeneration change, clear retainer.");
                this.q.c(0, (int) (n().getHeight() * c2.u()));
                this.q.clear();
                this.m = c2.r();
            }
            if (this.o.a() != c2.l()) {
                this.o.b(c2.l());
                this.o.c(CollectionsKt___CollectionsKt.toList(c2.n()));
            }
            long b2 = c.a.t0.m0.g.c.b(this);
            List<c.b.a.a.d> k2 = k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : k2) {
                c.a.t0.m0.f.d.a d2 = c.a.t0.m0.g.d.d((c.b.a.a.d) obj);
                if ((d2 == null || d2.d()) ? false : true) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            boolean z3 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b b3 = c.a.t0.m0.g.d.b((c.b.a.a.d) it.next());
                c.a.t0.m0.e.a a = b3 != null ? b3.a() : null;
                if (a != null && a.i() != ItemState.Measuring) {
                    boolean z4 = !a.f().r(c2.p());
                    if (a.i().compareTo(ItemState.Measuring) < 0 || z4) {
                        if (z4 && a.i().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v(Intrinsics.stringPlus("DanmakuEngine [Layout] re-measure ", a.e()));
                        }
                        a.o(ItemState.Measuring);
                        this.p.o(a, n(), c2);
                        z3 = true;
                    }
                }
            }
            ArrayList<c.b.a.a.d> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                b b4 = c.a.t0.m0.g.d.b((c.b.a.a.d) obj2);
                c.a.t0.m0.e.a a2 = b4 == null ? null : b4.a();
                if (a2 != null && a2.i().compareTo(ItemState.Measured) >= 0) {
                    arrayList2.add(obj2);
                }
            }
            boolean z5 = z3;
            for (c.b.a.a.d dVar : arrayList2) {
                b b5 = c.a.t0.m0.g.d.b(dVar);
                c.a.t0.m0.e.a a3 = b5 == null ? null : b5.a();
                if (a3 != null) {
                    DrawState f3 = a3.f();
                    c.a.t0.m0.f.d.c e2 = c.a.t0.m0.g.d.e(dVar);
                    if (e2 != null || (e2 = (c.a.t0.m0.f.d.c) c.a.t0.m0.g.c.a(this, c.a.t0.m0.f.d.c.class, dVar, a3)) != null) {
                        c.a.t0.m0.f.d.c cVar2 = e2;
                        if (f3.e() != c2.o()) {
                            f3.H(z);
                            cVar = cVar2;
                            drawState = f3;
                            cVar.e(o().d(a3, b2, n(), c2));
                        } else {
                            cVar = cVar2;
                            drawState = f3;
                        }
                        if (cVar.d()) {
                            synchronized (a3.i()) {
                                if (a3.i().compareTo(ItemState.Rendering) < 0) {
                                    a3.o(ItemState.Rendering);
                                    this.p.m(a3, n(), c2);
                                    z5 = true;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            o().a(a3, b2, n(), c2);
                            drawState.y(c2.o());
                        }
                        cVar.c().set(drawState.g(), drawState.h());
                        z = false;
                    }
                }
            }
            if (c.a.t0.m0.g.c.e(this)) {
                if (z5) {
                    this.p.n();
                } else {
                    c2.H();
                    this.n = c2.o();
                }
            }
            e.a();
        }
    }
}
