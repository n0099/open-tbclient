package c.a.o0.a.v2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
public class y0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f9415a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f9416b;

    public y0() {
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
        this.f9415a = new ArrayDeque();
        this.f9416b = null;
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
                    this.f9415a.offer(runnable);
                }
                boolean z3 = this.f9416b == null && !this.f9415a.isEmpty();
                if (z3) {
                    while (!this.f9415a.isEmpty()) {
                        Runnable poll = this.f9415a.poll();
                        this.f9416b = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f9416b = null;
                    }
                }
                z = (z2 || !z3) ? false : false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
