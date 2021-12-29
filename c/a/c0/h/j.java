package c.a.c0.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class j extends Handler implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentLinkedQueue<b<?>> f2085e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2086f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final j a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(863471415, "Lc/a/c0/h/j$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(863471415, "Lc/a/c0/h/j$a;");
                    return;
                }
            }
            a = new j();
        }
    }

    /* loaded from: classes.dex */
    public static class b<T extends f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final i<T> a;

        /* renamed from: b  reason: collision with root package name */
        public final T f2087b;

        public b(k kVar, i<T> iVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, iVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
            this.f2087b = t;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j() {
        super(Looper.getMainLooper());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2085e = new ConcurrentLinkedQueue<>();
        this.f2086f = false;
    }

    public static h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (h) invokeV.objValue;
    }

    @Override // c.a.c0.h.h
    public <T extends f> void a(k kVar, i<T> iVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, kVar, iVar, t) == null) {
            if (c.a.c0.e.g.a()) {
                iVar.onEvent(t);
                return;
            }
            synchronized (this) {
                this.f2085e.offer(new b<>(kVar, iVar, t));
                if (!this.f2086f) {
                    sendMessage(Message.obtain());
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                do {
                    b<?> poll = this.f2085e.poll();
                    if (poll == null) {
                        synchronized (this) {
                            poll = this.f2085e.poll();
                            if (poll == null) {
                                this.f2086f = false;
                                return;
                            }
                        }
                    }
                    poll.a.onEvent(poll.f2087b);
                } while (System.currentTimeMillis() - currentTimeMillis < 5);
                sendMessage(Message.obtain());
                this.f2086f = true;
            } finally {
                this.f2086f = false;
            }
        }
    }
}
