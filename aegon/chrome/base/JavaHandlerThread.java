package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
/* loaded from: classes.dex */
public class JavaHandlerThread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HandlerThread mThread;
    public Throwable mUnhandledException;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(658520875, "Laegon/chrome/base/JavaHandlerThread;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(658520875, "Laegon/chrome/base/JavaHandlerThread;");
                return;
            }
        }
        JavaHandlerThread.class.desiredAssertionStatus();
    }

    public JavaHandlerThread(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThread = new HandlerThread(str, i2);
    }

    @CalledByNative
    public static JavaHandlerThread create(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2)) == null) ? new JavaHandlerThread(str, i2) : (JavaHandlerThread) invokeLI.objValue;
    }

    @CalledByNative
    private Throwable getUncaughtExceptionIfAny() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.mUnhandledException : (Throwable) invokeV.objValue;
    }

    @CalledByNative
    private boolean isAlive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.mThread.isAlive() : invokeV.booleanValue;
    }

    @CalledByNative
    private void joinThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            boolean z = false;
            while (!z) {
                try {
                    this.mThread.join();
                    z = true;
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(this) { // from class: aegon.chrome.base.JavaHandlerThread.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JavaHandlerThread this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, thread, th) == null) {
                        this.this$0.mUnhandledException = th;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLooperStopped(long j);

    @CalledByNative
    private void quitThreadSafely(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, this, j) == null) {
            new Handler(this.mThread.getLooper()).post(new Runnable(this, j) { // from class: aegon.chrome.base.JavaHandlerThread.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JavaHandlerThread this$0;
                public final /* synthetic */ long val$nativeThread;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$nativeThread = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mThread.quit();
                        this.this$0.nativeOnLooperStopped(this.val$nativeThread);
                    }
                }
            });
            if (Build.VERSION.SDK_INT >= 18) {
                this.mThread.getLooper().quitSafely();
            }
        }
    }

    @CalledByNative
    private void startAndInitialize(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            maybeStart();
            new Handler(this.mThread.getLooper()).post(new Runnable(this, j, j2) { // from class: aegon.chrome.base.JavaHandlerThread.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JavaHandlerThread this$0;
                public final /* synthetic */ long val$nativeEvent;
                public final /* synthetic */ long val$nativeThread;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$nativeThread = j;
                    this.val$nativeEvent = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.nativeInitializeThread(this.val$nativeThread, this.val$nativeEvent);
                    }
                }
            });
        }
    }

    public void maybeStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mThread.getState() != Thread.State.NEW) {
                return;
            }
            this.mThread.start();
        }
    }
}
