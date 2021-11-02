package com.baidu.android.ext.manage;

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
/* loaded from: classes6.dex */
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

    public BasePopTask(@NonNull PopItem popItem, int i2, boolean z, boolean z2, boolean z3, @NonNull String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {popItem, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str, objArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mItem = popItem;
        this.isEnqueue = z;
        this.isEnforce = z2;
        this.isResumable = z3;
        setPriority(i2);
        setShowMethodAndParams(str, objArr);
    }

    public static int getHigherPriority(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? i2 < i3 ? i2 : i3 : invokeII.intValue;
    }

    public static int getLowerPriority(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? i2 > i3 ? i2 : i3 : invokeII.intValue;
    }

    public boolean execute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MutexPopManager.execPopTask(this) : invokeV.booleanValue;
    }

    public PopItem getItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mItem : (PopItem) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPriority : invokeV.intValue;
    }

    public boolean isEnforce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isEnforce : invokeV.booleanValue;
    }

    public boolean isEnqueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isEnqueue : invokeV.booleanValue;
    }

    public boolean isResumable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isResumable : invokeV.booleanValue;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        PopItem popItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (popItem = this.mItem) == null) {
            return;
        }
        popItem.mutexDismiss();
    }

    @Override // com.baidu.android.ext.manage.PopFinalCheck
    public boolean mutexFinalCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopFinalCheck popFinalCheck = this.mFinalCheck;
            return popFinalCheck == null || popFinalCheck.mutexFinalCheck();
        }
        return invokeV.booleanValue;
    }

    public boolean mutexShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? mutexShow(this.methodShowName, this.params) : invokeV.booleanValue;
    }

    public BasePopTask setEnforce(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.isEnforce = z;
            return this;
        }
        return (BasePopTask) invokeZ.objValue;
    }

    public BasePopTask setEnqueue(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            this.isEnqueue = z;
            return this;
        }
        return (BasePopTask) invokeZ.objValue;
    }

    public BasePopTask setFinalCheck(PopFinalCheck popFinalCheck) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, popFinalCheck)) == null) {
            this.mFinalCheck = popFinalCheck;
            return this;
        }
        return (BasePopTask) invokeL.objValue;
    }

    public BasePopTask setItem(PopItem popItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, popItem)) == null) {
            this.mItem = popItem;
            return this;
        }
        return (BasePopTask) invokeL.objValue;
    }

    public BasePopTask setPriority(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (i2 > 20) {
                i2 = 20;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            this.mPriority = i2;
            return this;
        }
        return (BasePopTask) invokeI.objValue;
    }

    public BasePopTask setResumable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.isResumable = z;
            return this;
        }
        return (BasePopTask) invokeZ.objValue;
    }

    public BasePopTask setShowMethodAndParams(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, objArr)) == null) {
            this.methodShowName = str;
            this.params = objArr;
            return this;
        }
        return (BasePopTask) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull BasePopTask basePopTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, basePopTask)) == null) ? this.mPriority - basePopTask.mPriority : invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r0 == false) goto L10;
     */
    @Override // com.baidu.android.ext.manage.PopItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mutexShow(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, objArr)) == null) {
            PopItem popItem = this.mItem;
            boolean z = false;
            if (popItem != null) {
                try {
                    try {
                        z = popItem.mutexShow(this.methodShowName, objArr);
                    } catch (ClassCastException e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                        return z;
                    }
                } finally {
                    boolean z2 = DEBUG;
                    MutexPopManager.doNextTask();
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr3 = newInitContext.callArgs;
                this((PopItem) objArr3[0], ((Integer) objArr3[1]).intValue(), ((Boolean) objArr3[2]).booleanValue(), ((Boolean) objArr3[3]).booleanValue(), ((Boolean) objArr3[4]).booleanValue(), (String) objArr3[5], (Object[]) objArr3[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
