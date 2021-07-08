package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class ActivityRecreator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "ActivityRecreator";
    public static final Class<?> activityThreadClass;
    public static final Handler mainHandler;
    public static final Field mainThreadField;
    public static final Method performStopActivity2ParamsMethod;
    public static final Method performStopActivity3ParamsMethod;
    public static final Method requestRelaunchActivityMethod;
    public static final Field tokenField;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object currentlyRecreatingToken;
        public Activity mActivity;
        public boolean mDestroyed;
        public final int mRecreatingHashCode;
        public boolean mStarted;
        public boolean mStopQueued;

        public LifecycleCheckCallbacks(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            this.mActivity = activity;
            this.mRecreatingHashCode = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && this.mDestroyed && !this.mStopQueued && !this.mStarted && ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
                this.mStopQueued = true;
                this.currentlyRecreatingToken = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, activity) == null) && this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(234247573, "Landroidx/core/app/ActivityRecreator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(234247573, "Landroidx/core/app/ActivityRecreator;");
                return;
            }
        }
        mainHandler = new Handler(Looper.getMainLooper());
        activityThreadClass = getActivityThreadClass();
        mainThreadField = getMainThreadField();
        tokenField = getTokenField();
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(activityThreadClass);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(activityThreadClass);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(activityThreadClass);
    }

    public ActivityRecreator() {
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

    public static Class<?> getActivityThreadClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Class.forName("android.app.ActivityThread");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Class) invokeV.objValue;
    }

    public static Field getMainThreadField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mMainThread");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Field) invokeV.objValue;
    }

    public static Method getPerformStopActivity2Params(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            try {
                Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Method) invokeL.objValue;
    }

    public static Method getPerformStopActivity3Params(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            try {
                Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Method) invokeL.objValue;
    }

    public static Method getRequestRelaunchActivityMethod(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, cls)) == null) {
            if (needsRelaunchCall() && cls != null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static Field getTokenField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mToken");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Field) invokeV.objValue;
    }

    public static boolean needsRelaunchCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            return i2 == 26 || i2 == 27;
        }
        return invokeV.booleanValue;
    }

    public static boolean queueOnStopIfNecessary(Object obj, int i2, Activity activity) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, obj, i2, activity)) == null) {
            try {
                Object obj2 = tokenField.get(activity);
                if (obj2 == obj && activity.hashCode() == i2) {
                    mainHandler.postAtFrontOfQueue(new Runnable(mainThreadField.get(activity), obj2) { // from class: androidx.core.app.ActivityRecreator.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Object val$activityThread;
                        public final /* synthetic */ Object val$token;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {r6, obj2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$activityThread = r6;
                            this.val$token = obj2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    if (ActivityRecreator.performStopActivity3ParamsMethod != null) {
                                        ActivityRecreator.performStopActivity3ParamsMethod.invoke(this.val$activityThread, this.val$token, Boolean.FALSE, "AppCompat recreation");
                                    } else {
                                        ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, Boolean.FALSE);
                                    }
                                } catch (RuntimeException e2) {
                                    if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                                        throw e2;
                                    }
                                } catch (Throwable th) {
                                    Log.e(ActivityRecreator.LOG_TAG, "Exception while invoking performStopActivity", th);
                                }
                            }
                        }
                    });
                    return true;
                }
                return false;
            } catch (Throwable th) {
                Log.e(LOG_TAG, "Exception while fetching field values", th);
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static boolean recreate(@NonNull Activity activity) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                activity.recreate();
                return true;
            } else if (needsRelaunchCall() && requestRelaunchActivityMethod == null) {
                return false;
            } else {
                if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
                    return false;
                }
                try {
                    Object obj2 = tokenField.get(activity);
                    if (obj2 == null || (obj = mainThreadField.get(activity)) == null) {
                        return false;
                    }
                    Application application = activity.getApplication();
                    LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                    application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                    mainHandler.post(new Runnable(lifecycleCheckCallbacks, obj2) { // from class: androidx.core.app.ActivityRecreator.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LifecycleCheckCallbacks val$callbacks;
                        public final /* synthetic */ Object val$token;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {lifecycleCheckCallbacks, obj2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$callbacks = lifecycleCheckCallbacks;
                            this.val$token = obj2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$callbacks.currentlyRecreatingToken = this.val$token;
                            }
                        }
                    });
                    if (needsRelaunchCall()) {
                        requestRelaunchActivityMethod.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                    } else {
                        activity.recreate();
                    }
                    mainHandler.post(new Runnable(application, lifecycleCheckCallbacks) { // from class: androidx.core.app.ActivityRecreator.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Application val$application;
                        public final /* synthetic */ LifecycleCheckCallbacks val$callbacks;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {application, lifecycleCheckCallbacks};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$application = application;
                            this.val$callbacks = lifecycleCheckCallbacks;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
                            }
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }
}
