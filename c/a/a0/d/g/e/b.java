package c.a.a0.d.g.e;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.q.d;
import c.a.a0.q.e;
import c.a.a0.q.f;
import c.a.a0.q.g;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes.dex */
public final class b implements e, d, f, g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1104d;

    /* renamed from: e  reason: collision with root package name */
    public static b f1105e;
    public transient /* synthetic */ FieldHolder $fh;
    public final CopyOnWriteArrayList<e> a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<WeakReference<Activity>> f1106b;

    /* renamed from: c  reason: collision with root package name */
    public int f1107c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1709352368, "Lc/a/a0/d/g/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1709352368, "Lc/a/a0/d/g/e/b;");
        }
    }

    public b() {
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
        this.a = new CopyOnWriteArrayList<>();
        this.f1106b = new LinkedList<>();
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f1105e == null) {
                synchronized (b.class) {
                    if (f1105e == null) {
                        f1105e = new b();
                    }
                }
            }
            return f1105e;
        }
        return (b) invokeV.objValue;
    }

    @Override // c.a.a0.q.d
    @Nullable
    public Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f1106b.isEmpty() || this.f1106b.size() < 2) {
                return null;
            }
            LinkedList<WeakReference<Activity>> linkedList = this.f1106b;
            return linkedList.get(linkedList.size() - 2).get();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // c.a.a0.q.g
    public void b(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null || this.a.contains(eVar)) {
            return;
        }
        if (f1104d && this.a.size() > 0) {
            CopyOnWriteArrayList<e> copyOnWriteArrayList = this.a;
            copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, eVar);
            return;
        }
        this.a.add(eVar);
    }

    @Override // c.a.a0.q.d
    @Nullable
    public Activity c() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int size = this.f1106b.size();
            if (size < 2) {
                return f();
            }
            for (int i = size - 1; i >= 0; i--) {
                WeakReference<Activity> weakReference = this.f1106b.get(i);
                if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // c.a.a0.q.g
    public void d(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) && eVar != null && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    @Nullable
    public Activity f() {
        InterceptResult invokeV;
        WeakReference<Activity> last;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f1106b.isEmpty() || (last = this.f1106b.getLast()) == null) {
                return null;
            }
            return last.get();
        }
        return (Activity) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.size() > 0 : invokeV.booleanValue;
    }

    public void h(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || eVar == null || this.a.contains(eVar)) {
            return;
        }
        f1104d = true;
        this.a.add(eVar);
    }

    @Override // c.a.a0.q.e
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, bundle) == null) {
            this.f1106b.add(new WeakReference<>(activity));
            if (g()) {
                Iterator<e> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityCreated(activity, bundle);
                }
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (g()) {
                Iterator<e> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityDestroyed(activity);
                }
            }
            if (this.f1106b.isEmpty()) {
                return;
            }
            int size = this.f1106b.size();
            while (true) {
                size--;
                if (size < 0) {
                    size = -1;
                    break;
                } else if (this.f1106b.get(size).get() == activity) {
                    break;
                }
            }
            if (size != -1) {
                this.f1106b.remove(size);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, activity) == null) && g()) {
            Iterator<e> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, activity) == null) && g()) {
            Iterator<e> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, activity, bundle) == null) && g()) {
            Iterator<e> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            if (g()) {
                Iterator<e> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStarted(activity);
                }
            }
            int i = this.f1107c + 1;
            this.f1107c = i;
            if (i == 1) {
                onBackgroundToForeground(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            if (g()) {
                Iterator<e> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStopped(activity);
                }
            }
            int i = this.f1107c - 1;
            this.f1107c = i;
            if (i == 0) {
                onForegroundToBackground(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, activity) == null) && g()) {
            Iterator<e> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundToForeground(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, activity) == null) && g()) {
            Iterator<e> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onForegroundToBackground(activity);
            }
        }
    }
}
