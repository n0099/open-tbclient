package com.baidu.android.ext.manage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BasePopTask implements PopItem, Comparable<BasePopTask>, PopFinalCheck {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final int MAX_PRIORITY = 0;
    public static final int MIN_PRIORITY = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isEnforce;
    public boolean isEnqueue;
    public boolean isResumable;
    public PopFinalCheck mFinalCheck;
    public PopItem mItem;
    public int mPriority;
    public String methodShowName;
    public Object[] params;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1503282012, "Lcom/baidu/android/ext/manage/BasePopTask;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1503282012, "Lcom/baidu/android/ext/manage/BasePopTask;");
        }
    }

    public static int getHigherPriority(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) ? i < i2 ? i : i2 : invokeII.intValue;
    }

    public static int getLowerPriority(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) ? i > i2 ? i : i2 : invokeII.intValue;
    }

    public BasePopTask(@NonNull PopItem popItem, int i, boolean z, boolean z2, boolean z3, @NonNull String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {popItem, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str, objArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mItem = popItem;
        this.isEnqueue = z;
        this.isEnforce = z2;
        this.isResumable = z3;
        setPriority(i);
        setShowMethodAndParams(str, objArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePopTask(@NonNull PopItem popItem, @NonNull String str, Object... objArr) {
        this(popItem, 20, true, false, false, str, objArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {popItem, str, objArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr3 = newInitContext.callArgs;
                this((PopItem) objArr3[0], ((Integer) objArr3[1]).intValue(), ((Boolean) objArr3[2]).booleanValue(), ((Boolean) objArr3[3]).booleanValue(), ((Boolean) objArr3[4]).booleanValue(), (String) objArr3[5], (Object[]) objArr3[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public boolean cancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return MutexPopManager.removeTask(this);
        }
        return invokeV.booleanValue;
    }

    public boolean execute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return MutexPopManager.execPopTask(this);
        }
        return invokeV.booleanValue;
    }

    public PopItem getItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mItem;
        }
        return (PopItem) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPriority;
        }
        return invokeV.intValue;
    }

    public boolean isEnforce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.isEnforce;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnqueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.isEnqueue;
        }
        return invokeV.booleanValue;
    }

    public boolean isResumable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isResumable;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        PopItem popItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (popItem = this.mItem) != null) {
            popItem.mutexDismiss();
        }
    }

    @Override // com.baidu.android.ext.manage.PopFinalCheck
    public boolean mutexFinalCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PopFinalCheck popFinalCheck = this.mFinalCheck;
            if (popFinalCheck != null && !popFinalCheck.mutexFinalCheck()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean mutexShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return mutexShow(this.methodShowName, this.params);
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull BasePopTask basePopTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, basePopTask)) == null) {
            return this.mPriority - basePopTask.mPriority;
        }
        return invokeL.intValue;
    }

    public BasePopTask setEnforce(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            this.isEnforce = z;
            return this;
        }
        return (BasePopTask) invokeZ.objValue;
    }

    public BasePopTask setEnqueue(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.isEnqueue = z;
            return this;
        }
        return (BasePopTask) invokeZ.objValue;
    }

    public BasePopTask setFinalCheck(PopFinalCheck popFinalCheck) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, popFinalCheck)) == null) {
            this.mFinalCheck = popFinalCheck;
            return this;
        }
        return (BasePopTask) invokeL.objValue;
    }

    public BasePopTask setItem(PopItem popItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, popItem)) == null) {
            this.mItem = popItem;
            return this;
        }
        return (BasePopTask) invokeL.objValue;
    }

    public BasePopTask setPriority(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (i > 20) {
                i = 20;
            }
            if (i < 0) {
                i = 0;
            }
            this.mPriority = i;
            return this;
        }
        return (BasePopTask) invokeI.objValue;
    }

    public BasePopTask setResumable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.isResumable = z;
            return this;
        }
        return (BasePopTask) invokeZ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        if (com.baidu.android.ext.manage.BasePopTask.DEBUG == false) goto L13;
     */
    @Override // com.baidu.android.ext.manage.PopItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mutexShow(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, objArr)) == null) {
            PopItem popItem = this.mItem;
            boolean z = false;
            if (popItem != null) {
                try {
                    try {
                        z = popItem.mutexShow(this.methodShowName, objArr);
                        if (!z) {
                        }
                    } catch (ClassCastException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    if (DEBUG) {
                        Log.v(MutexPopManager.TAG, "互斥任务未传入任何参数，将直接进行下一波任务！");
                    }
                    MutexPopManager.doNextTask();
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public BasePopTask setShowMethodAndParams(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, objArr)) == null) {
            this.methodShowName = str;
            this.params = objArr;
            return this;
        }
        return (BasePopTask) invokeLL.objValue;
    }
}
