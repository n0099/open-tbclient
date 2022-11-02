package com.baidu.sapi2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes2.dex */
public class ActivityStackManager implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Stack<Activity> stack;

    /* renamed from: com.baidu.sapi2.ActivityStackManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public static class Instance {
        public static /* synthetic */ Interceptable $ic;
        public static ActivityStackManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(471866536, "Lcom/baidu/sapi2/ActivityStackManager$Instance;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(471866536, "Lcom/baidu/sapi2/ActivityStackManager$Instance;");
                    return;
                }
            }
            INSTANCE = new ActivityStackManager(null);
        }

        public Instance() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public ActivityStackManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.stack = new Stack<>();
    }

    public static ActivityStackManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Instance.INSTANCE;
        }
        return (ActivityStackManager) invokeV.objValue;
    }

    public void finishAllActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            while (!this.stack.isEmpty()) {
                this.stack.pop().finish();
            }
        }
    }

    public Activity getTopActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.stack.isEmpty()) {
                return this.stack.lastElement();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public /* synthetic */ ActivityStackManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void addActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.stack.add(activity);
        }
    }

    public void finishActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.stack.pop().finish();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            removeActivity(activity);
        }
    }

    public void register(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, application) == null) {
            application.registerActivityLifecycleCallbacks(this);
        }
    }

    public boolean removeActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, activity)) == null) {
            return this.stack.remove(activity);
        }
        return invokeL.booleanValue;
    }

    public int searchActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, activity)) == null) {
            return this.stack.search(activity);
        }
        return invokeL.intValue;
    }

    public void unRegister(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, application) == null) {
            application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void finishActivityClass(Class<Activity> cls) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls) == null) && cls != null) {
            Iterator<Activity> it = this.stack.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next.getClass().equals(cls)) {
                    it.remove();
                    finishActivity(next);
                }
            }
        }
    }

    public Activity getPenultimateActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.stack.isEmpty() && this.stack.size() >= 2) {
                Stack<Activity> stack = this.stack;
                return stack.get(stack.size() - 2);
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public Activity getRealTopActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.stack.size();
            if (size < 2) {
                return getTopActivity();
            }
            for (int i = size - 1; i >= 0; i--) {
                Activity activity = this.stack.get(i);
                if (activity != null && !activity.isFinishing()) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, bundle) == null) {
            addActivity(activity);
        }
    }
}
