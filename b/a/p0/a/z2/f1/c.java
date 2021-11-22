package b.a.p0.a.z2.f1;

import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f9789a;

    /* renamed from: b  reason: collision with root package name */
    public a f9790b;

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
        this.f9789a = new ArrayDeque();
    }

    @Override // b.a.p0.a.z2.f1.b
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this.f9789a) {
                if (aVar == this.f9790b) {
                    e();
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f9789a) {
                if (this.f9790b != null) {
                    return;
                }
                e();
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f9790b != null) {
                    this.f9790b.a();
                    this.f9790b = null;
                }
                this.f9789a.clear();
            }
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar != null) {
                synchronized (this.f9789a) {
                    Queue<a> queue = this.f9789a;
                    aVar.b(this);
                    queue.offer(aVar);
                }
            }
            b();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f9789a) {
                this.f9790b = null;
                if (this.f9789a.isEmpty()) {
                    return;
                }
                a poll = this.f9789a.poll();
                this.f9790b = poll;
                if (poll == null) {
                    e();
                } else {
                    q0.a0(poll);
                }
            }
        }
    }
}
