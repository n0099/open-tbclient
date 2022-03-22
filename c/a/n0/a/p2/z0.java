package c.a.n0.a.p2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
public class z0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<Runnable> a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f5884b;

    public z0() {
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
        this.a = new ArrayDeque();
        this.f5884b = null;
    }

    public synchronized boolean a(Runnable runnable) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            synchronized (this) {
                z = true;
                boolean z2 = runnable == null;
                if (!z2) {
                    this.a.offer(runnable);
                }
                boolean z3 = this.f5884b == null && !this.a.isEmpty();
                if (z3) {
                    while (!this.a.isEmpty()) {
                        Runnable poll = this.a.poll();
                        this.f5884b = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f5884b = null;
                    }
                }
                z = (z2 || !z3) ? false : false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
