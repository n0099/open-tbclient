package c.a.p0.a.v2;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.f1.e.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanRelayActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.model.SwanTaskDeadEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9304f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f9305g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f9306h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public ActivityManager f9307a;

    /* renamed from: b  reason: collision with root package name */
    public List<ActivityManager.AppTask> f9308b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f9309c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f9310d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<SwanTaskDeadEvent> f9311e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f9312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f9313f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f9314g;

        public a(c cVar, b.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9314g = cVar;
            this.f9312e = aVar;
            this.f9313f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9314g.i();
                b.a aVar = this.f9312e;
                if (aVar != null && "1202000800000000".equals(aVar.T())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) this.f9312e.m("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        this.f9314g.f9309c = swanTaskDeadEvent.getStackList();
                        SparseArray<SwanTaskDeadEvent> historyCache = swanTaskDeadEvent.getHistoryCache();
                        if (historyCache != null) {
                            for (int i2 = 0; i2 < historyCache.size(); i2++) {
                                int keyAt = historyCache.keyAt(i2);
                                SwanTaskDeadEvent valueAt = historyCache.valueAt(i2);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    this.f9314g.f9311e.put(keyAt, valueAt);
                                    this.f9314g.f9310d.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                            }
                        }
                        this.f9314g.h(null, swanTaskDeadEvent.getTaskId(), this.f9313f);
                    }
                    if (c.f9304f) {
                        String str = "stack back: " + this.f9314g.f9309c;
                        return;
                    }
                    return;
                }
                b.a aVar2 = this.f9312e;
                if (aVar2 != null) {
                    this.f9314g.h(aVar2.H(), -1, this.f9313f);
                }
                c cVar = this.f9314g;
                cVar.f9309c = cVar.o();
                if (c.f9304f) {
                    String str2 = "getLaunchTask=" + this.f9314g.f9309c;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(831995924, "Lc/a/p0/a/v2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(831995924, "Lc/a/p0/a/v2/c;");
                return;
            }
        }
        f9304f = c.a.p0.a.k.f7085a;
        f9305g = d.f();
    }

    public c() {
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
        this.f9310d = new SparseIntArray();
        this.f9311e = new SparseArray<>();
        Application b2 = c.a.p0.a.c1.a.b();
        if (b2 != null) {
            this.f9307a = (ActivityManager) b2.getSystemService("activity");
        }
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static c m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f9306h == null) {
                synchronized (c.class) {
                    if (f9306h == null) {
                        f9306h = new c();
                    }
                }
            }
            return f9306h;
        }
        return (c) invokeV.objValue;
    }

    public static void q(@NonNull Message message) {
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, message) == null) && j()) {
            c m = m();
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent == null || TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    return;
                }
                if (ProcessUtils.isMainProcess() || ((arrayList = m.f9309c) != null && arrayList.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                    m.f9310d.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                    m.f9311e.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                }
            }
        }
    }

    public static void r(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, message) == null) && j()) {
            m().A((Bundle) message.obj);
        }
    }

    public final void A(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || bundle == null || this.f9309c == null) {
            return;
        }
        String string = bundle.getString("app_id");
        int i2 = bundle.getInt("key_task_id", -1);
        if (!TextUtils.isEmpty(string)) {
            int i3 = this.f9310d.get(string.hashCode(), -1);
            if (i3 > -1) {
                this.f9309c.remove(Integer.valueOf(i3));
                this.f9310d.delete(string.hashCode());
                this.f9311e.remove(i3);
                if (f9304f) {
                    String str = "removeTaskFromCache: " + string + ", oldTask=" + i3;
                }
            }
            this.f9309c.remove(Integer.valueOf(i2));
            return;
        }
        int i4 = bundle.getInt("key_task_id_old", -1);
        if (i4 == -1) {
            this.f9309c.remove(Integer.valueOf(i2));
        } else {
            int i5 = 0;
            while (true) {
                if (i5 >= this.f9309c.size()) {
                    break;
                } else if (this.f9309c.get(i5).intValue() == i4) {
                    this.f9309c.set(i5, Integer.valueOf(i2));
                    break;
                } else {
                    i5++;
                }
            }
            SwanTaskDeadEvent swanTaskDeadEvent = this.f9311e.get(i4);
            if (swanTaskDeadEvent != null) {
                if (swanTaskDeadEvent.getAppId() != null) {
                    this.f9310d.delete(swanTaskDeadEvent.getAppId().hashCode());
                }
                this.f9311e.remove(i4);
            }
        }
        if (f9304f) {
            String str2 = "removeTaskFromCache nowTask=" + i2 + ", old=" + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f9309c;
        }
    }

    public final void h(@Nullable String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, i3) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_task_id", i3);
            bundle.putInt("key_task_id_old", i2);
            bundle.putString("app_id", str);
            c.a.p0.a.v1.c.a e2 = c.a.p0.a.v1.c.a.e();
            c.a.p0.a.v1.c.c cVar = new c.a.p0.a.v1.c.c(123, bundle);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f9311e.clear();
            this.f9310d.clear();
        }
    }

    public boolean l(int i2) {
        InterceptResult invokeI;
        ActivityManager activityManager;
        List<ActivityManager.AppTask> appTasks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (j() && f9305g && (activityManager = this.f9307a) != null && (appTasks = activityManager.getAppTasks()) != null) {
                int i3 = 0;
                for (ActivityManager.AppTask appTask : appTasks) {
                    if (i3 > 0 && n(appTask) == i2) {
                        appTask.finishAndRemoveTask();
                        return true;
                    }
                    i3++;
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @RequiresApi(api = 21)
    public final int n(ActivityManager.AppTask appTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, appTask)) == null) {
            if (appTask != null) {
                try {
                    ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                    if (taskInfo != null) {
                        return taskInfo.id;
                    }
                    return -1;
                } catch (Exception unused) {
                    boolean z = f9304f;
                    return -1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Nullable
    public final ArrayList<Integer> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<Integer> arrayList = null;
            if (f9305g) {
                ActivityManager activityManager = this.f9307a;
                if (activityManager != null) {
                    List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                    int size = appTasks.size();
                    if (size < 2) {
                        return null;
                    }
                    arrayList = new ArrayList<>(size - 1);
                    for (int i2 = 1; i2 < size; i2++) {
                        int n = n(appTasks.get(i2));
                        if (n != -1) {
                            arrayList.add(Integer.valueOf(n));
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f9305g && (activityManager = this.f9307a) != null) {
                try {
                    return n(activityManager.getAppTasks().get(0));
                } catch (Exception unused) {
                    boolean z = f9304f;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean s(int i2, boolean z) {
        InterceptResult invokeCommon;
        ActivityManager activityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (f9305g) {
                List<ActivityManager.AppTask> list = this.f9308b;
                if ((!z || list == null) && (activityManager = this.f9307a) != null) {
                    list = activityManager.getAppTasks();
                    if (z) {
                        this.f9308b = list;
                    }
                }
                if (list != null) {
                    for (ActivityManager.AppTask appTask : list) {
                        if (i2 == n(appTask)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean t(List<Integer> list, List<Integer> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2)) == null) {
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (!TextUtils.equals(String.valueOf(list.get(i2)), String.valueOf(list2.get(i2)))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @AnyThread
    public synchronized boolean u(int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (i2 > -1) {
                    if (this.f9307a != null) {
                        if (s(i2, z)) {
                            if (f9304f) {
                                String str = "moveTaskToFront:" + i2;
                            }
                            try {
                                this.f9307a.moveTaskToFront(i2, 2, null);
                                return true;
                            } catch (Exception e2) {
                                c.a.p0.a.e0.d.c("SwanActivityTaskManager", "moveTaskToFront", e2);
                            }
                        } else if (this.f9311e.indexOfKey(i2) >= 0) {
                            SwanTaskDeadEvent swanTaskDeadEvent = this.f9311e.get(i2);
                            if (swanTaskDeadEvent != null) {
                                c.a aVar = (c.a) ((c.a) ((c.a) new c.a().u0(swanTaskDeadEvent.getAppId())).Q0(swanTaskDeadEvent.getPageScheme())).H0("1202000800000000");
                                Bundle bundle = new Bundle();
                                ArrayList<Integer> stackList = swanTaskDeadEvent.getStackList();
                                if (stackList != null && !stackList.isEmpty()) {
                                    SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                    Iterator<Integer> it = stackList.iterator();
                                    while (it.hasNext()) {
                                        Integer next = it.next();
                                        SwanTaskDeadEvent swanTaskDeadEvent2 = this.f9311e.get(next.intValue(), null);
                                        if (swanTaskDeadEvent2 != null) {
                                            sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                        }
                                    }
                                    swanTaskDeadEvent.setHistoryCache(sparseArray);
                                }
                                bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                                SwanLauncher.j().n(aVar, bundle);
                                if (f9304f) {
                                    String str2 = "launch dead app:" + swanTaskDeadEvent.getAppId();
                                }
                                return true;
                            }
                        } else if (f9304f) {
                            String str3 = "Not Found taskId:" + i2 + " cacheSize:" + this.f9311e.size();
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public synchronized boolean v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            synchronized (this) {
                ArrayList<Integer> arrayList = this.f9309c;
                if (z) {
                    arrayList = o();
                }
                if (arrayList != null && !arrayList.isEmpty() && this.f9307a != null) {
                    this.f9308b = null;
                    Iterator<Integer> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (u(it.next().intValue(), true, true)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean w(@NonNull Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            try {
                Intent intent = new Intent(context, SwanRelayActivity.class);
                intent.putExtra("key_task_id", i2);
                intent.setFlags(268435456);
                PendingIntent.getActivity(context, 0, intent, 134217728).send();
                return true;
            } catch (Exception unused) {
                boolean z2 = f9304f;
                return u(i2, z, false);
            }
        }
        return invokeCommon.booleanValue;
    }

    public void x(@Nullable SwanAppActivity swanAppActivity) {
        c.a.p0.a.h0.g.g swanAppFragmentManager;
        c.a.p0.a.h0.g.f fVar;
        c.a.p0.a.l1.c I1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, swanAppActivity) == null) || !j() || swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (fVar = (c.a.p0.a.h0.g.f) swanAppFragmentManager.n(c.a.p0.a.h0.g.f.class)) == null || (I1 = fVar.I1()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.getActivedAppId(), swanAppActivity.getTaskId(), I1.g() + "?" + I1.h(), this.f9309c));
        bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
        c.a.p0.a.v1.c.a e2 = c.a.p0.a.v1.c.a.e();
        c.a.p0.a.v1.c.c cVar = new c.a.p0.a.v1.c.c(124, bundle);
        cVar.f(true);
        e2.h(cVar);
        if (f9304f) {
            String str = "notify dead " + swanAppActivity.getActivedAppId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + swanAppActivity.getTaskId();
        }
    }

    public void y(@Nullable b.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i2) == null) {
            q.k(new a(this, aVar, i2), "getLaunchTask");
        }
    }

    public void z(@Nullable Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, intent, i2) == null) {
            ArrayList<Integer> o = o();
            if (!t(this.f9309c, o)) {
                i();
                h(null, -1, i2);
            }
            if (f9304f) {
                String str = "onNewIntent: " + i2 + ", newTaskList=" + o + ", mLaunchTaskList=" + this.f9309c + ", flag=" + (intent != null ? intent.getFlags() : -1);
            }
            this.f9309c = o;
        }
    }
}
