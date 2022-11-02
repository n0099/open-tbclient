package com.baidu.searchbox.launch;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class SmartLaunchTask implements Runnable, Comparable<SmartLaunchTask> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int HIGH_PRIORITY = 3;
    public static final int LOWEST_PRIORITY = 0;
    public static final int LOW_PRIORITY = 1;
    public static final int NORM_PRIORITY = 2;
    public static final String TAG = "SmartLaunchTask";
    public transient /* synthetic */ FieldHolder $fh;
    public long endTime;
    public String id;
    public Boolean isExecuted;
    public boolean isMainThreadIdleTask;
    public List<SmartLaunchTask> mDependencyList;
    public String name;
    public int priority;
    public double score;
    public long startTime;
    public int type;

    public abstract void execute();

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(658446492, "Lcom/baidu/searchbox/launch/SmartLaunchTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(658446492, "Lcom/baidu/searchbox/launch/SmartLaunchTask;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public List<SmartLaunchTask> getDependency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDependencyList;
        }
        return (List) invokeV.objValue;
    }

    public long getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.endTime;
        }
        return invokeV.longValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.priority;
        }
        return invokeV.intValue;
    }

    public double getScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.score;
        }
        return invokeV.doubleValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.startTime;
        }
        return invokeV.longValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public boolean isExecuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isExecuted.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean isMainThreadIdleTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.isMainThreadIdleTask;
        }
        return invokeV.booleanValue;
    }

    public void removeAllDependency() {
        List<SmartLaunchTask> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (list = this.mDependencyList) != null) {
            list.clear();
        }
    }

    public SmartLaunchTask() {
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
        this.priority = 2;
        this.isExecuted = Boolean.FALSE;
        this.startTime = 0L;
        this.endTime = 0L;
        this.type = 0;
        this.score = -1.0d;
        this.isMainThreadIdleTask = false;
        this.mDependencyList = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartLaunchTask(String str) {
        this(str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull SmartLaunchTask smartLaunchTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, smartLaunchTask)) == null) {
            if (this.priority > smartLaunchTask.getPriority()) {
                return -1;
            }
            if (this.priority < smartLaunchTask.getPriority()) {
                return 1;
            }
            if (this.score > smartLaunchTask.getScore()) {
                return -1;
            }
            if (this.score < smartLaunchTask.getScore()) {
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public SmartLaunchTask(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.priority = 2;
        this.isExecuted = Boolean.FALSE;
        this.startTime = 0L;
        this.endTime = 0L;
        this.type = 0;
        this.score = -1.0d;
        this.isMainThreadIdleTask = false;
        this.mDependencyList = null;
        this.id = str;
        this.priority = i;
        this.isMainThreadIdleTask = z;
    }

    public SmartLaunchTask(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.priority = 2;
        this.isExecuted = Boolean.FALSE;
        this.startTime = 0L;
        this.endTime = 0L;
        this.type = 0;
        this.score = -1.0d;
        this.isMainThreadIdleTask = false;
        this.mDependencyList = null;
        this.id = str;
        this.name = str2;
    }

    public void addDependency(SmartLaunchTask smartLaunchTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, smartLaunchTask) == null) {
            if (this.mDependencyList == null) {
                this.mDependencyList = new ArrayList();
            }
            this.mDependencyList.add(smartLaunchTask);
        }
    }

    public void removeDependency(SmartLaunchTask smartLaunchTask) {
        List<SmartLaunchTask> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, smartLaunchTask) == null) && (list = this.mDependencyList) != null) {
            list.remove(smartLaunchTask);
        }
    }

    public void setPriority(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.priority = i;
        }
    }

    public void setScore(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Double.valueOf(d)}) == null) {
            this.score = d;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.type = i;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.startTime = System.currentTimeMillis();
            execute();
            this.isExecuted = Boolean.TRUE;
            this.endTime = System.currentTimeMillis();
            if (DEBUG) {
                Log.d(TAG, "task id: " + this.id + " name: " + this.name + " startTime: " + this.startTime + " endTime " + this.endTime + " duration: " + (this.endTime - this.startTime));
            }
        }
    }
}
