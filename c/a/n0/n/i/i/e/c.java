package c.a.n0.n.i.i.e;

import c.a.n0.n.i.i.g.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends a<f> implements c.a.n0.n.i.i.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile f f11643b;

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
            }
        }
    }

    @Override // c.a.n0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f11643b = fVar;
        }
    }

    @Override // c.a.n0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            if (this.f11643b == fVar) {
                this.f11643b = null;
                if (c.a.n0.n.c.f11582a) {
                    String str = "notifyTaskEnd mCurrentTask == null:" + fVar;
                }
            }
            k(fVar);
        }
    }

    public synchronized f g() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                fVar = (f) super.c();
                if (c.a.n0.n.c.f11582a) {
                    String str = "deQueue first task:" + fVar;
                }
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    public synchronized void h(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            synchronized (this) {
                if (fVar == null) {
                    return;
                }
                if (this.f11643b != null && this.f11643b.d(fVar)) {
                    fVar.e().f(fVar.f());
                    if (c.a.n0.n.c.f11582a) {
                        String str = "enQueue: 要入队的任务和当前正在运行的任务相同->" + fVar;
                    }
                    return;
                }
                f e2 = e(fVar);
                if (e2 != null) {
                    fVar.e().f(fVar.f());
                    if (c.a.n0.n.c.f11582a) {
                        String str2 = "enQueue: 队列中已经有相同的任务在排队等待处理->" + fVar;
                    }
                    if (fVar.g() <= e2.g()) {
                        return;
                    }
                }
                int g2 = fVar.g();
                if (c.a.n0.n.c.f11582a) {
                    String str3 = "[enQueue] priorityOption:" + g2;
                }
                if (g2 == 200) {
                    if (e2 != null) {
                        this.f11632a.remove(e2);
                        this.f11632a.add(0, e2);
                        boolean z = c.a.n0.n.c.f11582a;
                    } else {
                        this.f11632a.add(0, fVar);
                    }
                    if (c.a.n0.n.c.f11582a) {
                        String str4 = "[enQueue] a new task added to queue head. size:" + this.f11632a.size();
                        String str5 = "[enQueue] task info:" + fVar;
                    }
                } else if (g2 == 300) {
                    j(fVar);
                    if (e2 != null) {
                        this.f11632a.remove(e2);
                        this.f11632a.add(0, e2);
                        boolean z2 = c.a.n0.n.c.f11582a;
                    } else {
                        this.f11632a.add(0, fVar);
                    }
                    if (c.a.n0.n.c.f11582a) {
                        String str6 = "[enQueue] a new task added to queue head. size:" + this.f11632a.size();
                        String str7 = "[enQueue] task info:" + fVar;
                    }
                } else if (e2 == null) {
                    this.f11632a.add(fVar);
                    if (c.a.n0.n.c.f11582a) {
                        String str8 = "[enQueue] append new task to queue tail. size:" + this.f11632a.size();
                        String str9 = "[enQueue] task info:" + fVar;
                    }
                }
                notifyAll();
            }
        }
    }

    public synchronized f i() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                fVar = (f) super.d();
                if (c.a.n0.n.c.f11582a) {
                    String str = "get first task:" + fVar;
                }
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    public final void j(f fVar) {
        f fVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) && fVar.g() == 300 && (fVar2 = this.f11643b) != null) {
            if (fVar2.g() == 300) {
                if (c.a.n0.n.c.f11582a) {
                    String str = "Hi-priority task is working, can't stop:" + fVar2;
                    return;
                }
                return;
            }
            fVar2.n();
            for (int i2 = 0; i2 < 500 && this.f11643b != null; i2++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void k(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) && fVar.j()) {
            if (c.a.n0.n.c.f11582a) {
                String str = "processPendingTask:" + fVar;
            }
            fVar.q(true);
            this.f11632a.add(0, fVar);
            if (c.a.n0.n.c.f11582a) {
                String str2 = "PendingTask added-to-Queue-head:" + fVar;
            }
        }
    }
}
