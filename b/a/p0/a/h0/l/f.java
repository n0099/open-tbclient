package b.a.p0.a.h0.l;

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
public class f implements V8ThreadDelegatePolicy, b.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f5431h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public V8Engine f5432b;

    /* renamed from: c  reason: collision with root package name */
    public Thread f5433c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f5434d;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f5435e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f5436f;

    /* renamed from: g  reason: collision with root package name */
    public int f5437g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5438e;

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
            this.f5438e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                this.f5438e.f5434d = new Handler();
                this.f5438e.f5432b.startEngineInternal();
                Looper.loop();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597551945, "Lb/a/p0/a/h0/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597551945, "Lb/a/p0/a/h0/l/f;");
                return;
            }
        }
        f5431h = b.a.p0.a.v2.d.a();
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
        this.f5432b = null;
        this.f5433c = null;
        this.f5434d = null;
        this.f5436f = null;
        this.f5437g = 0;
        this.f5435e = Looper.getMainLooper().getThread();
    }

    public final boolean c(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable != null && this.f5434d != null) {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                    this.f5434d.postAtFrontOfQueue(runnable);
                    return true;
                }
                if (this.f5435e == currentThread) {
                    if (f5431h) {
                        Runnable runnable2 = this.f5436f;
                        if (runnable2 == null) {
                            this.f5434d.postAtFrontOfQueue(runnable);
                        } else if (this.f5434d.hasCallbacks(runnable2)) {
                            this.f5434d.post(runnable);
                        } else {
                            this.f5434d.postAtFrontOfQueue(runnable);
                        }
                        this.f5436f = runnable;
                    } else {
                        boolean hasMessages = this.f5434d.hasMessages(this.f5437g);
                        this.f5437g++;
                        Message obtain = Message.obtain(this.f5434d, runnable);
                        obtain.what = this.f5437g;
                        if (hasMessages) {
                            this.f5434d.sendMessage(obtain);
                        } else {
                            this.f5434d.sendMessageAtFrontOfQueue(obtain);
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
            this.f5432b = v8Engine;
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || this.f5434d == null || c(runnable)) {
            return;
        }
        this.f5434d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) || this.f5434d == null || c(runnable)) {
            return;
        }
        this.f5434d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Handler handler = this.f5434d;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (handler = this.f5434d) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.f5434d.getLooper().quitSafely();
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, v8Engine) == null) && this.f5433c == null) {
            Thread thread = new Thread(new a(this));
            this.f5433c = thread;
            thread.setName(v8Engine.threadName());
            this.f5433c.setPriority(10);
            this.f5433c.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, runnable, j) == null) || this.f5434d == null || c(runnable)) {
            return;
        }
        this.f5434d.postDelayed(runnable, j);
    }
}
