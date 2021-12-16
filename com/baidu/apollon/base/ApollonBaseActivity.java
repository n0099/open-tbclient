package com.baidu.apollon.base;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class ApollonBaseActivity extends Activity implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "ApollonBaseActivity";
    public static LinkedList<ApollonBaseActivity> mActivityStack;
    public static int mLiveActivityNum;
    public transient /* synthetic */ FieldHolder $fh;
    public int mFlag;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-989282628, "Lcom/baidu/apollon/base/ApollonBaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-989282628, "Lcom/baidu/apollon/base/ApollonBaseActivity;");
                return;
            }
        }
        mActivityStack = new LinkedList<>();
        mLiveActivityNum = 0;
    }

    public ApollonBaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFlag = -1;
    }

    public static void addLiveActivityNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            mLiveActivityNum++;
        }
    }

    public static synchronized void addToTask(ApollonBaseActivity apollonBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, apollonBaseActivity) == null) {
            synchronized (ApollonBaseActivity.class) {
                mActivityStack.remove(apollonBaseActivity);
                mActivityStack.add(apollonBaseActivity);
            }
        }
    }

    public static synchronized void clearTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (ApollonBaseActivity.class) {
                Iterator<ApollonBaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    it.next().finish();
                }
            }
        }
    }

    public static synchronized void clearTaskExcept(ApollonBaseActivity apollonBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, apollonBaseActivity) == null) {
            synchronized (ApollonBaseActivity.class) {
                Iterator<ApollonBaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    ApollonBaseActivity next = it.next();
                    if (next != apollonBaseActivity) {
                        next.finish();
                    }
                }
            }
        }
    }

    public static synchronized void clearTasksTopOf(ApollonBaseActivity apollonBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, apollonBaseActivity) == null) {
            synchronized (ApollonBaseActivity.class) {
                LogUtil.d(a, "clearTasksTopOf. stack size = " + mActivityStack.size());
                for (int size = mActivityStack.size() + (-1); size > 0; size--) {
                    ApollonBaseActivity apollonBaseActivity2 = mActivityStack.get(size);
                    if (apollonBaseActivity2 == apollonBaseActivity) {
                        break;
                    }
                    apollonBaseActivity2.finish();
                }
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            synchronized (ApollonBaseActivity.class) {
                LogUtil.d(a, "clearTasksWithFlag. stack size = " + mActivityStack.size());
                Iterator<ApollonBaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    ApollonBaseActivity next = it.next();
                    if (next.mFlag == i2) {
                        next.finish();
                        next.overridePendingTransition(0, 0);
                    }
                }
            }
        }
    }

    public static void decLiveActivityNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            mLiveActivityNum--;
        }
    }

    public static ApollonBaseActivity getTopActivity() throws Throwable {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? mActivityStack.getLast() : (ApollonBaseActivity) invokeV.objValue;
    }

    public static boolean isAppInForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? mLiveActivityNum > 0 : invokeV.booleanValue;
    }

    public static synchronized void removeFromTask(ApollonBaseActivity apollonBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, apollonBaseActivity) == null) {
            synchronized (ApollonBaseActivity.class) {
                mActivityStack.remove(apollonBaseActivity);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            addToTask(this);
            com.baidu.mytransformapp.util.LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            removeFromTask(this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            decLiveActivityNum();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            addLiveActivityNum();
        }
    }
}
