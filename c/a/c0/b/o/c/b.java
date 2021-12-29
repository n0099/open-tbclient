package c.a.c0.b.o.c;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.n.d;
import c.a.c0.n.e;
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
public final class b implements d, c.a.c0.n.c, e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1834d;

    /* renamed from: e  reason: collision with root package name */
    public static b f1835e;
    public transient /* synthetic */ FieldHolder $fh;
    public final CopyOnWriteArrayList<d> a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<WeakReference<Activity>> f1836b;

    /* renamed from: c  reason: collision with root package name */
    public int f1837c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-846230098, "Lc/a/c0/b/o/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-846230098, "Lc/a/c0/b/o/c/b;");
        }
    }

    public b() {
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
        this.a = new CopyOnWriteArrayList<>();
        this.f1836b = new LinkedList<>();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f1835e == null) {
                synchronized (b.class) {
                    if (f1835e == null) {
                        f1835e = new b();
                    }
                }
            }
            return f1835e;
        }
        return (b) invokeV.objValue;
    }

    @Override // c.a.c0.n.c
    @Nullable
    public Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f1836b.isEmpty() || this.f1836b.size() < 2) {
                return null;
            }
            LinkedList<WeakReference<Activity>> linkedList = this.f1836b;
            return linkedList.get(linkedList.size() - 2).get();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // c.a.c0.n.c
    @Nullable
    public Activity b() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int size = this.f1836b.size();
            if (size < 2) {
                return d();
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                WeakReference<Activity> weakReference = this.f1836b.get(i2);
                if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public Activity d() {
        InterceptResult invokeV;
        WeakReference<Activity> last;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f1836b.isEmpty() || (last = this.f1836b.getLast()) == null) {
                return null;
            }
            return last.get();
        }
        return (Activity) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.size() > 0 : invokeV.booleanValue;
    }

    public void f(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || dVar == null || this.a.contains(dVar)) {
            return;
        }
        f1834d = true;
        this.a.add(dVar);
    }

    public void g(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null || this.a.contains(dVar)) {
            return;
        }
        if (f1834d && this.a.size() > 0) {
            CopyOnWriteArrayList<d> copyOnWriteArrayList = this.a;
            copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, dVar);
            return;
        }
        this.a.add(dVar);
    }

    @Override // c.a.c0.n.d
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, bundle) == null) {
            this.f1836b.add(new WeakReference<>(activity));
            if (e()) {
                Iterator<d> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityCreated(activity, bundle);
                }
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            if (e()) {
                Iterator<d> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityDestroyed(activity);
                }
            }
            if (this.f1836b.isEmpty()) {
                return;
            }
            int size = this.f1836b.size();
            while (true) {
                size--;
                if (size < 0) {
                    size = -1;
                    break;
                } else if (this.f1836b.get(size).get() == activity) {
                    break;
                }
            }
            if (size != -1) {
                this.f1836b.remove(size);
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && e()) {
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, activity) == null) && e()) {
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, activity, bundle) == null) && e()) {
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            if (e()) {
                Iterator<d> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStarted(activity);
                }
            }
            int i2 = this.f1837c + 1;
            this.f1837c = i2;
            if (i2 == 1) {
                onBackgroundToForeground(activity);
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            if (e()) {
                Iterator<d> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStopped(activity);
                }
            }
            int i2 = this.f1837c - 1;
            this.f1837c = i2;
            if (i2 == 0) {
                onForegroundToBackground(activity);
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, activity) == null) && e()) {
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundToForeground(activity);
            }
        }
    }

    @Override // c.a.c0.n.d
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, activity) == null) && e()) {
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onForegroundToBackground(activity);
            }
        }
    }
}
