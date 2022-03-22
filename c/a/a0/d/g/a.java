package c.a.a0.d.g;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.l.i;
import c.a.a0.q.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public static final List<c.a.a0.q.b> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(68817639, "Lc/a/a0/d/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(68817639, "Lc/a/a0/d/g/a;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new c.a.a0.d.b.c.a());
        a.add(new i());
        a.add(new c.a.a0.d.f.c());
        a.add(new c());
        d dVar = new d();
        c.a.g0.a.b.d<c.a.a0.q.b> dVar2 = dVar.a;
        if (dVar2 == null || c.a.a0.x.a.g(dVar2.getList())) {
            return;
        }
        a.addAll(dVar.a.getList());
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !a.isEmpty() : invokeV.booleanValue;
    }

    @Override // c.a.a0.q.e
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onActivityDestroyed(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onActivityPaused(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, activity) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onActivityResumed(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, activity, bundle) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, activity) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onActivityStarted(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, activity) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onActivityStopped(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onBackgroundToForeground(activity);
            }
        }
    }

    @Override // c.a.a0.q.e
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, activity) == null) && e()) {
            for (c.a.a0.q.b bVar : a) {
                bVar.onForegroundToBackground(activity);
            }
        }
    }
}
