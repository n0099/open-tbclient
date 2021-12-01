package c.a.p0.a.h0.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f implements V8ThreadDelegatePolicy, c.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f5660i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public V8Engine f5661c;

    /* renamed from: d  reason: collision with root package name */
    public Thread f5662d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5663e;

    /* renamed from: f  reason: collision with root package name */
    public final Thread f5664f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f5665g;

    /* renamed from: h  reason: collision with root package name */
    public int f5666h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5667e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5667e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                this.f5667e.f5663e = new Handler();
                this.f5667e.f5661c.startEngineInternal();
                Looper.loop();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087017768, "Lc/a/p0/a/h0/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087017768, "Lc/a/p0/a/h0/l/f;");
                return;
            }
        }
        f5660i = c.a.p0.a.z2.d.a();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5661c = null;
        this.f5662d = null;
        this.f5663e = null;
        this.f5665g = null;
        this.f5666h = 0;
        this.f5664f = Looper.getMainLooper().getThread();
    }

    public final boolean c(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable != null && this.f5663e != null) {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                    this.f5663e.postAtFrontOfQueue(runnable);
                    return true;
                }
                if (this.f5664f == currentThread) {
                    if (f5660i) {
                        Runnable runnable2 = this.f5665g;
                        if (runnable2 == null) {
                            this.f5663e.postAtFrontOfQueue(runnable);
                        } else if (this.f5663e.hasCallbacks(runnable2)) {
                            this.f5663e.post(runnable);
                        } else {
                            this.f5663e.postAtFrontOfQueue(runnable);
                        }
                        this.f5665g = runnable;
                    } else {
                        boolean hasMessages = this.f5663e.hasMessages(this.f5666h);
                        this.f5666h++;
                        Message obtain = Message.obtain(this.f5663e, runnable);
                        obtain.what = this.f5666h;
                        if (hasMessages) {
                            this.f5663e.sendMessage(obtain);
                        } else {
                            this.f5663e.sendMessageAtFrontOfQueue(obtain);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Engine) == null) {
            this.f5661c = v8Engine;
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || this.f5663e == null || c(runnable)) {
            return;
        }
        this.f5663e.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) || this.f5663e == null || c(runnable)) {
            return;
        }
        this.f5663e.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Handler handler = this.f5663e;
            if (handler != null) {
                return handler.getLooper().getThread();
            }
            return null;
        }
        return (Thread) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (handler = this.f5663e) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.f5663e.getLooper().quitSafely();
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, v8Engine) == null) && this.f5662d == null) {
            Thread thread = new Thread(new a(this));
            this.f5662d = thread;
            thread.setName(v8Engine.threadName());
            this.f5662d.setPriority(10);
            this.f5662d.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, runnable, j2) == null) || this.f5663e == null || c(runnable)) {
            return;
        }
        this.f5663e.postDelayed(runnable, j2);
    }
}
