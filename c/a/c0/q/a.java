package c.a.c0.q;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static e a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static c a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eVar)) == null) {
            if (eVar instanceof c) {
                return (c) eVar;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public static void b(@NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, eVar) == null) {
            synchronized (e.class) {
                if (a != null) {
                    return;
                }
                a = eVar;
            }
        }
    }

    @Nullable
    public static Activity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.b();
        }
        return (Activity) invokeV.objValue;
    }
}
