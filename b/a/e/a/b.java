package b.a.e.a;

import android.app.Activity;
import android.app.ActivityManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<SoftReference<Activity>> f1459c;

    /* renamed from: d  reason: collision with root package name */
    public static b f1460d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f1461a;

    /* renamed from: b  reason: collision with root package name */
    public int f1462b;

    /* loaded from: classes.dex */
    public interface a {
        void onActivityClosed();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1462b = 0;
        if (f1459c == null) {
            f1459c = new ArrayList<>(20);
        }
    }

    public static b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f1460d == null) {
                f1460d = new b();
            }
            return f1460d;
        }
        return (b) invokeV.objValue;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 0) {
            return;
        }
        int h2 = g().h();
        while (h2 > i2) {
            h2--;
            Activity l = g().l(1);
            if (l != null) {
                l.finish();
            }
        }
    }

    public Activity b() {
        InterceptResult invokeV;
        SoftReference<Activity> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int size = f1459c.size();
            if (size == 0 || (softReference = f1459c.get(size - 1)) == null) {
                return null;
            }
            return softReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    public Activity c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (f1459c.size() == 0) {
                return null;
            }
            Iterator<SoftReference<Activity>> it = f1459c.iterator();
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

    public String d() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<SoftReference<Activity>> arrayList = f1459c;
            if (arrayList != null && arrayList.size() != 0) {
                StringBuilder sb = new StringBuilder();
                Iterator<SoftReference<Activity>> it = f1459c.iterator();
                while (it.hasNext()) {
                    SoftReference<Activity> next = it.next();
                    if (next != null && (activity = next.get()) != null) {
                        String simpleName = (activity == null || activity.getClass() == null) ? "" : activity.getClass().getSimpleName();
                        if (!StringUtils.isNull(simpleName)) {
                            sb.append(simpleName + ";");
                        }
                    }
                }
                return sb.toString();
            }
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null) {
                            String str2 = runningTaskInfo.topActivity != null ? "top:" + runningTaskInfo.topActivity.getClassName() : "";
                            if (runningTaskInfo.baseActivity != null) {
                                str2 = str2 + "&base:" + runningTaskInfo.baseActivity.getClassName();
                            }
                            str = str2 + "&numbers:" + runningTaskInfo.numActivities;
                        } else {
                            str = "";
                        }
                        if (!StringUtils.isNull(str)) {
                            sb2.append(str + ";");
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

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1462b : invokeV.intValue;
    }

    public Activity f(int i2) {
        InterceptResult invokeI;
        SoftReference<Activity> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int size = f1459c.size();
            if (size != 0 && i2 >= 0 && i2 < size && (softReference = f1459c.get(i2)) != null) {
                return softReference.get();
            }
            return null;
        }
        return (Activity) invokeI.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f1459c.size() : invokeV.intValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (f1459c.size() == 0) {
                return false;
            }
            Iterator<SoftReference<Activity>> it = f1459c.iterator();
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

    public int j(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
            int size = f1459c.size();
            if (size <= 0 || activity == null) {
                return -1;
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                SoftReference<Activity> softReference = f1459c.get(i2);
                if (softReference == null) {
                    f1459c.remove(i2);
                } else if (activity.equals(softReference.get())) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public Activity k() {
        InterceptResult invokeV;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int size = f1459c.size();
            if (size == 0 || (remove = f1459c.remove(size - 1)) == null) {
                return null;
            }
            return remove.get();
        }
        return (Activity) invokeV.objValue;
    }

    public Activity l(int i2) {
        InterceptResult invokeI;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int size = f1459c.size();
            if (size != 0 && i2 >= 0 && i2 < size && (remove = f1459c.remove(i2)) != null) {
                return remove.get();
            }
            return null;
        }
        return (Activity) invokeI.objValue;
    }

    public void m(Activity activity) {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, activity) == null) || activity == null) {
            return;
        }
        int size = f1459c.size();
        if (size == 0) {
            a aVar3 = this.f1461a;
            if (aVar3 != null) {
                aVar3.onActivityClosed();
                return;
            }
            return;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            SoftReference<Activity> softReference = f1459c.get(i2);
            if (softReference == null) {
                f1459c.remove(i2);
            } else if (activity.equals(softReference.get())) {
                f1459c.remove(i2);
                if (f1459c.size() != 0 || (aVar = this.f1461a) == null) {
                    return;
                }
                aVar.onActivityClosed();
                return;
            } else if (f1459c.size() == 0 && (aVar2 = this.f1461a) != null) {
                aVar2.onActivityClosed();
            }
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                Activity k = k();
                if (k != null) {
                    k.finish();
                }
            }
        }
    }

    public void o(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, activity) == null) || activity == null) {
            return;
        }
        f1459c.add(new SoftReference<>(activity));
        a(this.f1462b);
    }

    public void p() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (f1459c != null) {
                while (!f1459c.isEmpty()) {
                    SoftReference<Activity> remove = f1459c.remove(0);
                    if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                        activity.finish();
                    }
                }
            }
            a aVar = this.f1461a;
            if (aVar != null) {
                aVar.onActivityClosed();
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            a(3);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 >= 10 || i2 == 0) {
                this.f1462b = i2;
            }
        }
    }

    public void s(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.f1461a = aVar;
        }
    }
}
