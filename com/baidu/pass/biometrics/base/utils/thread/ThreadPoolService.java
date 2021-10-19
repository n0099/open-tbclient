package com.baidu.pass.biometrics.base.utils.thread;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class ThreadPoolService {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f44023c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f44024d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f44025e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f44026f = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f44027a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f44028b;

    /* loaded from: classes5.dex */
    public static class SingletonContainer {
        public static /* synthetic */ Interceptable $ic;
        public static ThreadPoolService mSingleInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1423240861, "Lcom/baidu/pass/biometrics/base/utils/thread/ThreadPoolService$SingletonContainer;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1423240861, "Lcom/baidu/pass/biometrics/base/utils/thread/ThreadPoolService$SingletonContainer;");
                    return;
                }
            }
            mSingleInstance = new ThreadPoolService();
        }

        public SingletonContainer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-554288743, "Lcom/baidu/pass/biometrics/base/utils/thread/ThreadPoolService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-554288743, "Lcom/baidu/pass/biometrics/base/utils/thread/ThreadPoolService;");
                return;
            }
        }
        f44023c = Runtime.getRuntime().availableProcessors();
        f44024d = new ThreadFactory() { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final AtomicInteger f44029a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44029a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "pass_face_thread # " + this.f44029a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
    }

    public static ThreadPoolService getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? SingletonContainer.mSingleInstance : (ThreadPoolService) invokeV.objValue;
    }

    public void run(TPRunnable tPRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tPRunnable) == null) {
            this.f44027a.submit(tPRunnable);
        }
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tPRunnable) == null) {
            this.f44028b.sendMessage(this.f44028b.obtainMessage(0, tPRunnable));
        }
    }

    public ThreadPoolService() {
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
        this.f44028b = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ThreadPoolService f44030a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f44030a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 == 0) {
                        ((TPRunnable) message.obj).run();
                    } else if (i4 != 1) {
                    } else {
                        this.f44030a.f44027a.submit(((TPRunnable) message.obj).runable);
                    }
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(f44023c - 1, 4)), Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f44024d);
        this.f44027a = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }
}
