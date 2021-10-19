package c.p.a.e.b.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Object f35287a;

    /* renamed from: b  reason: collision with root package name */
    public Queue<b> f35288b;

    /* renamed from: c  reason: collision with root package name */
    public a f35289c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f35290d;

    /* loaded from: classes4.dex */
    public class a extends HandlerThread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f35291e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35291e = gVar;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onLooperPrepared();
                Looper looper = getLooper();
                synchronized (this.f35291e.f35287a) {
                    this.f35291e.f35290d = new Handler(looper);
                }
                while (!this.f35291e.f35288b.isEmpty()) {
                    b bVar = (b) this.f35291e.f35288b.poll();
                    this.f35291e.f35290d.postDelayed(bVar.f35292a, bVar.f35293b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Runnable f35292a;

        /* renamed from: b  reason: collision with root package name */
        public long f35293b;

        public b(g gVar, Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, runnable, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35292a = runnable;
            this.f35293b = j2;
        }
    }

    public g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35287a = new Object();
        this.f35288b = new ConcurrentLinkedQueue();
        this.f35289c = new a(this, str);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35289c.start();
        }
    }

    public void d(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            e(runnable, 0L);
        }
    }

    public void e(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, runnable, j2) == null) {
            if (this.f35290d == null) {
                synchronized (this.f35287a) {
                    if (this.f35290d == null) {
                        this.f35288b.add(new b(this, runnable, j2));
                        return;
                    }
                }
            }
            this.f35290d.postDelayed(runnable, j2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f35289c.quit();
        }
    }
}
