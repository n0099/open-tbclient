package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ApplicationStatus {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Activity, Object> sActivityInfo;
    public static final ObserverList<ApplicationStateListener> sApplicationStateListeners;
    @SuppressLint({"SupportAnnotationUsage"})
    public static int sCurrentApplicationState;
    public static ApplicationStateListener sNativeApplicationStateListener;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface ApplicationStateListener {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1662041413, "Laegon/chrome/base/ApplicationStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1662041413, "Laegon/chrome/base/ApplicationStatus;");
                return;
            }
        }
        ApplicationStatus.class.desiredAssertionStatus();
        sActivityInfo = Collections.synchronizedMap(new HashMap());
        sCurrentApplicationState = 0;
        new ObserverList();
        sApplicationStateListeners = new ObserverList<>();
        new ObserverList();
    }

    public ApplicationStatus() {
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

    @AnyThread
    @CalledByNative
    public static int getStateForApplication() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (sActivityInfo) {
                i2 = sCurrentApplicationState;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public static native void nativeOnApplicationStateChange(int i2);

    @MainThread
    public static void registerApplicationStateListener(ApplicationStateListener applicationStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, applicationStateListener) == null) {
            sApplicationStateListeners.addObserver(applicationStateListener);
        }
    }

    @CalledByNative
    public static void registerThreadSafeNativeApplicationStateListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            Runnable runnable = new Runnable() { // from class: aegon.chrome.base.ApplicationStatus.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

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
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && ApplicationStatus.sNativeApplicationStateListener == null) {
                        ApplicationStateListener applicationStateListener = new ApplicationStateListener(this) { // from class: aegon.chrome.base.ApplicationStatus.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }
                        };
                        ApplicationStatus.sNativeApplicationStateListener = applicationStateListener;
                        ApplicationStatus.registerApplicationStateListener(applicationStateListener);
                    }
                }
            };
            if (ThreadUtils.runningOnUiThread()) {
                runnable.run();
            } else {
                ThreadUtils.getUiThreadHandler().post(runnable);
            }
        }
    }
}
