package androidx.lifecycle;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "coroutineScope", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class LifecycleKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lifecycle)) == null) {
            do {
                LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.mInternalScopeRef.get();
                if (lifecycleCoroutineScopeImpl2 != null) {
                    return lifecycleCoroutineScopeImpl2;
                }
                lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
            } while (!lifecycle.mInternalScopeRef.compareAndSet(null, lifecycleCoroutineScopeImpl));
            lifecycleCoroutineScopeImpl.register();
            return lifecycleCoroutineScopeImpl;
        }
        return (LifecycleCoroutineScope) invokeL.objValue;
    }
}
