package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public class ThreadUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final Object sLock;
    public static boolean sThreadAssertsDisabled;
    public static Handler sUiThreadHandler;
    public static boolean sWillOverride;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-380973706, "Laegon/chrome/base/ThreadUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-380973706, "Laegon/chrome/base/ThreadUtils;");
                return;
            }
        }
        sLock = new Object();
    }

    public ThreadUtils() {
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

    public static void assertOnUiThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            boolean z = sThreadAssertsDisabled;
        }
    }

    public static Handler getUiThreadHandler() {
        InterceptResult invokeV;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (sLock) {
                if (sUiThreadHandler == null) {
                    if (sWillOverride) {
                        throw new RuntimeException("Did not yet override the UI thread");
                    }
                    sUiThreadHandler = new Handler(Looper.getMainLooper());
                }
                handler = sUiThreadHandler;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    @CalledByNative
    public static boolean isThreadPriorityAudio(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65540, null, i2)) == null) ? Process.getThreadPriority(i2) == -16 : invokeI.booleanValue;
    }

    @Deprecated
    public static <T> T runOnUiThreadBlockingNoException(Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, callable)) == null) {
            try {
                FutureTask futureTask = new FutureTask(callable);
                if (runningOnUiThread()) {
                    futureTask.run();
                } else {
                    getUiThreadHandler().post(futureTask);
                }
                try {
                    return (T) futureTask.get();
                } catch (InterruptedException e2) {
                    throw new RuntimeException("Interrupted waiting for callable", e2);
                }
            } catch (ExecutionException e3) {
                throw new RuntimeException("Error occurred waiting for callable", e3);
            }
        }
        return (T) invokeL.objValue;
    }

    public static boolean runningOnUiThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? getUiThreadHandler().getLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            Process.setThreadPriority(i2, -16);
        }
    }
}
