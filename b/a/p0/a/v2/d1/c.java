package b.a.p0.a.v2.d1;

import b.a.p0.a.v2.q0;
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
    public final Queue<a> f8582a;

    /* renamed from: b  reason: collision with root package name */
    public a f8583b;

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
        this.f8582a = new ArrayDeque();
    }

    @Override // b.a.p0.a.v2.d1.b
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this.f8582a) {
                if (aVar == this.f8583b) {
                    e();
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f8582a) {
                if (this.f8583b != null) {
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
                if (this.f8583b != null) {
                    this.f8583b.a();
                    this.f8583b = null;
                }
                this.f8582a.clear();
            }
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar != null) {
                synchronized (this.f8582a) {
                    Queue<a> queue = this.f8582a;
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
            synchronized (this.f8582a) {
                this.f8583b = null;
                if (this.f8582a.isEmpty()) {
                    return;
                }
                a poll = this.f8582a.poll();
                this.f8583b = poll;
                if (poll == null) {
                    e();
                } else {
                    q0.X(poll);
                }
            }
        }
    }
}
