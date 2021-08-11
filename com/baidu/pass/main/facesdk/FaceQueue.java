package com.baidu.pass.main.facesdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class FaceQueue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int nThreads;
    public LinkedList queue;
    public PoolWorker[] threads;

    /* renamed from: com.baidu.pass.main.facesdk.FaceQueue$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class HolderClass {
        public static /* synthetic */ Interceptable $ic;
        public static final FaceQueue instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1280649353, "Lcom/baidu/pass/main/facesdk/FaceQueue$HolderClass;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1280649353, "Lcom/baidu/pass/main/facesdk/FaceQueue$HolderClass;");
                    return;
                }
            }
            instance = new FaceQueue(1);
        }

        public HolderClass() {
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

    /* loaded from: classes5.dex */
    public class PoolWorker extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceQueue this$0;

        public PoolWorker(FaceQueue faceQueue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceQueue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceQueue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                synchronized (this.this$0.queue) {
                    while (this.this$0.queue.isEmpty()) {
                        try {
                            this.this$0.queue.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    runnable = (Runnable) this.this$0.queue.removeFirst();
                }
                try {
                    runnable.run();
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public /* synthetic */ PoolWorker(FaceQueue faceQueue, AnonymousClass1 anonymousClass1) {
            this(faceQueue);
        }
    }

    public FaceQueue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.queue = null;
        this.nThreads = i2;
        this.queue = new LinkedList();
        this.threads = new PoolWorker[i2];
        for (int i5 = 0; i5 < i2; i5++) {
            this.threads[i5] = new PoolWorker(this, null);
            this.threads[i5].start();
        }
    }

    public static FaceQueue getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? HolderClass.instance : (FaceQueue) invokeV.objValue;
    }

    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            synchronized (this.queue) {
                this.queue.addLast(runnable);
                this.queue.notify();
            }
        }
    }
}
