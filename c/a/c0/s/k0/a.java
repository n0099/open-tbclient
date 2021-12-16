package c.a.c0.s.k0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.c0.p;
import c.a.c0.s.f0.j;
import c.a.c0.s.f0.k;
import c.a.c0.s.f0.m;
import c.a.c0.s.v0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<j>> a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public k f2022b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public List<k> f2023c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public List<m> f2024d;

    public a() {
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
        this.a = new ConcurrentHashMap<>();
    }

    @Override // c.a.c0.s.k0.c
    @Deprecated
    public void a(@Nullable k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f2022b = kVar;
        }
    }

    @Override // c.a.c0.s.k0.c
    public void b(@NonNull m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
            j(mVar);
        }
    }

    @Override // c.a.c0.s.k0.c
    public void c(int i2, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, jVar) == null) {
            CopyOnWriteArrayList<j> copyOnWriteArrayList = this.a.get(Integer.valueOf(i2));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(jVar)) {
                int expectOrder = jVar.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(jVar);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, jVar);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), jVar);
                }
            }
            this.a.put(Integer.valueOf(i2), copyOnWriteArrayList);
        }
    }

    @Override // c.a.c0.s.k0.c
    public void d(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            String type = getType();
            h.i(type, System.identityHashCode(this) + " notifyEvent " + pVar);
            if (pVar.j() == 1) {
                if (i(pVar)) {
                    return;
                }
                g(pVar);
                pVar.o();
                return;
            }
            l(pVar);
        }
    }

    @Override // c.a.c0.s.k0.c
    public void e(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jVar) == null) {
            for (CopyOnWriteArrayList<j> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(jVar);
            }
        }
    }

    @Override // c.a.c0.s.k0.c
    public void f(@NonNull m mVar) {
        List<m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) || (list = this.f2024d) == null) {
            return;
        }
        list.remove(mVar);
    }

    public void g(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            k(pVar);
            h(pVar);
            CopyOnWriteArrayList<j> copyOnWriteArrayList = this.a.get(Integer.valueOf(pVar.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<j> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (!pVar.b(next)) {
                    switch (pVar.getType()) {
                        case -1:
                        case 6:
                            next.a(pVar);
                            continue;
                        case 1:
                            next.n(pVar);
                            continue;
                        case 2:
                            next.q(pVar);
                            continue;
                        case 3:
                            next.k(pVar);
                            continue;
                        case 4:
                            next.d(pVar);
                            continue;
                        case 5:
                            next.h((PlayerStatus) pVar.f(2), (PlayerStatus) pVar.f(1));
                            continue;
                        case 7:
                            if (next instanceof c.a.c0.s.o0.c) {
                                ((c.a.c0.s.o0.c) next).g(pVar);
                                break;
                            } else {
                                next.a(pVar);
                                continue;
                            }
                        case 8:
                            next.j(pVar);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(p pVar) {
        List<m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) || (list = this.f2024d) == null) {
            return;
        }
        for (m mVar : list) {
            mVar.a(pVar);
        }
    }

    public boolean i(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, pVar)) == null) {
            k kVar = this.f2022b;
            if (kVar != null && kVar.getInterceptorLayer() != pVar.k() && this.f2022b.e(pVar)) {
                h.b("AbsMessenger", "isNeedIntercept() = true, event = " + pVar);
                pVar.o();
                return true;
            }
            List<k> list = this.f2023c;
            if (list != null) {
                for (k kVar2 : list) {
                    if (kVar2.getInterceptorLayer() != pVar.k() && kVar2.e(pVar)) {
                        h.b("AbsMessenger", "isNeedIntercept() = true, event = " + pVar);
                        pVar.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mVar) == null) {
            if (this.f2024d == null) {
                this.f2024d = new ArrayList();
            }
            if (this.f2024d.contains(mVar)) {
                return;
            }
            int expectOrder = mVar.getExpectOrder();
            if (expectOrder == 0) {
                this.f2024d.add(mVar);
            } else if (expectOrder == 1) {
                this.f2024d.add(0, mVar);
            } else if (expectOrder != 2) {
            } else {
                List<m> list = this.f2024d;
                list.add(list.size(), mVar);
            }
        }
    }

    public final void k(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            if (pVar.i() == 0) {
                String type = getType();
                h.b(type, System.identityHashCode(this) + ": dispatch event :" + pVar);
                return;
            }
            String type2 = getType();
            h.i(type2, System.identityHashCode(this) + ": dispatch event :" + pVar);
        }
    }

    public abstract void l(@NonNull p pVar);

    @Override // c.a.c0.s.k0.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<m> list = this.f2024d;
            if (list != null) {
                list.clear();
                this.f2024d = null;
            }
            this.a.clear();
            this.f2022b = null;
            List<k> list2 = this.f2023c;
            if (list2 != null) {
                list2.clear();
                this.f2023c = null;
            }
        }
    }
}
