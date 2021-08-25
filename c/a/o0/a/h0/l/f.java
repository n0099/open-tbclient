package c.a.o0.a.h0.l;

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
public class f implements V8ThreadDelegatePolicy, c.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f6053h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public V8Engine f6054b;

    /* renamed from: c  reason: collision with root package name */
    public Thread f6055c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f6056d;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f6057e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f6058f;

    /* renamed from: g  reason: collision with root package name */
    public int f6059g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6060e;

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
            this.f6060e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                this.f6060e.f6056d = new Handler();
                this.f6060e.f6054b.startEngineInternal();
                Looper.loop();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957935049, "Lc/a/o0/a/h0/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957935049, "Lc/a/o0/a/h0/l/f;");
                return;
            }
        }
        f6053h = c.a.o0.a.v2.d.a();
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
        this.f6054b = null;
        this.f6055c = null;
        this.f6056d = null;
        this.f6058f = null;
        this.f6059g = 0;
        this.f6057e = Looper.getMainLooper().getThread();
    }

    public final boolean c(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable != null && this.f6056d != null) {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                    this.f6056d.postAtFrontOfQueue(runnable);
                    return true;
                }
                if (this.f6057e == currentThread) {
                    if (f6053h) {
                        Runnable runnable2 = this.f6058f;
                        if (runnable2 == null) {
                            this.f6056d.postAtFrontOfQueue(runnable);
                        } else if (this.f6056d.hasCallbacks(runnable2)) {
                            this.f6056d.post(runnable);
                        } else {
                            this.f6056d.postAtFrontOfQueue(runnable);
                        }
                        this.f6058f = runnable;
                    } else {
                        boolean hasMessages = this.f6056d.hasMessages(this.f6059g);
                        this.f6059g++;
                        Message obtain = Message.obtain(this.f6056d, runnable);
                        obtain.what = this.f6059g;
                        if (hasMessages) {
                            this.f6056d.sendMessage(obtain);
                        } else {
                            this.f6056d.sendMessageAtFrontOfQueue(obtain);
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
            this.f6054b = v8Engine;
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || this.f6056d == null || c(runnable)) {
            return;
        }
        this.f6056d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) || this.f6056d == null || c(runnable)) {
            return;
        }
        this.f6056d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Handler handler = this.f6056d;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (handler = this.f6056d) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.f6056d.getLooper().quitSafely();
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, v8Engine) == null) && this.f6055c == null) {
            Thread thread = new Thread(new a(this));
            this.f6055c = thread;
            thread.setName(v8Engine.threadName());
            this.f6055c.setPriority(10);
            this.f6055c.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, runnable, j2) == null) || this.f6056d == null || c(runnable)) {
            return;
        }
        this.f6056d.postDelayed(runnable, j2);
    }
}
