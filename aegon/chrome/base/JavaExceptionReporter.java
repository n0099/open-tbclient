package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
/* loaded from: classes.dex */
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mCrashAfterReport;
    public boolean mHandlingException;
    public final Thread.UncaughtExceptionHandler mParent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1277408177, "Laegon/chrome/base/JavaExceptionReporter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1277408177, "Laegon/chrome/base/JavaExceptionReporter;");
                return;
            }
        }
        JavaExceptionReporter.class.desiredAssertionStatus();
    }

    public JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uncaughtExceptionHandler, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mParent = uncaughtExceptionHandler;
        this.mCrashAfterReport = z;
    }

    @CalledByNative
    public static void installHandler(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z));
        }
    }

    public static native void nativeReportJavaException(boolean z, Throwable th);

    public static native void nativeReportJavaStackTrace(String str);

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, thread, th) == null) {
            if (!this.mHandlingException) {
                this.mHandlingException = true;
                nativeReportJavaException(this.mCrashAfterReport, th);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mParent;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
