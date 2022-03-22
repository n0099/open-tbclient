package com.baidu.searchbox.appframework;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class BdBoxActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BdBoxActivityLifecycle";
    public static boolean hasGlobalLifecycle;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivityCount;
    public LinkedList<WeakReference<Activity>> mActivityStack;
    public CopyOnWriteArrayList<IActivityLifecycle> mCustomActivityLifeCycles;
    public boolean mIsForeground;

    /* loaded from: classes4.dex */
    public static class BackForegroundEvent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isForeground;

        public BackForegroundEvent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isForeground = z;
        }
    }

    /* loaded from: classes4.dex */
    public interface IActivityLifecycle {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);

        void onBackgroundToForeground(Activity activity);

        void onForegroundToBackground(Activity activity);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-545421487, "Lcom/baidu/searchbox/appframework/BdBoxActivityLifecycle;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-545421487, "Lcom/baidu/searchbox/appframework/BdBoxActivityLifecycle;");
        }
    }

    public BdBoxActivityLifecycle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActivityStack = new LinkedList<>();
        this.mIsForeground = false;
        this.mCustomActivityLifeCycles = new CopyOnWriteArrayList<>();
    }

    private String dump() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            LinkedList<WeakReference<Activity>> linkedList = this.mActivityStack;
            if (linkedList == null || linkedList.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (int size = this.mActivityStack.size() - 1; size >= 0; size--) {
                Activity activity = this.mActivityStack.get(size).get();
                if (activity != null) {
                    String simpleName = activity.getClass().getSimpleName();
                    sb.append(size + 1);
                    sb.append(": ");
                    sb.append(simpleName);
                    sb.append(" ");
                }
            }
            sb.append("], this = ");
            sb.append(this);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void finishAllActivity() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mActivityStack.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.mActivityStack.size(); i++) {
            WeakReference<Activity> weakReference = this.mActivityStack.get(i);
            if (weakReference != null && (activity = weakReference.get()) != null) {
                activity.finish();
            }
        }
    }

    public int getActivityCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedList<WeakReference<Activity>> linkedList = this.mActivityStack;
            if (linkedList == null || linkedList.isEmpty()) {
                return 0;
            }
            return this.mActivityStack.size();
        }
        return invokeV.intValue;
    }

    public LinkedList<WeakReference<Activity>> getActivityStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mActivityStack : (LinkedList) invokeV.objValue;
    }

    public Activity getPenultimateActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mActivityStack.isEmpty() || this.mActivityStack.size() < 2) {
                return null;
            }
            LinkedList<WeakReference<Activity>> linkedList = this.mActivityStack;
            return linkedList.get(linkedList.size() - 2).get();
        }
        return (Activity) invokeV.objValue;
    }

    public Activity getRealTopActivity() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int size = this.mActivityStack.size();
            if (size < 2) {
                return getTopActivity();
            }
            for (int i = size - 1; i >= 0; i--) {
                WeakReference<Activity> weakReference = this.mActivityStack.get(i);
                if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public Activity getSpecifiedActivity(Class cls) {
        InterceptResult invokeL;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            if (cls == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList(this.mActivityStack);
            for (int i = 0; i < linkedList.size(); i++) {
                WeakReference weakReference = (WeakReference) linkedList.get(i);
                if (weakReference != null && (activity = (Activity) weakReference.get()) != null && cls.getSimpleName().equals(activity.getClass().getSimpleName())) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    public Activity getTopActivity() {
        InterceptResult invokeV;
        WeakReference<Activity> last;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mActivityStack.isEmpty() || (last = this.mActivityStack.getLast()) == null) {
                return null;
            }
            return last.get();
        }
        return (Activity) invokeV.objValue;
    }

    public boolean isActivityInStack(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) ? getSpecifiedActivity(cls) != null : invokeL.booleanValue;
    }

    public boolean isForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsForeground : invokeV.booleanValue;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, activity, bundle) == null) {
            this.mActivityStack.add(new WeakReference<>(activity));
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
            if (!this.mActivityStack.isEmpty()) {
                int size = this.mActivityStack.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        size = -1;
                        break;
                    }
                    Activity activity2 = this.mActivityStack.get(size).get();
                    if (activity2 != null && activity2 == activity) {
                        break;
                    }
                }
                if (size != -1) {
                    this.mActivityStack.remove(size);
                }
            }
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, activity) == null) || (copyOnWriteArrayList = this.mCustomActivityLifeCycles) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
        while (it.hasNext()) {
            it.next().onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, activity) == null) || (copyOnWriteArrayList = this.mCustomActivityLifeCycles) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
        while (it.hasNext()) {
            it.next().onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, activity, bundle) == null) || (copyOnWriteArrayList = this.mCustomActivityLifeCycles) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
        while (it.hasNext()) {
            it.next().onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStarted(activity);
                }
            }
            int i = this.mActivityCount + 1;
            this.mActivityCount = i;
            if (i == 1) {
                onBackgroundToForeground(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStopped(activity);
                }
            }
            int i = this.mActivityCount - 1;
            this.mActivityCount = i;
            if (i == 0) {
                onForegroundToBackground(activity);
            }
        }
    }

    public void onBackgroundToForeground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            this.mIsForeground = true;
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundToForeground(activity);
            }
        }
    }

    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            this.mIsForeground = false;
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onForegroundToBackground(activity);
            }
        }
    }

    public void registerGlobalLifeCycle(IActivityLifecycle iActivityLifecycle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, iActivityLifecycle) == null) || iActivityLifecycle == null || this.mCustomActivityLifeCycles.contains(iActivityLifecycle)) {
            return;
        }
        hasGlobalLifecycle = true;
        this.mCustomActivityLifeCycles.add(iActivityLifecycle);
    }

    public void registerLifeCycle(IActivityLifecycle iActivityLifecycle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, iActivityLifecycle) == null) || iActivityLifecycle == null || this.mCustomActivityLifeCycles.contains(iActivityLifecycle)) {
            return;
        }
        if (hasGlobalLifecycle && this.mCustomActivityLifeCycles.size() > 0) {
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
            copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, iActivityLifecycle);
            return;
        }
        this.mCustomActivityLifeCycles.add(iActivityLifecycle);
    }

    public void unregisterLifeCycle(IActivityLifecycle iActivityLifecycle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, iActivityLifecycle) == null) || iActivityLifecycle == null) {
            return;
        }
        this.mCustomActivityLifeCycles.remove(iActivityLifecycle);
    }
}
