package com.baidu.adp.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class BdActivityStack {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<SoftReference<Activity>> sActivityStack;
    public static BdActivityStack sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public a mActivityClosed;
    public boolean mActivityGreySwitch;
    public int mActivityStackMaxSize;

    /* loaded from: classes.dex */
    public interface a {
        void onActivityClosed();
    }

    public BdActivityStack() {
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
        this.mActivityStackMaxSize = 0;
        if (sActivityStack == null) {
            sActivityStack = new ArrayList<>(20);
        }
    }

    public static BdActivityStack getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new BdActivityStack();
            }
            return sInstance;
        }
        return (BdActivityStack) invokeV.objValue;
    }

    public Activity currentActivity() {
        InterceptResult invokeV;
        SoftReference<Activity> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int size = sActivityStack.size();
            if (size == 0 || (softReference = sActivityStack.get(size - 1)) == null) {
                return null;
            }
            return softReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    public ArrayList<SoftReference<Activity>> getActivityStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return sActivityStack;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return sActivityStack.size();
        }
        return invokeV.intValue;
    }

    public Activity popActivity() {
        InterceptResult invokeV;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int size = sActivityStack.size();
            if (size == 0 || (remove = sActivityStack.remove(size - 1)) == null) {
                return null;
            }
            return remove.get();
        }
        return (Activity) invokeV.objValue;
    }

    public void releaseAllPossibleAcitivities() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            checkAndMaintainActivityStack(3);
        }
    }

    private void checkAndMaintainActivityStack(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65537, this, i) != null) || i == 0) {
            return;
        }
        int size = getInst().getSize();
        while (size > i) {
            size--;
            Activity popActivity = getInst().popActivity(1);
            if (popActivity != null) {
                popActivity.finish();
            }
        }
    }

    public void popNumberActivtiy(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                Activity popActivity = popActivity();
                if (popActivity != null) {
                    popActivity.finish();
                }
            }
        }
    }

    public void setActivityStackMaxSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (i < 10 && i != 0) {
                return;
            }
            this.mActivityStackMaxSize = i;
        }
    }

    public void setOnActivityAllClosed(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.mActivityClosed = aVar;
        }
    }

    public Activity getActivityByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (sActivityStack.size() == 0) {
                return null;
            }
            Iterator<SoftReference<Activity>> it = sActivityStack.iterator();
            while (it.hasNext()) {
                SoftReference<Activity> next = it.next();
                if (next != null && next.get() != null && next.get().getClass().getSimpleName() != null && next.get().getClass().getSimpleName().equals(str)) {
                    return next.get();
                }
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    public boolean isActivityExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (sActivityStack.size() == 0) {
                return false;
            }
            Iterator<SoftReference<Activity>> it = sActivityStack.iterator();
            while (it.hasNext()) {
                SoftReference<Activity> next = it.next();
                if (next != null && next.get() != null && next.get().getClass().getSimpleName() != null && next.get().getClass().getSimpleName().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setActivityIsGrey(boolean z) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048591, this, z) != null) || !this.mActivityGreySwitch) {
            return;
        }
        this.mActivityGreySwitch = false;
        if (sActivityStack == null) {
            return;
        }
        for (int i = 0; i < sActivityStack.size(); i++) {
            SoftReference<Activity> softReference = sActivityStack.get(i);
            if (softReference != null && (activity = softReference.get()) != null && activity.getWindow() != null) {
                if (this.mActivityGreySwitch) {
                    x4.b(activity.getWindow().getDecorView());
                } else {
                    x4.a(activity.getWindow().getDecorView());
                }
            }
        }
    }

    public String getAllActivityName() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList<SoftReference<Activity>> arrayList2 = sActivityStack;
            if (arrayList2 != null && arrayList2.size() != 0) {
                Iterator<SoftReference<Activity>> it = sActivityStack.iterator();
                while (it.hasNext()) {
                    SoftReference<Activity> next = it.next();
                    if (next != null && (activity = next.get()) != null) {
                        arrayList.add(activity.getClass().getName());
                    }
                }
                return TextUtils.join("_", arrayList);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public Activity getIndexActivtiy(int i) {
        InterceptResult invokeI;
        SoftReference<Activity> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int size = sActivityStack.size();
            if (size == 0 || i < 0 || i >= size || (softReference = sActivityStack.get(i)) == null) {
                return null;
            }
            return softReference.get();
        }
        return (Activity) invokeI.objValue;
    }

    public int isExitAt(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
            int size = sActivityStack.size();
            if (size > 0 && activity != null) {
                for (int i = size - 1; i >= 0; i--) {
                    SoftReference<Activity> softReference = sActivityStack.get(i);
                    if (softReference == null) {
                        sActivityStack.remove(i);
                    } else if (activity.equals(softReference.get())) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public Activity popActivity(int i) {
        InterceptResult invokeI;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int size = sActivityStack.size();
            if (size == 0 || i < 0 || i >= size || (remove = sActivityStack.remove(i)) == null) {
                return null;
            }
            return remove.get();
        }
        return (Activity) invokeI.objValue;
    }

    public void pushActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, activity) == null) && activity != null) {
            sActivityStack.add(new SoftReference<>(activity));
            checkAndMaintainActivityStack(this.mActivityStackMaxSize);
            if (this.mActivityGreySwitch && activity.getWindow() != null) {
                x4.b(activity.getWindow().getDecorView());
            }
        }
    }

    public void popActivity(Activity activity) {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, activity) == null) && activity != null) {
            int size = sActivityStack.size();
            if (size == 0) {
                a aVar3 = this.mActivityClosed;
                if (aVar3 != null) {
                    aVar3.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = sActivityStack.get(i);
                if (softReference == null) {
                    sActivityStack.remove(i);
                } else if (activity.equals(softReference.get())) {
                    sActivityStack.remove(i);
                    if (sActivityStack.size() == 0 && (aVar = this.mActivityClosed) != null) {
                        aVar.onActivityClosed();
                        return;
                    }
                    return;
                } else if (sActivityStack.size() == 0 && (aVar2 = this.mActivityClosed) != null) {
                    aVar2.onActivityClosed();
                }
            }
        }
    }

    public void releaseAllAcitivities() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (sActivityStack != null) {
                while (!sActivityStack.isEmpty()) {
                    SoftReference<Activity> remove = sActivityStack.remove(0);
                    if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                        activity.finish();
                    }
                }
            }
            a aVar = this.mActivityClosed;
            if (aVar != null) {
                aVar.onActivityClosed();
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        String str2;
        Activity activity;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ArrayList<SoftReference<Activity>> arrayList = sActivityStack;
            if (arrayList != null && arrayList.size() != 0) {
                StringBuilder sb = new StringBuilder();
                Iterator<SoftReference<Activity>> it = sActivityStack.iterator();
                while (it.hasNext()) {
                    SoftReference<Activity> next = it.next();
                    if (next != null && (activity = next.get()) != null) {
                        if (activity.getClass() == null) {
                            str3 = "";
                        } else {
                            str3 = activity.getClass().getSimpleName();
                        }
                        if (!StringUtils.isNull(str3)) {
                            sb.append(str3 + ParamableElem.DIVIDE_PARAM);
                        }
                    }
                }
                return sb.toString();
            }
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo == null) {
                            str = "";
                        } else {
                            if (runningTaskInfo.topActivity == null) {
                                str2 = "";
                            } else {
                                str2 = "top:" + runningTaskInfo.topActivity.getClassName();
                            }
                            if (runningTaskInfo.baseActivity != null) {
                                str2 = str2 + "&base:" + runningTaskInfo.baseActivity.getClassName();
                            }
                            str = str2 + "&numbers:" + runningTaskInfo.numActivities;
                        }
                        if (!StringUtils.isNull(str)) {
                            sb2.append(str + ParamableElem.DIVIDE_PARAM);
                        }
                    }
                    return sb2.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
